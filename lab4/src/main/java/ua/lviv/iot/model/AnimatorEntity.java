package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "animator", schema = "animators_orders", catalog = "")
public class AnimatorEntity {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String gender;
    private String character;
    private Integer salary;
    private Integer experience;
    private String phone;
    private String email;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "character")
    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    @Basic
    @Column(name = "salary")
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "experience")
    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimatorEntity that = (AnimatorEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (character != null ? !character.equals(that.character) : that.character != null) return false;
        if (salary != null ? !salary.equals(that.salary) : that.salary != null) return false;
        if (experience != null ? !experience.equals(that.experience) : that.experience != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (character != null ? character.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (experience != null ? experience.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AnimatorEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", character='" + character + '\'' +
                ", salary=" + salary +
                ", experience=" + experience +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public AnimatorEntity() {
    }

    public AnimatorEntity(Integer id, String name, String surname, Integer age, String gender, String character, Integer salary, Integer experience, String phone, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.character = character;
        this.salary = salary;
        this.experience = experience;
        this.phone = phone;
        this.email = email;
    }

    public AnimatorEntity(String name, String surname, Integer age, String gender, String character, Integer salary,
                          Integer experience, String phone, String email) {
        this(null, name, surname, age, gender, character, salary, experience, phone, email);
    }
}
