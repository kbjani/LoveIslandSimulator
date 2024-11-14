// Love Island Simulation
// Main method to test program is in TestSimulation.java

public class TestSimulation {
    public static void main(String[] args) {

        
        System.out.println("\nLet's run a trial game! Let's make 5 players and have them do 2 challenges.\n");

        Contestant p1 = new Islander("Leah", new SafeStrategy());
        Contestant p2 = new Islander("Kaylor", new AggressiveStrategy());
        Contestant p3 = new Islander("Serena", new SafeStrategy());
        Contestant p4 = new Islander("Rob", new SafeStrategy());
        Contestant p5 = new Islander("Jana", new SafeStrategy());

        Contestant[] contestants = {p1, p2, p3, p4, p5};

        System.out.println("Before Challenge 1, let's see the players and scores.\n");
        
        for (Contestant islander : contestants) {
            islander.updatedScore(0);
            System.out.println(islander.getDescription() + ": Score - " + islander.getScore());
        }

        System.out.println("\nDuring this challenge, some players will take on different roles.\n");

        System.out.println("Challenge 1..............................\n");

        // scores get updated based on challenge command execution ....

        p1.updatedScore(15);
        p2.updatedScore(15);
        p3.updatedScore(15);
        p4.updatedScore(15);
        p5.updatedScore(15);
        System.out.println(p1.getDescription() + ": Score - " + p1.getScore());
        System.out.println(p2.getDescription() + ": Score - " + p2.getScore());
        System.out.println(p3.getDescription() + ": Score - " + p3.getScore());
        System.out.println(p4.getDescription() + ": Score - " + p4.getScore());
        System.out.println(p5.getDescription() + ": Score - " + p5.getScore());

        System.out.println("\nRob will be flirty.");
        System.out.println("Leah will be a leader.");
        System.out.println("Kaylor will be an outsider.\n");

        p4 = new FlirtRole(p4);
        p1 = new LeaderRole(p1);
        p2 = new OutsiderRole(p2);

        System.out.println(p1.getDescription() + ": Score - " + p1.getScore());
        System.out.println(p2.getDescription() + ": Score - " + p2.getScore());
        System.out.println(p3.getDescription() + ": Score - " + p3.getScore());
        System.out.println(p4.getDescription() + ": Score - " + p4.getScore());
        System.out.println(p5.getDescription() + ": Score - " + p5.getScore());

        System.out.println("\nChallenge 2................................");
        System.out.println("\nKaylor is going to be double faced in the next challenge.\n");


        p1.updatedScore(22);
        p2.updatedScore(22);
        p3.updatedScore(22);
        p4.updatedScore(22);
        p5.updatedScore(22);

        p2 = new DoubleFacedRole(p2);
        
        System.out.println(p1.getDescription() + ": Score - " + p1.getScore());
        System.out.println(p2.getDescription() + ": Score - " + p2.getScore());
        System.out.println(p3.getDescription() + ": Score - " + p3.getScore());
        System.out.println(p4.getDescription() + ": Score - " + p4.getScore());
        System.out.println(p5.getDescription() + ": Score - " + p5.getScore());

    }
}
