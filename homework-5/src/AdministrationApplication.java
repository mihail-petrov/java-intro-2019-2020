import java.util.Random;

public class AdministrationApplication {

    static final int INDEX_NOT_FOUND = -1;

    public static void main(String[] args) {

        // 1. Сортиране на въведените числа във възходящ ред
        // 2. Сортиране на въведените числа във визходящ ред
        //int[] collection = new int[]{5, 8, 66, 7, 9, 11, 0, -5, 6, 7, 4};
        //renderCollection(sortCollectionInAscOrder(collection));
        //renderCollection(sortCollectionInDescOrder(collection));

        // 3. Търсене на позиция на конкретно число
//        int[] collection = new int[]{5, 8, 66, 7, 9, 11, 0, -5, 6, 7, 4};
//        renderCollection(sortCollectionInAscOrder(collection));
//        System.out.println(findIndexInCollection(collection, 5));
//        System.out.println(findIndexInCollection(collection, 8));
//        System.out.println(findIndexInCollection(collection, 7));
//        System.out.println(findIndexInCollection(collection, 11));
//        System.out.println(findIndexInCollection(collection, 0));
//        System.out.println(findIndexInCollection(collection, 66));
//        System.out.println(findIndexInCollection(collection, 67));

        // 5.Разбъркване на числата
//        int[] collection = new int[]{5, 8, 66, 7, 9, 11, 0, -5, 6, 7, 4};
//        renderCollection(shuffleCollection(collection));
//        renderCollection(shuffleCollection(collection));
//        renderCollection(shuffleCollection(collection));
//        renderCollection(shuffleCollection(collection));
//        renderCollection(shuffleCollection(collection));

        // 6. Намиране на най-голямото число
//         int[] collection = new int[]{5, 8, 66, 7, 9, 11, 0, -5, 6, 7, 4};
//         System.out.println(findMax(collection));

        // 7. Намиране на най-малкото число
//        int[] collection = new int[]{5, 8, 66, 7, 9, 11, 0, -5, 6, 7, 4};
//        System.out.println(findMin(collection));

        int[] collection = new int[]{5, 8, 66, 7, 9, 11, 0, -5, 6, 7, 4};
        System.out.println(averageOfCollection(collection));

        // 11. Визуализирай въведените числа
        // int[] collection = new int[] {1,2,3,4,5,6,7,8,9,10};
        // renderCollection(collection);
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