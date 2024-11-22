public class Player {
    private char symbol; // Player1 och player2 symbol (X eller O)
    private String name; // namn för att registrera i spelet.

    // Konstruktor för spelarens symbol och namn
    public Player(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }
    // Hämtar player symbol
    public char getSymbol() {
        return symbol;
    }
    // Hämtar player namn
    public String getName() {
        return name;
    }
}
