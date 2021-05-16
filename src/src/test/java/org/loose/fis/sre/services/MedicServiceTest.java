package org.loose.fis.sre.services;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.loose.fis.sre.exceptions.PatientAlreadyExistsException;
import org.loose.fis.sre.exceptions.SimptomAlreadyExistsException;
import org.loose.fis.sre.model.Medic;
import org.testfx.assertions.api.Assertions;

public class MedicServiceTest {
    public static final String ADMIN="admin";
    @BeforeClass
    public static void beforeAll(){

        System.out.println("BEFORE CLASS");
    }
    @AfterClass
    public static void afterAll(){

        System.out.println("AFTER CLASS");
    }
    @Before
    public void setup() throws Exception{
        FileSystemService.APPLICATION_FOLDER=".test-jurnal-medical";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        MedicService.initDatabase();
        PacientService.initDatabase();
    }
    @After
    public void tearDown(){
        MedicService.close();
        PacientService.close();
    }
    @Test
    public void testDatabaseIsInitialisedAndNoMedicIsPersisted() throws Exception{

        Assertions.assertThat(MedicService.getAllMedics()).isNotNull();
        Assertions.assertThat(MedicService.getAllMedics()).isEmpty();
    }
    @Test
    public void testMedicIsAddedToDatabase() {

        MedicService.addMedic(ADMIN);
        Assertions.assertThat(MedicService.getAllMedics()).isNotEmpty().size().isEqualTo(1);
        Medic medic=MedicService.getAllMedics().get(0);
        Assertions.assertThat(medic).isNotNull();
        Assertions.assertThat(medic.getUsername()).isEqualTo(ADMIN);


    }
    @Test(expected = PatientAlreadyExistsException.class)
    public void testPatientCannotBeAddedTwice() throws PatientAlreadyExistsException {
        MedicService.addMedic(ADMIN);
        Medic medic=MedicService.getMedic(ADMIN);
        medic.addPacient1("Pacient");
        medic.checkPatientDoesNotAlreadyExist("Pacient");
    }
    @Test
    public void testCheckEmptyJournal1(){
        MedicService.addMedic(ADMIN);
        Assertions.assertThat(MedicService.CheckEmptyJournal1(ADMIN)).isEqualTo(1);
    }
    @Test
    public void testPatientIsAddedToDatabase() throws PatientAlreadyExistsException {

        MedicService.addMedic(ADMIN);
        PacientService.addPacient("pacient");
        MedicService.addPacient(ADMIN,"pacient");
        Assertions.assertThat(MedicService.getMedic(ADMIN).getPacienti()).isNotEmpty();
        Assertions.assertThat(MedicService.getMedic(ADMIN).getNr_pacienti()).isEqualTo(1);
        String pacient=MedicService.getAllMedics().get(0).getPacienti()[0];
        Assertions.assertThat(pacient).isNotNull();
        Assertions.assertThat(pacient).isEqualTo("pacient");


    }
    @Test
    public void testRemovePatient()throws PatientAlreadyExistsException {
        MedicService.addMedic(ADMIN);
        MedicService.addPacient(ADMIN,"pacient");
        MedicService.removePacient(ADMIN,"pacient");
        Assertions.assertThat(MedicService.getMedic(ADMIN).getPacienti()[0]).isNull();
        Assertions.assertThat(MedicService.getMedic(ADMIN).getNr_pacienti()).isEqualTo(0);
    }
    @Test
    public void testviewJurnal()throws PatientAlreadyExistsException, SimptomAlreadyExistsException {
        MedicService.addMedic(ADMIN);
        PacientService.addPacient("pacient");
        MedicService.addPacient(ADMIN,"pacient");
        PacientService.addSimptom(ADMIN, "simptom");
        Assertions.assertThat(MedicService.viewJurnal(ADMIN,"pacient")).isEqualTo(1);
    }
    @Test
    public void testSendFeedback()throws PatientAlreadyExistsException{
        MedicService.addMedic(ADMIN);
        PacientService.addPacient("pacient");
        MedicService.addPacient(ADMIN,"pacient");
        MedicService.sendFeedback(ADMIN,"pacient","feedback");
        Assertions.assertThat(PacientService.getPacient("pacient").getFeedback()).isEqualTo("feedback");
    }
}