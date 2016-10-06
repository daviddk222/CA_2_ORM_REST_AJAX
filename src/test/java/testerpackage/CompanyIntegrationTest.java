package testerpackage;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

/**
 *
 * @author John
 */
public class CompanyIntegrationTest {
    private String baseUrl = "http://localhost:8084/CA2REST/api/company";
    
    public CompanyIntegrationTest() {
        
    }
    
//    @Test
//    public void VerifyAllCompanies() {
//        given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get(baseUrl + "/complete")
//                .then()
//                .statusCode(200)
//                //Checking for dummy-data in several json objects
//                .body("firstname", hasItems("Daniel", "Mohammed", "David"));
//    }
    
    @Test
    public void VerifySingleCvr() {
        given()
                .contentType(ContentType.JSON)
                .pathParam("cvr","384729")
                .when()
                .get(baseUrl + "/complete/cvr/{cvr}")
                .then()
                .statusCode(200)
                .body("name", equalTo("DWP Web"));
    }
    
    @Test
    public void VerifySingleCvrException() {
        given()
                .contentType(ContentType.JSON)
                .pathParam("cvr","999999999")
                .when()
                .get(baseUrl + "/complete/cvr/{cvr}")
                .then()
                .statusCode(404)
                .body("message", equalTo("No company with that cvr was found"));
    }
    
    @Test
    public void UndefinedCompany() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(baseUrl)
                .then()
                .statusCode(404)
                .body("message", equalTo("The service you requested does not exist."));
    }
    
    @Test
    public void VerifyPhone() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .pathParam("phone", "93949192")
                .get(baseUrl + "/complete/phone/{phone}")
                .then()
                .statusCode(200)
                .body("name", equalTo("DWP Web"));
    }
    
//    @Test
//    public void VerifyContactInfo() {
//        given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get(baseUrl + "/contactinfo")
//                .then()
//                .statusCode(200)
//                .body("", hasItems("id", "name", "email"));
//    }
    
}
