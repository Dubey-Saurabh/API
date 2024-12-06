package APISessions.Session4;

import APISessions.Session3.EmployeePOJO;

import java.util.List;

public class NestedJSONPojoClass {

    private String companyName;
    private String Street;
    private String City;
    private String state;
    private String pinCode;
    private List<String > bankAccount;

    private List<EmployeePOJO> employeeList;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public List<String> getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(List<String> bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<EmployeePOJO> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<EmployeePOJO> employeeList) {
        this.employeeList = employeeList;
    }



}
