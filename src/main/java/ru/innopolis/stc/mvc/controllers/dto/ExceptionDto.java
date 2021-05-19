/**
 * bse71
 */

package ru.innopolis.stc.mvc.controllers.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
@Getter
public class ExceptionDto {

    private String message;
    private String causeMessage;

}
