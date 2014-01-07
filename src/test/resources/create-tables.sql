drop table if exists users;
CREATE TABLE users ( 
	id integer primary key auto_increment  not null,
	    tenant_id 		integer ,
		email          	varchar(255) NULL,
		name           	varchar(255) NULL,
		last_login     	timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
		active         	tinyint(1) NULL,
		email_validated tinyint(1) NULL,
		created_by     	bigint(20) NULL,
		created_date   	timestamp NULL,
		updated_by     	bigint(20) NULL,
		updated_date   	timestamp NULL,
		referral_id    	bigint(20) NULL,
        PRIMARY KEY (id) 
	);
	
drop table if exists groups;
CREATE TABLE groups ( 
    id              	int(11) AUTO_INCREMENT NOT NULL,
    group_name      	varchar(100) NULL,
    description     	varchar(200) NULL,
    code            	varchar(20) NULL,
    active_indicator	char(1) NULL,
    created_date    	datetime NULL,
    updated_date    	datetime NULL,
    created_by      	bigint(20) NULL,
    updated_by      	bigint(20) NULL,
    tenant_id       	bigint(20) NULL,
    PRIMARY KEY(id)
);

drop table if exists user_to_groups;
CREATE TABLE user_to_groups ( 
    user_id         	bigint(20) NULL,
    group_id        	int(11) NOT NULL,
    id              	int(11) AUTO_INCREMENT NOT NULL,
    active_indicator	char(1) NULL,
    created_date    	datetime NULL,
    updated_date    	datetime NULL,
    created_by      	bigint(20) NULL,
    updated_by      	bigint(20) NULL,
    PRIMARY KEY(id)
);

drop table if exists user_profile;
CREATE TABLE user_profile (
	id integer primary key auto_increment  not null,
	first_name			varchar(50) 	NULL,
	middle_name			varchar(50) 	NULL,
	last_name			varchar(50) 	NULL,
	profile_name 		varchar(100) 	NULL,
	gender       		varchar(1) 		NULL DEFAULT 'M',
	phone_mobile 		varchar(20) 	NULL,
	phone_home   		varchar(20) 	NULL,
	phone_work   		varchar(20) 	NULL,
	email_opt_out 		varchar(1) NOT 	NULL DEFAULT 'Y',
	birth_day    		timestamp 		NULL,
	photo_link   		varchar(250) 	NULL,
	timezone     		varchar(10) 	NULL,
	prompt_app_rating   varchar(1) 		NULL,
	user_id     		integer 		NULL,
	PRIMARY KEY (id)
);

drop table if exists user_profile_privacy;
CREATE TABLE user_profile_privacy ( 
    user_id          	bigint(20) NOT NULL,
    display_birthyear	char(1) NULL DEFAULT 'Y',
    email            	int(11) NULL DEFAULT '2',
    friends          	int(11) NULL DEFAULT '2',
    activity         	int(11) NULL DEFAULT '2',
    want             	int(11) NULL DEFAULT '2',
    own              	int(11) NULL DEFAULT '2',
    birthdate        	int(11) NULL,
    gender           	int(11) NULL,
    city_state       	int(11) NULL,
    created_date     	datetime NULL,
    created_by       	bigint(20) NULL,
    updated_date     	datetime NULL,
    updated_by       	bigint(20) NULL,
    id               	bigint(20) AUTO_INCREMENT NOT NULL,
    PRIMARY KEY(id)
);

drop table if exists user_address;
CREATE TABLE user_address ( 
	id          	integer AUTO_INCREMENT NOT NULL,
	entity_address_id  	integer ,
	user_id     	integer NULL,
	address_type 	varchar(20) NULL,
	address_name 	varchar(50) NULL,
	address1    	varchar(100) NULL,
	address2    	varchar(100) NULL,
	address3    	varchar(100) NULL,
	city        	varchar(100) NULL,
	state_id    	int(11) NULL,
	country_id  	int(11) NULL,
	postal_code 	varchar(11) NULL,
	created_by  	integer NULL,
	created_date	timestamp NULL,
	updated_by  	integer NULL,
	updated_date	timestamp NULL, 
	PRIMARY KEY (id)
);

drop table if exists prod_regn;
CREATE TABLE prod_regn ( 
	prod_regn_id        	bigint(20) primary key auto_increment NOT NULL,
	user_id             	bigint(20) NULL,
	prod_id             	bigint(20) NULL,
	purchase_price      	double NULL,
	purchase_store      	varchar(200) NULL,
	prod_srl_no         	varchar(200) NULL,
	purchase_date       	date NULL,
	warranty_expiry_date 	date NULL,
	addl_info           	varchar(500) NULL,
	created_by          	bigint(20) NULL,
	updated_by          	bigint(20) NULL,
	created_date        	datetime NULL,
	updated_date        	datetime NULL,
	first_name          	varchar(100) NULL,
	last_name           	varchar(100) NULL,
	email               	varchar(255) NULL,
	address1            	varchar(100) NULL,
	address2            	varchar(100) NULL,
	address3            	varchar(100) NULL,
	city                	varchar(100) NULL,
	postal_code         	varchar(11) NULL,
	phone_mobile        	varchar(20) NULL,
	phone_home          	varchar(20) NULL,
	phone_work          	varchar(20) NULL,
	state_id            	int(11) NULL,
	country_id          	int(11) NULL,
	brand_id            	bigint(20) NULL,
	user_address_id     	bigint(20) NULL,
	regn_name           	varchar(50) NULL, 
	template           	varchar(50) NULL,
	PRIMARY KEY (prod_regn_id)
);

