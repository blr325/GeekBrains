package java2.lesson1;

public class Human implements RunningAndJumpable {
    private String name;
    private int maxRun;
    private int maxJump;

    public Human(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    public boolean checkLength(RunningTrack track) {
        return maxRun >= track.getLengthRunningTrack();
    }

    public boolean checkHeight(Wall wall) {
        return maxJump >= wall.getHeightWall();
    }

    @Override
    public void jump(Wall wall) {
        if (checkHeight(wall)) System.out.println(name + " перепрыгнул стену");
        else System.out.println(name + " не перепрыгнул стену");
    }

    @Override
    public void run(RunningTrack track) {
        if (checkLength(track))
            System.out.println(name + " пробежал через беговую дорожку");
        else System.out.println(name + " не смог пробежать через беговую дорожку");

    }

    @Override
    public String toString() {
        return "Человек : " + name ;
    }
}
