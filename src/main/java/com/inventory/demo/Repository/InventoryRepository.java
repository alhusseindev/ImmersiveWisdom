package com.inventory.demo.Repository;

import com.inventory.demo.Entity.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
