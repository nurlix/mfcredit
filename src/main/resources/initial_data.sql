INSERT INTO `mfloan`.`users` (`enabled`, `password`, `username`) VALUES (true, 'password', 'admin');
INSERT INTO `mfloan`.`users` (`enabled`, `password`, `username`) VALUES (true, 'password', 'user');

INSERT INTO `mfloan`.`orgform` (`enabled`, `name`) VALUES (true, '��. ����');
INSERT INTO `mfloan`.`orgform` (`enabled`, `name`) VALUES (true, '���. ����');

INSERT INTO `mfloan`.`region` (`name`,`code`) VALUES ('���������� �������','����� ��� �������');
INSERT INTO `mfloan`.`region` (`name`,`code`) VALUES ('�����-�������� �������','����� ��� �������');
INSERT INTO `mfloan`.`region` (`name`,`code`) VALUES ('������ �������','����� ��� �������');
INSERT INTO `mfloan`.`region` (`name`,`code`) VALUES ('��������� �������','����� ��� �������');
INSERT INTO `mfloan`.`region` (`name`,`code`) VALUES ('��������� �������','����� ��� �������');
INSERT INTO `mfloan`.`region` (`name`,`code`) VALUES ('�����-�������� �������','����� ��� �������');
INSERT INTO `mfloan`.`region` (`name`,`code`) VALUES ('������� �������','����� ��� �������');
INSERT INTO `mfloan`.`region` (`name`,`code`) VALUES ('�.������','����� ��� ������');

INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('���������� �����','����� ��� ������',1);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('���������� �����','����� ��� ������',1);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('������������ �����','����� ��� ������',1);

INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('��������� �����','����� ��� ������',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('���-��������� �����','����� ��� ������',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('��������� �����','����� ��� ������',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('�����-���������� �����','����� ��� ������',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('���������� �����','����� ��� ������',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('����������� �����','����� ��� ������',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('������������� �����','����� ��� ������',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('�����-���������� �����','����� ��� ������',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('�.�����-����','����� ��� ������',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('�.����-����','����� ��� ������',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('�.���-�����','����� ��� ������',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('�.���-������','����� ��� ������',2);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('�.������-���','����� ��� ������',2);


INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('���������� �����','����� ��� ������',3);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('�������� �����','����� ��� ������',3);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('����-������� �����','����� ��� ������',3);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('����-������������ �����','����� ��� ������',3);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('���-�������� �����','����� ��� ������',3);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('��������� �����','����� ��� ������',3);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('���������� �����','����� ��� ������',3);
INSERT INTO `mfloan`.`district` (`name`,`code`,`region_id`) VALUES ('�.��','����� ��� ������',3);

INSERT INTO `mfloan`.`aokmotu` (`name`,`code`,`district_id`) VALUES ('������� �1 1.������','����� ��� �������',1);
INSERT INTO `mfloan`.`aokmotu` (`name`,`code`,`district_id`) VALUES ('������� �2 1.������','����� ��� �������',1);
INSERT INTO `mfloan`.`aokmotu` (`name`,`code`,`district_id`) VALUES ('������� �3 1.������','����� ��� �������',1);

INSERT INTO `mfloan`.`aokmotu` (`name`,`code`,`district_id`) VALUES ('������� �1 2.������','����� ��� �������',2);
INSERT INTO `mfloan`.`aokmotu` (`name`,`code`,`district_id`) VALUES ('������� �2 2.������','����� ��� �������',2);
INSERT INTO `mfloan`.`aokmotu` (`name`,`code`,`district_id`) VALUES ('������� �3 2.������','����� ��� �������',2);

INSERT INTO `mfloan`.`village` (`name`,`code`,`aokmotu_id`) VALUES ('���� �1 1.�������','����� ��� ����',1);
INSERT INTO `mfloan`.`village` (`name`,`code`,`aokmotu_id`) VALUES ('���� �2 1.�������','����� ��� ����',1);
INSERT INTO `mfloan`.`village` (`name`,`code`,`aokmotu_id`) VALUES ('���� �3 1.�������','����� ��� ����',1);

INSERT INTO `mfloan`.`village` (`name`,`code`,`aokmotu_id`) VALUES ('���� �1 2.�������','����� ��� ����',2);
INSERT INTO `mfloan`.`village` (`name`,`code`,`aokmotu_id`) VALUES ('���� �2 2.�������','����� ��� ����',2);
INSERT INTO `mfloan`.`village` (`name`,`code`,`aokmotu_id`) VALUES ('���� �3 2.�������','����� ��� ����',2);


INSERT INTO `mfloan`.`identity_doc_given_by` (`enabled`, `name`) VALUES (true, '���');
INSERT INTO `mfloan`.`identity_doc_given_by` (`enabled`, `name`) VALUES (true, '������������ �������');


INSERT INTO `mfloan`.`identity_doc_type` (`enabled`, `name`) VALUES (true, '�������');
INSERT INTO `mfloan`.`identity_doc_type` (`enabled`, `name`) VALUES (true, '������������� � �����������');

INSERT INTO `mfloan`.`employment_history_event_type` (`name`) VALUES ('���� ��������');
INSERT INTO `mfloan`.`employment_history_event_type` (`name`) VALUES ('����� - ������ �����������');
INSERT INTO `mfloan`.`employment_history_event_type` (`name`) VALUES ('�������� �� ������');
INSERT INTO `mfloan`.`employment_history_event_type` (`name`) VALUES ('���������� � ������');
INSERT INTO `mfloan`.`employment_history_event_type` (`name`) VALUES ('�����������');
INSERT INTO `mfloan`.`employment_history_event_type` (`name`) VALUES ('�������������� ���������');

INSERT INTO `mfloan`.`c_system` (`name`) VALUES ('�����');
INSERT INTO `mfloan`.`c_system` (`name`) VALUES ('Rm1');

INSERT INTO `mfloan`.`object_type` (`name`,`code`) VALUES ('�������','cSystem');
INSERT INTO `mfloan`.`object_type` (`name`,`code`) VALUES ('�����������','Organization');


INSERT INTO `mfloan`.`object_field` (`name`,`description`,`method_name`,`object_type_id`) VALUES ('id','����������������� ����� �������','getId',1);
INSERT INTO `mfloan`.`object_field` (`name`,`description`,`method_name`,`object_type_id`) VALUES ('name','������������ �������','getName',1);




