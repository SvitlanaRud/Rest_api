package allTests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(DataProviderRunner.class)
public class TestsWithDataProvider {

    @DataProvider
    public static Object[][] zipCodesAndPlaces(){
        return new Object[][]{
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"},
                {"ca", "B2R", "Waverley"},
        }; }

        @Test
        @UseDataProvider("zipCodesAndPlaces")
        public void requestUsZipCode90210_checkPlaceNameInResponceBody (String countryCode, String zipCode, String expctedPlaceName){
            given().
                    pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).
                    when().get("http://zippopotam.us/{countryCode}/{zipCode}").
                    then().assertThat().body("places[0].'place name'", equalTo(expctedPlaceName)); //Json path

        }
    }
