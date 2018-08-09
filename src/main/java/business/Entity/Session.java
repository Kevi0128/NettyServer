package business.Entity;

import io.netty.channel.Channel;

import java.util.UUID;

/**
 * 构建会话实体
 * todo 完善会话实体
 */
public class Session {
    //会话ID
    private String id;
    //会话用户
    private User user;
    private int user_id;
    //会话连接
    private Channel channel;
    private String channel_id;

    public void init(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.user_id = user.getId();
    }

    public int getUser_id() {
        return user_id;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
        this.channel_id = channel.id().asLongText();
    }

    public String getChannel_id() {
        return channel_id;
    }

}
