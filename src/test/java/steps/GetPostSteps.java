package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;




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

    @Then("^Response status code should be \"([^\"]*)\"$")
    public void responseStatusCodeShouldBe(Integer code)  {
        given().contentType(ContentType.JSON).
                when().
                then().statusCode(code);
    }


    @Given("^I create a post method with author \"([^\"]*)\" and id \"([^\"]*)\" with title \"([^\"]*)\"$")
    public void i_create_a_post_method_with_author_and_id_with_title(String name, String id, String title)  {
        HashMap<String, String> postContent = new HashMap<String, String>();
        postContent.put("id", id);
        postContent.put("title", title);
        postContent.put("author", name);

        given().contentType(ContentType.JSON).

                with()
                .body(postContent).
                when()
                .post("http://localhost:3000/posts").
                then();
    }

    @Given("^I perform Delete operation for id \"([^\"]*)\"$")
    public void i_perform_Delete_operation_for_id(String id) {
        given().contentType(ContentType.JSON);

        when().delete("http://localhost:3000/posts/{%s}", id).
                then().statusCode(200);
    }

    @Then("^Response code should be \"([^\"]*)\"$")
    public void responseCodeShouldBe(Integer code) {
        given().contentType(ContentType.JSON).
                when().
                then().statusCode(code);
    }



    @Given("^I create a update operation$")
    public void iCreateAUpdateOperation() {
        HashMap<String,String> postContent = new HashMap<String, String>();
        postContent.put("id", "6");
        postContent.put("title","Updated Title");
        postContent.put("author", "New Author");

        given()
                .contentType(ContentType.JSON).

                with()
                .body(postContent).
                when()
                .put("http://localhost:3000/posts/6").
                then();
    }
}