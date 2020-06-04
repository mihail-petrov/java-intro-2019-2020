package unittests;

abstract class UnitTest {

    public abstract void run();

    protected void assertIsTrue(boolean testExpression) {

        if(testExpression) {
            System.out.println("Correct");
        }
        else {
            System.out.println("Incorect");
        }
    }

    protected void assertIsFalse(boolean testExpression) {
        assertIsTrue(!testExpression);
    }
}