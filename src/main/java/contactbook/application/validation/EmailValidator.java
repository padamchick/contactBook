package contactbook.application.validation;

import contactbook.application.model.Credentials;
import contactbook.application.services.CredentialsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class EmailValidator implements Validator {

    @Autowired
    private CredentialsServiceImpl service;

    @Override
    public boolean supports(Class<?> aClass) {
        return Credentials.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Credentials user = (Credentials) o;

    }
}
