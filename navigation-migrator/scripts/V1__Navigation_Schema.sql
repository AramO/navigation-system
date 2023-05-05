CREATE TABLE base_station
(
    id                         UUID DEFAULT GEN_RANDOM_UUID() NOT NULL PRIMARY KEY,
    station_name               VARCHAR(255),
    crd_x                      FLOAT(8),
    crd_y                      FLOAT(8),
    detection_radius_in_meters FLOAT(8),
    created_at                 DATE DEFAULT NOW(),
    updated_at                 DATE
);

CREATE TABLE mobile_station
(
    id                         UUID DEFAULT GEN_RANDOM_UUID() NOT NULL PRIMARY KEY,
    station_name               VARCHAR(255),
    crd_x                      FLOAT(8),
    crd_y                      FLOAT(8),
    created_at                 DATE DEFAULT NOW(),
    updated_at                 DATE
);

CREATE TABLE report
(
    id                         UUID DEFAULT GEN_RANDOM_UUID() NOT NULL PRIMARY KEY,
    base_station_id            UUID NOT NULL REFERENCES base_station(id),
    mobile_station_id          UUID NOT NULL REFERENCES mobile_station(id),
    distance                   FLOAT(8),
    created_at                 DATE
);


