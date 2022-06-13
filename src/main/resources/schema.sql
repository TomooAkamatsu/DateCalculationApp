DROP TABLE IF EXISTS calc_pattern, users;

CREATE TABLE calc_pattern(
id INT NOT NULL AUTO_INCREMENT,
date_id VARCHAR(10),
date_name VARCHAR(20),
calc_y INT DEFAULT 0,
calc_m INT DEFAULT 0,
calc_d INT DEFAULT 0,
PRIMARY KEY(id)
);

CREATE TABLE users(
username VARCHAR(50) NOT NULL PRIMARY KEY,
password VARCHAR(500) NOT NULL,
authority enum('ADMIN', 'USER') NOT NULL
);
