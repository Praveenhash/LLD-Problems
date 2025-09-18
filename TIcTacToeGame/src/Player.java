public class Player {
    private String name;
    private int id;
    private int score;
    private Symbol symbol;

    public Player(int id, String name, Symbol symbol){
        this.id=id;
        this.name=name;
        this.symbol=symbol;
        this.score=0;
    }
    // Getters and setters
    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }
}
