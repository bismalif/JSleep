package com.BismaAlifAlghifariJSleepMN.controller;

import com.BismaAlifAlghifariJSleepMN.*;
import com.BismaAlifAlghifariJSleepMN.dbjson.JsonAutowired;
import com.BismaAlifAlghifariJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Account.class,filepath = "src/json/payment.json")
    public static JsonTable<Payment> paymentTable;

    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    @PostMapping("/accept")
    public boolean accept( @RequestParam int id ){
        return false;
    }

    @PostMapping("/cancel")
    public boolean cancel(@RequestParam int id  ){
        return false;
    }

    @PostMapping("/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ) throws ParseException {
        Account account = Algorithm.<Account>find(new AccountController().getJsonTable(), pred -> pred.id == buyerId);
        Room room = Algorithm.<Room>find(new RoomController().getJsonTable(), pred -> pred.id == roomId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);

        if(account == null || room == null || fromDate == null || toDate == null) return null;
        else{
            double price = room.price.price;
            Payment payment = new Payment(buyerId, renterId, roomId, fromDate, toDate);
            account.balance -= price;
            payment.status = Invoice.PaymentStatus.WAITING;
            if(Payment.makeBooking(fromDate, toDate, room)){
                paymentTable.add(payment);
                return payment;
            }
        }
        return null;
    }

}
