INSERT INTO `role`  (`id`, `description`, `name`) VALUES (1, 'ROLE_ADMIN', 'ROLE_ADMIN');
INSERT INTO `role`  (`id`, `description`, `name`) VALUES (2, 'ROLE_OWNER', 'ROLE_OWNER');
INSERT INTO `role`  (`id`, `description`, `name`) VALUES (3, 'ROLE_EMPLOYER', 'ROLE_EMPLOYER');
INSERT INTO `role`  (`id`, `description`, `name`) VALUES (4, 'ROLE_CUSTOMER', 'ROLE_CUSTOMER');

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
