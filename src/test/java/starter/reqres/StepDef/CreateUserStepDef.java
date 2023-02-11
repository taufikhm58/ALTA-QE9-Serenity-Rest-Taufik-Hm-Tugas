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

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //Positive Cases
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST_CREATE_USER + "/RequestCreateUser.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USERS);
    }

    @And("Response body name should be {string} and job {string}")
    public void responseBodyNameShouldBeNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @And("validate json schema create user")
    public void validateJsonSchemaCreateUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA_CREATE_USER + "/CreateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Negative Cases
    //Negative Case with file json invalid string
    @Given("Post create user with invalid string json")
    public void postCreateUserWithInvalidStringJson() {
        File json = new File(Constant.JSON_REQUEST_CREATE_USER + "/RequestCreateUserInvalid_String.json");
        reqresAPI.postCreateUser(json);
    }

    //Negative Case with file json invalid job
    @Given("Post create user without job json")
    public void postCreateUserWithInvalidJobJson() {
        File json = new File(Constant.JSON_REQUEST_CREATE_USER + "/RequestCreateUserInvalid_Job.json");
        reqresAPI.postCreateUser(json);
    }

    //Negative Case with file json invalid name
    @And("Post create user with invalid name json")
    public void postCreateUserWithInvalidNameJson() {
        File json = new File(Constant.JSON_REQUEST_CREATE_USER + "/RequestCreateUserInvalid_Name.json");
        reqresAPI.postCreateUser(json);
    }

}
