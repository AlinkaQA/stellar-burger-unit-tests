package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Parameterized.Parameters(name = "Bun[name={0}, price={1}]")
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Black Bun", 100f},
                {"White Bun", 200.55f},
                {"Red Bun", 0f}
        };
    }

    @Test
    public void testBunName() {
        assertEquals("Bun name should match the input name", name, bun.getName());
    }

    @Test
    public void testBunPrice() {
        assertEquals("Bun price should match the input price", price, bun.getPrice(), 0.001f);
    }
}
