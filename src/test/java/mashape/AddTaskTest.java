package mashape;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Silvia Coca on 3/20/2015.
 */
public class AddTaskTest {

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
        expectedProjectName = "Add Project Task";
        String expectedemail = "scoca@pros.com";
        String password = "aleisa08";
        Home homepage = new Home();
        dashboard = homepage.loginAs(expectedemail, password);
        containerAddProject = dashboard.ClickAddProjectLbl();
        containerAddProject.setProjectName(expectedProjectName);
        containerAddProject.ClickSelectColorProject();
        containerAddProject.clickAddProjectBtn();

    }

    @Test
    public void AddTaskTest() throws Exception {

        Thread.sleep(1000);
        addTaskContainer = containerAddProject.clickOverProject(expectedProjectName);
        addTaskContainer.ClickAddTask();
        addTaskContainer.setNameTask(taskName);
        addTaskContainer.clickSaveBtn();
        contextMenuTask = addTaskContainer.clickSubMenu(taskName);
        Thread.sleep(1000);
        contextMenuTask.SelectPriority2();
        //ContextMenuTask contextMenuTask1 = addTaskContainer.clickSubMenu();
        //Thread.sleep(1000);
        //contextMenuTask1.ClickDeleteTaskMenu();

       Assert.assertTrue(addTaskContainer.isTaskDisplayed(taskName));

    }

    @AfterClass
    public void tearDown() throws Exception {
        //contextMenuSettings = dashboard.clickSettings();
        //contextMenuSettings.clickLogoutMenu();
        Thread.sleep(1000);
        //contextMenuSettings = dashboard.clickSettings();
        //contextMenuSettings.clickLogoutMenu();
        modalDeleteProject = dashboard.ClickDeleteProject(expectedProjectName);
        modalDeleteProject.clickDeleteProjectBtn();
        Thread.sleep(1000);
    }


    }



