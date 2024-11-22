
// Jag använder en array för bräda och den här klassen gör ett 3x3-spelbräde med 9 rutor.
public class Board {
    private char[] board;

    // Skapa en array med bräda 9 (för de 9 rutorna)
    public Board() {
        board = new char[9];
        initializeBoard();
    }

    //Här fyller vi brädet med siffrorna 1 till 9.
    //Det gör det enkelare, att välja vilken ruta de vill placera sina markeringar på.
    private void initializeBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = (char) ('1' + i);
        }
    }

    // Den här metoden skriver ut brädan i konsolen i en snyggt formaterad 3x3 layout.
    public void printBoard() {
        System.out.println("-----------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i * 3 + j] + " | ");
            }
            System.out.println("\n-----------");
        }
    }

    // Kontrollera om den nuvarande spelaren har vunnit
    public boolean checkWinner(char currentPlayer) {
        // Kontrollera raderna
        for (int i = 0; i < 3; i++) {
            if (board[i * 3] == currentPlayer && board[i * 3 + 1] == currentPlayer && board[i * 3 + 2] == currentPlayer) {
                return true;
            }
        }

        // Kontrollera kolumner
        for (int i = 0; i < 3; i++) {
            if (board[i] == currentPlayer && board[i + 3] == currentPlayer && board[i + 6] == currentPlayer) {
                return true;
            }
        }

        // Kontrollera diagonaler
        if (board[0] == currentPlayer && board[4] == currentPlayer && board[8] == currentPlayer) {
            return true;
        }
        if (board[2] == currentPlayer && board[4] == currentPlayer && board[6] == currentPlayer) {
            return true;
        }
       // om någon lyckas få tre i rad så returnerar den till true
        return false;
    }

    // Kontrollera om bräda är fullt
    public boolean isBoardFull() {
        for (int i = 0; i < 9; i++) {
            if (board[i] != 'X' && board[i] != 'O') {
                return false;  // Om det finns en ledig ruta
            }
        }
        return true;
    }

    // Placera spelarens symbol(markering) på brädan
    public void placeMark(int position, char symbol) {
        board[position - 1] = symbol;  // Det är -1 eftersom arrayindex börjar på 0.
    }

    // Kontrollerar om en ruta är tom eller inte
    public boolean isCellEmpty(int position) {
        return board[position - 1] != 'X' && board[position - 1] != 'O';  // Kolla om det är en tom ruta
    }
}
