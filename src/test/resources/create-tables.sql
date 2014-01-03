drop table if exists users;
CREATE TABLE users ( 
	id integer primary key auto_increment  not null,
		email          	varchar(255) NULL,
		name           	varchar(255) NULL,
		last_login     	timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
		active         	tinyint(1) NULL,
		email_validated tinyint(1) NULL,
		referral_id    	bigint(20) NULL,
        PRIMARY KEY (id) 
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
    id               	bigint(20) AUTO_INCREMENT NOT NULL,
    user_id          	bigint(20) NULL,
    address_type     	varchar(20) NULL,
    address_name     	varchar(50) NULL,
    address1         	varchar(100) NULL,
    address2         	varchar(100) NULL,
    address3         	varchar(100) NULL,
    city             	varchar(100) NULL,
    state_id         	int(11) NULL,
    country_id       	int(11) NULL,
    postal_code      	varchar(11) NULL,
    created_by       	bigint(20) NULL,
    created_date     	datetime NULL,
    updated_by       	bigint(20) NULL,
    updated_date     	datetime NULL,
    entity_address_id	bigint(20) NULL,
    PRIMARY KEY(id)
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


	
drop table if exists form_template_defn;
CREATE TABLE form_template_defn ( 
	id integer primary key auto_increment  not null,
	template_defn_data    	longtext 	NULL,
	version_number		decimal(20,6)	NULL,
	start_date  datetime 	NULL,
	end_date	datetime 	NULL	
);

drop table if exists form_defn;
CREATE TABLE form_defn ( 
	id integer primary key auto_increment  not null,
	tenant_id       	bigint(20) 	NULL,
	template_defn_id    	bigint(20) 	NULL,	
	form_code   		varchar(30) 	NULL,
	form_name   		varchar(500) 	NULL,
	locale_id   		bigint(20) 	NULL,
	version_number		decimal(20,6)	NULL,	
	status_code     	varchar(30) 	NULL,
	form_defn_data    	longtext 	NULL,
	is_active 		char(1) 	NULL,
	start_date		datetime 	NULL,
	end_date		datetime 	NULL,
	created_date    	datetime 	NULL,
	updated_date    	datetime 	NULL,
	created_by      	bigint(20) 	NULL,
	updated_by      	bigint(20) 	NULL
);

ALTER TABLE form_defn
	ADD CONSTRAINT fk_templateid_defn
	FOREIGN KEY(template_defn_id)
	REFERENCES form_template_defn(id);
 
drop table if exists form_defn_audit;
CREATE TABLE form_defn_audit ( 
	id integer primary key auto_increment  not null,
	form_defn_id       	bigint(20) 	NOT NULL,
	status_code     	varchar(30) 	NULL,
	status_date		datetime 	NULL,
	status_by		bigint(20)	NULL
);

ALTER TABLE form_defn_audit
	ADD CONSTRAINT fk_formdefnid_defn
	FOREIGN KEY(form_defn_id)
	REFERENCES form_defn(id);
	
drop table if exists form_instance;
CREATE TABLE form_instance ( 
	id integer primary key auto_increment  not null,
	form_defn_id       	bigint(20) 	NOT NULL,
	form_instance_data  longtext 	NULL,	
	created_date    	datetime 	NULL,
	updated_date    	datetime 	NULL,
	created_by      	bigint(20) 	NULL,
	updated_by      	bigint(20) 	NULL
);

ALTER TABLE form_instance
	ADD CONSTRAINT fk_formid_instance
	FOREIGN KEY(form_defn_id)
	REFERENCES form_defn(id);

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
    updated_by      bigint(20) 	NULL    
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
	be_address_id	BIGINT(20)  NULL   
);

CREATE TABLE entity_address (
	id					bigint(20) 	AUTO_INCREMENT NOT NULL,
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
	email        		varchar(50) 		NULL,
	land_mark    		varchar(500) 		NULL,
	created_date    	datetime 			NULL,
	updated_date    	datetime 			NULL,
	created_by      	bigint(20) 			NULL,
    updated_by      	bigint(20) 			NULL  
	
);

CREATE TABLE business_entity_geo ( 
	id					bigint(20) 	AUTO_INCREMENT NOT NULL,
	be_address_id	BIGINT(20) NULL,
	latitude     	bigint(2000) NULL,
	longitude    	bigint(2000) NULL
	);
	
drop table if exists business_entity_brand;
CREATE TABLE business_entity_brand (
    id				bigint(20) 	AUTO_INCREMENT NOT NULL,
    be_id   		bigint(20) 			NULL,
    brand_id		bigint(20) 			NULL,
    is_active		char(1) 			NULL
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
    is_credit_onhold		char(1) 		NULL
);	

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
    phone_ext         		varchar(10) 	NULL,
    fax         		varchar(50) 		NULL,
    fax_ext         		varchar(10) 		NULL,
    email  			varchar(100) 		NULL,
    department			varchar(50) 		NULL,
);

drop table if exists entity_address_geo;
CREATE TABLE entity_address_geo ( 
    id				bigint(20) 		AUTO_INCREMENT NOT NULL,
    entity_address_id		bigint(20) 		NULL,
    latitude     		mediumtext 		NULL,
    longitude    		mediumtext 		NULL
  );
  
  CREATE TABLE brand ( 
    brand_id				bigint(20) 		AUTO_INCREMENT NOT NULL,
    brand_name    	varchar(250) NOT NULL,
    brand_type    	char(1) NULL DEFAULT 'B',
    brand_link    	varchar(250) NULL,
    created_by    	bigint(20) NULL,
    created_date  	datetime NULL,
    updated_by    	bigint(20) NULL,
    updated_date  	datetime NULL,
    brand_logo    	varchar(50) NULL,
    feedback_email	varchar(100) NULL,
    department    	varchar(50) NULL,
    registered    	char(1) NULL DEFAULT 'N',
    is_active     	char(1) NULL,
    prod_source_id	int(11) NULL
);

