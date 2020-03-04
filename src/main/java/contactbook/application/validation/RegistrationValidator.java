//package contactbook.application.validation;
//
//import contactbook.application.entity.Credentials;
//import contactbook.application.services.CredentialsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//@Component
//public class RegistrationValidator implements Validator {
//
//    @Autowired
//    private CredentialsServiceImpl service;
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return Credentials.class.equals(aClass);
//    }
//
//    @Override
//    public void validate(Object o, Errors errors) {
//        Credentials user = (Credentials) o;
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotNull");
//
//        if(service.findByEmail(user.getEmail()) != null) {          //sprawdz, czy uzytkownik o takim mailu juz istnieje
//            errors.rejectValue("email", "Duplicate.credentials.email");
//        }
//        if(service.findByUsername(user.getUsername()) != null) {    //sprawdz, czy uzytkownik o takim loginie juz istnieje
//            errors.rejectValue("username", "Duplicate.credentials.username");
//        }
//        if (!user.getConfPassword().equals(user.getPassword())) {      //sprawdz, czy uzytkownik prawidlowo potworzyl haslo
//            errors.rejectValue("confPassword", "Diff.credentials.confPassword");
//        }
//
//    }
//}
