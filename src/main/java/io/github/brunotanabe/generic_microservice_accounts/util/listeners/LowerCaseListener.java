package io.github.brunotanabe.generic_microservice_accounts.util.listeners;

import io.github.brunotanabe.generic_microservice_accounts.application.entities.dtos.ApplicationException;
import io.github.brunotanabe.generic_microservice_accounts.util.annotations.NotModifyField;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.http.HttpStatus;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * The Class LowerCaseListener.
 * The LowerCaseListener class is responsible for transforming the string fields of an entity to lowercase.
 *
 * @Author Bruno Tanabe
 * @CreatedAt 2025-04-19
 */

/**
 * The type Lower case listener.
 */
public class LowerCaseListener {

    /**
     * Transform.
     *
     * @param entity the entity
     */
    @PrePersist
    @PreUpdate
    public void transform(Object entity) {
        try {
            Field[] fields = entity.getClass().getDeclaredFields();

            for (Field field : fields) {

                if (!field.isAnnotationPresent(NotModifyField.class) && field.getType().equals(String.class)) {

                    field.setAccessible(true);
                    String fieldValue = (String) field.get(entity);

                    if (Objects.nonNull(fieldValue)) {
                        field.set(entity, fieldValue.toLowerCase());
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new ApplicationException("Não foi possível a transformação", HttpStatus.BAD_REQUEST);
        }
    }
}
