package server.handler;

import business.entity.Session;
import business.select.SelectMain;
import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.GameServer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理服务端 channel
 * 继承ChannelInboundHandlerAdapter，获得事件处理接口
 */
@ChannelHandler.Sharable
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(DiscardServerHandler.class);

    //该方法在连接被注册进连接池（EventLoop）后调用
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        logger.trace("新连接尝试注册中");
        //发送你好信息
        //todo 实现握手协议
        ctx.writeAndFlush("hello");
        //创建session
        Session session = new Session();
        session.init();
        session.setChannel(ctx.channel());
        GameServer.getInstance().getSessionManager().addSession(session);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("连接激活，传送欢迎信息");
        String welcome = "welcome kevi's NettyServer \n";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        welcome += "time:"+format.format(new Date());
        ctx.writeAndFlush(welcome);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    //该方法会在收到消息时被调用
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //展示并丢弃接收到的数据
        String in_str = (String) msg;
        try {
            //在这里处理数据
            if (!StringUtil.isNullOrEmpty(in_str)){
                //Todo 直接按byte数组接受收数据，依据放置指令头分类别传送数据去处理
                //todo Maybe先期还是使用JSON传输使用数据，使用标识区分目标接口，后期再构建数据格式

                //使用Utf-8接收传入数据，全部作json字符串处理
                //todo 单独整理方法处理处理数据传入选择器
                //简单判定是不是Http请求
                if (in_str.indexOf("HTTP") > 0){
                    //判定为Http请求
                    logger.info("http请求:{}",in_str);

                }else {
                    //
                    JSONObject object = JSONObject.parseObject(in_str);
                    SelectMain select = GameServer.getInstance().getSelectManager().getSelectMain();
                    int key = object.getIntValue("key");
                    JSONObject parm = object.getJSONObject("parm");
                    parm.put("ChannelID",ctx.channel().id().asLongText());
                    select.JsonSelect(key,parm);
                }
            }
        }finally {
            //最后一定要显示的释放掉数据
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        super.channelWritabilityChanged(ctx);
    }

    //捕获抛出的异常，并处理异常（通常记录异常信息，并关闭对应的channel）
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //打印异常，并关闭
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
    }
}
