package server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.server.ServerSet;

/**
 * 服务器主启动类
 */
public class ServerStart {

    private static final Logger logger = LoggerFactory.getLogger(ServerStart.class);

    public static void main(String[] args) {
        //首先，说个你好
        logger.info("############################系统开始启动##########################");
        logger.info("你好，世界");
        //初始服务器
        GameServer.getInstance();
        GameServer.start();
        //调用服务器设置并启动
        int port = 233;
        try {
            new ServerSet(port).run();
        }catch (Exception e){
            //临时处理异常
            e.printStackTrace();
            logger.error("!!!!!!!!!!!!!!!!!!!严重错误，系统崩溃!!!!!!!!!!!!!!!!!!");
            logger.error("详细错误信息:{}",e.toString());
        }

    }

}
