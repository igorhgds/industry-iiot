CREATE TABLE IF NOT EXISTS work_orders(
    order_id       UUID            PRIMARY KEY,
    alert_id        UUID,
    equipment_id    UUID,
    assigned_to     UUID,
    title           VARCHAR(50)     NOT NULL,
    description     TEXT,
    priority        VARCHAR(50),
    status          VARCHAR(50),
    created_at      TIMESTAMP       NOT NULL,
    closes_at       TIMESTAMP,

    CONSTRAINT fk_orders_alert FOREIGN KEY (alert_id) REFERENCES alerts (alert_id),
    CONSTRAINT fk_orders_equipment FOREIGN KEY (equipment_id) REFERENCES equipments (equipment_id),
    CONSTRAINT fk_orders_user   FOREIGN KEY (assigned_to) REFERENCES users (user_id)
);