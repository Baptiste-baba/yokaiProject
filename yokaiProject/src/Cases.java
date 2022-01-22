public class Cases extends gameBoard {
    
    private yokaiCards yokaiCard;
    private cluesCards clueCard;
    private Position position;

    //Constucteur
    public Cases(yokaiCards yokaiCard, cluesCards clueCard, Position position) {
        this.yokaiCard = yokaiCard;
        this.clueCard = clueCard;
        this.position = position;
    }

    //Encapsulation
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public yokaiCards getyokaiCards() {
        return yokaiCard;
    }

    public cluesCards getcluesCards() {
        return clueCard;
    }

}
