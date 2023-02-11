package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.reqres.Utils.Constant;

import java.io.File;

public class ReqresAPI {

    public static String GET_LIST_USERS = Constant.BASE_URL + "/api/users?page={page}"; //untuk URL get list users
    public static String POST_CREATE_USERS = Constant.BASE_URL + "/api/users"; //untuk URL post create users
    public static String PUT_UPDATE_USERS = Constant.BASE_URL + "/api/users/{id}"; //untuk URL put create users
    public static String DELETE_USERS = Constant.BASE_URL + "/api/users/{id}"; //untuk URL delete users
    public static String LOGIN_USERS = Constant.BASE_URL + "/api/login"; //untuk URL login users
    public static String REGISTER_USERS = Constant.BASE_URL + "/api/register"; //untuk URL Register users

    //METHOD
    @Step("Get list users") //Untuk valid get list user
    public void getListUsers(int page) {
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Get list users invalid") //Untuk invalid get list user
    public void getListUsersInvalid(String page) {
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Post create user")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void putUpdatUser(int id, File json) {
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Login user")
    public void loginUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Register user")
    public void registerUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
