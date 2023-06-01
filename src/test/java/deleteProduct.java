import POJO.loginResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class deleteProduct extends baseClass{
    public deleteProduct() throws Exception {
    }

    @Test
    public void delete() throws Exception {
        Login login = new Login();
        loginResponse responses = login.firstLogin();

        RequestSpecification request = new RequestSpecBuilder().setBaseUri(data.getBaseUri())
                .setContentType(ContentType.JSON)
                .addHeader("authorization", responses.getToken())
                .build();


        RequestSpecification reqLogin = given().log().all().spec(request);
        String res = reqLogin.when().delete("api/ecom/product/delete-product/64711bd1568c3e9fb1777817").then()
                .extract().response().asString();
        System.out.println(res);
    }
}
