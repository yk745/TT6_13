INSERT INTO exchange_rate (id,base_currency,exchange_currency,rate)
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


INSERT INTO public.i_user (id,username,"password",name)
	VALUES (1, 'user101', '123456', 'Jacky'),
    (2, 'user102', '123456', 'Jane'),
    (3, 'user103', '123456', 'Tom'),
    (4, 'user104', '123456', 'Helen'),
     (5, 'user105', '123456', 'Mark');

INSERT INTO wallet (id,user_id,"name")
	VALUES (1, 1, 'Multi-Currency Account'),
    (2, 1, 'Travel Account'),
    (3, 2, 'Trading Account'),
    (4, 3, 'Multi-Currency Account'),
    (5, 4, 'Trip to Japan');

INSERT INTO currency (id,wallet_id,currency,amount)
	VALUES
    	(1, 1, 'SGD', 4294.50),
    	(2, 1, 'CAD', 5687.65),
    	(3, 1, 'CNH', 6063.14),
    	(4, 1, 'EUR', 8089.82),
    	(5, 1, 'HKD', 7862.36),
    	(6, 1, 'JPY', 5759.15),
    	(7, 1, 'NZD', 6943.26),
    	(8, 1, 'NOK', 4038.10),
    	(9, 1, 'GBP', 8287.33),
    	(10, 1, 'SEK', 5126.40),
    	(11, 1, 'THB', 147.62),
    	(12, 1, 'USD', 7331.77),
    	(13, 2, 'SGD', 485.19),
        (14, 2, 'CAD', 2634.58),
    	(15, 2, 'CNH', 3893.29),
    	(16, 2, 'EUR', 3887.15),
    	(17, 2, 'HKD', 4065.34),
    	(18, 2, 'JPY', 1702.47),
    	(19, 2, 'NZD', 3299.38),
    	(20, 2, 'NOK', 7681.32),
    	(21, 2, 'GBP', 3720.37),
    	(22, 2, 'SEK', 4511.50),
    	(23, 2, 'THB', 6216.60),
    	(24, 2, 'USD', 9103.66);

INSERT INTO "transaction" (id, wallet_id, debit_id, debit_currency, debit_amount, credit_id, credit_currency, credit_amount, description, created_timestamp, created_by, last_modified_timestamp, last_modified_by)
	VALUES
	(1, 1, 4, 'EUR', 97.19, 8, 'NOK', 1000.00, '', '2021-11-04 16:00:00', 'Jacky', '2021-11-06 16:00:00', 'Jacky'),
    (2, 2, 13, 'SGD', 102.53, 18, 'JPY', 10000.00, 'allowance for winter school', '2021-11-05 16:00:00', 'Jane', '2021-11-05 16:00:00', NULL),
    (3, 2, 20, 'NOK', 250.00, 15, 'CNH', 164.13, 'trip to china', '2021-11-05 16:00:00', 'Jane', '2021-11-06 16:00:00', 'Jane'),
    (4, 1, 6, 'JPY', 685577.82, 12, 'USD', 5000.00, 'to transfer to securities account wallet', '2021-11-06 16:00:00', 'Jacky', '2021-11-06 16:00:00', null);




