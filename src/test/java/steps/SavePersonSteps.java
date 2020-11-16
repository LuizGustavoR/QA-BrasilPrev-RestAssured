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

public class SavePersonSteps {

    RequestSpecification requestSpecification;
    Response response;

    @Before
    public void setup(){
        RestAssured.baseURI = "http://localhost/pessoas";
        RestAssured.port = 8080;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Given("that user wants to save new person data")
    public void thatUserWantsToSaveNewPersonData() {
        String file = ReadFile.getFile(Constants.JSON_PATH + "newPerson.json");
        JSONObject jsonObject = new JSONObject(file);

        requestSpecification = given().
                header("Content-Type","application/json" ).
                body(jsonObject.toString());
    }

    @When("make a post request")
    public void makeAPostRequest() {
        response = requestSpecification.when().post();
    }

    @Then("return status {int}")
    public void returnStatus(int status) {
        response.then().
                statusCode(status);
    }

    @After
    public void finish(){
        requestSpecification = null;
        response = null;
    }

}
