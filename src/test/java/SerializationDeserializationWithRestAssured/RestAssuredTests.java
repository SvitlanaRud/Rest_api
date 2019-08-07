package SerializationDeserializationWithRestAssured;

import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTests {

    //JSON Serialization
    @Test
    public void testVideoGameSerializationJSON(){

        //instance of Video Game object
        VideoGame myVideoGame = new VideoGame("Halo", 88, "2012-06-03", "Shooter", "PG-13", 11);

        given().
                contentType("application/json").
                body(myVideoGame).
        when().
                post("http://localhost:8080/videogames").
         then().
                assertThat().
                body(equalTo("{\"status\": \"Record Added Successfully\"}"));
    }

    //XML Serialization
    @Test
    public void testVideoGameSerializationXML(){

        //instance of Video Game object
        VideoGame myVideoGame = new VideoGame("Halo", 88, "2012-06-03", "Shooter", "PG-13", 11);

        given().
                contentType("application/xml").
                body(myVideoGame).
                when().
                post("http://localhost:8080/videogames").
                then().
                assertThat().
                body(equalTo("{\"status\": \"Record Added Successfully\"}"));
    }

    //JSON De-Serialization
    @Test
    public void testVideogameDeSerialization(){
        VideoGame myVideogame = get(("http://localhost:8080/videogames/13")).as(VideoGame.class);
        System.out.println(myVideogame.toString());
    }
}
