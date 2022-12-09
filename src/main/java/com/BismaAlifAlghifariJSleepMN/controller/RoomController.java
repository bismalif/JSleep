package com.BismaAlifAlghifariJSleepMN.controller;

import com.BismaAlifAlghifariJSleepMN.*;
import com.BismaAlifAlghifariJSleepMN.dbjson.JsonAutowired;
import com.BismaAlifAlghifariJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import com.BismaAlifAlghifariJSleepMN.Price;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {


    @JsonAutowired(value = Room.class, filepath = "src\\json\\room.json")
    public static JsonTable<Room> roomTable;


    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }

    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter
            (
                    @PathVariable int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            ){
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> pred.accountId == id);
    }

    @PostMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam ArrayList<Facility> facility,
            @RequestParam City city,
            @RequestParam String address,
            @RequestParam BedType bedType
    ){
        System.out.println("Id: " + accountId);
        System.out.println("Name: " + name);
        System.out.println("Size: " + size);
        System.out.println("facility: " + facility);
        System.out.println("Address: " + address);
        System.out.println("Bed: " + bedType);
        Account account = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId && pred.renter != null);
        System.out.println(account);
        if(account == null) return null;
        else{
            Room room = new Room(accountId, name, size, new Price(price), facility, city, address, bedType);
            System.out.println(room);
            roomTable.add(room);
            return room;
        }
    }

    @GetMapping("/getAllRoom")
    List<Room> getAllRoom(
            @RequestParam int page,
            @RequestParam int pageSize
            ){
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> true);
    }



}
