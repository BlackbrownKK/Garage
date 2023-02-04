CREATE TABLE "client"
(
    client_id         integer NOT NULL AUTO_INCREMENT,
    enable            boolean NOT NULL,
    client_first_name text    NOT NULL,
    client_last_name  text    NOT NULL,
    client_email      text    NOT NULL,
    client_password   text    NOT NULL,
    PRIMARY KEY (client_id)
);

CREATE TABLE "autority"
(
    id integer NOT NULL AUTO_INCREMENT,
    client_id  integer NOT NULL,
    roles text NOT NULL,
    FOREIGN KEY (client_id)
        REFERENCES "client" (client_id)
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

INSERT INTO "client" VALUES (DEFAULT,true, 'client_first_name', 'client_last_name', 'client_email@ukr.net', 'password');
INSERT INTO "client" VALUES (DEFAULT,true, 'user2', 'userUser2', 'client_email2@ukr.net', 'password2');
INSERT INTO "autority" VALUES (DEFAULT, 1, 'USER');
INSERT INTO "autority" VALUES (DEFAULT, 2, 'ADMIN');