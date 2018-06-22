package business.select.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 分辨json数据选择请求
 */
public class RequestSelect {

    private final Map<Object, Class<?>> selects; //装入初始请求选择
    private final Map<Object, Object> select_map; //使用Map装入已初始化请求选择

    public RequestSelect(){
        selects = new ConcurrentHashMap<Object, Class<?>>();
        select_map = new ConcurrentHashMap<Object, Object>();
    }

    /**
     * 装入选择器选择
     * @param select_key
     * @param dealClass
     */
    public void addSelct(Object select_key, Object dealClass){
        select_map.put(select_key,dealClass);
    }

    public void addSelect(Object select_key, Class<?> dealClass){
        selects.put(select_key,dealClass);
    }

    /**
     * 清空选择器
     */
    public void cleanAll(){
        this.select_map.clear();
        this.selects.clear();
    }

    /**
     * 从选择器中获取选择
     * @param key
     * @return
     */
    public Object getSelectDeal(Object key) throws InstantiationException,IllegalAccessException {
        Object deal = select_map.get(key);
        if (deal != null){
            return deal;
        }
        Class<?> dealClass = selects.get(key);
        if (dealClass == null){
            return null;
        }
        deal = dealClass.newInstance();
        select_map.put(key,deal);
        return deal;
    }

}