CREATE TABLE brand_support ( 
    brand_id         	bigint(20) NOT NULL,
    brand_support_id				bigint(20) 		AUTO_INCREMENT NOT NULL,
    support_phone    	varchar(20) NULL,
    support_email    	varchar(100) NULL,
    support_site     	varchar(250) NULL,
    support_chat     	varchar(500) NULL,
    support_phone_tf 	varchar(20) NULL,
    support_qualifier	varchar(250) NULL,
    validated_by     	varchar(100) NULL,
    validated_on     	datetime NULL,
    prodcat_id       	int(11) NULL,
    support_facebook 	varchar(250) NULL,
    support_twitter  	varchar(250) NULL,
    country_id       	int(11) NOT NULL,
    support_type     	int(11) NULL,
    data_source_type 	int(11) NULL,
    validated        	tinyint(1) NULL,
    hours_of_op      	varchar(250) NULL,
    created_by       	bigint(20) NULL,
    created_date     	datetime NULL,
    updated_by       	bigint(20) NULL,
    updated_date     	datetime NULL
);

insert into locale values(1,'Y','EN','USA','EN_USA');

INSERT INTO  business_entity(id, code, type_code, sub_type_code, name, logo, created_date, updated_date, created_by, updated_by, active_indicator)
  VALUES(961, '10C00100P', 'dealer', NULL, 'WASHINGTON AIR COMP. RENTAL', NULL, '2013-06-19 14:39:31.0', '2013-07-26 14:17:19.0', NULL, NULL, NULL);

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
  
  INSERT INTO entity_address(id) VALUES(1);
  
  INSERT INTO business_entity_intl(id, be_id) VALUES(101, 961);
  
INSERT INTO  catalog (id, tenant_id, catalog_code, catalog_type, is_active, catalog_name, created_date, updated_date, created_by, updated_by)
  VALUES(100, 961, 'TestCatalog', 'TestCatalogType', 'Y', 'TestCatalogName', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);

INSERT INTO  catalog_entry (id, catalog_id, item_code, is_active, is_default, order_sequence, created_date, updated_date, created_by, updated_by)
  VALUES(102, 100, 'ItemCode', 'Y', 'N', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);

  
INSERT INTO form_template_defn (id, template_defn_data, version_number, start_date, end_date)
	VALUES (1,'{{#each searchFileds}} <input type="text" /> {{/each}}', 1.0, '2013-11-19 00:00:00', '2014-11-18 00:00:00');
	
INSERT INTO form_defn (id, tenant_id, template_defn_id, form_code, form_name, locale_id, version_number, status_code, form_defn_data, is_active, start_date, end_date, created_date, updated_date, created_by, updated_by)
	VALUES (1,961, 1, 'Form Code', 'Form Name', 1, 1.0, 'DRAFT', 'Form Def data', 'Y', '2014-11-19 00:00:00', '2014-11-18 00:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 779, 779);

	  
  INSERT INTO users (id,email,name,last_login ,active,email_validated,referral_id)
  VALUES (1,'suryamanem@m-ize.com','surya prakash','2013-11-19 00:00:00',1,1,null);	

  INSERT INTO users (id,email,name,last_login ,active,email_validated,referral_id)
  VALUES (2,'shiva@m-ize.com','Shiva Kumar','2013-10-19 00:00:00',1,1,null);	

  INSERT INTO user_profile(profile_name,first_name,last_name,birth_day,gender,photo_link,user_id,phone_mobile,phone_home,phone_work,email_opt_out,timezone,prompt_app_rating)
  VALUES ('surya prakash','surya','prakash',null,0,null,1,9492418417,null,null,'Y','GMT+0','Y'); 
  
  INSERT INTO brand VALUES (1,'m-ize',NULL,'http://www.m-ize.com/',NULL,NULL,NULL,NULL,'m-ize.png','support@m-ize.com',NULL,NULL,NULL);
  INSERT INTO brand VALUES (2,'Bose',NULL,'http://www.bose.com',NULL,NULL,NULL,NULL,'bose.png','',NULL,NULL,NULL);
  INSERT INTO brand VALUES (3,'Samsung',NULL,'http://www.samsung.com',NULL,NULL,NULL,NULL,'samsung.png','',NULL,NULL,NULL);
  
  INSERT INTO users_to_brand(id,user_id,brand_id,created_date,updated_date,created_by,updated_by,active_indicator) VALUES(1,1,1,NULL,NULL,NULL,NULL,'Y'); 
  INSERT INTO users_to_brand(id,user_id,brand_id,created_date,updated_date,created_by,updated_by,active_indicator) VALUES(2,1,2,NULL,NULL,NULL,NULL,'Y'); 
  INSERT INTO users_to_brand(id,user_id,brand_id,created_date,updated_date,created_by,updated_by,active_indicator) VALUES(3,1,3,NULL,NULL,NULL,NULL,'N'); 
  INSERT INTO users_to_brand(id,user_id,brand_id,created_date,updated_date,created_by,updated_by,active_indicator) VALUES(4,2,3,NULL,NULL,NULL,NULL,'Y'); 
  
 
  INSERT INTO business_entity_brand(id,be_id,brand_id,is_active) VALUES(1,961,1,'Y');
  INSERT INTO business_entity_brand(id,be_id,brand_id,is_active) VALUES(2,961,2,'Y');
  INSERT INTO business_entity_brand(id,be_id,brand_id,is_active) VALUES(3,962,3,'Y');