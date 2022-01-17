public class NonPossede extends EtatTerrain{


    public NonPossede(Terrain terrain){
        super(terrain);
    }
    @Override
    public void atterir(Joueur joueur) {
        int prix = this.terrain.getPrixAchat();

        System.out.println("Vous etes tombe sur la case " + this.terrain.getNom() + " (" + "prix:" + ((CaseAchetable)this.terrain).getPrixAchat() +
                ", couleur:" + ((CaseAchetable)this.terrain).getCouleur()+")\n");
        if(joueur.propositionAchat()){
            joueur.acheterCase();
            this.terrain.setProprietaire(joueur);
            this.terrain.setEtat(new Possede(this.terrain));
            this.terrain.getQuartier().nouveauProprietaire(joueur);
            System.out.println(this.toString());
        }
    }

    @Override
    public void construire() {}
}
