package client.initializer;

import client.handler.TempHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class TempInitialzer extends ChannelInitializer<SocketChannel> {

    private static final StringDecoder DECODER = new StringDecoder(CharsetUtil.UTF_8);
    private static final StringEncoder ENCODER = new StringEncoder(CharsetUtil.UTF_8);

    private static final TempHandler CLIENT_HANDLER = new TempHandler();

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        pipeline.addLast(DECODER);
        pipeline.addLast(ENCODER);
        pipeline.addLast(CLIENT_HANDLER);

    }

}
