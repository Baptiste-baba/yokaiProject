import java.util.*;

public class Yokai {
    
    private Player currentPlayer;
    private Player player1;
    private Player player2;

    public Yokai (Player currentPlayer, Player player1, Player player2) {
        this.currentPlayer = currentPlayer;
        this.player1 = player1;
        this.player2 = player2;
    }

    int n = 6;
    List<Player> players = new ArrayList<>();
    int turn = 0;
    Cases[][] cardBoard = new Cases[n][n];
    Cases[][] clueBoard = new Cases[n][n];
    Stack<String> clueStack = new Stack<>();
    List<String> drawClueList = new ArrayList<>();

    public void play() {
        while (true) {
            createPlayers();
            /* initialiseBoard();
            while (!isPartyOver()) {
                printBoard();
                String move;
                do {
                    move = askMove();
                }
                while (!isValidMove(move));
                updateBoard(move);
                switchPlayer();
            }
            */
        }
    }

    public void createPlayers() {
        Scanner scanner = new Scanner(System.in);

        int nbplayers;
        System.out.println("Combien de joueurs y aura t-il ?");
        nbplayers = scanner.nextInt();
        if (nbplayers <= 4) {
                    
            final Player player1 = new Player();
            System.out.println("Comment s'appelle le joueur commençant la partie?");
            player1.setName(scanner.nextLine());
            
            final Player player2 = new Player();
            System.out.println("Comment s'appelle le second joueur ?");
            player2.setName(scanner.nextLine());

            if (nbplayers >= 4) {
                final Player player3 = new Player();
                System.out.println("Comment s'appelle le troixieme joueur ?");
                player3.setName(scanner.nextLine());
            }

            if (nbplayers == 4) {
                final Player player4 = new Player();
                System.out.println("Comment s'appelle le dernier joueur ?");
                player4.setName(scanner.nextLine());
            }
            currentPlayer = player1;


        } else {
            System.out.println("nombre de joueur invalide");

        }

        private void initialiseBoard() {
            int i = 0;
            int j = 0;
            board = new Cell[8][8];
     
            while (i < 8) {
                j = 0;
                while (j < 8) {
                    board[i][j] = new Cell(whichPiece(i, j));
                    j++;
                }
                i++;
            }
        }
             


        public static void isValidMove() {
            
        }

        public static void displayCards() {

        }
        
    }
}