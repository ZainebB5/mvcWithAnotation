package be.intecbrussel.util;

import be.intecbrussel.model.UserEntity;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidationUtil <T>{
    private  final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    public  boolean ValidateEntity (T t){
      final var validator = validatorFactory.getValidator();
        final var violations = validator.validate(t);
        if (!violations.isEmpty())
        {
            for (final var violation: violations){
                System.err.println(violation.getMessage());
            }
            return false;
        }
      return true;
    }
}
