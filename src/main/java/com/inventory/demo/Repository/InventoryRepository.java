package com.inventory.demo.Repository;

import com.inventory.demo.Entity.Inventory;
import com.inventory.demo.Enum.ItemStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.List;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    List<Inventory> findAllByItemStatusAndItemEnteredByUser(@RequestParam("itemStatus") ItemStatus status, @RequestParam("itemEnteredByUser") String enteredBy);
}
