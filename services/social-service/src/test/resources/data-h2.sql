MERGE INTO vote_answer (id, name_system) VALUES ('1', 'YES');
MERGE INTO vote_answer (id, name_system) VALUES ('2', 'ABSTAIN');
MERGE INTO vote_answer (id, name_system) VALUES ('3', 'NO');

MERGE INTO vote_answer_names_view (vote_answer_id, name_view, locale) VALUES ('1', 'За', 'ru_RU');
MERGE INTO vote_answer_names_view (vote_answer_id, name_view, locale) VALUES ('2', 'Воздержаться', 'ru_RU');
MERGE INTO vote_answer_names_view (vote_answer_id, name_view, locale) VALUES ('3', 'Против', 'ru_RU');

MERGE INTO vote_answer_names_view (vote_answer_id, name_view, locale) VALUES ('1', 'Yes', 'en');
MERGE INTO vote_answer_names_view (vote_answer_id, name_view, locale) VALUES ('2', 'Abstain', 'en');
MERGE INTO vote_answer_names_view (vote_answer_id, name_view, locale) VALUES ('3', 'No', 'en');

MERGE INTO campaign_status (id, name_system) VALUES ('1', 'PLANNED');
MERGE INTO campaign_status (id, name_system) VALUES ('2', 'STARTED');
MERGE INTO campaign_status (id, name_system) VALUES ('3', 'ENDED');
MERGE INTO campaign_status (id, name_system) VALUES ('4', 'ARCHIVE');

MERGE INTO campaign_status_names_view (campaign_status_id, name_view, locale) VALUES ('1', 'Запланированно', 'ru_RU');
MERGE INTO campaign_status_names_view (campaign_status_id, name_view, locale) VALUES ('2', 'Началось', 'ru_RU');
MERGE INTO campaign_status_names_view (campaign_status_id, name_view, locale) VALUES ('3', 'Закончилось', 'ru_RU');
MERGE INTO campaign_status_names_view (campaign_status_id, name_view, locale) VALUES ('4', 'В архиве', 'ru_RU');

MERGE INTO campaign_status_names_view (campaign_status_id, name_view, locale) VALUES ('1', 'Is planned', 'en');
MERGE INTO campaign_status_names_view (campaign_status_id, name_view, locale) VALUES ('2', 'Started', 'en');
MERGE INTO campaign_status_names_view (campaign_status_id, name_view, locale) VALUES ('3', 'Ended', 'en');
MERGE INTO campaign_status_names_view (campaign_status_id, name_view, locale) VALUES ('4', 'In th archive', 'en');