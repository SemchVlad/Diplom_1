package praktikum;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class DatabaseTest {

    @Test
    public void checkReturnAvailableBunsData() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        assertSame("black bun", buns.get(0).getName());
        assertSame("white bun", buns.get(1).getName());
        assertSame("red bun", buns.get(2).getName());
    }

    @Test
    public void checkReturnAvailableIngredients() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        assertSame("hot sauce", ingredients.get(0).getName());
        assertSame("sour cream", ingredients.get(1).getName());
        assertSame("chili sauce", ingredients.get(2).getName());
        assertSame("cutlet", ingredients.get(3).getName());
        assertSame("dinosaur", ingredients.get(4).getName());
        assertSame("sausage", ingredients.get(5).getName());
    }
}
