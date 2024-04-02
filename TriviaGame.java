import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TriviaGame {

    public static void main(String[] args) {
        System.out.println("Welcome to Who Wants to Be a Millionaire!");
        System.out.println("You will be presented with a series of multiple-choice questions.");
        System.out.println("For each question, choose the correct answer to earn the corresponding prize money.");
        System.out.println("You have access to three lifelines to assist you:");
        System.out.println(
                "- 50/50: Removes two incorrect answers, leaving one incorrect answer and the correct answer.");
        System.out.println("- Phone a Friend: Get advice from a friend about the correct answer.");
        System.out.println("- Ask the Audience: Poll the audience for their opinion on the correct answer.");
        System.out.println(
                "Use these lifelines wisely to increase your chances of winning the ultimate prize of $1,000,000!\n");
        System.out.println("Let's get started!\n");

        Scanner scan = new Scanner(System.in);
        boolean fiftyFifty = false;
        boolean audiencePoll = false;
        List<Question> questions = new ArrayList<>();
        int playerPoints = 0;
        int[] prizeMoney = { 10, 100, 500, 1000, 5000, 10000, 25000, 50000, 750000, 1000000 };

        String filePath = "C:" + File.separator + "Users" + File.separator + "Aden" + File.separator +
                "OneDrive" + File.separator + "Desktop" + File.separator +
                "Game dev" + File.separator + "Source code triv" + File.separator +
                "AMN" + File.separator + "TriviaGame" + File.separator + "QUESTIONS.TXT";

        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine()) {
                String question = sc.nextLine();
                String firstAnswer = sc.nextLine();
                String secondAnswer = sc.nextLine();
                String thirdAnswer = sc.nextLine();
                String fourthAnswer = sc.nextLine();
                String correctAnswer = sc.nextLine();
                questions.add(new Question(question, firstAnswer, secondAnswer, thirdAnswer, fourthAnswer, correctAnswer));
            }

            for (int i = 0; i < questions.size(); i++) {
                Question q = questions.get(i);
                System.out.println(q.toString());
                boolean rightAnswer = false;
                while (true) {
                    System.out.println("Your lifelines are: \n");
                    System.out.println("e) Audience Poll");
                    System.out.println("f) Fifty-Fifty");
                    System.out.println("g) Phone a Friend");
                    String answer = scan.next();
                    switch (answer.toLowerCase()) {
                        case "a":
                        case "b":
                        case "c":
                        case "d":
                            rightAnswer = answer.equals(q.getCorrectAnswer());
                            break;
                        case "e":
                            if (!audiencePoll) {
                                System.out.println("The public chose:");
                                Random rand = new Random();
                                int optionA = rand.nextInt(101);
                                int optionB = rand.nextInt(101 - optionA);
                                int optionC = rand.nextInt(101 - optionA - optionB);
                                int optionD = 100 - optionA - optionB - optionC;

                                System.out.println("Option A: " + optionA + "%");
                                System.out.println("Option B: " + optionB + "%");
                                System.out.println("Option C: " + optionC + "%");
                                System.out.println("Option D: " + optionD + "%");

                                System.out.println(q.toString());
                            }
                            continue;
                        case "f":
                            if (!fiftyFifty) {
                                List<String> allAnswers = new ArrayList<>(Arrays.asList(
                                        q.getFirstAnswer(),
                                        q.getSecondAnswer(),
                                        q.getThirdAnswer(),
                                        q.getFourthAnswer()));

                                Collections.shuffle(allAnswers);
                                allAnswers.subList(2, allAnswers.size()).clear();
                                System.out.println("The remaining options are: ");
                                for (int j = 0; j < allAnswers.size(); j++) {
                                    System.out.println((j + 1) + ") " + allAnswers.get(j));
                                }
                                continue;
                            }
                            break;
                        case "g":
                            System.out.println("Your friend says the answer is: " + q.getCorrectAnswer());
                            System.out.println(q.toString());
                            continue;
                    }
                    break;
                }

                if (rightAnswer) {
                    playerPoints += prizeMoney[i];
                    System.out.println("You got it right! You have " + playerPoints + "$\n");
                } else {
                    System.out.println("Sorry, that was incorrect! You won " + playerPoints + "$\n");
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        writePointsToFile(playerPoints);
        scan.close();
    }

    private static void writePointsToFile(int playerPoints) {
        try (FileWriter writer = new FileWriter("Winner.txt")) {
            writer.write("Player won: " + playerPoints + "$");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
