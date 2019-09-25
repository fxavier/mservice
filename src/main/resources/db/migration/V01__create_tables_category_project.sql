CREATE TABLE category(
category_id BIGSERIAL,
category_name VARCHAR(50) NOT NULL,
image_url VARCHAR(500),
PRIMARY KEY(category_id)
);

CREATE TABLE user_account(
user_id BIGSERIAL,
firstName VARCHAR(50) NOT NULL,
lastName VARCHAR(50) NOT NULL,
email VARCHAR(500) NOT NULL,
password VARCHAR(500) NOT NULL,
PRIMARY KEY(user_id)
);

CREATE TABLE project(
project_id BIGSERIAL,
project_name VARCHAR(100) NOT NULL,
description TEXT,
category_id BIGINT NOT NULL,
initial_price NUMERIC(10, 2),
final_price NUMERIC(10, 2),
posted_date DATE NOT NULL,
posted_by BIGINT NOT NULL,
PRIMARY KEY(project_id),
CONSTRAINT fk_project_category
  FOREIGN KEY(category_id) REFERENCES category(category_id),
CONSTRAINT fk_user_project
  FOREIGN KEY(posted_by) REFERENCES user_account(user_id)
);