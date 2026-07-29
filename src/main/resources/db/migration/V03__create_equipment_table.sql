CREATE TABLE IF NOT EXISTS equipments(
    equipment_id        UUID            PRIMARY KEY,
    equip_code          VARCHAR(15)     NOT NULL UNIQUE,
    name                VARCHAR(50)     NOT NULL,
    type                VARCHAR(50)     NOT NULL,
    status              VARCHAR(50),
    sector_id           UUID,
    created_at          TIMESTAMP       NOT NULL,
    update_at           TIMESTAMP,

    CONSTRAINT fk_equipments_sector FOREIGN KEY (sector_id) REFERENCES sectors (sector_id)
);