package uni.fmi.informatics;

/**
 * Основен клас на приложението, извикващ функционалностите реализирани в проекта
 *
 * @author Константин Русев
 */
public class Main {

    public static void main(String[] args) {
        int[] array = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};

        // Бърза сортировка
        // QuickSort.sort(array);
        // Utility.printArray(array);

        // Сортировка - Пряка селекция
        // SelectionSort.sort(array);
        // Utility.printArray(array);

        /*  Модификатори за достъп:
            1. public
            2. private
            3. protected
            4. package
            5. default: package-private
        */

        ArrayListDemo.testArrayList();
    }
}
