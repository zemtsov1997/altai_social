MERGE INTO user_role (id, name_to_system) VALUES (1,'ROLE_EMPLOYEE');
MERGE INTO user_role (id, name_to_system) VALUES (2,'ROLE_ADMIN_EMPLOYEE');
MERGE INTO user_role (id, name_to_system) VALUES (3,'ROLE_COMPANY');
MERGE INTO user_role (id, name_to_system) VALUES (4,'ROLE_ADMIN_COMPANY');
MERGE INTO user_role (id, name_to_system) VALUES (5,'ROLE_AUTHOR_ARTICLE');
MERGE INTO user_role (id, name_to_system) VALUES (6,'ROLE_ADMIN_ARTICLE');
MERGE INTO user_role (id, name_to_system) VALUES (7,'ROLE_CREATER');
MERGE INTO user_role (id, name_to_system) VALUES (8,'ROLE_AUTHOR_NEWS');
MERGE INTO user_role (id, name_to_system) VALUES (9,'ROLE_ADMIN_NEWS');

MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (1, 'Соискатель', 'ru_RU');
MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (2, 'Администратор соискателей', 'ru_RU');
MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (3, 'Работодатель', 'ru_RU');
MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (4, 'Администратор работодателей', 'ru_RU');
MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (5, 'Автор статей', 'ru_RU');
MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (6, 'Администратор статей', 'ru_RU');
MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (7, 'Создатель', 'ru_RU');
MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (8, 'Автор новостей', 'ru_RU');
MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (9, 'Администратор новостей', 'ru_RU');

MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (1, 'Employee', 'en');
MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (2, 'Admin employers', 'en');
MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (3, 'Company', 'en');
MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (4, 'Admin Companies', 'en');
MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (5, 'Author article', 'en');
MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (6, 'Admin article', 'en');
MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (7, 'Creater', 'en');
MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (8, 'Author news', 'en');
MERGE INTO user_role_names_to_view (user_role_id, names_to_view, names_to_view_key) VALUES (9, 'Admin news', 'en');

MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (1, 'Предоставляет возможность работы с резюме.', 'ru_RU');
MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (2, 'Предоставляет возможность работы с компанией и вакансиями.', 'ru_RU');
MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (3, 'Поведение пока не определено.', 'ru_RU');
MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (4, 'Поведение пока не определено.', 'ru_RU');
MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (5, 'Поведение пока не определено.', 'ru_RU');
MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (6, 'Поведение пока не определено.', 'ru_RU');
MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (7, 'Поведение пока не определено.', 'ru_RU');
MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (8, 'Поведение пока не определено.', 'ru_RU');
MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (9, 'Поведение пока не определено.', 'ru_RU');

MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (1, 'Provides the ability to work with resume.', 'en');
MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (2, 'Provides the opportunity to work with the company and vacancies.', 'en');
MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (3, 'Undefined behavior.', 'en');
MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (4, 'Undefined behavior.', 'en');
MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (5, 'Undefined behavior.', 'en');
MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (6, 'Undefined behavior.', 'en');
MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (7, 'Undefined behavior.', 'en');
MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (8, 'Undefined behavior.', 'en');
MERGE INTO user_role_names_to_description (user_role_id, names_to_description, names_to_description_key) VALUES (9, 'Undefined behavior.', 'en');

MERGE INTO gender (id, name_to_system) VALUES (1, 'MALE');
MERGE INTO gender (id, name_to_system) VALUES (2, 'FEMALE');

MERGE INTO gender_names_to_view (gender_id, names_to_view, names_to_view_key) VALUES (1, 'мужской', 'ru_RU');
MERGE INTO gender_names_to_view (gender_id, names_to_view, names_to_view_key) VALUES (2, 'женский', 'ru_RU');

MERGE INTO gender_names_to_view (gender_id, names_to_view, names_to_view_key) VALUES (1, 'male', 'en');
MERGE INTO gender_names_to_view (gender_id, names_to_view, names_to_view_key) VALUES (2, 'female', 'en');