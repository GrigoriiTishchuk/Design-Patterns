public class IntermediateState implements CharacterState {

    private static final int LEVEL_UP_XP = 250;

    @Override
    public void train(GameCharacter character) {
        System.out.println("Training as an Intermediate character. +30 XP gained.");
        character.addXp(character.getXp() + 30);
        if (character.getXp() >= LEVEL_UP_XP) {
            character.setState(new ExpertState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Meditating as an Intermediate character...");
        character.addHealth(20);
        character.displayStatus();
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Fighting as an Intermediate character is not allowed yet...");
    }

    @Override
    public String getLevelName() {
        return "Intermediate";
    }

    @Override
    public void displayOptions() {
        System.out.println("Options for Intermediate character:");
        System.out.println("1. Train");
        System.out.println("2. Meditate");
    }
}
