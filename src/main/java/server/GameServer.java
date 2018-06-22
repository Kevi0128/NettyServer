package server;

import server.manager.ChannelManager;
import server.manager.SelectManager;

/**
 * 抽象整个Server
 */
public final class GameServer {

    private static GameServer _instance = null;
    private SelectManager selectManager;
    private ChannelManager channelManager;

    public static GameServer getInstance(){
        if (_instance == null){
            _instance = new GameServer();
        }
        return _instance;
    }

    private GameServer(){
       SelectManager selectManager = new SelectManager();
       this.selectManager = selectManager;
       ChannelManager channelManager = new ChannelManager();
       this.channelManager = channelManager;
    }

    public static void start(){
        getInstance().selectManager.init();
    }

    public SelectManager getSelectManager() {
        return this.selectManager;
    }

    public ChannelManager getChannelManager() {
        return channelManager;
    }
}
