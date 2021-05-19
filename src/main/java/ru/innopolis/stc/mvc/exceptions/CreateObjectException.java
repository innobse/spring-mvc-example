/**
 * bse71
 */

package ru.innopolis.stc.mvc.exceptions;

public class CreateObjectException extends RuntimeException {

    public CreateObjectException(String objectName, Exception err) {
        super("Ошибка при создании " + objectName, err);
    }
}