drop table if exists users_to_brand;
CREATE TABLE users_to_brand (
id integer primary key auto_increment  not null,
	user_id         	integer NOT NULL,
	brand_id        	integer NOT NULL,
	created_date    	datetime NULL,
	updated_date    	datetime NULL,
	created_by      	bigint(20) NULL,
	updated_by      	bigint(20) NULL,
	active_indicator 	char(1)  NULL,
	PRIMARY KEY (id)
);

drop table if exists users_to_be;
CREATE TABLE users_to_be ( 
    user_id     	bigint(20) NULL,
    be_id       	bigint(20) NULL,
    job_role    	varchar(200) NULL,
    created_date	datetime NULL,
    created_by  	bigint(20) NULL,
    updated_date	datetime NULL,
    updated_by  	bigint(20) NULL,
    department  	varchar(100) NULL,
    id          	bigint(20) AUTO_INCREMENT NOT NULL,
    PRIMARY KEY(id)
);

drop table if exists brand_feed;
CREATE TABLE brand_feed ( 
	id          	integer AUTO_INCREMENT NOT NULL,
	brand_id    	bigint(20) NULL,
	feed_type   	varchar(20) NULL,
	feed_desc   	varchar(2000) NULL,
	start_time  	datetime NULL,
	end_time    	datetime NULL,
	created_by  	bigint(20) NULL,
	created_date	datetime NULL,
	updated_by  	bigint(20) NULL,
	updated_date	datetime NULL,
	feed_title  	varchar(50) NULL,
        PRIMARY KEY (id) 
	);

drop table if exists prod_repeat_ship_options;
CREATE TABLE prod_repeat_ship_options ( 
	id          	integer AUTO_INCREMENT NOT NULL,
	brand_id    	bigint(20) NULL,
	prod_id     	bigint(20) NULL,
	code        	varchar(50) NULL,
	description 	varchar(200) NULL,
	ship_amt    	double NULL,
	created_date	datetime NULL,
	created_by  	bigint(20) NULL,
	updated_date	datetime NULL,
	updated_by  	bigint(20) NULL, 
	PRIMARY KEY (id)
	);

drop table if exists linked_account;
CREATE TABLE linked_account ( 
	id bigint(20) primary key auto_increment  not null,
	user_id            	bigint(20) NULL,
	provider_user_id   	varchar(255) NULL,
	provider_key       	varchar(255) NULL,
	access_token_secret 	varchar(255) NULL,
	created_by         	bigint(20) NULL,
	created_date       	datetime NULL,
	updated_by         	bigint(20) NULL,
	updated_date       	datetime NULL,
	access_token       	varchar(1500) NULL,
	user_name          	varchar(100) NULL,
	first_login        	char(1) NULL 
);

drop table if exists role;
create table role
(
	id integer primary key auto_increment  not null,
	code varchar(20), 
 	role_name varchar(100), 	
 	description varchar(200),
 	active_indicator varchar(1),
 	created_date timestamp null,                     
 	updated_date timestamp null,                     
 	created_by  integer null,                     
 	updated_by integer null
);

drop table if exists catalog;
create table catalog
(
	id integer primary key auto_increment  not null,
    tenant_id integer ,
 	catalog_code varchar(30),
 	catalog_type varchar(100),
 	is_active char(1) default 'Y',
 	catalog_name varchar(250),
  	created_date timestamp,
  	updated_date timestamp, 
  	created_by integer,
  	updated_by integer
);

drop table if exists catalog_entry;
create table catalog_entry
(
	id integer primary key auto_increment  not null,
	catalog_id integer,
 	item_code varchar(30), 	
 	is_active char(1) default 'Y',
 	is_default char(1) default 'N',
 	order_sequence bigint(20),
  	created_date timestamp,
  	updated_date timestamp, 
  	created_by integer,
  	updated_by integer
);

ALTER TABLE catalog_entry
  ADD CONSTRAINT FK_CT1
  FOREIGN KEY(catalog_id)
  REFERENCES catalog(id);

drop table if exists catalog_entry_intl;
create table catalog_entry_intl
(
	id integer primary key auto_increment  not null,
	catalog_entry_id integer,
	locale_id integer,
 	item_name varchar(100),
 	item_description varchar(500),
  	created_date timestamp,
  	updated_date timestamp, 
  	created_by integer,
  	updated_by integer
);

ALTER TABLE catalog_entry_intl
  ADD CONSTRAINT FK_CT2
  FOREIGN KEY(catalog_entry_id)
  REFERENCES catalog_entry(id);

drop table if exists locale;
create table locale 
(
	locale_id integer primary key auto_increment not null,
	is_active char(1),
	language_code varchar(10),
	country_code varchar(10),
	locale_name varchar(100)
);

