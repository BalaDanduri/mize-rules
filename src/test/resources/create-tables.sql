
drop table if exists catalog;
create table catalog
(
	id integer primary key auto_increment  not null,
    tenant_id integer ,
 	catalog_code varchar(30),
 	catalog_type varchar(100),
 	is_active char(1) default 'Y',
  	created_date timestamp,
  	updated_date timestamp, 
  	created_by integer,
  	updated_by integer
);

drop table if exists catalog_intl;
create table catalog_intl
(
	id integer primary key auto_increment  not null,
	catalog_id integer,
	locale_id integer,
 	catalog_name varchar(100),
 	catalog_desc varchar(1000),
  	created_date timestamp,
  	updated_date timestamp, 
  	created_by integer,
  	updated_by integer
);

create table locale 
(
	locale_id integer primary key auto_increment not null,
	is_active char(1),
	language_code varchar(10),
	country_code varchar(10),
	locale_name varchar(100)
);

insert into locale values(1,'Y','EN','USA','EN_USA');