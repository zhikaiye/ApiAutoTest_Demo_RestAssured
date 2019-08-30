import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class baidu {

    @Test
    public void Baidu() {
        given()
                .log().all().get("https://www.baidu.com")
                .then().log().all().statusCode(200);
    }

    @Test
    public void baidump3() {
        given().log().all()
                .queryParam("wd", "mp3")
                .when()
                .get("http://www.baidu.com/s")
                .then().log().all().statusCode(200);


    }

    @Test
    public void proxydemo(){
        useRelaxedHTTPSValidation();
        given().log().all().proxy("192.168.1.108",8888)
                .when()
                .get("https://www.baidu.com")
                .then().log().all().statusCode(200);
    }
}
