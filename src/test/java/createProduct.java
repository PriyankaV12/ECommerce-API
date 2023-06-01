import POJO.createProductResponse;
import POJO.loginResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class createProduct extends baseClass {


    public createProduct() throws Exception {
    }

    @Test
    public String product() throws Exception {

        Login login = new Login();
        loginResponse responses = login.firstLogin();


        RequestSpecification request = new RequestSpecBuilder().setBaseUri(data.getBaseUri())
                .addHeader("authorization", responses.getToken())
                .build();

        ResponseSpecification response = new ResponseSpecBuilder().expectStatusCode(201)
                .expectContentType(ContentType.JSON).build();


     RequestSpecification addProduct = given().log().all().spec(request).param("productName", data.getProductName())
                .param("productAddedBy", responses.getUserId())
                .param("productCategory", data.getProductCategory())
                .param("productSubCategory", data.getProductSubCategory())
                .param("productPrice", data.getProductPrice())
                .param("productDescription", data.getProductDescription())
                .param("productFor", data.getProductFor())
                .multiPart("productImage", new File(data.getProductImage()));

    createProductResponse result = addProduct.when().post("api/ecom/product/add-product")
            .then().log().all().extract().response().as(createProductResponse.class);

      String productId = result.getProductId();
      String message = result.getMessage();

      return productId;
    }
}
