package com.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "employees")
public class Employees {

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

    @Column(name = "departments_id" , insertable = false, updatable = false)
    private long departmentId;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "departmentId"))
    private Departments departments;

    public Employees(){
    }

    public Employees(Long departmentId, String name, String surname,
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
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", salary=" + salary +
                ", departmentId=" + departmentId +
                ", departments=" + departments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return departmentId == employees.departmentId && Objects.equals(id, employees.id) && Objects.equals(name, employees.name) && Objects.equals(surname, employees.surname) && Objects.equals(patronymic, employees.patronymic) && Objects.equals(birthday, employees.birthday) && Objects.equals(salary, employees.salary) && Objects.equals(departments, employees.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, birthday, salary, departmentId, departments);
    }
}
