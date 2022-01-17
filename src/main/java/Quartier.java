import java.util.ArrayList;

public class Quartier {

    private ArrayList<CaseAchetable> caseQuartier;
    private Couleurs type;

    public Quartier(Couleurs couleur){
        this.type = couleur;
        caseQuartier = new ArrayList<CaseAchetable>();
    }

    public boolean verifProprietaireQuartier(Joueur joueur){
        int memeProprietaire = 0;
        for(int i = 0; i<caseQuartier.size(); i++){
            if(caseQuartier.get(i).getProprietaire() == joueur){
                memeProprietaire++;
            }
        }
        return memeProprietaire == caseQuartier.size();
    }

    public void modifProprietaireQuartier(Joueur joueur){
        joueur.ajoutQuartier(this);
        if(type != Couleurs.GARE || type != Couleurs.COMPAGNIE) {
            for (int j = 0; j < caseQuartier.size(); j++) {
                ((Terrain) (caseQuartier.get(j))).setEtat(new Constructible((Terrain) caseQuartier.get(j)));
            }
        }
    }

    public void nouveauProprietaire(Joueur joueur){
        //System.out.println(type.toString());
        if(verifProprietaireQuartier(joueur)){
            modifProprietaireQuartier(joueur);
        }
    }

    public void ajouter(CaseAchetable maCase){
        caseQuartier.add(maCase);
    }

    public int getNbCompagnie(Joueur joueur){
        int nbCompagnie = 0;
        for(int i = 0; i<caseQuartier.size(); i++){
            if(caseQuartier.get(i).getProprietaire() == joueur){
                nbCompagnie++;
            }
        }
        return nbCompagnie;
    }

    public int getNbGare(Joueur joueur){
        int nbGare = 0;
        for(int i = 0; i<caseQuartier.size(); i++){
            if(caseQuartier.get(i).getProprietaire() == joueur){
                nbGare++;
            }
        }
        return nbGare;
    }

    public Couleurs getCouleurQuartier(){
        return type;
    }

    public String toString(){
        String res = "Quartier " + type.toString() + " :\n";
        for(int i = 0; i<caseQuartier.size(); i++){
            res = res + caseQuartier.get(i).getNom() + "\n";
        }
        return res;
    }
}
