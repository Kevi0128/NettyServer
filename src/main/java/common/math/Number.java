package common.math;

import java.util.Random;

public class Number {

    /**
     * 指定范围生成随机数
     * @param min 最小生成
     * @param max 最大生成
     * @return
     */
    public static int getrandom(final int min, final int max) {
        Random rand = new Random();
        int tmp = Math.abs(rand.nextInt());
        int therandom = tmp % (max - min + 1) + min;
        return therandom;
    }

}
