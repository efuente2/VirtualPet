import java.util.Random;
import java.util.Scanner;

public class VirtualPet {
    private static final int MAX_HUNGER = 100;
    private static final int MAX_THIRST = 100;
    private static final int MAX_HAPPINESS = 100;
    private static final int MAX_HEALTH = 100;
    private static final int MAX_ENERGY = 100;


    private static final int HUNGER_THRESHOLD = 80;
    private static final int THIRST_THRESHOLD = 80;
    private static final int HAPPINESS_THRESHOLD = 20;
    private static final int ENERGY_THRESHOLD = 20;

    private int hunger;
    private int thirst;
    private int happiness;
    private int health;
    private int energy;

    private static Random random = new Random();

    public VirtualPet() {
        hunger = MAX_HUNGER / 2;
        thirst = MAX_THIRST / 2;
        happiness = MAX_HAPPINESS / 2;
        health = MAX_HEALTH / 2;
        energy = MAX_ENERGY / 2;
    }

    public void feed(int value) {
        hunger = Math.max(0, Math.min(MAX_HUNGER, hunger + value));
    }

    public void water(int value) {
        thirst = Math.max(0, Math.min(MAX_THIRST, thirst + value));
    }

    public void play(int value) {
        happiness = Math.max(0, Math.min(MAX_HAPPINESS, happiness + value));
    }

    public void sleep(int value) {
        energy = Math.max(0, Math.min(MAX_ENERGY, energy + value));
    }

    public void checkStatus() {
        System.out.println("Current Pet Status:");
        System.out.println("Hunger: " + hunger);
        System.out.println("Thirst: " + thirst);
        System.out.println("Happiness: " + happiness);
        System.out.println("Health: " + health);
        System.out.println("Energy: " + energy);
    }

    public void tick() {
        hunger = Math.max(0, hunger + random.nextInt(10));
        thirst = Math.max(0, thirst + random.nextInt(10));
        happiness = Math.max(0, happiness - random.nextInt(10));
        health = Math.max(0, health - random.nextInt(10));
        energy = Math.max(0, energy - random.nextInt(10));

        if (hunger >= HUNGER_THRESHOLD) {
            health -= random.nextInt(10);
        }
        if (thirst >= THIRST_THRESHOLD) {
            health -= random.nextInt(10);
        }
        if (happiness <= HAPPINESS_THRESHOLD) {
            health -= random.nextInt(10);
        }
        if (energy <= ENERGY_THRESHOLD) {
            health -= random.nextInt(10);
        }

        if (health <= 0) {
            System.out.println("Your pet has perished! Game over.");
            System.exit(0);
        }
    }
}

