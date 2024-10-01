package br.com.eadtt.aula01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerFora {
    @GetMapping("/fora")
    @ResponseBody
    public String hello() {
        return "index.html";
    }
}
