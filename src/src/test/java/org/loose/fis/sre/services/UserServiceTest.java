package org.loose.fis.sre.services;


import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.User;
import org.testfx.assertions.api.Assertions;

public class UserServiceTest {
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
        UserService.initDatabase();
    }
    @After
    public void tearDown(){
        UserService.close();
    }
    @Test
    public void testDatabaseIsInitialisedAndNoUserIsPersisted() throws Exception{

        Assertions.assertThat(UserService.getAllUsers()).isNotNull();
        Assertions.assertThat(UserService.getAllUsers()).isEmpty();
    }
    @Test
    public void testUserIsAddedToDatabase() throws UsernameAlreadyExistsException {

        UserService.addUser(ADMIN,ADMIN,ADMIN);
        Assertions.assertThat(UserService.getAllUsers()).isNotEmpty().size().isEqualTo(1);
        User user=UserService.getAllUsers().get(0);
        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(user.getUsername()).isEqualTo(ADMIN);
        Assertions.assertThat(user.getPassword()).isEqualTo(UserService.encodePassword(ADMIN,ADMIN));
        Assertions.assertThat(user.getRole()).isEqualTo(ADMIN);

    }
    @Test(expected = UsernameAlreadyExistsException.class)
    public void testUserCannotBeAddedTwice() throws UsernameAlreadyExistsException{

        UserService.addUser(ADMIN,ADMIN,ADMIN);
        UserService.addUser(ADMIN,ADMIN,ADMIN);
    }
    @Test(expected = UsernameAlreadyExistsException.class)
            public void testCheckUserDoesNotAlreadyExists() throws UsernameAlreadyExistsException {
            UserService.addUser(ADMIN, ADMIN, ADMIN);
            UserService.checkUserDoesNotAlreadyExist(ADMIN);
            }
@Test
    public void testCheckCredentialsOk() throws UsernameAlreadyExistsException{
    UserService.addUser(ADMIN, ADMIN, "Pacient");
    Assertions.assertThat(UserService.CheckCredentialsOk(ADMIN,ADMIN)).isEqualTo(1);
    UserService.addUser("admin2", "admin2", "Medic");
    Assertions.assertThat(UserService.CheckCredentialsOk("admin2","admin2")).isEqualTo(2);
}
}