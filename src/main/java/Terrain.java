public class Terrain extends CaseAchetable{

    private int loyer;
    private int prixConstruction;
    private int nbMaison;
    private int nbHotel;

    private EtatTerrain etat;

    public Terrain(String nom, int prixAchat, int loyer, int prixConstruction, Couleurs couleur, Quartier quartier){
        super(nom, prixAchat, couleur, quartier);
        this.etat = new NonPossede(this);
        this.loyer = loyer;
        this.prixConstruction = prixConstruction;
        this.nbHotel = 0;
        this.nbMaison = 0;
    }

    @Override
    public void atterir(Joueur joueur){
        etat.atterir(joueur);
    }

    public void construire(){
        this.etat.construire();
    }

    /************** Guetteurs et Setteurs *****************/
    public EtatTerrain getEtat() {
        return etat;
    }

    public void setEtat(EtatTerrain etat) {
        this.etat = etat;
    }

    public int getLoyer(){
        return loyer;
    }

    public int getPrixConstruction(){
        return this.prixConstruction;
    }

    public int getNbMaison(){
        return nbMaison;
    }

    public int getNbHotel(){
        return nbHotel;
    }

    public void ajoutMaison(){
        this.nbMaison++;
    }

    public void ajoutHotel(){
        this.nbMaison = 0;
        this.nbHotel++;
    }

}
