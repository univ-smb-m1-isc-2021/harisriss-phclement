public class Compagnie extends CaseAchetable{


    public Compagnie(String nom, int prixAchat, Quartier quartier){
        super(nom, prixAchat, Couleurs.COMPAGNIE, quartier);
    }

    @Override
    public void atterir(Joueur joueur){
        System.out.println("Vous etes tombe sur la case " + this.getNom() + " (" + "prix:" + ((CaseAchetable)this).getPrixAchat() +
                ", couleur:" + ((CaseAchetable)this).getCouleur()+")\n");
        if(this.getProprietaire() == null){
            if(joueur.propositionAchat()){
                joueur.acheterCase();
                this.setProprietaire(joueur);
                this.getQuartier().nouveauProprietaire(joueur);
            }
        }
        else{
            if(this.getProprietaire() != joueur){
                int nbCompagnie = this.getQuartier().getNbCompagnie(this.getProprietaire());
                this.payer(joueur, nbCompagnie);
            }
        }
    }

    public void payer(Joueur joueur, int nbCompagnie){
        int coefMultiplicateur;
        int valeurLancerDes;
        int loyerCompagnie;

        if(nbCompagnie == 1){
            coefMultiplicateur = 4;
        }
        else{
            coefMultiplicateur = 10;
        }
        valeurLancerDes = joueur.lancerDes();
        loyerCompagnie = valeurLancerDes * coefMultiplicateur;
        System.out.println("nbGare:" + nbCompagnie +  ", loyer:" + loyerCompagnie);
        System.out.println("Case possede par un autre joueur, vous devez payer un loyer de " + loyerCompagnie + "\n");
        joueur.debiter(loyerCompagnie);
        this.getProprietaire().crediter(loyerCompagnie);

    }
}
