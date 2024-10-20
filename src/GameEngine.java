/**
 * This task was created by Niv Seker (https://github.com/sekerniv)
 *
 * For any questions or further assistance, feel free to reach out!
 */

// Leave this import as it is. You'll need it
import assignmentfiles.*;
public class GameEngine {
    private String targetWord;
    private int attemptsLeft;
    private boolean isWin;

    public GameEngine(String targetWord) {
        this.targetWord = targetWord;
        this.attemptsLeft = 6;
    }


    public static void main(String[] args) {
        WordLoader wordLoader = new WordLoader();
        String word = wordLoader.getRandomWord();
        GameEngine Ge = new GameEngine(word);
        GameUI Gui = new GameUI();
        while (!Ge.isGameOver()) {
             word = Gui.readUserGuess();
            String play = Ge.playGuess(word);
            System.out.println(play);
        }
        if (Ge.isWin()) {
            Gui.displayWin();
        } else
            Gui.displayLoss(word);
    }


    /**
     * Compares the player's guess to the target word and returns feedback.
     * For each character in the guess:
     * - '*' if the character is in the correct position.
     * - '+' if the character is in the target word but in the wrong position.
     * - '-' if the character is not in the target word.
     * <p>
     * The comparison is done up to the length of the shorter word, ignoring any extra characters.
     * Example:
     * targetWord = "taper", guess = "water"
     * Returns: "-+*"
     **/
    public static String evaluateGuess(String targetWord, String guess) {
        String wordoutput = "";
        for (int i = 0; i < guess.length(); i++) {
            if (targetWord.indexOf(guess.charAt(i)) == -1) {
                wordoutput += '-';
            } else if (guess.charAt(i) == targetWord.charAt(i)) {
                wordoutput += "*";
            } else {
                wordoutput += "+";
            }
        }
        return wordoutput;
    }

    public boolean isGameOver() {
        if (this.isWin || this.attemptsLeft == 0) {
            return true;
        } else
            return false;
    }

    public String playGuess(String guess) {
        this.attemptsLeft -= 1;
        if (this.targetWord.equals(guess)) {
            this.isWin = true;
        }
        return evaluateGuess(targetWord, guess);
    }

    public boolean isWin() {
        return isWin;
    }

    public String getTargetWord() {
        return this.targetWord;
    }

    public int getAttemptsLeft() {
        return this.attemptsLeft;
    }
}