drop table if exists country;
CREATE TABLE country ( 
	country_id    	INTEGER(11) NOT NULL,
	country_name  	VARCHAR(100) NULL,
	country_code  	VARCHAR(2) NULL,
	country_code_3	VARCHAR(3) NULL,
	created_by    	BIGINT(20) NULL,
	created_date  	DATETIME NULL,
	updated_by    	BIGINT(20) NULL,
	updated_date  	DATETIME NULL 
	);

drop table if exists state;
CREATE TABLE state ( 
	state_id    	INTEGER(11) NOT NULL,
	state_code  	VARCHAR(5) NOT NULL,
	state_name  	VARCHAR(100) NOT NULL,
	created_by  	BIGINT(20) NULL,
	created_date	DATETIME NULL,
	updated_by  	BIGINT(20) NULL,
	updated_date	DATETIME NULL,
	country_id  	INTEGER(11) NULL 
	);

drop table if exists business_entity;
CREATE TABLE business_entity ( 
    id       bigint(20) 	AUTO_INCREMENT NOT NULL,
    tenant_id     bigint(20) 		NULL,
    code           varchar(50) 	NULL,
    type_code      varchar(50) 	NULL,
    sub_type_code  varchar(50) 	NULL,
    name		   varchar(50) 	NULL,
   	logo           varchar(100) NULL,
    active_indicator char(1) 	NULL,
    currency_code  varchar(50) 	NULL,
    parent_be_id	bigint(20) 	NULL,
    created_date    datetime 	NULL,
    updated_date    datetime 	NULL,
    created_by      bigint(20) 	NULL,
    updated_by      bigint(20) 	NULL,    
);

drop table if exists business_entity_intl;
CREATE TABLE business_entity_intl ( 
    id         bigint(20) 	AUTO_INCREMENT NOT NULL,
    be_id      bigint(20) 	NOT NULL,   
    locale_id  bigint(20) 	NULL,
    be_name    varchar(250) NULL,
    be_description  varchar(500) NULL,
    be_first_name  varchar(100) NULL,
    be_last_name  varchar(100) NULL,
    be_middle_initial  varchar(50) NULL,
);

drop table if exists business_entity_address;
CREATE TABLE  business_entity_address  ( 
	id         bigint(20) 	AUTO_INCREMENT NOT NULL,
	be_id        	BIGINT(20) NOT NULL,
	code         	VARCHAR(50) NULL,
	locale_id    	INTEGER(11) NULL,
	name         	VARCHAR(200) NULL,
	address_1    	VARCHAR(100) NULL,
	address_2    	VARCHAR(100) NULL,
	address_3    	VARCHAR(100) NULL,
	zip          	VARCHAR(10) NULL,
	zip_ext      	VARCHAR(10) NULL,
	city         	VARCHAR(50) NULL,
	county       	VARCHAR(50) NULL,
	state_id     	INTEGER(11) NULL,
	country_id   	INTEGER(11) NULL,
	phone_1      	VARCHAR(50) NULL,
	phone_2      	VARCHAR(50) NULL,
	email        	VARCHAR(50) NULL,
	fax          	VARCHAR(50) NULL,
	land_mark    	VARCHAR(500) NULL,
	url          	VARCHAR(256) NULL,
	tool_tip_logo	VARCHAR(100) NULL,
	icon         	VARCHAR(100) NULL,
	hours_of_op  	VARCHAR(250) NULL, 
	be_address_id	BIGINT(20)  NULL,
	is_preferred 	char(1) 	NULL
);

drop table if exists business_entity_geo;
CREATE TABLE business_entity_geo ( 
	id					bigint(20) 	AUTO_INCREMENT NOT NULL,
	be_address_id	BIGINT(20) NULL,
	latitude     	bigint(2000) NULL,
	longitude    	bigint(2000) NULL,
	);

drop table if exists business_entity_brand;
CREATE TABLE business_entity_brand (
    id				bigint(20) 	AUTO_INCREMENT NOT NULL,
    be_id   		bigint(20) 			NULL,
    brand_id		bigint(20) 			NULL,
    is_active		char(1) 			NULL,
);

drop table if exists business_entity_attribute;
CREATE TABLE business_entity_attribute (
    id				bigint(20) 		AUTO_INCREMENT NOT NULL,
    be_id   			bigint(20) 		NULL,
    brand_id			bigint(20) 		NULL,
    url          		varchar(256) 		NULL,
    tool_tip_logo		varchar(100) 		NULL,
    icon         		varchar(100) 		NULL,
    hours_of_op  		varchar(250) 		NULL,
    is_credit_onhold		char(1) 		NULL,
);	

INSERT INTO business_entity_attribute(be_id, brand_id, url, tool_tip_logo, icon, hours_of_op, is_credit_onhold) VALUES (961,1,'testUrl','toolTip','icon','hours0fOp','y');

