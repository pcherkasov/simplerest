package com.godel.java.task.dto;

/**
 * Class Employee.
 * create 15.04.2019.
 *
 * @author Pavel Cherkasov
 */


public class Employee {

    private Integer employeeId;
    private String firstName;
    private Gender gender;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setGender(String genderString) {
        if (Gender.MALE.toString().equalsIgnoreCase(genderString)) {
            this.gender = Gender.MALE;
        } else {
            this.gender = Gender.FEMALE;
        }
    }
}
