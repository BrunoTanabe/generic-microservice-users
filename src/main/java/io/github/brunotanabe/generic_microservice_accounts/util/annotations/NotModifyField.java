package io.github.brunotanabe.generic_microservice_accounts.util.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Annotation NotModifyField.
 * The NotModifyField annotation is responsible for indicating that the field should not be modified.
 *
 * @Author Bruno Tanabe
 * @CreatedAt 2025-04-19
 */

/**
 * The interface Not modify field.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotModifyField {
}