drop table if exists business_entity_contact;
CREATE TABLE business_entity_contact (
    id				bigint(20) 		AUTO_INCREMENT NOT NULL,
    be_id   			bigint(20) 		NULL,
    contact_type        varchar(50) 	NULL,
    brand_id			bigint(20) 		NULL,
    is_primary			char(1) 		NULL,
    first_name			varchar(100) 	NULL,
    last_name			varchar(100) 	NULL,
    middle_initial		varchar(50) 	NULL,
    phone         		varchar(50) 	NULL,
    phone_ext         	varchar(10) 	NULL,
    fax         		varchar(50) 	NULL,
    fax_ext             varchar(10) 	NULL,
    email  			    varchar(100) 	NULL,
    department			varchar(50) 	NULL,
);

drop table if exists entity_address;
CREATE TABLE entity_address (
	id			bigint(20) 	  AUTO_INCREMENT NOT NULL,
	address_type    	varchar(100) 		NULL,
	address_1    		varchar(100) 		NULL,
	address_2    		varchar(100) 		NULL,
	address_3    		varchar(100) 		NULL,
	zip          		varchar(10) 		NULL,
	zip_ext      		varchar(10) 		NULL,
	city         		varchar(50)			NULL,
	county       		varchar(50) 		NULL,
	state_id     		bigint(20) 			NULL,
	country_id   		bigint(20) 			NULL,	
	email        		varchar(100) 		NULL,
	land_mark    		varchar(500) 		NULL,
	created_date    	datetime 			NULL,
	updated_date    	datetime 			NULL,
	created_by      	bigint(20) 			NULL,
    updated_by      	bigint(20) 			NULL,  
);

drop table if exists entity_address_phone;
CREATE TABLE entity_address_phone (
	id			bigint(20) 		AUTO_INCREMENT NOT NULL,
	entity_address_id    	bigint(20) 		NULL,
	phone_type      	varchar(50) 		NULL,
	phone_value      	varchar(50) 		NULL,
	phone_ext      		varchar(10) 		NULL,
);

drop table if exists entity_address_geo;
CREATE TABLE entity_address_geo ( 
    id				bigint(20) 		AUTO_INCREMENT NOT NULL,
    entity_address_id		bigint(20) 		NULL,
    latitude     		mediumtext 		NULL,
    longitude    		mediumtext 		NULL,
    PRIMARY KEY (id)
);

drop table if exists part;
create table part
(
	id integer primary key auto_increment  not null,
    tenant_id integer ,
 	part_code varchar(30),
 	part_type varchar(30),
 	is_active char(1) default 'Y',
 	is_kit char(1),
 	is_serialized char(1),
 	is_returnable char(1),
 	uom varchar(30),
  	created_date timestamp,
  	updated_date timestamp, 
  	created_by integer,
  	updated_by integer
);

drop table if exists part_intl;
create table part_intl
(
	id integer primary key auto_increment  not null,
    locale_id integer ,
    part_id integer ,
 	part_name varchar(250),
 	part_desc varchar(500),
  
);

drop table if exists part_price;
create table part_price
(
	id integer primary key auto_increment  not null,
    country_id integer ,
    part_id integer ,
 	unit_price DECIMAL(20,6),
 	list_price DECIMAL(20,6),
 	net_price DECIMAL(20,6),
 	start_date timestamp,
  	end_date timestamp,
  	currency_code varchar(30),
  	tax_id  integer,
  	created_date timestamp,
  	updated_date timestamp, 
  	created_by integer,
  	updated_by integer
);

drop table if exists part_attribute;
create table part_attribute
(
	id integer primary key auto_increment  not null,
    part_id integer ,
    attribute_code varchar(30),
 	attribute_value varchar(100),
    attribute_uom varchar(30)
);


drop table if exists part_kit;
create table part_kit
(
	id integer primary key auto_increment  not null,
    part_id integer ,
    tenant_id integer ,
    price_method  varchar(30) ,
 	kit_type varchar(30),
 	is_active char(1) default 'Y',
 	start_date timestamp,
 	end_date timestamp,
    created_date timestamp,
  	updated_date timestamp, 
  	created_by integer,
  	updated_by integer
    
);

drop table if exists part_kit_item;
create table part_kit_item
(
	id integer primary key auto_increment  not null,
    part_id integer ,
    part_kit_id integer ,
 	part_qty DECIMAL(20,6),
);

drop table if exists picklist;
create table picklist
(
	id integer primary key auto_increment  not null,
    picklist_code  varchar(30) ,
 	picklist_type varchar(30),
 	is_active char(1) default 'Y',
 	be_id integer,
 	tenant_id integer,
 	picklist_comments varchar(500),
    created_date timestamp,
  	updated_date timestamp, 
  	created_by integer,
  	updated_by integer
    
);

drop table if exists picklist_item;
create table picklist_item
(
	id integer primary key auto_increment  not null,
	part_id integer ,
    picklist_id integer ,
 	part_qty DECIMAL(20,6),
);

