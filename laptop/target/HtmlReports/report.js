$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Feature/demotask.feature");
formatter.feature({
  "name": "Adding a laptop to the Cart",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search Laptop and add it to the cart",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@chrome"
    }
  ]
});
formatter.step({
  "name": ": I am at the home page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.describe.i_am_at_the_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": ": I click on the \"Laptops\" search filter",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.describe.i_click_on_the_search_filter(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": ": I should be at the \"Laptops\" search page with \"35 items\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.describe.i_should_be_at_the_search_page_with(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": ": The title should be \"Laptops\" search page",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.describe.the_title_should_be_search_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": ": I select the \"APPLE MacBook Pro Retina\" with description as \"15-inch, 256GB\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.describe.i_select_the_with_description_as(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": ": Add it to the cart",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.describe.add_it_to_the_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": ": Navigate to user details page and provide the following details",
  "rows": [
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.describe.navigate_to_user_details_page_and_provide_the_following_details(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
});