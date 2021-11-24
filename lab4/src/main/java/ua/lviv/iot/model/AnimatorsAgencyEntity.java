package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "animators_agency", schema = "animators_orders", catalog = "")
public class AnimatorsAgencyEntity {
    private Integer businessId;
    private String name;
    private String address;
    private Integer workersNumber;
    private String license;
    private String bankAccount;
    private Integer registrationCountry;

    public AnimatorsAgencyEntity() {
    }

    public AnimatorsAgencyEntity(String name, String address, Integer workersNumber, String license, String bankAccount, Integer registrationCountryId) {
        this.name = name;
        this.address = address;
        this.workersNumber = workersNumber;
        this.license = license;
        this.bankAccount = bankAccount;
        this.registrationCountry = registrationCountryId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "business_id")
    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "workers_number")
    public Integer getWorkersNumber() {
        return workersNumber;
    }

    public void setWorkersNumber(Integer workersNumber) {
        this.workersNumber = workersNumber;
    }

    @Basic
    @Column(name = "license")
    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Basic
    @Column(name = "bank_account")
    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Basic
    @Column(name = "registration_country")
    public Integer getRegistrationCountry() {
        return registrationCountry;
    }

    public void setRegistrationCountry(Integer registrationCountry) {
        this.registrationCountry = registrationCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimatorsAgencyEntity that = (AnimatorsAgencyEntity) o;

        if (businessId != null ? !businessId.equals(that.businessId) : that.businessId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (workersNumber != null ? !workersNumber.equals(that.workersNumber) : that.workersNumber != null)
            return false;
        if (license != null ? !license.equals(that.license) : that.license != null) return false;
        if (bankAccount != null ? !bankAccount.equals(that.bankAccount) : that.bankAccount != null) return false;
        if (registrationCountry != null ? !registrationCountry.equals(that.registrationCountry) : that.registrationCountry != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = businessId != null ? businessId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (workersNumber != null ? workersNumber.hashCode() : 0);
        result = 31 * result + (license != null ? license.hashCode() : 0);
        result = 31 * result + (bankAccount != null ? bankAccount.hashCode() : 0);
        result = 31 * result + (registrationCountry != null ? registrationCountry.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AnimatorsAgencyEntity{" +
                "businessId=" + businessId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", workersNumber=" + workersNumber +
                ", license='" + license + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", countryByRegistrationCountry=" + registrationCountry +
                '}';
    }
}
