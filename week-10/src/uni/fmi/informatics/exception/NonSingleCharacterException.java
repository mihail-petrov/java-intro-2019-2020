package uni.fmi.informatics.exception;

/**
 * Клас, дефиниращ изключение, което служи за обработка на невалидни символи - {@code char}
 *
 * @author Константин Русев
 */
public class NonSingleCharacterException extends Exception {

    @Override
    public String toString() {
        return "Non Single Character Exception";
    }
}
