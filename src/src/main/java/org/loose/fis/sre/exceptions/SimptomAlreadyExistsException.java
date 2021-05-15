package org.loose.fis.sre.exceptions;

public class SimptomAlreadyExistsException extends Exception {

    private String simptom;

    public SimptomAlreadyExistsException(String simptom) {
        super(String.format("Simptom %s already added!", simptom));
        this.simptom = simptom;
    }

    public String getSimptom() {
        return simptom;
    }
}
