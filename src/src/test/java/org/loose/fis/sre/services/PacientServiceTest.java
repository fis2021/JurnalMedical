package org.loose.fis.sre.services;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.loose.fis.sre.exceptions.SimptomAlreadyExistsException;
import org.loose.fis.sre.model.Pacient;
import org.testfx.assertions.api.Assertions;

public class PacientServiceTest {
    public static final String ADMIN = "admin";

    @BeforeClass
    public static void beforeAll() {

        System.out.println("BEFORE CLASS");
    }

    @AfterClass
    public static void afterAll() {

        System.out.println("AFTER CLASS");

    }

    @Before
    public void setup() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".test-jurnal-medical";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        PacientService.initDatabase();
    }

    @After
    public void tearDown() {
        PacientService.close();
    }

    @Test
    public void testDatabaseIsInitialisedAndNoPatientIsPersisted() throws Exception {
        Assertions.assertThat(PacientService.getAllPatients()).isNotNull();
        Assertions.assertThat(PacientService.getAllPatients()).isEmpty();
    }

    @Test
    public void testPatientIsAddedToDatabase() {

        PacientService.addPacient(ADMIN);
        Assertions.assertThat(PacientService.getAllPatients()).isNotEmpty().size().isEqualTo(1);
        Pacient pacient = PacientService.getAllPatients().get(0);
        Assertions.assertThat(pacient).isNotNull();
        Assertions.assertThat(pacient.getUsername()).isEqualTo(ADMIN);


    }

    @Test(expected = SimptomAlreadyExistsException.class)
    public void testSimptomCannotBeAddedTwice() throws SimptomAlreadyExistsException {
        PacientService.addPacient(ADMIN);
        Pacient pacient = PacientService.getPacient(ADMIN);
        pacient.addSimptom("simptom");
        pacient.checkSimptomDoesNotAlreadyExist("simptom");
    }

    @Test
    public void testCheckEmptyJournal() {
        PacientService.addPacient(ADMIN);
        Assertions.assertThat(PacientService.CheckEmptyJournal(ADMIN)).isEqualTo(1);
    }

    @Test
    public void testSimptomIsAddedToDatabase() throws SimptomAlreadyExistsException {

        PacientService.addPacient(ADMIN);
        PacientService.addSimptom(ADMIN, "simptom");
        Assertions.assertThat(PacientService.getPacient(ADMIN).getSimptome()).isNotEmpty();
        Assertions.assertThat(PacientService.getPacient(ADMIN).getNr_simptome()).isEqualTo(1);
        String simptom = PacientService.getAllPatients().get(0).getSimptome()[0];
        Assertions.assertThat(simptom).isNotNull();
        Assertions.assertThat(simptom).isEqualTo("simptom");


    }

    @Test
    public void testRemoveSimptom() throws SimptomAlreadyExistsException {
        PacientService.addPacient(ADMIN);
        PacientService.addSimptom(ADMIN, "simptom");
        PacientService.removeSimptom(ADMIN, "simptom");
        Assertions.assertThat(PacientService.getPacient(ADMIN).getSimptome()[0]).isNull();
        Assertions.assertThat(PacientService.getPacient(ADMIN).getNr_simptome()).isEqualTo(0);
    }

    @Test
    public void testfindPacient() {
        Assertions.assertThat(PacientService.findPacient(ADMIN)).isEqualTo(0);
        PacientService.addPacient(ADMIN);
        Assertions.assertThat(PacientService.findPacient(ADMIN)).isEqualTo(1);
    }

    @Test
    public void testsendFeedback() {
        PacientService.addPacient(ADMIN);
        PacientService.sendFeedback(ADMIN, "feedback");
        Assertions.assertThat(PacientService.getPacient(ADMIN).getFeedback()).isEqualTo("feedback");
    }

    @Test
    public void testviewFeedback() {
        PacientService.addPacient(ADMIN);
        PacientService.sendFeedback(ADMIN, "feedback");
        Assertions.assertThat(PacientService.viewFeedback(ADMIN)).isEqualTo("feedback");
    }

    @Test
    public void testCheckNoFeedback() {
        PacientService.addPacient(ADMIN);
        Assertions.assertThat(PacientService.CheckNoFeedback(ADMIN)).isEqualTo(1);
        PacientService.sendFeedback(ADMIN, "feedback");
        Assertions.assertThat(PacientService.CheckNoFeedback(ADMIN)).isEqualTo(0);
    }

}