package henrique.igor.iiot.model.entities;

import henrique.igor.iiot.model.enums.SensorStatus;
import henrique.igor.iiot.model.enums.SensorType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "sensors")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID sensorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @Column(nullable = false, unique = true)
    private String sensorCode;

    @Enumerated(EnumType.STRING)
    private SensorType type;

    private String unitOfMeasure;

    private BigDecimal minThreshold;

    private BigDecimal maxThreshold;

    @Enumerated(EnumType.STRING)
    private SensorStatus status;

    private String mqttTopic;

    @CreatedDate
    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
}
