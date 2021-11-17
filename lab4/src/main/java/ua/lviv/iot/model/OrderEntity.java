package ua.lviv.iot.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "order", schema = "animators_orders", catalog = "")
public class OrderEntity {
    private Integer id;
    private Timestamp orderDatetime;
    private String client;
    private Integer price;
    private Integer amountOfAnimators;
    private String subject;
    private Integer eventId;
    private Integer clientAccountId;
    private Integer animatorsAgencyBusinessId;

    public OrderEntity(Timestamp orderDatetime, String client, Integer price, Integer amountOfAnimators, String subject,
                       Integer eventId, Integer clientAccountId, Integer animatorsAgencyBusinessId) {
        this.orderDatetime = orderDatetime;
        this.client = client;
        this.price = price;
        this.amountOfAnimators = amountOfAnimators;
        this.subject = subject;
        this.eventId = eventId;
        this.clientAccountId = clientAccountId;
        this.animatorsAgencyBusinessId = animatorsAgencyBusinessId;
    }

    public OrderEntity() {

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
    @Column(name = "order_datetime")
    public Timestamp getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(Timestamp orderDatetime) {
        this.orderDatetime = orderDatetime;
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
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "amount_of_animators")
    public Integer getAmountOfAnimators() {
        return amountOfAnimators;
    }

    public void setAmountOfAnimators(Integer amountOfAnimators) {
        this.amountOfAnimators = amountOfAnimators;
    }

    @Basic
    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "event_id")
    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "client_account_id")
    public Integer getClientAccountId() {
        return clientAccountId;
    }

    public void setClientAccountId(Integer clientAccountId) {
        this.clientAccountId = clientAccountId;
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

        OrderEntity that = (OrderEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (orderDatetime != null ? !orderDatetime.equals(that.orderDatetime) : that.orderDatetime != null)
            return false;
        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (amountOfAnimators != null ? !amountOfAnimators.equals(that.amountOfAnimators) : that.amountOfAnimators != null)
            return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (eventId != null ? !eventId.equals(that.eventId) : that.eventId != null) return false;
        if (clientAccountId != null ? !clientAccountId.equals(that.clientAccountId) : that.clientAccountId != null) return false;
        if (animatorsAgencyBusinessId != null ? !animatorsAgencyBusinessId.equals(that.animatorsAgencyBusinessId) : that.animatorsAgencyBusinessId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (orderDatetime != null ? orderDatetime.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (amountOfAnimators != null ? amountOfAnimators.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (eventId != null ? eventId.hashCode() : 0);
        result = 31 * result + (clientAccountId != null ? clientAccountId.hashCode() : 0);
        result = 31 * result + (animatorsAgencyBusinessId != null ? animatorsAgencyBusinessId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", orderDatetime=" + orderDatetime +
                ", client='" + client + '\'' +
                ", price=" + price +
                ", amountOfAnimators=" + amountOfAnimators +
                ", subject='" + subject + '\'' +
                ", eventId=" + eventId +
                ", billById=" + clientAccountId +
                ", animatorsAgencyByAnimatorsAgencyBusinessId=" + animatorsAgencyBusinessId +
                '}';
    }
}
