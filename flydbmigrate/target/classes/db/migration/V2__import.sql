ALTER TABLE companies
ADD ticker varchar(10);

UPDATE companies SET ticker='WM' WHERE id='1';
UPDATE companies SET ticker='EX' WHERE id='2';
UPDATE companies SET ticker='CH' WHERE id='3';
UPDATE companies SET ticker='BH' WHERE id='4';
UPDATE companies SET ticker='AAPL' WHERE id='5';
