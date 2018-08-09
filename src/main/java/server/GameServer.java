package server;

import server.manager.ChannelManager;
import server.manager.SelectManager;
import server.manager.SessionManager;

/**
 * 抽象整个Server
 */
public final class GameServer {

    private static GameServer _instance = null;
    private SelectManager selectManager;
    private SessionManager sessionManager;

    public static GameServer getInstance(){
        if (_instance == null){
            _instance = new GameServer();
        }
        return _instance;
    }

    private GameServer(){
       SelectManager selectManager = new SelectManager();
       this.selectManager = selectManager;
       SessionManager sessionManager = new SessionManager();
       this.sessionManager = sessionManager;
    }

    public static void start(){
        getInstance().selectManager.init();
    }

    public SelectManager getSelectManager() {
        return this.selectManager;
    }

    public SessionManager getSessionManager() {
        return sessionManager;
    }
}
