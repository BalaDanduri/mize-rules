
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

CREATE TABLE user_address ( 
	id          	integer AUTO_INCREMENT NOT NULL,
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


CREATE TABLE parts_order_amount (
	id integer primary key auto_increment  not null,
	requested_quantity	 	 DECIMAL(20,6),
	requested_amount		 DECIMAL(20,6),
	discount_amount		 	 DECIMAL(20,6),
	handling_amount		 	 DECIMAL(20,6),
	shipping_amount			 DECIMAL(20,6),
	tax_amount		 		 DECIMAL(20,6),
	miscellaneous_amount	 DECIMAL(20,6),
	adjusted_amount			 DECIMAL(20,6),
	total_amount		 	 DECIMAL(20,6),
	PRIMARY KEY (id)
);

CREATE TABLE parts_order (
	id integer primary key auto_increment  not null,
	tenant_id			integer	NULL,
	order_code			varchar(50) 	NULL,	
	order_type			varchar(50) 	NULL,
	request_type		varchar(50) 	NULL,
	order_status		varchar(50) 	NULL,
	locale_id			integer	NULL,
	currency_code		varchar(50) 	NULL,
	order_reference		varchar(100) 	NULL,	
	sales_person		varchar(100) 	NULL,
	ship_complete   	char(1)         NULL,
	amount_id			integer	NULL,
	created_date 		datetime 	NULL,
	updated_date 		datetime 	NULL,
	created_by 			integer	NULL,
	updated_by 			integer	NULL,
	PRIMARY KEY (id)
);
	
ALTER TABLE parts_order
	ADD CONSTRAINT po_amountid_fk
	FOREIGN KEY(amount_id)
	REFERENCES parts_order_amount(id);


CREATE TABLE parts_order_requester (
	id 						integer primary key auto_increment  not null,
	order_id				integer NULL,
	requester_be_id			integer	NULL,
	requester_address_id	integer	NULL,
	PRIMARY KEY (id)
);
			
ALTER TABLE parts_order_requester
	ADD CONSTRAINT por_orderid_fk
	FOREIGN KEY(order_id)
	REFERENCES parts_order(id);
		
	
	
CREATE TABLE parts_order_part (
	id 						integer primary key auto_increment  not null,
	order_id				integer NULL,
	part_id					integer NULL,
	part_type				varchar(50) 		NULL,	
	part_code				varchar(100) 		NULL,   
	part_serial				varchar(100) 		NULL,
	part_name				varchar(250) 		NULL,
	part_description		varchar(500) 		NULL,
	part_uom				varchar(50) 		NULL,   
	part_status				varchar(50) 		NULL,
	part_weight				DECIMAL(20,6),
	prod_id					integer NULL,
	model           		varchar(50) 		NULL,
    prod_srl_no         	varchar(200) 		NULL,
	amount_id				integer NULL,
	created_date 			datetime 		NULL,
	updated_date 			datetime 		NULL,
	created_by 				integer NULL,
	updated_by 				integer NULL,
	PRIMARY KEY (id)
);

ALTER TABLE parts_order_part
	ADD CONSTRAINT pop_orderid_fk
	FOREIGN KEY(order_id)
	REFERENCES parts_order(id);
	
ALTER TABLE parts_order_part
	ADD CONSTRAINT pop_amountid_fk
	FOREIGN KEY(amount_id)
	REFERENCES parts_order_amount(id);
	

CREATE TABLE parts_order_audit ( 
	id 						integer primary key auto_increment  not null,
	order_id       			integer NULL,
	status_code     		varchar(30) 	NULL,
	status_date				datetime 	NULL,
	status_by				integer	NULL,
    PRIMARY KEY (id)
);

ALTER TABLE parts_order_audit
	ADD CONSTRAINT poa_orderid_fk
	FOREIGN KEY(order_id)
	REFERENCES parts_order(id);
	
	
CREATE TABLE parts_order_attach ( 
	id 					integer primary key auto_increment  not null,
	order_id       		integer NULL,
	type_code     		varchar(30) 	NULL,
	attach_name			varchar(250) 	NULL,
	attach_url			varchar(256) 	NULL,
    PRIMARY KEY (id)
);

ALTER TABLE parts_order_attach
	ADD CONSTRAINT poattach_orderid_fk
	FOREIGN KEY(order_id)
	REFERENCES parts_order(id);
	

CREATE TABLE parts_order_comment ( 
	id 					integer primary key auto_increment  not null,
	order_id       		integer NULL,
	comment_type     	varchar(50) 	NULL,
	comments     		varchar(5000) 	NULL,
    PRIMARY KEY (id)
);

ALTER TABLE parts_order_comment
	ADD CONSTRAINT poc_orderid_fk
	FOREIGN KEY(order_id)
	REFERENCES parts_order(id);
	

	
CREATE TABLE parts_order_shipment (
	id 						integer primary key auto_increment  not null,
	order_id				integer NULL,
	shipment_be_id 			integer	NULL,
	shipment_address_id		integer	NULL,
	shipment_method			varchar(50) 	NULL,
	shipment_priority		varchar(50) 	NULL,
	shipment_carrier		varchar(50) 	NULL,	
	estimated_ship_date		datetime 	NULL,
	drop_ship				char(1)		NULL,
	PRIMARY KEY (id)
);
			
ALTER TABLE parts_order_shipment
	ADD CONSTRAINT pos_orderid_fk
	FOREIGN KEY(order_id)
	REFERENCES parts_order(id);
	

CREATE TABLE parts_order_payment (
	id 						integer primary key auto_increment  not null,
	order_id				integer NULL,
	payee_be_id 			integer	NULL,
	payee_address_id		integer	NULL,
	payment_method     		varchar(50) NULL,
	PRIMARY KEY (id)
);
		
ALTER TABLE parts_order_payment
	ADD CONSTRAINT popayee_orderid_fk
	FOREIGN KEY(order_id)
	REFERENCES parts_order(id);
	

	

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

drop table if exists catalog_entry;
create table catalog_entry
(
	id integer primary key auto_increment  not null,
	catalog_id integer,
 	item_code varchar(30), 	
 	is_active char(1) default 'Y',
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
 	item_desc varchar(500),
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
	
drop table if exists brand;
CREATE TABLE brand (
        brand_id         bigint(20) NOT NULL,
        brand_name         varchar(250) NOT NULL,
        brand_type         bigint(11) NULL,
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

INSERT INTO brand(brand_id,brand_name,brand_type,brand_link,created_by,created_date,updated_by,updated_date,feedback_email,department,registered,is_active)
 	VALUES(4,'Bose',1,'bose.com',null,null,null,null,'feedback_email','Electronics','Y','Y');

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

CREATE TABLE business_entity_intl ( 
    id         bigint(20) 	AUTO_INCREMENT NOT NULL,
    be_id      bigint(20) 	NOT NULL,   
    locale_id  bigint(20) 	NULL,
    be_name    varchar(250) NULL,
    be_description  varchar(500) NULL,
    be_first_name varchar(100) NULL,
    be_last_name varchar(100) NULL,
    be_middle_initial varchar(50) NULL
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
	be_address_id	BIGINT(20)  NULL,   
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
    updated_by      	bigint(20) 			NULL,  
	
);

drop table if exists entity_address_phone;
CREATE TABLE entity_address_phone (
	id			bigint(20) 		AUTO_INCREMENT NOT NULL,
	entity_address_id    	bigint(20) 		NULL,
	phone_type      	varchar(50) 		NULL,
	phone_value      	varchar(50) 		NULL,
	phone_ext      		varchar(10) 		NULL,
	PRIMARY KEY (id)
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
    url          		varchar(256) 		NULL,
    tool_tip_logo		varchar(100) 		NULL,
    icon         		varchar(100) 		NULL,
    hours_of_op  		varchar(250) 		NULL,
    is_credit_onhold		char(1) 		NULL,
);	



drop table if exists business_entity_contact;
CREATE TABLE business_entity_contact (
    id				bigint(20) 		AUTO_INCREMENT NOT NULL,
    be_id   			bigint(20) 		NULL,    
    is_primary			char(1) 		NULL,
    contact_type			varchar(100) 		NULL,
    first_name			varchar(100) 		NULL,
    last_name			varchar(100) 		NULL,
    middle_initial		varchar(50) 		NULL,
    phone         		varchar(50) 		NULL,
    phone_ext         		varchar(10) 		NULL,
    fax         		varchar(50) 		NULL,
    fax_ext         		varchar(10) 		NULL,
    email  			varchar(100) 		NULL,
    department			varchar(50) 		NULL,
);

INSERT INTO business_entity_contact (be_id, is_primary, first_name, last_name, middle_initial, phone, phone_ext, fax, fax_ext, email, department)
 	VALUES(961,'Y','firstName','lastName','middleIntial','90909090','90909090','909090','90909','test@test.com','departmant');


drop table if exists entity_address_geo;
CREATE TABLE entity_address_geo ( 
    id				bigint(20) 		AUTO_INCREMENT NOT NULL,
    entity_address_id		bigint(20) 		NULL,
    latitude     		mediumtext 		NULL,
    longitude    		mediumtext 		NULL,
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
 	part_description varchar(500),
  
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


drop table if exists service_entity;
create table service_entity
(
	id integer primary key auto_increment not null,
  	tenant_id integer,
  	entity_code varchar(50),
  	entity_status varchar(50),
  	locale_id integer,
  	currency_code varchar(50),
  	entity_reference varchar(50),
  	part_amount_id integer,
  	labor_amount_id integer,
  	other_amount_id integer,
  	total_amount_id integer,
  	created_date timestamp,
  	updated_date timestamp,
  	created_by integer,
  	updated_by integer,
  	service_type varchar(50),
  	sales_person varchar(50),
  	ship_complete char(1),
  	process_id varchar(50),
 );
 
 drop table if exists service_entity_address;
create table service_entity_address
(
	id integer primary key auto_increment not null,
  	address_type varchar(100),
 	address_1 varchar(100),
 	address_2 varchar(100),
  	address_3 varchar(100),
 	city varchar(50),
  	zip varchar(10),
  	zip_ext varchar(10),
  	county varchar(100),
  	state_id integer,
  	country_id integer,
  	phone_1 varchar(50),
  	phone_2 varchar(50),
  	email varchar(50),
  	fax varchar(50),
  	
);

drop table if exists service_entity_amount;
CREATE TABLE service_entity_amount (
        id integer primary key auto_increment not null,
        requested_quantity   DECIMAL(20,6)         null,
        adjusted_quantity    DECIMAL(20,6)      null,
        requested_amount     DECIMAL(20,6)      null,
        adjusted_amount      DECIMAL(20,6)      null,
        total_amount         DECIMAL(20,6)      null,
        discount_amount      DECIMAL(20,6)      null,
        handling_amount      DECIMAL(20,6)      null,
        freight_amount       DECIMAL(20,6)      null,
        tax_amount         	 DECIMAL(20,6)      null,
        miscellaneous_amount DECIMAL(20,6)      null,
 );
 
 
 drop table if exists service_entity_attach;
 CREATE TABLE service_entity_attach (
        id integer primary key auto_increment not null,
        entity_id  integer not null,
        type_code  varchar(30) null,
        attach_name varchar(30) null,
        attach_url varchar(256) null,
 );

drop table if exists service_entity_audit;
create table service_entity_audit
(
	id integer primary key auto_increment not null,
	entity_id integer,
  	status_code varchar2(30),
  	status_date timestamp,
  	status_by integer,
);

drop table if exists service_entity_notes;
CREATE TABLE service_entity_notes (
        id integer primary key auto_increment not null,
        entity_id  integer not null,
        notes  varchar(5000) null,
        note_type varchar(50) null,
);

drop table if exists service_entity_payment;
CREATE TABLE service_entity_payment (
     id integer primary key auto_increment not null,
     entity_id  integer  not null,
     payer_id   integer  not null,
     address_id integer  not null,
               
 );


drop table if exists service_entity_provider;
create table service_entity_provider
(
	id integer primary key auto_increment not null,
	entity_id integer,
  	provider_id integer,
  	address_id integer,
);

drop table if exists service_entity_request;
CREATE TABLE service_entity_request (
        id integer primary key auto_increment not null,
        entity_id integer,
        request_type varchar(50) null,
        failure_date   timestamp  null,
        repair_date   timestamp  null,
        prod_id   integer    null,
        prod_regn_id  integer    null,
        contract_id   integer    null,
        repair_site_code  varchar(100)  null,
        coverage_id   integer    null,
        coverage_code varchar(100)  null,
        coverage_descr  varchar(1000) null,
        coverage_end_date  timestamp  null,
        complaint_code   varchar(100)  null,
        complaint_description  varchar(1000) null,
        cause_code   varchar(100)  null,
        cause_description  varchar(1000) null,
        corrective_action_code  varchar(100)  null,
        corrective_action_descr  varchar(1000)  null,
        part_amount_id   integer  null,
        labor_amount_id  integer  null,
        other_amount_id  integer  null,
        total_amount_id  integer  null,
        created_date  timestamp  null,
        updated_date  timestamp  null,
        created_by  integer  null,
        updated_by  integer  null,
 );
 
 drop table if exists service_entity_request_labor;
 CREATE TABLE service_entity_request_labor (
        id  integer primary key auto_increment not null,
        request_id integer  not null,
        labor_type  varchar(50) null,
        labor_code  varchar(100) null,
        labor_description  varchar(500) null,
        amount_id  integer null,
        created_date timestamp null,
        updated_date timestamp null,
        created_by integer null,
        updated_by integer null,
 );
 
 drop table if exists service_entity_request_other;
 CREATE TABLE service_entity_request_other (
        id  integer primary key auto_increment not null,
        request_id integer  not null,
        other_charge_type  varchar(50) null,
        other_charge_code  varchar(100) null,
        other_charge_description  varchar(500) null,
        amount_id  integer null,
        created_date timestamp  null,
        updated_date timestamp  null,
        created_by integer null,
        updated_by integer null,
 );
 
 drop table if exists service_entity_request_part;
 CREATE TABLE service_entity_request_part (
        id  integer primary key auto_increment not null,
        request_id  bigint(20)  NOT NULL,
        part_type   varchar(50) NULL,
        part_code   varchar(100)  NULL,
        part_serial varchar(100)  NULL,
        part_description  varchar(500)  NULL,
        amount_id  bigint(20) NULL,
        created_date  datetime NULL,
        updated_date  datetime NULL,
        created_by    bigint(20) NULL,
        updated_by    bigint(20) NULL,
        part_uom   varchar(50)  NULL,
        part_weight DECIMAL(20,6) null,
        prod_id bigint(20) NULL,
        model varchar(50) null,
        prod_srl_no varchar(200) null,
        warehouse_code varchar(100) null,
 );
  
  drop table if exists service_entity_requester;
  CREATE TABLE service_entity_requester (
        id  integer primary key auto_increment not null,
        entity_id   bigint(20)  NOT NULL,
        requester_id bigint(20) NULL,
        address_id   bigint(20) NULL,
  );

  drop table if exists service_entity_rltn;
  CREATE TABLE service_entity_rltn (
        id  bigint(20) AUTO_INCREMENT NOT NULL,
        entity_id  bigint(20) NOT NULL,
        entity_rltn_id bigint(20) NOT NULL,
  );

  drop table if exists part_substitute;
  CREATE TABLE part_substitute (
	id 			bigint(20) 	AUTO_INCREMENT NOT NULL,
	old_part_id		bigint(20)	NOT NULL,
	new_part_id		bigint(20)	NOT NULL,
	family_code		varchar(50) 	NULL,
	substitute_date		datetime 	NULL,
	substitute_code		varchar(50) 	NULL,
	substitute_comments	varchar(1000) 	NULL,	
	created_date 		datetime 	NULL,
	updated_date 		datetime 	NULL,
	created_by 		bigint(20)	NULL,
	updated_by 		bigint(20)	NULL,	
	PRIMARY KEY (id)
);

drop table if exists prod_cat;
create table prod_cat
(
	prod_cat_id			bigint(20)	auto_increment NOT NULL,	
	prod_cat_name		varchar(100)	NULL,			
	parent_prod_cat_id	int(15)			NULL,			
	prod_cat_link		varchar(250)	NULL,			
	prod_count			int(11)			NULL,			
	is_active			tinyint(1)		NULL,			
	created_date		datetime		NULL,			
	created_by			bigint(20)		NULL,			
	updated_date		datetime		NULL,			
	updated_by			bigint(20)		NULL,			
	department			varchar(25)		NULL,			
	cat_level			int(11)			NULL,			
	display_order		int(11)			NULL,			
	order_number		int(11)			NULL,			
	searchable			tinyint(4)		NULL,			
	small_pic			varchar(50)		NULL,			
	thumb_pic			varchar(50)		NULL,			
	watched_top_10		int(11)			NULL,			
	un_cat_id			bigint(20)		NULL,			
	family_id			int(11)			NULL,			
	series_id			int(11)			NULL,			
	unit_id				bigint(20)		NULL,			
	t_id				int(11)			NULL,			
	prod_source_id		int(11)			NULL,			
	tenant_id			bigint(20)		NULL	
);

drop table if exists prod_to_cat;
create table prod_to_cat
(
	id			bigint(20)	auto_increment	NOT NULL,
	prod_id		bigint(20)	NULL,
	prod_cat_id	bigint(20)  NULL
);

drop table if exists prod;
create table prod
(
	prod_id		bigint(20)    auto_increment NOT NULL,              
	prod_name       varchar(200)   NULL,      
	prod_desc       varchar(500)   NULL,      
	upc        	varchar(20)    NULL,             
	qr_code        	varchar(100)   NULL,        
	brand_id        bigint(20)     NULL,         
	brand_name      varchar(250)   NULL,     
	prod_image      varchar(500)   NULL,     
	created_date    datetime       NULL,       
	created_by      bigint(20)     NULL,       
	updated_date    datetime       NULL,       
	updated_by      bigint(20)     NULL,       
	mfg_part_no     varchar(70)    NULL,     
	manufacturer_id bigint(20)     NULL,  
	is_active       tinyint(4)     NULL,        
	is_accessory    char(1)        NULL,        
	equivalency     varchar(30)    NULL,     
	family_id       bigint(20)     NULL,        
	user_id        	bigint(20)     NULL,          
	low_pic        	varchar(50)    NULL,         
	high_pic        varchar(50)    NULL,        
	thumb_pic       varchar(50)    NULL,       
	low_pic_size    int(11)        NULL,        
	high_pic_size   int(11)        NULL,       
	thumb_pic_size  int(11)        NULL,      
	release_date    datetime       NULL,       
	prod_updated_date datetime     NULL,  
	is_consumable   char(1)        NULL,       
	model        	varchar(50)    NULL,
	active			varchar(1)	   NULL,
	manufacturer_be_id bigint(20)  NULL,
	tenant_id		bigint(20)	   NULL 
);

drop table if exists prod_intl;
CREATE TABLE prod_intl ( 
    id         bigint(20) 	AUTO_INCREMENT NOT NULL,
    prod_id      bigint(20) 	NOT NULL,   
    locale_id  bigint(20) 	NULL,
    prod_name    varchar(250) NULL,
    prod_description  varchar(500) NULL
);

drop table if exists prod_to_source;
create table prod_to_source
(
	id				   	bigint(20) auto_increment    	NOT NULL,              
	prod_to_source_id  	varchar(50)    	NOT NULL,      
	prod_source_id     	int(11)   		NOT NULL,      
	prod_id        		bigint(20)  	NOT NULL
);

drop table if exists prod_serial;
  CREATE TABLE prod_serial (
	id 			bigint(20) 	auto_increment NOT NULL,
	tenant_id		bigint(20)	NULL,
	prod_id			bigint(20)	NOT NULL,
	prod_srl_no     varchar(200) 	NULL,
	delivery_be_id  bigint(20) 	NULL,
	delivery_date   datetime 	NULL,
	build_date		datetime 	NULL,	
	created_date 		datetime 	NULL,
	updated_date 		datetime 	NULL,
	created_by 		bigint(20)	NULL,
	updated_by 		bigint(20)	NULL,
	primary key (id)
);

  drop table if exists prod_serial_comment;
  CREATE TABLE prod_serial_comment (
	id 				bigint(20) 	auto_increment NOT NULL,
	prod_srl_id 	bigint(20)	NOT NULL,
	comment_id		bigint(20)	NOT NULL,
	created_date 	datetime 	NULL,
	updated_date 	datetime 	NULL,
	created_by 		bigint(20)	NULL,
	updated_by 		bigint(20)	NULL,	
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
	form_instance_data    		longtext 	NULL,	
	created_date    	datetime 	NULL,
	updated_date    	datetime 	NULL,
	created_by      	bigint(20) 	NULL,
	updated_by      	bigint(20) 	NULL
);

ALTER TABLE form_instance
	ADD CONSTRAINT fk_formid_instance
	FOREIGN KEY(form_defn_id)
	REFERENCES form_defn(id);



CREATE TABLE purchase_order_amount (
	id integer primary key auto_increment  not null,
	requested_amount		 DECIMAL(20,6),
	discount_amount		 	 DECIMAL(20,6),
	handling_amount		 	 DECIMAL(20,6),
	shipping_amount			 DECIMAL(20,6),
	freight_amount			 DECIMAL(20,6),
	tax_amount		 		 DECIMAL(20,6),
	miscellaneous_amount	 DECIMAL(20,6),
	adjusted_amount			 DECIMAL(20,6),
	total_amount		 	 DECIMAL(20,6),
	PRIMARY KEY (id)
);

CREATE TABLE purchase_order (
	id integer primary key auto_increment  not null,
	tenant_id			integer	NULL,
	order_number		varchar(50) 	NULL,	
	order_type			varchar(50) 	NULL,
	request_type		varchar(50) 	NULL,
	order_status		varchar(50) 	NULL,
	locale_id			integer	NULL,
	currency_code		varchar(50) 	NULL,
	order_reference		varchar(100) 	NULL,	
	sales_person		varchar(100) 	NULL,
	discount_id			integer	NULL,
	amount_id			integer	NULL,
	created_date 		datetime 	NULL,
	updated_date 		datetime 	NULL,
	created_by 			integer	NULL,
	updated_by 			integer	NULL,
	PRIMARY KEY (id)
);
	
ALTER TABLE purchase_order
	ADD CONSTRAINT pc_amountid_fk
	FOREIGN KEY(amount_id)
	REFERENCES purchase_order_amount(id);


CREATE TABLE purchase_order_requester (
	id 						integer primary key auto_increment  not null,
	order_id				integer NULL,
	requester_be_id			integer	NULL,
	requester_address_id	integer	NULL,
	PRIMARY KEY (id)
);
			
ALTER TABLE purchase_order_requester
	ADD CONSTRAINT pcr_orderid_fk
	FOREIGN KEY(order_id)
	REFERENCES purchase_order(id);
		

CREATE TABLE purchase_order_payment (
	id 						integer primary key auto_increment  not null,
	order_id				integer NULL,
	payee_be_id 			integer	NULL,
	payee_address_id		integer	NULL,          
	payment_method     		varchar(50) NULL,
	PRIMARY KEY (id)
);
		
ALTER TABLE purchase_order_payment
	ADD CONSTRAINT pcp_orderid_fk
	FOREIGN KEY(order_id)
	REFERENCES purchase_order(id);

	
CREATE TABLE purchase_order_shipment (
	id 						integer primary key auto_increment  not null,
	order_id				integer NULL,
	shipment_be_id 			integer	NULL,
	shipment_address_id		integer	NULL,     			
	shipment_method			varchar(50) 	NULL,
	shipment_priority		varchar(50) 	NULL,
	shipment_carrier		varchar(50) 	NULL,	
	estimated_ship_days		varchar(50) 	NULL,
	estimated_ship_date		datetime 	NULL,
	estimated_ship_cost		DECIMAL(20,6),
	drop_ship				char(1)		NULL,
	ship_complete			char(1)		NULL,
	PRIMARY KEY (id)
);
			
ALTER TABLE purchase_order_shipment
	ADD CONSTRAINT pcs_orderid_fk
	FOREIGN KEY(order_id)
	REFERENCES purchase_order(id);
	
	
CREATE TABLE purchase_order_item (
	id 						integer primary key auto_increment  not null,
	order_id				integer NULL,
	item_id					integer NULL,                       
	item_type				varchar(50) 		NULL,	
	item_number				varchar(100) 		NULL,   
	item_serial				varchar(100) 		NULL,
	item_name				varchar(250) 		NULL,
	item_description		varchar(500) 		NULL,
	item_uom				varchar(50) 		NULL,   
	item_status				varchar(50) 		NULL,
	item_price_code			varchar(50) 		NULL,
	item_weight				DECIMAL(20,6),	
	item_prod_model         varchar(50) 		NULL,
    item_prod_srl_no        varchar(200) 		NULL,
	requested_quantity		DECIMAL(20,6),
	backorder_quantity		DECIMAL(20,6),
    amount_id				integer NULL,
	created_date 			datetime 		NULL,
	updated_date 			datetime 		NULL,
	created_by 				integer NULL,
	updated_by 				integer NULL,
	PRIMARY KEY (id)
);

ALTER TABLE purchase_order_item
	ADD CONSTRAINT poi_orderid_fk
	FOREIGN KEY(order_id)
	REFERENCES purchase_order(id);
	
ALTER TABLE purchase_order_item
	ADD CONSTRAINT poi_amountid_fk
	FOREIGN KEY(amount_id)
	REFERENCES purchase_order_amount(id);
	

CREATE TABLE purchase_order_audit ( 
	id 						integer primary key auto_increment  not null,
	order_id       			integer NULL,
	status_code     		varchar(30) 	NULL,
	status_date				datetime 	NULL,
	status_by				integer	NULL,
    PRIMARY KEY (id)
);

ALTER TABLE purchase_order_audit
	ADD CONSTRAINT pca_orderid_fk
	FOREIGN KEY(order_id)
	REFERENCES purchase_order(id);
	
	
CREATE TABLE purchase_order_attach (
	id 					integer primary key auto_increment  not null,
	order_id       		integer NULL,
	attach_id			integer NULL,
    PRIMARY KEY (id)
);

ALTER TABLE purchase_order_attach
	ADD CONSTRAINT pcattach_orderid_fk
	FOREIGN KEY(order_id)
	REFERENCES purchase_order(id);
	

CREATE TABLE purchase_order_comment ( 
	id 					integer primary key auto_increment  not null,
	order_id       		integer NULL,
	comment_id     		integer NULL,	
    PRIMARY KEY (id)
);

ALTER TABLE purchase_order_comment
	ADD CONSTRAINT pcc_orderid_fk
	FOREIGN KEY(order_id)
	REFERENCES purchase_order(id);
	
CREATE TABLE purchase_order_message ( 
	id 					integer primary key auto_increment  not null,
	order_id       		integer NULL,
	error_message_id    integer NULL,	
    PRIMARY KEY (id)
);

ALTER TABLE purchase_order_message
	ADD CONSTRAINT pcm_orderid_fk
	FOREIGN KEY(order_id)
	REFERENCES purchase_order(id);

	
CREATE TABLE purchase_order_item_warehouse (
	id 						integer primary key auto_increment  not null,
	order_item_id			integer NULL,	
	warehouse_code			varchar(100) 	NULL,
	warehouse_name			varchar(500) 	NULL,
	warehouse_address_id	integer NULL,	          
	warehouse_item_status	varchar(100) 	NULL,	
	available_quantity		DECIMAL(20,6),
	backorder_quantity		DECIMAL(20,6),
	estimated_ship_date		datetime 	NULL,
	estimated_ship_cost		DECIMAL(20,6),	
	PRIMARY KEY (id)
);
	
ALTER TABLE purchase_order_item_warehouse
	ADD CONSTRAINT pciw_itemid_fk
	FOREIGN KEY(order_item_id)
	REFERENCES purchase_order_item(id);

	
CREATE TABLE purchase_order_ship_package (
	id 						integer primary key auto_increment  not null,
	order_shipment_id			integer NULL,	
	package_number			varchar(50) 	NULL,
	package_weight			DECIMAL(20,6),
	shipment_method			varchar(50) 	NULL,
	shipment_priority		varchar(50) 	NULL,
	shipment_carrier		varchar(50) 	NULL,	
	shipment_date			datetime 	NULL,
	tracking_number			varchar(50) 	NULL,
	shipment_status			varchar(50) 	NULL,
	shipment_label			varchar(200) 	NULL,
	shipment_link_info		varchar(200) 	NULL,
	warehouse_code			varchar(100) 	NULL,
	warehouse_name			varchar(500) 	NULL,
	warehouse_item_status	varchar(100) 	NULL,	
	handling_amount			DECIMAL(20,6),	
	freight_amount			DECIMAL(20,6),
	total_amount			DECIMAL(20,6),
	created_date 			datetime 	NULL,
	updated_date 			datetime 	NULL,
	created_by 				integer	NULL,
	updated_by 				integer	NULL,
	PRIMARY KEY (id)
);
	
ALTER TABLE purchase_order_ship_package
	ADD CONSTRAINT pcsp_shipid_fk
	FOREIGN KEY(order_shipment_id)
	REFERENCES purchase_order_shipment(id);
	
CREATE TABLE purchase_order_item_status (
	id 						integer primary key auto_increment  not null,
	ship_package_id			integer NULL,	
	order_item_id			integer NULL,	
	item_quantity			DECIMAL(20,6),	
	item_status				varchar(50) 	NULL,
	PRIMARY KEY (id)
);
	
ALTER TABLE purchase_order_item_status
	ADD CONSTRAINT pcsi_packageid_fk
	FOREIGN KEY(ship_package_id)
	REFERENCES purchase_order_ship_package(id);	
	
ALTER TABLE purchase_order_item_status
	ADD CONSTRAINT pcsi_itemid_fk
	FOREIGN KEY(order_item_id)
	REFERENCES purchase_order_item(id);
	
	
CREATE TABLE entity_attachment ( 
	id           		bigint(20) 		AUTO_INCREMENT NOT NULL,	
	attachment_type 	varchar(50) 		NULL,
	attachment_name     varchar(200) 		NULL,
    attachment_url		varchar(256) 		NULL,
    created_date    	datetime 		NULL,
	updated_date    	datetime 		NULL,
	created_by      	bigint(20) 		NULL,
    updated_by      	bigint(20) 		NULL,          
    PRIMARY KEY (id)
);

CREATE TABLE entity_error_message ( 
	id           			bigint(20) 		AUTO_INCREMENT NOT NULL,	
	message_severity     	bigint(20) 		NULL,
	message_field			varchar(250) 		NULL,
	message_code			varchar(100) 		NULL,
	message_type			varchar(100) 		NULL,
	short_description		varchar(250) 		NULL,
	long_description		varchar(500) 		NULL,
    created_date    		datetime 		NULL,
	updated_date    		datetime 		NULL,
	created_by      		bigint(20) 		NULL,
    updated_by      		bigint(20) 		NULL,          
    PRIMARY KEY (id)
);

drop table if exists prod_name_intl;
create table prod_name_intl
(
	id integer primary key auto_increment  not null,
    locale_id integer ,
    prod_id integer ,
 	prod_name varchar(250),
 	prod_desc varchar(500),
  
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
  VALUES(10799, 961, NULL, 1, NULL, '12529 PARKLAWN DR.', NULL, NULL, '20852', NULL, 'ROCKVILLE', NULL, 20, 1, '3012305800', NULL, NULL, '3012305830', NULL, NULL, NULL, NULL, NULL,10799);
  
INSERT INTO business_entity_brand(be_id, brand_id, is_active) VALUES (961, 1, 'Y');

INSERT INTO business_entity_attribute(be_id, url, tool_tip_logo, icon, hours_of_op, is_credit_onhold) VALUES (961,'url','tooltiplogo','icon','24*7','Y');


  
INSERT INTO  catalog (id, tenant_id, catalog_code, catalog_type, is_active, created_date, updated_date, created_by, updated_by)
  VALUES(100, 961, 'TestCatalog', 'TestCatalogType', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
  
INSERT INTO  catalog_entry (id, catalog_id, item_code, is_active, created_date, updated_date, created_by, updated_by)
  VALUES(102, 100, 'ItemCode', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
  
  
INSERT INTO  part (id, tenant_id, part_code, part_type, is_active,is_kit,is_serialized,is_returnable,uom, created_date, updated_date, created_by, updated_by)
  VALUES(101, 961, 'partCode','standard', 'Y', 'N','N','N',null,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO  part (id, tenant_id, part_code, part_type, is_active,is_kit,is_serialized,is_returnable,uom, created_date, updated_date, created_by, updated_by)
  VALUES(102, 961, 'partCode1','standard', 'Y', 'N','N','N',null,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
  
INSERT INTO  part_intl (id, locale_id, part_id, part_name, part_description)
  VALUES(201, 1, 101,'partname', 'partdescription');
INSERT INTO  part_intl (id, locale_id, part_id, part_name, part_description)
  VALUES(202, 1, 102,'partname', 'partdescription');
  
INSERT INTO  part_price (id, country_id, part_id, unit_price, list_price, net_price, start_date, end_date, currency_code, tax_id, created_date, updated_date, created_by, updated_by)
  VALUES(301, 1, 101,200.00, null, 200.00,CURRENT_TIMESTAMP,null,'USD',null,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);

INSERT INTO  part_price (id, country_id, part_id, unit_price, list_price, net_price, start_date, end_date, currency_code, tax_id, created_date, updated_date, created_by, updated_by)
  VALUES(302, 1, 102,200.00, null, 200.00,CURRENT_TIMESTAMP,null,'USD',null,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);

INSERT INTO  part_attribute (id, part_id, attribute_code,attribute_value,attribute_uom)
  VALUES(401, 101,'attributecode','attributevalue','standard');
  
INSERT INTO  part_attribute (id, part_id, attribute_code,attribute_value,attribute_uom)
  VALUES(402, 102,'attributecode1','attributevalue','other');

INSERT INTO  part_kit (id, part_id,price_method, kit_type, is_active, start_date, end_date, created_date, updated_date, created_by, updated_by)
  VALUES(501, 101, 'Kit Level','Standard', 'Y', null,null,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
  
INSERT INTO  part_kit (id, part_id,price_method, kit_type, is_active, start_date, end_date, created_date, updated_date, created_by, updated_by)
  VALUES(502, 102, 'Kit Level','Standard', 'Y', null,null,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
  
INSERT INTO  part_kit_item (id, part_id, part_kit_id,part_qty)
  VALUES(601, 101,501,3);

INSERT INTO  part_kit_item (id, part_id, part_kit_id,part_qty)
  VALUES(602, 102,501,3);
    
INSERT INTO  picklist (id, picklist_code, picklist_type, is_active,be_id,tenant_id,picklist_comments,created_date, updated_date, created_by, updated_by)
  VALUES(701, 'pickListcode', 'Standard', 'Y', 961,null,'picklistcomments',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
  
INSERT INTO  picklist (id, picklist_code, picklist_type, is_active,be_id,tenant_id,picklist_comments,created_date, updated_date, created_by, updated_by)
  VALUES(702, 'pickListcode', 'Standard', 'Y', 961,null,'picklistcomments',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
  
INSERT INTO  picklist_item (id,part_id, picklist_id,part_qty)
  VALUES(801,101, 701,3);
 
INSERT INTO  picklist_item (id, part_id,picklist_id,part_qty)
  VALUES(802,101, 702,3);
  
INSERT INTO service_entity (id, tenant_id, entity_code, entity_status, locale_id, currency_code, entity_reference, part_amount_id, labor_amount_id, other_amount_id, total_amount_id, created_date, updated_date, created_by, updated_by, service_type, sales_person, ship_complete, process_id) 
  VALUES (201, 961, 'entityCode', 'Draft', 1, 'USA', 'entity_reference' , 203, 204, 205, 206, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null, null, 'serviceType', 'Sales', 'Y', 1);
  
INSERT INTO service_entity_address (id, address_type, address_1, address_2, address_3, zip, zip_ext, city,county, state_id, country_id, phone_1, phone_2, email, fax)
  VALUES(101 ,'address_type' ,'address_1' ,'address_2' ,'address_3' ,'50000' ,'500000' ,'albama' ,'US' ,1 ,1 ,'456543456' ,'456543456' ,'raghu@gmail.com' ,'45454545');

 INSERT INTO service_entity_amount (id, requested_quantity, adjusted_quantity, requested_amount, adjusted_amount, total_amount, discount_amount, handling_amount, freight_amount, tax_amount, miscellaneous_amount)
  VALUES(2086, 20, 20, 300, 301 ,301, 303, 304, 305, 306, 307);  
  
 INSERT INTO service_entity_attach(id, entity_id, type_code, attach_name, attach_url)
 	VALUES(35, 201, null, 'upload', 'bose.jpg');

 INSERT INTO service_entity_audit (id, entity_id, status_code, status_date, status_by)
  VALUES(801, 201, 'status_code', CURRENT_TIMESTAMP, 801);
  
 INSERT INTO service_entity_notes(id, entity_id, notes, note_type)
   VALUES(301, 201, 'Notes1','noteType');
   
 INSERT INTO service_entity_payment(id, entity_id, payer_id, address_id)
   VALUES(401, 201, 2, 101);
   
 INSERT INTO service_entity_provider(id, entity_id, provider_id, address_id)
  VALUES(401, 201, 2, 101);
  
INSERT INTO service_entity_request(id, entity_id, request_type, failure_date, repair_date,prod_id,prod_regn_id, contract_id, repair_site_code, coverage_id, coverage_code, coverage_descr, coverage_end_date, complaint_code, complaint_description, cause_code, cause_description, corrective_action_code, corrective_action_descr, part_amount_id, labor_amount_id, other_amount_id, total_amount_id, created_date, updated_date, created_by, updated_by)
   VALUES(101, 201,'Warranty',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,100,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,null,203,204,205,206,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,NULL,NULL);
   
INSERT INTO service_entity_request_labor(id,request_id, labor_type, labor_code, labor_description, amount_id, created_date, updated_date, created_by, updated_by)
  VALUES(201,201,'hour1','L001',null,120,current_timestamp,current_timestamp,null,null);
  
INSERT INTO service_entity_request_other(id,request_id, other_charge_type, other_charge_code, other_charge_description, amount_id, created_date, updated_date, created_by, updated_by)
  VALUES(201,201,'other1123','L001',null,120,current_timestamp,current_timestamp,null,null);
  
 INSERT INTO service_entity_request_part(id, request_id, part_type, part_code, part_serial, part_description,amount_id, created_date, updated_date, created_by, updated_by, part_uom,part_weight,prod_id,model,prod_srl_no,warehouse_code)
   VALUES(1001,201,'part1123','L001',111,null,115,current_timestamp,current_timestamp,null,null,null,null,null,null,null,null);
   
 INSERT INTO service_entity_requester(id, entity_id, requester_id, address_id)
   VALUES(1001,201,101,22);
   
 INSERT INTO service_entity_rltn(id, entity_id, entity_rltn_id)
 VALUES(1001,201,33);
  INSERT INTO entity_address(id) VALUES(1);
  
  INSERT INTO business_entity_intl(id, be_id) VALUES(101, 961);
  INSERT INTO prod_cat (prod_cat_id, prod_cat_name, parent_prod_cat_id, prod_cat_link, is_active, department) values (1, 'Parent', null, 'ParentLink', '1', 'Testing Department');
  INSERT INTO prod_cat (prod_cat_id, prod_cat_name, parent_prod_cat_id, prod_cat_link, is_active, department) values (2, 'Child', 1, 'ChildLink', '1', 'Testing Department');
  INSERT INTO prod_to_cat (id, prod_id, prod_cat_id) values (1, 1, 1);
  INSERT INTO prod (prod_id, prod_name, prod_desc) values (101000, 'test prod1', 'testing the product1');
  INSERT INTO prod (prod_id, prod_name, prod_desc) values (102000, 'test prod2', 'testing the product2');
  INSERT INTO prod_to_source (id, prod_to_source_id, prod_source_id, prod_id) values (1, 'TEST_SOURCE_ID', 2, 101000);
  
  INSERT INTO  business_entity(id, code, type_code, sub_type_code, name, logo, created_date, updated_date, created_by, updated_by, active_indicator)
  VALUES(101000, '1C10100P', 'dealer', NULL, 'PROD SERIAL TEST', NULL, '2013-06-19 14:39:31.0', '2013-07-26 14:17:19.0', NULL, NULL, NULL);

  INSERT INTO  prod_serial(id, tenant_id, prod_id, prod_srl_no, delivery_be_id, delivery_date, build_date, created_date, updated_date, created_by, updated_by)
  VALUES(101000, 101000, 101000, '101-TEST-SERIAL', 101, '2013-12-01 14:39:31.0', '2012-12-01 14:39:31.0', '2013-06-19 14:39:31.0', '2013-07-26 14:17:19.0', NULL, NULL);

  INSERT INTO  entity_comment(id, comment_type, comments, created_date, updated_date, created_by, updated_by)
  VALUES(101000, 'serial', 'Testing the comments for prod serial', '2013-06-19 14:39:31.0', '2013-07-26 14:17:19.0', NULL, NULL);

  INSERT INTO  prod_serial_comment(id, prod_srl_id, comment_id)
  VALUES(101000, 101000, 101000);
  
  INSERT INTO form_template_defn (id, template_defn_data, version_number, start_date, end_date)
	VALUES (1,'{{#each searchFileds}} <input type="text" /> {{/each}}', 1.0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	
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
  INSERT INTO users_to_brand(id,user_id,brand_id,created_date,updated_date,created_by,updated_by,active_indicator) VALUES(3,1,3,NULL,NULL,NULL,NULL,'Y'); 
  INSERT INTO users_to_brand(id,user_id,brand_id,created_date,updated_date,created_by,updated_by,active_indicator) VALUES(4,2,3,NULL,NULL,NULL,NULL,'Y'); 
  
 
  INSERT INTO business_entity_brand(id,be_id,brand_id,is_active) VALUES(1,961,1,'Y');
  INSERT INTO business_entity_brand(id,be_id,brand_id,is_active) VALUES(2,961,2,'Y');
  INSERT INTO business_entity_brand(id,be_id,brand_id,is_active) VALUES(3,962,3,'Y');
 
