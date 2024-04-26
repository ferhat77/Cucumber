package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.ToDoListPage;

import java.util.List;

public class ToDoListStepDefinitions {
ToDoListPage toDoListPage=new ToDoListPage();
    @When("enter todos")
    public void enter_todos(DataTable dataTable) {
        //Data table tek sutundan olusuyorsa List<String> seklinde alinabilir

     List<String>todoList=dataTable.asList();
        System.out.println("todoList = " + todoList);
for (String w : todoList)
        toDoListPage.input.sendKeys(w + Keys.ENTER);

    }
}
