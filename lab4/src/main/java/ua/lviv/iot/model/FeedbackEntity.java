package ua.lviv.iot.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "feedback", schema = "animators_orders", catalog = "")
public class FeedbackEntity {
    private String client;
    private Date date;
    private String text;
    private Integer rate;
    private Integer eventId;
    private Integer clientAccountId;

    public FeedbackEntity(String client, Date date, String text, Integer rate, Integer eventId, Integer clientAccountId) {
        this.client = client;
        this.date = date;
        this.text = text;
        this.rate = rate;
        this.eventId = eventId;
        this.clientAccountId = clientAccountId;
    }

    public FeedbackEntity() {

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
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "rate")
    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackEntity that = (FeedbackEntity) o;

        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;
        if (eventId != null ? !eventId.equals(that.eventId) : that.eventId != null) return false;
        if (clientAccountId != null ? !clientAccountId.equals(that.clientAccountId) : that.clientAccountId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = client != null ? client.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (eventId != null ? eventId.hashCode() : 0);
        result = 31 * result + (clientAccountId != null ? clientAccountId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FeedbackEntity{" +
                "client='" + client + '\'' +
                ", date=" + date +
                ", text='" + text + '\'' +
                ", rate=" + rate +
                ", eventId=" + eventId +
                ", clientAccountByClientAccountId=" + clientAccountId +
                '}';
    }
}
