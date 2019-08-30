package com.kk.wework;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class WeWork {

    private static String token;
    private static String getWeToken(){
        return given()
                .queryParam("corpid",WeWorkConfig.getInstance().corpid)
                .queryParam("corpsecret",WeWorkConfig.getInstance().secret)
                .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then().log().all().statusCode(200).body("errcode",equalTo(0))
        .extract().path("access_token");
    }

    public static String getToken(){
        if (token==null){
            token=getWeToken();
        }
        return token;
    }
}
