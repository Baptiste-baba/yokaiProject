public class cluesCards {
    
    public enum clues {
        ROUGE,
        VERT,
        BLEU,
        VIOLET,
        ROUGE_VIOLET,
        VERT_ROUGE,
        BLEU_VIOLET,
        VERT_VIOLET,
        VERT_BLEU,
        BLEU_ROUGE,
        BLEU_VERT_VIOLET,
        VERT_VIOLET_ROUGE,
        BLEU_VIOLET_ROUGE,
        BLEU_VERT_ROUGE;
    }

    private Position position;
    private String color;

    //constructeur
    public cluesCards(String clueCard, Position position) {
        this.color = clueCard;
        this.position = position;
    }

    public String getClueName() {
        return color;
    }

}
