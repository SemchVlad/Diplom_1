package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class IngredientParameterTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParameterTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Проверим что создан ингредиент правильно: " +
            "Тип - \"{0}\", название - \"{1}\", цена - {2}")
    public static Object[][] dataForTest() {
        return new Object[][] {
                { IngredientType.FILLING, "сыр", 2.3F},
                { IngredientType.SAUCE, "кетчуп", 3F},
        };
    }

    @Test
    public void paramTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Тип ингредиента отличается от указанного при создании!",
                type, ingredient.getType());
        assertEquals("Имя ингредиента отличается от указанного при создании!",
                name, ingredient.getName());
        assertTrue("Цена ингредиента отличается от указанной при создании!",
                ingredient.getPrice() == price);
    }
}
