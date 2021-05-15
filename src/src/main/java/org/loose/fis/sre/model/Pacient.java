package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;
import org.loose.fis.sre.exceptions.SimptomAlreadyExistsException;

import java.util.Objects;

public class Pacient {
    @Id
    private String username;
    private String[] simptome=new String[100];
    private int nr_simptome=0;
    private String feedback;
    public Pacient(String username){
        this.username=username;
    }
    public Pacient() {
    }
    public int getNr_simptome() {
        return nr_simptome;
    }
    public String[] getSimptome() {
        return simptome;
    }
    public String getUsername() {
        return username;
    }

    public void addSimptom(String simptom)throws SimptomAlreadyExistsException {
        if(nr_simptome==simptome.length){
            String[] aux=new String[simptome.length+10];
            for(int j=0;j<simptome.length;j++)aux[j]=simptome[j];
            simptome=aux;
        }
        simptome[nr_simptome]=simptom;
        nr_simptome++;
    }
    public void checkSimptomDoesNotAlreadyExist(String simptom) throws SimptomAlreadyExistsException {
                for(int j=0;j<nr_simptome;j++)
                    if(Objects.equals(simptome[j],simptom)){
                throw new SimptomAlreadyExistsException(simptom);
        }
    }
    public int removeSimptom(String simptom){
        int gasit=0;
        if(nr_simptome==0)gasit=-1;

        for(int j=0;j<simptome.length;j++)
            if(Objects.equals(simptome[j],simptom)){
                gasit=1;
                for(int i=j;i<simptome.length-1;i++)
                    simptome[i]=simptome[i+1];
                nr_simptome--;}
        return gasit;

    }
    public void sendFeedback(String f){
        feedback=f;
    }
    public String getFeedback(){return feedback;}

}