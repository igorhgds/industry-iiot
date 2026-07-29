CREATE TABLE IF NOT EXISTS alerts(
    alert_id            UUID            PRIMARY KEY,
    equipment_id        UUID,
    sensor_id           UUID,
    severity            VARCHAR(50)     NOT NULL,
    message             TEXT            NOT NULL,
    value_at_trigger    FLOAT           NOT NULL,
    status              VARCHAR(50),
    acknowledged_by     UUID,
    triggered_at        TIMESTAMP,
    resolved_at         TIMESTAMP,

    CONSTRAINT fk_alerts_equipment FOREIGN KEY (equipment_id) REFERENCES equipments (equipment_id),
    CONSTRAINT fk_alerts_sensor  FOREIGN KEY (sensor_id) REFERENCES sensors (sensor_id),
    CONSTRAINT fk_alerts_user   FOREIGN KEY (acknowledged_by) REFERENCES users (user_id)
);