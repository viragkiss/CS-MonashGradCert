--*****PLEASE ENTER YOUR DETAILS BELOW*****
--T6a-cr-json.sql

-- ITO Assignment 2 Task 6a

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
SET PAGESIZE 300

SELECT
        JSON_OBJECT(
            '_id' VALUE to_char(carn_date, 'DDMMYYYY')
                        || '_'
                        || eventtype_code,
                    'carnival_date' VALUE to_char(carn_date, 'DD-MM-YYYY'),
                    'carnival_location' VALUE carn_location,
                    'event' VALUE
                JSON_OBJECT(
                    'type' VALUE eventtype_code,
                    'description' VALUE eventtype_desc
                ),
                    'no_competitors' VALUE(COUNT(entry_id)),
                    'competitors' VALUE JSON_ARRAYAGG(
                JSON_OBJECT(
                    'comp_no' VALUE comp_no,
                            'name' VALUE comp_fname
                                         || ' '
                                         || comp_lname,
                            'gender' VALUE(decode(upper(comp_gender),
                                                  'F',
                                                  'Female',
                                                  'M',
                                                  'Male',
                                                  'U',
                                                  'Undisclosed')),
                            'phone' VALUE rtrim(comp_phone)
                )
            )
        FORMAT JSON)
        || ','
FROM
         entry
    NATURAL JOIN event
    NATURAL JOIN carnival
    NATURAL JOIN competitor
    NATURAL JOIN eventtype
GROUP BY
    carn_date,
    eventtype_code,
    carn_location,
    eventtype_desc
ORDER BY
    carn_date;