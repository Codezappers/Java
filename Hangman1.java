package Source Code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Hangman1 {
    public static void main(String args[]) throws FileNotFoundException {
        // TODO code application logic here
       List<String> words = new ArrayList<>();
       Scanner scanner = new Scanner(new File("D:\\Kashan\\Documents\\MEGA\\Red Deer Polytech\\Game Programming\\hangman\\words_alpha.txt"));
       Scanner keyboard = new Scanner(System.in);
       while (scanner.hasNext())
       {
          // System.out.println(scanner.nextLine());
          words.add(scanner.nextLine());
       }
       
       Random rand = new Random();
       
       String word = words.get(rand.nextInt(words.size()));
       
       System.out.println(word);
       
       List<Character> playerGuesses = new ArrayList<>();
       
       printWordState(word, playerGuesses);
                
       getPlayerGuess(keyboard, playerGuesses, word);
       
    }

    private static void getPlayerGuess(Scanner keyboard, List<Character> playerGuesses, String word) {
        System.out.println("Please enter a letter");
        String letterGuess = keyboard.nextLine();
        playerGuesses.add(letterGuess.charAt(0));
        
        printWordState(word, playerGuesses);
    }

    private static void printWordState(String word, List<Character> playerGuesses) {
        for (int i =0;i< word.length();i++)
        {
            if (playerGuesses.contains(word.charAt(i)))
            {
                System.out.print(word.charAt(i));
            }
            else
            {
                System.out.print("-");
            }
        }
       System.out.println();
    }
}