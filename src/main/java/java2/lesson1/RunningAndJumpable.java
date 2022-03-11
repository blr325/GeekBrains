package java2.lesson1;

public interface RunningAndJumpable{
    void run(RunningTrack track);
    void jump(Wall wall);
    boolean checkHeight(Wall wall);
    boolean checkLength(RunningTrack track);

}
