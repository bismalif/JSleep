package com.BismaAlifAlghifariJSleepMN.controller;

import com.BismaAlifAlghifariJSleepMN.Algorithm;
import com.BismaAlifAlghifariJSleepMN.dbjson.JsonTable;
import com.BismaAlifAlghifariJSleepMN.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 * This class is used to represent a basic get controller.
 * @param <T> The type of the object.
 */
@RestController
public interface BasicGetController <T extends Serializable> {
    /**
     * This method is used to get the json table.
     * @return The json table.
     */
    @GetMapping("/{id}")
    public default T getById(
            @PathVariable int id
    ){
        T object = (T) Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);
        return object;
    }

    /**
     * This method is used to get the json table.
     * @return The json table.
     */
    public abstract JsonTable<T> getJsonTable();

    /**
     * This method is used to get all the objects.
     * @return The list of objects.
     */
    @GetMapping("/page")
    public default List<T> getPage(
            @RequestParam  int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred -> true);
    }

}
