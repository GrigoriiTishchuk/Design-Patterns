import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your character's name:");
        String name = scanner.nextLine();
        GameCharacter hero = new GameCharacter(name);

        while (true) {
            System.out.println("\nCurrent Level: " + hero.getState().getLevelName());
            hero.getState().displayOptions();
            System.out.print("Choose an action (1-3) or 0 to exit: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Exiting the game. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    hero.train();
                    break;
                case 2:
                    hero.meditate();
                    break;
                case 3:
                    hero.fight();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
