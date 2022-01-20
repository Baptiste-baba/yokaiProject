public class yokaiCards {
    
    public enum Cards {
        KAPPA,
        KITSUNE,
        ONI,
        ROKUROKUBI
    }

    public static void callCards() {
        
        for (Cards myVar : Cards.values()) {
            System.out.println("Les différentes cartes du jeux sont: " + myVar);
        }
     }

     public static void hideCards() {
         
     }

     public static void DisplayCards() {

     }

     
}
