package business.select.impl;

import business.select.core.RequestSelect;

public class JsonRequestSelect {

    private final RequestSelect requestSelect;

    public JsonRequestSelect(){
         this.requestSelect = new RequestSelect();
    }

    public void addSelect(Integer key, Class<?> deal){
        requestSelect.addSelct(key,deal);
    }

    public Object getSelect(Integer key){
        try {
           return requestSelect.getSelectDeal(key);
        }catch (InstantiationException error){
            error.printStackTrace();
        }catch (IllegalAccessException error){
            error.printStackTrace();
        }
        return null;
    }

}
