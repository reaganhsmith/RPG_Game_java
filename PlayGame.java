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

        String gameInstructions = "For this game you get to design your own character and go through battles and follow a fun story line. You will collect items and at the end it will show your inventory.";

        System.out.println(gameInstructions);
        System.out.println(" ");

        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        /*
         * CREATING ARRAYS TO HOLD DIFFERENT INFORMATION USED IN THE GAME
         * the characterdetails holds the things the user selects about their character
         * character stats is used when they fight another creature so it hold their
         * health is index 0 and damage at index 1
         * character invetory holds the items you can collect while playing the game.
         */
        ArrayList<String> characterDetails = new ArrayList<>();
        ArrayList<Integer> characterStats = new ArrayList<>();
        ArrayList<String> characterInventory = new ArrayList<>();
        // REQ!! FUNCTION- function to let the user create their charater, add this
        // character to an array and import it to a text file then display the text file
        createAndDisplayCharacter(scanner, characterDetails, characterStats);

        // Function that runs through the game and the other to display your inventroy
        // at the end
        battlePlay(scanner, characterStats, characterInventory);
        saveInventory(characterInventory);

    }

    /*
     * BattlePlay function runs through if statements to let the user pick their
     * course.
     * depending on what they pick they are taken through an adventure that calls
     * other functions
     * to battle creatures or pick items up. Each path has a different story ending.
     */

    public static void battlePlay(Scanner scanner, ArrayList<Integer> characterStats,
            ArrayList<String> characterInventory) {

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
                int spiderHp = new Random().nextInt((30 - 5) + 1) + 5;
                spiderEncounter(scanner, characterHp, characterDamage, characterInventory, spiderHp);
                System.out.println(
                        "After the spider encounter you decide to play it safe and stay away from the trees. You make your way to the stream but end up encountering a sleeping siren! Do you want to (1) Fight or (2) Run?");
                int choice2 = Integer.parseInt(scanner.nextLine());
                if (choice2 == 1) {
                    int sirenHP = new Random().nextInt((30 - 10) + 1) + 10;
                    sirenEncounter(scanner, characterHp, characterDamage, characterInventory, sirenHP);

                    System.out.println(
                            "You get across the siren and walk along the river for a while. You find a pile of rare seeds. Do you 1: Pick them up or 2: Keep going?");
                    int choice3 = Integer.parseInt(scanner.nextLine());
                    if (choice3 == 1) {

                        itemFound(scanner, characterInventory, characterHp, characterDamage);
                        System.out.println(
                                "After seeing the seeds you keep walking. you trip and hit your head super hard.");
                        System.out.println(
                                "All of the sudden you are waking up in an amazingly comfy bed. You find out you have been asleep for 10 days after battling creatures on an incredible journey!");

                    } else {
                        System.out.println(
                                "You decide to keep walking. You come across a ladder that leads up to a tree house.");
                        System.out.println(
                                "You go up the ladder to the treehouse. You open the door and there is an awesome dance party happening with all your wizard and werewolf friend!");

                    }

                } else {
                    System.out.println("You tip toed across the sleeping siren without waking her.");

                    System.out.println(
                            "You get across the siren and walk along the river for a while. You find a pile of rare seeds. Do you 1: Pick them up or 2: Keep going?");
                    int choice3 = Integer.parseInt(scanner.nextLine());
                    if (choice3 == 1) {

                        itemFound(scanner, characterInventory, characterHp, characterDamage);
                        System.out.println(
                                "After seeing the seeds you continue on your journey. You run into a lamp and after rubbing it a genie comes out!!");
                        System.out.println(
                                "You hurry and wish for 3 things. 1. An unlimited supply of Takis, 2. A pet sloth and 3. the power to fly!!");

                    } else {
                        System.out.println(
                                "You decide to keep walking. In the distance you see a empty house and walk into it.");
                        System.out.println(
                                "You walk in and take a step. All of the sudden you start falling!! you keep falling for what feels like forever until you land on a fluffy pillow. You end up in a room of trampolines! so much fun");

                    }

                }

            } else {
                System.out.println("You succesfully outran the Vampire spider.");
                System.out.println(
                        "After the spider encounter you decide to play it safe and stay away from the trees. You make your way to the stream but end up encountering a sleeping siren! Do you want to (1) Fight or (2) Run?");
                int choice2 = Integer.parseInt(scanner.nextLine());
                if (choice2 == 1) {
                    int sirenHP = new Random().nextInt((30 - 10) + 1) + 10;
                    sirenEncounter(scanner, characterHp, characterDamage, characterInventory, sirenHP);

                    System.out.println(
                            "You get across the siren and walk along the river for a while. You find a pile of rare seeds. Do you 1: Pick them up or 2: Keep going?");
                    int choice3 = Integer.parseInt(scanner.nextLine());
                    if (choice3 == 1) {

                        itemFound(scanner, characterInventory, characterHp, characterDamage);
                        System.out.println(
                                "After seeing the seeds you keep walking along. You run into a pile of kittens with a note that says free please help!");
                        System.out.println(
                                "You hurry and toss all of the kittens into your backback. You rush home to get them food and water. You now have 10 cats.");

                    } else {
                        System.out.println(
                                "You decide to keep walking. In the distance you see a empty cottage and walk into it.");
                        System.out.println(
                                "You open the cottage door to reveal a beautiful city with chocolate river, candycane trees and cotton candy grass. You have never been so happy in your life.");

                    }
                } else {
                    System.out.println("You quietly snuck past the sleeping siren");

                    System.out.println(
                            "You get across the siren and walk along the river for a while. You find a pile of rare seeds. Do you 1: Pick them up or 2: Keep going?");
                    int choice3 = Integer.parseInt(scanner.nextLine());
                    if (choice3 == 1) {

                        itemFound(scanner, characterInventory, characterHp, characterDamage);
                        System.out.println(
                                "After seeing the seeds you keep walking along the water. You trip and fall into the water!! ");
                        System.out.println(
                                "All of the sudden your grow a beautiful mermaid tail and can talk to animals!! You swim you way all the water to the ocean and live happy among other sea creatures.");

                    } else {
                        System.out.println(
                                "You decide to keep walking. In the distance you see a random door but it appears nothing is behind it. You go to open the door. ");
                        System.out.println(
                                "You open the door and there is a secret meadow behind it with fruit trees and baskets of the ripest strawberries you have ever seen. This is your new favorite place.");
                    }

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

    /*
     * ITEM FOUND FUNCTION:
     * this function picks a random number between 1 and two and then goes into a
     * path based on that number.
     * This way the path is random and the user can maybe participate.
     */
    public static void itemFound(Scanner scanner, ArrayList<String> characterInventory, int characterHp,
            int characterDamage) {

        int randomPath = new Random().nextInt(2) + 1;
        if (randomPath == 1) {
            System.out
                    .println("OH NO!! It was a trap and giant rattlesnake jumps at you! will you 1: fight or 2: run?");
            int choice4 = Integer.parseInt(scanner.nextLine());
            if (choice4 == 1) {
                int snakeHp = new Random().nextInt((20 - 10) + 1) + 10;
                snakeEncounter(scanner, characterHp, characterDamage, characterInventory, snakeHp);

            } else {
                System.out.println("You got away successfully and ");
                int randomAmount = new Random().nextInt(20) + 1;
                String specialSeeds;
                if (randomAmount == 1) {
                    specialSeeds = randomAmount + " magic seeds";
                } else {
                    specialSeeds = randomAmount + " magic seeds";
                }
                characterInventory.add(specialSeeds);

                System.out
                        .println("You picked up: "
                                + specialSeeds);
                System.out
                        .println(" ");

            }

        } else {
            int randomAmount = new Random().nextInt(20) + 1;
            String specialSeeds;
            if (randomAmount == 1) {
                specialSeeds = randomAmount + " seeds";
            } else {
                specialSeeds = randomAmount + " seeds";
            }
            characterInventory.add(specialSeeds);

            System.out
                    .println("You picked up: "
                            + specialSeeds);
            System.out
                    .println(" ");

        }

    }

    /*
     * ENCOUNTER FUNCTIONS!!!
     * all the encounter functions are very similar. The set an attach amount for
     * that creature and then
     * pick a random number to determine the path for the user. Based on that the
     * creature or the user take damage
     * until the creature is defeated and the user can pick up an item. They can
     * also run at any point but might not
     * be able to escape
     */
    public static void snakeEncounter(Scanner scanner, int characterHp, int characterDamage,
            ArrayList<String> characterInventory, int snakeHP) {
        int snakeAttack = new Random().nextInt((40 - 20) + 1) + 20;
        int randomPath = new Random().nextInt(2) + 1;
        if (randomPath == 1) {
            System.out.println("The snake gets a nasty bite in. You can feel its venmo flowing through you.");
            characterHp -= snakeAttack;
            System.out.println("You now have: " + characterHp + " Health");
            System.out.println("Its coiling up to attack again. Do you 1: fight back or 2: run for help?");
            int path = Integer.parseInt(scanner.nextLine());
            if (path == 1) {
                snakeEncounter(scanner, characterHp, characterDamage, characterInventory, snakeHP);
            } else {
                randomPath = new Random().nextInt(2) + 1;
                if (randomPath == 1) {
                    System.out.println("You successfully got away from the snake!");
                } else {
                    System.out.println("Oh no you could NOT you were not fast enough!");
                    snakeEncounter(scanner, characterHp, characterDamage, characterInventory, snakeHP);
                }

            }
        } else {
            snakeHP -= characterDamage;
            System.out.println(
                    "You got to the snake first and were able to do some damage. The snakes health is now " + snakeHP);

            if (snakeHP > 0) {
                System.out.println(
                        "Wait! The snake is still alive and wants to keep fighting!! Would you like to (1) fight or (2) run?");
                int path = Integer.parseInt(scanner.nextLine());

                if (path == 1) {
                    snakeEncounter(scanner, characterHp, characterDamage, characterInventory, snakeHP);
                } else {
                    randomPath = new Random().nextInt(2) + 1;
                    if (randomPath == 1) {
                        System.out.println(
                                "You have never ran so fast in your life! You were able to get away from the snake.");
                    } else {
                        System.out.println("You were too slow!");
                        snakeEncounter(scanner, characterHp, characterDamage, characterInventory, snakeHP);
                    }
                }
            } else {
                int randomAmount = new Random().nextInt(7) + 1;
                String snakeRattler;
                if (randomAmount == 1) {
                    snakeRattler = randomAmount + " snake rattle";
                } else {
                    snakeRattler = randomAmount + " snake rattles";
                }
                characterInventory.add(snakeRattler);

                System.out
                        .println("Congrats! You successfully defeated the Rattlesnake. You picked up: "
                                + snakeRattler);
                System.out
                        .println(" ");

            }
        }

    }

    public static void sirenEncounter(Scanner scanner, int characterHp, int characterDamage,
            ArrayList<String> characterInventory, int sirenHP) {
        int sirenAttack = new Random().nextInt((30 - 5) + 1) + 5;
        int randomPath = new Random().nextInt(2) + 1;
        if (randomPath == 1) {
            System.out.println("Oh no! The siren burst into music and it damages you.");
            characterHp -= sirenAttack;
            System.out.println("You now have: " + characterHp + " Health");
            System.out.println("She looks ready for round 2... Would you like to (1) fight or (2) run?");
            int path = Integer.parseInt(scanner.nextLine());
            if (path == 1) {
                sirenEncounter(scanner, characterHp, characterDamage, characterInventory, sirenHP);
            } else {
                randomPath = new Random().nextInt(2) + 1;
                if (randomPath == 1) {
                    System.out.println("You got away before the siren could attack again!!");
                } else {
                    System.out.println("Oh no you could NOT you were not fast enough!");
                    sirenEncounter(scanner, characterHp, characterDamage, characterInventory, sirenHP);
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
                    sirenEncounter(scanner, characterHp, characterDamage, characterInventory, sirenHP);
                } else {
                    randomPath = new Random().nextInt(2) + 1;
                    if (randomPath == 1) {
                        System.out.println("You sprinted as fast as you could before the siren could get to you!");
                    } else {
                        System.out.println("Oh no you could NOT get away from the siren!");
                        sirenEncounter(scanner, characterHp, characterDamage, characterInventory, sirenHP);
                    }
                }
            } else {
                int randomAmount = new Random().nextInt(10) + 1;
                String sirenTears;
                if (randomAmount == 1) {
                    sirenTears = randomAmount + " siren tear";
                } else {
                    sirenTears = randomAmount + " siren tears";
                }
                characterInventory.add(sirenTears);

                System.out
                        .println("Congrats! You successfully defeated the sleeping siren. You picked up: "
                                + sirenTears);
                System.out
                        .println(" ");

            }
        }

    }

    public static void spiderEncounter(Scanner scanner, int characterHp, int characterDamage,
            ArrayList<String> characterInventory, int spiderHp) {

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
                spiderEncounter(scanner, characterHp, characterDamage, characterInventory, spiderHp);
            } else {
                randomPath = new Random().nextInt(2) + 1;
                if (randomPath == 1) {
                    System.out.println("You got away before the spider could attack again!!");
                } else {
                    spiderEncounter(scanner, characterHp, characterDamage, characterInventory, spiderHp);
                }

            }
        } else {
            spiderHp -= characterDamage;
            System.out.println("You got a gnarly hit on the vampire spider. Its health is now " + spiderHp);

            if (spiderHp > 0) {
                System.out.println("The vampire spider is still ALIVE!! Would you like to (1) fight or (2) run?");
                int path = Integer.parseInt(scanner.nextLine());

                if (path == 1) {
                    spiderEncounter(scanner, characterHp, characterDamage, characterInventory, spiderHp);
                } else {
                    randomPath = new Random().nextInt(2) + 1;
                    if (randomPath == 1) {
                        System.out.println("You got away before the spider could attack again!!");
                    } else {
                        spiderEncounter(scanner, characterHp, characterDamage, characterInventory, spiderHp);
                    }
                }
            } else {
                int randomAmount = new Random().nextInt(5) + 1;
                String vampSpider = (randomAmount > 1) ? randomAmount + " spider webs"
                        : randomAmount + " spider web";
                characterInventory.add(vampSpider);

                System.out
                        .println("Congrats! You successfully defeated the Vampire Spider. You picked up: "
                                + vampSpider);
                System.out
                        .println(" ");

            }
        }

    }

    /*
     * CREATE AND DISPLAY CHARACTER FUNCTION
     * this function is used to ask for the users input in determining their
     * character.
     * If they pick werewolf they have a slightly elevated health but do less
     * damage. Adds what they
     * pcik to the characterdetails and characterstats arrayto be used later in the
     * game. Then it adds
     * this array to a text file an then reads that text file back to the user so
     * they can see their character
     */
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

    /*
     * SAVE CHARACTER
     * This function creates a new text file called characterinfo and adds each item
     * of the characterdetails
     * array to a new line on the text file to later be displayed for the user
     */
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

    /*
     * DISPLAY FILE NAME
     * this function gets the file name and displays each like of that file for the
     * user.
     */
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

    /*
     * SAVE INVENTORY
     * this function does the same thing as savecharacter but for the
     * characterinventory array instead.
     */

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
