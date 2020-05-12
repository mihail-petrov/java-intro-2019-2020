public class AdministrationApplication {

    public static void main(String[] args) {

        // 1. Сортиране на въведените числа във възходящ ред
        int[] collection = new int[]{5, 8, 66, 7, 9, 11, 0, -5, 6, 7, 4};
        renderCollection(sortCollectionInAscOrder(collection));


        // 11. Визуализирай въведените числа
        // int[] collection = new int[] {1,2,3,4,5,6,7,8,9,10};
        // renderCollection(collection);
    }

    public static int[] copyCollection(int[] collection) {

        int[] copyOfReferenceCollection = new int[collection.length];

        for(int i = 0; i < collection.length; i++) {
            copyOfReferenceCollection[i] = collection[i];
        }

        return copyOfReferenceCollection;
    }


    public static int[] sortCollectionInAscOrder(int[] collection) {

        // single iteration swap
        // 5, 8, 66, 7, 9, 11, 0, -5, 6, 7, 4
        // 0, 8, 66, 7, 9, 11, 5, -5, 6, 7, 4
        // 0, 8, 66, 7, 9, 11, -5, 5, 6, 7, 4
        // 0, 8, 66, 7, 9, 11, -5, 4, 6, 7, 5

        // single iteration swap
        // 5, 8, 66, 7, 9, 11, 0, -5, 6, 7, 4
        // minimal = -5
        // min index = 7

        int[] referenceCollection       = copyCollection(collection);

        for(int i = 0; i < referenceCollection.length; i++) {

            int currentMinimalElementIndex  = i;
            int currentMinimalElement       = referenceCollection[currentMinimalElementIndex];

            for(int j = (i + 1); j < referenceCollection.length; j++) {

                if(currentMinimalElement > referenceCollection[j]) {

                    currentMinimalElementIndex  = j;
                    currentMinimalElement       = referenceCollection[j];
                }
            }

            int swappableElement = referenceCollection[i];
            referenceCollection[i] = currentMinimalElement;
            referenceCollection[currentMinimalElementIndex] = swappableElement;
        }

        return referenceCollection;
    }

    public static void renderCollection(int[] collection) {

        System.out.print("[");
        for(int i = 0; i < collection.length; i++) {
            System.out.print(collection[i]);

            if(i != (collection.length - 1)) {
                System.out.print(",");
            }
        }
        System.out.println("];");
    }
}