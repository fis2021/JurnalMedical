package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.util.Objects;

public class Pacient {
    @Id
    private String username;
    private String[] simptome=new String[100];
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

    public int removeSimptom(String simptom){
        int gasit=0;
        if(nr_simptome==0)gasit=-1;
<<<<<<< HEAD
        for(int j=0;j<simptome.length;j++)
            if(Objects.equals(simptome[j],simptom)){
                gasit=1;
                for(int i=j;i<simptome.length-1;i++)
                    simptome[i]=simptome[i+1];
                nr_simptome--;}
        return gasit;
=======
            for(int j=0;j<simptome.length;j++)
                if(Objects.equals(simptome[j],simptom)){
                    gasit=1;
                    for(int i=j;i<simptome.length-1;i++)
                        simptome[i]=simptome[i+1];
            nr_simptome--;}
            return gasit;
>>>>>>> b42c8ba474ed51ea5e7b39f503a9d7df6ce26948
    }

}