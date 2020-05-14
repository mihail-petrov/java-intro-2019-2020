package uni.fmi.informatics;

/**
 * Клас, реализиращ алгоритъм за сортиране - Пряка селекция
 *
 * @author Константин Русев
 */
public class SelectionSort {

    /**
     * Метод, реализиращ сортировка на масив във възходящ ред
     *
     * @param array масивът, който ще бъде сортиран
     */
    public static void sort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int minElementIndex = i;

            for (int j = i + 1; j < array.length; j++) {

                // за низходящ ред: сменяме > с <
                if (array[minElementIndex] > array[j]) {
                    minElementIndex = j;
                }
            }

            if (minElementIndex != i) {
                int temp = array[i];
                array[i] = array[minElementIndex];
                array[minElementIndex] = temp;
            }
        }
    }
}
