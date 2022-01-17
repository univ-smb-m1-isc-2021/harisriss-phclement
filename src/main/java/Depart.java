public class Depart extends Kase {

    final int montantPaie = 200;

    public Depart(){
        super("Depart");
    }

    @Override
    public void atterir(Joueur joueur) {
        System.out.println("Vous etes tombe sur la case " + this.getNom() + ". Vous recevez donc un salaire de " + this.montantPaie + "\n");
        joueur.crediter(this.montantPaie);
    }

    public int getMontantPaie(){
        return this.montantPaie;
    }
}
