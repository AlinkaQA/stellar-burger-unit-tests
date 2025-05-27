package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void testSauceToString() {
        assertEquals("toString should return 'SAUCE' for SAUCE", "SAUCE", IngredientType.SAUCE.toString());
    }

    @Test
    public void testFillingToString() {
        assertEquals("toString should return 'FILLING' for FILLING", "FILLING", IngredientType.FILLING.toString());
    }
}
