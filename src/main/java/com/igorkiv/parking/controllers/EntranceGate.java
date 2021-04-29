package com.igorkiv.parking.controllers;

import com.igorkiv.parking.service.ParkingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class EntranceGate {

//    @Qualifier("ParkingServiceImpl")
    private final ParkingService parkingService;

    @GetMapping({"","/"})
    String indexPage(Model model){
        model.addAttribute("parkingSpaces",parkingService.showAll());
        model.addAttribute("freeSpaces",parkingService.freeSpaces());
        return "index";
    }

    @GetMapping("/entry")
    String entry(Model model)
    {
        if (parkingService.entrance()) {
            model.addAttribute("parkingInformation", "Welcome");
        } else {
            model.addAttribute("parkingInformation", "No free places!");
        }
        model.addAttribute("parkingSpaces",parkingService.showAll());
        model.addAttribute("freeSpaces",parkingService.freeSpaces());
        return "index";
    }

    @GetMapping("/departure")
    String departure(Model model)
    {
        parkingService.exit();
        model.addAttribute("parkingSpaces",parkingService.showAll());
        model.addAttribute("freeSpaces",parkingService.freeSpaces());
        return "index";
    }
}
