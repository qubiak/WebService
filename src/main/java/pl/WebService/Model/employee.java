package pl.WebService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class employee {

    @GeneratedValue
    @Id
    private Long ID;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Integer salary;

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSalary(Integer salary) {
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

    public Integer getSalary() {
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

    public employee withID(final Long ID) {
        this.ID = ID;
        return this;
    }

    public employee withName(final String name) {
        this.name = name;
        return this;
    }

    public employee withSurname(final String surname) {
        this.surname = surname;
        return this;
    }

    public employee withSalary(final Integer salary) {
        this.salary = salary;
        return this;
    }
}
