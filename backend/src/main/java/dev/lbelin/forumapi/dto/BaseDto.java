package dev.lbelin.forumapi.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class BaseDto {

    @NotNull
    protected Long id;

    @NotBlank
    protected LocalDateTime createdOn;

    @NotBlank
    protected LocalDateTime updatedOn;
}
