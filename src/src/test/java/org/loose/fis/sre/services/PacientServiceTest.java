package org.loose.fis.sre.services;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.loose.fis.sre.model.Pacient;
import org.testfx.assertions.api.Assertions;

public class PacientServiceTest {
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
        PacientService.initDatabase();
    }
    @After
    public void tearDown(){
        PacientService.close();
    }
    @Test
    public void testDatabaseIsInitialisedAndNoPatientIsPersisted() throws Exception{

        Assertions.assertThat(PacientService.getAllPatients()).isNotNull();
        Assertions.assertThat(PacientService.getAllPatients()).isEmpty();
    }
    @Test
    public void testPatientIsAddedToDatabase() {

        PacientService.addPacient(ADMIN);
        Assertions.assertThat(PacientService.getAllPatients()).isNotEmpty().size().isEqualTo(1);
        Pacient pacient=PacientService.getAllPatients().get(0);
        Assertions.assertThat(pacient).isNotNull();
        Assertions.assertThat(pacient.getUsername()).isEqualTo(ADMIN);


    }

}