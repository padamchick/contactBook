package contactbook.application.validation;


import contactbook.application.model.Credentials;
import contactbook.application.services.CredentialsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {

    @Autowired
    private CredentialsServiceImpl service;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean supports(Class<?> aClass) {
        return Credentials.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Credentials user = (Credentials) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotNull");


        if (service.findByUsername(user.getUsername()) == null) {
            errors.rejectValue("username", "Missing.credentials.username");

        }
//        else if (!service.findByUsername(user.getUsername()).getPassword().equals(user.getPassword())) {
//            errors.rejectValue("password", "Mismatch.credentials.password");
//        }
    }
}
