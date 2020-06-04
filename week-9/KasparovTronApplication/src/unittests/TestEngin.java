package unittests;

import java.util.ArrayList;

class TestEngin {

    private ArrayList<UnitTest> testObjectCollection;

    public TestEngin() {
        this.testObjectCollection = new ArrayList<>();
    }

    public void register(UnitTest testObject) {
        this.testObjectCollection.add(testObject);
    }

    public void run() {

        for(UnitTest element : testObjectCollection) {
            element.run();
        }
    }
}
