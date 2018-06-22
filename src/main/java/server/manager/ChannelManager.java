package server.manager;

import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChannelManager {

    private final Map<String, Channel> channel_save;

    public ChannelManager(){
        channel_save = new ConcurrentHashMap<String, Channel>();
    }

    public void saveChannel(Channel channel) {
        this.channel_save.put(channel.id().asLongText(),channel);
    }

    public Channel findChannel(String key){
       return this.channel_save.get(key);
    }

}
