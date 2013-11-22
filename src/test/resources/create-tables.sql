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
	created_date    	datetime 			NULL,
	updated_date    	datetime 			NULL,
	created_by      	bigint(20) 			NULL,
    updated_by      	bigint(20) 			NULL,  
	
);

CREATE TABLE business_entity_geo ( 
	id					bigint(20) 	AUTO_INCREMENT NOT NULL,
	be_address_id	BIGINT(20) NULL,
	latitude     	bigint(2000) NULL,
	longitude    	bigint(2000) NULL,
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
  
INSERT INTO  catalog (id, tenant_id, catalog_code, catalog_type, is_active, created_date, updated_date, created_by, updated_by)
  VALUES(100, 961, 'TestCatalog', 'TestCatalogType', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
  
INSERT INTO  catalog_entry (id, catalog_id, item_code, is_active, created_date, updated_date, created_by, updated_by)
  VALUES(102, 100, 'ItemCode', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
  
  
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