package client.handler;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.StringUtil;

public class TempHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String in_str = (String) msg;
        try {
            if (!StringUtil.isNullOrEmpty(in_str)) {
                System.out.println(in_str);
                JSONObject jsonObject = JSONObject.parseObject(in_str);
            }
        }catch (Exception e){
//            e.printStackTrace();
            //暂时假定无法接受json数据，就是服务器的初次连接欢迎信息
            //那么申请登录服务器
            if (in_str.indexOf("kevi's Netty") > 0){
                System.out.println("发送登录信息");
                JSONObject request = new JSONObject();
                request.put("key",1);
                JSONObject parm = new JSONObject();
                parm.put("name","kevi");
                parm.put("password","0128");
                request.put("parm",parm);
                ctx.writeAndFlush(request.toJSONString());
            }
        }finally {
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

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

}
