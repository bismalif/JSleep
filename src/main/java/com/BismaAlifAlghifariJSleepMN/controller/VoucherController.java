package com.BismaAlifAlghifariJSleepMN.controller;

import com.BismaAlifAlghifariJSleepMN.Account;
import com.BismaAlifAlghifariJSleepMN.Algorithm;
import com.BismaAlifAlghifariJSleepMN.Price;
import com.BismaAlifAlghifariJSleepMN.Voucher;
import com.BismaAlifAlghifariJSleepMN.dbjson.JsonAutowired;
import com.BismaAlifAlghifariJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to represent a voucher controller.
 * @author Bisma Alif Alghifari
 * @version 1.0
 */

@RestController
@RequestMapping("/voucher")

public class VoucherController implements BasicGetController<Voucher> {
    @JsonAutowired(value= Account.class,filepath = "src\\json\\voucher.json")
    public static JsonTable<Voucher> voucherTable;

    /**
     * This method is used to get the voucher.
     * @return The voucher.
     */
    @Override
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }


    @GetMapping("/{id}/isUsed")
    boolean isUsed(
            @RequestParam int id
    ){
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.isUsed();
    }


    @GetMapping("/{id}/canApply ")
    boolean canApply(
            @RequestParam int id,
            @RequestParam double price
    ){
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.canApply(new Price(price));
    }


    @GetMapping("/getAvailable")
    List<Voucher> getAvailable(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        List<Voucher> collectVoucher = Algorithm.<Voucher>collect(getJsonTable(), pred -> true);
        List<Voucher> availableVoucher = new ArrayList<>();
        for(Voucher voucher : collectVoucher){
            if(!voucher.isUsed()){
                availableVoucher.add(voucher);
            }
        }
        return Algorithm.<Voucher>paginate(availableVoucher, page, pageSize, pred -> true);
    }

}
