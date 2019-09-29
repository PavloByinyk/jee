package com.example.spboot.controller;

import com.example.spboot.domain.User;
import com.example.spboot.domain.dto.CaptchaResponseDTO;
import com.example.spboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    private static final String CAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${recaptcha.secret}")
    private String captchaSecret;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            @RequestParam("g-recaptcha-response") String captchaResponse,
            @RequestParam("password2") String passwordConfirmation,
            @Valid User user,
            BindingResult bindingResult,
            Model model){

        String url = String.format(CAPTCHA_URL, captchaSecret, captchaResponse);

        CaptchaResponseDTO response = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponseDTO.class);

        if(!response.isSuccess()){
            model.addAttribute("captchaError", "Fill captcha");
        }


        boolean isConfirmPasswordEmpty = StringUtils.isEmpty(passwordConfirmation);
        if(isConfirmPasswordEmpty){
            model.addAttribute("password2Error", "Please fill the password confirmation");

        }
        if(user.getPassword() != null && !user.getPassword().equals(passwordConfirmation)){
            model.addAttribute("message", "Passwords dont match");
        }

        if(isConfirmPasswordEmpty || bindingResult.hasErrors() || !response.isSuccess()){
            model.mergeAttributes(ControllerUtils.getErrors(bindingResult));
            return "registration";
        }

        if(!userService.addUser(user)){
            model.addAttribute("usernameError", "User exists!");
            return "registration";
        }
        return "redirect:/login";
    }


    @GetMapping("/activate/{code}")
    public String activate(@PathVariable String code, Model model){
        boolean isActivated = userService.activateUser(code);
        if(isActivated){
            model.addAttribute("message", "User successfully activated");
        }else {
            model.addAttribute("message", "Activation code is not found");
        }
        return "login";
    }

}
