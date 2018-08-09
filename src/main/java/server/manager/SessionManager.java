package server.manager;


import business.Entity.Session;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {

    private final Map<String, Session> sessionMap; //最根本存储session还是用id来对应session

    private final Map<String, String> sessionIdMap; //快捷查找sessionId的map

    /**
     * 初始化管理
     */
    public SessionManager(){
        sessionMap = new HashMap<>();
        sessionIdMap = new HashMap<>();
    }

    /**
     * 添加session到管理中
     * @param session
     */
    public void addSession(Session session){
        sessionMap.put(session.getId(), session);
        sessionIdMap.put(session.getChannel_id(), session.getId());
    }

    /**
     * 直接通过seesion_id获取session
     * @param id
     * @return session
     */
    public Session getSessionByID(int id){
        return sessionMap.get(id);
    }

    /**
     * 通过cannnel_id(channel.id().asLongText())获取session
     * @param cannelID
     * @return session
     */
    public Session getSessionByCannelID(String cannelID){
        String id = sessionIdMap.get(cannelID);
        return sessionMap.get(id);
    }

}
