import model.Calculator;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveCalculatorTest {
//    static final Logger LOTTestPositive = LogManager.getLogger(PositiveCalculatorTest.class);

    @DataProvider
    public static Object[][] positiveDataIsDouble() {
        return new Object[][]{
                { "69", true},
                {"-98", true},
                {"4",  true},
                {"0",  true},
                {"4",  true},
                { "30", true},
                { "1", true},
                {"4", true},
                { "0", true},
                {"-2",true},
                {"-0.0", true},
                {"-2.4", true},
                {"2.4", true},
        };
    }

    @Test (dataProvider = "positiveDataIsDouble")
    public void positiveTestIsDouble(Object string, Object two) {
        String str = (String) string;
        boolean bool = (boolean) two;
        Assert.assertEquals(Calculator.isDouble( str), bool, "Позитивный тест запущен");
    }

    @DataProvider
    public static Object[] positiveDataIsZnak() {
        return new Object[][]{
                {"+", true},
                {"-", true},
                {"*", true},
                {"*", true},
                {"/", true},
                {"d", false},
                {"  /d", false},
                {"  /", true},
                {"  /   ", true},
                {"s/", false},
                {" s/", false},
                {" s /", false},
                {"\t/", true},
                {"/\t ", true},
                {"t\t/ ", false},
                {"// ", false},
        };
    }

    @Test (dataProvider = "positiveDataIsZnak")
    public void positiveTestIsZnak(Object string, Object two) {
        String str = (String) string;
        boolean bool = (boolean) two;
        Assert.assertEquals(Calculator.isZnak( str), bool, "Позитивный тест запущен");
    }

    @DataProvider
    public static Object[][] positiveData() {
        return new String[][]{
                {"+", "69", "30", "99.0"},
                {"-", "-98", "1", "-99.0"},
                {"*", "4", "4", "16.0"},
                {"*", "0", "0", "0.0"},
                {"-", "0.0", "-2.4", "2.4"},
                {"*", "2", "4.8", "9.6"},
                {"/", "2", "3", "0.667"},
        };
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String one, String two, String tree, String four) {
        Assert.assertEquals(Calculator.execute(new String[]{one, two, tree}), four, "Позитивный тест запущен");
//        LOTTestPositive.info("позитивное тестированиние");
    }
}
