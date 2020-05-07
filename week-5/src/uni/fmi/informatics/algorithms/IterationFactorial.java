package uni.fmi.informatics.algorithms;

/**
 * Изчисляване на факториел чрез итеративен подход
 *
 * @author Константин Русев
 */
public class IterationFactorial {

    public static void main(String[] args) {
        int number = 6;
        long resultFactorial = calculateFactorial(number);
        System.out.printf("Факториел от: %d e: %d\n", number, resultFactorial);
    }

    /**
     * Метод, който изчислява факториел от полученото като входен параметър число
     *
     * @param number    числото, на което ще изчисляваме факториел
     * @return          изчисленият факториел от полученото като входен параметър число
     */
    public static long calculateFactorial(int number) {
        long result = 1;

        for (int i = 1; i <= number; i++) {
            result = result * i;
        }

        return result;
    }
}
