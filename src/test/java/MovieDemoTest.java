import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.muctr.IO_Demo.StringIO.MovieDemo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author Evgenia Skichko
 */
public class MovieDemoTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    MovieDemo md;

    @Before
    public void setUpOutputStream() {
        System.setOut(new PrintStream(output));
        md = new MovieDemo();
    }

    @Test
    public void methodShouldPrintToConsole(){
        md.printToConsoleForTest();
        Assert.assertEquals("Working", output.toString());
    }

    @After
    public void cleanUpOutputStream() {
        System.setOut(null);
    }
}
