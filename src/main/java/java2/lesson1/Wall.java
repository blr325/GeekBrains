package java2.lesson1;

public class Wall implements Barrier{
    private int heightWall;

    public Wall(int heightWall) {
        this.heightWall = heightWall;
    }

    public int getHeightWall() {
        return heightWall;
    }
}
