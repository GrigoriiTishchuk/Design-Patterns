public interface CharacterState {
    void train(GameCharacter character);
    void fight(GameCharacter character);
    void meditate(GameCharacter character);

    String getLevelName();
    void displayOptions();
}
