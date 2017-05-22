package controleur;

import model.Tortue;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Matchers.any;

/**
 * Created by Sachouw on 22/05/2017.
 */
public class ControleurFeuilleFlockingTest {

    private ControleurFeuilleFlocking controleur;

    private Tortue tortuePositionneeEn1010;
    private Tortue tortuePositionneeEn2020;
    private Tortue tortuePositionneeEn4010;
    private Tortue tortuePositionneeEn100100;

    @Before
    public void setUp() throws Exception {
        controleur = new ControleurFeuilleFlocking();

        tortuePositionneeEn1010 = new Tortue(10, 10);
        tortuePositionneeEn2020 = new Tortue(20, 20);
        tortuePositionneeEn4010 = new Tortue(40, 10);
        tortuePositionneeEn100100 = new Tortue(100, 100);

}

    @Test
    public void tortuesSontVoisines_devrait_retourner_faux_pour_2tortues_identiques() throws Exception {
        assertThat(controleur.tortuesSontVoisines(tortuePositionneeEn1010, tortuePositionneeEn1010)).isFalse();
    }

    @Test
    public void tortuesSontVoisines_devrait_retourner_vrai_pour_distance_euclidienne_inferieure_distance_vue() throws Exception {
        assertThat(controleur.tortuesSontVoisines(tortuePositionneeEn1010, tortuePositionneeEn2020)).isTrue();
    }

    @Test
    public void tortuesSontVoisines_devrait_retourner_faux_pour_distance_euclidienne_superieur_distance_vue() throws Exception {
        assertThat(controleur.tortuesSontVoisines(tortuePositionneeEn1010, tortuePositionneeEn100100)).isFalse();
    }

    @Test
    public void tortuesSontVoisines_devrait_retourner_faux_pour_distance_euclidienne_egale_distance_vue() throws Exception {
        assertThat(controleur.tortuesSontVoisines(tortuePositionneeEn1010, tortuePositionneeEn4010)).isFalse();
    }
}