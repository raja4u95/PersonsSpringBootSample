DROP TABLE IF EXISTS TBL_PERSONS;
 
CREATE TABLE TBL_PERSONS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);