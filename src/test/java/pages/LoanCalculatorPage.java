package pages;

import entity.CustomerInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.NumberFormat;
import java.util.List;

/**
 * this is the load calculator page and its web elements,
 * and the action on the web elements
 */
public class LoanCalculatorPage extends BasePage{
    @FindBy(how = How.ID, using = "application_type_single")
    public WebElement application_type_single;

    @FindBy(how = How.ID, using = "application_type_joint")
    public WebElement application_type_joint;

    @FindBy(how = How.CSS, using = "select[title='Number of dependants'")
    public WebElement number_of_dependants;

    //Select dropdown_dependants = new Select(number_of_dependants);
    @FindBy(how = How.ID, using = "borrow_type_home")
    public WebElement borrow_type_home;

    @FindBy(how = How.ID, using = "borrow_type_investment")
    public WebElement borrow_type_investment;

    @FindBy(how = How.CSS, using = "input[aria-labelledby='q2q1']")
    public WebElement income;

    @FindBy(how = How.CSS, using = "input[aria-labelledby='q2q2']")
    public WebElement other_income;

    @FindBy(how = How.ID, using = "expenses")
    public WebElement living_expenses;

    @FindBy(how = How.ID, using = "homeloans")
    public WebElement home_loans_repay;

    @FindBy(how = How.ID, using = "otherloans")
    public WebElement other_loan_repay;

    @FindBy(how = How.CSS, using = "input[aria-labelledby='q3q4']")
    public WebElement other_commitment;

    @FindBy(how = How.ID, using = "btnBorrowCalculater")
    public WebElement how_much_i_can_borrow;



    @FindBy(how=How.CSS,using="span.borrow__result__text")
    public WebElement borrow_result_text;

    @FindBy(how=How.ID,using="borrowResultTextAmount")
    public WebElement borrow_result_amount;

    @FindBy(how = How.ID, using = "credit")
    public WebElement credit_card_limit;

    @FindBy(how=How.CSS,using="button[class='start-over']")
    //public WebElement button_Start_Over;
    public List<WebElement> links_button_Start_Over;


    @FindBy(how = How.CSS, using = ".borrow__error__text")
    public WebElement errorMessageText;

    public void assertStartOverButtonDisplayed() {
        Assert.assertTrue(elementHelpers.weElementIsDisplayed(this.links_button_Start_Over.get(0)));
    }

    /**
     * this function is to fill in the customer information into the box
     */
    public void fillInUserInformation(CustomerInfo customer){
        if(customer==null){
            System.out.println("no customer information provided, please check the input!");
        } else {
            if (customer.getApplication_type().equalsIgnoreCase("joint")){
                this.application_type_joint.click();
            }else{
                this.application_type_single.click();
            }
            if (customer.getProperty_purpose().equalsIgnoreCase("Residential investment")){
                this.borrow_type_investment.click();
            } else{
                this.borrow_type_home.click();
            }
            Select select = new Select(this.number_of_dependants);
            select.selectByVisibleText(customer.getNumbers_of_dependents());//selectByIndex(0);
            System.out.println("income is:"+String.valueOf(customer.getIncome()));
            elementHelpers.weSendKeys(this.income,String.valueOf(customer.getIncome()), true);
            elementHelpers.weSendKeys(this.other_income,String.valueOf(customer.getOther_income()),true);
            elementHelpers.weSendKeys(this.living_expenses,String.valueOf(customer.getLiving_costs()),true);
            elementHelpers.weSendKeys(this.home_loans_repay,String.valueOf(customer.getCurrent_home_loan_repay()),true);
            elementHelpers.weSendKeys(this.other_loan_repay,String.valueOf(customer.getOther_loan_repay()),true);
            elementHelpers.weSendKeys(this.other_commitment,String.valueOf(customer.getOther_commit()),true);
            elementHelpers.weSendKeys(this.credit_card_limit,String.valueOf(customer.getTotal_credit_card_limits()),true);
        }
    }

    /**
     * click the "how much i can borrow botton"
     */
    public void submit(){
        elementHelpers.weClick(how_much_i_can_borrow);
    }

    /**
     * verify the borrow money in gui is same with expected
     * @param expectedBorrowNumber
     */
    public void verifyEstimatedBorrowNumber(int expectedBorrowNumber) {
        if (elementHelpers.weElementIsDisplayed(this.borrow_result_amount)) {
            System.out.println(elementHelpers.weElementIsDisplayed(this.borrow_result_amount));
            if (elementHelpers.waitUntilValueChanges(this.borrow_result_text)) {
                System.out.println("the calculated borrow amount is:" + this.borrow_result_amount.getText());
               // NumberFormat formatter = NumberFormat.getIntegerInstance();
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                String expectedNumber=formatter.format((long)expectedBorrowNumber).replace(".00","");
                Assert.assertEquals(this.borrow_result_amount.getText(),expectedNumber);
            }
        }
    }

    public void clearAllInput(){
       // elementHelpers.weClick(this.button_Start_Over);
       this.links_button_Start_Over.get(0).click();
    }

    /**
     * verify after start over button is clicked,
     * all page text input will be reset to original status
     */
    public void verifyPageRest(){
        Assert.assertEquals(this.income.getAttribute("value"),"0");
        Assert.assertEquals(this.other_income.getAttribute("value"),"0");
        Assert.assertEquals(this.living_expenses.getAttribute("value"),"0");
        Assert.assertEquals(this.home_loans_repay.getAttribute("value"),"0");
        Assert.assertEquals(this.other_loan_repay.getAttribute("value"),"0");
        Assert.assertEquals(this.other_commitment.getAttribute("value"),"0");
        Assert.assertEquals(this.credit_card_limit.getAttribute("value"),"0");

    }
    public void assertErrorMessage(String errorMessage) {
        Assert.assertEquals(elementHelpers.weGetAttribute(errorMessageText, "textContent").trim(), errorMessage);
    }
}
