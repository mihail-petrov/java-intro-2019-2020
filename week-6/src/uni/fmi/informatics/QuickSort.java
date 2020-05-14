package uni.fmi.informatics;

/**
 * Клас, реализиращ алгоритъм за сортиране - Бърза сортировка
 *
 * @author Константин Русев
 */
public class QuickSort {

    /**
     * Метод, реализиращ валидации и сортировка на масив
     *
     * @param array масивът, който ще бъде сортиран
     */
    public static void sort(int[] array) {

        if (array == null || array.length == 0) {
            System.err.println("Масивът не е създаден или не съдържа стойности");
            return;
        }

        System.out.println("================== Бърза сортировка ==================");
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Метод, реализиращ сортиране на масив чрез алгоритъм - Бърза сортировка
     *
     * @param array      масив, който ще бъде сортиран
     * @param leftIndex  краен ляв елемент на масив (начало)
     * @param rightIndex краен десен елемент на масив (край)
     */
    public static void quickSort(int[] array, int leftIndex, int rightIndex) {
        int temp;
        int left  = leftIndex;
        int right = rightIndex;
        int pivot = array[(leftIndex + rightIndex) / 2];

        do {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        } while (left <= right);

        if (leftIndex < right) {
            quickSort(array, leftIndex, right);
        }

        if (left < rightIndex) {
            quickSort(array, left, rightIndex);
        }
    }
}
