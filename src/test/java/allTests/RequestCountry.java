package allTests;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RequestCountry{

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponceBody(){
                given().
                when().get("http://zippopotam.us/US/00210").
                then().assertThat().body("places[0].'place name'", equalTo("Portsmouth")). //Json path
                and().assertThat().statusCode(200).and().contentType(ContentType.JSON);
    }

    @Test
    public void requestUsZipCode90210_checkNumberOfPlacesNamesInResponceBody(){
        given().
                when().get("http://zippopotam.us/US/00210").
                then().assertThat().body("places.'place name'", hasItem("Portsmouth")); //Json path
    }

    @Test
    public void requestUsZipCode90210_checkNotHasPlaceNamesInResponceBody(){
        given().
                when().get("http://zippopotam.us/US/00210").
                then().assertThat().body("places.'place name'", not(hasItem("New York"))); //Json path
    }
    @Test
    public void requestUsZipCode90210_checkNumberOfPlacesNamesInResponceBodys(){
        given().
                when().get("http://zippopotam.us/US/00210").
                then().assertThat().body("places.'place name'", hasSize(1)); //Json path
    }

    @Test
    public void requestUsZipCode90210_checkStateNameInResponceBody() {
        given().
                when().get("http://zippopotam.us/US/00210").
                then().assertThat().body("places[0].'state'", equalTo("New Hampshire")); //Json path
    }

    @Test
    public void requestUsZipCode90210_logRequestAndResponseDetails(){
        given().
                log().all().
                when().
            get("http://zippopotam.us/US/00210").
         then().
            log().body();
    }
}
