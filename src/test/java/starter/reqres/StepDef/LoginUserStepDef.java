package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class LoginUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //Positive Cases
    @Given("Login with valid user json")
    public void postLoginWithUserValid() {
        File json = new File(Constant.JSON_REQUEST_LOGIN_USER + "/RequestLoginUser.json");
        reqresAPI.loginUser(json);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USERS);
    }

    @And("Response body name should be token {string}")
    public void responseBodyNameShouldBeToken(String token) {
        SerenityRest.then()
                .body(ReqresResponses.TOKEN_USER, equalTo(token)); // TOKEN
    }

    @And("Validate json schema login user")
    public void validateJsonSchemaLoginUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA_LOGIN_USER+"/LoginUserSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Negative Cases
    //Negative Case with file json invalid email
    @Given("Login with invalid user email json")
    public void loginWithInvalidUserEmailJson() {
        File json = new File(Constant.JSON_REQUEST_LOGIN_USER+"/RequestLoginUserInvalid_Email.json");
        reqresAPI.loginUser(json);
    }

    @And("Validate invalid login json schema")
    public void validateInvalidLoginJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA_LOGIN_USER+"/InvalidLoginUserSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Negative Case with file json invalid password
    @Given("Login with invalid user password json")
    public void loginWithInvalidUserPasswordJson() {
        File json = new File(Constant.JSON_REQUEST_LOGIN_USER+"/RequestLoginUserInvalid_Password.json");
        reqresAPI.loginUser(json);
    }
    @And("Response login body name should be error as {string}")
    public void responseLoginBodyNameShouldBeErrorAs(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR, equalTo(error));
    }

    @Given("Post login user with invalid email and password json")
    public void postLoginUserWithInvalidEmailAndPasswordJson() {
        File json = new File(Constant.JSON_REQUEST_LOGIN_USER+"/RequestLoginUserInvalid_Email_Password.json");
        reqresAPI.loginUser(json);
    }
}
