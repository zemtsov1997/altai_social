INSERT IGNORE INTO user_role (id, name_to_system) VALUES (1,'ROLE_GUEST');
INSERT IGNORE INTO user_role (id, name_to_system) VALUES (2,'ROLE_ADMIN');

INSERT IGNORE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (1, 'Гость', 'ru_RU');
INSERT IGNORE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (2, 'Администратор', 'ru_RU');

INSERT IGNORE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (1, 'Guest', 'en');
INSERT IGNORE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (2, 'Admin', 'en');

INSERT IGNORE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (1, 'Предоставляет возможность работы.', 'ru_RU');
INSERT IGNORE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (2, 'Предоставляет возможность администрирования.', 'ru_RU');

INSERT IGNORE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (1, 'Provides the ability to work.', 'en');
INSERT IGNORE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (2, 'Provides the opportunity to work administration.', 'en');

INSERT IGNORE INTO gender (id, name_to_system) VALUES (1, 'MALE');
INSERT IGNORE INTO gender (id, name_to_system) VALUES (2, 'FEMALE');

INSERT IGNORE INTO gender_names_to_view (gender_id, names_to_view, names_to_view_key) VALUES (1, 'мужской', 'ru_RU');
INSERT IGNORE INTO gender_names_to_view (gender_id, names_to_view, names_to_view_key) VALUES (2, 'женский', 'ru_RU');

INSERT IGNORE INTO gender_names_to_view (gender_id, names_to_view, names_to_view_key) VALUES (1, 'male', 'en');
INSERT IGNORE INTO gender_names_to_view (gender_id, names_to_view, names_to_view_key) VALUES (2, 'female', 'en');