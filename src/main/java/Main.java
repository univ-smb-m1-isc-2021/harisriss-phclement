public class Main {
    public static void main(String[] args) {

        //bonus :
        //essayer de faire vendre
        //essayer rajouter un etat plusConstructible
        //ameliorer le tour pour que l'on puisse construire autant qu'on veux en un tour
        //mettre en place les differentes valeurs de loyer en fonction des maisons
        //testConstructionPlateau();
        //testAcheter();
        ///testPayerLoyer();
        //testObtenirQuartier();
        testMonopoly();
    }

    public static void testConstructionPlateau(){
        Plateau monPlateau = new Plateau();
        System.out.println("Hoey world !");
        System.out.println(monPlateau.toString());
    }

    public static void testAcheter(){
        Plateau monPlateau = new Plateau();
        Partie maPartie = new Partie(monPlateau);
        Joueur angel = new Joueur("Angelique", "Collomb", 1500, maPartie, monPlateau.getCaseDepart());
        System.out.println(angel.getPosition().getNom());
        angel.jouerTour();
        System.out.println(angel.toString());
        System.out.println(angel.getPosition().getNom());
    }

    public static void testPayerLoyer(){
        Plateau monPlateau = new Plateau();
        Partie maPartie = new Partie(monPlateau);
        Joueur angel = new Joueur("Angelique", "Collomb", 1500, maPartie, monPlateau.getCaseDepart());
        Joueur benjamin = new Joueur("Benjamin", "Verdant", 1500, maPartie, monPlateau.getCaseDepart());
        System.out.println(angel.toString());
        angel.jouerTour();
        System.out.println(angel.toString());
        System.out.println(benjamin.toString());
        benjamin.jouerTour();
        System.out.println(benjamin.toString());
        System.out.println(angel.toString());
    }

    public static void testPayerCompagnie(){
        //testPayerLoyer + placer la valeur du lancer de des sur l'indice de la premiere compagnie = 8


    }

    public static void testPayerGare(){
        // testPayerLoyer + placer la valeur du lancer de des sur l'indice de la premiere compagnie = 3
    }

    public static void testObtenirQuartier(){
        // lancer de des egal a 1
        Plateau monPlateau = new Plateau();
        Partie maPartie = new Partie(monPlateau);
        Joueur angel = new Joueur("Angelique", "Collomb", 1500, maPartie, monPlateau.getCaseDepart());
        Joueur benjamin = new Joueur("Benjamin", "Verdant", 1500, maPartie, monPlateau.getCaseDepart());
        System.out.println(angel.toString());
        angel.jouerTour();
        System.out.println(angel.toString());
        angel.jouerTour();

        angel.jouerTour();

        angel.jouerTour();
        angel.jouerTour();
        angel.jouerTour();

        System.out.println(angel.toString());
        benjamin.jouerTour();
        System.out.println(benjamin.toString());

    }

    public static void testMonopoly(){
        Plateau monPlateau = new Plateau();
        Partie maPartie = new Partie(monPlateau);
        boolean gagner = true;
        Joueur angel = new Joueur("Angelique", "Collomb", 1500, maPartie, monPlateau.getCaseDepart());
        Joueur benjamin = new Joueur("Benjamin", "Verdant", 1500, maPartie, monPlateau.getCaseDepart());
        while(gagner) {
            angel.jouerTour();
            System.out.println(angel.toString());
            benjamin.jouerTour();
            System.out.println(benjamin.toString());
        }
    }
}
