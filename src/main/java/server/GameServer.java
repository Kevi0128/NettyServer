package server;

import server.manager.SelectManager;

/**
 * 抽象整个Server
 */
public final class GameServer {

    private static GameServer _instance = null;
    private SelectManager selectManager;

    public static GameServer getInstance(){
        if (_instance == null){
            _instance = new GameServer();
        }
        return _instance;
    }

    public GameServer(){
       SelectManager selectManager = new SelectManager();
       this.selectManager = selectManager;
    }

    public static void start(){

    }

    public SelectManager getSelectManager() {
        return this.selectManager;
    }
}
