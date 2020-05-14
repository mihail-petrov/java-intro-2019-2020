package uni.fmi.informatics;

/**
 * Клас, съдържащ помощни методи и функционалности за приложението
 *
 * @author Константин Русев
 */
public class Utility {

    /**
     * Метод, който изпечатва масив, взет като входен параметър, в конзолата
     *
     * @param array масив, който ще се изпечата в конзолата
     */
    public static void printArray(int[] array) {

        for (int element : array) {
            System.out.print(element);
            System.out.print(" ");
        }

        System.out.println();
    }
}
