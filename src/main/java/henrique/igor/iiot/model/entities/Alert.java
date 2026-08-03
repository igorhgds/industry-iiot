package henrique.igor.iiot.model.entities;

import henrique.igor.iiot.model.enums.AlertStatus;
import henrique.igor.iiot.model.enums.Severity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@Entity
@Table(name = "alerts")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID alertId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Severity severity;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private BigDecimal valueAtTrigger;

    private AlertStatus status;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "acknowledged_by")
    private User acknowledgedBy;

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private LocalDateTime triggeredAt;

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private LocalDateTime resolvedAt;
}
