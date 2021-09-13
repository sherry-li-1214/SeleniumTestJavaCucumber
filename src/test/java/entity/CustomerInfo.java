package entity;

/**
 * this class is to keep the user input as customer object
 * and all the property
 */
public class CustomerInfo {
    private String application_type="single";
    private String numbers_of_dependents= "0";
    private String property_purpose="Home to Live in" ;
    private int income=80000;
    private int other_income=10000;
    private int living_costs=500;

    private int current_home_loan_repay=0;
    private int other_loan_repay=100;
    private int other_commit=0;
    private int total_credit_card_limits=10000;
    private int expected_loan_amount=508000;

    public int getExpected_loan_amount() {
        return expected_loan_amount;
    }

    public CustomerInfo(){

    }

    public String getNumbers_of_dependents() {
        return numbers_of_dependents;
    }

    public String getProperty_purpose() {
        return property_purpose;
    }

    public int getIncome() {
        return income;
    }

    public int getOther_income() {
        return other_income;
    }

    public int getLiving_costs() {
        return living_costs;
    }

    public int getCurrent_home_loan_repay() {
        return current_home_loan_repay;
    }

    public int getOther_loan_repay() {
        return other_loan_repay;
    }

    public int getOther_commit() {
        return other_commit;
    }

    public int getTotal_credit_card_limits() {
        return total_credit_card_limits;
    }

    public String getApplication_type() {
        return application_type;
    }
    @Override
    public String toString() {
        return "CustomerInfo{" +
                "application_type='" + application_type + '\'' +
                ", numbers_of_dependents='" + numbers_of_dependents + '\'' +
                ", property_purpose='" + property_purpose + '\'' +
                ", income=" + income +
                ", other_income=" + other_income +
                ", living_costs=" + living_costs +
                ", current_home_loan_repay=" + current_home_loan_repay +
                ", other_loan_repay=" + other_loan_repay +
                ", other_commit=" + other_commit +
                ", total_credit_card_limits=" + total_credit_card_limits +
                ", expected_loan_amount=" + expected_loan_amount +
                '}';
    }

    /**
     * clear the customer object and make all number elements to zero
     * @param
     */
    public void setAllIntFieldToZero(){
        income=0;
        other_income=0;
        living_costs=0;
        current_home_loan_repay=0;
        other_loan_repay=0;
        other_commit=0;
        total_credit_card_limits=0;

    }


    public void setApplication_type(String application_type) {
        this.application_type = application_type;
    }

    public void setNumbers_of_dependents(String numbers_of_dependents) {
        this.numbers_of_dependents = numbers_of_dependents;
    }

    public void setProperty_purpose(String property_purpose) {
        this.property_purpose = property_purpose;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void setOther_income(int other_income) {
        this.other_income = other_income;
    }

    public void setLiving_costs(int living_costs) {
        this.living_costs = living_costs;
    }

    public void setCurrent_home_loan_repay(int current_home_loan_repay) {
        this.current_home_loan_repay = current_home_loan_repay;
    }

    public void setOther_loan_repay(int other_loan_repay) {
        this.other_loan_repay = other_loan_repay;
    }

    public void setOther_commit(int other_commit) {
        this.other_commit = other_commit;
    }

    public void setTotal_credit_card_limits(int total_credit_card_limits) {
        this.total_credit_card_limits = total_credit_card_limits;
    }

    public void setExpected_loan_amount(int expected_loan_amount) {
        this.expected_loan_amount = expected_loan_amount;
    }
}
