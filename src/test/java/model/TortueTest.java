package model;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Sachouw on 01/06/2017.
 */
public class TortueTest {

    private static int DEGREE_MAX = 360;

    private int x100;
    private int y50;
    private Tortue tortue10050;

    @Before
    public void setUp() {
        x100 = 100;
        y50 = 50;
        tortue10050 = new Tortue(x100, y50);
    }

    @Test
    public void instancier_tortue_devrait_la_positionner_au_bon_endroit() {
        assertThat(tortue10050.getPosX()).isEqualTo(x100);
        assertThat(tortue10050.getPosY()).isEqualTo(y50);
    }

    @Test
    public void setPosition_najoute_pas_une_tortue_en_dehors_de_la_map() {
        tortue10050.setPosition(x100 + Tortue.WIDTH, y50);
        assertThat(tortue10050.getPosX()).isEqualTo(x100);
        assertThat(tortue10050.getPosY()).isEqualTo(y50);

        tortue10050.setPosition(x100, y50 + Tortue.HEIGHT);
        assertThat(tortue10050.getPosX()).isEqualTo(x100);
        assertThat(tortue10050.getPosY()).isEqualTo(y50);

        tortue10050.setPosition(x100 - Tortue.WIDTH, y50);
        assertThat(tortue10050.getPosX()).isEqualTo(x100);
        assertThat(tortue10050.getPosY()).isEqualTo(y50);

        tortue10050.setPosition(x100, y50 - Tortue.HEIGHT);
        assertThat(tortue10050.getPosX()).isEqualTo(x100);
        assertThat(tortue10050.getPosY()).isEqualTo(y50);

        tortue10050.setPosition(x100 + 1, y50 + 1);
        assertThat(tortue10050.getPosX()).isEqualTo(x100 + 1);
        assertThat(tortue10050.getPosY()).isEqualTo(y50 + 1);
    }

    @Test
    public void setDirection_tortue_doit_retourner_valeur_possible() {
        tortue10050.setDirection(DEGREE_MAX + 50);
        assertThat(tortue10050.getDir()).isLessThan(DEGREE_MAX);

        tortue10050.setDirection(- DEGREE_MAX);
        assertThat(tortue10050.getDir()).isGreaterThanOrEqualTo(0);

        tortue10050.setDirection(50);
        assertThat(tortue10050.getDir()).isEqualTo(50);
    }
}