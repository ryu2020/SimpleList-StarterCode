// To run this with a default runner try:
// java org.junit.runner.JUnitCore SimpleListTests

// static import gives us access to assert methods without class name
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class SimpleListTests {

  private SimpleList<String> e;
  private SimpleList<String> f;

  // This method is called before EVERY test to set up the testing environment.
  @Before
  public void setUp(){
    e = new MyList<String>();
    f = new MyList<String>();
    f.add("hello");
    f.add("world");
  }

  // Test that isEmpty works

  // Test that size is reported correctly
  @Test
  public void emptySize(){
    assertTrue(e.isEmpty());
  }

  //TODO write one in class to make sure the other list is not empty

  // Test that size is reported correctpy
}
