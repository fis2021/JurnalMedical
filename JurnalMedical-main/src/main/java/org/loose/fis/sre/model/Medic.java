package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

public class Medic {
    @Id
    private String username1;
    private String [] pacienti= new String[100];
    private int nr_pacienti;
    public Medic(String username){
        this.username1=username;
    }
    public Medic(){
    }
    public int getNr_pacienti(){
        return nr_pacienti;
    }
    public String[] getPacienti(){
        return  pacienti;
    }
    public String getUsername(){
        return username1;
    }
    public void addPacient1(String Pacient){
        if(nr_pacienti==pacienti.length){
            String[] aux=new String[pacienti.length+10];
            for(int j=0;j<pacienti.length;j++)
                pacienti=aux;
        }
        pacienti[nr_pacienti]=Pacient;
        nr_pacienti++;
    }
}