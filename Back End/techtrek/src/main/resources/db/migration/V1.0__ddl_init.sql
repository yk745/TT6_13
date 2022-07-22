CREATE TABLE multicurrency (
	id int4 NOT NULL,
	base_currency varchar(255) NULL,
	exchange_currency varchar(255) NULL,
	rate float4 NULL,
	CONSTRAINT multicurrency_pkey PRIMARY KEY (id)
);

CREATE TABLE wallet (
	id int4 NOT NULL,
	"name" varchar(255) NULL,
	user_id int4 NULL,
	CONSTRAINT wallet_pkey PRIMARY KEY (id)
);

CREATE TABLE currency (
	id int4 NOT NULL,
	amount float4 NULL,
	currency varchar(255) NULL,
	wallet_id int4 NULL,
	CONSTRAINT currency_pkey PRIMARY KEY (id)
);
ALTER TABLE currency ADD CONSTRAINT fks2lwnbc64wfh6t1x06sb03odk FOREIGN KEY (wallet_id) REFERENCES wallet(id);

CREATE TABLE "transaction" (
	id int4 NOT NULL,
	created_by varchar(255) NULL,
	created_timestamp timestamp NULL,
	last_modified_by varchar(255) NULL,
	last_modified_timestamp timestamp NULL,
	credit_amount float4 NULL,
	credit_currency varchar(255) NULL,
	debit_amount float4 NULL,
	description varchar(255) NULL,
	credit_id int4 NULL,
	debit_id int4 NULL,
	wallet_id int4 NULL,
	CONSTRAINT transaction_pkey PRIMARY KEY (id)
);

ALTER TABLE "transaction" ADD CONSTRAINT fk689cb5uubpk2rpflx1l6edr24 FOREIGN KEY (credit_id) REFERENCES currency(id);
ALTER TABLE "transaction" ADD CONSTRAINT fk9oj7l8491did2amcrg8yrh03m FOREIGN KEY (debit_id) REFERENCES currency(id);
ALTER TABLE "transaction" ADD CONSTRAINT fktfwlfspv2h4wcgc9rjd1658a6 FOREIGN KEY (wallet_id) REFERENCES wallet(id);

CREATE TABLE i_user (
	id int4 NOT NULL,
	"name" varchar(255) NULL,
	"password" varchar(255) NULL,
	username varchar(255) NULL,
	CONSTRAINT i_user_pkey PRIMARY KEY (id)
);