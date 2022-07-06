package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void verifyDisplayNameAndPrice(){
        Bun bun = new Bun("Чиабатта", 2);
        assertEquals("Чиабатта", bun.getName());
        assertEquals(2F, bun.getPrice(), 0.0);
    }

}
