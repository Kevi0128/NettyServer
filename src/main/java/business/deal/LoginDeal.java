package business.deal;

import business.deal.core.RequestDeal;
import com.alibaba.fastjson.JSONObject;

public class LoginDeal extends RequestDeal {

    @Override
    public void requestDeal(JSONObject parms) {
        System.out.println("【LoginDeal:】"+parms.toJSONString());
    }
}
