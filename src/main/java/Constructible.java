public class Constructible extends EtatTerrain{

    final int NBMAXMAISON = 4;
    final int NBMAXHOTEL = 1;

    public Constructible(Terrain terrain){
        super(terrain);
    }
    @Override
    public void atterir(Joueur joueur) {
        // ici methode aleatoire. Prendre reel valeur de loyer en fonction des maisons
        System.out.println("Vous etes tombe sur la case " + this.terrain.getNom() + " (" + "prix:" + ((CaseAchetable)this.terrain).getPrixAchat() +
                ", couleur:" + ((CaseAchetable)this.terrain).getCouleur()+")\n");
        int nbMaison = this.terrain.getNbMaison();
        int nbHotel = this.terrain.getNbHotel();
        int loyer;
        if(this.terrain.getProprietaire() != joueur){
            if(nbHotel != 0){
                loyer = this.terrain.getLoyer() * 30;
            }
            else if(nbMaison != 0){
                loyer = this.terrain.getLoyer() * 3 * nbMaison;
            }
            else{
                loyer = this.terrain.getLoyer() * 2;
            }
            System.out.println("Case possede par un autre joueur, vous devez payer un loyer de " + loyer + "\n");
            joueur.debiter(loyer);
            this.terrain.getProprietaire().crediter(loyer);
            System.out.println(this.toString());
        }
    }

    @Override
    public void construire() {
        // voir pour l'implementation de l'uniformite
        int prixConstruction = this.terrain.getPrixConstruction();
        if(this.terrain.getNbHotel() != NBMAXHOTEL){
            if(this.terrain.getProprietaire().propositionConstruction(this.terrain)){
                if(this.terrain.getNbMaison() < 4){
                    this.terrain.getProprietaire().debiter(prixConstruction);
                    System.out.println(this.toString());
                    this.terrain.ajoutMaison();
                }
                else if(this.terrain.getNbMaison() == NBMAXMAISON){
                    System.out.println("Vous avez le nombre maximum de maison pouvant etre construit sur votre terrain");
                    System.out.println("Un hotel va donc etre construit");
                    this.terrain.getProprietaire().debiter(prixConstruction);
                    System.out.println(this.toString());
                    this.terrain.ajoutHotel();
                }
            }
        }
        else{
            System.out.println("Vous ne pouvez plus construire sur ce terrain");
        }
    }
}
