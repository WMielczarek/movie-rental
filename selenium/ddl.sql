CREATE TABLE seriale (
id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
tytul VARCHAR(50) NOT NULL,
CONSTRAINT id_pk PRIMARY KEY ( id ) );


CREATE TABLE odcinki (
id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
tytul VARCHAR(50) NOT NULL,
id_serial INTEGER NOT NULL,
CONSTRAINT odcinek_id PRIMARY KEY ( id ),
FOREIGN KEY (id_serial) REFERENCES seriale (id));