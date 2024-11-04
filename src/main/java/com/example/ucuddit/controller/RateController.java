package com.example.ucuddit.controller;
import com.example.ucuddit.model.Rate;
import com.example.ucuddit.service.RateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RateController {

    private final RateService rateService;

    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @GetMapping("/total/likes")
    public List<Rate> getAllRates() {
        return rateService.getAllRates();
    }


    @PostMapping("/send/likes")
    public Rate saveTotalLikes(@RequestBody Rate rate) {
        return rateService.saveTotalLikes(rate.getPost().getPostId(), rate.getLikes());
    }
}
