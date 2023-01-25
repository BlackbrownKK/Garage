CREATE TABLE "user"
(
    user_id integer NOT NULL AUTO_INCREMENT,
    name    text,
    PRIMARY KEY (user_id)
);

CREATE TABLE "car"
(
    car_id        integer NOT NULL AUTO_INCREMENT,
    user_id_ovner integer,
    model         text,
    FOREIGN KEY (user_id_ovner)
        REFERENCES "user" (user_id)
        ON UPDATE NO ACTION
        ON DELETE CASCADE);

