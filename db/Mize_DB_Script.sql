/*
Script generated by Aqua Data Studio 11.0.13 on Oct-16-2012 09:34:05 AM
Database: mizepocdb
Schema: <All Schemas>
Objects: TABLE
*/
ALTER TABLE users_user_permission
	DROP FOREIGN KEY fk_users_user_permission_user_02
GO
ALTER TABLE users_user_permission
	DROP FOREIGN KEY fk_users_user_permission_user_01
GO
ALTER TABLE users_security_role
	DROP FOREIGN KEY fk_users_security_role_users_01
GO
ALTER TABLE users_security_role
	DROP FOREIGN KEY fk_users_security_role_securi_02
GO
ALTER TABLE user_support_log
	DROP FOREIGN KEY user_support_log_ibfk_3
GO
ALTER TABLE user_support_log
	DROP FOREIGN KEY user_support_log_ibfk_2
GO
ALTER TABLE user_support_log
	DROP FOREIGN KEY user_support_log_ibfk_1
GO
ALTER TABLE user_connect
	DROP FOREIGN KEY user_connect_ibfk_2
GO
ALTER TABLE user_connect
	DROP FOREIGN KEY user_connect_ibfk_1
GO
ALTER TABLE user_profile
	DROP FOREIGN KEY user_profile_ibfk_4
GO
ALTER TABLE user_profile
	DROP FOREIGN KEY user_profile_ibfk_3
GO
ALTER TABLE user_profile
	DROP FOREIGN KEY user_profile_ibfk_2
GO
ALTER TABLE user_brands
	DROP FOREIGN KEY user_brands_ibfk_2
GO
ALTER TABLE user_brands
	DROP FOREIGN KEY user_brands_ibfk_1
GO
ALTER TABLE post_to_social_media
	DROP FOREIGN KEY post_to_social_media_ibfk_2
GO
ALTER TABLE post_to_social_media
	DROP FOREIGN KEY post_to_social_media_ibfk_1
GO
ALTER TABLE linked_account
	DROP FOREIGN KEY fk_linked_account_user_1
GO
ALTER TABLE brand_support_temp
	DROP FOREIGN KEY fk_country
GO
ALTER TABLE brand_support_temp
	DROP FOREIGN KEY brand_support_temp_ibfk_1
GO
ALTER TABLE brand_support_feedback
	DROP FOREIGN KEY brand_support_feedback_ibfk_1
GO
ALTER TABLE brand_feedback
	DROP FOREIGN KEY brand_feedback_ibfk_3
GO
ALTER TABLE brand_feedback
	DROP FOREIGN KEY brand_feedback_ibfk_2
GO
ALTER TABLE brand_feedback
	DROP FOREIGN KEY brand_feedback_ibfk_1
GO
ALTER TABLE application_messages
	DROP FOREIGN KEY application_messages_ibfk_1
GO
ALTER TABLE company_url
	DROP FOREIGN KEY company_url_ibfk_1
GO
ALTER TABLE user_company
	DROP FOREIGN KEY user_company_ibfk_1
GO
ALTER TABLE user_company
	DROP FOREIGN KEY user_company_ibfk_2
GO
ALTER TABLE company_brand
	DROP FOREIGN KEY company_brand_ibfk_1
GO
ALTER TABLE company_brand
	DROP FOREIGN KEY company_brand_ibfk_2
GO
ALTER TABLE user_brand_resp
	DROP FOREIGN KEY user_brand_resp_ibfk_1
GO
ALTER TABLE user_brand_resp
	DROP FOREIGN KEY user_brand_resp_ibfk_2
GO
ALTER TABLE company
	DROP CONSTRAINT company_name
GO
ALTER TABLE company_url
	DROP CONSTRAINT company_id_access_type_url_type
GO
ALTER TABLE token_action
	DROP INDEX uq_token_action_token
GO
ALTER TABLE brand_temp
	DROP INDEX brand_name
GO
ALTER TABLE application_messages
	DROP INDEX message_code
GO

