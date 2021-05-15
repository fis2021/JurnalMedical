package org.loose.fis.sre.exceptions;

public class PatientAlreadyExistsException extends Exception {

    private String patient;

    public PatientAlreadyExistsException(String patient) {
        super(String.format("Patient %s already added!", patient));
        this.patient = patient;
    }

    public String getPatient() {
        return patient;
    }
}
