CREATE TABLE multicurrency (
	id int4 NOT NULL,
	base_currency varchar(255) NULL,
	exchange_currency varchar(255) NULL,
	rate float4 NULL,
	CONSTRAINT multicurrency_pkey PRIMARY KEY (id)
);

INSERT INTO multicurrency (id,base_currency,exchange_currency,rate)
	VALUES (1,'SGD','CAD', 0.9255),
	(2,'SGD','CNH', 4.7868),
	(3, 'SGD', 'EUR', 0.7086),
    (4, 'SGD', 'HKD', 5.5830),
    (5, 'SGD', 'JPY', 97.5303),
    (6, 'SGD', 'NZD', 1.1612),
    (7, 'SGD', 'NOK', 7.2912),
    (8, 'SGD', 'GBP', 0.5974),
    (9, 'SGD', 'SEK', 7.5168),
    (10, 'SGD', 'THB', 25.7275),
    (11, 'SGD', 'USD', 0.7113);