DROP INDEX fk_users_user_permission_user_02 ON users_user_permission
GO
DROP INDEX fk_users_security_role_securi_02 ON users_security_role
GO
DROP INDEX brand_id ON user_support_log
GO
DROP INDEX country_id ON user_support_log
GO
DROP INDEX user_id ON user_support_log
GO
DROP INDEX user_profile_ibfk_2 ON user_profile
GO
DROP INDEX user_profile_ibfk_3 ON user_profile
GO
DROP INDEX user_profile_ibfk_4 ON user_profile
GO
DROP INDEX brand_id ON user_brands
GO
DROP INDEX user_id ON user_brands
GO
DROP INDEX ix_token_action_targetUser_2 ON token_action
GO
DROP INDEX social_media_id ON post_to_social_media
GO
DROP INDEX support_feedback_id ON post_to_social_media
GO
DROP INDEX ix_linked_account_user_1 ON linked_account
GO
DROP INDEX brand_id ON brand_support_temp
GO
DROP INDEX fk_country ON brand_support_temp
GO
DROP INDEX support_log_id ON brand_support_feedback
GO
DROP INDEX brand_id ON brand_feedback
GO
DROP INDEX feedback_category_id ON brand_feedback
GO
DROP INDEX user_id ON brand_feedback
GO
DROP INDEX message_type_id ON application_messages
GO
DROP TABLE users_user_permission
GO
DROP TABLE users_security_role
GO
DROP TABLE user_connect
GO
DROP TABLE users
GO
DROP TABLE user_support_log
GO
DROP TABLE user_source
GO
DROP TABLE user_profile
GO
DROP TABLE user_permission
GO
DROP TABLE user_brands
GO
DROP TABLE token_action
GO
DROP TABLE state
GO
DROP TABLE security_role
GO
DROP TABLE post_to_social_media
GO
DROP TABLE message_type
GO
DROP TABLE linked_account
GO
DROP TABLE feedback_category
GO
DROP TABLE country
GO
DROP TABLE brand_temp
GO
DROP TABLE brand_support_temp
GO
DROP TABLE brand_support_feedback
GO
DROP TABLE brand_support
GO
DROP TABLE brand_feedback
GO
DROP TABLE brand
GO
DROP TABLE application_messages
GO
DROP TABLE company
GO
DROP TABLE company_url
GO
DROP TABLE user_company
GO
DROP TABLE company_brand
GO
DROP TABLE user_brand_resp
GO

ALTER TABLE email
	DROP CONSTRAINT PRIMARY
GO
DROP TABLE email
GO


