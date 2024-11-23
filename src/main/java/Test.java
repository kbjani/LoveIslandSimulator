public class Test {
    public static void main(String[] args) {
        
        Contestant player1 = new Islander("Leah", new BalancedStrategy());
        player1 = new FlirtRole(player1);
        Contestant player2 = new Islander("Rob", new AggressiveStrategy());
        Contestant player3 = new Islander("Jana", new PassiveStrategy());
        player3 = new LeaderRole(player3);

        Contestant[] islanders = {player1, player2, player3};

        for (Contestant islander : islanders) {
            System.out.println();
            ChallengeCommand game = new PhysicalChallenge(islander);
            game.execute();
            System.out.println();
        }



    }
}
