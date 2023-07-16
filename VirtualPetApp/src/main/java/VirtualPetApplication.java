import java.util.Random;
import java.util.Scanner;

public class VirtualPetApplication {
    private static final int MAX_ACTIONS_PER_TICK = 3;

    private static final int TICK_INTERVAL = 5;
    private static final int MAX_TICKS = 20;

    private static final String[] ACTIONS = { "Feed", "Water", "Play", "Sleep", "Check Status" };
    private static final int MAX_ACTION_VALUE = 10;
    private static final int MIN_ACTION_VALUE = 1;

    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Virtual Pet App!");

        VirtualPet pet = new VirtualPet();
        int ticks = 0;

        while (ticks < MAX_TICKS) {
            int actionsPerformed = 0;
            while (actionsPerformed < MAX_ACTIONS_PER_TICK) {
                printActions();
                int actionIndex = getActionIndex();
                performAction(actionIndex, pet);
                actionsPerformed++;
            }
            pet.tick();
            ticks++;
            System.out.println("Tick " + ticks + " completed.\n");
            wait(TICK_INTERVAL);
        }

        System.out.println("Game Over! Thanks for playing.");
    }

    private static void printActions() {
        System.out.println("What would you like to do?");
        for (int i = 0; i < ACTIONS.length; i++) {
            System.out.println((i + 1) + ". " + ACTIONS[i]);
        }
    }
    private static int getActionIndex() {
        int actionIndex = -1;
        while (actionIndex < 0 || actionIndex >= ACTIONS.length) {
            System.out.print("Enter the action number: ");
            try {
                actionIndex = scanner.nextInt() - 1;
                scanner.nextLine(); // Consume newline character
                if (actionIndex < 0 || actionIndex >= ACTIONS.length) {
                    System.out.println("Invalid action number. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid action number.");
                scanner.nextLine(); // Consume invalid input
            }
        }
        return actionIndex;
    }

    private static void performAction(int actionIndex, VirtualPet pet) {
        switch (actionIndex) {
            case 0:
                int feedValue = getRandomActionValue();
                pet.feed(feedValue);
                System.out.println("You fed the pet. Hunger level changed by: " + feedValue);
                break;
            case 1:
                int waterValue = getRandomActionValue();
                pet.water(waterValue);
                System.out.println("You gave water to the pet. Thirst level changed by: " + waterValue);
                break;
            case 2:
                int playValue = getRandomActionValue();
                pet.play(playValue);
                System.out.println("You played with the pet. Happiness level changed by: " + playValue);
                break;
            case 3:
                int sleepValue = getRandomActionValue();
                pet.sleep(sleepValue);
                System.out.println("You let the pet sleep. Energy level changed by: " + sleepValue);
                break;
            case 4:
                pet.checkStatus();
                break;
        }
    }
    private static int getRandomActionValue() {
        return random.nextInt(MAX_ACTION_VALUE - MIN_ACTION_VALUE + 1) + MIN_ACTION_VALUE;
    }

    private static void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
