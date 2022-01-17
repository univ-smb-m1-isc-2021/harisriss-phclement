public abstract class EtatTerrain {

    protected Terrain terrain;

    public EtatTerrain(Terrain terrain){
        this.terrain = terrain;
    }
    public abstract void atterir(Joueur joueur);
    public abstract void construire();
}