CREATE TABLE application_messages  ( 
	id                	int(11) AUTO_INCREMENT NOT NULL,
	message_type_id   	int(11) NOT NULL,
	message_code      	varchar(50) NOT NULL,
	message_short_desc	varchar(250) NULL,
	message_long_desc 	varchar(500) NULL,
	message_severity  	int(11) NULL,
	created_by       	bigint(20) NULL,
	created_date     	datetime NULL,
	updated_by       	bigint(20) NULL,
	updated_date     	datetime NULL,
	PRIMARY KEY(id)
)
GO
CREATE TABLE brand  ( 
	brand_id  		bigint(20) NOT NULL,
	brand_name		varchar(250) NOT NULL,
	brand_type		int(11) NULL,
	brand_link		varchar(250) NULL,
	brand_logo		varchar(50) NULL,
	feedback_email  varchar(100) NULL,
	created_by       	bigint(20) NULL,
	created_date     	datetime NULL,
	updated_by       	bigint(20) NULL,
	updated_date     	datetime NULL,
	PRIMARY KEY(brand_id)
)
GO
CREATE TABLE brand_feedback  ( 
	brand_feedback_id   	bigint(20) AUTO_INCREMENT NOT NULL,
	brand_id            	bigint(20) NOT NULL,
	user_id             	bigint(20) NOT NULL,
	feedback_category_id	int(11) NULL,
	feedback_subject    	varchar(250) NULL,
	feedback_description	varchar(1000) NULL,
	created_by       	bigint(20) NULL,
	created_date     	datetime NULL,
	updated_by       	bigint(20) NULL,
	updated_date     	datetime NULL,
	PRIMARY KEY(brand_feedback_id)
)
GO
CREATE TABLE brand_support  ( 
	brand_id         	bigint(20) NOT NULL,
	brand_support_id 	bigint(20) NOT NULL,
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
	updated_date     	datetime NULL,
	PRIMARY KEY(brand_support_id)
)
GO
CREATE TABLE brand_support_feedback  ( 
	support_feedback_id 	bigint(20) AUTO_INCREMENT NOT NULL,
	support_log_id      	bigint(20) NULL,
	resolved            	char(1) NULL,
	feedback_posted_date	timestamp NOT NULL,
	support_rating      	int(11) NULL,
	support_feedback    	varchar(250) NULL,
	ticket_number       	varchar(10) NULL,
	created_by       	bigint(20) NULL,
	created_date     	datetime NULL,
	updated_by       	bigint(20) NULL,
	updated_date     	datetime NULL,
	PRIMARY KEY(support_feedback_id)
)
GO
CREATE TABLE brand_support_temp  ( 
	brand_id         	bigint(20) NOT NULL,
	brand_support_id 	bigint(20) NOT NULL,
	support_phone    	varchar(20) NULL,
	support_email    	varchar(100) NULL,
	support_site     	varchar(250) NULL,
	support_chat     	varchar(250) NULL,
	support_phone_tf 	varchar(20) NULL,
	support_qualifier	varchar(250) NULL,
	validated_by     	varchar(100) NULL,
	validated_on     	datetime NULL,
	prodcat_id       	int(11) NULL,
	support_facebook 	varchar(250) NULL,
	support_twitter  	varchar(250) NULL,
	country_id       	int(11) NULL,
	support_type     	int(11) NULL,
	data_source_type 	int(11) NULL,
	validated        	tinyint(1) NULL,
	hours_of_op      	varchar(250) NULL,
	created_by       	bigint(20) NULL,
	created_date     	datetime NULL,
	updated_by       	bigint(20) NULL,
	updated_date     	datetime NULL,
	PRIMARY KEY(brand_support_id)
)
GO
CREATE TABLE brand_temp  ( 
	brand_id  		bigint(20) NOT NULL,
	brand_name		varchar(250) NOT NULL,
	brand_type		int(11) NULL,
	brand_link		varchar(250) NULL,
	created_by       	bigint(20) NULL,
	created_date     	datetime NULL,
	updated_by       	bigint(20) NULL,
	updated_date     	datetime NULL,
	PRIMARY KEY(brand_id)
)
GO
CREATE TABLE country  ( 
	country_id  		int(11) NOT NULL,
	country_name		varchar(100) NULL,
	country_code		varchar(2) NULL,
	country_code_3	varchar(3) NULL,
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
	PRIMARY KEY(country_id)
)
GO
CREATE TABLE email ( 
	id        	int(10) AUTO_INCREMENT NOT NULL primary key,
	user_id   	int(11) NOT NULL,
	email_type	varchar(100) NULL,
	email_from	varchar(50) NOT NULL,
	email_to  	varchar(200) NOT NULL,
	email_cc  	varchar(200) NULL,
	subject   	varchar(200) NOT NULL,
	content   	varchar(500) NOT NULL, 
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL
	)
GO
CREATE TABLE feedback_category  ( 
	feedback_category_id	int(11) AUTO_INCREMENT NOT NULL,
	feedback_category   	varchar(250) NULL,
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
	PRIMARY KEY(feedback_category_id)
)
GO
CREATE TABLE linked_account  ( 
	id              	bigint(20) AUTO_INCREMENT NOT NULL,
	user_id         	bigint(20) NULL,
	provider_user_id	varchar(255) NULL,
	provider_key    	varchar(255) NULL,
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
	PRIMARY KEY(id)
)
CREATE TABLE user_connect  ( 
	user_id         	bigint(20) NOT NULL,
	linked_account_id	bigint(20) NOT NULL,
	email    		varchar(255) NOT NULL,
	provider    		varchar(255) NOT NULL,
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL
)
GO
CREATE TABLE message_type  ( 
	message_type_id	int(11) AUTO_INCREMENT NOT NULL,
	message_type   	varchar(100) NOT NULL,
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
	PRIMARY KEY(message_type_id)
)
GO
CREATE TABLE post_to_social_media  ( 
	support_feedback_id	bigint(20) NOT NULL,
	post_id            	varchar(250) NULL,
	posted_date        	timestamp NOT NULL,
	posted_data        	varchar(500) NULL,
	social_media_id    	int(11) NULL,
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL
	)
