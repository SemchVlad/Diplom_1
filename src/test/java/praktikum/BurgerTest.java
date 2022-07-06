package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient2;
    @Mock
    Ingredient ingredient3;

    @Test
    public void checkSetBuns(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Черная булка");
        assertEquals(bun.getName(), burger.bun.getName());
    }

    @Test
    public void checkAddIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Ingredient addedIngredient = burger.ingredients.get(burger.ingredients.indexOf(ingredient));
        Mockito.when(ingredient.getName()).thenReturn("Кетчуп");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);

        assertEquals(1, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(ingredient));
        assertSame(addedIngredient.getName(), ingredient.getName());
        assertTrue(burger.ingredients.contains(ingredient));
        assertSame(addedIngredient.getType(), ingredient.getType());
    }

    @Test
    public void checkRemoveIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        int addedIngredientIndex = burger.ingredients.indexOf(ingredient);
        assertEquals(1, burger.ingredients.size());
        burger.removeIngredient(addedIngredientIndex);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void checkMoveIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        int IngredientIndex = burger.ingredients.indexOf(ingredient);

        burger.moveIngredient(IngredientIndex, 2);
        assertEquals(ingredient, burger.ingredients.get(2));
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient3, burger.ingredients.get(1));
    }

    @Test
    public void checkGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        Mockito.when(bun.getPrice()).thenReturn(2F);
        Mockito.when(ingredient.getPrice()).thenReturn(3F);
        Mockito.when(ingredient2.getPrice()).thenReturn(5.5F);

        assertEquals(12.5F, burger.getPrice(), 0.0F);
    }

    @Test
    public void checkGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        Mockito.when(bun.getPrice()).thenReturn(2F);
        Mockito.when(ingredient.getPrice()).thenReturn(3F);
        Mockito.when(ingredient2.getPrice()).thenReturn(5.5F);
        Mockito.when(bun.getName()).thenReturn("Черная булочка");
        Mockito.when(ingredient.getName()).thenReturn("Кетчуп");
        Mockito.when(ingredient2.getName()).thenReturn("Куриная котлета");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);

        String expected = String.format("(==== %s ====)%n", bun.getName());
        expected += String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                ingredient.getName());
        expected += String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(),
                ingredient2.getName());
        expected += String.format("(==== %s ====)%n", bun.getName());
        expected += String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(expected, burger.getReceipt());
    }
}
