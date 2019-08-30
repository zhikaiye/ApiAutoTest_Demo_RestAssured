package com.kk.wework.contact;

import com.jayway.jsonpath.JsonPath;
import com.kk.wework.WeWork;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Department {

    public Response list(String id){
        return given()
                .param("access_token", WeWork.getToken())
                .param("id",id)
                .header("Content-Type","application/json; charset=UTF-8")
        .when().get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
        .then().log().all().statusCode(200).extract().response();
    }

    public Response create(String name,String id){
        String body = JsonPath.parse(this.getClass().getResourceAsStream("/data/data.json"))
                .set("name",name)
                .set("id",id).jsonString();
        return given().log().all()
                .queryParam("access_token",WeWork.getToken())
                .body(body)
                .header("Content-Type","application/json; charset=UTF-8")
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all().statusCode(200).extract().response();
    }

    public Response update(String id,String name,String parentid,String order){
        String body = JsonPath.parse(this.getClass().getResourceAsStream("/data/uptate.json"))
                .set("name",name)
                .set("parentid",parentid)
                .set("order",order)
                .set("id",id).jsonString();
        return given().log().all()
                .queryParam("access_token",WeWork.getToken())
                .body(body)
                .header("Content-Type","application/json; charset=UTF-8")
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/update")
                .then().log().all().statusCode(200).extract().response();
    }

    public Response delete(String id){
        return given().log().all()
                .queryParam("access_token",WeWork.getToken())
                .queryParam("id",id)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                .then().log().all().statusCode(200).extract().response();
    }
}
