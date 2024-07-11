--*****PLEASE ENTER YOUR DETAILS BELOW*****
--T3-cr-dml.sql

-- ITO Assignment 2 Task 3

--Student ID: 33724733
--Student Name: Virag Kiss

/* Comments for your marker:




*/

-- ENSURE that your SQL code is formatted and has a semicolon (;)
-- at the end of every statement. When marked this will be run as
-- a script.

/*
(a)
*/
-- drop sequences

DROP SEQUENCE comp_seq;

DROP SEQUENCE entry_seq;

DROP SEQUENCE team_seq;

-- create sequences

CREATE SEQUENCE comp_seq START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 99999; -- the entry_id has a precision of 5 digits

CREATE SEQUENCE entry_seq START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 99999; -- the comp_id has a precision of 5 digits

CREATE SEQUENCE team_seq START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 999; -- the team_id has a precision of 3 digits


/*
(b) 
*/
-- add Brigid's entry

INSERT INTO entry (
    entry_id,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    entry_seq.NEXTVAL,
    'Amnesty International',
    (
        SELECT
            comp_no
        FROM
            competitor
        WHERE
            upper(comp_phone) = upper('1234567890')
    ),
    (
        SELECT
            carn_date
        FROM
            carnival
        WHERE
            upper(carn_name) = upper('CR Summer Series Melbourne 2024')
    ),
    (
        SELECT
            eventtype_code
        FROM
            eventtype
        WHERE
            upper(eventtype_desc) = upper('21.1 Km Half Marathon')
    )
);

-- end transaction --
COMMIT;

-- test if inserted correctly
SELECT
    *
FROM
    competitor
WHERE
    upper(comp_phone) = upper('1234567890');

SELECT
    *
FROM
    entry;


/*
(c)
*/
-- move Brigid into 10K

UPDATE entry
SET
    eventtype_code = (
        SELECT
            eventtype_code
        FROM
            eventtype
        WHERE
            upper(eventtype_desc) = upper('10 Km Run')
    )
WHERE
        comp_no = (
            SELECT
                comp_no
            FROM
                competitor
            WHERE
                upper(comp_phone) = upper('1234567890')
        )
    AND carn_date = (
        SELECT
            carn_date
        FROM
            carnival
        WHERE
            upper(carn_name) = upper('CR Summer Series Melbourne 2024')
    );

-- add Bridig's team

INSERT INTO team (
    team_id,
    team_name,
    carn_date,
    team_no_members,
    char_name,
    entry_id
) VALUES (
    team_seq.NEXTVAL,
    'Kenya Speedstars',
    (
        SELECT
            carn_date
        FROM
            carnival
        WHERE
            upper(carn_name) = upper('CR Summer Series Melbourne 2024')
    ),
    1,
    'Beyond Blue',
    entry_seq.CURRVAL
);

-- update Bridig's entry with team_id

UPDATE entry
SET
    team_id = team_seq.CURRVAL
WHERE
        comp_no = (
            SELECT
                comp_no
            FROM
                competitor
            WHERE
                upper(comp_phone) = upper('1234567890')
        )
    AND carn_date = (
        SELECT
            carn_date
        FROM
            carnival
        WHERE
            upper(carn_name) = upper('CR Summer Series Melbourne 2024')
    );

-- end transaction --
COMMIT;

-- test if done correctly
SELECT
    *
FROM
    team;

SELECT
    *
FROM
    entry;


/*
(d) 
*/

-- remove team_id from Brigid's entry in CR Summer Series Melbourne 2024
UPDATE entry
SET
    team_id = NULL
WHERE
        comp_no = (
            SELECT
                comp_no
            FROM
                competitor
            WHERE
                upper(comp_phone) = upper('1234567890')
        )
    AND carn_date = (
        SELECT
            carn_date
        FROM
            carnival
        WHERE
            upper(carn_name) = upper('CR Summer Series Melbourne 2024')
    );

-- remove Brigid's team from CR Summer Series Melbourne 2024
DELETE FROM team
WHERE
        upper(team_name) = upper('Kenya Speedstars')
    AND carn_date = (
        SELECT
            carn_date
        FROM
            carnival
        WHERE
            upper(carn_name) = upper('CR Summer Series Melbourne 2024')
    );

-- remove Brigid's entry from CR Summer Series Melbourne 2024
DELETE FROM entry
WHERE
        comp_no = (
            SELECT
                comp_no
            FROM
                competitor
            WHERE
                upper(comp_phone) = upper('1234567890')
        )
    AND carn_date = (
        SELECT
            carn_date
        FROM
            carnival
        WHERE
            upper(carn_name) = upper('CR Summer Series Melbourne 2024')
    );

-- end transaction --
COMMIT;

-- test if done correctly --
SELECT
    *
FROM
    team;

SELECT
    *
FROM
    entry;