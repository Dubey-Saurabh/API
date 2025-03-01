package APISessions.Session3;

public class EmployeePOJO {

    private String firstname;
    private String lastname;
    private String gender;
    private int age;
    private double salary;
    private AddressPOJO address;

    public AddressPOJO getAddress() {
        return address;
    }

    public void setAddress(AddressPOJO address) {
        this.address = address;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
