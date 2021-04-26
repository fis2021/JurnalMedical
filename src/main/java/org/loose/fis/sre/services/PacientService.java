package org.loose.fis.sre.services;

        import org.dizitart.no2.Nitrite;
        import org.dizitart.no2.objects.ObjectRepository;
        import org.loose.fis.sre.model.Pacient;
        import java.util.Objects;

        import static org.loose.fis.sre.services.FileSystemService.getPathToFile2;

public class PacientService{

    private static ObjectRepository<Pacient> pacientRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile2("pacients.db").toFile())
                .openOrCreate("test", "test");

        pacientRepository = database.getRepository(Pacient.class);
    }

    public static void addPacient(String username) {
        pacientRepository.insert(new Pacient(username));
    }

    public static int CheckEmptyJournal(String username) {
        for (Pacient pacient : pacientRepository.find())
            if (Objects.equals(username, pacient.getUsername()) )
                if(pacient.getNr_simptome()==0)return 1;
        return 0;
    }
    public static void addSimptom(String username,String simptom){
        for (Pacient pacient : pacientRepository.find())
            if (Objects.equals(username, pacient.getUsername()) ){
                pacient.addSimptom(simptom);
                pacientRepository.update(pacient);
            }

    }
    /*public static void ViewSimptoms(String username){
        for (Pacient pacient : pacientRepository.find())
            if (Objects.equals(username, pacient.getUsername()) ){
                pacient.ViewSimptoms();
            }
    }*/
}
