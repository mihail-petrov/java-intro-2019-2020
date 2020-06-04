package unittests;

public class TestExecute {

    public static void run() {

        TestEngin executeUnitTest = new TestEngin();
        executeUnitTest.register(new PawnTest());
        executeUnitTest.register(new RookTest());

        executeUnitTest.run();
    }
}
