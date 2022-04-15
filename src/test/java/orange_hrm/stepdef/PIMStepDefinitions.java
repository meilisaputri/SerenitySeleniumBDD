package orange_hrm.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.ensure.Ensure;
import orange_hrm.pageobjects.HRMPIMPageObjects;
import org.openqa.selenium.Keys;
import tasks.ClickOn;
import tasks.InputField;
import tasks.NavigateTo;
import tasks.VerifyDisplayed;


public class PIMStepDefinitions {

    //Read Employee
    @And("{actor} access employee list")
    public void accessEmployee(Actor actor) throws Exception {
        actor.wasAbleTo(NavigateTo.theURL("HRM Employee List"));
    }
    @And("{actor} can see new employee list result")
    public void listResult(Actor actor) throws Exception {
        actor.attemptsTo(
                VerifyDisplayed.element("Employee List")
        );
    }

    //Add Employee
    @When("{actor} add new employee with required field only")
    public void addEmployee(Actor actor) throws Exception {
        actor.attemptsTo(
           ClickOn.button("Add"),
           InputField.onField("firstName", "Caca"),
           InputField.onField("lastName", "Dwich"),
           ClickOn.button("Save")
        );
    }

    @Then("{actor} can see my Personal Details")
    public void personalDetails(Actor actor) throws Exception {
        actor.attemptsTo(
            VerifyDisplayed.element("Personal Details")
        );
    }


    //Search Employee
    @And("{actor} search for new employee")
    public void searchEmployee(Actor actor) throws Exception {
        actor.attemptsTo(
                InputField.onField("employeeName", "Caca Dwich"),
                ClickOn.button("Search")
        );
    }


    //Update Employee
    @When("{actor} update new employee's data")
    public void updateEmployee(Actor actor) throws Exception {
        actor.attemptsTo(
                ClickOn.employeeList(),
                ClickOn.button("Edit"),
                InputField.onField("editMiddleName", "Putri"),
                ClickOn.button("Gender"),
                ClickOn.button("Save")
        );
    }


    @Then("{actor} can see the Personal Details has changed")
    public void updatedEmployee(Actor actor) throws Exception {
        actor.attemptsTo(
                Ensure.that(HRMPIMPageObjects.EDIT_MIDDLE_NAME_FIELD).value().isEqualTo("Putri"),
                Ensure.that(HRMPIMPageObjects.GENDER_OPTION).value().isNotEmpty()
        );
    }

    //Delete Employee
    @And("{actor} delete new employee")
    public void deleteEmployee(Actor actor) throws Exception {
        actor.attemptsTo(
                ClickOn.checkbox(),
                ClickOn.button("Delete"),
                ClickOn.button("Ok")
        );
    }

    @Then("{actor} can't see deleted employee on list")
    public void deletedEmployee(Actor actor) throws Exception {
        actor.attemptsTo(
                VerifyDisplayed.element("No Employee")
        );
    }
}
