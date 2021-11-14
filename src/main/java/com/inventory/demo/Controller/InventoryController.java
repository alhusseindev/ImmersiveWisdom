package com.inventory.demo.Controller;


import com.inventory.demo.Entity.Inventory;
import com.inventory.demo.Enum.ItemStatus;
import com.inventory.demo.Exceptions.InventoryException;
import com.inventory.demo.Repository.InventoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/app/item")
@CrossOrigin
public class InventoryController {

    private static InventoryRepository myInventoryRepository;


    @GetMapping("/")
    public List<Inventory> listInventoryItems(){
        return myInventoryRepository.findAll();
    }

    @GetMapping("/{itemId}")
    public Inventory getInventoryItemById(@PathVariable Integer itemId) throws InventoryException {
        return myInventoryRepository.findById(itemId).orElseThrow(() -> new InventoryException("Error Finding Item in Inventory!"));
    }

    @GetMapping("/")
    public Inventory searchInventoryBy(@RequestParam("status") ItemStatus status, @RequestParam("enteredBy") String enteredBy){
        Inventory myInventory = new Inventory();
        status = myInventory.getItemStatus();
        enteredBy = myInventory.getItemEnteredByUser();
        return myInventory;
    }


    @GetMapping("/")
    public Page<Inventory> findAllBy(@RequestParam("pageSize") Pageable pageSize, @RequestParam("page") String page, @RequestParam("sortBy") String sortByField){
        PageRequest myPageRequest = PageRequest.of(Integer.parseInt(page), Integer.parseInt(String.valueOf(pageSize)), Sort.by(sortByField));

        return myInventoryRepository.findAll(myPageRequest);

    }




    @PostMapping("/")
    public Inventory createInventoryItem(@RequestBody Inventory myInventoryItem){
        return myInventoryRepository.save(myInventoryItem);
    }


    //PUT

    @PutMapping("/{itemId}")
    public Inventory updateInventoryItem(@RequestBody Inventory myInventoryItem, @PathVariable Integer itemId){
        return myInventoryRepository.findById(itemId).map((inventory) ->{
            inventory.setItemName(myInventoryItem.getItemName());
            inventory.setItemEnteredByUser(myInventoryItem.getItemEnteredByUser());
            inventory.setItemEnteredDate(myInventoryItem.getItemEnteredDate());
            inventory.setItemSellingPrice(myInventoryItem.getItemSellingPrice());
            inventory.setItemBuyingPrice(myInventoryItem.getItemBuyingPrice());
            inventory.setItemLastModifiedByUser(myInventoryItem.getItemLastModifiedByUser());
            inventory.setItemStatus(myInventoryItem.getItemStatus());

            return myInventoryRepository.save(inventory);
        }).orElseGet(() ->{
            myInventoryItem.setItemId(itemId);
            return myInventoryRepository.save(myInventoryItem);
        });
    }

    @DeleteMapping("/{itemId}")
    public void deleteInventoryItemById(@PathVariable Integer itemId){
        myInventoryRepository.deleteById(itemId);
    }

    @DeleteMapping("/")
    public void deleteAllInventoryItems(){
        myInventoryRepository.deleteAll();
    }
}
