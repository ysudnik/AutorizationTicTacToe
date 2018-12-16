package controllers;

import dao.DaoXml;
import objects.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.io.File;

@Component
public class PasswordValidator implements Validator {
    String Path3;
    DaoXml<User> daoXmlUsers;
    User user;
    File file;

    public String getPath3() {
        return Path3;
    }

    public void setPath3(String path3) {
        Path3 = path3;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public DaoXml<User> getDaoXmlUsers() {
        return daoXmlUsers;
    }

    public void setDaoXmlUsers(DaoXml<User> daoXmlUsers) {
        this.daoXmlUsers = daoXmlUsers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "required.password","May be not empty" );

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
                "required.confirmPassword", "May be not empty");

        User user = (User)target;
        if (user.getConfirmPassword()!=null){
        if(!(user.getPassword().equals(user.getConfirmPassword()))) {
            errors.rejectValue("password", "not equal", "passwords not equal ");
            errors.rejectValue("confirmPassword", "not equal", "passwords not equal");
        }
        }

    }
}
