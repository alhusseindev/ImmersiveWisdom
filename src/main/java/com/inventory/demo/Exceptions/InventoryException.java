package com.inventory.demo.Exceptions;

public class InventoryException extends Exception {
    public InventoryException(String errorMessage){
        super(errorMessage);
    }
}
