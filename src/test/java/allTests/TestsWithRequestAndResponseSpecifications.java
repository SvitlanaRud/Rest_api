package allTests;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class TestsWithRequestAndResponseSpecifications {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responceSpec;

    @BeforeClass
    public static void createRequestSpecification() {
        requestSpec = new RequestSpecBuilder().
                setBaseUri("http://zippopotam.us").
                build();
    }
    @BeforeClass
    public static void createResponceSpecification() {
        responceSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }

    @Test
    public void requestUsZipCode90210(){
        given().
            spec(requestSpec).
        when().
            get("us/90210").
                then().
                    assertThat().
                    statusCode(200);
    }

    @Test
    public void requestUsZipCode90210_2(){
        given().
            spec(requestSpec).
        when().
            get("us/90210").
        then().
            spec(responceSpec).
        and().
            assertThat().
            body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    public void requestUsZipCode90210_exptactPlaceName(){
        String placeName =
        given().
                spec(requestSpec).
                when().
                    get("us/90210").
                then().
                    extract().
                    path("places[0].'place name'");
        Assert.assertEquals(placeName,"Beverly Hills" );
    }
}
