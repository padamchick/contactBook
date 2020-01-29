package contactbook.application.validation;


import contactbook.application.model.Credentials;
import contactbook.application.services.CredentialsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {

    @Autowired
    private CredentialsServiceImpl service;

    @Override
    public boolean supports(Class<?> aClass) {
        return Credentials.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Credentials user = (Credentials) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotNull");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotNull");

        if (service.findByEmail(user.getEmail()) == null) {
            errors.rejectValue("email", "Missing.credentials.email");
        } else if (!service.findByEmail(user.getEmail()).getPassword().equals(user.getPassword())) {
            errors.rejectValue("password", "Mismatch.credentials.password");
        }
    }
}
