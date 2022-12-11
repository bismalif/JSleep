package com.BismaAlifAlghifariJSleepMN.controller;

import com.BismaAlifAlghifariJSleepMN.*;
import com.BismaAlifAlghifariJSleepMN.dbjson.JsonAutowired;
import com.BismaAlifAlghifariJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import com.BismaAlifAlghifariJSleepMN.Price;

import java.util.ArrayList;
import java.util.List;

/**
 * A REST controller that provides methods to create, get room by renter, get all room, and filter the room list.
 *
 * <p>It implements the {@link BasicGetController} interface and uses a JsonTable of Room objects to store
 * room information.</p>
 *
 * @author Bisma Alif Alghifari
 * @see Room
 */
@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {

    /**
     * A `JsonTable` that stores room data.
     *
     * @JsonAutowired indicates that this field should be initialized with data from the specified file.
     */
    @JsonAutowired(value = Room.class, filepath = "src\\json\\room.json")
    public static JsonTable<Room> roomTable;

    /**
     * Returns the `JsonTable` object that stores the room.
     *
     * @return The `JsonTable` object that stores the room.
     */
    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }
    /**
     * This method is used to get all room by renter.
     * <p>This method uses the paginate method from the Algorithm class to paginate the results.</p>
     *
     * @param id The ID of the room.
     * @param page The page number to be return.
     * @param pageSize The number of room objects to return on each page.
     * @return The room for the specified renter ID.
     */
    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter
            (
                    @PathVariable int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            ){
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> pred.accountId == id);
    }

    /**
     * Create a new room to the system using the accountId, name, size, price, facility, city, address, & bed type.
     *
     * @param accountId The ID the account wants to create room.
     * @param name The name of the room the account wants to create.
     * @param size The size of the room.
     * @param price The price of the room.
     * @param facility The facilities provided with the room.
     * @param city The city the room located to.
     * @param address The address of the room.
     * @param bedType The bed type in the room.
     * @return The created `Room` object if the creation is successful, or `null` otherwise.
     */
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

    /**
     * This method is used to get all room.
     * <p>This method uses the paginate method from the Algorithm class to paginate the results.</p>
     *
     * @param page The page number to be return.
     * @param pageSize The number of room objects to return on each page.
     * @return All room that already created.
     */
    @GetMapping("/getAllRoom")
    List<Room> getAllRoom(
            @RequestParam int page,
            @RequestParam int pageSize
            ){
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> true);
    }

    /**
     * This method is used to filter room by City.
     * <p>This method uses the paginate method from the Algorithm class to paginate the results.</p>
     *
     * @param page The page number to be return.
     * @param pageSize The number of room objects to return on each page.
     * @param city The city that the user search for the room.
     * @return The room for the specified City.
     */
    @GetMapping("/filterByCity")
    List<Room> filterByCity(
            @RequestParam int page,
            @RequestParam int pageSize,
            @RequestParam City city
    ){
        return Algorithm.<Room>paginate(getJsonTable(),page,pageSize,kamar -> kamar.city == city);
    }

    /**
     * This method is used to filter room by Name.
     * <p>This method uses the paginate method from the Algorithm class to paginate the results.</p>
     *
     * @param page The page number to be return.
     * @param pageSize The number of room objects to return on each page.
     * @param name The name that the user search for the room.
     * @return The room for the specified Name.
     */
    @GetMapping("/filterByName")
    List<Room> filterByName(
            @RequestParam int page,
            @RequestParam int pageSize,
            @RequestParam String name
    ){
        return Algorithm.<Room>paginate(getJsonTable(),page,pageSize,kamar -> kamar.name.contains(name));
    }

    /**
     * This method is used to filter room by Price.
     * <p>This method uses the paginate method from the Algorithm class to paginate the results.</p>
     *
     * @param page The page number to be return.
     * @param pageSize The number of room objects to return on each page.
     * @param min The minimum price that the user search for the room.
     * @param max The maximum price that the user search for the room.
     * @return The room for the specified range of Price.
     */
    @GetMapping("/filterByPrice")
    List<Room> filterByPrice(
            @RequestParam int page,
            @RequestParam int pageSize,
            @RequestParam int min,
            @RequestParam int max
    ){
        return Algorithm.<Room>paginate(getJsonTable(),page,pageSize,i -> ((i.price.price >= min) && (i.price.price <= max)));
    }

}