drop table if exists brand;
CREATE TABLE brand (
        brand_id         bigint(20) NOT NULL,
        brand_name         varchar(250) NOT NULL,
        brand_type         int(11) NULL,
        brand_link         varchar(250) NULL,
        created_by         bigint(20) NULL,
        created_date         datetime NULL,
        updated_by         bigint(20) NULL,
        updated_date         datetime NULL,
        brand_logo         varchar(50) NULL,
        feedback_email         varchar(100) NULL,
        department         varchar(50) NULL,
        registered         char(1) NULL DEFAULT 'N',
        is_active         char(1) NULL,
);

drop table if exists brand_support;
CREATE TABLE brand_support (
        brand_id         bigint(20) NOT NULL,
        brand_support_id         bigint(20) NOT NULL,
        support_phone         varchar(20) NULL,
        support_email         varchar(100) NULL,
        support_site         varchar(250) NULL,
        support_chat         varchar(500) NULL,
        support_phone_tf         varchar(20) NULL,
        support_qualifier         varchar(250) NULL,
        validated_by         varchar(100) NULL,
        validated_on         datetime NULL,
        prodcat_id         int(11) NULL,
        support_facebook         varchar(250) NULL,
        support_twitter         varchar(250) NULL,
        country_id         int(11) NOT NULL,
        support_type         int(11) NULL,
        data_source_type         int(11) NULL,
        validated         tinyint(1) NULL,
        hours_of_op         varchar(250) NULL,
        created_by         bigint(20) NULL,
        created_date         datetime NULL,
        updated_by         bigint(20) NULL,
        updated_date         datetime NULL,
);
	
drop table if exists groups;
CREATE TABLE groups ( 
    id				bigint(20) 	AUTO_INCREMENT NOT NULL,
    tenant_id integer ,
    GROUP_NAME		varchar(50) 	NULL,
    CODE			varchar(50) 	NULL,
    DESCRIPTION		varchar(20) 	NULL,
   	ACTIVE_INDICATOR	char(1) default 'Y', 
   	created_date timestamp,
  	updated_date timestamp, 
  	created_by integer,
  	updated_by integer
);


drop table if exists role;
CREATE TABLE role ( 
    id				bigint(20) 	AUTO_INCREMENT NOT NULL,
    CODE			varchar(50) 	NULL,
    ROLE_NAME		varchar(50) 	NULL,
    DESCRIPTION		varchar(20) 	NULL,
   	ACTIVE_INDICATOR	char(1) default 'Y',  
   	created_date timestamp,
  	updated_date timestamp, 
  	created_by integer,
  	updated_by integer
);

drop table if exists groups_to_role;
CREATE TABLE groups_to_role ( 
    id				bigint(20) 	AUTO_INCREMENT NOT NULL,
    group_id		bigint(20) 	NULL,
    role_id		   	bigint(20) 	NULL,
   	ACTIVE_INDICATOR	char(1) default 'Y', 
   	created_date timestamp,
  	updated_date timestamp, 
  	created_by integer,
  	updated_by integer
);

drop table if exists entity_parameter;	
CREATE TABLE entity_parameter (
	id 			bigint(20) 		AUTO_INCREMENT NOT NULL,
	tenant_id		bigint(20)		NULL,
	entity_type		varchar(50) 		NULL,	
	entity_code		varchar(50) 		NULL,		
	start_date		datetime 		NULL,
	end_date		datetime 		NULL,
	created_date 		datetime 		NULL,
	updated_date 		datetime 		NULL,
	created_by 		bigint(20)		NULL,
	updated_by 		bigint(20)		NULL,	
	PRIMARY KEY (id)
);

drop table if exists entity_parameter_attribute;	
CREATE TABLE entity_parameter_attribute (
	id 			bigint(20) 		AUTO_INCREMENT NOT NULL,
	parameter_id		bigint(20)		NOT NULL,
	attribute_code		varchar(50) 		NULL,	
	attribute_value		varchar(100) 		NULL,	
	PRIMARY KEY (id)
);

drop table if exists entity_parameter_comment;
CREATE TABLE entity_parameter_comment (
	id 			bigint(20) 		AUTO_INCREMENT NOT NULL,
	parameter_id		bigint(20)		NOT NULL,
	comment_id		bigint(20)		NOT NULL,	
	PRIMARY KEY (id)
);

  drop table if exists entity_comment;
  CREATE TABLE entity_comment (
	id 			bigint(20) 	AUTO_INCREMENT NOT NULL,
	comment_type varchar(50)	NOT NULL,
	comments     varchar(5000) 	NOT NULL,
	created_date 		datetime 	NULL,
	updated_date 		datetime 	NULL,
	created_by 		bigint(20)	NULL,
	updated_by 		bigint(20)	NULL,	
	PRIMARY KEY (id)
);

drop table if exists work_queue;
create table work_queue(
id                   bigint(20 )       AUTO_INCREMENT NOT NULL,
code                 varchar(50)       NULL,
name                 varchar(100)      NULL,
description          varchar(500)      NULL,
created_by           integer           NULL,
updated_by           integer           NULL,
created_date         timestamp         NULL,
updated_date         timestamp         NULL,
is_active            char(1)           default 'Y',
tenant_id            integer           NULL,
PRIMARY KEY (id)
);

