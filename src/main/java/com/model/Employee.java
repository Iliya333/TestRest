package com.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column( name = "birthday")
    private LocalDate birthday;

    @Column(name = "salary")
    private Long salary;

    @Column(name = "department_id" , insertable = false, updatable = false)
    private long departmentId;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "departmentId"))
    private Department department;

    public Employee(){
    }

    public Employee(Long departmentId, String name, String surname,
                    String patronymic, LocalDate birthday, Long salary) {
        this.departmentId = departmentId;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", salary=" + salary +
                ", departmentId=" + departmentId +
                ", departments=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return departmentId == employee.departmentId && Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(patronymic, employee.patronymic) && Objects.equals(birthday, employee.birthday) && Objects.equals(salary, employee.salary) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, birthday, salary, departmentId, department);
    }
}
