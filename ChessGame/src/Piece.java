public abstract class Piece {

    private boolean isWhitePiece;
    private boolean killed = false;
    private MovementStrategy movementStrategy;
    public Piece(boolean isWhitePiece){
        this.isWhitePiece = isWhitePiece;
        this.movementStrategy = movementStrategy;
    }

    public boolean isWhitePiece() {
        return isWhitePiece;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed){
        this.killed = killed;
    }

    public boolean canMove(Board board, Cell startBlock, Cell endBlock){
        return movementStrategy.canMove(board, startBlock, endBlock);
    }
}
