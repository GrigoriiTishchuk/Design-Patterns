import java.util.Random;

public class SurfaceTensionGame extends Game {
    private int glassCapacity;
    private int currentCoins;
    private int maxCoinsPerTurn;
    private int loserPlayer;
    private boolean isOverflowed;
    private Random rand;



    @Override
    public void initializeGame(int numberOfPlayers) {
        this.rand = new Random();
        this.glassCapacity = 20 + rand.nextInt(10); // Random capacity between 20 and 29
        this.currentCoins = 0;
        this.maxCoinsPerTurn = 1 + rand.nextInt(3); // Random max coins per turn between 1 and 3
        this.loserPlayer = -1;
        this.isOverflowed = false;
        System.out.println("Game initialized with glass capacity: " + glassCapacity + " and max coins per turn: " + maxCoinsPerTurn);
        System.out.println("Number of players: " + numberOfPlayers);
    }

    @Override
    public boolean endOfGame() {
        return isOverflowed;
    }

    @Override
    public void playSingleTurn(int player) {
        int coinsToAdd = 1 + rand.nextInt(maxCoinsPerTurn); // Random coins to add between 1 and maxCoinsPerTurn
        System.out.println("Player " + player+1 + " adds " + coinsToAdd + " coins.");
        currentCoins += coinsToAdd;
        if (currentCoins >= glassCapacity) {
            isOverflowed = true;
            loserPlayer = player;
            System.out.println("SPLASH!!! Player " + (player+1) + " caused the glass to overflow!");
        } else {
            System.out.println("Water surface stands strong!) " );
        }
    }


    @Override
    public void displayWinner() {
        System.out.println("Game over! The glass overflowed with " + currentCoins + " coins.");
        System.out.println("Player " + (loserPlayer+1) + " loses the game!");
        System.out.println("Congratulations to the other players!");
    }
}
