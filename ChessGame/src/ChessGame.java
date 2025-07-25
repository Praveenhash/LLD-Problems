import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChessGame implements BoardGames {

    private Board board;
    private Player player1;
    private Player player2;
    boolean isWhiteTurn;
    private List<Move> gameLog;
    private Status status;

    public ChessGame(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.board = Board.getInstance(8);
        this.isWhiteTurn = true;
        this.status = Status.ACTIVE;
        this.gameLog = new ArrayList<>();
    }

    public void Play(){
        Scanner scanner = new Scanner(System.in);
        while(this.status == Status.ACTIVE){
            Player currentPlayer = isWhiteTurn ? player1 : player2;
            System.out.println(currentPlayer.getName()+"'s turn ("+(currentPlayer.isWhiteSide() ? "White" : "Black")+")");

            // Ask user for source coordinates
            System.out.print("Enter source row and column (e.g., 6 4): ");
            int startRow = scanner.nextInt();
            int startCol = scanner.nextInt();

            // Ask user for destination coordinates
            System.out.print("Enter destination row and column (e.g., 4 4): ");
            int endRow = scanner.nextInt();
            int endCol = scanner.nextInt();

            // Get the start and end cells from the board
            Cell startcell = board.getCell(startRow, startCol);
            Cell endCell = board.getCell(endRow, endCol);

            if(startcell == null || startcell.getPiece() == null){
                System.out.println("Invalid move: no piece at source cell.");
                continue;
            }

            makeMove(new Move(startcell, endCell), currentPlayer);
        }
    }

    public void makeMove(Move move, Player player){
        if(move.isValid()){
            Piece sourcePiece = move.getStartCell().getPiece();
            if(sourcePiece.canMove(this.board, move.getStartCell(), move.getEndCell())){
                Piece destinationPiece = move.getEndCell().getPiece();
                if(destinationPiece != null){
                    if(destinationPiece instanceof  King && isWhiteTurn){
                        this.status = Status.WHITE_WIN;
                        return;
                    }
                    if(destinationPiece instanceof King && !isWhiteTurn){
                        this.status = Status.BLACK_WIN;
                        return;
                    }
                    destinationPiece.setKilled(true);
                }
                gameLog.add(move);
                move.getEndCell().setPiece(sourcePiece);
                move.getStartCell().setPiece(null);
                isWhiteTurn = !isWhiteTurn;
            }
        }
    }
}
