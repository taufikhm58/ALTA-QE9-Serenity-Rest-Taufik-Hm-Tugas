package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class RegisterUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //Positive Cases
    //Json file with email : eve.holt@reqres.i
    @Given("Post register user with valid json")
    public void postCreateUserWithInvalidJson() {
        File json = new File(Constant.JSON_REQUEST_REGISTER_USER + "/RequestRegisterUser.json");
        reqresAPI.registerUser(json);
    }


    @Given("Post register user with valid json another email")
    public void postRegisterUserWithValidJsonAnotherEmail() {
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USERS);
    }

    @And("Response body id should be {int} and token {string}")
    public void responseBodyIdShouldBeAndToken(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponses.ID_USER, equalTo(id))
                .body(ReqresResponses.TOKEN_USER, equalTo(token));
    }

    @And("Validate json schema register")
    public void validateJsonSchemaRegisterUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA_REGISTER_USER + "/RegisterUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Negative Cases
    //Json file without password
    @Given("Post register user with invalid password json")
    public void postRegisterUserWithInvalidJson() {
        File json = new File(Constant.JSON_REQUEST_REGISTER_USER + "/RequestRegisterUserInvalid_Password.json");
        reqresAPI.registerUser(json);
    }

    @And("Response body name should be error as {string}")
    public void responseBodyNameShouldBe(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR, equalTo(error));
    }

    @And("Validate invalid register json schema")
    public void validateInvalidJsonSchemaRegister() {
        File jsonSchema = new File(Constant.JSON_SCHEMA_REGISTER_USER+"/InvalidRegisterUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Json file without email
    @Given("Post register user with invalid email json")
    public void postRegisterUserWithInvalidEmailJson() {
        File json = new File(Constant.JSON_REQUEST_REGISTER_USER + "/RequestRegisterUserInvalid_Email.json");
        reqresAPI.registerUser(json);
    }

    //Json file without email and password
    @Given("Post register user with invalid email and password json")
    public void postRegisterUserWithInvalidEmailAndPasswordJson() {
        File json = new File(Constant.JSON_REQUEST_REGISTER_USER + "/RequestRegisterUserInvalid_Email_Password.json");
        reqresAPI.registerUser(json);
    }

}