public class yokaiCards {

    public enum Cards {
        KAPPA,
        KITSUNE,
        ONI,
        ROKUROKUBI
    }
    
    private Position position;
    private yokaiCards.Cards type;

    //constructeur
    public yokaiCards(Cards type, Position position) {
        this.type = type;
        this.position = position;
    }

    //Encapsulation
    public yokaiCards.Cards getCardName() {
        return type;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}