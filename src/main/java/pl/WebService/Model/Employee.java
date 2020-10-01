package pl.WebService.Model;

import javax.persistence.*;

@Entity
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long ID;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Long salary;

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "employee{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Employee withID(final Long ID) {
        this.ID = ID;
        return this;
    }

    public Employee withName(final String name) {
        this.name = name;
        return this;
    }

    public Employee withSurname(final String surname) {
        this.surname = surname;
        return this;
    }

    public Employee withSalary(final Long salary) {
        this.salary = salary;
        return this;
    }
}