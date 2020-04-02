-- Admin user = school

-- Create nessecary users
CREATE USER 'bank_prod'@'%' IDENTIFIED BY '';
CREATE USER 'bank_tester'@'%' IDENTIFIED BY '';

-- Provide necessary grants for users
GRANT SELECT, UPDATE, INSERT ON banking.* TO 'bank_prod'@'%';
GRANT SELECT ON banking.* TO 'bank_tester'@'%';