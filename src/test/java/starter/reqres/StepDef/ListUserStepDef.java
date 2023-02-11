package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ListUserStepDef {
        @Steps
        ReqresAPI reqresAPI;

        //Positive Cases
        @Given("Get list user with page {int}")
        public void getListUserWithPage(int page) {
            reqresAPI.getListUsers(page);
        }

        @When("Send request get list user")
        public void sendRequestGetListUser() {
            SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
        }

        @Then("Should return status code {int}")
        public void shouldReturnStatusCode(int ok) {
            SerenityRest.then().statusCode(ok);
        }

        @And("Response body page should be {int}")
        public void responseBodyShouldPageShouldBePage(int page) {
            SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
        }

        @And("Validate json schema list user")
        public void validateJsonSchemaListUser() {
            File jsonSchema = new File(Constant.JSON_SCHEMA_LIST_USER + "/ListUserSchema.json");
            SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
        }

        //Negative Cases
        @Given("Get list user with page {string}")
        public void getListUserWithPage(String page) {
            reqresAPI.getListUsersInvalid(page);
        }

    }

