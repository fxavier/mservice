CREATE TABLE language(
id BIGSERIAL,
name VARCHAR(50) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE skill(
id BIGSERIAL,
name VARCHAR(50) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE freelancer(
freelancer_id BIGSERIAL,
freelancer_type VARCHAR(50) NOT NULL,
job_title VARCHAR(100) NOT NULL,
phone VARCHAR(50),
profile_pictura VARCHAR(500),
about_you TEXT NOT NULL,
skill_id BIGINT NOT NULL,
user_id BIGINT NOT NULL,
PRIMARY KEY(freelancer_id),
CONSTRAINT fk_freelancer_user
  FOREIGN KEY(user_id) REFERENCES user_account(user_id),
CONSTRAINT fk_freelancer_skill
  FOREIGN KEY(skill_id) REFERENCES skill(id)
);