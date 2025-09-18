import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== TIC TAC TOE GAME ===");

        // Create game with custom board size
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter board size (e.g., 3 for 3x3): ");
        int boardSize = scanner.nextInt();

        TicTacToeGame game = TicTacToeGameFactory.createGame(GameType.STANDARD, boardSize);

        // Add observer
        IObserver notifier = new ConsoleNotifier();
        game.addObserver(notifier);

        // Create players with custom symbols
        Player player1 = new Player(1, "Praveenkumar", new Symbol('X'));
        Player player2 = new Player(2, "Akash", new Symbol('O'));

        game.addPlayer(player1);
        game.addPlayer(player2);

        // Play the game
        game.Play();

        scanner.close();

    }
}