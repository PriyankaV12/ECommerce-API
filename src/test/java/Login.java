import POJO.loginResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Login extends baseClass {


    public Login() throws Exception {

    }

    @Test
    public loginResponse firstLogin()
    {

        RequestSpecification request = new RequestSpecBuilder().setBaseUri(data.getBaseUri())
                .setContentType(ContentType.JSON).build();

        ResponseSpecification response = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();

        JSONObject json = new JSONObject();
        json.put("userEmail",data.getUserEmail());
        json.put("userPassword",data.getUserPassword());

        RequestSpecification reqLogin = given().spec(request).body(json.toString());
        loginResponse res = reqLogin.when().post("/api/ecom/auth/login").then()
                .extract().response().as(loginResponse.class);
        String token =  res.getToken();
        String userId = res.getUserId();
        return res;

    }
}
