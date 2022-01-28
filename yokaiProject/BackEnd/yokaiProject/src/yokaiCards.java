public class yokaiCards {

    public enum Cards {
        KAPPA,
        KITSUNE,
        ONI,
        ROKUROKUBI
    }
    
    private Position position;
    private char type;

    //constructeur
    public yokaiCards(char cardList, Position position) {
        this.type = cardList;
        this.position = position;
    }

    //Encapsulation
    public char getCardName() {
        return type;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}