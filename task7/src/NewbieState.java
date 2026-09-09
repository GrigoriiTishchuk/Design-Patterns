public class NewbieState implements CharacterState {

    private static final int LEVEL_UP_XP = 100;
    // for fast progression, addXp is calculated as getXp + 10, so that the character can level up faster for testing purposes.
    // In a real game, it would be just addXp(10) to add 10 XP to the current XP.
    @Override
    public void train(GameCharacter character) {
        System.out.println(character.getName() + " is training as a Newbie. +10 XP gained.");
        character.addXp(character.getXp() + 10);
        character.displayStatus();
        if  (character.getXp() >= LEVEL_UP_XP) {
            character.setState(new IntermediateState());
        }
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println(character.getName() + ", for this character, is dangerous to fight as a Newbie.");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println(character.getName() + " can not meditate as a Newbie.");
    }


    @Override
    public String getLevelName() {
        return "Newbie";
    }

    @Override
    public void displayOptions() {
        System.out.println("As a Newbie, you can: ");
        System.out.println("1. Train");
    }
}
