package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;
import org.loose.fis.sre.services.PacientService;

import java.util.Objects;

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
    public int removePacient(String Pacient){
        int t=0;
        if(nr_pacienti==0)t=-1;
        for(int j=0;j<pacienti.length;j++)
            if(Objects.equals(pacienti[j],Pacient)){
                t=1;
                for(int i=j;i<pacienti.length-1;i++)
                    pacienti[i]=pacienti[i+1];
                nr_pacienti--;}
        return t;
    }
    public int viewJurnal(String Pacient) {
        int t=1,q=0;
        for(int j=0;j<pacienti.length;j++)
            if(Objects.equals(pacienti[j],Pacient)) {
                q = 1;
            }
        if(q==0)t=-1;
        if(PacientService.findPacient(Pacient)==0)t=0;
        return t;
    }

}