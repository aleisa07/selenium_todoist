package mashape;

import framework.selenium.Commons;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Silvia Coca on 3/20/2015.
 */
public class EditProjectTest {
    String projectName = "Project Silvia";
    String newNameProject = "Test Project Edited";
    String expectedemail = "scoca@pros.com";
    String password = "aleisa08";
    Home homepage;
    LoginModal loginModal;
    Dashboard dashboard;
    ContainerAddProject containerAddProject;
    ContextMenuSettings contextMenuSettings;
    ModalDeleteProject modalDeleteProject;
    ContainerEditProject containerEditProject;

    @BeforeMethod
    public void setUp() {
        Home homepage = new Home();
        dashboard = homepage.loginAs(expectedemail, password);


        containerAddProject = dashboard.ClickAddProjectLbl();
        containerAddProject.setProjectName(projectName);
        containerAddProject.selectProjectColor("ORANGE");
        containerAddProject.clickAddProjectBtn();

    }

    @Test
    public void EditProjectTest() throws Exception {

        containerEditProject = dashboard.ClickEditProject(projectName);
        containerEditProject.setProjectName(newNameProject);
        containerEditProject.selectProjectColor("LIGHGREEN");
        containerEditProject.clickSaveProjectBtn();

        Assert.assertTrue(Commons.isElementPresent(By.xpath("//tr[contains(., '" + newNameProject +"')]")));

      }

    @AfterClass
    public void tearDown() throws Exception {

        modalDeleteProject = dashboard.ClickDeleteProject(newNameProject);
        modalDeleteProject.clickDeleteProjectBtn();
    }
}