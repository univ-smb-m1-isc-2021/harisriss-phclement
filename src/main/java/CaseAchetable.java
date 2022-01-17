public abstract class CaseAchetable extends Kase{

    private int prixAchat;
    private Joueur proprietaire;
    private Couleurs couleur;
    private Quartier quartier;

    public CaseAchetable(String nom, int prixAchat, Couleurs couleur, Quartier quartier){
        super(nom);
        this.prixAchat = prixAchat;
        this.couleur = couleur;
        this.proprietaire = null;
        this.quartier = quartier;
    }

    public abstract void atterir(Joueur joueur);

    /************** Guetteurs et Setteurs *****************/
    public int getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Couleurs getCouleur() {
        return couleur;
    }

    public Quartier getQuartier(){
        return this.quartier;
    }
}
