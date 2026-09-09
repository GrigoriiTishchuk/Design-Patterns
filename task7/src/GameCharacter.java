public class GameCharacter {
    private final String name;
    private int health;
    private int xp;
    private CharacterState state;

    // NewbieState is the initial state of the character
    public GameCharacter(String name) {
        this.name = name;
        this.health = 100;
        this.xp = 0;
        this.state = new NewbieState();
    }

    public void setState(CharacterState state) {
        this.state = state;
        System.out.println("Congatulations! "+ name + " Changed state to " + state.getLevelName() +"! \n");
    }

    public void train() {
        state.train(this);
    }

    public void fight() {
        state.fight(this);
    }

    public void meditate() {
        state.meditate(this);
    }


    public void displayStatus(){
        System.out.println(name + "'s health: " + health + ", xp: " + xp + ", state: " + state.getLevelName());
        state.displayOptions();
    }



    public String getName() {return name;}

    public int getHealth() {return health;}
    public void addHealth(int amount) {this.health += amount;}
    public void reduceHealth(int amount) {this.health = Math.max(0, this.health - amount);}
    public int getXp() {return xp;}
    public void addXp(int amount) {this.xp += amount;}

    public CharacterState getState() {return state;}
}
