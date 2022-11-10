package com.BismaAlifAlghifariJSleepMN.controller;

import com.BismaAlifAlghifariJSleepMN.Account;
import com.BismaAlifAlghifariJSleepMN.Algorithm;
import com.BismaAlifAlghifariJSleepMN.Voucher;
import com.BismaAlifAlghifariJSleepMN.dbjson.JsonAutowired;
import com.BismaAlifAlghifariJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {
    @JsonAutowired(value= Account.class,filepath = "src/json/voucher.json")
    public static JsonTable<Voucher> voucherTable;

    public JsonTable<Voucher> getJsonTable(){
        return voucherTable;
    }

    @GetMapping ("/{id}/isUsed")
    boolean isUsed(
            @PathVariable int id
    ){
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.isUsed();
    }

    @GetMapping("/{id}/canApply")
    boolean canApply(
            @PathVariable int id,
            @RequestParam Double price
    ){
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(),pred -> pred.id == id);
        return voucher.canApply();
    }

    List<Voucher> getAvailable(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> !pred.isUsed());
    }

}