create table work_queue_auth
(
Id                  bigint(20)          AUTO_INCREMENT NOT NULL,
work_queue_id       bigint(20)          NOT NULL, 
auth_id             bigint(20)          NULL,
auth_type           varchar(30)         NULL,
created_by          integer             NULL,
updated_by          integer             NULL,
created_date        timestamp           NULL,
updated_date        timestamp           NULL,
PRIMARY KEY (id)
);

ALTER TABLE work_queue_auth
                ADD CONSTRAINT fk_wqid_wqa
                FOREIGN KEY(work_queue_id)
                REFERENCES work_queue (id);

INSERT INTO entity_parameter(id, tenant_id, entity_type, entity_code, start_date, end_date, created_date, updated_date, created_by, updated_by)
VALUES(2,961,'testParamType1','testParamCode1',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);

INSERT INTO entity_parameter_attribute(id, parameter_id, attribute_code, attribute_value)
VALUES(1,2,'testAttrType1','testAttrCode1');
INSERT INTO entity_parameter_attribute(id, parameter_id, attribute_code, attribute_value)
VALUES(2,2,'testAttrType2','testAttrCode2');
INSERT INTO entity_parameter_attribute(id, parameter_id, attribute_code, attribute_value)
VALUES(3,2,'testAttrType3','testAttrCode3');

INSERT INTO entity_parameter_comment(id, parameter_id, comment_id)
VALUES(1,2,1);

