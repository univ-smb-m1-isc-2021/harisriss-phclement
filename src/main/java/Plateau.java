import java.util.ArrayList;

public class Plateau {

    final int NBCASE = 32;

    private ArrayList<Kase> cases;
    private ArrayList<Quartier> quartiers;

    public Plateau() {
        cases = new ArrayList<Kase>();
        quartiers = new ArrayList<Quartier>();

        Quartier marron = new Quartier(Couleurs.MARRON);
        Quartier cyan = new Quartier(Couleurs.CYAN);
        Quartier rose = new Quartier(Couleurs.ROSE);
        Quartier orange = new Quartier(Couleurs.ORANGE);
        Quartier rouge = new Quartier(Couleurs.ROUGE);
        Quartier jaune = new Quartier(Couleurs.JAUNE);
        Quartier vert = new Quartier(Couleurs.VERT);
        Quartier bleu = new Quartier(Couleurs.BLEU);
        Quartier gare = new Quartier(Couleurs.GARE);
        Quartier compagnie = new Quartier(Couleurs.COMPAGNIE);

        Depart depart = new Depart();

        Terrain marron1 = new Terrain("Boulevard de Belleville", 60, 2, 5, Couleurs.MARRON, marron);
        Terrain marron2 = new Terrain("Rue Lecourbe", 60, 4, 5, Couleurs.MARRON, marron);

        Terrain cyan1 = new Terrain("Rue de Vaugirard", 100, 6, 5, Couleurs.CYAN, cyan);
        Terrain cyan2 = new Terrain("Rue de Courcelles", 100, 6, 5, Couleurs.CYAN, cyan);
        Terrain cyan3 = new Terrain("Avenue de la Republique", 120, 8, 5, Couleurs.CYAN, cyan);

        Terrain rose1 = new Terrain("Boulevard de la Villette", 140, 10, 10, Couleurs.ROSE, rose);
        Terrain rose2 = new Terrain("Avenue de Neuilly", 140, 10, 10, Couleurs.ROSE, rose);
        Terrain rose3 = new Terrain("Rue de Paradis", 160, 12, 10, Couleurs.ROSE, rose);

        Terrain orange1 = new Terrain("Avenue de Mozart", 180, 14, 10, Couleurs.ORANGE, orange);
        Terrain orange2 = new Terrain("Boulevard Saint-Michel", 180, 14, 10, Couleurs.ORANGE, orange);
        Terrain orange3 = new Terrain("Place Pigalle", 200, 16, 10, Couleurs.ORANGE, orange);

        Terrain rouge1 = new Terrain("Avenue Matignon", 220, 18, 15, Couleurs.ROUGE, rouge);
        Terrain rouge2 = new Terrain("Boulevard Malesherbes", 220, 18, 15, Couleurs.ROUGE, rouge);
        Terrain rouge3 = new Terrain("Avenu Henri-Martin", 240, 20, 15, Couleurs.ROUGE, rouge);

        Terrain jaune1 = new Terrain("Faubourg Saint-Honore", 260, 22, 15, Couleurs.JAUNE, jaune);
        Terrain jaune2 = new Terrain("Place de la Bourse", 260, 22, 15, Couleurs.JAUNE, jaune);
        Terrain jaune3 = new Terrain("Rue Lafayette", 280, 22, 15, Couleurs.JAUNE, jaune);

        Terrain vert1 = new Terrain("Avenue de Breteuil", 300, 26, 20, Couleurs.VERT, vert);
        Terrain vert2 = new Terrain("Avenue Foch", 300, 26, 20, Couleurs.VERT, vert);
        Terrain vert3 = new Terrain("Boulevard des Capucines", 320, 28, 20, Couleurs.VERT, vert);

        Terrain bleu1 = new Terrain("Avenue des Champs-Elysees", 350, 35, 20, Couleurs.BLEU, bleu);
        Terrain bleu2 = new Terrain("Rue de la Paix", 400, 50, 20, Couleurs.BLEU, bleu);

        Gare gare1 = new Gare("Gare Montparnasse", 200, 25, gare);
        Gare gare2 = new Gare("Gare de Lyon", 200, 25, gare);
        Gare gare3 = new Gare("Gare du Nord", 200, 25, gare);
        Gare gare4 = new Gare("Gare Saint-Lazare", 200, 25, gare);

        Compagnie compagnie1 = new Compagnie("Compagnie de Distribution d'electricite", 150, compagnie);
        Compagnie compagnie2 = new Compagnie("Compagnie de Distribution des Eaux", 150, compagnie);

        Taxe taxe1 = new Taxe("Impot sur le revenu", 200);
        Taxe taxe2 = new Taxe("Taxe de Luxe", 100);

        cases.add(depart);

        // Quartier Marron
        marron.ajouter(marron1);
        marron.ajouter(marron2);
        quartiers.add(marron);
        cases.add(marron1);
        cases.add(marron2);

        cases.add(taxe1);

        cases.add(gare1);

        // Quartier Cyan
        cyan.ajouter(cyan1);
        cyan.ajouter(cyan2);
        cyan.ajouter(cyan3);
        quartiers.add(cyan);
        cases.add(cyan1);
        cases.add(cyan2);
        cases.add(cyan3);

        // Quartier Rose
        rose.ajouter(rose1);
        rose.ajouter(rose2);
        rose.ajouter(rose3);
        quartiers.add(rose);
        cases.add(rose1);

        cases.add(compagnie1);

        cases.add(rose2);
        cases.add(rose3);

        cases.add(gare2);

        // Quartier Orange
        orange.ajouter(orange1);
        orange.ajouter(orange2);
        orange.ajouter(orange3);
        quartiers.add(orange);
        cases.add(orange1);
        cases.add(orange2);
        cases.add(orange3);

        // Quartier Rouge
        rouge.ajouter(rouge1);
        rouge.ajouter(rouge2);
        rouge.ajouter(rouge3);
        quartiers.add(rouge);
        cases.add(rouge1);
        cases.add(rouge2);
        cases.add(rouge3);

        cases.add(gare3);

        // Quartier Jaune
        jaune.ajouter(jaune1);
        jaune.ajouter(jaune2);
        jaune.ajouter(jaune3);
        quartiers.add(jaune);
        cases.add(jaune1);
        cases.add(jaune2);

        cases.add(compagnie2);

        cases.add(jaune3);

        //Quartier Vert
        vert.ajouter(vert1);
        vert.ajouter(vert2);
        vert.ajouter(vert3);
        quartiers.add(vert);
        cases.add(vert1);
        cases.add(vert2);
        cases.add(vert3);

        cases.add(gare4);

        // Quartier Bleu
        bleu.ajouter(bleu1);
        bleu.ajouter(bleu2);
        quartiers.add(bleu);
        cases.add(bleu1);
        cases.add(taxe2);
        cases.add(bleu2);

        gare.ajouter(gare1);
        gare.ajouter(gare2);
        gare.ajouter(gare3);
        gare.ajouter(gare4);
        quartiers.add(gare);

        compagnie.ajouter(compagnie1);
        compagnie.ajouter(compagnie2);
        quartiers.add(compagnie);
    }

    public Kase avancer(Joueur joueur, int nbCase) {
        Kase res;
        int indiceCaseCourante;

        //if(cases.contains(caseCourante)) {}
        indiceCaseCourante = cases.indexOf(joueur.getPosition());
        res = cases.get((indiceCaseCourante + nbCase) % (NBCASE - 1));
        System.out.println("Indice case courante: " + indiceCaseCourante);
        System.out.println("Indice case courante + nbCase: " + (indiceCaseCourante + nbCase) % (NBCASE - 1));
        if (((indiceCaseCourante + nbCase) % (NBCASE - 1)) < indiceCaseCourante) {
            System.out.println("Vous etes passez par la case depart. Vous recevez donc un salaire de 200M\n");
            joueur.crediter(200);
        }
        return res;
    }

    public Kase getCaseDepart() {
        return cases.get(0);
    }

    public String toString() {
        String res = "Liste case plateau : \n";
        for (int i = 0; i < cases.size(); i++) {
            res = res + cases.get(i).getNom() + "\n";
        }

        res = res + "\n" + quartiers.toString();
        return res;
    }
}
