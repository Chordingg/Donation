package com.donation.controller;

import com.donation.entity.Donation;
import com.donation.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/donations")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @GetMapping("/new")
    public String showDonationForm(Model model) {
        model.addAttribute("donation", new Donation());
        return "/donation/donation-form";
    }

    @PostMapping("/new")
    public String addDonation(@ModelAttribute Donation donation, @RequestParam("file") MultipartFile file) {
        donationService.saveDonation(donation, file);
        return "redirect:/donations/list";
    }

    @GetMapping("/list")
    public String listDonations(Model model) {
        model.addAttribute("donations", donationService.getAllDonations());
        return "/donation/donation-list";
    }
}
