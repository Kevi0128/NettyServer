package business.deal;

import business.deal.core.RequestDeal;
import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.GameServer;

public class LoginDeal extends RequestDeal {

    private Logger logger = LoggerFactory.getLogger(LoginDeal.class);

    @Override
    public void requestDeal(JSONObject parms) {
        logger.info("【LoginDeal:】{}",parms.toJSONString());
        String channel_id = parms.getString("ChannelID");
        Channel channel = GameServer.getInstance().getSessionManager().getSessionByCannelID(channel_id).getChannel();
        JSONObject result = new JSONObject();
        result.put("msg","登录成功");
        channel.writeAndFlush(result.toJSONString());
    }

}
