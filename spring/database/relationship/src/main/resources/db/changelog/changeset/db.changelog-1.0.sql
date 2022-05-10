-- liquibase formatted sql

-- changeset ashabelskii:1
CREATE TABLE IF NOT EXISTS detail
(
    id     BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    series VARCHAR(255),
    number VARCHAR(255),
    CONSTRAINT pk_detail PRIMARY KEY (id)
);

-- changeset ashabelskii:2
CREATE TABLE IF NOT EXISTS person
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name      VARCHAR(255),
    detail_id BIGINT REFERENCES detail (id),
    CONSTRAINT pk_person PRIMARY KEY (id)
);