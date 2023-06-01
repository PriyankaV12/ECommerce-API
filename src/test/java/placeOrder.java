import POJO.loginResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class placeOrder extends baseClass {

    public placeOrder() throws Exception {
    }

    @Test
    public void order() throws Exception {

        Login login = new Login();
        loginResponse responses = login.firstLogin();

        RequestSpecification request = new RequestSpecBuilder().setBaseUri(data.getBaseUri())
                .setContentType(ContentType.JSON)
                .addHeader("authorization", responses.getToken())
                .build();

        ResponseSpecification response = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON).build();


        List<Order> orders = data.getOrders();

        JSONArray ordersArray = new JSONArray();
        for (Order order : orders) {
            JSONObject orderObject = new JSONObject();
            orderObject.put("country", order.getCountry());
            orderObject.put("productOrderedId", order.getProductOrderedId());
            ordersArray.put(orderObject);
        }

        JSONObject requestBody = new JSONObject();
        requestBody.put("orders", ordersArray);

        RequestSpecification reqLogin = given().log().all().spec(request).body(requestBody.toString());
            String res = reqLogin.when().post("api/ecom/order/create-order").then()
                    .extract().response().asString();

        }
    }