insert into groups (ID, tenant_id, GROUP_NAME, CODE, DESCRIPTION, ACTIVE_INDICATOR, created_date, updated_date, created_by, updated_by) values (1, 961,'MIZE ADMIN', 'ADMIN001', 'Desc', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
insert into groups (ID, tenant_id, GROUP_NAME, CODE, DESCRIPTION, ACTIVE_INDICATOR, created_date, updated_date, created_by, updated_by) values (2, 961,'MIZE ADMIN1', 'ADMIN002', 'Desc', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
insert into groups (ID, tenant_id, GROUP_NAME, CODE, DESCRIPTION, ACTIVE_INDICATOR, created_date, updated_date, created_by, updated_by) values (3, 961,'MIZE ADMIN2', 'ADMIN003', 'Desc', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);

insert into role (ID, CODE,ROLE_NAME, DESCRIPTION, ACTIVE_INDICATOR, created_date, updated_date, created_by, updated_by) values (1, 'roleCode1', 'roleName1', 'Desc1', 'N', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
insert into role (ID, CODE,ROLE_NAME, DESCRIPTION, ACTIVE_INDICATOR, created_date, updated_date, created_by, updated_by) values (2, 'roleCode2', 'roleName2', 'Desc2', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
	
insert into groups_to_role (ID, group_id, role_id, ACTIVE_INDICATOR, created_date, updated_date, created_by, updated_by) values (111, 2, 1, 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
insert into groups_to_role (ID, group_id, role_id, ACTIVE_INDICATOR, created_date, updated_date, created_by, updated_by) values (112, 2, 2, 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);	

insert into locale values(1,'Y','EN','USA','EN_USA');

INSERT INTO  business_entity(id, code, type_code, sub_type_code, name, logo, created_date, updated_date, created_by, updated_by, active_indicator)
  VALUES(961, '10C00100P', 'dealer', NULL, 'WASHINGTON AIR COMP. RENTAL', NULL, '2013-06-19 14:39:31.0', '2013-07-26 14:17:19.0', NULL, NULL, NULL);
  
  INSERT INTO  business_entity(id, code, type_code, sub_type_code, name, logo, created_date, updated_date, created_by, updated_by, active_indicator)
  VALUES(962, '100CP101', 'dealer', NULL, 'WASHINGTON AIR COMP. RENTAL', NULL, '2013-06-19 14:39:31.0', '2013-07-26 14:17:19.0', NULL, NULL, NULL);

INSERT INTO business_entity_geo(id, be_address_id, latitude, longitude)
  VALUES(101,10799, 39.0, 345.0);  


INSERT INTO country(country_id, country_name, country_code, country_code_3, created_by, created_date, updated_by, updated_date)
  VALUES(1, 'United States', 'US', 'USA', NULL, NULL, NULL, NULL);
INSERT INTO country(country_id, country_name, country_code, country_code_3, created_by, created_date, updated_by, updated_date)
  VALUES(2, 'Canada', 'CA', 'CAN', NULL, NULL, NULL, NULL);

INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(1, 'AL', 'Alabama', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(2, 'AK', 'Alaska', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(3, 'AZ', 'Arizona', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(4, 'AR', 'Arkansas', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(5, 'CA', 'California', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(6, 'CO', 'Colorado', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(7, 'CT', 'Connecticut', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(8, 'DE', 'Delaware', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(9, 'FL', 'Florida', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(10, 'GA', 'Georgia', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(11, 'HI', 'Hawaii', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(12, 'ID', 'Idaho', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(13, 'IL', 'Illinois', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(14, 'IN', 'Indiana', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(15, 'IA', 'Iowa', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(16, 'KS', 'Kansas', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(17, 'KY', 'Kentucky', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(18, 'LA', 'Louisiana', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(19, 'ME', 'Maine', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(20, 'MD', 'Maryland', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(21, 'MA', 'Massachusetts', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(22, 'MI', 'Michigan', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(23, 'MN', 'Minnesota', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(24, 'MS', 'Mississippi', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(25, 'MO', 'Missori', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(26, 'MT', 'Montana', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(27, 'NE', 'Nebraska', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(28, 'NV', 'Nevada', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(29, 'NH', 'New Hampshire', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(30, 'NJ', 'New Jersey', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(31, 'NM', 'New Mexico', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(32, 'NY', 'New York', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(33, 'NC', 'North Carolina', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(34, 'ND', 'North Dakota', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(35, 'OH', 'Ohio', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(36, 'OK', 'Oklahoma', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(37, 'OR', 'Oregon', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(38, 'PA', 'Pennsylvania', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(39, 'RI', 'Rhode Island', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(40, 'SC', 'South Carolina', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(41, 'SD', 'South Dakota', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(42, 'TN', 'Tennessee', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(43, 'TX', 'Texas', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(44, 'UT', 'Utah', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(45, 'VT', 'Vermont', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(46, 'VA', 'Virginia', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(47, 'WA', 'Washington', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(48, 'WV', 'West Virginia', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(49, 'WI', 'Wisconsin', NULL, NULL, NULL, NULL, 1);
INSERT INTO state(state_id, state_code, state_name, created_by, created_date, updated_by, updated_date, country_id)
  VALUES(50, 'WY', 'Wyoming', NULL, NULL, NULL, NULL, 1);

INSERT INTO  business_entity_address (id, be_id, code, locale_id, name, address_1, address_2, address_3, zip, zip_ext, city, county, state_id, country_id, phone_1, phone_2, email, fax, land_mark, url, tool_tip_logo, icon, hours_of_op, be_address_id)
  VALUES(10799, 961, NULL, 1, NULL, '12529 PARKLAWN DR.', NULL, NULL, '20852', NULL, 'ROCKVILLE', NULL, 20, 1, '3012305800', NULL, NULL, '3012305830', NULL, NULL, NULL, NULL, NULL,1);
  
INSERT INTO  catalog (id, tenant_id, catalog_code, catalog_type, is_active, catalog_name, created_date, updated_date, created_by, updated_by)
  VALUES(100, 961, 'TestCatalog', 'TestCatalogType', 'Y', 'TestCatalogName', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
  
INSERT INTO  catalog_entry (id, catalog_id, item_code, is_active, is_default, order_sequence, created_date, updated_date, created_by, updated_by)
  VALUES(102, 100, 'ItemCode', 'Y', 'N', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
  
 
INSERT INTO  part (id, tenant_id, part_code, part_type, is_active,is_kit,is_serialized,is_returnable,uom, created_date, updated_date, created_by, updated_by)
  VALUES(101, 961, 'partCode','standard', 'Y', 'N','N','N',null,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO  part (id, tenant_id, part_code, part_type, is_active,is_kit,is_serialized,is_returnable,uom, created_date, updated_date, created_by, updated_by)
  VALUES(102, 961, 'partCode1','standard', 'Y', 'N','N','N',null,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
  
INSERT INTO  part_intl (id, locale_id, part_id, part_name, part_desc)
  VALUES(201, 1, 101,'partname', 'partdescription');
INSERT INTO  part_intl (id, locale_id, part_id, part_name, part_desc)
  VALUES(202, 1, 102,'partname', 'partdescription');
  
INSERT INTO  part_price (id, country_id, part_id, unit_price, list_price, net_price, start_date, end_date, currency_code, tax_id, created_date, updated_date, created_by, updated_by)
  VALUES(301, 1, 101,200.00, null, 200.00,CURRENT_TIMESTAMP,null,'USD',null,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);

INSERT INTO  part_price (id, country_id, part_id, unit_price, list_price, net_price, start_date, end_date, currency_code, tax_id, created_date, updated_date, created_by, updated_by)
  VALUES(302, 1, 102,200.00, null, 200.00,CURRENT_TIMESTAMP,null,'USD',null,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);

INSERT INTO  part_attribute (id, part_id, attribute_code,attribute_value,attribute_uom)
  VALUES(401, 101,'attributecode','attributevalue','standard');
  
INSERT INTO  part_attribute (id, part_id, attribute_code,attribute_value,attribute_uom)
  VALUES(402, 102,'attributecode1','attributevalue','other');

INSERT INTO  part_kit (id, part_id, tenant_id,price_method, kit_type, is_active, start_date, end_date, created_date, updated_date, created_by, updated_by)
  VALUES(501, 101,961, 'Kit Level','Standard', 'Y', null,null,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
  
INSERT INTO  part_kit (id, part_id, tenant_id,price_method, kit_type, is_active, start_date, end_date, created_date, updated_date, created_by, updated_by)
  VALUES(502, 102, 961, 'Kit Level','Standard', 'Y', null,null,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
  
INSERT INTO  part_kit_item (id, part_id, part_kit_id,part_qty)
  VALUES(601, 101,501,3);

INSERT INTO  part_kit_item (id, part_id, part_kit_id,part_qty)
  VALUES(602, 102,501,3);
    
INSERT INTO  picklist (id, picklist_code, picklist_type, is_active,be_id,tenant_id,picklist_comments,created_date, updated_date, created_by, updated_by)
  VALUES(701, 'pickListcode', 'Standard', 'Y', 961,961,'picklistcomments',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
  
INSERT INTO  picklist (id, picklist_code, picklist_type, is_active,be_id,tenant_id,picklist_comments,created_date, updated_date, created_by, updated_by)
  VALUES(702, 'pickListcode', 'Standard', 'Y', 961,961,'picklistcomments',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
  
INSERT INTO  picklist_item (id,part_id, picklist_id,part_qty)
  VALUES(801,101, 701,3);
 
INSERT INTO  picklist_item (id, part_id,picklist_id,part_qty)
  VALUES(802,101, 702,3);
  
  INSERT INTO entity_address(id) VALUES(1);
  
  INSERT INTO business_entity_intl(id, be_id) VALUES(101, 961);
  INSERT INTO role(id, role_name,description,code) VALUES(1, 'name1','desc1','code1');
  
   INSERT INTO role(id, role_name,description,code,active_indicator) VALUES(2,'name2','desc2','code2','Y');
   
   INSERT INTO users (id,email,name,last_login ,active,email_validated,referral_id)
  VALUES (1,'suryamanem@m-ize.com','surya prakash','2013-11-19 00:00:00',1,1,null);	

  INSERT INTO users (id,email,name,last_login ,active,email_validated,referral_id)
  VALUES (2,'shiva@m-ize.com','Shiva Kumar','2013-10-19 00:00:00',1,1,null);	

  INSERT INTO users_to_be (user_id, be_id, job_role) VALUES (1, 961, 'CEO1');	
  
  INSERT INTO users_to_be (user_id, be_id, job_role) VALUES (2, 962, 'CEO2');	

  
  INSERT INTO user_profile(profile_name,first_name,last_name,birth_day,gender,photo_link,user_id,phone_mobile,phone_home,phone_work,email_opt_out,timezone,prompt_app_rating)
  VALUES ('surya prakash','surya','prakash',null,0,null,1,9492418417,null,null,'Y','GMT+0','Y'); 
  
  INSERT INTO users_to_brand(id,user_id,brand_id,created_date,updated_date,created_by,updated_by,active_indicator) VALUES(1,1,1,NULL,NULL,NULL,NULL,'Y'); 
  INSERT INTO users_to_brand(id,user_id,brand_id,created_date,updated_date,created_by,updated_by,active_indicator) VALUES(2,1,2,NULL,NULL,NULL,NULL,'Y'); 
  INSERT INTO users_to_brand(id,user_id,brand_id,created_date,updated_date,created_by,updated_by,active_indicator) VALUES(3,1,3,NULL,NULL,NULL,NULL,'N'); 
  INSERT INTO users_to_brand(id,user_id,brand_id,created_date,updated_date,created_by,updated_by,active_indicator) VALUES(4,2,3,NULL,NULL,NULL,NULL,'Y'); 
  
 
  INSERT INTO business_entity_brand(id,be_id,brand_id,is_active) VALUES(1,961,1,'Y');
  INSERT INTO business_entity_brand(id,be_id,brand_id,is_active) VALUES(2,961,2,'Y');
  INSERT INTO business_entity_brand(id,be_id,brand_id,is_active) VALUES(3,962,3,'Y');
  
  INSERT INTO role(id, role_name,description,code,active_indicator) VALUES(3, 'name1','desc1','code1','N');
  INSERT INTO role(id, role_name,description,code,active_indicator) VALUES(4,'name2','desc2','code2','Y');
  
    INSERT INTO work_queue (id ,code, name, description, created_by, updated_by, created_date, updated_date,is_active,tenant_id) 
    values (1,'SR_WORQUEUE','Support request workqueue','Support request workqueue',1,1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'Y',961);
  INSERT INTO work_queue (id ,code, name, description, created_by, updated_by, created_date, updated_date,is_active,tenant_id) 
    values (2,'CLAIM_WORKQUEUE','CLAIM REQUEST WORKQUEUE','CLAIM REQUEST WORKQUEUE',1,1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'N',961);
  INSERT INTO work_queue (id ,code, name, description, created_by, updated_by, created_date, updated_date,is_active,tenant_id) 
    values (3,'PARTS_ORDER_WORKQUEUE','PARTS ORDER REQUEST WORKQUEUE','PARTS ORDER REQUEST WORKQUEUE',1,1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'Y',961);

  INSERT INTO work_queue_auth (Id,work_queue_id,auth_id,auth_type,created_by,updated_by,created_date,updated_date) 
    values (1,1,1,'User',1,1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
  INSERT INTO work_queue_auth (Id,work_queue_id,auth_id,auth_type,created_by,updated_by,created_date,updated_date) 
    values (2,1,961,'BUSINESS_ENTITY',1,1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
  INSERT INTO work_queue_auth (Id,work_queue_id,auth_id,auth_type,created_by,updated_by,created_date,updated_date) 
    values (3,1,1,'GROUP',1,1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);