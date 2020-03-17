package ru.sbt.course;

public class WrongPinException extends Exception {
    public WrongPinException(String message){
        super(message);
    }
}
