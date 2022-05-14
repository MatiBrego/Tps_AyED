import org.junit.Test;

public class TestPathBuilder {
    @Test
    public void test_recursive_peek() {
        PathBuilder my_path = new PathBuilder();
        my_path.recursive_peek(new Position(1, 1), 4, "");
    }
}
