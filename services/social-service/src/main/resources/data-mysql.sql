INSERT IGNORE INTO vote_answer (id, name_system) VALUES ('1', 'YES');
INSERT IGNORE INTO vote_answer (id, name_system) VALUES ('2', 'ABSTAIN');
INSERT IGNORE INTO vote_answer (id, name_system) VALUES ('3', 'NO');

INSERT IGNORE INTO vote_answer_names_view (vote_answer_id, name_view, locale) VALUES ('1', 'За', 'ru_RU');
INSERT IGNORE INTO vote_answer_names_view (vote_answer_id, name_view, locale) VALUES ('2', 'Воздержаться', 'ru_RU');
INSERT IGNORE INTO vote_answer_names_view (vote_answer_id, name_view, locale) VALUES ('3', 'Против', 'ru_RU');

INSERT IGNORE INTO vote_answer_names_view (vote_answer_id, name_view, locale) VALUES ('1', 'Yes', 'en');
INSERT IGNORE INTO vote_answer_names_view (vote_answer_id, name_view, locale) VALUES ('2', 'Abstain', 'en');
INSERT IGNORE INTO vote_answer_names_view (vote_answer_id, name_view, locale) VALUES ('3', 'No', 'en');

INSERT IGNORE INTO campaign_status (id, name_system) VALUES ('1', 'PLANNED');
INSERT IGNORE INTO campaign_status (id, name_system) VALUES ('2', 'STARTED');
INSERT IGNORE INTO campaign_status (id, name_system) VALUES ('3', 'ENDED');
INSERT IGNORE INTO campaign_status (id, name_system) VALUES ('4', 'ARCHIVE');

INSERT IGNORE INTO campaign_status_names_view (campaign_status_id, name_view, locale) VALUES ('1', 'Запланированно', 'ru_RU');
INSERT IGNORE INTO campaign_status_names_view (campaign_status_id, name_view, locale) VALUES ('2', 'Началось', 'ru_RU');
INSERT IGNORE INTO campaign_status_names_view (campaign_status_id, name_view, locale) VALUES ('3', 'Закончилось', 'ru_RU');
INSERT IGNORE INTO campaign_status_names_view (campaign_status_id, name_view, locale) VALUES ('4', 'В архиве', 'ru_RU');

INSERT IGNORE INTO campaign_status_names_view (campaign_status_id, name_view, locale) VALUES ('1', 'Is planned', 'en');
INSERT IGNORE INTO campaign_status_names_view (campaign_status_id, name_view, locale) VALUES ('2', 'Started', 'en');
INSERT IGNORE INTO campaign_status_names_view (campaign_status_id, name_view, locale) VALUES ('3', 'Ended', 'en');
INSERT IGNORE INTO campaign_status_names_view (campaign_status_id, name_view, locale) VALUES ('4', 'In th archive', 'en');