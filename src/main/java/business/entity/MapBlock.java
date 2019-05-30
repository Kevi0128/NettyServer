package business.entity;

public class MapBlock {

    public int BlockType;  //地块类型

    public int x;       //x轴坐标

    public int y;       //y轴坐标

    public int z;       //z轴坐标

    public int getBlockType() {
        return BlockType;
    }

    public void setBlockType(int blockType) {
        BlockType = blockType;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
