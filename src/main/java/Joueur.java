import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {

    private String prenom;
    private String nom;
    private int argent;
    private Kase position;
    private Partie partie;
    private ArrayList<CaseAchetable> proprietes;
    private ArrayList<Quartier> mesQuartiers;


    public Joueur(String prenom, String nom, int argent, Partie partie, Kase position) {
        this.prenom = prenom;
        this.nom = nom;
        this.argent = argent;
        this.partie = partie;
        this.position = position;
        this.proprietes = new ArrayList<CaseAchetable>();
        this.mesQuartiers = new ArrayList<Quartier>();
    }

    public Joueur(String prenom) {
        this.prenom = prenom;
    }

    public Joueur(String prenom, int argent) {
        this.prenom = prenom;
        this.argent = argent;
    }

    // Valeurs comprise entre 2 et 12
    public int lancerDes() {
        return (int) ((Math.random() * 10 + 1) + 2);
    }

    public void avancerJoueur() {
        int valeurLancerDes = this.lancerDes();
        System.out.println(valeurLancerDes + "");
        this.position = partie.avancer(this, valeurLancerDes);
    }

    public void afficherAction() {
        ArrayList<CaseAchetable> listeChoixTerrain = new ArrayList<CaseAchetable>();
        int numeroChoix = 1;
        Quartier quartierConstruction;
        boolean possedeUnQuartier = mesQuartiers.size() == 1;
        String res = "";
        Scanner scanner = new Scanner(System.in);
        int choix;
        String affichageQuartier = (possedeUnQuartier ? "Vous posseder le quartier suivant : "
                : "Vous posseder les quartiers suivants : ");
        String propositionConstruction = (possedeUnQuartier ? "Voulez vous construire sur l'une des proprietes de votre quartier ?" :
                "Voulez vous construire sur l'une des des proprietes de l'un de vos quartiers ?");
        if (mesQuartiers.size() == 0) {
            System.out.println("Vous ne possedez aucun quartier, aucune autre action est donc possible. Fin de votre tour.\n");
        } else {
            System.out.println(affichageQuartier);
            for (int i = 0; i < mesQuartiers.size(); i++) {
                System.out.println("- " + mesQuartiers.get(i).getCouleurQuartier().toString());
            }
            System.out.println(res);
            System.out.println(propositionConstruction);
            System.out.println("1 - Oui");
            System.out.println("2 - Non");
            choix = scanner.nextInt();
            if (choix == 1) {
                if (possedeUnQuartier) {
                    quartierConstruction = mesQuartiers.get(0);
                } else {
                    System.out.println("\nSur quelle Quartier voulez vous construire : ");
                    for (int j = 0; j < mesQuartiers.size(); j++) {
                        if ((mesQuartiers.get(j).getCouleurQuartier() != Couleurs.COMPAGNIE) && (mesQuartiers.get(j).getCouleurQuartier() != Couleurs.GARE)) {
                        }
                        System.out.println(numeroChoix + " - " + mesQuartiers.get(j).getCouleurQuartier());
                        numeroChoix++;
                    }
                    choix = scanner.nextInt();
                    quartierConstruction = mesQuartiers.get(choix - 1);
                    numeroChoix = 1;
                }
                System.out.println("\nSur quelle propriete voulez vous construire : ");
                for (int k = 0; k < proprietes.size(); k++) {
                    if (proprietes.get(k).getCouleur() == quartierConstruction.getCouleurQuartier()) {
                        System.out.println(numeroChoix + " - " + proprietes.get(k).getNom());
                        listeChoixTerrain.add(proprietes.get(k));
                        numeroChoix++;
                    }
                }
                choix = scanner.nextInt();
                ((Terrain) listeChoixTerrain.get(choix - 1)).construire();
                // Au choix recursif ou bien while
            }
        }
    }

    public void jouerTour() {
        System.out.println("--------------------------- tour de " + this.prenom + " ---------------------------\n");
        this.avancerJoueur();
        position.atterir(this);
        this.afficherAction();
    }

    public boolean propositionAchat() {
        int choix;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cette case est libre voulez vous l'acheter ?");
        System.out.println("1 - Oui");
        System.out.println("2 - Non");

        choix = scanner.nextInt();

        return choix == 1;
    }

    public boolean propositionConstruction(Terrain terrain) {
        int choix;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Le prix de la construction d'une maison sur " + terrain.getNom() + " est de : " + terrain.getPrixConstruction());
        System.out.println("Voulez vous construire ?");
        System.out.println("1 - Oui");
        System.out.println("2 - Non");

        choix = scanner.nextInt();

        return choix == 1;
    }

    public void acheterCase() {
        this.setArgent(argent - ((CaseAchetable) position).getPrixAchat());
        this.proprietes.add((CaseAchetable) position);
    }

    public void ajoutQuartier(Quartier quartier) {
        this.mesQuartiers.add(quartier);
    }

    // eventuellement rajouter ici les proecdeure de vente lorsqu'on ne peut etre debiter
    public void debiter(int loyer) {
        setArgent(argent - loyer);
    }

    public void crediter(int loyer) {
        setArgent(argent + loyer);
    }

    public String toString() {
        String res = this.prenom + " " + this.nom + "\n";
        res = res + "position: " + this.position.getNom() + "\n";
        res = res + "argent: " + this.argent + "\n";
        res = res + "proprietes: \n";
        for (int i = 0; i < proprietes.size(); i++) {
            res = res + "- " + proprietes.get(i).getNom() + "\n";
        }
        res = res + "quartiers: \n";
        for (int j = 0; j < mesQuartiers.size(); j++) {
            res = res + "- " + mesQuartiers.get(j).toString() + "\n";
        }
        return res;
    }

    /************** Guetteurs et Setteurs *****************/
    public int getArgent() {
        return argent;
    }

    private void setArgent(int argent) {
        this.argent = argent;
    }

    public Kase getPosition() {
        return this.position;
    }

    public String getPrenom() {
        return this.prenom;
    }
}
