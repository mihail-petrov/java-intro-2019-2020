package uni.fmi.informatics.input;

import uni.fmi.informatics.exception.NonSingleCharacterException;

import java.util.Scanner;

/**
 * Помощен клас, съдържащ методи за четене от конзолата
 *
 * @author Константин Русев
 */
public class Keyboard {

    public static final Scanner scanner = new Scanner(System.in);

    /**
     * Конструктор по подразбиране, който забранява създаването на обекти от този клас извън него
     */
    private Keyboard() {

    }

    /**
     * Метод, валидиращ дали подадената като входен параметър стойност има само един символ.
     * Ако съдържа само един символ - го връща.
     * Ако съдържа повече или по-малко от един символ - хвърля грешка.
     *
     * @return  валидиран символ от тип {@code char}
     * @throws NonSingleCharacterException  грешката, която се хвърля при невалидна стойност
     */
    public static char readChar() throws NonSingleCharacterException {
        String inputValue = scanner.next();
        char validatedInput = validateChar(inputValue);

        checkInputType(validatedInput);

        return validatedInput;
    }

    /**
     * Метод, валидиращ дали подадената като входен параметър стойност има само един символ.
     * Ако съдържа само един символ - го връща.
     * Ако съдържа повече или по-малко от един символ - хвърля грешка.
     *
     * @param inputValue  стойността, която ще се проверява, дали е валидна стойност от тип {@code char}
     * @return  валидиран символ от тип {@code char}
     * @throws NonSingleCharacterException  грешката, която се хвърля при невалидна стойност
     */
    private static char validateChar(String inputValue) throws NonSingleCharacterException {
        if (inputValue.length() != 1) {
            throw new NonSingleCharacterException();
        }

        return inputValue.charAt(0);
    }

    /**
     * Метод, който проверява дали символът е цифра, буква или специален символ
     *
     * @param inputChar стойността, която ще се проверява дали е цифра, буква или специален символ
     */
    private static void checkInputType(char inputChar) {
        if (Character.isLetter(inputChar)) {
            System.out.printf("Въведеният символ: %s e буква! %n", inputChar);
        } else if (Character.isDigit(inputChar)) {
            System.out.printf("Въведеният символ: %s e цифра! %n", inputChar);
        } else {
            System.out.printf("Въведеният символ: %s e специален символ! %n", inputChar);
        }
    }
}
