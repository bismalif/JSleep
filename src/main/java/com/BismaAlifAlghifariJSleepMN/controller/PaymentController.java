package com.BismaAlifAlghifariJSleepMN.controller;

import com.BismaAlifAlghifariJSleepMN.Payment;
import com.BismaAlifAlghifariJSleepMN.dbjson.JsonAutowired;
import com.BismaAlifAlghifariJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class PaymentController {

    @PostMapping("/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    )
    {
        return null;
    }

    @PostMapping("/{id}/cancel")
    public boolean cancel(int id) {
        return false;
    }

    @PostMapping("/{id}/submit")
    public boolean submit(int id) {
        return false;
    }

    @PostMapping("/{id}/accept")
    public boolean accept(int id) {
        return false;
    }

}
