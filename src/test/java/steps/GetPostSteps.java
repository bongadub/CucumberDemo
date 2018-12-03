package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


import static org.hamcrest.Matchers.is;

import gherkin.lexer.Is;
import io.restassured.http.ContentType;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class GetPostSteps {
    @Given("^I perform GET operation for \"([^\"]*)\"$")
    public void iPerformGETOperationFor(String url) {

        given().contentType(ContentType.JSON);
    }

    @And("^I perform GET for the post number \"([^\"]*)\"$")
    public void iPerformGETForThePostNumber(String postNumber) {
         when().get(String.format("http://localhost:3000/posts/%s", postNumber))
                .then().body("author", is("Bonga"));
    }

    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorNameAs(String arg0) {

    }
//


    @Given("^I perform POST operation for \"([^\"]*)\"$")
    public void iPerformPOSTOperationFor(String arg0) throws Throwable {
        HashMap<String,String> postContent = new HashMap<String, String>();
        postContent.put("id", "6");
        postContent.put("title","Post ");
        postContent.put("author", "Lani");

        given()
                .contentType(ContentType.JSON).

                with()
                .body(postContent).
                when()
                .post("http://localhost:3000/posts").
                then().body("author", is("Lani"));
    }
}