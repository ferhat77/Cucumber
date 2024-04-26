package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.FormHomePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class FormPageStepDefinitions {
    FormHomePage formHomePage = new FormHomePage();

    @Given("go to form page")
    public void go_to_form_page() {
        Driver.getDriver().get(ConfigReader.getProperty("form_page_url"));

    }

    @When("enter username {string}")
    public void enter_username(String username) {
        formHomePage.username.sendKeys(username);
    }

    @When("enter password {string}")
    public void enterPassword(String password) {
        formHomePage.password.sendKeys(password);

    }

    @When("enter comment {string}")
    public void enter_comment(String comments) {
        formHomePage.comments.clear();
        formHomePage.comments.sendKeys(comments);
    }


    @And("clcik on submit")
    public void clcikOnSubmit() {
        formHomePage.submit.click();
    }

    @When("user enters username, password")
    public void user_enters_username_password(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> usurnamepossword = dataTable.asMap();//Data Table iki sutun var ise MAp String String seklinde alinabili r.
        System.out.println("usurnamepossword = " + usurnamepossword);
        //MAp entry set kullanarak loop icinde kullanilabilir.
        for (Map.Entry<String, String> w : usurnamepossword.entrySet()) {
            String usurname = w.getKey();
            String password = w.getValue();
            System.out.println("usurname = " + usurname);
            System.out.println("password = " + password);

            formHomePage.username.sendKeys(usurname);
            formHomePage.password.sendKeys(password);


            Driver.getDriver().navigate().refresh();
        }
    }

    @When("user enters username, password and comment")
    public void user_enters_username_password_and_comment(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

        List<String> row3 = dataTable.row(2);//row() methodu ile istenen satır List haline alınabilir
        System.out.println("row3 = " + row3);

        String r2c2 = dataTable.cell(1,1);//cell() methodu ile istenen hücre String olarak alınabilir.
        System.out.println("r2c2 = " + r2c2);

        //2'den fazla sütunu bulunana data table için List<List<>> yapısı daha uygundur.
        List<List<String>> rows = dataTable.asLists();
        System.out.println("rows = " + rows);

//        List<String> ayseRow = rows.get(2);
//        System.out.println("ayseRow = " + ayseRow);

        for (List<String> w : rows) {

            String username = w.get(0);
            String password = w.get(1);
            String comment = w.get(2);

            formHomePage.username.sendKeys(username);
            formHomePage.password.sendKeys(password);
            formHomePage.comments.sendKeys(comment);

            Thread.sleep(1000);
            Driver.getDriver().navigate().refresh();

        }


    }
}
