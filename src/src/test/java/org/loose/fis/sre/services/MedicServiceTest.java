package org.loose.fis.sre.services;

import org.apache.commons.io.FileUtils;
import org.junit.*;
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
    }
    @After
    public void tearDown(){
        MedicService.close();
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
}