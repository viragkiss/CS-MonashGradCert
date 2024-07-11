--*****PLEASE ENTER YOUR DETAILS BELOW*****
--T2-cr-insert.sql

-- ITO Assignment 2 Task 2

--Student ID: 33724733
--Student Name: Virag Kiss

/* Comments for your marker:

Performed necessary updates in lines 897 - 1008 because of foreign key constaints of both TEAM and ENTRY, 
as per Ed Discussion Forum post #192 by teaching staff.

*/


-- ENSURE that your SQL code is formatted and has a semicolon (;)
-- at the end of every statement. When marked this will be run as
-- a script.


-- Insert into ENTRY

-- entries not supporting a charity
-- and not in a team

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    1,
    TO_DATE('19/SEP/2021 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('19/SEP/2021 13:00:30', 'DD/MON/YYYY HH24:MI:SS'),
    1,
    TO_DATE('19/SEP/2021', 'DD/MON/YYYY'),
    '10K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    2,
    TO_DATE('19/SEP/2021 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('19/SEP/2021 12:30:15', 'DD/MON/YYYY HH24:MI:SS'),
    2,
    TO_DATE('19/SEP/2021', 'DD/MON/YYYY'),
    '5K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    3,
    TO_DATE('19/SEP/2021 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('19/SEP/2021 12:55:00', 'DD/MON/YYYY HH24:MI:SS'),
    3,
    TO_DATE('19/SEP/2021', 'DD/MON/YYYY'),
    '10K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    4,
    TO_DATE('04/SEP/2022 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('04/SEP/2022 13:05:00', 'DD/MON/YYYY HH24:MI:SS'),
    4,
    TO_DATE('04/SEP/2022', 'DD/MON/YYYY'),
    '10K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    5,
    TO_DATE('04/SEP/2022 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('04/SEP/2022 12:25:00', 'DD/MON/YYYY HH24:MI:SS'),
    5,
    TO_DATE('04/SEP/2022', 'DD/MON/YYYY'),
    '5K'
);

-- entries supporting a charity
-- and not in a team

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    6,
    TO_DATE('04/SEP/2022 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('04/SEP/2022 12:35:00', 'DD/MON/YYYY HH24:MI:SS'),
    'RSPCA',
    6,
    TO_DATE('04/SEP/2022', 'DD/MON/YYYY'),
    '5K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    7,
    TO_DATE('01/FEB/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('01/FEB/2023 13:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Beyond Blue',
    7,
    TO_DATE('01/FEB/2023', 'DD/MON/YYYY'),
    '10K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    8,
    TO_DATE('01/FEB/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('01/FEB/2023 14:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Salvation Army',
    8,
    TO_DATE('01/FEB/2023', 'DD/MON/YYYY'),
    '21K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    9,
    TO_DATE('01/FEB/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('01/FEB/2023 12:20:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Amnesty International',
    9,
    TO_DATE('01/FEB/2023', 'DD/MON/YYYY'),
    '5K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    10,
    TO_DATE('01/FEB/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('01/FEB/2023 12:18:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Amnesty International',
    10,
    TO_DATE('01/FEB/2023', 'DD/MON/YYYY'),
    '3K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    11,
    TO_DATE('06/APR/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('06/APR/2023 13:50:00', 'DD/MON/YYYY HH24:MI:SS'),
    'RSPCA',
    1,
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    '21K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    12,
    TO_DATE('08/SEP/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('08/SEP/2023 12:20:00', 'DD/MON/YYYY HH24:MI:SS'),
    'RSPCA',
    6,
    TO_DATE('08/SEP/2023', 'DD/MON/YYYY'),
    '5K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    13,
    TO_DATE('08/SEP/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('08/SEP/2023 12:25:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Salvation Army',
    7,
    TO_DATE('08/SEP/2023', 'DD/MON/YYYY'),
    '5K'
);

-- entries supporting a charity
-- and in a team

-- Galloway Gang

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    14,
    TO_DATE('06/APR/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('06/APR/2023 15:45:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Beyond Blue',
    6,
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    '42K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    15,
    TO_DATE('06/APR/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('06/APR/2023 15:45:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Beyond Blue',
    7,
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    '42K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    16,
    TO_DATE('06/APR/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('06/APR/2023 15:45:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Beyond Blue',
    8,
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    '42K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    17,
    TO_DATE('06/APR/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('06/APR/2023 15:45:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Beyond Blue',
    9,
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    '42K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    18,
    TO_DATE('06/APR/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('06/APR/2023 15:45:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Beyond Blue',
    10,
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    '42K'
);

-- Fast & Furious

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    19,
    TO_DATE('06/APR/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('06/APR/2023 13:45:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Salvation Army',
    11,
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    '21K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    20,
    TO_DATE('06/APR/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('06/APR/2023 13:45:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Salvation Army',
    12,
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    '21K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    21,
    TO_DATE('06/APR/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('06/APR/2023 13:45:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Salvation Army',
    13,
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    '21K'
);

-- Roisin

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    22,
    TO_DATE('06/APR/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('06/APR/2023 16:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Amnesty International',
    16,
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    '42K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    23,
    TO_DATE('06/APR/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('06/APR/2023 16:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Amnesty International',
    17,
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    '42K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    24,
    TO_DATE('06/APR/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('06/APR/2023 16:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Amnesty International',
    18,
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    '42K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    25,
    TO_DATE('06/APR/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('06/APR/2023 16:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Amnesty International',
    19,
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    '42K'
);

-- Powerpuff trio

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    26,
    TO_DATE('08/SEP/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('08/SEP/2023 16:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Salvation Army',
    4,
    TO_DATE('08/SEP/2023', 'DD/MON/YYYY'),
    '42K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    27,
    TO_DATE('08/SEP/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('08/SEP/2023 16:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Salvation Army',
    5,
    TO_DATE('08/SEP/2023', 'DD/MON/YYYY'),
    '42K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    28,
    TO_DATE('08/SEP/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('08/SEP/2023 16:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    'Salvation Army',
    6,
    TO_DATE('08/SEP/2023', 'DD/MON/YYYY'),
    '42K'
);

-- Road Runners & Sylvester

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    29,
    TO_DATE('08/SEP/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('08/SEP/2023 16:30:00', 'DD/MON/YYYY HH24:MI:SS'),
    14,
    TO_DATE('08/SEP/2023', 'DD/MON/YYYY'),
    '42K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    30,
    TO_DATE('08/SEP/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('08/SEP/2023 16:30:00', 'DD/MON/YYYY HH24:MI:SS'),
    15,
    TO_DATE('08/SEP/2023', 'DD/MON/YYYY'),
    '42K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    31,
    TO_DATE('08/SEP/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('08/SEP/2023 16:30:00', 'DD/MON/YYYY HH24:MI:SS'),
    20,
    TO_DATE('08/SEP/2023', 'DD/MON/YYYY'),
    '42K'
);

-- Galloway Gang 2024

INSERT INTO entry (
    entry_id,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    32,
    'RSPCA',
    6,
    TO_DATE('20/FEB/2024', 'DD/MON/YYYY'),
    '21K'
);

INSERT INTO entry (
    entry_id,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    33,
    'RSPCA',
    7,
    TO_DATE('20/FEB/2024', 'DD/MON/YYYY'),
    '21K'
);

INSERT INTO entry (
    entry_id,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    34,
    'RSPCA',
    8,
    TO_DATE('20/FEB/2024', 'DD/MON/YYYY'),
    '21K'
);

INSERT INTO entry (
    entry_id,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    35,
    'RSPCA',
    9,
    TO_DATE('20/FEB/2024', 'DD/MON/YYYY'),
    '21K'
);

INSERT INTO entry (
    entry_id,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    36,
    'RSPCA',
    10,
    TO_DATE('20/FEB/2024', 'DD/MON/YYYY'),
    '21K'
);

-- Road Runners & Sylvester 2024

INSERT INTO entry (
    entry_id,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    37,
    'RSPCA',
    14,
    TO_DATE('20/FEB/2024', 'DD/MON/YYYY'),
    '10K'
);

INSERT INTO entry (
    entry_id,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    38,
    'RSPCA',
    15,
    TO_DATE('20/FEB/2024', 'DD/MON/YYYY'),
    '10K'
);

INSERT INTO entry (
    entry_id,
    char_name,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    39,
    'RSPCA',
    20,
    TO_DATE('20/FEB/2024', 'DD/MON/YYYY'),
    '10K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    40,
    TO_DATE('19/SEP/2021 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('19/SEP/2021 12:25:00', 'DD/MON/YYYY HH24:MI:SS'),
    4,
    TO_DATE('19/SEP/2021', 'DD/MON/YYYY'),
    '5K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    41,
    TO_DATE('04/SEP/2022 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('04/SEP/2022 12:22:00', 'DD/MON/YYYY HH24:MI:SS'),
    3,
    TO_DATE('04/SEP/2022', 'DD/MON/YYYY'),
    '5K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    42,
    TO_DATE('06/APR/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('06/APR/2023 12:19:00', 'DD/MON/YYYY HH24:MI:SS'),
    3,
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    '5K'
);

INSERT INTO entry (
    entry_id,
    entry_starttime,
    entry_finishtime,
    comp_no,
    carn_date,
    eventtype_code
) VALUES (
    43,
    TO_DATE('06/APR/2023 12:00:00', 'DD/MON/YYYY HH24:MI:SS'),
    TO_DATE('06/APR/2023 12:22:40', 'DD/MON/YYYY HH24:MI:SS'),
    2,
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    '5K'
);

--------------------------------------------------------------------------------
-- Insert into TEAM

-- 6,7,8,9,10 team Galloway Gang 06-APR-23 42K
-- 11,12,13 team Fast & Furious 06-APR-23 21K
-- 16,17,18,19 team Roisin 06-APR-23 42K

-- 4,5,6 team Powerpuff Trio 08-SEP-23 42K
-- 14,15,20 team Road Runners & Sylvester 08-SEP-23 42K

-- 6,7,8,9,10 team Galloway Gang 20-FEB-24 21K
-- 14,15,20 team Road Runners & Sylvester 20-FEB-24 10K

INSERT INTO team (
    team_id,
    team_name,
    carn_date,
    team_no_members,
    char_name,
    entry_id
) VALUES (
    1,
    'Galloway Gang',
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    5,
    'RSPCA',
    14
);

INSERT INTO team (
    team_id,
    team_name,
    carn_date,
    team_no_members,
    char_name,
    entry_id
) VALUES (
    2,
    'Fast and Furious',
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    3,
    'Salvation Army',
    19
);

INSERT INTO team (
    team_id,
    team_name,
    carn_date,
    team_no_members,
    char_name,
    entry_id
) VALUES (
    3,
    'Roisin',
    TO_DATE('06/APR/2023', 'DD/MON/YYYY'),
    4,
    'Amnesty International',
    22
);

INSERT INTO team (
    team_id,
    team_name,
    carn_date,
    team_no_members,
    char_name,
    entry_id
) VALUES (
    4,
    'Powerpuff Trio',
    TO_DATE('08/SEP/2023', 'DD/MON/YYYY'),
    3,
    'RSPCA',
    27
);

INSERT INTO team (
    team_id,
    team_name,
    carn_date,
    team_no_members,
    char_name,
    entry_id
) VALUES (
    5,
    'Road Runners and Sylvester',
    TO_DATE('08/SEP/2023', 'DD/MON/YYYY'),
    3,
    'RSPCA',
    30
);

INSERT INTO team (
    team_id,
    team_name,
    carn_date,
    team_no_members,
    char_name,
    entry_id
) VALUES (
    6,
    'Galloway Gang',
    TO_DATE('20/FEB/2024', 'DD/MON/YYYY'),
    5,
    'Beyond Blue',
    32
);

INSERT INTO team (
    team_id,
    team_name,
    carn_date,
    team_no_members,
    char_name,
    entry_id
) VALUES (
    7,
    'Road Runners and Sylvester',
    TO_DATE('20/FEB/2024', 'DD/MON/YYYY'),
    3,
    'RSPCA',
    37
);

COMMIT;

-- necessary updates:
-- adding team_id column to entry table and populating it to complete the data

-- team 1
UPDATE entry
SET
    team_id = 1
WHERE
    entry_id = 14;

UPDATE entry
SET
    team_id = 1
WHERE
    entry_id = 15;

UPDATE entry
SET
    team_id = 1
WHERE
    entry_id = 16;

UPDATE entry
SET
    team_id = 1
WHERE
    entry_id = 17;

UPDATE entry
SET
    team_id = 1
WHERE
    entry_id = 18;

-- team 2
UPDATE entry
SET
    team_id = 2
WHERE
    entry_id = 19;

UPDATE entry
SET
    team_id = 2
WHERE
    entry_id = 20;

UPDATE entry
SET
    team_id = 2
WHERE
    entry_id = 21;

-- team 3
UPDATE entry
SET
    team_id = 3
WHERE
    entry_id = 22;

UPDATE entry
SET
    team_id = 3
WHERE
    entry_id = 23;

UPDATE entry
SET
    team_id = 3
WHERE
    entry_id = 24;

UPDATE entry
SET
    team_id = 3
WHERE
    entry_id = 25;

-- team 4
UPDATE entry
SET
    team_id = 4
WHERE
    entry_id = 26;

UPDATE entry
SET
    team_id = 4
WHERE
    entry_id = 27;

UPDATE entry
SET
    team_id = 4
WHERE
    entry_id = 28;

-- team 5
UPDATE entry
SET
    team_id = 5
WHERE
    entry_id = 29;

UPDATE entry
SET
    team_id = 5
WHERE
    entry_id = 30;

UPDATE entry
SET
    team_id = 5
WHERE
    entry_id = 31;

-- team 6
UPDATE entry
SET
    team_id = 6
WHERE
    entry_id = 32;

UPDATE entry
SET
    team_id = 6
WHERE
    entry_id = 33;

UPDATE entry
SET
    team_id = 6
WHERE
    entry_id = 34;

UPDATE entry
SET
    team_id = 6
WHERE
    entry_id = 35;

UPDATE entry
SET
    team_id = 6
WHERE
    entry_id = 36;

-- team 7
UPDATE entry
SET
    team_id = 7
WHERE
    entry_id = 37;

UPDATE entry
SET
    team_id = 7
WHERE
    entry_id = 38;

UPDATE entry
SET
    team_id = 7
WHERE
    entry_id = 39;

COMMIT;