package com.BismaAlifAlghifariJSleepMN.controller;

import com.BismaAlifAlghifariJSleepMN.Algorithm;
import com.BismaAlifAlghifariJSleepMN.dbjson.JsonTable;
import com.BismaAlifAlghifariJSleepMN.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public interface BasicGetController <T extends Serializable> {

    @GetMapping("/{id}")
    public default T getById(
            @PathVariable int id
    ){
        T object = (T) Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);
        return object;
    }

    public abstract JsonTable<T> getJsonTable();

    @GetMapping("/page")
    public default List<T> getPage(
            @RequestParam  int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred -> true);
    }

}
