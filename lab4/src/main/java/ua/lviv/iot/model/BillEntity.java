package ua.lviv.iot.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bill", schema = "animators_orders", catalog = "")
public class BillEntity {
    private Integer id;
    private String client;
    private Timestamp billDatetime;
    private Integer animatorsNumber;
    private Integer perfomanceDuration;
    private String price;
    private String organizer;
    private Integer orderId;

    public BillEntity(String client, Timestamp billDatetime, Integer animatorsNumber, Integer perfomanceDuration, String price, String organizer, Integer orderId) {
        this.client = client;
        this.billDatetime = billDatetime;
        this.animatorsNumber = animatorsNumber;
        this.perfomanceDuration = perfomanceDuration;
        this.price = price;
        this.organizer = organizer;
        this.orderId = orderId;
    }

    public BillEntity() {

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
    @Column(name = "client")
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Basic
    @Column(name = "bill_datetime")
    public Timestamp getBillDatetime() {
        return billDatetime;
    }

    public void setBillDatetime(Timestamp billDatetime) {
        this.billDatetime = billDatetime;
    }

    @Basic
    @Column(name = "animators_number")
    public Integer getAnimatorsNumber() {
        return animatorsNumber;
    }

    public void setAnimatorsNumber(Integer animatorsNumber) {
        this.animatorsNumber = animatorsNumber;
    }

    @Basic
    @Column(name = "perfomance_duration")
    public Integer getPerfomanceDuration() {
        return perfomanceDuration;
    }

    public void setPerfomanceDuration(Integer perfomanceDuration) {
        this.perfomanceDuration = perfomanceDuration;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "organizer")
    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    @Basic
    @Column(name = "order_id")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillEntity that = (BillEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (billDatetime != null ? !billDatetime.equals(that.billDatetime) : that.billDatetime != null) return false;
        if (animatorsNumber != null ? !animatorsNumber.equals(that.animatorsNumber) : that.animatorsNumber != null)
            return false;
        if (perfomanceDuration != null ? !perfomanceDuration.equals(that.perfomanceDuration) : that.perfomanceDuration != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (organizer != null ? !organizer.equals(that.organizer) : that.organizer != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (billDatetime != null ? billDatetime.hashCode() : 0);
        result = 31 * result + (animatorsNumber != null ? animatorsNumber.hashCode() : 0);
        result = 31 * result + (perfomanceDuration != null ? perfomanceDuration.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (organizer != null ? organizer.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BillEntity{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", billDatetime=" + billDatetime +
                ", animatorsNumber=" + animatorsNumber +
                ", perfomanceDuration=" + perfomanceDuration +
                ", price='" + price + '\'' +
                ", organizer='" + organizer + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
