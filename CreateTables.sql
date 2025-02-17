

DROP DATABASE IF EXISTS `ca4_database`;
CREATE DATABASE `ca4_database`;
USE `ca4_database`;
DROP TABLE IF EXISTS expenses;
CREATE TABLE expenses(expenseID int NOT NULL AUTO_INCREMENT,
             title VARCHAR(20),
             category VARCHAR(50),
             amount double(10,2),
             dateIncurred date,
			 PRIMARY KEY (expenseID));
CREATE TABLE incomes(incomeID int NOT NULL AUTO_INCREMENT,
             title VARCHAR(20),
             amount double(10,2),
             dateEarned date,
			 PRIMARY KEY (incomeID));



INSERT INTO expenses VALUES (1, 'weekly shop', 'groceries', '47.50','2025-01-25' );
INSERT INTO expenses VALUES (2, 'gym membership', 'fitness', '30.10','2025-02-15' );

INSERT INTO incomes VALUES (1, 'babysitting', '60.05','2025-01-16' );
INSERT INTO incomes VALUES (2, 'bar work', '100.50','2025-01-12' );