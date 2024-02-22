CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       user_name VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       user_role VARCHAR(50) NOT NULL
);