DROP TABLE IF EXISTS friendship;
DROP TABLE IF EXISTS victimship;
DROP TABLE IF EXISTS heroes;


CREATE TABLE heroes(

    id serial primary key,
    name VARCHAR(30) not null
);

CREATE TABLE friendship(
    id serial primary key,
    hero1_id integer not null references heroes(id) on delete cascade,
    hero2_id integer not null references heroes(id) on delete cascade
);

CREATE TABLE victimship(
    id serial primary key,
    predator_id integer not null references heroes(id) on delete cascade,
    victim_id integer not null references heroes(id) on delete cascade
);



