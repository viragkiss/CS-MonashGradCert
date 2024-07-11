--*****PLEASE ENTER YOUR DETAILS BELOW*****
--T5-cr-mods.sql

-- ITO Assignment 2 Task 5

--Student ID: 33724733
--Student Name: Virag Kiss

/* Comments for your marker:

Part a: PK could not be changed to uniqie combination of carn_date and comp_no
as the table was already populated.

*/

-- ENSURE that your SQL code is formatted and has a semicolon (;)
-- at the end of every statement. When marked this will be run as
-- a script.

/*
(a)
*/
DROP TABLE uniqueentry CASCADE CONSTRAINTS;

CREATE TABLE uniqueentry (
    carn_date DATE NOT NULL,
    comp_no   NUMBER(5) NOT NULL
);

COMMENT ON COLUMN uniqueentry.carn_date IS
    'Date of carnival (unique identifier)';

COMMENT ON COLUMN uniqueentry.comp_no IS
    'Competitor registration number (unique)';

ALTER TABLE uniqueentry ADD CONSTRAINT uniqueentry_pk PRIMARY KEY ( carn_date,
                                                                    comp_no );

ALTER TABLE uniqueentry
    ADD CONSTRAINT carnival_uniqueentry_fk FOREIGN KEY ( carn_date )
        REFERENCES carnival ( carn_date );

ALTER TABLE uniqueentry
    ADD CONSTRAINT entry_uniqueentry_fk FOREIGN KEY ( comp_no )
        REFERENCES competitor ( comp_no );

DESC uniqueentry;

COMMIT;

 
/*
(b)
*/

ALTER TABLE entry ADD (
    entry_elapsed_time NUMBER(5, 2)
);

COMMENT ON COLUMN entry.entry_elapsed_time IS
    'Elapsed time between start and finish of run';

DESC entry;

COMMIT;

UPDATE entry
SET
    entry_elapsed_time = round((TO_NUMBER((entry_finishtime - entry_starttime) * 60 * 24
    )),
                               2);

COMMIT;


/*
(c)
*/

-- drop emercontact relationship column from competitor
ALTER TABLE competitor DROP COLUMN comp_ec_relationship;

-- create composite table
DROP TABLE comp_emercontacts CASCADE CONSTRAINTS;

CREATE TABLE comp_emercontacts (
    ec_phone             CHAR(10) NOT NULL,
    comp_no              NUMBER(5) NOT NULL,
    comp_ec_relationship CHAR(1) NOT NULL
);

COMMENT ON COLUMN comp_emercontacts.ec_phone IS
    'Emergency contact phone number';

COMMENT ON COLUMN comp_emercontacts.comp_no IS
    'Competitor registration number (unique)';

COMMENT ON COLUMN comp_emercontacts.comp_ec_relationship IS
    'Emergency contact relationship to competitor (P or  T or G or F)
P = Parent
T = Partner
G = Guardian
F = Friend
';

ALTER TABLE comp_emercontacts ADD CONSTRAINT comp_emercontacts_pk PRIMARY KEY ( ec_phone
,
                                                                                comp_no
                                                                                );

ALTER TABLE comp_emercontacts
    ADD CONSTRAINT emercontact_econtacts_fk FOREIGN KEY ( ec_phone )
        REFERENCES emercontact ( ec_phone );

ALTER TABLE comp_emercontacts
    ADD CONSTRAINT competitor_econtacts_fk FOREIGN KEY ( comp_no )
        REFERENCES competitor ( comp_no );

DESC comp_emercontacts;

COMMIT;