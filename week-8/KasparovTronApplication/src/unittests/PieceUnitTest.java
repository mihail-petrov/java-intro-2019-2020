package unittests;

abstract class PieceUnitTest extends UnitTest {

    public void testGroup(String groupName) {

        System.out.println(groupName);
        System.out.println("=================");
    }

    public void testMessage(String testName, int initRow, int externalRow, int initCol, int externalCol) {

        System.out.println(String.format("%s:", testName));
        System.out.print(String.format("Move from %d to %d row and %d to %d col:",  initRow,
                                                                                    externalRow,
                                                                                    initCol,
                                                                                    externalCol));
    }
}
