package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.PatientAlreadyExistsException;
import org.loose.fis.sre.model.Medic;

import java.util.List;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class MedicService{

    private static ObjectRepository<Medic> medicRepository;
    private static Nitrite database;
    public static void initDatabase() {
        database = Nitrite.builder()
                .filePath(getPathToFile("medici.db").toFile())
                .openOrCreate("test", "test");

        medicRepository = database.getRepository(Medic.class);
    }

    public static void addMedic(String username) {
        medicRepository.insert(new Medic(username));
    }

    public static int CheckEmptyJournal1(String username) {
        for (Medic medic : medicRepository.find())
            if (Objects.equals(username, medic.getUsername()) )
                if(medic.getNr_pacienti()==0)return 1;
        return 0;
    }
    public static void checkPatientDoesNotAlreadyExist(String username,String pacient)throws PatientAlreadyExistsException {
        for (Medic medic : medicRepository.find())
            if (Objects.equals(username, medic.getUsername()) )
                medic.checkPatientDoesNotAlreadyExist(pacient);
    }
    public static int  addPacient(String username,String pacient)throws PatientAlreadyExistsException{
        checkPatientDoesNotAlreadyExist(username,pacient);
        int gasit=0;
        for (Medic medic : medicRepository.find())
            if (Objects.equals(username, medic.getUsername()) )
                if(PacientService.findPacient(pacient)==1){
                    medic.addPacient1(pacient);
                medicRepository.update(medic);
                gasit=1;
                }


        return gasit;
    }

    public static Medic getMedic(String username){
        for (Medic medic : medicRepository.find())
            if (Objects.equals(username, medic.getUsername()) ){
                return medic;
            }
        return new Medic("Username");

    }
    public static int removePacient(String username,String pacient){
        int r=0;
        for (Medic medic : medicRepository.find())
            if (Objects.equals(username, medic.getUsername()) ){
                r=medic.removePacient(pacient);
                medicRepository.update(medic);
            }
        return r;
    }
    public static int viewJurnal(String username,String pacient){
        int r=0;
        for (Medic medic : medicRepository.find())
            if (Objects.equals(username, medic.getUsername()) ){
                r=medic.viewJurnal(pacient);
            }
        return r;
    }
    public static void  sendFeedback(String username,String pacient,String f){
        for (Medic medic : medicRepository.find())
            if (Objects.equals(username, medic.getUsername()) )
                if(PacientService.findPacient(pacient)==1){
                    PacientService.sendFeedback(pacient,f);
                }

    }
    public static List<Medic> getAllMedics(){
        return medicRepository.find().toList();
    }
    public static void close() {
        medicRepository.close();
        database.close();
    }
}
