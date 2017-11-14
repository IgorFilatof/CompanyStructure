CREATE TABLE main_department
(
  id_main_dep serial NOT NULL,
  name_department character varying(50) NOT NULL,
  CONSTRAINT main_department_pkey PRIMARY KEY (id_main_dep)
);

CREATE TABLE department
(
  id_dep serial NOT NULL,
  name_department character varying(50) NOT NULL,
  date_creation date NOT NULL,
  id_main serial NOT NULL,
  CONSTRAINT department_pkey PRIMARY KEY (id_dep),
  CONSTRAINT department_fkey FOREIGN KEY (id_main)
      REFERENCES main_department (id_main_dep) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT main_dep_fkey FOREIGN KEY (id_main)
      REFERENCES main_department (id_main_dep) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE worker
(
  id_worker serial NOT NULL,
  surname character varying(50) NOT NULL,
  name character varying(50) NOT NULL,
  patronymic character varying(50),
  gender character varying(10),
  birthday_date date NOT NULL,
  phone_number character varying(50) NOT NULL,
  email character varying(50) NOT NULL,
  date_start_work date NOT NULL,
  date_end_work date,
  "position" character varying(50) NOT NULL,
  salary integer NOT NULL,
  is_leader boolean NOT NULL,
  id_dep integer,
  CONSTRAINT worker_pkey PRIMARY KEY (id_worker),
  CONSTRAINT worker_fkey FOREIGN KEY (id_dep)
      REFERENCES department (id_dep) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);





  
