public class MasterState implements CharacterState{

    @Override
    public void train(GameCharacter character)
    {
        System.out.println("You are already a master. Training is not necessary.");
    }

    @Override
    public void meditate(GameCharacter character)
    {
        System.out.println("You are already a master, NO ONE CAN BEAT YOU. Meditating is not necessary.");
    }

    @Override
    public void fight(GameCharacter character)
    {
        System.out.println("You are already a master, EVERYONE FEARS YOU. Fighting is not necessary.");
    }


    @Override
    public String getLevelName() {
        return "Master";
    }

    @Override
    public void displayOptions() {
        System.out.println("As a Master, you have no further options. You have reached the pinnacle of your journey. GAME OVER.");
    }
}
