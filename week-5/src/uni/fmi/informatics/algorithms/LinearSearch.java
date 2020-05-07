package uni.fmi.informatics.algorithms;

/**
 * Клас, реализиращ линейно търсене масив
 *
 * @author Константин Русев
 */
public class LinearSearch {

    public static void main(String[] args) {
        int[] array = {23, 45, 21, 55, 234, 1, 34, 90};
        int searchKey = 100;
        System.out.printf(
                "Търсената стойност: %d e намерена на индекс: %d\n",
                searchKey,
                linearSearch(array, searchKey)
        );
    }

    /**
     * Метод, реализиращ линейно търсене в масив
     *
     * @param array масивът, върху който ще извършваме търсенето
     * @param key   елементът, който ще търсим в масива
     * @return      индексът на намерения в масива елемент, ако елементът не е намерен връщаме -1
     */
    public static int linearSearch(int[] array, int key) {
        int size = array.length;

        for (int i = 0; i < size; i++) {

            if (array[i] == key) {
                return i;
            }
        }

        return  -1;
    }

}
