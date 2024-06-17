package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.bindng.UserRegisterDTO;
import com.dictionaryapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("registerData")
    public UserRegisterDTO createEmptyDTO() {
        return new UserRegisterDTO();
    }

    @GetMapping("/register")
    public String viewRegister() {

        return "register";
    }

    @PostMapping("/register")
    public String doRegister(
            @Valid UserRegisterDTO data, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userService.register(data)){
            redirectAttributes.addFlashAttribute("registerData", data);
            redirectAttributes.addFlashAttribute(
                    "org.spring.framework.validation.BindingResult.registerData", bindingResult);

            return "redirect:/register";
        }


        return "redirect:/login";
    }
}