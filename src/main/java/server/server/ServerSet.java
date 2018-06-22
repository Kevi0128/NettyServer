package server.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.GameServer;
import server.initializer.GameChannelInitialzer;
import server.manager.SelectManager;

public class ServerSet {

    private static final Logger logger = LoggerFactory.getLogger(ServerSet.class);

    private int port;

    public ServerSet(int port){
        this.port = port;
    }

    public void run() throws Exception{
        //临时在这里启动
        GameServer.getInstance().getSelectManager().init();


        logger.info("启动Netty服务中");
        //构造两个线程池，boss接收进来的连接，worker则处理已接收的连接
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //辅助启动NIO服务
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boosGroup, workerGroup)
                     .channel(NioServerSocketChannel.class)  //指定使用NioServerSocketChannel接收进入连接
                     .childHandler(new GameChannelInitialzer())
                     .option(ChannelOption.SO_BACKLOG, 128)  //提供给指定的用来接收连接的Channel，指定Channel实现的配置参数
                     .childOption(ChannelOption.SO_KEEPALIVE, true);  //提供给指定连接的Channel的父ServerChannel
            //绑定接收数据的端口(可以多次调用，绑定不同的地址)
            ChannelFuture future = bootstrap.bind(port).sync();
            //等待，直到服务器关闭连接
            //todo
            //所以，先手动关闭连接
            future.channel().closeFuture().sync();
        }finally {
            workerGroup.shutdownGracefully();
            boosGroup.shutdownGracefully();
        }

    }

}
