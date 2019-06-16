CREATE TABLE IF NOT EXISTS Weight (
    Location_id0 BIGINT UNSIGNED NOT NULL,
    Location_id1 BIGINT UNSIGNED NOT NULL,
    direction0  BIGINT UNSIGNED NOT NULL,
    direction1  BIGINT UNSIGNED NOT NULL,
    weight DOUBLE NOT NUll
);
CREATE PRIMARY KEY on Location(Location_id0, Location_id1);
