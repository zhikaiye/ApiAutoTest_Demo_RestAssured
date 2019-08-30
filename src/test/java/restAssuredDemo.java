import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class restAssuredDemo {
    @Test
    public void testdemo1() {
        when()
                .get("http://m.api.4399.cn//android/box/game/v3.0/search-hotWords.html")
                .then().log().all().statusCode(200);
        when()
                .request("get", "http://m.api.4399.cn//android/box/game/v3.0/search-hotWords.html")
                .then().log().all().statusCode(200);
    }

    @Test
    public void jsonPathTest() {
        when().get("http://m.api.4399.cn//android/box/game/v3.0/search-hotWords.html").then().statusCode(200);
    }

    @Test
    public void paramGetTest() {

        given().log().all()
                .param("word", "mp3")
                .when().get("http://www.baidu.com/s")
                .then().log().all().statusCode(200);

    }

    @Test
    public void paramPostTest() {
        //startKey
        //installedIds	105102,105839,123796,
        //from	search
        //sessionId	1566048222468fhCphQL0KRsUSu8Q
        //word	王者荣耀
        //n	20
        given()
                .param("startKey", "")
                .param("installedIds", "")
                .param("from", "search")
                .param("sessionId", "1566048222468fhCphQL0KRsUSu8Q")
                .param("word", "王者荣耀")
                .param("n", "20")
                .when().post("http://m.api.4399.cn/app/android/v4.2.2/game-search.html").then().statusCode(200);
    }

    @Test
    public void multiParamTest() {
        given().log().all()
                .param("word", "aaa", "bbb", "ccc")
                .when().get("https://www.baidu.com/s").then().statusCode(200);
    }

    @Test
    public void listParamTest() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        given().log().all()
                .param("word", list)
                .when().get("https://www.baidu.com/s").then().statusCode(200);
    }

    @Test
    public void cookieTest() {
        //Hm_lvt_1b08922f2d6095855a3530341e9b66ca	1566097509
        //Hm_lpvt_1b08922f2d6095855a3530341e9b66ca	1566097509
        //Hm_lvt_da0bce75c9049bf4056836b34215ec4c	1566097513
        //_4399tongji_vid	156609751332626
        //_4399tongji_st	1566097513
        //Hm_lvt_5c9e5e1fa99c3821422bf61e662d4ea5	1566097513
        //smidV2	20190818110513ee183cb7f9ce38c2bcce540206750f13009c6e1c44527e270
        //Pauth	2591652446%7C2017011111%7C82202ed87b2b2a8606c1a6cb439cfd46%7C1566097524%7C0%7C44a5088a7579f375df6607b7a44fed9e%7C
        //User	%E5%B0%8F%E5%B0%8F%E8%8F%9C%E9%B8%9F-%E7%83%A6%E6%81%BC%E5%A4%9A%E5%A4%9A%EF%BC%9F%7C2591652446%7C2017011111%7Ce2b3c092e2d346664bab37d3bd490523f61814d1
        //Pnick	%E5%B0%8F%E5%B0%8F%E8%8F%9C%E9%B8%9F-%E7%83%A6%E6%81%BC%E5%A4%9A%E5%A4%9A%EF%BC%9F
        //_ga	GA1.2.909730290.1566097766
        //_gid	GA1.2.495113880.1566097766
        //ad_forums	1
        //Hm_lpvt_5c9e5e1fa99c3821422bf61e662d4ea5	1566097794
        //Hm_lpvt_da0bce75c9049bf4056836b34215ec4c	1566097794
        given().log().all()
                .cookie("Hm_lvt_1b08922f2d6095855a3530341e9b66ca", "1566097509")
                .cookie("Hm_lpvt_1b08922f2d6095855a3530341e9b66ca", "1566097509")
                .cookie("Hm_lvt_da0bce75c9049bf4056836b34215ec4c", "1566097513")
                .cookie("_4399tongji_vid", "156609751332626")
                .cookie("_4399tongji_st", "1566097513")
                .cookie("Hm_lvt_5c9e5e1fa99c3821422bf61e662d4ea5", "1566097513")
                .cookie("smidV2", "20190818110513ee183cb7f9ce38c2bcce540206750f13009c6e1c44527e270")
                .cookie("Pauth", "2591652446%7C2017011111%7C82202ed87b2b2a8606c1a6cb439cfd46%7C1566097524%7C0%7C44a5088a7579f375df6607b7a44fed9e%7C")
                .cookie("User", "2591652446%7C2017011111%7C82202ed87b2b2a8606c1a6cb439cfd46%7C1566097524%7C0%7C44a5088a7579f375df6607b7a44fed9e%7C")
                .cookie("Pnick", "%E5%B0%8F%E5%B0%8F%E8%8F%9C%E9%B8%9F-%E7%83%A6%E6%81%BC%E5%A4%9A%E5%A4%9A%EF%BC%9F")
                .cookie("_ga", "GA1.2.909730290.1566097766")
                .cookie("_gid", "GA1.2.495113880.1566097766")
                .cookie("ad_forums", "1")
                .cookie("Hm_lpvt_5c9e5e1fa99c3821422bf61e662d4ea5", "1566097794")
                .cookie("Hm_lpvt_da0bce75c9049bf4056836b34215ec4c", "Hm_lpvt_da0bce75c9049bf4056836b34215ec4c")
                .when().get("http://bbs.4399.cn/forums-mythread").then().statusCode(200);
    }

    @Test
    public void cookieTest1() {
        given().log().all()
                .cookie("baidu", "cookie1", "cookie2")
                .when().get("https://www.baidu.com").then().statusCode(200);
    }

    @Test
    public void cookieTest2() {
        Cookie cookie = new Cookie.Builder("baidu", "cookie1").build();
        given().log().all()
                .cookie(cookie)
                .when().get("https://www.baidu.com").then().statusCode(200);
    }

    @Test
    public void cookieTest3() {
        Cookie cookie = new Cookie.Builder("baidu", "cookie1").build();
        Cookie cookie1 = new Cookie.Builder("baidu", "cookie2").build();
        Cookies cookies = new Cookies(cookie, cookie1);


        given().log().all()
                .cookies(cookies)
                .when().get("https://www.baidu.com").then().statusCode(200);
    }

    @Test
    public void headTest() {
        given().log().all()
                .header("header", "aaa")
                .header("header1", "bbb")
                .when().get("http://www.baidu.com").then().statusCode(200);
    }

    @Test
    public void headsTest() {
        given().log().all()
                .header("header", "aaa", "ccc")
                .header("header1", "bbb")
                .when().get("http://www.baidu.com").then().statusCode(200);
    }

    @Test
    public void responseTest() throws IOException {
//        InputStream json = when().get("https://www.baidu.com").asInputStream();
//        System.out.println(json);
//        json.close();

        Response response = when().get("https://www.baidu.com").then().extract().response();
        System.out.println(response.asString());
    }

    @Test
    public void responseTest1() {
        Response s = when().get("http://m.api.4399.cn//android/box/game/v3.0/search-hotWords.html")
                .then()
                .extract().response();
        String s2 = s.asString();
        System.out.println(s2);
        String s1 = s.jsonPath().getString("result.Version-V");
        System.out.println(s1);
    }

    @Test
    public void responseTest2() {
        String s = when().get("http://m.api.4399.cn//android/box/game/v3.0/search-hotWords.html")
                .andReturn().jsonPath().getString("code");
        System.out.println(s);
    }

    @Test
    public void cookie_header_status_Get() {

        Response response = when().get("http://bbs.4399.cn/");
        Headers headers = response.getHeaders();
        for (Object o : headers.asList().toArray()) {
            System.out.println(o);
        }
        System.out.println("=================以上是headers====================");
        String header = response.getHeader("Content-Type");
        System.out.println(header);
        System.out.println("=================以上是header=====================");
        Map<String, String> cookies = response.getCookies();
        System.out.println(cookies);
        System.out.println("=================以上是Cookies=====================");
        String cookie = response.getCookie("_4399stats_vid");
        System.out.println(cookie);
        System.out.println("=================以上是Cookie======================");
        String lineStatus = response.getStatusLine();
        System.out.println(lineStatus);
        System.out.println("=================以上是lineStatus===================");
        int lineCode = response.getStatusCode();
        System.out.println(lineCode);
        System.out.println("=================以上是lineCode====================");
    }

    @Test
    public void cookie_detail_get() {
        Response response = when().get("http://bbs.4399.cn/");
        Cookie cookie = response.getDetailedCookie("_4399stats_vid");
        String domain = cookie.getDomain();
        System.out.println("这是domain的值:" + domain);
        String comment = cookie.getComment();
        System.out.println("这是comment的值:" + comment);
        Date expiryDate = cookie.getExpiryDate();
        System.out.println("这是expiryDate的值:" + expiryDate);
        int maxAge = cookie.getMaxAge();
        System.out.println("这是maxAge的值:" + maxAge);
        String name = cookie.getName();
        System.out.println("这是name的值:" + name);
        String path = cookie.getPath();
        System.out.println("这是path的值:" + path);

        Cookies cookies = response.getDetailedCookies();
        System.out.println("打印所有getDetailedCookies：");
        for (Object o : cookies.asList().toArray()) {
            System.out.println(o);
        }
    }

    @Test
    public void cookie_verify() {
        when().get("http://bbs.4399.cn/").then().assertThat().cookie("_4399stats_vid", "1566128251400247");
        when().get("http://bbs.4399.cn/").then().assertThat().cookies("_4399stats_vid", "1566128251400247"
                , "bbb", "ccc");
        when().get("http://bbs.4399.cn/").then().assertThat().cookie("_4399stats_vid", containsString("1566128"));
    }


    @Test
    public void status_line_code_verify() {
        when().get("http://bbs.4399.cn/").then().assertThat().statusCode(200);
        when().get("http://bbs.4399.cn/").then().assertThat().statusLine("HTTP/1.1 200 OK");
        when().get("http://bbs.4399.cn/").then().assertThat().statusLine(containsString("200 OK"));
    }

    @Test
    public void header_verify() {
        when().get("http://bbs.4399.cn/").then().assertThat().header("Content-Type", "text/html");
        when().get("http://bbs.4399.cn/").then().assertThat()
                .headers("Content-Type", "text/html", "Content-Length", "13894");
        when().get("http://bbs.4399.cn/").then().assertThat()
                .headers("Content-Type", containsString("text"), "Content-Length", "13894");

        when().get("http://bbs.4399.cn/").then().assertThat()
                .header("Content-Length", Integer::parseInt, lessThan(2000));
    }

    @Test
    public void content_type_verify() {
        when().get("http://bbs.4399.cn/").then().assertThat().contentType("text/html");
    }


    @Test
    public void body_verify() {
        when().get("http://bbs.4399.cn/").then().assertThat().body(equalTo("adfadfa"));
    }


    @Test
    public void jsonPathDemo() {
        JsonPath jsonPath = new JsonPath("{\"lotto\": {\"lottoId\": 5,\"winning-numbers\": [2, 45, 34, 23, 7, 5, 3],\"winners\": [{\"winnerId\": 23,\"numbers\": [2, 45, 34, 23, 3, 5]}, {\"winnerId\": 54,\"numbers\": [52, 3, 12, 11, 18, 22]}]}}");

        int lottoid = jsonPath.getInt("lotto.lottoId");
        System.out.println(lottoid);

        List<Integer> list = jsonPath.getList("lotto.winning-numbers");
        for (Integer o : list) {
            System.out.println(o);
        }

        System.out.println("---------------这个是分割线-----------------");

        List<Integer> list1 = jsonPath.getList("lotto.winners.winnerId");
        for (Integer o : list1) {
            System.out.println(o);
        }

        System.out.println("---------------这个是分割线-----------------");

        int sumOfWinningNumbers = jsonPath.getInt("lotto.winning-numbers.sum()");
        System.out.println(sumOfWinningNumbers);

        System.out.println("---------------这个是分割线-----------------");

        List<Integer> list2 = jsonPath.getList("lotto.winners.find {it.winnerId == 23}.numbers.findAll {it > 10}", Integer.class);
        for (Integer o : list2){
            System.out.println(o);
        }
    }

    @Test
    public void jsonPathdemo1(){
        when().get("http://localhost:8082/lotto.json").then()
                .body("lotto.winners.find{winners -> winners.winnerId>23}.winnerId",equalTo(54));
    }

    @Test
    public void xmlPathDemo(){
        when().get("http://localhost:8082/shopping.xml").then()
                .body("shopping.category.item[0].name",equalTo("Chocolate"))
                .body("shopping.category.item.size()",equalTo(5))
                .body("shopping.category.findAll { it.@type == 'groceries' }.size()",equalTo(1));

    }
}
