package uni.fmi.informatics;

import uni.fmi.informatics.exception.NonSingleCharacterException;
import uni.fmi.informatics.input.Keyboard;

/**
 * Клас, служещ за отправна точка и стартиране на нашата програма
 *
 * @author Константин Русев
 */
public class Main {

    /**
     * Входната точка за изпълнение на програмата
     *
     */
    public static void main(String[] args) {

        System.out.println("Въведете символ: ");

        try {
            char symbol = Keyboard.readChar();
            System.out.printf("Вие въведохте символът: %s %n", symbol);
        } catch (NonSingleCharacterException e) {
            System.out.println("Въвели сте повече или по-малко от един символ!");
            // System.out.println(e);
            // e.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Възникна неочаквана грешка по време на изпълнение на програмата");
            // ex.printStackTrace();
        } finally {
            System.out.println("---------------------------------");
            System.out.println("Довиждане!");
        }
    }
}
