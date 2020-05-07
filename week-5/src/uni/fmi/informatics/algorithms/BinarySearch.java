package uni.fmi.informatics.algorithms;

/**
 * Клас, реализиращ двоично търсене
 *
 * @author Константин Русев
 */
public class BinarySearch {

    public static final int ELEMENT_NOT_FOUND = -1;
    public static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        int elementToFind = 100;
        int foundElementIndex = binarySearch(elementToFind, 0, array.length - 1);

        if (foundElementIndex == ELEMENT_NOT_FOUND) {
            System.err.print("Елементът не е намерен!\n");
        } else {
            System.out.printf(
                    "Елементът е намерен на позиция: %d\n",
                    (foundElementIndex + 1)
            );
        }
    }

    /**
     * Метод, реализиращ двоично търсене в масив
     *
     * @param element    елементът, който ще търсим в масива
     * @param leftIndex  краен ляв индекс на масив (начален индекс)
     * @param rightIndex краен десен индекс на масив (последен индекс)
     * @return           индексът на намерения елемент в масива, ако елементът не е намерен връщаме -1
     */
    public static int binarySearch(int element, int leftIndex, int rightIndex) {
        int left = leftIndex;
        int right = rightIndex;
        int middle = (left + right) / 2;

        while (left <= right) {
            if (element == array[middle]) {
                return middle;
            } else if (element < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }

            middle = (left + right) / 2;
        }

        return ELEMENT_NOT_FOUND;
    }
}
