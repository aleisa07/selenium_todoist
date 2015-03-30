package mashape;

import framework.utils.Util;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Silvia Coca on 3/20/2015.
 */
public class AddProjectColorTest {

    LoginModal loginModal;
    Dashboard dashboard;
    String expectedProjectName;
    ContextMenuSettings contextMenuSettings;
    ModalDeleteProject modalDeleteProject;
    String color= "rgb(255, 196, 113)";


    @BeforeMethod
    public void setUp() {
        expectedProjectName = "Project Add";
        String expectedemail = "scoca@pros.com";
        String password = "aleisa08";

        Home homepage = new Home();
        dashboard = homepage.loginAs(expectedemail, password);
    }

    @Test
    public void AddProjectColor() throws Exception {
        ContainerAddProject containerAddProject = dashboard.ClickAddProjectLbl();
        containerAddProject.setProjectName(expectedProjectName);
        containerAddProject.selectProjectColor("ORANGE");
        containerAddProject.clickAddProjectBtn();

        Assert.assertTrue(dashboard.isProjectDisplayed("Project Add"));

    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(1000);
        modalDeleteProject = dashboard.ClickDeleteProject(expectedProjectName);
        modalDeleteProject.clickDeleteProjectBtn();
        Thread.sleep(1000);

    }

}
