DROP TABLE IF EXISTS calc_pattern;

CREATE TABLE calc_pattern(
number INT NOT NULL AUTO_INCREMENT,
date_id VARCHAR(10),
date_name VARCHAR(20),
calc_y INT DEFAULT 0,
calc_m INT DEFAULT 0,
calc_d INT DEFAULT 0,
PRIMARY KEY(number)
);