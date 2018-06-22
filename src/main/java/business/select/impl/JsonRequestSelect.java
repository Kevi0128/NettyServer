package business.select.impl;

import business.deal.core.RequestDeal;
import business.select.core.RequestSelect;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonRequestSelect {

    private final Logger logger = LoggerFactory.getLogger(JsonRequestSelect.class);

    private final RequestSelect requestSelect;

    public JsonRequestSelect(){
         this.requestSelect = new RequestSelect();
    }

    public void addSelect(Integer key, Object deal){
        requestSelect.addSelct(key,deal);
    }

    public void JsonSelect(Integer key, JSONObject parm){
        try {
           RequestDeal deal = (RequestDeal) this.requestSelect.getSelectDeal(key);
           deal.requestDeal(parm);
        }catch (InstantiationException error){
            error.printStackTrace();
            logger.error("JsonRequestSelect error InstantiationException info{}",error.toString());
        }catch (IllegalAccessException error){
            error.printStackTrace();
            logger.error("JsonRequestSelect error IllegalAccessException info{}",error.toString());
        }
    }

}
