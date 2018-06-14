package server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

/**
 * 处理服务端 channel
 * 继承ChannelInboundHandlerAdapter，获得事件处理接口
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

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

    //该方法会在收到消息时被调用
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //展示并丢弃接收到的数据
        ByteBuf in = (ByteBuf) msg;
        try {
            //在这里处理数据
            while (in.isReadable()){
                //使用Utf-8接收传入数据，全部作json字符串处理
                String in_str = in.toString(CharsetUtil.UTF_8);
                System.out.println(in_str);
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
    public boolean isSharable() {
        return super.isSharable();
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
