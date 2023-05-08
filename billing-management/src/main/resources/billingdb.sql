CREATE DATABASE IF NOT EXISTS billing;
USE billing;

CREATE TABLE IF NOT EXISTS patient_billing (
  bill_id int NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  contact varchar(50) NOT NULL,
  appointment_fee float NOT NULL,
  medical_expenses float NOT NULL,
  total_expenses float NOT NULL,
  PRIMARY KEY (bill_id)
);


