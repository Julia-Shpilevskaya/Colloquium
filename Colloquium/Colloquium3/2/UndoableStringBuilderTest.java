import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UndoableStringBuilderTest {

    @Test
    public void testAppendAndUndo() {
        UndoableStringBuilder builder = new UndoableStringBuilder();
        builder.append("Hello, ");
        builder.append("world!");

        assertEquals("Hello, world!", builder.toString());

        builder.undo();
        assertEquals("Hello, ", builder.toString());

        builder.undo();
        assertEquals("", builder.toString());

        builder.undo(); // Undoing when there are no more operations should do nothing
        assertEquals("", builder.toString());
    }

    @Test
    public void testDeleteAndUndo() {
        UndoableStringBuilder builder = new UndoableStringBuilder();
        builder.append("This is a test string.");

        builder.delete(10, 14);
        assertEquals("This is test string.", builder.toString());

        builder.undo();
        assertEquals("This is a test string.", builder.toString());

        builder.undo(); // Undoing when there are no more operations should do nothing
        assertEquals("This is a test string.", builder.toString());
    }
}