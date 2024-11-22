import java.util.Scanner;
import java.util.Random;

//Här deklarerar vi fyra variabler.
public class TicTacToe {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;  // Håller reda på vilken spelare som ska spela


    // Konstruktor för att starta bräda, ber spelarna ange namn.
    // Väljer även en slumpmäässig spelare för att börja med.
    public TicTacToe() {
        board = new Board();  // Skapa brädet
        Scanner scanner = new Scanner (System.in);
        System.out.println("Ange förnamn för spelare (X)");

        String player1Name = scanner.nextLine();
        player1 = new Player('X', player1Name);  // Första spelaren är X

        System.out.println("Ange förnamn för spelare (O)");
        String player2Name = scanner.nextLine();
        player2 = new Player( 'O', player2Name);  // Andra spelaren är O

        // currentPlayer = player1;  // Börja med att spela X

        Random rand = new Random(); // Slumpa startspelare
        currentPlayer = (rand.nextInt(2) == 0) ? player1 : player2;  // Välj slumpmässigt mellan player1 och player2
    }




// Den skriver ut bräda, spelaren spelar,
// kollar om någon vunnit eller om det är fullt
// och byter spelare. om spelet är slut  frågar den om man vill spela igen.

    // Huvudmetod för att spela spelet
    public void play() {
        while (true) {
            board.printBoard();  // Skriv ut brädet
            makeMove();  // Låt spelaren göra sitt drag

            // Kontrollera om någon har vunnit
            if (board.checkWinner(currentPlayer.getSymbol())) {
                board.printBoard();
                System.out.println("Spelare " + currentPlayer.getSymbol() + " har vunnit!");
                break;  // Avsluta spelet
            }

            // Kontrollera om brädet är fullt
            if (board.isBoardFull()) {
                board.printBoard();
                System.out.println("Spelet är oavgjort!");
                break;  // Avsluta spelet
            }
            switchPlayer();  // Byt spelare
        }

        // Fråga om spelarna vill spela igen
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vill du spela igen? (ja/nej): ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("ja")) {
            board = new Board();  // Återställ brädet för ett nytt spel
            play();  // Starta om spelet
        } else {
            System.out.println("Tack för att du spelade!");
        }
    }



    // Den här metoden hanterar inmatningen av spelarens markering.
    // Den ser till att spelaren anger en giltig position och
    // att rutan är ledig innan markeringen placeras.
    private void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int position = -1;

        while (true) {
            System.out.print("Spelare: " + currentPlayer.getName() + ", Symbol: " + currentPlayer.getSymbol() + ", välj en ledig position (1-9): ");
            // position = scanner.nextInt();  // Spelaren anger en position mellan 1 och 9
            String input = scanner.nextLine();
        // Jag använde try catch för att när man skriver bokstäver istället för siffror
        // så ska den inte krocka med koden.
            try {
                position = Integer.parseInt(input);  // Försök att konvertera strängen till en int

                // Kontrollera att positionen är mellan 1 och 9 och att den är ledig
                if (position >= 1 && position <= 9 && board.isCellEmpty(position)) {
                    board.placeMark(position, currentPlayer.getSymbol());  // Placera spelarens symbol på brädet
                    break;  // Avsluta loopen när draget är gjort
                } else {
                    System.out.println("Ogiltigt drag. Försök igen.");
                }
            } catch (NumberFormatException e) {
                // Om användaren skriver något som inte är en siffra, fånga felet och ge ett meddelande
                System.out.println("Felaktig inmatning! Du måste ange en siffra mellan 1 och 9.");
            }
        }
    }

    // Metod för att byta spelare
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;  // Byt spelare
    }
}
