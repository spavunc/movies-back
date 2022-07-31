DROP TABLE IF EXISTS Movie;

CREATE TABLE Movie(
id long auto_increment primary key,
title varchar(250) not null,
release_date date,
rating NUMERIC(4,2),
revenue NUMERIC(16,2)
);