import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestJoueur {

    @Test
    public void TestCreateJoueurName() {
        Joueur j = new Joueur("Haris");
        assertEquals("Haris", j.getNom());
    }

    @Test
    public void TestCreateJoueurSolde() {
        Joueur j = new Joueur("Haris", 0);
        assertEquals(0, j.getArgent());
    }
}