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

CREATE TABLE  business_entity ( 
	id              	BIGINT(20) NOT NULL,
	code            	VARCHAR(50) NULL,
	type_code       	VARCHAR(50) NULL,
	sub_type_code   	VARCHAR(50) NULL,
	name            	VARCHAR(200) NULL,
	logo            	VARCHAR(100) NULL,
	created_date    	DATETIME NULL,
	updated_date    	DATETIME NULL,
	created_by      	BIGINT(20) NULL,
	updated_by      	BIGINT(20) NULL,
	active_indicator	CHAR(1) NULL 
	);


CREATE TABLE  business_entity_address  ( 
	id           	BIGINT(20) NOT NULL,
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
	hours_of_op  	VARCHAR(250) NULL 
	);

CREATE TABLE business_entity_geo ( 
	be_address_id	BIGINT(20) NULL,
	latitude     	VARCHAR(16777215) NULL,
	longitude    	VARCHAR(16777215) NULL 
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


insert into locale values(1,'Y','EN','USA','EN_USA');

INSERT INTO  business_entity(id, code, type_code, sub_type_code, name, logo, created_date, updated_date, created_by, updated_by, active_indicator)
  VALUES(961, '10C00100P', 'dealer', NULL, 'WASHINGTON AIR COMP. RENTAL', NULL, '2013-06-19 14:39:31.0', '2013-07-26 14:17:19.0', NULL, NULL, NULL);

INSERT INTO business_entity_geo(be_address_id, latitude, longitude)
  VALUES(10799, '39.061799', '-77.11795099999999');  

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

INSERT INTO  business_entity_address (id, be_id, code, locale_id, name, address_1, address_2, address_3, zip, zip_ext, city, county, state_id, country_id, phone_1, phone_2, email, fax, land_mark, url, tool_tip_logo, icon, hours_of_op)
  VALUES(10799, 961, NULL, 1, NULL, '12529 PARKLAWN DR.', NULL, NULL, '20852', NULL, 'ROCKVILLE', NULL, 20, 1, '3012305800', NULL, NULL, '3012305830', NULL, NULL, NULL, NULL, NULL);
  
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