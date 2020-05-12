import java.util.Random;
import java.util.Scanner;

public class AdministrationApplication {

    static final int INDEX_NOT_FOUND = -1;

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);
        int countOfElements;
        int menuOption;
        boolean isRunning = true;

        System.out.print("Въведете колко на брой числа ще въвеждате.");
        countOfElements = inputScanner.nextInt();
        int[] inputCollection = new int[countOfElements];

        for(int i = 0; i < countOfElements; i++) {
            inputCollection[i] = readInputValue(inputScanner);
        }

        while(isRunning) {

            renderMenu();
            menuOption = inputScanner.nextInt();

            if (menuOption == 1) {
                renderCollection(sortCollectionInAscOrder(inputCollection));
            }

            if (menuOption == 2) {
                renderCollection(sortCollectionInDescOrder(inputCollection));
            }

            if (menuOption == 3) {

                System.out.print("Въведете числото, чиято позиция искате да намерите:");
                int findInput       = inputScanner.nextInt();
                int operationIndex  = findIndexInCollection(inputCollection, findInput);
                String message      = (operationIndex == INDEX_NOT_FOUND) ? "Числото" + findInput + " не е намерено."
                                                                          : "Числото" + findInput + " е намерено на позиция " + operationIndex;
                System.out.println(message);
            }

            if (menuOption == 4) {
                renderCollection(shuffleCollection(inputCollection));
            }

            if (menuOption == 5) {
                System.out.println(sumNumber(inputCollection));
            }

            if (menuOption == 6) {
                System.out.println(findMin(inputCollection));
            }

            if (menuOption == 7) {
                System.out.println(findMax(inputCollection));
            }

            if (menuOption == 8) {
                System.out.println(averageOfCollection(inputCollection));
            }

            if (menuOption == 9) {

                String message = isCollectionSymmetrical(inputCollection) ? "Масивът е симетричен"
                                                                          : "Масивът не е симетричен";
                System.out.println(message);
                renderCollection(inputCollection);
            }

            if (menuOption == 10) {
                renderCollection(reverseCollection(inputCollection));
            }

            if (menuOption == 11) {
                renderCollection(inputCollection);
            }

            if (menuOption == 12) {
                isRunning = false;
            }
        }
    }

    public static int readInputValue(Scanner scannerReference) {

        while(true) {

            System.out.print("Въведете число по-голямо от нула и по-малко от 100:");
            int input = scannerReference.nextInt();
            if(input >= 0 && input <= 100) {
                return input;
            }

            System.out.println("Ти тотално обърка всичко");
        }
    }

    public static void renderMenu() {

        System.out.println("1. Сортиране на въведените числа във възходящ ред");
        System.out.println("2. Сортиране на въведените числа в низходящ ред");
        System.out.println("3. Търсене на позиция на конкретно число");
        System.out.println("4. Разбъркване на числата");
        System.out.println("5. Изчисляване на сбора на всички числа");
        System.out.println("6. Намиране на най-голямото число");
        System.out.println("7. Намиране на най-малкото число");
        System.out.println("8. Намиране средно-аритметично на числата");
        System.out.println("9. Проверка за симетричност на масива от числа");
        System.out.println("10. Обръщане на масива от числа");
        System.out.println("11. Визуализирай въведените числа");
        System.out.println("12. Изход");
    }

    private static int[] reverseCollection(int[] collection) {

        int[] referenceCollection = new int[collection.length];
        int i = collection.length - 1;
        int j = 0;
        for(; i >= 0; i--, j++) {
            referenceCollection[j] = collection[i];
        }
        return referenceCollection;
    }

    public static int[] copyCollection(int[] collection) {

        int[] copyOfReferenceCollection = new int[collection.length];

        for (int i = 0; i < collection.length; i++) {
            copyOfReferenceCollection[i] = collection[i];
        }

        return copyOfReferenceCollection;
    }

    public static int[] sortCollection(int[] collection, boolean ascOrder) {

        int[] referenceCollection = copyCollection(collection);

        for (int i = 0; i < referenceCollection.length; i++) {

            int currentMinimalElementIndex = i;
            int currentMinimalElement = referenceCollection[currentMinimalElementIndex];

            for (int j = (i + 1); j < referenceCollection.length; j++) {

                boolean isAscending = (ascOrder && (currentMinimalElement > referenceCollection[j]));
                boolean isDescending = (!ascOrder && (currentMinimalElement < referenceCollection[j]));
                boolean isOrderable = isAscending || isDescending;

                if (isOrderable) {
                    currentMinimalElementIndex = j;
                    currentMinimalElement = referenceCollection[j];
                }
            }

            int swappableElement = referenceCollection[i];
            referenceCollection[i] = currentMinimalElement;
            referenceCollection[currentMinimalElementIndex] = swappableElement;
        }

        return referenceCollection;
    }

    public static int[] sortCollectionInAscOrder(int[] collection) {
        return sortCollection(collection, true);
    }

    public static int[] sortCollectionInDescOrder(int[] collection) {
        return sortCollection(collection, false);
    }

    public static int getBinarySearchMidIndex(int startIndex, int endIndex) {
        return startIndex + (endIndex - startIndex) / 2;
    }

    public static int findIndexInCollection(int[] collection, int serchableValue) {

        int[] sortedCollection = sortCollection(collection, true);
        int startIndex = 0;
        int endIndex = collection.length;

        while (startIndex < endIndex) {

            // 1 .
            // int midIndex = (sortedCollection.length / 2); // ?
            int midIndex = getBinarySearchMidIndex(startIndex, endIndex);
            int midValue = sortedCollection[midIndex];

            if (serchableValue < midValue) {
                endIndex = midIndex;
            }

            if (serchableValue > midValue) {
                startIndex = midIndex + 1;
            }

            if (serchableValue == midValue) {
                return midIndex;
            }
        }

        return INDEX_NOT_FOUND;
    }

    public static int[] shuffleCollection(int[] collection) {

        int[] referenceCollection = copyCollection(collection);

        Random randomGenerator = new Random();

        for (int i = 0; i < referenceCollection.length; i++) {

            int shuffalbleIndex = randomGenerator.nextInt(referenceCollection.length);
            int shafflableElement = referenceCollection[shuffalbleIndex];
            int initElement = referenceCollection[i];
            referenceCollection[i] = shafflableElement;
            referenceCollection[shuffalbleIndex] = initElement;
        }

        return referenceCollection;
    }

    public static int sumNumber(int[] collection) {

        int sum = 0;
        for(int i = 0; i < collection.length; i++) {
            sum +=    collection[i];
        }

        return sum;
    }

    public static double averageOfCollection(int[] collection) {

        int collectionSum   = sumNumber(collection);
        int length          = collection.length;

        return collectionSum / (double)length;
    }

    public static int findLimit(int[] collection, boolean isLimitMin) {

        int minElement = collection[0];
        for(int i = 1; i < collection.length; i++) {

            boolean isMinLimited = (isLimitMin && (minElement > collection[i]));
            boolean isMaxLimited = (!isLimitMin && (minElement < collection[i]));
            boolean isLimited = isMinLimited || isMaxLimited;

            if(isLimited) {
                minElement = collection[i];
            }
        }

        return minElement;
    }

    public static int findMin(int[] collection) {
        return findLimit(collection, true);
    }

    public static int findMax(int[] collection) {
        return findLimit(collection, false);
    }

    public static boolean isCollectionSymmetrical(int[] collection) {

        int i = 0;
        int j = (collection.length - 1);
        for(; i < j; i++, j--) {
            if(collection[i] != collection[j]) {
                return false;
            }
        }
        return true;
    }

    public static void renderCollection(int[] collection) {

        System.out.print("[");
        for (int i = 0; i < collection.length; i++) {
            System.out.print(collection[i]);

            if (i != (collection.length - 1)) {
                System.out.print(",");
            }
        }
        System.out.println("];");
    }
}