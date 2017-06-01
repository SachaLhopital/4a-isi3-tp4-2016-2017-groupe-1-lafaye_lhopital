package controleur;

import controleur.commun.ControleurFeuilleDessin;
import model.Tortue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import view.commun.ViewFeuille;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Sachouw on 22/05/2017.
 */
public class ControleurFeuilleDessinTest {

    protected ControleurFeuilleDessin controleur;

    @Mock protected ViewFeuille mockViewFeuille;
    @Mock protected Tortue mockTortue;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controleur = new ControleurFeuilleDessin();
        controleur.setFeuilleDessin(mockViewFeuille);
    }

    @Test
    public void ajouterTortue_devrait_creer_vue_associee_et_changer_tortue_courante(){
        assertThat(controleur.getTortues().size()).isEqualTo(0);
        assertThat(controleur.getTortueCourrante()).isNull();

        controleur.ajouterTortue(mockTortue);

        assertThat(controleur.getTortues().size()).isEqualTo(1);
        assertThat(controleur.getTortueCourrante()).isEqualToComparingFieldByField(mockTortue);
        verify(mockTortue, times(1)).addObserver(anyObject());
        verify(mockViewFeuille, times(1)).ajouterVueTortue(anyObject());
    }

}