package server;

import server.server.ServerSet;

/**
 * 服务器主启动类
 */
public class ServerStart {

    public static void main(String[] args) {
        //首先，说个你好
        System.out.println("Hello World!");
        System.out.println("你好世界！");
        //调用服务器设置并启动
        int port = 8080;
        try {
            new ServerSet(port).run();
        }catch (Exception e){
            //临时处理异常
            e.printStackTrace();
        }

    }

}
