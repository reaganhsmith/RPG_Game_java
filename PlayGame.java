import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.Random;

// REQ!! CREATING A CLASS IN JAVA 
public class PlayGame {
    public static void main(String[] args) {

        System.out.println(" ");
        System.out.println("Hello World!! Welcome to a very fun adventure game!");
        System.out.println(" ");

        String gameInstructions = "For this game you get to design your own character and go through battles and follow a fun story line";

        System.out.println(gameInstructions);
        System.out.println(" ");

        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> characterDetails = new ArrayList<>();
        ArrayList<Integer> characterStats = new ArrayList<>();
        ArrayList<String> characterInventory = new ArrayList<>();
        // REQ!! FUNCTION
        createAndDisplayCharacter(scanner, characterDetails, characterStats);
        battlePlay(scanner, characterStats, characterInventory);
        saveInventory(characterInventory);

    }

    public static void battlePlay(Scanner scanner, ArrayList<Integer> characterStats,
            ArrayList<String> characterInventory) {
        // System.out.print(character);

        // Get the character stats from the ARRAY
        int characterHp = characterStats.get(0);
        int characterDamage = characterStats.get(1);
        System.out.println("For the following questions pick either: ");
        System.out.println("1: Fight");
        System.out.println("2: Run");
        System.out.println("You only need to enter the number 1 or 2.");
        System.out.println("*****************************************************");
        System.out.println(" ");

        System.out.println("");
        int keepPlaying = 1;
        while (keepPlaying == 1) {
            System.out.println(
                    "You begin your journey on a crisp fall morning. As you walk through the woods a giant vampire spider jumps out at you! Do you want to (1) Fight or (2) Run?");
            String choice1 = scanner.nextLine();
            int choiceINT = Integer.parseInt(choice1);
            System.out.println(" ");
            if (choiceINT == 1) {
                spiderEncounter(scanner, characterHp, characterDamage, characterInventory);
                System.out.println(
                        "After the spider encounter you decide to play it safe and stay away from the trees. You make your way to the stream but end up encountering a sleeping siren! Do you want to (1) Fight or (2) Run?");
                int choice2 = Integer.parseInt(scanner.nextLine());
                if (choice2 == 1) {
                    sirenEncounter(scanner, characterHp, characterDamage, characterInventory);
                } else {
                    System.out.println("You tip toed across the sleeping siren without waking her.");
                }

            } else {
                System.out.println("You succesfully outran the Vampire spider. Your health is: ");
                System.out.println(
                        "After the spider encounter you decide to play it safe and stay away from the trees. You make your way to the stream but end up encountering a sleeping siren! Do you want to (1) Fight or (2) Run?");
                int choice2 = Integer.parseInt(scanner.nextLine());
                if (choice2 == 1) {
                    sirenEncounter(scanner, characterHp, characterDamage, characterInventory);
                } else {
                    System.out.println("You quietly snuck past the sleeping siren");
                }
            }

            keepPlaying = 2;
        }
        System.out.println("");
        System.out.println("Thank you for playing!");

        saveInventory(characterInventory);
        System.out.println("");
        displayFile("Inventory", "CharacterInventory.txt");

    }

    public static void sirenEncounter(Scanner scanner, int characterHp, int characterDamage,
            ArrayList<String> characterInventory) {
        int sirenHP = new Random().nextInt((80 - 50) + 1) + 50;
        int sirenAttack = new Random().nextInt((30 - 5) + 1) + 5;
        int randomPath = new Random().nextInt(2) + 1;
        if (randomPath == 1) {
            System.out.println("Oh no! The siren burst into music and it damages you.");
            characterHp -= sirenAttack;
            System.out.println("You now have: " + characterHp + " Health");
            System.out.println("She looks ready for round 2... Would you like to (1) fight or (2) run?");
            int path = Integer.parseInt(scanner.nextLine());
            if (path == 1) {
                sirenEncounter(scanner, characterHp, characterDamage, characterInventory);
            } else {
                randomPath = new Random().nextInt(2) + 1;
                if (randomPath == 1) {
                    System.out.println("You got away before the siren could attack again!!");
                } else {
                    System.out.println("Oh no you could NOT you were not fast enough!");
                    sirenEncounter(scanner, characterHp, characterDamage, characterInventory);
                }

            }
        } else {
            sirenHP -= characterDamage;
            System.out.println(
                    "You leaped at the siren and you were able to do some damage. Her health is now " + sirenHP);

            if (sirenHP > 0) {
                System.out.println(
                        "However the siren is still alive and looks like she wants to fight!! Would you like to (1) fight or (2) run?");
                int path = Integer.parseInt(scanner.nextLine());

                if (path == 1) {
                    sirenEncounter(scanner, characterHp, characterDamage, characterInventory);
                } else {
                    randomPath = new Random().nextInt(2) + 1;
                    if (randomPath == 1) {
                        System.out.println("You sprinted as fast as you could before the siren could get to you!");
                    } else {
                        System.out.println("Oh no you could NOT get away from the siren!");
                        sirenEncounter(scanner, characterHp, characterDamage, characterInventory);
                    }
                }
            } else {
                int randomAmount = new Random().nextInt(10) + 1;
                String sirenTears;
                if (randomAmount > 1) {
                    sirenTears = randomAmount + " siren tear";
                } else {
                    sirenTears = randomAmount + " siren tears";
                }
                characterInventory.add(sirenTears);

                System.out
                        .println("Congrats! You successfully killed the sleeping siren. You picked up: "
                                + sirenTears);
                System.out
                        .println(" ");

            }
        }

    }

