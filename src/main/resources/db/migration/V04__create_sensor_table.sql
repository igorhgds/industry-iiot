CREATE TABLE IF NOT EXISTS sensors(
    sensor_id           UUID            PRIMARY KEY,
    equipment_id        UUID,
    sensor_code         VARCHAR(50)     NOT NULL UNIQUE,
    type                VARCHAR(50)     NOT NULL,
    unit_of_measure     VARCHAR(10),
    min_threshold       FLOAT,
    max_threshold       FLOAT,
    status              VARCHAR(50),
    mqtt_topic          VARCHAR(255),
    created_at          TIMESTAMP       NOT NULL,

    CONSTRAINT fk_sensors_equipments FOREIGN KEY (equipment_id) REFERENCES equipments (equipment_id)
);