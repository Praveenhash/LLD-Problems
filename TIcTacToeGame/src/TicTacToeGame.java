import java.util.*;

public class TicTacToeGame {
    private Board board;
    private Deque<Player> players;
    private TicTacTOeRules rules;
    private List<IObserver> observers;
    private boolean gameOver;

    public TicTacToeGame(int size){
        board = new Board(size);
        players = new ArrayDeque<>();
        rules = new StandardTicTacToeRules();
        observers = new ArrayList<>();
        gameOver = false;
    }
    public void addPlayer(Player player){
        players.addLast(player);
    }
    public void addObserver(IObserver observer){
        observers.add(observer);
    }
    public void notify(String message){
        for(IObserver observer : observers){
            observer.update(message);
        }
    }
    public void Play(){
        if(players.size() < 2) {
            System.out.println("Need at least 2 players!");
            return;
        }

        notify("Tic Tac Toe Game Started!");

        Scanner scanner = new Scanner(System.in);

        while(!gameOver){
            board.display();

            Player currentPlayer = players.peekFirst();
            System.out.print(currentPlayer.getName() + " (" + currentPlayer.getSymbol().getSymbol() + ") - Enter row and column: ");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // check if move is valid
            if(rules.isValidMove(board, row, col)) {
                board.placeMark(row, col, currentPlayer.getSymbol());
                notify(currentPlayer.getName() + " played (" + row + "," + col + ")");

                if(rules.checkWinCondition(board, currentPlayer.getSymbol())) {
                    board.display();
                    System.out.println(currentPlayer.getName() + " wins!");
                    currentPlayer.incrementScore();

                    notify(currentPlayer.getName() + " wins!");

                    gameOver = true;
                }
                else if(rules.checkDrawCondition(board)) {
                    board.display();

                    System.out.println("It's a draw!");
                    notify("Game is Draw!");

                    gameOver = true;
                }
                else {
                    // Move player to back of queue
                    players.removeFirst();
                    players.addLast(currentPlayer);
                }
            }
            else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }
}
