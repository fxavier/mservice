CREATE TABLE category(
category_id BIGSERIAL,
category_name VARCHAR(50) NOT NULL,
image_url VARCHAR(500),
PRIMARY KEY(category_id)
);

CREATE TABLE service(
service_id BIGSERIAL,
service_name VARCHAR(100),
category_id BIGINT,
PRIMARY KEY(service_id),
CONSTRAINT fk_service_category
  FOREIGN KEY(category_id) REFERENCES category(category_id)
);