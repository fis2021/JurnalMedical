package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.jetbrains.annotations.NotNull;
import org.loose.fis.sre.model.Medic;

import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile2;

public class MedicService{

    private static ObjectRepository<Medic> MedicRepository;

    public static void initDatabase1() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile2("medici.db").toFile())
                .openOrCreate("test", "test");

        MedicRepository = database.getRepository(Medic.class);
    }

    public static void addPacient1(String username) {
        MedicRepository.insert(new Medic(username));
    }

    public static int CheckEmptyJournal1(String username) {
        for (Medic medic : MedicRepository.find())
            if (Objects.equals(username, medic.getUsername()) )
                if(medic.getNr_pacienti()==0)return 1;
        return 0;
    }
    public static void addPacient2(String username,String pacient){
        for (Medic medic : MedicRepository.find())
            if (Objects.equals(username, medic.getUsername()) ){
                medic.addPacient1(pacient);
               MedicRepository.update(medic);
            }

    }

    @NotNull
    public static Medic getMedic(String username){
        for (Medic medic : MedicRepository.find())
            if (Objects.equals(username, medic.getUsername()) ){
                return medic;
            }
        return new Medic("Username");

    }
}
