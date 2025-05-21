package week_7.GuessGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuessingGame implements PlayableGame{
    Scanner scanner = new Scanner(System.in);
    private int randomNum;
    private int guessCount = 0;
    private List<Integer> previousGuess = new ArrayList<>();


    public GuessingGame() {
        this.randomNum = (int) (Math.random() * 100) + 1;
    }

    @Override
    public void startGame() {
        System.out.println("Welcome to the game!!\nPlease guess number from 1 - 100");

        while (true){
            int userGuess = Integer.parseInt(scanner.nextLine().trim());
            int differenceNumber = Math.abs(userGuess - randomNum);

            if (userGuess == randomNum) {
                System.out.println("🎉 Great guess!!! You got it right.");
                guessCount++;
                previousGuess.add(userGuess);
                System.out.println("It took you " + guessCount + " guesses to get the right number");
                break;
            } else if (differenceNumber >= 75) {
                System.out.println("❌ Too far: at least 75 points difference");
            } else if (differenceNumber >= 50) {
                System.out.println("😬 Still far: at least 50 points difference");
            } else if (differenceNumber >= 25) {
                System.out.println("🙂 Closer: at least 25 points difference");
            } else if (differenceNumber >= 10) {
                System.out.println("🤏 Very close: less than 25 points difference");
            } else {
                System.out.println("🔥 Super close: less than 10 points difference");
            }

            guessCount++;
            previousGuess.add(userGuess);

        }
        for (Integer i: previousGuess){
            System.out.println(i);
        }

    }
}
