package org.list4team.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id){
        super("Id Not Found: " + id);
    }
}
