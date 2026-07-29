CREATE TABLE IF NOT EXISTS telemetry_data(
    telemetry_id        UUID        PRIMARY KEY,
    sensor_id           UUID,
    timestamp           TIMESTAMP   NOT NULL,
    value               FLOAT       NOT NULL,
    raw_payload         TEXT,

    CONSTRAINT fk_telemetry_sensor FOREIGN KEY (sensor_id) REFERENCES sensors (sensor_id)
);