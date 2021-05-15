package org.loose.fis.sre.services;




import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.testfx.assertions.api.Assertions;

public class UserServiceTest {
    @BeforeClass
    public static void beforeAll(){

        System.out.println("BEFORE CLASS");
    }
    @AfterClass
    public static void afteAll(){

        System.out.println("AFTER CLASS");
    }
    @Before
    public void setup() throws Exception{
        FileSystemService.APPLICATION_FOLDER=".test-jurnal-medical";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
    }
    @After
    public void tearDown(){
        System.out.println("AFTER EACH");
    }
    @Test
    public void testDatabaseIsInitialisedAndNoUserIsPersisted() throws Exception{
        UserService.initDatabase();
        Assertions.assertThat(UserService.getAllUsers()).isNotNull();
        Assertions.assertThat(UserService.getAllUsers()).isEmpty();
    }

}