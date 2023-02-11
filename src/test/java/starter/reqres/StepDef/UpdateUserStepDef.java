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

public class UpdateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //Positive Cases
    @Given("Put update user with valid json with id {int}")
    public void putUpdateUserWithValidJsonWithId(int id) {
        File json = new File( Constant.JSON_REQUEST_UPDATE_USER+"/RequestUpdateUser_1.json");
        reqresAPI.putUpdatUser(id,json);
    }

    @Given("Put update user job with valid json with id {int}")
    public void putUpdateUserJobWithValidJsonWithId(int id) {
        File json = new File( Constant.JSON_REQUEST_UPDATE_USER+"/RequestUpdateUser_2.json");
        reqresAPI.putUpdatUser(id,json);
    }

    @Given("Put update user name with valid json with id {int}")
    public void putUpdateUserNameWithValidJsonWithId(int id) {
        File json = new File( Constant.JSON_REQUEST_UPDATE_USER+"/RequestUpdateUser_3.json");
        reqresAPI.putUpdatUser(id,json);
    }

    @And("Response update user body name should be {string} and job {string}")
    public void responseUpdateUserBodyNameShouldBeAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @And("Response update job body name should be {string} and job {string}")
    public void responseUpdateJobBodyNameShouldBeAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @And("Response update name body name should be {string} and job {string}")
    public void responseUpdateNameBodyNameShouldBeAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USERS);
    }

    @And("Validate json schema update user")
    public void validateJsonSchemaUpdateUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA_UPDATE_USER+"/UpdateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Negative Case
    @Given("Put update user with invalid null name json with id {int}")
    public void putUpdateUserWithInvalidNullNameJsonWithId(int id) {
        File json = new File( Constant.JSON_REQUEST_UPDATE_USER+"/RequestUpdateUserInvalid_NullName.json");
        reqresAPI.putUpdatUser(id,json);
    }

    @Given("Put update user with invalid null job json with id {int}")
    public void putUpdateUserWithInvalidNullJobJsonWithId(int id) {
        File json = new File( Constant.JSON_REQUEST_UPDATE_USER+"/RequestUpdateUserInvalid_NullJob.json");
        reqresAPI.putUpdatUser(id,json);
    }

    @Given("Put update user with invalid string json with id {int}")
    public void putUpdateUserWithInvalidStringJsonWithId(int id) {
        File json = new File( Constant.JSON_REQUEST_UPDATE_USER+"/RequestUpdateUserInvalid_String.json");
        reqresAPI.putUpdatUser(id,json);
    }

    @Given("Put update user with invalid null name and null job json with id {int}")
    public void putUpdateUserWithInvalidNullNameAndNullJobJsonWithId(int id) {
        File json = new File( Constant.JSON_REQUEST_UPDATE_USER+"/RequestUpdateUserInvalid_NullName_NullJob.json");
        reqresAPI.putUpdatUser(id,json);
    }
}
