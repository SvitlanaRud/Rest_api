package utils;
//
//import static io.restassured.RestAssured.*;
//import org.junit.Test;
//import static org.hamcrest.Matchers.equalTo;
//
//
//
//public class Utils{
//
//        @Test
//        public void verifyGooglePlacesApi() {
//            RestAssured.baseURI = "https://maps.googleapis.com";
//            given().
//                    param("location", "-33.8670522,151.1957362").
//                    param("radius", "1500").
//                    param("key", "YOUR_API_KEY").
//                    when().
//                    get("maps/api/place/nearbysearch/json").
//                    then().assertThat().
//                    statusCode(200).and().contentType(ContentType.JSON).and().
////                    body("results[0].name", equalTo("Sydney")).
//                    and().header("Server", "scaffolding on HTTPServer2");
//            //Verify status code of the responce
//            //Content type
//            //Body
//            //Header response
//        }
//
//        @Test
//        public void postData() {
//            RestAssured.baseURI = "https://maps.googleapis.com";
//            Response res = given().
//                    param("location", "-33.8670522,151.1957362").
//                    param("radius", "1500").
//                    param("key", "YOUR_API_KEY").
//                    when().
//                    get("maps/api/place/nearbysearch/json").
//                    then().assertThat().
//                    statusCode(200).and().contentType(ContentType.JSON).and().
////                    body("results[0].name", equalTo("Sydney")).
//                    and().header("Server", "scaffolding on HTTPServer2").
//                    extract().response();
//
//                    String responseString = res.asString();
//            System.out.println(responseString);
//            JsonPath jsP = new JsonPath(responseString);
//            String status = jsP.get("status");
//            System.out.println(status);
//
//
//        }
//
//    }
