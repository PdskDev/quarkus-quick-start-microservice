drop table if exists etudiants;

create table etudiants
(
    id bigint auto_increment,
    first_name varchar(255),
    last_name varchar(255),
    is_active boolean default false,
    primary key (id)
);

INSERT INTO etudiants (first_name, last_name, is_active) VALUES ('Nadet', 'Dev', 'false');
INSERT INTO etudiants (first_name, last_name, is_active) VALUES ('SO', 'Loved', 'true');
INSERT INTO etudiants (first_name, last_name, is_active) VALUES ('lA', 'Perzu', 'true');
INSERT INTO etudiants (first_name, last_name, is_active) VALUES ('LO', 'Best Mama', 'false');
INSERT INTO etudiants (first_name, last_name, is_active) VALUES ('YN', 'Gmer', 'true');