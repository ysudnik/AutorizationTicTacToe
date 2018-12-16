package controllers;

import javax.servlet.http.HttpServletRequest;

import dao.DaoXml;
import objects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class StartController {
    String Path3;
    DaoXml<User> daoXmlUsers;
    File file;

    public String getPath3() {
        return Path3;
    }

    public void setPath3(String path3) {
        Path3 = path3;
    }

    public DaoXml<User> getDaoXmlUsers() {
        return daoXmlUsers;
    }

    public void setDaoXmlUsers(DaoXml<User> daoXmlUsers) {
        this.daoXmlUsers = daoXmlUsers;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Autowired
    PasswordValidator passwordValidator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String GetUser(Model model) {
        model.addAttribute("userParam", new User());
        return "autorization";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String GetUser2(Model model) {
        model.addAttribute("userParam", new User());
        return "registration";
    }

    @RequestMapping(value = "/autorization", method = RequestMethod.POST)
    public String Autorization(@Valid @ModelAttribute("userParam") User user,
                               BindingResult bindingResult) {
        passwordValidator.validate(user, bindingResult);
        if (bindingResult.getErrorCount() > 0) {
            return "autorization";
        } else {
            String page = null;
            if ((new File(Path3)).exists()) {
                List<User> fullusers = daoXmlUsers.getAll(Path3, User.class);
                if (!fullusers.isEmpty()) {
                    for (User user1 : fullusers) {
                        if (user1.getName().equals(user.getName()) && user1.getPassword().equals(user.getPassword())) {
                            page = "redirect:/startGame";
                            return page;

                        } else {
                            page = "autorization";
                        }

                    }
                } else {
                    page = "redirect:/reg";
                }
            } else {
                page = "redirect:/reg";
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            return page;

        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String Registration(@Valid @ModelAttribute("userParam") User user,
                               BindingResult bindingResult) {
        passwordValidator.validate(user, bindingResult);
        if (bindingResult.getErrorCount() > 0) {
            return "registration";
        } else {
            String page;
            if ((new File(Path3)).exists()) {
                List<User> fullusers = daoXmlUsers.getAll(Path3, User.class);
                for (User user1 : fullusers) {
                    if (user1.getName().equals(user.getName())) {
                        page = "registration";
                        return page;
                    }
                }
                daoXmlUsers.add(user, Path3, User.class, "users");
                page = "autorization";
                return page;
            } else {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                daoXmlUsers.add(user, Path3, User.class, "users");
                daoXmlUsers.getAll(Path3,User.class);
                page = "autorization";
                return page;
            }
        }
    }

}
