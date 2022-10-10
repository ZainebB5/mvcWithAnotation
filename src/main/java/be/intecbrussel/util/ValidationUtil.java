package be.intecbrussel.util;

import be.intecbrussel.model.UserEntity;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;

public class ValidationUtil <T>{
    private  final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    public  boolean validateEntity (T t){
      final var validator = validatorFactory.getValidator();
        final var violations = validator.validate(t);
        if (!violations.isEmpty())
        {
            for (final var violation: violations){
                System.err.println("constraint message : " + violation.getMessage());
            }
            return false;
        }
      return true;
    }
    public long validateList(List<T> tList){
        return tList.stream()
                .map(t -> validateEntity(t))
                .filter(violated -> !violated)
                .count();
    }
}