    public static void spiderEncounter(Scanner scanner, int characterHp, int characterDamage,
            ArrayList<String> characterInventory) {
        int spiderHP = new Random().nextInt((30 - 5) + 1) + 5;
        int spiderAttack = new Random().nextInt((50 - 5) + 1) + 5;

        int randomPath = new Random().nextInt(2) + 1;

        if (randomPath == 1) {
            System.out.println("Oh no! The spider attacked you before you could do anything!");
            characterHp -= spiderAttack;
            System.out.println("You now have: " + characterHp + " Health");
            System.out.println(
                    "The vampire spider is ready to pounce again!! Would you like to (1) fight or (2) run?");
            int path = Integer.parseInt(scanner.nextLine());

            if (path == 1) {
                spiderEncounter(scanner, characterHp, characterDamage, characterInventory);
            } else {
                randomPath = new Random().nextInt(2) + 1;
                if (randomPath == 1) {
                    System.out.println("You got away before the spider could attack again!!");
                } else {
                    spiderEncounter(scanner, characterHp, characterDamage, characterInventory);
                }

            }
        } else {
            spiderHP -= characterDamage;
            System.out.println("You got a gnarly hit on the vampire spider. Its health is now " + spiderHP);

            if (spiderHP > 0) {
                System.out.println("The vampire spider is still ALIVE!! Would you like to (1) fight or (2) run?");
                int path = Integer.parseInt(scanner.nextLine());

                if (path == 1) {
                    spiderEncounter(scanner, characterHp, characterDamage, characterInventory);
                } else {
                    randomPath = new Random().nextInt(2) + 1;
                    if (randomPath == 1) {
                        System.out.println("You got away before the spider could attack again!!");
                    } else {
                        spiderEncounter(scanner, characterHp, characterDamage, characterInventory);
                    }
                }
            } else {
                int randomAmount = new Random().nextInt(5) + 1;
                String vampSpider = (randomAmount > 1) ? randomAmount + " spider webs"
                        : randomAmount + " spider web";
                characterInventory.add(vampSpider);

                System.out
                        .println("Congrats! You successfully killed the Vampire Spider. You picked up: "
                                + vampSpider);
                System.out
                        .println(" ");

            }
        }

    }

    public static void createAndDisplayCharacter(Scanner scanner, ArrayList<String> characterDetails,
            ArrayList<Integer> characterStats) {
        // REQ! DATA STRUCTURE FROM JAVA FRAMEWORK

        System.out.print("Player Hair color: ");
        String hairColor = "Hair color: " + scanner.nextLine();
        characterDetails.add(hairColor);

        System.out.print("wizard or werewolf: ");
        String wizardOrNot = scanner.nextLine().toLowerCase();
        characterDetails.add(wizardOrNot);

        // REQ!! THIS IS AN EXAMPLE OF JAVA CONDITIONAL (IF, ELSE IF, ELSE)
        if ("wizard".equalsIgnoreCase(wizardOrNot)) {
            int randomHP = new Random().nextInt((100 - 80) + 1) + 80;
            String characterHP = "Your health: " + randomHP;
            characterStats.add(randomHP);
            characterDetails.add(characterHP);

            int randomDamage = new Random().nextInt((30 - 5) + 1) + 5;
            characterStats.add(randomDamage);
            String powers = "You do: " + randomDamage + " damage";
            characterDetails.add(powers);

        } else {
            int randomHP = new Random().nextInt((120 - 90) + 1) + 90;
            characterStats.add(randomHP);
            String characterHP = "Your health: " + randomHP;
            characterDetails.add(characterHP);

            int randomDamage = new Random().nextInt((20 - 5) + 1) + 5;
            characterStats.add(randomDamage);
            String powers = "You do: " + randomDamage + " damage";
            characterDetails.add(powers);
        }

        System.out.println(" ");
        // REQ!! FUNCTION
        // System.out.println(characterDetails.get(1));
        saveCharacter(characterDetails);
        displayFile("character", "CharacterInfo.txt");
        System.out.println(" ");

    }

    private static void saveCharacter(ArrayList<String> Character) {
        // Specify the directory and file name
        String directoryPath = ".";
        String fileName = "CharacterInfo.txt";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(directoryPath, fileName)))) {
            // REQ!!! FOR LOOP
            for (String line : Character) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayFile(String type, String file) {
        System.out.println("Your " + type + ": ");

        String infoPath = file;
        try (BufferedReader reader = new BufferedReader(new FileReader(infoPath))) {
            String line;
            // REQ!! WHILE LOOP
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(" ");
    }

    private static void saveInventory(ArrayList<String> characterInventory) {
        // Specify the directory and file name
        String directoryPath = ".";
        String fileName = "CharacterInventory.txt";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(directoryPath, fileName)))) {
            // REQ!!! FOR LOOP
            for (String line : characterInventory) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
