//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player1", true);
        Player player2 = new Player("Player2", false);

        ChessGame chessgame = new ChessGame(player1, player2);

        chessgame.Play();
    }
}