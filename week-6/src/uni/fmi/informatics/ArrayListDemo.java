package uni.fmi.informatics;

import java.util.ArrayList;

/**
 * Клас, реализиращ работа със списъчна структура (списък) - {@code ArrayList}
 *
 * @author Константин Русев
 */
public class ArrayListDemo {

    /**
     * Метод, реализиращ пример за работа с {@code ArrayList}
     *
     */
    public static void testArrayList() {
        ArrayList<String> foodList = new ArrayList<>();

        if (foodList.isEmpty()) {
            System.out.println("Списъкът е празен!");
        }

        foodList.add("Pizza");
        foodList.add("Pizza");
        foodList.add("Pizza");

        System.out.println("След добавянето на пиците: ");
        System.out.println(foodList);

        foodList.add(2, "Salad");
        System.out.println("След добавянето на салатата: ");
        System.out.println(foodList);

        foodList.add("Spagetti");
        System.out.println("След добавянето на спагетите: ");
        System.out.println(foodList);

        foodList.remove(0);
        System.out.println("След премахването на първия елемент:");
        System.out.println(foodList);

        if (!foodList.contains("Bread")) {
            System.out.println("Няма хляб!");
        }

        ArrayList<String> newFoodList = new ArrayList<>();
        newFoodList.add("Apple");
        newFoodList.add("Cherry");

        foodList.addAll(newFoodList);
        System.out.println("След добавянето на цял списък: ");
        System.out.println(foodList);
    }
}
