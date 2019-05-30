package common.map;

import common.math.Number;

/**
 * 创建新的地图块
 */
public class MapBlockFactory {

    /**
     * 依据周边环境来生产新的基础地块
     * @param west   东
     * @param east   西
     * @param south  南
     * @param north  北
     * @param hight 水平高度  暂不使用
     * @return  int 地块编号
     */
    public int CreateNewBaseBlock(int west, int east, int south, int north, int hight){
        int land = 500, bias = 0;
        bias = BiasBlock(bias, west);
        bias = BiasBlock(bias, east);
        bias = BiasBlock(bias, south);
        bias = BiasBlock(bias, north);
        int check = Number.getrandom(1,1000);
        if (check <= (land + bias))
            return MapBlockType.land;
        return MapBlockType.water;
    }

    private int BiasBlock(int bias, int near){
        switch (near){
            case 1:
                bias += 125;
                break;
            case 2:
                bias -= 125;
                break;
            default:
                bias += 0;
        }
        return bias;
    }

}
