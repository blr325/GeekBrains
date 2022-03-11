package java2.lesson1;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<RunningAndJumpable> participants = new ArrayList<>();
        participants.add(new Cat("Барсик", 200, 2));
        participants.add(new Cat("Мурзик", 150, 1));
        participants.add(new Cat("Рыжик", 250, 3));
        participants.add(new Human("Андрей", 400, 2));
        participants.add(new Human("Михаил", 150, 3));
        participants.add(new Human("Алексей", 300, 5));
        participants.add(new Robot("b2b2", 100, 7));
        participants.add(new Robot("b1b1", 150, 6));
        participants.add(new Robot("b4b2", 300, 5));

        ArrayList<Barrier> barriers = new ArrayList<>();
        barriers.add(new Wall(3));
        barriers.add(new RunningTrack(200));

        ArrayList<RunningAndJumpable> winners = new ArrayList<>();

        for (RunningAndJumpable participant : participants) {
            participant.run(((RunningTrack) barriers.get(1)));
            if(!participant.checkLength(((RunningTrack) barriers.get(1)))){
                continue;
            }
            participant.jump(((Wall) barriers.get(0)));
            if(participant.checkHeight(((Wall) barriers.get(0)))){
                winners.add(participant);
            }
        }

        System.out.println("-------------------------------------");
        System.out.println("Прошли все преграды:");
        winners.forEach(System.out::println);
    }
}
