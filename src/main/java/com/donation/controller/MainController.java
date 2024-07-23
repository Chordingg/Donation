package com.donation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index"; // templates/index.html 파일을 렌더링
    }

    @GetMapping("/inner-page")
    public String innerPage() {
        return "inner-page"; // templates/inner-page.html 파일을 렌더링
    }

    @GetMapping("/portfolio-details")
    public String portfolioDetails() {
        return "portfolio-details"; // templates/portfolio-details.html 파일을 렌더링
    }

}
