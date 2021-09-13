package steps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import pages.*;
import entity.*;
import utils.helpers.JSONHelper;
import utils.selenium.Driver;
import utils.selenium.Settings;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/**
 * load calculator step page for cucumer
 * this is userd to align to the steps in the feature file
 */
public class LoanCalculatorStep extends Page{

    CustomerInfo customer;
    @Given("Client navigate to the loan page")
    public void client_navigate_to_the_loan_page() {
        instanceOf(LoanCalculatorPage.class).navigateToBaseUrl();
    }

    @When("they input the detailed information for themselves from test data file")
    public void they_input_the_detailed_information_for_themselves_as_below() {
        // Write code here that turns the phrase above into concrete actions
       JSONHelper jsHelp = new JSONHelper();
        customer=jsHelp.loadCustomerFromJSON("src/test/resources/features/test_data/customerInfo.json");
// System.out.println("in steps ,custoemr is:"+customer.toString());
        instanceOf(LoanCalculatorPage.class).fillInUserInformation(customer);
    }
    @Then("they click button Work out how much I can borrow")
    public void they_click_button_work_out_how_much_i_can_borrow() {
        // Write code here that turns the phrase above into concrete actions
        instanceOf(LoanCalculatorPage.class).submit();
    }
    @Then("they can get the estimate they could borrow")
    public void they_can_get_the_estimate_they_could_borrow() {
       instanceOf(LoanCalculatorPage.class).verifyEstimatedBorrowNumber(customer.getExpected_loan_amount());
    }

    @When("they click on Start Over button")
    public void theyClickOnStartOverButton() {
        instanceOf(LoanCalculatorPage.class).clearAllInput();
    }

    @Then("all the information has been cleared")
    public void allTheInformationHasBeenCleared() {
        instanceOf(LoanCalculatorPage.class).verifyPageRest();
    }

    @And("they enter below data for their information")
    public void theyEnterBelowDataForTheirInformation(DataTable arg1) {

    }


    @And("they enter below data for their information as below")
    public void theyEnterBelowDataForTheirInformationAsBelow(DataTable input) {
        List<Map<String,String>> data = input.asMaps(String.class,String.class);
        String living_expenses=data.get(0).get("living expenses");
        System.out.println("living expense is:"+living_expenses);
        customer=new CustomerInfo();
        customer.setAllIntFieldToZero();
        customer.setLiving_costs(Integer.valueOf(living_expenses));
        instanceOf(LoanCalculatorPage.class).fillInUserInformation(customer);
        //String error_message=data.get(0).get("error message");
    }

    @Then("^they see the error message \"([^\"]*)\"$")
    public void theySeeErrorMessage(String errorMessage) {
        instanceOf(LoanCalculatorPage.class).assertErrorMessage(errorMessage);
    }

}