GO
CREATE TABLE security_role  ( 
	id       		bigint(20) AUTO_INCREMENT NOT NULL,
	role_name		varchar(255) NULL,
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
	PRIMARY KEY(id)
)
GO
CREATE TABLE state  ( 
	state_id  		int(11) AUTO_INCREMENT NOT NULL,
	state_code		varchar(5) NOT NULL,
	state_name		varchar(100) NOT NULL,
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
	PRIMARY KEY(state_id)
)
GO
CREATE TABLE token_action  ( 
	id            	bigint(20) AUTO_INCREMENT NOT NULL,
	token         	varchar(255) NULL,
	target_user_id	bigint(20) NULL,
	type          	varchar(2) NULL,
	created       	timestamp NOT NULL,
	expires       	timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
	PRIMARY KEY(id)
)
GO
CREATE TABLE user_brands  ( 
	user_brands_id  	bigint(20) AUTO_INCREMENT NOT NULL,
	user_id         	bigint(20) NOT NULL,
	brand_id        	bigint(20) NOT NULL,
	brand_support_id	bigint(20) NOT NULL,
	favorite        	varchar(15) NULL,
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
	PRIMARY KEY(user_brands_id)
)
GO
CREATE TABLE user_permission  ( 
	id   			bigint(20) AUTO_INCREMENT NOT NULL,
	value			varchar(255) NULL,
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
	PRIMARY KEY(id)
)
GO
CREATE TABLE user_profile  ( 
	profile_name	varchar(100) NULL,
	first_name 		varchar(100) NULL,
	last_name  		varchar(100) NULL,
	birth_day  		timestamp NULL,
	gender     		varchar(1) NULL,
	address1   		varchar(100) NULL,
	address2   		varchar(100) NULL,
	address3   		varchar(100) NULL,
	city       		varchar(100) NULL,
	state_id   		int(11) NULL,
	country_id 		int(11) NULL,
	postal_code		varchar(11) NULL,
	photo_link 		varchar(250) NULL,
	user_id    		bigint(20) NOT NULL, 
	phone_mobile	varchar(20) NULL,
	phone_home		varchar(20) NULL,
	phone_work 		varchar(20) NULL,
	job_title		varchar(100) NULL,	
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL
	)
GO
CREATE TABLE user_source  ( 
	user_source_id  	int(11) NOT NULL,
	user_source_name	varchar(100) NOT NULL,
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
	PRIMARY KEY(user_source_id)
)
GO
CREATE TABLE user_support_log  ( 
	support_log_id	bigint(20) AUTO_INCREMENT NOT NULL,
	user_id       	bigint(20) NOT NULL,
	brand_id      	bigint(20) NULL,
	brand_support_id bigint(20) NULL,
	start_ts      	timestamp NOT NULL,
	end_ts        	timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
	country_id    	int(11) NULL,
	support_type  	varchar(50) NULL,
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
	PRIMARY KEY(support_log_id)
)
GO
CREATE TABLE users  ( 
	id             	bigint(20) AUTO_INCREMENT NOT NULL,
	email          	varchar(255) NULL,
	name           	varchar(255) NULL,
	last_login     	timestamp NOT NULL,
	active         	tinyint(1) NULL,
	email_validated	tinyint(1) NULL,
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
	PRIMARY KEY(id)
)
GO
CREATE TABLE users_security_role  ( 
	users_id        	bigint(20) NOT NULL,
	security_role_id	bigint(20) NOT NULL,
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
	PRIMARY KEY(users_id,security_role_id)
)
GO
CREATE TABLE users_user_permission  ( 
	users_id          	bigint(20) NOT NULL,
	user_permission_id	bigint(20) NOT NULL,
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
	PRIMARY KEY(users_id,user_permission_id)
)
GO
CREATE TABLE company( 
	company_id      int(11) AUTO_INCREMENT NOT NULL,
	company_name    varchar(200) NOT NULL,
	company_type 	varchar(100) NULL,
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
	PRIMARY KEY(company_id));
GO
CREATE TABLE company_url( 
    company_url_id  int(11) AUTO_INCREMENT NOT NULL,
    company_id       int(11) NOT NULL,
    access_type     varchar(100) NULL,  
    country_id      int(11) NULL,
    url             varchar(250) NULL,
    url_type        varchar(100) NULL,    
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
PRIMARY KEY(company_url_id)
);
GO
CREATE TABLE user_company( 
    user_id         bigint(20)  NOT NULL,
    company_id      int(11) NOT NULL,
    is_validated    tinyint(1) NULL,
    validated_by    varchar(100) NULL, 
    validated_date  datetime NULL,
    internal_comments varchar(500) NULL,
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
    PRIMARY KEY (user_id, company_id));
