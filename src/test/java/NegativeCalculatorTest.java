import model.Calculator;
import model.CalculatorException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeCalculatorTest {
    static final Logger LOGTestNegat = LogManager.getLogger(NegativeCalculatorTest.class);

    @DataProvider
    public static Object[] [] negativeData() {
        return new String[][]{
                {"+", "1", "100"},
                {"-", "-99", "1"},
                {"*", "50", "2"},
                {"*", "50", "-2"},
                {"*/", "-1.1", "-0.0"},
                {"+", "null", "null"},
                {"*", "one", "two"},
                {"+", null, null},
                {"-", "one", "two"},
                {"plus", "1", "1"},
                {"/", "4", "0"},
                {"/", "1", "0"},
                {"/", "-1.1", "0.0"},
        };
    }

    @Test(dataProvider = "negativeData", expectedExceptions = CalculatorException.class)
    public void negativeTest(String one, String two, String tree) {
        Calculator.execute(new String[]{one, two, tree});
        LOGTestNegat.info("Негативное тестированиниеб выход за рамки ");
    }

}