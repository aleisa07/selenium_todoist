package mashape;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Silvia Coca on 3/20/2015.
 */
public class DeleteProjectTest {
    String expectedProjectName = "Project Silvia";
    String expectedemail = "scoca@pros.com";
    String password = "aleisa08";
    Home homepage;
    LoginModal loginModal;
    Dashboard dashboard;
    ContainerAddProject containerAddProject;
    ModalDeleteProject modalDeleteProject;
    ContextMenuSettings contextMenuSettings;

    @BeforeMethod
    public void setUp() {
        homepage = new Home();
        //homepage.clickLogin();
        Home homepage = new Home();
        dashboard = homepage.loginAs(expectedemail, password);
        containerAddProject = dashboard.ClickAddProjectLbl();
        containerAddProject.setProjectName(expectedProjectName);
        containerAddProject.selectProjectColor("ORANGE");
        containerAddProject.clickAddProjectBtn();

    }

    @Test
    public void DeleteProjectTest() throws Exception {
        modalDeleteProject = dashboard.ClickDeleteProject(expectedProjectName);
        modalDeleteProject.clickDeleteProjectBtn();

         Assert.assertFalse(dashboard.isProjectDisplayed(expectedProjectName));

    }


}