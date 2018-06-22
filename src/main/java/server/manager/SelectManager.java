package server.manager;

import business.select.SelectMain;
import server.GameServer;

public class SelectManager {

    private GameServer server;
    private SelectMain selectMain;

    public boolean inited = false;

    public void init(){
        if (!inited){
            server = GameServer.getInstance();
            SelectMain select = new SelectMain();
            select.init();
            this.selectMain = select;
            inited = true;
        }
    }

    public SelectMain getSelectMain() {
        return selectMain;
    }

    public void setSelectMain(SelectMain selectMain) {
        this.selectMain = selectMain;
    }
}
