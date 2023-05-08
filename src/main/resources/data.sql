INSERT INTO `role`  (`id`, `description`, `name`) VALUES (1, 'ROLE_ADMIN', 'ROLE_ADMIN');
INSERT INTO `role`  (`id`, `description`, `name`) VALUES (2, 'ROLE_USER', 'ROLE_USER');

INSERT INTO `user`  (birthdate, dni_number, email, name, password, phone, surname, id_role)
VALUES
    (
        '1997-07-01',
        '123',
        'camilo@gmail.com',
        'camilo',
        '$2a$10$wYUCpxXCCjCLgrYXAl4oTeS2aK6zFh4T24rAtqDjSupcdEoA2h/my',
        '1234567890',
        'Surname',
        1
    );
