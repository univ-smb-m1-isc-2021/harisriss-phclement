public class Taxe extends Kase{

    int montantTaxe;
    public Taxe(String nom, int montantTaxe){
        super(nom);
        this.montantTaxe = montantTaxe;
    }
    @Override
    public void atterir(Joueur joueur) {
        System.out.println("Vous etes tombe sur la case " + this.getNom() + ". Vous devez payer une taxe de " + montantTaxe + "\n");
        joueur.debiter(this.montantTaxe);
    }
}
