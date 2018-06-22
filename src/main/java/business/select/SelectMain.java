package business.select;

import business.deal.LoginDeal;
import business.select.impl.JsonRequestSelect;

public class SelectMain extends JsonRequestSelect {

    public void init(){
        addSelect(1,new LoginDeal());
    }

}
