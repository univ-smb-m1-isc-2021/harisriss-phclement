import java.util.ArrayList;

public class Partie {

    private ArrayList<Joueur> joueurs;
    private Plateau plateau;
    private Quartier quartiers;

    public Partie(Plateau plateau){
        this.plateau = plateau;
    }

    public Kase avancer(Joueur joueur, int nbCase){
        return plateau.avancer(joueur, nbCase);
    }
}
