public class Gare extends CaseAchetable {

    private boolean etat;
    private int loyerGare;

    public Gare(String nom, int prixAchat, int loyerGare, Quartier quartier) {
        super(nom, prixAchat, Couleurs.GARE, quartier);
        this.etat = false;
        this.loyerGare = loyerGare;
    }

    @Override
    public void atterir(Joueur joueur) {
        System.out.println("Vous etes tombe sur la case " + this.getNom() + " (" + "prix:" + ((CaseAchetable) this).getPrixAchat() +
                ", couleur:" + ((CaseAchetable) this).getCouleur() + ")\n");
        if (this.getProprietaire() == null) {
            if (joueur.propositionAchat()) {
                joueur.acheterCase();
                this.setProprietaire(joueur);
                this.getQuartier().nouveauProprietaire(joueur);
            }
        } else if (this.getProprietaire() != joueur) {
            int nbGare = this.getQuartier().getNbGare(this.getProprietaire());
            this.payer(joueur, nbGare);
        }
    }

    public void payer(Joueur joueur, int nbGare) {
        int loyer = loyerGare * ((int) Math.pow(2, nbGare - 1));
        System.out.println("nbGare:" + nbGare + ", loyer:" + loyer);
        System.out.println("Case possede par un autre joueur, vous devez payer un loyer de " + loyer + "\n");
        joueur.debiter(loyer);
        this.getProprietaire().crediter(loyer);
    }
}
