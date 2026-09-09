public class ExpertState implements CharacterState{
    private static final int LEVEL_UP_XP = 350;

    @Override
    public void train(GameCharacter character) {
        System.out.println("Training as an Expert character. +50 XP gained.");
        character.addXp(30);
        character.displayStatus();
        if (character.getXp() >= LEVEL_UP_XP) {
            character.setState(new MasterState());
        }
    }


    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Meditating as an Expert character...");
        character.addHealth(30);
        character.displayStatus();
    }


    @Override
    public void fight(GameCharacter character) {
        if (character.getXp() <= 15) {
            System.out.println("Too low on HP, hero. Fighting as an Expert character is not allowed.");
            return;
        }
        System.out.println("Fighting as an Expert character. Tough fight! -15 HP lost and +40 XP gained.");
        character.reduceHealth(15);
        character.addXp(40);
        character.displayStatus();
        if  (character.getXp() >= LEVEL_UP_XP) {
            character.setState(new MasterState());
        }

    }


    @Override
    public String getLevelName() {
        return "Expert";
    }

    @Override
    public void displayOptions() {
        System.out.println("Options for Expert character:");
        System.out.println("1. Train");
        System.out.println("2. Meditate");
        System.out.println("3. Fight");
    }
}
