package starter.reqres.Utils;

public class Constant {

    public static  String BASE_URL ="https://reqres.in"; //ini base url
    public static final String DIR = System.getProperty("user.dir"); //ini untuk mendapatkan sitem properti location project


    //Ini Path Json Schema
    public static String JSON_SCHEMA_CREATE_USER = DIR+"/src/test/resources/JSON/JsonSchema/CreateUserSchema"; //untuk path JSON Schema Create User
    public static String JSON_SCHEMA_LIST_USER = DIR+"/src/test/resources/JSON/JsonSchema/ListUserSchema"; //untuk path JSON Schema List User
    public static String JSON_SCHEMA_LOGIN_USER = DIR+"/src/test/resources/JSON/JsonSchema/LoginUserSchema"; //untuk path JSON Schema Login User
    public static String JSON_SCHEMA_REGISTER_USER = DIR+"/src/test/resources/JSON/JsonSchema/RegisterUserSchema"; //untuk path JSON Schema Register User
    public static String JSON_SCHEMA_UPDATE_USER = DIR+"/src/test/resources/JSON/JsonSchema/UpdateUserSchema"; //untuk path JSON Schema Update User


    //Ini Path Json Request
    public static String JSON_REQUEST_CREATE_USER = DIR + "/src/test/resources/JSON/Request/CreateUser"; //untuk path json Request Create User
    public static String JSON_REQUEST_LOGIN_USER = DIR + "/src/test/resources/JSON/Request/LoginUser"; //untuk path json Request Login User
    public static String JSON_REQUEST_REGISTER_USER = DIR + "/src/test/resources/JSON/Request/RegisterUser"; //untuk path json Request Register User
    public static String JSON_REQUEST_UPDATE_USER = DIR+"/src/test/resources/JSON/Request/UpdateUser"; //untuk path json Request Update User



}
