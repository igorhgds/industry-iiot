CREATE TABLE IF NOT EXISTS users(
    user_id         UUID            PRIMARY KEY,
    name            VARCHAR(50)     NOT NULL,
    email           VARCHAR(50)     NOT NULL UNIQUE,
    password        VARCHAR(255)    NOT NULL,
    role            VARCHAR(30),
    sector_id       UUID,
    created_at      TIMESTAMP       NOT NULL,

    CONSTRAINT fk_users_sector FOREIGN KEY (sector_id) REFERENCES sectors (sector_id)
);

