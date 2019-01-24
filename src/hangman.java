import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class hangman {
    public static void main(String[] args) {
        Scanner inputFile;
        try {
             inputFile = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("FIlen finns inte använd tgb istället");
            inputFile = new Scanner(System.in);
        }

        ArrayList<String> wordList = new ArrayList<>();

        while (inputFile.hasNextLine()) {
            wordList.add(inputFile.nextLine());
        }

        Math.random();
        Random R = new Random();
        int wordIndex = R.nextInt(wordList.size());
        String correctWord = wordList.get(wordIndex);
        System.out.println(correctWord);

        System.out.println("Gissa ordet");
        char[] letters = correctWord.toCharArray();
        char[] guessedLetters = new char [correctWord.length()];
        int i;
        for (i=0; i<guessedLetters.length; i++){
            guessedLetters[i] = '\u005F';
        }
        System.out.println(guessedLetters);
        String[] state = {"  ---| \n" +
                          "  |  o \n",
                          "  |    \n",
                          ""};
        int lives =state.length;
        while (lives>0){
        Scanner letterGuess = new Scanner(System.in);
            char guessAschar = letterGuess.nextLine().charAt(0);
            boolean found= false;
            System.out.println(lives);

            for (int n=0;n < letters.length; n++) {
                if (letters[n] == guessAschar) {
                    guessedLetters[n] = guessAschar;
                    found = true;

                }
                if (!found)
                    lives--;
                }
            }
    }
}
