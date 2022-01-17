public class Possede extends EtatTerrain{

    public Possede(Terrain terrain){
        super(terrain);
    }

    @Override
    public void atterir(Joueur joueur) {
        System.out.println("Vous etes tombe sur la case " + this.terrain.getNom() + " (" + "prix:" + ((CaseAchetable)this.terrain).getPrixAchat() +
                ", couleur:" + ((CaseAchetable)this.terrain).getCouleur()+")\n");
        if(this.terrain.getProprietaire() != joueur){
            System.out.println("Case possede par un autre joueur, vous devez payer un loyer de " + this.terrain.getLoyer() + "\n");
            int loyer = this.terrain.getLoyer();
            joueur.debiter(loyer);
            this.terrain.getProprietaire().crediter(loyer);
            System.out.println(this.toString());
        }
    }

    public void devientConstructible(){
        this.terrain.setEtat(new Constructible(this.terrain));
    }

    @Override
    public void construire() {}
}
