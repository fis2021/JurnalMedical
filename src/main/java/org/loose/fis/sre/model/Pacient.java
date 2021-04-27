package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

public class Pacient {
    @Id
    private String username;
    private String[] simptome=new String[10];
    private int nr_simptome=0;
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

    public void addSimptom(String simptom){
        if(nr_simptome==simptome.length){
            String[] aux=new String[simptome.length+10];
            for(int j=0;j<simptome.length;j++)aux[j]=simptome[j];
            simptome=aux;
        }
        simptome[nr_simptome]=simptom;
        nr_simptome++;
    }


}
