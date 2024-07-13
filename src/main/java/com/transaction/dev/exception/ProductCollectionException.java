package com.transaction.dev.exception;

/**
 * CollectionException
 */
public class ProductCollectionException extends Exception{

    public ProductCollectionException(String message){
        super(message);
    }

    public static String NotFoundException(String id){
        return "System Transaction with "+ id +"not found!";
    }

    public static String TransactionAlreadyExists(){
        return "Product with given name already exists";
    }
}