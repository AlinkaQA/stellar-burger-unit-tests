package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters(name = "Ingredient[type={0}, name={1}, price={2}]")
    public static Object[][] testData() {
        return new Object[][] {
                {IngredientType.SAUCE, "BBQ", 99.99f},
                {IngredientType.FILLING, "Chicken", 123.45f}
        };
    }

    @Test
    public void testGetNameReturnsCorrectValue() {
        assertEquals("Ingredient name should match", name, ingredient.getName());
    }

    @Test
    public void testGetPriceReturnsCorrectValue() {
        assertEquals("Ingredient price should match", price, ingredient.getPrice(), 0.001f);
    }

    @Test
    public void testGetTypeReturnsCorrectValue() {
        assertEquals("Ingredient type should match", type, ingredient.getType());
    }
}