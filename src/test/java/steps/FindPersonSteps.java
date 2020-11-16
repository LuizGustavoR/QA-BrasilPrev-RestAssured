package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import utils.Constants;
import utils.ReadFile;

import static io.restassured.RestAssured.given;

public class FindPersonSteps {

    RequestSpecification requestSpecification;
    Response response;

    @Before
    public void setup(){
        RestAssured.baseURI = "http://localhost/pessoas";
        RestAssured.port = 8080;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Given("that user wants to find person data")
    public void thatUserWantsToFindPersonData() {
        requestSpecification = given().
                header("Content-Type","application/json" );
    }

    @When("make a get request")
    public void makeAGetRequest() {
        response = requestSpecification.when().
                get("/"+16+"/"+9);
    }

    @When("make a get request with dd {int} and number {int}")
    public void makeAGetRequestWithDdAndNumber(int ddd, int number) {
        response = requestSpecification.when().
                get("/"+ddd+"/"+number);
    }

    @Then("return person status {int}")
    public void returnStatus(int status) {
        response.then().
                statusCode(status);
    }

    @After
    public void finish(){
        RestAssured.reset();
    }

}
