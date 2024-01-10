import org.junit.Test;
import static org.junit.Assert.*;

public class FurnitureFactoryTest {
    @Test
    public void testModernFurniture() {
        FurnitureFactory factory = new ModernFurnitureFactory();
        Chair chair = factory.createChair();
        Table table = factory.createTable();

        assertEquals("ModernChair", chair.getClass().getSimpleName());
        assertEquals("ModernTable", table.getClass().getSimpleName());
    }

    @Test
    public void testVictorianFurniture() {
        FurnitureFactory factory = new VictorianFurnitureFactory();
        Chair chair = factory.createChair();
        Table table = factory.createTable();

        assertEquals("VictorianChair", chair.getClass().getSimpleName());
        assertEquals("VictorianTable", table.getClass().getSimpleName());
    }
}
