public class gameBoard {
    
    private void initialiseBoard() {
        char[] cardList = {'R', 'R', 'R', 'R', 'B', 'B', 'B', 'B', 'P', 'P', 'P', 'P', 'G', 'G', 'G', 'G'};
        shuffle(cardList);

        int count = 0;
        for (int i = (n / 2 - 2); i < (n / 2 + 2); i++) {
            for (int j = (n / 2 - 2); j < (n / 2 + 2); j++) {
                Position positionCard = new Position(i, j);
                YokaiCard card = new YokaiCard(cardList[count], positionCard);
                cardBoard[i][j] = new Cell(card, null, positionCard);
                count += 1;
            }
        }
    }
}
