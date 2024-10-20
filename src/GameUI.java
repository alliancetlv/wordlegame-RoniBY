import java.util.Scanner;
public class GameUI {
    private Scanner sc;

    public GameUI (){
        this.sc = new Scanner(System.in);
    }

    public String readUserGuess (){
        return sc.next();
    }

    public String displayResult(GameEngine gameEngine) {
        String guess = readUserGuess();
        String feedback = GameEngine.evaluateGuess(gameEngine.getTargetWord(), guess);
        return "You have " + gameEngine.getAttemptsLeft() + " attempts left. Your guess: " + guess + ". Feedback: " + feedback;
    }
    public void displayWin (){
        System.out.println("Congratulations, YOU WIN!");
    }
    public void displayLoss (String targetWord){
        System.out.println("Game over! The word was: " + targetWord);
    }
}