GO
CREATE TABLE company_brand( 
    company_id      int(20),
    brand_id        bigint(20),
	created_by    	bigint(20) NULL,
	created_date  	datetime NULL,
	updated_by    	bigint(20) NULL,
	updated_date  	datetime NULL,
    PRIMARY KEY(company_id, brand_id)
    );
GO
    CREATE INDEX message_type_id USING BTREE 
	ON application_messages(message_type_id)
GO
CREATE INDEX brand_id USING BTREE 
	ON brand_feedback(brand_id)
GO
CREATE INDEX feedback_category_id USING BTREE 
	ON brand_feedback(feedback_category_id)
GO
CREATE INDEX user_id USING BTREE 
	ON brand_feedback(user_id)
GO
CREATE INDEX support_log_id USING BTREE 
	ON brand_support_feedback(support_log_id)
GO
CREATE INDEX brand_id USING BTREE 
	ON brand_support_temp(brand_id)
GO
CREATE INDEX fk_country USING BTREE 
	ON brand_support_temp(country_id)
GO
CREATE INDEX ix_linked_account_user_1 USING BTREE 
	ON linked_account(user_id)
GO
CREATE INDEX social_media_id USING BTREE 
	ON post_to_social_media(social_media_id)
GO
CREATE INDEX support_feedback_id USING BTREE 
	ON post_to_social_media(support_feedback_id)
GO
CREATE INDEX ix_token_action_targetUser_2 USING BTREE 
	ON token_action(target_user_id)
GO
CREATE INDEX brand_id USING BTREE 
	ON user_brands(brand_id)
GO
CREATE INDEX user_id USING BTREE 
	ON user_brands(user_id)
GO
CREATE INDEX user_profile_ibfk_2 USING BTREE 
	ON user_profile(state_id)
GO
CREATE INDEX user_profile_ibfk_3 USING BTREE 
	ON user_profile(country_id)
GO
CREATE INDEX user_profile_ibfk_4 USING BTREE 
	ON user_profile(user_id)
GO
CREATE INDEX brand_id USING BTREE 
	ON user_support_log(brand_id)
GO
CREATE INDEX country_id USING BTREE 
	ON user_support_log(country_id)
GO
CREATE INDEX user_id USING BTREE 
	ON user_support_log(user_id)
GO
CREATE INDEX fk_users_security_role_securi_02 USING BTREE 
	ON users_security_role(security_role_id)
GO
CREATE INDEX fk_users_user_permission_user_02 USING BTREE 
	ON users_user_permission(user_permission_id)
GO
ALTER TABLE application_messages
	ADD CONSTRAINT message_code
	UNIQUE (message_code)
GO
ALTER TABLE brand_temp
	ADD CONSTRAINT brand_name
	UNIQUE (brand_name)
GO
ALTER TABLE brand
	ADD CONSTRAINT brand_name
	UNIQUE (brand_name)
GO
ALTER TABLE country
	ADD CONSTRAINT country_code
	UNIQUE (country_code)
GO
ALTER TABLE feedback_category
	ADD CONSTRAINT feedback_category
	UNIQUE (feedback_category)
GO
ALTER TABLE message_type
	ADD CONSTRAINT message_type
	UNIQUE (message_type)
GO
ALTER TABLE state
	ADD CONSTRAINT state_code
	UNIQUE (state_code)
GO
ALTER TABLE token_action
	ADD CONSTRAINT uq_token_action_token
	UNIQUE (token)
GO
ALTER TABLE user_source
	ADD CONSTRAINT user_source_name
	UNIQUE (user_source_name)
GO
ALTER TABLE company
	ADD CONSTRAINT company_name
	UNIQUE (company_name);
GO
ALTER TABLE company_url
	ADD CONSTRAINT company_id_access_type_url_type
	UNIQUE (company_id, access_type, url_type);
