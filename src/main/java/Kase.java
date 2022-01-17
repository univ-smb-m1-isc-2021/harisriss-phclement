public abstract class Kase {


    private String nom;

    public Kase(String nom){
        this.nom = nom;
    }

    public abstract void atterir(Joueur joueur);

    public String getNom() {
        return nom;
    }
}
