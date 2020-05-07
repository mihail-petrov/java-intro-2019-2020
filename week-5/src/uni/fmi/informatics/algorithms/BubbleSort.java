package uni.fmi.informatics.algorithms;

import java.util.Arrays;

/**
 * Клас, реализиращ сортировка по метода на мехурчето
 *
 * @author Константин Русев
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {3, 6, 45, 4, 32, 1};
        int[] sortedArray = sort(array);

        // System.out.println(Arrays.toString(sortedArray));

        for (int element : array) {
            System.out.print(element + " ");
        }
    }

    /**
     * Метод, който приема като входен параметър несортиран масив и го връща сортиран.
     * За сортировка се използва метод на мехурчето.
     *
     * @param array масив, който трябва да бъде сортиран
     * @return сортиран масив
     */
    public static int[] sort(int[] array) {
        int length = array.length;
        int element;

        for (int i = 1; i < length; i++) {

            for (int j = length - 1; j >= i; j--) {

                if (array[j-1] > array[j]) {
                    element = array[j-1];
                    array[j-1] = array[j];
                    array[j] = element;
                }
            }
        }

        return array;
    }
}
