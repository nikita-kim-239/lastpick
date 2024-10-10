DROP TABLE IF EXISTS counterpicks;
DROP TABLE IF EXISTS combos;
DROP TABLE IF EXISTS heroes;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;


CREATE SEQUENCE global_seq START WITH 1;


CREATE TABLE heroes
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name VARCHAR(30) not null unique
);

CREATE TABLE combos
(
    id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    hero1_id integer not null references heroes (id) on delete cascade,
    hero2_id integer not null references heroes (id) on delete cascade
);

CREATE TABLE counterpicks
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    predator_id integer not null references heroes (id) on delete cascade,
    victim_id   integer not null references heroes (id) on delete cascade
);

CREATE TABLE users
(
    id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    username varchar not null,
    password varchar not null
);




