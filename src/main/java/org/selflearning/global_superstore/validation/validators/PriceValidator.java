package org.selflearning.global_superstore.validation.validators;

import org.selflearning.global_superstore.models.Item;
import org.selflearning.global_superstore.validation.annotations.ValidPrice;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriceValidator implements ConstraintValidator<ValidPrice, Item> {

    @Override
    public boolean isValid(Item value, ConstraintValidatorContext context) {
        return value.getPrice() > value.getDiscount();
    }

}
