package PostMitExtract;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class CreateBooking {
    @Test
    public void CreateBookingWithPost(){
       Response response = given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"firstname\" : \"Jim\",\n" +
                        "\"lastname\" : \"Brown\",\n"+
                        "\"totalprice\" : 111,\n" +
                        "\"depositpaid\" : true,\n" +
                        "\"bookingdates\" : {\n"+
                            "\"checkin\" : \"2018-01-01\",\n"+
                            "\"checkout\" : \"2019-01-01\" },\n" +
                        "\"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .post();

    // bookingid yi yazdirma

               int Bookingid = response
                .then()
                .statusCode(200)
                .extract()
                .path("bookingid");
        System.out.println("bookingid = " + Bookingid);

    // lastname i yazdirma

                String Lastname = response
                        .then()
                        .extract()
                        .path("booking.lastname");
        System.out.println("Lastname = " + Lastname);

    }

}