GO
ALTER TABLE application_messages
	ADD CONSTRAINT application_messages_ibfk_1
	FOREIGN KEY(message_type_id)
	REFERENCES message_type(message_type_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE brand_feedback
	ADD CONSTRAINT brand_feedback_ibfk_3
	FOREIGN KEY(feedback_category_id)
	REFERENCES feedback_category(feedback_category_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE brand_feedback
	ADD CONSTRAINT brand_feedback_ibfk_2
	FOREIGN KEY(brand_id)
	REFERENCES brand(brand_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE brand_feedback
	ADD CONSTRAINT brand_feedback_ibfk_1
	FOREIGN KEY(user_id)
	REFERENCES users(id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE brand_support_feedback
	ADD CONSTRAINT brand_support_feedback_ibfk_1
	FOREIGN KEY(support_log_id)
	REFERENCES user_support_log(support_log_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT
GO
ALTER TABLE brand_support
	ADD CONSTRAINT fk_country
	FOREIGN KEY(country_id)
	REFERENCES country(country_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE brand_support
	ADD CONSTRAINT brand_support_ibfk_1
	FOREIGN KEY(brand_id)
	REFERENCES brand(brand_id)
	ON DELETE RESTRICT 
ON UPDATE RESTRICT
GO
alter table brand_support 
add constraint unique (brand_id, support_qualifier)
GO
ALTER TABLE brand_support_temp
	ADD CONSTRAINT fk_country
	FOREIGN KEY(country_id)
	REFERENCES country(country_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE brand_support_temp
	ADD CONSTRAINT brand_support_temp_ibfk_1
	FOREIGN KEY(brand_id)
	REFERENCES brand_temp(brand_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT
GO
ALTER TABLE linked_account
	ADD CONSTRAINT fk_linked_account_user_1
	FOREIGN KEY(user_id)
	REFERENCES users(id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE post_to_social_media
	ADD CONSTRAINT post_to_social_media_ibfk_2
	FOREIGN KEY(social_media_id)
	REFERENCES user_source(user_source_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE post_to_social_media
	ADD CONSTRAINT post_to_social_media_ibfk_1
	FOREIGN KEY(support_feedback_id)
	REFERENCES brand_support_feedback(support_feedback_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE user_brands
	ADD CONSTRAINT user_brands_ibfk_2
	FOREIGN KEY(brand_id)
	REFERENCES brand(brand_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE user_brands
	ADD CONSTRAINT user_brands_ibfk_1
	FOREIGN KEY(user_id)
	REFERENCES users(id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE user_profile
	ADD CONSTRAINT user_profile_ibfk_4
	FOREIGN KEY(user_id)
	REFERENCES users(id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE user_profile
	ADD CONSTRAINT user_profile_ibfk_3
	FOREIGN KEY(country_id)
	REFERENCES country(country_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE user_connect
	ADD CONSTRAINT user_connect_ibfk_1
	FOREIGN KEY(user_id)
	REFERENCES users(id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE user_connect
	ADD CONSTRAINT user_connect_ibfk_2
	FOREIGN KEY(linked_account_id)
	REFERENCES linked_account(id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE user_profile
	ADD CONSTRAINT user_profile_ibfk_2
	FOREIGN KEY(state_id)
	REFERENCES state(state_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE user_support_log
	ADD CONSTRAINT user_support_log_ibfk_3
	FOREIGN KEY(country_id)
	REFERENCES country(country_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE user_support_log
	ADD CONSTRAINT user_support_log_ibfk_2
	FOREIGN KEY(brand_id)
	REFERENCES brand(brand_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE user_support_log
	ADD CONSTRAINT user_support_log_ibfk_1
	FOREIGN KEY(user_id)
	REFERENCES users(id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
alter table user_support_log 
	add foreign key (brand_support_id) 
	references brand_support (brand_support_id)
GO
ALTER TABLE users_security_role
	ADD CONSTRAINT fk_users_security_role_users_01
	FOREIGN KEY(users_id)
	REFERENCES users(id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE users_security_role
	ADD CONSTRAINT fk_users_security_role_securi_02
	FOREIGN KEY(security_role_id)
	REFERENCES security_role(id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE users_user_permission
	ADD CONSTRAINT fk_users_user_permission_user_02
	FOREIGN KEY(user_permission_id)
	REFERENCES user_permission(id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE users_user_permission
	ADD CONSTRAINT fk_users_user_permission_user_01
	FOREIGN KEY(users_id)
	REFERENCES users(id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE company_url
	ADD CONSTRAINT company_url_ibfk_1
	FOREIGN KEY(company_id)
	REFERENCES company(company_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT;
GO
ALTER TABLE user_company
	ADD CONSTRAINT user_company_ibfk_1
	FOREIGN KEY(user_id)
	REFERENCES users(id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT;
GO
ALTER TABLE user_company
	ADD CONSTRAINT user_company_ibfk_2
	FOREIGN KEY(company_id)
	REFERENCES company(company_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT;
GO
ALTER TABLE company_brand
	ADD CONSTRAINT company_brand_ibfk_1
	FOREIGN KEY(company_id)
	REFERENCES company(company_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT;
GO
ALTER TABLE company_brand
	ADD CONSTRAINT company_brand_ibfk_2
	FOREIGN KEY(brand_id)
	REFERENCES brand(brand_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT;
GO
ALTER TABLE user_brand_resp
	ADD CONSTRAINT user_brand_resp_ibfk_1
	FOREIGN KEY(user_id)
	REFERENCES users(id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT;
GO
ALTER TABLE user_brand_resp
	ADD CONSTRAINT user_brand_resp_ibfk_2
	FOREIGN KEY(brand_id)
	REFERENCES brand(brand_id)
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT;
GO

INSERT INTO country(country_id, country_name, country_code)
VALUES(1, 'United States', 'US')
GO
INSERT INTO country(country_id, country_name, country_code)
VALUES(2, 'Canada', 'CA')
GO

INSERT INTO user_source(user_source_id, user_source_name)
  VALUES(1, 'mize')
GO
INSERT INTO user_source(user_source_id, user_source_name)
  VALUES(2, 'facebook')
GO
INSERT INTO user_source(user_source_id, user_source_name)
  VALUES(3, 'twitter')
GO
INSERT INTO user_source(user_source_id, user_source_name)
  VALUES(4, 'google')
GO

INSERT INTO state(state_id, state_code, state_name)
  VALUES(1, 'AL', 'Alabama')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(2, 'AK', 'Alaska')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(3, 'AZ', 'Arizona')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(4, 'AR', 'Arkansas')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(5, 'CA', 'California')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(6, 'CO', 'Colorado')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(7, 'CT', 'Connecticut')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(8, 'DE', 'Delaware')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(9, 'FL', 'Florida')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(10, 'GA', 'Georgia')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(11, 'HI', 'Hawaii')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(12, 'ID', 'Idaho')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(13, 'IL', 'Illinois')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(14, 'IN', 'Indiana')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(15, 'IA', 'Iowa')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(16, 'KS', 'Kansas')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(17, 'KY', 'Kentucky')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(18, 'LA', 'Louisiana')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(19, 'ME', 'Maine')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(20, 'MD', 'Maryland')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(21, 'MA', 'Massachusetts')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(22, 'MI', 'Michigan')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(23, 'MN', 'Minnesota')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(24, 'MS', 'Mississippi')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(25, 'MO', 'Missori')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(26, 'MT', 'Montana')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(27, 'NE', 'Nebraska')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(28, 'NV', 'Nevada')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(29, 'NH', 'New Hampshire')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(30, 'NJ', 'New Jersey')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(31, 'NM', 'New Mexico')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(32, 'NY', 'New York')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(33, 'NC', 'North Carolina')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(34, 'ND', 'North Dakota')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(35, 'OH', 'Ohio')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(36, 'OK', 'Oklahoma')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(37, 'OR', 'Oregon')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(38, 'PA', 'Pennsylvania')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(39, 'RI', 'Rhode Island')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(40, 'SC', 'South Carolina')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(41, 'SD', 'South Dakota')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(42, 'TN', 'Tennessee')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(43, 'TX', 'Texas')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(44, 'UT', 'Utah')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(45, 'VT', 'Vermont')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(46, 'VA', 'Virginia')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(47, 'WA', 'Washington')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(48, 'WV', 'West Virginia')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(49, 'WI', 'Wisconsin')
GO
INSERT INTO state(state_id, state_code, state_name)
  VALUES(50, 'WY', 'Wyoming')
GO

INSERT INTO message_type(message_type_id, message_type)
  VALUES(1, 'Application')
GO
INSERT INTO message_type(message_type_id, message_type)
  VALUES(2, 'Error')
GO

INSERT INTO feedback_category(feedback_category_id, feedback_category)
  VALUES(1, 'Product enhancement')
GO
INSERT INTO feedback_category(feedback_category_id, feedback_category)
  VALUES(2, 'Support enhancement')
GO
INSERT INTO feedback_category(feedback_category_id, feedback_category)
  VALUES(3, 'User Manual')
GO
