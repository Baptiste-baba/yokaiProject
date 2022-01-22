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
    private cluesCards.clues type;

    //constructeur
    public cluesCards(cluesCards.clues type, Position position) {
        this.type = type;
        this.position = position;
    }

}
