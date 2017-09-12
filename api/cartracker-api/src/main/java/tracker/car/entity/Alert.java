package tracker.car.entity;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@NamedQueries({
        @NamedQuery(name="Alert.findAllHighAlert",
                query="SELECT a FROM Alert a WHERE a.timestamp> :pTS and a.priority='HIGH'"),
        @NamedQuery(name="Alert.findByVin",
                query = "SELECT a FROM Alert a WHERE a.vin=:pVin")
})
public class Alert {
    @Id
    @Column(columnDefinition = "varchar(36)")
    private String id;
    private String vin;
    private Timestamp timestamp;
    private String priority;
    private String reason;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    @Override
    public String toString() {
        return "Alert{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", timestamp=" + timestamp +
                ", priority='" + priority + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
