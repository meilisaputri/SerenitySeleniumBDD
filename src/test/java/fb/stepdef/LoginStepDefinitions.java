package fb.stepdef;

import io.cucumber.java.en.*;
import io.github.cdimascio.dotenv.Dotenv;
import net.serenitybdd.screenplay.Actor;
import tasks.*;


public class LoginStepDefinitions {
    @Given("{actor} open facebook login page")
    public void loadPage(Actor actor) throws Exception{
        actor.wasAbleTo(NavigateTo.theURL("FB Log In"));
    }

    @When("{actor} input email and password")
    public void inputField(Actor actor) throws Exception {
        Dotenv dotenv = Dotenv.load();

        String email = dotenv.get("EMAIL_FB");
        String password = dotenv.get("PASSWORD_FB");

        actor.attemptsTo(
                InputField.onField("FB email", email),
                InputField.onField("FB password", password)
        );
    }

    @And("{actor} click button login")
    public void clickButton(Actor actor) throws Exception{
        actor.attemptsTo(
                ClickOn.button("FB Log In")
        );
    }
}
