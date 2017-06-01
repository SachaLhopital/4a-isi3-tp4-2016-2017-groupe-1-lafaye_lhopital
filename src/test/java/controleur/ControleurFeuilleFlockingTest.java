package controleur;

import controleur.modeAuto.ControleurFeuilleFlocking;
import model.Tortue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import vue.commun.VueFeuille;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;
import static junit.framework.TestCase.fail;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Matchers.any;

/**
 * Created by Sachouw on 22/05/2017.
 */
public class ControleurFeuilleFlockingTest {

    private static final String GET_DISTANCE_EUCLIDIENNE = "getDistanceEuclidienne";

    private ControleurFeuilleFlocking controleur;

    private Method getDistanceEuclidienne;
    private Point[] parametres;
    private Class[] typesDesParametres;

    @Mock private VueFeuille mockVueFeuille;
    @Mock private Tortue tortuePositionneeEn1010;
    @Mock private Tortue tortuePositionneeEn2020;
    @Mock private Tortue tortuePositionneeEn4010;
    @Mock private Tortue tortuePositionneeEn100100;
    @Mock private Tortue tortuePositionneeEn1010Negatif;
    @Mock private Tortue tortuePositionneeEn5010Negatif;

    @Before
    public void setUp() throws Exception {

        /* Mocks */
        MockitoAnnotations.initMocks(this);
        Mockito.doNothing().when(mockVueFeuille).ajouterVueTortue(any());

        Mockito.when(tortuePositionneeEn1010.getPosition()).thenReturn(new Point(10,10));
        Mockito.when(tortuePositionneeEn1010.getCouleur()).thenReturn(Color.BLACK);

        Mockito.when(tortuePositionneeEn2020.getPosition()).thenReturn(new Point(20,20));
        Mockito.when(tortuePositionneeEn2020.getCouleur()).thenReturn(Color.BLACK);

        Mockito.when(tortuePositionneeEn4010.getPosition()).thenReturn(new Point(40,10));
        Mockito.when(tortuePositionneeEn4010.getCouleur()).thenReturn(Color.BLACK);

        Mockito.when(tortuePositionneeEn100100.getPosition()).thenReturn(new Point(100,100));
        Mockito.when(tortuePositionneeEn100100.getCouleur()).thenReturn(Color.BLACK);

        Mockito.when(tortuePositionneeEn1010Negatif.getPosition()).thenReturn(new Point(-10,-10));
        Mockito.when(tortuePositionneeEn5010Negatif.getPosition()).thenReturn(new Point(-50,-10));

        /* Variables diverses */
        controleur = new ControleurFeuilleFlocking();
        controleur.setFeuilleDessin(mockVueFeuille);

        /* Setup pour tester les méthodes privées */
        parametres = new Point[2];

        typesDesParametres = new Class[2];
        typesDesParametres[0] = Point.class;
        typesDesParametres[1] = Point.class;

        getDistanceEuclidienne = controleur.getClass().getDeclaredMethod(
                GET_DISTANCE_EUCLIDIENNE,
                typesDesParametres);
        getDistanceEuclidienne.setAccessible(true);
    }

    //GetDistanceEuclidienne

    @Test
    public void getDistanceEuclidienne_devrait_retourner_difference_entre_2entiers_positifs() {
        try {
            parametres[0] = tortuePositionneeEn4010.getPosition();
            parametres[1] = tortuePositionneeEn1010.getPosition();
            assertThat((double) getDistanceEuclidienne.invoke(controleur, parametres)).isEqualTo(30.0);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void getDistanceEuclidienne_devrait_retourner_difference_entre_2entiers_negatifs(){
        try {
            parametres[0] = tortuePositionneeEn5010Negatif.getPosition();
            parametres[1] = tortuePositionneeEn1010Negatif.getPosition();
            assertThat((double) getDistanceEuclidienne.invoke(controleur, parametres)).isEqualTo(40.0);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void getDistanceEuclidienne_devrait_retourner_0_entre_2tortues_a_la_meme_position(){
        try {
            parametres[0] = tortuePositionneeEn1010Negatif.getPosition();
            parametres[1] = tortuePositionneeEn1010Negatif.getPosition();
            assertThat((double) getDistanceEuclidienne.invoke(controleur, parametres)).isEqualTo(0.0);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    //TortuesSontVoisines

    @Test
    public void tortuesSontVoisines_devrait_retourner_faux_pour_2tortues_identiques() throws Exception {
        assertThat(controleur.tortuesPeuventSeSuivre(tortuePositionneeEn1010, tortuePositionneeEn1010)).isFalse();
    }

    @Test
    public void tortuesSontVoisines_devrait_retourner_vrai_pour_distance_euclidienne_inferieure_distance_vue() throws Exception {
        assertThat(controleur.tortuesPeuventSeSuivre(tortuePositionneeEn1010, tortuePositionneeEn2020)).isTrue();
    }

    @Test
    public void tortuesSontVoisines_devrait_retourner_faux_pour_distance_euclidienne_superieur_distance_vue() throws Exception {
        assertThat(controleur.tortuesPeuventSeSuivre(tortuePositionneeEn1010, tortuePositionneeEn100100)).isFalse();
    }

    @Test
    public void tortuesSontVoisines_devrait_retourner_faux_pour_distance_euclidienne_egale_distance_vue() throws Exception {
        assertThat(controleur.tortuesPeuventSeSuivre(tortuePositionneeEn1010, tortuePositionneeEn4010)).isFalse();
    }

    //ajouterToutesLesTortues

    @Test
    public void ajouterToutesLesTortues_devrait_ajouter_NOMBRES_TORTUES_BASE_liste() {
        assertThat(controleur.getTortues().size()).isEqualTo(0);
        controleur.ajouterToutesLesTortues();
        assertThat(controleur.getTortues().size()).isEqualTo(controleur.NOMBRES_TORTUES_BASE);
    }

    //MiseAJour

    @Test
    public void miseAJour_devrait_bouger_les_tortues() {
        ajouterTortuesAuControleur();
        controleur.démarrer();
        controleur.miseAJour();

        verify(tortuePositionneeEn1010, atLeast(1)).avancer(anyInt());
        verify(tortuePositionneeEn4010, atLeast(1)).avancer(anyInt());
        verify(tortuePositionneeEn2020, atLeast(1)).avancer(anyInt());
    }

    @Test
    public void miseAJour_devrait_ne_rien_faire_si_programme_non_en_route() {
        ajouterTortuesAuControleur();
        controleur.miseAJour();

        verify(tortuePositionneeEn1010, never()).avancer(anyInt());
        verify(tortuePositionneeEn4010, never()).avancer(anyInt());
        verify(tortuePositionneeEn2020, never()).avancer(anyInt());
    }

    //Methodes privées

    /***
     * Ajoute 3 mocks à la liste des tortues du controleur
     */
    private void ajouterTortuesAuControleur() {
        List<Tortue> listeTortues = new LinkedList<>();
        listeTortues.add(tortuePositionneeEn1010);
        listeTortues.add(tortuePositionneeEn4010);
        listeTortues.add(tortuePositionneeEn2020);
        controleur.getTortues().addAll(listeTortues);
    }
}