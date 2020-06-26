package org.example.validation;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleServletException(Exception exception, Model model) {
        model.addAttribute("nameEx", exception.getLocalizedMessage());
        return "exception";
    }
}
