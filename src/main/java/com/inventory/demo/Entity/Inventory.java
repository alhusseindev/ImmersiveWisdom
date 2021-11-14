package com.inventory.demo.Entity;


import com.inventory.demo.Enum.ItemStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
public class Inventory {

    @Id @GeneratedValue
    private Integer itemId;
    private String itemName;
    private String itemEnteredByUser;
    private LocalDateTime itemEnteredDate = LocalDateTime.now();
    private Double  itemBuyingPrice;
    private Double itemSellingPrice;
    private LocalDateTime itemLastModifiedDate = LocalDateTime.now();
    private String itemLastModifiedByUser;
    private ItemStatus itemStatus;

    //No Arg Constructor
    public Inventory(){}


    public Inventory(Integer itemId, String itemName, String itemEnteredByUser, Double  itemBuyingPrice, Double itemSellingPrice, String itemLastModifiedByUser, ItemStatus itemStatus){
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemEnteredByUser = itemEnteredByUser;
        this.itemBuyingPrice = itemBuyingPrice;
        this.itemSellingPrice = itemSellingPrice;
        this.itemLastModifiedByUser = itemLastModifiedByUser;
        this.itemStatus = itemStatus;
    }


    //Getters


    public Integer getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public LocalDateTime getItemEnteredDate() {
        return itemEnteredDate;
    }

    public LocalDateTime getItemLastModifiedDate() {
        return itemLastModifiedDate;
    }

    public String getItemEnteredByUser() {
        return itemEnteredByUser;
    }

    public String getItemLastModifiedByUser() {
        return itemLastModifiedByUser;
    }


    public Double getItemBuyingPrice() {
        return itemBuyingPrice;
    }

    public Double getItemSellingPrice() {
        return itemSellingPrice;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    //Setters

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemBuyingPrice(Double itemBuyingPrice) {
        this.itemBuyingPrice = itemBuyingPrice;
    }

    public void setItemEnteredByUser(String itemEnteredByUser) {
        this.itemEnteredByUser = itemEnteredByUser;
    }

    public void setItemEnteredDate(LocalDateTime itemEnteredDate) {
        this.itemEnteredDate = itemEnteredDate;
    }

    public void setItemLastModifiedByUser(String itemLastModifiedByUser) {
        this.itemLastModifiedByUser = itemLastModifiedByUser;
    }

    public void setItemLastModifiedDate(LocalDateTime itemLastModifiedDate) {
        this.itemLastModifiedDate = itemLastModifiedDate;
    }

    public void setItemSellingPrice(Double itemSellingPrice) {
        this.itemSellingPrice = itemSellingPrice;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemEnteredByUser='" + itemEnteredByUser + '\'' +
                ", itemEnteredDate=" + itemEnteredDate +
                ", itemBuyingPrice=" + itemBuyingPrice +
                ", itemSellingPrice=" + itemSellingPrice +
                ", itemLastModifiedDate=" + itemLastModifiedDate +
                ", itemLastModifiedByUser='" + itemLastModifiedByUser + '\'' +
                ", itemStatus=" + itemStatus +
                '}';
    }
}
