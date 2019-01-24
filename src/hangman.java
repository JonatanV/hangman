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

        System.out.println("Gissa ordet");
        char[] letters = correctWord.toCharArray();
        char[] guessedLetters = new char [correctWord.length()];
        int i;
        for (i=0; i<guessedLetters.length; i++){
            guessedLetters[i] = '\u005F';
        }
        for (i=0; i<guessedLetters.length; i++){
                System.out.print(" " + guessedLetters[i]);
        }
        //        System.out.println(guessedLetters);

        String[] state = {"  ---|  \n" +
                          "  |  o  \n",
                          "  | /| \\ \n",
                          "  | / \\ \n",
                          " /-\\   \n",
                          ""};
        int lives =state.length;
        int score= 0;
        while (lives>0 && score<correctWord.length()){
        Scanner letterGuess = new Scanner(System.in);
            char guessAschar = letterGuess.nextLine().charAt(0);
            boolean found= false;

            for (int n=0;n < letters.length; n++) {
                if (letters[n] == guessAschar) {
                    guessedLetters[n] = guessAschar;
                    found = true;
                    score++;
                }
            }
            for (i=0; i<guessedLetters.length; i++) {
                System.out.print(" " + guessedLetters[i]);
            }

            if (!found) {
                lives--;
            }
            System.out.println("\n"+lives);

        }

        if(lives<1){
            System.out.println("Du förlorade försök igen");

        } else {
            System.out.println("Du Klarade det ordet var "+ correctWord);
        }
    }
}
