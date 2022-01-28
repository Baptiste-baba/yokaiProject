public class gameBoard {
    
    protected static void initialiseBoard() {

        int n = 6;
        Cases[][] cardBoard = new Cases[n][n];

        char[] cardList = {'R', 'R', 'R', 'R', 'B', 'B', 'B', 'B', 'P', 'P', 'P', 'P', 'G', 'G', 'G', 'G'};
        Yokai.Mix(cardList);

        int count = 0;
        for (int i = (n / 2 - 2); i < (n / 2 + 2); i++) {
            for (int j = (n / 2 - 2); j < (n / 2 + 2); j++) {
                Position positionCard = new Position(i, j);
                yokaiCards card = new yokaiCards(cardList[count], positionCard);
                cardBoard[i][j] = new Cases(card, null, positionCard);
                count += 1;
            }
        }
    }
}
