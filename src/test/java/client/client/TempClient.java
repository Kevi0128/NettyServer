package client.client;

import client.initializer.TempInitialzer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TempClient {

    private static final String host = "127.0.0.1";
    private static final int port = 233;



    public static void main(String args[]) throws Exception {
        EventLoopGroup wokergroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(wokergroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.handler(new TempInitialzer());

            //依据地址和端口启动客户端
            ChannelFuture future = bootstrap.connect(host, port);

            future.channel().closeFuture().sync();

        }finally {
            wokergroup.shutdownGracefully();
        }

    }

}
