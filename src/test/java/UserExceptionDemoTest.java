import org.junit.Test;
import ru.muctr.Exceptions.Factorial;
import ru.muctr.Exceptions.NumberInvalidForFactorialException;

/**
 * @author Evgenia Skichko
 */
public class UserExceptionDemoTest {

    @Test(expected = NumberInvalidForFactorialException.class)
    public void methodShouldThrowNumberInvalidForFactorialException() throws NumberInvalidForFactorialException {
        Factorial.getFactorial(-5);
    }
}
