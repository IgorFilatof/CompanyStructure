INSERT INTO main_department(
             name_department)
    VALUES ( 'IT');

    INSERT INTO main_department(
             name_department)
    VALUES ( 'Economy');

    
INSERT INTO department(
             name_department, date_creation, id_main)
    VALUES ('development','2002-02-12', 1);
    
INSERT INTO department(
             name_department, date_creation, id_main)
    VALUES ('testing','2002-03-12', 1);

    INSERT INTO department(
             name_department, date_creation, id_main)
    VALUES ('accountant','2002-01-12', 2);


INSERT INTO worker(
             surname, name, patronymic, gender, birthday_date, 
            phone_number, email, date_start_work,"position", 
            salary, is_leader, id_dep)
    VALUES ('Filatov','Igor','Vladimirovich','M','1994-11-06',8908986532
            ,'igor123@yandex.ru','2007-05-12','programmer',
            23000,false,1);

INSERT INTO worker(
             surname, name, patronymic, gender, birthday_date, 
            phone_number, email, date_start_work,"position", 
            salary, is_leader, id_dep)
    VALUES ('Oshitok','Vladimir','Vladimirovich','M','1994-01-06',8908489532
            ,'vladimir123@yandex.ru','2009-07-12','programmer',
            24000,false,1);

INSERT INTO worker(
             surname, name, patronymic, gender, birthday_date, 
            phone_number, email, date_start_work,"position", 
            salary, is_leader, id_dep)
    VALUES ('Pushkarenko','Oleg','Ivanovich','M','1993-01-15',8908732532
            ,'push123@yandex.ru','2005-02-12','tester',
            24000,false,2);

 INSERT INTO worker(
             surname, name, patronymic, gender, birthday_date, 
            phone_number, email, date_start_work,"position", 
            salary, is_leader, id_dep)
    VALUES ('Semenov','Ivan','Ivanovich','M','1996-05-15',8904232532
            ,'semen123@yandex.ru','2010-02-12','tester',
            23000,false,2);

 INSERT INTO worker(
             surname, name, patronymic, gender, birthday_date, 
            phone_number, email, date_start_work,"position", 
            salary, is_leader, id_dep)
    VALUES ('Litvinov','Georgiy','Semenovich','M','1996-05-15',8904232532
            ,'semen123@yandex.ru','2010-02-12','programmer',
            50000,true,1);

 INSERT INTO worker(
             surname, name, patronymic, gender, birthday_date, 
            phone_number, email, date_start_work,"position", 
            salary, is_leader, id_dep)
    VALUES ('Drozdova','Olga','Semenovich','F','1990-09-15',8959232532
            ,'olga123@yandex.ru','2015-02-12','analitics',
            30000,false,3);

INSERT INTO worker(
             surname, name, patronymic, gender, birthday_date, 
            phone_number, email, date_start_work,"position", 
            salary, is_leader, id_dep)
    VALUES ('Ivonova','Natalya','Igorevna','F','1991-09-15',8959788732
            ,'nata123@yandex.ru','2010-02-12','analitics',
            40000,true,3);

INSERT INTO worker(
             surname, name, patronymic, gender, birthday_date, 
            phone_number, email, date_start_work,"position", 
            salary, is_leader, id_dep)
    VALUES ('Volodina','Natalya','Olegovna','F','1992-09-15',8959788732
            ,'vol123@yandex.ru','2015-02-12','analitics',
            20000,false,3);

            INSERT INTO worker(
             surname, name, patronymic, gender, birthday_date, 
            phone_number, email, date_start_work,"position", 
            salary, is_leader, id_dep)
    VALUES ('Petrov','Petr','Olegovich','M','1992-09-15',8959769832
            ,'petr123@yandex.ru','2016-02-12','economist',
            20000,false,3);

   INSERT INTO worker(
             surname, name, patronymic, gender, birthday_date, 
            phone_number, email, date_start_work,"position", 
            salary, is_leader, id_dep)
    VALUES ('Vikov','Svetlana','Olegovna','F','1991-10-15',8959558732
            ,'svet23@yandex.ru','2012-02-12','analitics',
            40000,true,3);
            
            
          