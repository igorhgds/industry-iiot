CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS sectors(
    sector_id       UUID            PRIMARY KEY,
    name            VARCHAR(50)     NOT NULL,
    description     TEXT,
    created_at      TIMESTAMP       NOT NULL
);