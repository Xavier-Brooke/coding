-- CREATE DATABASE IF NOT EXISTS insta ;

-- USE insta ;

-- CREATE TABLE users(
--     user_id VARCHAR(50) PRIMARY KEY,
--     name VARCHAR(50) NOT NULL,
--     age INT NOT NULL,
--     email VARCHAR(50) NOT NULL,
--     city VARCHAR(50) NOT NULL,
--     country VARCHAR(50) NOT NULL,
--     CONSTRAINT check_age CHECK(age >= 15 AND age <= 60)
-- ) ;

ALTER TABLE users
ADD COLUMN password VARCHAR(50) NOT NULL ;

-- CREATE TABLE posts(
--     post_id VARCHAR(50) PRIMARY KEY,
--     msg VARCHAR(1000) NOT NULL,
--     user_id VARCHAR(50),
--     FOREIGN KEY (user_id) REFERENCES users(user_id)
-- ) ;