CREATE TABLE public.client
(

    client_id         integer NOT NULL AUTO_INCREMENT,
    enable            boolean NOT NULL,
    client_first_name text    NOT NULL,
    client_last_name  text    NOT NULL,
    client_email      text    NOT NULL,
    client_password   text    NOT NULL,
    PRIMARY KEY (client_id)
);

CREATE TABLE public.autority
(
    id integer NOT NULL AUTO_INCREMENT,
    client_id  integer NOT NULL,
    role text NOT NULL,
    FOREIGN KEY (client_id)
        REFERENCES public.client (client_id)
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

INSERT INTO public.client VALUES (DEFAULT,true, 'client_first_name', 'client_last_name', 'client1@ukr.net', '$2a$12$Z7rlaciAT0joYQ7mUIYTFezVEZ8KAuvoPmkEBklO7mg55.5.DSvg2');
INSERT INTO public.client VALUES (DEFAULT,true, 'user2', 'userUser2', 'client2@ukr.net', '$2a$12$Z7rlaciAT0joYQ7mUIYTFezVEZ8KAuvoPmkEBklO7mg55.5.DSvg2');
INSERT INTO public.autority VALUES (DEFAULT, 1, 'USER');
INSERT INTO public.autority VALUES (DEFAULT, 2, 'ADMIN');