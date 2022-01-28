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
        createPlayers();
        gameBoard.initialiseBoard();
        placeCards(players.size());
        do {
            Turn();
            displayCards();
            displayCluesCards();
            showTwoCards();
            moveCard();
            displayCards();
            drawOneClueCard(clueStack);
        } while (endGame());
    }

    private void createPlayers() {
        players = new ArrayList<>();
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerLine = new Scanner(System.in);
        System.out.println("Veuillez entrer le nombre de joueurs");
        int playerNumber = scannerInt.nextInt();
        System.out.println();
        for (int i = 0; i < playerNumber; i++) {
            System.out.println("Nom du joueur " + (i + 1));
            players.add(new Player(scannerLine.nextLine()));
        }
        System.out.println();
    }

    private void Turn() {
        System.out.println("Au tour de : " + players.get(turn).getName() + "\n");
        if (turn < players.size() - 1) {
            turn += 1;
        } else {
            turn = 0;
        }
    }

    protected static void Mix(char[] cardList) {
        Random random = new Random();
        for (int i = 0; i < cardList.length; i++) {
            int r = random.nextInt(cardList.length);
            char temp = cardList[i];
            cardList[i] = cardList[r];
            cardList[r] = temp;
        }
    }


    private void placeCards(int playerNumber) {

        String[] colorSet = {"R", "B", "P", "G"};
        List<String> colorList = new ArrayList<>(Arrays.asList(colorSet));

        List<String> duoColorList = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (i != j) {
                    duoColorList.add(colorSet[i] + colorSet[j]);
                }
            }
        }

        List<String> triColorList = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                for (int k = 0; k <= 3; k++) {
                    if (i != j && j != k && i != k) {
                        triColorList.add(colorSet[i] + colorSet[j] + colorSet[k]);
                    }
                }
            }
        }

        Collections.shuffle(colorList);
        Collections.shuffle(duoColorList);
        Collections.shuffle(triColorList);

        List<String> clueList = new ArrayList<>();

        switch (playerNumber) {
            case 2:
                for (int i = 0; i <= 6; i++) {
                    if (i <= 1) {
                        clueList.add(colorList.get(i));
                    } else if (i <= 4) {
                        clueList.add(duoColorList.get(i));
                    } else {
                        clueList.add(triColorList.get(i));
                    }
                }
                Collections.shuffle(clueList);
            case 3:
                for (int i = 0; i <= 8; i++) {
                    if (i <= 1) {
                        clueList.add(colorList.get(i));
                    } else if (i <= 5) {
                        clueList.add(duoColorList.get(i));
                    } else {
                        clueList.add(triColorList.get(i));
                    }
                }
                Collections.shuffle(clueList);
            case 4:
                for (int i = 0; i <= 9; i++) {
                    if (i <= 2) {
                        clueList.add(colorList.get(i));
                    } else if (i <= 6) {
                        clueList.add(duoColorList.get(i));
                    } else {
                        clueList.add(triColorList.get(i));
                    }
                }
                Collections.shuffle(clueList);
        }

        for (String s : clueList) {
            clueStack.push(s);
        }
    }

    private void displayCards() {
        System.out.println(" ".repeat(3 * (n / 2) - 4) + "[Card Board]" + " ".repeat(3 * (n / 2) - 4));
        System.out.println("╭ " + " ─ ".repeat(n) + " ╮");
        for (int i = 0; i < n; i++) {
            System.out.print("│  ");
            for (int j = 0; j < n; j++) {
                if (cardBoard[i][j] == null) {
                    System.out.print("·  ");
                } else {
                    yokaiCards card = cardBoard[i][j].getyokaiCards();
                    System.out.print(card.getCardName() + "  ");
                }
            }
            System.out.print("│");
            System.out.println();
        }
        System.out.println("╰ " + " ─ ".repeat(n) + " ╯");
        System.out.println();
    }

    private void displayCluesCards() {
        System.out.println(" ".repeat(3 * (n / 2) - 4) + "[Clue Board]" + " ".repeat(3 * (n / 2) - 4));
        System.out.println("╭ " + " ─ ".repeat(n) + " ╮");
        for (int i = 0; i < n; i++) {
            System.out.print("│  ");
            for (int j = 0; j < n; j++) {
                if (clueBoard[i][j] == null) {
                    System.out.print("·  ");
                } else {
                    cluesCards clue = clueBoard[i][j].getCluesCards();
                    System.out.print(clue.getClueName() + "  ");
                }
            }
            System.out.print("│");
            System.out.println();
        }
        System.out.println("╰ " + " ─ ".repeat(n) + " ╯");
        System.out.println();
    }

    private void showTwoCards() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer les coordonnées des deux cartes à regarder :");
        System.out.println();

        for (int i = 1; i <= 2; i++) {
            int x, y;
            do {
                System.out.println("Veuillez sélectionner des coordonnées valides pour la carte " + i);
                System.out.println("Coordonnées en x de la carte " + i + " :");
                x = scanner.nextInt();
                System.out.println("Coordonnées en y de la carte " + i + " :");
                y = scanner.nextInt();
            } while ((x >= n || y >= n) || cardBoard[x][y] == null);

            System.out.println("\nCarte " + i + " : " + cardBoard[x][y].getyokaiCards().getCardName());
            System.out.println();
        }
    }

    private void moveCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez les coordonnées de la carte à déplacer :");
        int x, y;

        do {
            System.out.println("\nVeuillez sélectionner des coordonnées valides pour la carte à déplacer :");
            System.out.println("Coordonnées en x de la carte :");
            x = scanner.nextInt();
            System.out.println("Coordonnées en y de la carte :");
            y = scanner.nextInt();
        } while ((x >= n || y >= n) || cardBoard[x][y] == null || clueBoard[x][y] != null);
        System.out.println();

        int i, j;
        boolean test;

        Cases temp = cardBoard[x][y];
        cardBoard[x][y] = null;
        displayCards();

        do {
            System.out.println("\nVeuillez sélectionner des coordonnées valides où déplacer la carte :\n");
            System.out.println("Coordonnées en x de la carte :");
            i = scanner.nextInt();
            System.out.println("Coordonnées en y de la carte :");
            j = scanner.nextInt();
            if (i < n && j < n) {
                if (cardBoard[i][j] == null) {
                    cardBoard[i][j] = temp;
                    cardBoard[i][j].setPosition(new Position(i, j));
                    cardBoard[i][j].getyokaiCards().setPosition(new Position(i, j));

                    test = (i >= n || j >= n) || isValidMove(cardBoard[i][j]);
                    if (test) {
                        cardBoard[i][j] = null;
                    }
                } else {
                    test = true;
                }
            } else {
                test = true;
            }
        } while (test);
    }

    private boolean isValidMove(Cases cell) {
        Position cellPosition = cell.getPosition();
        boolean gauche, droite, haut, bas;
        if (cellPosition.getRow() > 0) {
            haut = cardBoard[cellPosition.getRow() - 1][cellPosition.getColumn()] != null;
        } else {
            haut = false;
        }
        if (cellPosition.getColumn() > 0) {
            gauche = cardBoard[cellPosition.getRow()][cellPosition.getColumn() - 1] != null;
        } else {
            gauche = false;
        }
        if (cellPosition.getRow() < n - 1) {
            bas = cardBoard[cellPosition.getRow() + 1][cellPosition.getColumn()] != null;
        } else {
            bas = false;
        }
        if (cellPosition.getColumn() < n - 1) {
            droite = cardBoard[cellPosition.getRow()][cellPosition.getColumn() + 1] != null;
        } else {
            droite = false;
        }

        //System.out.println("gauche : " + gauche + " ,droite : " + droite + " ,haut : " + haut + " ,bas : " + bas);
        return (!(gauche || droite || haut || bas));
    }

    private void drawOneClueCard(Stack<String> clueStack) {
        Scanner scanner = new Scanner(System.in);
        String clueCard = clueStack.pop();
        System.out.println("\nIndice pioché : " + clueCard + "\n");
        System.out.println("Choisissez si vous voulez mettre l'indice de côté (tap 0) ou le jouer (tap 1)");
        int choice = scanner.nextInt();
        System.out.println();

        if (choice == 1) {
            System.out.println("Choisissez ou poser l'indice :\n");
            int x, y;

            do {
                System.out.println("Veuillez sélectionner des coordonnées valides pour l'indice à placer :\n");
                System.out.println("Coordonnées en x de la carte :");
                x = scanner.nextInt();
                System.out.println("Coordonnées en y de la carte :");
                y = scanner.nextInt();
            } while (((x >= n) || (y >= n)) || clueBoard[x][y] != null);

            Position positionClue = new Position(x, y);
            cluesCards card = new cluesCards(clueCard, positionClue);
            clueBoard[x][y] = new Cases(null, card, positionClue);

        } else {
            System.out.println("L'indice est mis sur le côté\n");
            drawClueList.add(clueCard);
            System.out.println("Liste des indices :\n");
            System.out.println(drawClueList + "\n");
        }
    }

    private boolean endGame() {
        Scanner scannerLine = new Scanner(System.in);
        System.out.println("Voulez vous déclarer que les Yokais sont apaisés ? (Y/N)\n");
        String choice = scannerLine.nextLine();
        if (choice.equals("Y") || clueStack.size() == 0) {
            if (verificationEndGame()) {
                System.out.println(countThePoints());
            }
            return false;
        } else {
            return true;
        }
    }

    private boolean verificationEndGame() {
        boolean win = true;
        boolean gauche, droite, haut, bas;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cardBoard[i][j] != null) {

                    if (i > 0) {
                        if (cardBoard[i - 1][j] != null) {
                            haut = cardBoard[i - 1][j].getyokaiCards().getCardName()
                                    == cardBoard[i][j].getyokaiCards().getCardName();
                        } else {
                            haut = false;
                        }
                    } else {
                        haut = false;
                    }

                    if (j > 0) {
                        if (cardBoard[i][j - 1] != null) {
                            gauche = cardBoard[i][j - 1].getyokaiCards().getCardName()
                                    == cardBoard[i][j].getyokaiCards().getCardName();
                        } else {
                            gauche = false;
                        }
                    } else {
                        gauche = false;
                    }

                    if (i < n - 1) {
                        if (cardBoard[i + 1][j] != null) {
                            bas = cardBoard[i + 1][j].getyokaiCards().getCardName()
                                    == cardBoard[i][j].getyokaiCards().getCardName();
                        } else {
                            bas = false;
                        }
                    } else {
                        bas = false;
                    }

                    if (j < n - 1) {
                        if (cardBoard[i][j + 1] != null) {
                            droite = cardBoard[i][j + 1].getyokaiCards().getCardName()
                                    == cardBoard[i][j].getyokaiCards().getCardName();
                        } else {
                            droite = false;
                        }
                    } else {
                        droite = false;
                    }

                    if (!(gauche || droite || haut || bas)) {
                        win = false;
                    }
                    //System.out.println("(" + i + "," + j + ") " + "gauche : " + gauche + " ,droite : " + droite + " ,haut : " + haut + " ,bas : " + bas);
                }
            }
        }
        if (win) {
            System.out.println("Victoire");
        } else {
            System.out.println("Défaite");
        }
        return win;
    }

    public int countThePoints() {
        int finalScore = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cardBoard[i][j] != null && clueBoard[i][j] != null) {
                    int count = 0;
                    for (int k = 0; k < clueBoard[i][j].getCluesCards().getClueName().length(); k++) {
                        if (cardBoard[i][j].getyokaiCards().getCardName() == clueBoard[i][j].getCluesCards().getClueName().charAt(k)) {
                            finalScore += 1;
                        } else {
                            count += 1;
                        }
                    }
                    if (count == clueBoard[i][j].getCluesCards().getClueName().length()) {
                        finalScore -= 1;
                    }
                }
            }
        }

        finalScore += 2*drawClueList.size();
        finalScore += 5*clueStack.size();

        System.out.println("Vôtre countThePoints : " + finalScore);

        System.out.println("\n Victoire : ");

        switch (players.size()) {
            case 2:
                if (finalScore <= 7) {
                    System.out.print("Honorable");
                } else if (finalScore <= 11) {
                    System.out.print("Glorieuse");
                } else {System.out.print("Totale");}
            case 3:
                if (finalScore <= 9) {
                    System.out.print("Honorable");
                } else if (finalScore <= 13) {
                    System.out.print("Glorieuse");
                } else {System.out.print("Totale");}
            case 4:
                if (finalScore <= 10) {
                    System.out.print("Honorable");
                } else if (finalScore <= 14) {
                    System.out.print("Glorieuse");
                } else {System.out.print("Totale");}
        }
        return finalScore;
    }
}