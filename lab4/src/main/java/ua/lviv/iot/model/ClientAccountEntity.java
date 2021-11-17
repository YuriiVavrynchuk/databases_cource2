package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "client_account", schema = "animators_orders", catalog = "")
public class ClientAccountEntity {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String gender;
    private String phone;
    private String email;
    private Integer debt;
    private Integer bonuses;
    private Byte blacklistPresence;
    private Integer animatorsAgencyBusinessId;

    public ClientAccountEntity(String name, String surname, Integer age, String gender, String phone, String email,
                               Integer debt, Integer bonuses, Byte blacklistPresence, Integer animatorsAgencyBusinessId) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.debt = debt;
        this.bonuses = bonuses;
        this.blacklistPresence = blacklistPresence;
        this.animatorsAgencyBusinessId = animatorsAgencyBusinessId;
    }

    public ClientAccountEntity() {

    }

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

    @Basic
    @Column(name = "debt")
    public Integer getDebt() {
        return debt;
    }

    public void setDebt(Integer debt) {
        this.debt = debt;
    }

    @Basic
    @Column(name = "bonuses")
    public Integer getBonuses() {
        return bonuses;
    }

    public void setBonuses(Integer bonuses) {
        this.bonuses = bonuses;
    }

    @Basic
    @Column(name = "blacklist_presence")
    public Byte getBlacklistPresence() {
        return blacklistPresence;
    }

    public void setBlacklistPresence(Byte blacklistPresence) {
        this.blacklistPresence = blacklistPresence;
    }

    @Basic
    @Column(name = "animators_agency_business_id")
    public Integer getAnimatorsAgencyBusinessId() {
        return animatorsAgencyBusinessId;
    }

    public void setAnimatorsAgencyBusinessId(Integer animatorsAgencyBusinessId) {
        this.animatorsAgencyBusinessId = animatorsAgencyBusinessId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientAccountEntity that = (ClientAccountEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (debt != null ? !debt.equals(that.debt) : that.debt != null) return false;
        if (bonuses != null ? !bonuses.equals(that.bonuses) : that.bonuses != null) return false;
        if (blacklistPresence != null ? !blacklistPresence.equals(that.blacklistPresence) : that.blacklistPresence != null)
            return false;
        if (animatorsAgencyBusinessId != null ? !animatorsAgencyBusinessId.equals(that.animatorsAgencyBusinessId) :
                that.animatorsAgencyBusinessId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (debt != null ? debt.hashCode() : 0);
        result = 31 * result + (bonuses != null ? bonuses.hashCode() : 0);
        result = 31 * result + (blacklistPresence != null ? blacklistPresence.hashCode() : 0);
        result = 31 * result + (animatorsAgencyBusinessId != null ? animatorsAgencyBusinessId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientAccountEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", debt=" + debt +
                ", bonuses=" + bonuses +
                ", blacklistPresence=" + blacklistPresence +
                ", animatorsAgencyByAnimatorsAgencyBusinessId=" + animatorsAgencyBusinessId +
                '}';
    }
}
