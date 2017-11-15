INSERT INTO `mfloan`.`users` (`enabled`, `password`, `username`) VALUES (true, 'password', 'admin');
INSERT INTO `mfloan`.`users` (`enabled`, `password`, `username`) VALUES (true, 'password', 'user');

INSERT INTO `mfloan`.`orgform` (`enabled`, `name`) VALUES (true, 'Юр. лицо');
INSERT INTO `mfloan`.`orgform` (`enabled`, `name`) VALUES (true, 'Физ. лицо');

INSERT INTO `mfloan`.`region` (`name`,`code`) VALUES ('Баткенская область','СОАТЕ код области');
INSERT INTO `mfloan`.`region` (`name`,`code`) VALUES ('Жалал-Абадская область','СОАТЕ код области');
INSERT INTO `mfloan`.`region` (`name`,`code`) VALUES ('Ошская область','СОАТЕ код области');
INSERT INTO `mfloan`.`region` (`name`,`code`) VALUES ('Таласская область','СОАТЕ код области');
INSERT INTO `mfloan`.`region` (`name`,`code`) VALUES ('Нарынская область','СОАТЕ код области');
INSERT INTO `mfloan`.`region` (`name`,`code`) VALUES ('Иссык-Кульская область','СОАТЕ код области');
INSERT INTO `mfloan`.`region` (`name`,`code`) VALUES ('Чуйская область','СОАТЕ код области');
INSERT INTO `mfloan`.`region` (`name`,`code`) VALUES ('г.Бишкек','СОАТЕ код города');

INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Баткенский район','СОАТЕ код района',1);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Ляйлякский район','СОАТЕ код района',1);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Кадамжайский район','СОАТЕ код района',1);

INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Аксыйский район','СОАТЕ код района',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Ала-Букинский район','СОАТЕ код района',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Сузакский район','СОАТЕ код района',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Базар-Коргонский район','СОАТЕ код района',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Ноокенский район','СОАТЕ код района',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Чаткальский район','СОАТЕ код района',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Токтогульский район','СОАТЕ код района',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Тогуз-Тороузский район','СОАТЕ код района',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('г.Жалал-Абад','СОАТЕ код района',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('г.Кара-Куль','СОАТЕ код района',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('г.Таш-Кумыр','СОАТЕ код района',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('г.Кок-Жангак','СОАТЕ код района',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('г.Кочкор-Ата','СОАТЕ код района',2);


INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Араванский район','СОАТЕ код района',3);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Алайский район','СОАТЕ код района',3);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Кара-Суйский район','СОАТЕ код района',3);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Кара-Кульджинский район','СОАТЕ код района',3);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Чон-Алайский район','СОАТЕ код района',3);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Узгенский район','СОАТЕ код района',3);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('Ноокатский район','СОАТЕ код района',3);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('г.Ош','СОАТЕ код района',3);

INSERT INTO `mfloan`.`aokmotu` (`name`,`code`,`district_id`) VALUES ('Аокмоту №1 1.района','СОАТЕ код аокмоту',1);
INSERT INTO `mfloan`.`aokmotu` (`name`,`code`,`district_id`) VALUES ('Аокмоту №2 1.района','СОАТЕ код аокмоту',1);
INSERT INTO `mfloan`.`aokmotu` (`name`,`code`,`district_id`) VALUES ('Аокмоту №3 1.района','СОАТЕ код аокмоту',1);

INSERT INTO `mfloan`.`aokmotu` (`name`,`code`,`district_id`) VALUES ('Аокмоту №1 2.района','СОАТЕ код аокмоту',2);
INSERT INTO `mfloan`.`aokmotu` (`name`,`code`,`district_id`) VALUES ('Аокмоту №2 2.района','СОАТЕ код аокмоту',2);
INSERT INTO `mfloan`.`aokmotu` (`name`,`code`,`district_id`) VALUES ('Аокмоту №3 2.района','СОАТЕ код аокмоту',2);

INSERT INTO `mfloan`.`village` (`name`,`code`,`aokmotu_id`) VALUES ('Село №1 1.аокмоту','СОАТЕ код мела',1);
INSERT INTO `mfloan`.`village` (`name`,`code`,`aokmotu_id`) VALUES ('Село №2 1.аокмоту','СОАТЕ код мела',1);
INSERT INTO `mfloan`.`village` (`name`,`code`,`aokmotu_id`) VALUES ('Село №3 1.аокмоту','СОАТЕ код мела',1);

INSERT INTO `mfloan`.`village` (`name`,`code`,`aokmotu_id`) VALUES ('Село №1 2.аокмоту','СОАТЕ код мела',2);
INSERT INTO `mfloan`.`village` (`name`,`code`,`aokmotu_id`) VALUES ('Село №2 2.аокмоту','СОАТЕ код мела',2);
INSERT INTO `mfloan`.`village` (`name`,`code`,`aokmotu_id`) VALUES ('Село №3 2.аокмоту','СОАТЕ код мела',2);


INSERT INTO `mfloan`.`identity_doc_given_by` (`enabled`, `name`) VALUES (true, 'МКК');
INSERT INTO `mfloan`.`identity_doc_given_by` (`enabled`, `name`) VALUES (true, 'Министерство юстиции');


INSERT INTO `mfloan`.`identity_doc_type` (`enabled`, `name`) VALUES (true, 'Паспорт');
INSERT INTO `mfloan`.`identity_doc_type` (`enabled`, `name`) VALUES (true, 'Свидетельство о регистрации');

INSERT INTO `mfloan`.`employment_history_event_type` (`name`) VALUES ('Дата рождения');
INSERT INTO `mfloan`.`employment_history_event_type` (`name`) VALUES ('Учеба - высшее образование');
INSERT INTO `mfloan`.`employment_history_event_type` (`name`) VALUES ('Принятие на работу');
INSERT INTO `mfloan`.`employment_history_event_type` (`name`) VALUES ('Увольнение с работы');
INSERT INTO `mfloan`.`employment_history_event_type` (`name`) VALUES ('Награждение');
INSERT INTO `mfloan`.`employment_history_event_type` (`name`) VALUES ('Дисциплинарное взыскание');

INSERT INTO `mfloan`.`c_system` (`name`) VALUES ('АСУБК');
INSERT INTO `mfloan`.`c_system` (`name`) VALUES ('Rm1');

INSERT INTO `mfloan`.`object_type` (`name`,`code`) VALUES ('Система','cSystem');
INSERT INTO `mfloan`.`object_type` (`name`,`code`) VALUES ('Организация','Organization');


INSERT INTO `mfloan`.`object_field` (`name`,`description`,`method_name`,`object_type_id`) VALUES ('id','Идентификационный номер системы','getId',1);
INSERT INTO `mfloan`.`object_field` (`name`,`description`,`method_name`,`object_type_id`) VALUES ('name','Наименование системы','getName',1);




