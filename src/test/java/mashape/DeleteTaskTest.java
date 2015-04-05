package mashape;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Silvia Coca on 3/20/2015.
 */
public class DeleteTaskTest {

    String expectedProjectName;
    String expectedemail = "scoca@pros.com";
    String password = "aleisa08";
    String taskName = "TASK 1";
    LoginModal loginModal;
    Dashboard dashboard;
    ContainerAddProject containerAddProject;
    AddTaskContainer addTaskContainer;
    ContextMenuTask contextMenuTask;
    ContextMenuSettings contextMenuSettings;
    ModalDeleteProject modalDeleteProject;


    @BeforeMethod
    public void setUp() {
        expectedProjectName = "Project Silvia";

        Home homepage = new Home();
        dashboard = homepage.loginAs(expectedemail, password);

        containerAddProject = dashboard.ClickAddProjectLbl();
        containerAddProject.setProjectName(expectedProjectName);
        containerAddProject.selectProjectColor("ORANGE");
        containerAddProject.clickAddProjectBtn();
    }

    @Test
    public void AddTaskTest() throws Exception {
        addTaskContainer = containerAddProject.clickOverProject(expectedProjectName);
        addTaskContainer.ClickAddTask();
        addTaskContainer.setNameTask(taskName);
        addTaskContainer.clickSaveBtn();
        contextMenuTask = addTaskContainer.clickSubMenu(taskName);
        contextMenuTask.ClickDeleteTaskMenu();


        Assert.assertFalse(addTaskContainer.isTaskDisplayed(taskName));
    }


    @AfterClass
    public void tearDown() throws Exception {

        modalDeleteProject = dashboard.ClickDeleteProject(expectedProjectName);
        modalDeleteProject.clickDeleteProjectBtn();

    }
}
