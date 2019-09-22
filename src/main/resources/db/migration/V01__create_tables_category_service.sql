CREATE TABLE category(
category_id BIGSERIAL,
category_name VARCHAR(50) NOT NULL,
image_url VARCHAR(500),
PRIMARY KEY(category_id)
);

CREATE TABLE service(
service_id BIGSERIAL,
service_name VARCHAR(100),
service_category BIGINT,
PRIMARY KEY(service_id),
CONSTRAINT fk_service_category
  FOREIGN KEY(service_category) REFERENCES category(category_id)
);