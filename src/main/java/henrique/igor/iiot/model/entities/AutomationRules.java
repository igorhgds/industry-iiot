package henrique.igor.iiot.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@Entity
@Table(name = "automation_rules")
public class AutomationRules {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID automationId;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "input_sensor_id")
    private Sensor inputSensor;

    @Column(nullable = false)
    private String condition;

    @Column(nullable = false)
    private BigDecimal thresholdValue;

    @Column(nullable = false)
    private String actionType;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "target_sensor_id")
    private Sensor targetSensor;

    private boolean isActive;
}