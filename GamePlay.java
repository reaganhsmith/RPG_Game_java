import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class GamePlay {
    public static void main(String[] args){

        Random random = new Random();

        System.out.println(" ");
        System.out.println("Hello World!! Welcome to a very fun adventure game!");
        System.out.println(" ");

        String gameInstructions = "For this game you get to design your own character and go through battles and follow a fun story line";

        System.out.println(gameInstructions);
        System.out.println(" ");


        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> Character = new ArrayList<String>();
        
        System.out.print("Player Hair color: ");
        String hairColor = "Hair color: " + scanner.nextLine();
        Character.add(hairColor);

        System.out.print("Player hairstyle: ");
        String hairStyle = "Hair style: " + scanner.nextLine();
        Character.add(hairStyle);

        System.out.print("wizard or wareworlf: ");
        String wizardOrNot = scanner.nextLine().toUpperCase();
        Character.add("You are a: " + wizardOrNot);



        if("wizard".equalsIgnoreCase(wizardOrNot)){
            int randomHP = random.nextInt((100 - 80) + 1) + 80;
            String characterHP = "Your health: " + randomHP;
            Character.add(characterHP);

            int randomDamage = random.nextInt((30 - 5) + 1) + 5;
            String powers = "You know magic spells and do " + randomDamage + " damage per spell cast.";
            Character.add(powers);

            
        } else{
            int randomHP = random.nextInt((100- 80) + 1) + 80;
            String characterHP = "Your health: " + randomHP;
            Character.add(characterHP);

            int randomDamage = random.nextInt((30 - 5) + 1) + 5;
            String powers = "You have a narly bite and scratch. You do " + randomDamage + " damage per attack.";
            Character.add(powers);

            
            
        }
        System.out.println(" ");
        saveCharacter(Character);
        displayCharacterFromFile();
        System.out.println(" ");


 
       scanner.close();
    }
    @SuppressWarnings("unused")
    private static void saveCharacter(ArrayList<String> Character) {
        // Specify the directory and file name
        String directoryPath = ".";
        String fileName = "CharacterInfo.txt";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(directoryPath, fileName)))) {
            for (String line : Character) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    private static void displayCharacterFromFile() {
        System.out.println("Your character: ");

        String infoPath = "CharacterInfo.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(infoPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line as needed
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(" ");
    }
}
