package com.example.exception;

public class ResourceFoundException extends RuntimeException{
    public ResourceFoundException(String message){
        super(message);
    }
    public ResourceFoundException(){
        super("Resource alredy exists");

    }}
