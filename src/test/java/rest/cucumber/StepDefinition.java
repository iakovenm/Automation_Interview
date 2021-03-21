package rest.cucumber;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;

public class StepDefinition {

    private static final String BASIC_API_PATH = "https://api.ratesapi.io/api/";
    private Response response;


    @When("^user calls \"([^\"]*)\"$")
    public void getApi(String api) throws IOException {
        response = RestAssured
                .given()
                .baseUri(BASIC_API_PATH)
                .when()
                .get(api)
                .then()
                .extract().response();
    }

    @Then("^server return response with a status\"([^\"]*)\"$")
    public void assertResponseWithStatus(String status) {
        Assert.assertEquals(this.response.statusCode(), Integer.parseInt(status));
        System.out.println(this.response.path("base").toString());
        System.out.println(this.response.path("rates[0]").toString());
    }

    @Then("^server return response with correct\"([^\"]*)\",\"([^\"]*)\"$")
    public void assertPositiveResponse(String base, String rates) {
        Assert.assertEquals(this.response.path("base[0]").toString(), base);
        Assert.assertEquals(this.response.path("rates[0],[1]").toString(), rates);
    }

    @Then("^server return response that includes fields \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void assertResponseFields(String base, String rates, String date) {
        Assert.assertEquals(this.response.path("base").toString(), base);
        Assert.assertEquals(this.response.path("rates").toString(), rates);
        Assert.assertEquals(this.response.path("date").toString(), date);
    }

    @Then("^server return response with correct date\"([^\"]*)\"$")
    public void assertResponseDate(String date) {
        Assert.assertEquals(this.response.path("date").toString(), date);
    }
}

