package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class BurgerTest {

    private Burger burger;

    @Mock private Bun mockBun;
    @Mock private Ingredient mockIngredient1;
    @Mock private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
    }

    @Test
    public void testSetBunsAssignsBun() {
        burger.setBuns(mockBun);
        assertEquals("Burger bun should be set correctly", mockBun, burger.bun);
    }

    @Test
    public void testAddIngredientIncreasesList() {
        burger.addIngredient(mockIngredient1);
        assertEquals("Ingredients list size should be 1 after adding", 1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredientClearsList() {
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(0);
        assertEquals("Ingredients list should be empty after removal", 0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredientReordersList() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals("First ingredient should move to second position", mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPriceCalculatesTotal() {
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockIngredient1.getPrice()).thenReturn(50f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);

        float expected = 100f * 2 + 50f;
        assertEquals("Total price should include double bun price and ingredients", expected, burger.getPrice(), 0.001f);
    }

    @Test
    public void testGetReceiptContainsExpectedLines() {
        when(mockBun.getName()).thenReturn("Black Bun");
        when(mockIngredient1.getName()).thenReturn("Hot Sauce");
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        String receipt = burger.getReceipt();

        assertTrue("Receipt should contain bun name", receipt.contains("Black Bun"));
        assertTrue("Receipt should contain ingredient name", receipt.contains("Hot Sauce"));
        assertTrue("Receipt should mention sauce type in lowercase", receipt.contains("sauce Hot Sauce"));
        assertTrue("Receipt should display price label", receipt.contains("Price:"));
    }
}
