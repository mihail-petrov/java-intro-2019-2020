package uni.fmi.informatics.algorithms;

/**
 * Изчисляване на факториел чрез рекурсивен подход
 *
 * @author Константин Русев
 */
public class RecursiveFactorial {

    public static void main(String[] args) {
        int number = 6; // 3! = 3 * 2 * 1
        long resultFactorial = calculateFactorial(number);
        System.out.printf("Факториел от: %d e: %d\n", number, resultFactorial);
    }

    /**
     * Mетод, който изчислява факториел от полученото число като входен параметър
     *
     * @param number    числото, на което ще се изчислява факториел
     * @return          изчисленият факториел от полученото като входен параметър число
     */
    public static long calculateFactorial(int number) {

        if (number == 0) {
            return 1; // 0! = 1
        }

        return number * calculateFactorial(number - 1);
    }
}
