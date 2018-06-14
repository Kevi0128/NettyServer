package server.initializer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import server.decoder.StringDecoder;
import server.encoder.StringEncoder;
import server.handler.DiscardServerHandler;

// 这里的事件处理类经常会被用来处理一个最近的已经接收的 Channel。
// ChannelInitializer 是一个特殊的处理类，他的目的是帮助使用者配置一个新的 Channel。
// 也许你想通过增加一些处理类比如DiscardServerHandler 来配置一个新的 Channel
// 或者其对应的ChannelPipeline 来实现你的网络程序。
// 当你的程序变的复杂时，可能你会增加更多的处理类到 pipline 上，
// 然后提取这些匿名类到最顶层的类上。
public class GameChannelInitialzer extends ChannelInitializer<SocketChannel> {
    //构建默认编码解码器
    private static final StringDecoder DECODER = new StringDecoder();
    private static final StringEncoder ENCODER = new StringEncoder();
    //获取事件处理Handler
    private static final DiscardServerHandler SERVER_HANDLER = new DiscardServerHandler();
//    //放置连接
//    private final SocketChannel socketChannel;
//
//    public GameChannelInitialzer(SocketChannel socketChannel){
//        this.socketChannel = socketChannel;
//    }

    @Override
    public void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        pipeline.addLast(SERVER_HANDLER);

    }
}
