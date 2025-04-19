package io.github.brunotanabe.generic_microservice_accounts.application.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * The Exception ApplicationException.
 * The ApplicationException exception is used to handle application-specific errors.
 *
 * @Author Bruno Tanabe
 * @CreatedAt 2025-04-19
 */

/**
 * The type Application exception.
 */
@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException {

    private final String message;

    private final HttpStatus httpStatus;
}

