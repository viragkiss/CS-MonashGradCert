--*****PLEASE ENTER YOUR DETAILS BELOW*****
--T4-cr-queries.sql

-- ITO Assignment 2 Task 4

--Student ID: 33724733
--Student Name: Virag Kiss

/* Comments for your marker:

Parts b, d, f: Could not use column aliases in some instances of in(), upper(), 
to_char() and count() functions as these generated errors.

*/

-- ENSURE that your SQL code is formatted and has a semicolon (;)
-- at the end of every statement. When marked this will be run as
-- a script.


/*
(a)
*/

SELECT
    to_char(en.carn_date, 'Dy DD Month YYYY') AS carnival_date,
    carn_name                                 AS carnname,
    eventtype_desc                            AS eventtypedesc,
    comp_fname
    || ' '
    || comp_lname                             AS fullname
FROM
         competitor c
    JOIN entry     en
    ON c.comp_no = en.comp_no
    JOIN event     ev
    ON ev.eventtype_code = en.eventtype_code
       AND ev.carn_date = en.carn_date
    JOIN carnival  c
    ON en.carn_date = c.carn_date
    JOIN eventtype t
    ON t.eventtype_code = en.eventtype_code
WHERE
    upper(comp_email) LIKE '%GMAIL.COM'
ORDER BY
    en.carn_date,
    fullname;


/*
(b)
*/
SELECT
    to_char(en.carn_date, 'Dy DD Month YYYY') AS carnival_date,
    a.char_name                               AS charity_name,
    comp_fname
    || ' '
    || comp_lname                             AS fullname,
    a.char_contact                            AS charity_contact,
    eventtype_desc                            AS eventtypedesc
FROM
         competitor c
    JOIN entry     en
    ON c.comp_no = en.comp_no
    JOIN charity   a
    ON en.char_name = a.char_name
    JOIN event     ev
    ON ev.eventtype_code = en.eventtype_code
       AND ev.carn_date = en.carn_date
    JOIN eventtype t
    ON t.eventtype_code = en.eventtype_code
WHERE
    en.char_name IN (
        SELECT
            char_name
        FROM
            charity
    )
    AND en.char_name IS NOT NULL
    AND upper(t.eventtype_desc) = upper('42.2 km Marathon')
ORDER BY
    en.carn_date,
    charity_name,
    fullname;


/*
(c)
*/
SELECT
    lpad(to_char(c.comp_no),
         length('compno'),
         ' ')   AS compno,
    comp_fname  AS compfname,
    comp_lname  AS complname,
    comp_gender AS compgender,
    rpad(to_char(' '
                 || COUNT(
        CASE
            WHEN((EXTRACT(YEAR FROM carn_date) =(EXTRACT(YEAR FROM current_date)) - 2
            )) THEN
                1
        END
    )),
         length('twoyrsback'),
         ' ')   AS twoyrsback,
    rpad(to_char(' '
                 || COUNT(
        CASE
            WHEN((EXTRACT(YEAR FROM carn_date) =(EXTRACT(YEAR FROM current_date)) - 1
            )) THEN
                1
        END
    )),
         length('lastcalyear'),
         ' ')   AS lastcalyear,
    CASE
        WHEN ( COUNT(
            CASE
                WHEN(EXTRACT(YEAR FROM carn_date) =(EXTRACT(YEAR FROM current_date)) - 1
                )
                    OR(EXTRACT(YEAR FROM carn_date) =(EXTRACT(YEAR FROM current_date)
                    ) - 2) THEN
                    1
            END
        ) ) > 0 THEN
            rpad(to_char(' '
                         || COUNT(
                CASE
                    WHEN(EXTRACT(YEAR FROM carn_date) =(EXTRACT(YEAR FROM current_date
                    )) - 1)
                        OR(EXTRACT(YEAR FROM carn_date) =(EXTRACT(YEAR FROM current_date
                        )) - 2) THEN
                        1
                END
            )),
                 length(' Completed no runs'),
                 ' ')
        ELSE
            rpad(' Completed no runs',
                 length(' Completed no runs'),
                 ' ')
    END         AS last2calendaryears
FROM
         competitor c
    JOIN entry en
    ON c.comp_no = en.comp_no
GROUP BY
    c.comp_no,
    comp_fname,
    comp_lname,
    comp_gender
ORDER BY
    last2calendaryears DESC,
    compno;


/*
(d)
*/
SELECT
    to_char(c.carn_date, 'DD-Mon-YYYY') AS carnival_date,
    c.carn_name                         AS carnname,
    COUNT(en.entry_id)                  AS total_entries5km
FROM
         carnival c
    JOIN event     ev
    ON c.carn_date = ev.carn_date
    JOIN entry     en
    ON ev.carn_date = en.carn_date
       AND ev.eventtype_code = en.eventtype_code
    JOIN eventtype t
    ON ev.eventtype_code = t.eventtype_code
WHERE
        to_char(c.carn_date, 'yyyy') = '2023'
    AND upper(t.eventtype_desc) = upper('5 Km Run')
GROUP BY
    c.carn_date,
    c.carn_name
ORDER BY
    total_entries5km DESC,
    carnival_date;


/* 
(e) 
*/
SELECT
    to_char(c.carn_date, 'DD-Mon-YYYY') AS carnival_date,
    c.carn_name                         AS carnname,
    t.eventtype_desc                    AS eventtypedesc
FROM
         carnival c
    JOIN event     ev
    ON c.carn_date = ev.carn_date
    JOIN eventtype t
    ON ev.eventtype_code = t.eventtype_code
WHERE
    c.carn_date < current_date
MINUS
SELECT
    to_char(c.carn_date, 'DD-Mon-YYYY') AS carnival_date,
    c.carn_name                         AS carnname,
    t.eventtype_desc                    AS eventtypedesc
FROM
         carnival c
    JOIN event     ev
    ON c.carn_date = ev.carn_date
    JOIN entry     en
    ON ev.carn_date = en.carn_date
       AND ev.eventtype_code = en.eventtype_code
    JOIN eventtype t
    ON ev.eventtype_code = t.eventtype_code
ORDER BY
    carnival_date,
    eventtypedesc;



/*
(f)
*/
SELECT
    team_name                            AS teamname,
    --lpad(to_char(en.carn_date), length('carnivaldate'), ' ')         AS carnivaldate,
    to_char(en.carn_date, 'DD-Mon-YYYY') AS carnivaldate,
    ' '
    || lpad(to_char(en.comp_no),
            4,
            '0')
    || ' '
    || c.comp_fname
    || ' '
    || c.comp_lname                      AS teamleader,
    t.team_no_members                    AS teamnomembers
FROM
         competitor c
    JOIN entry en
    ON c.comp_no = en.comp_no
    JOIN team  t
    ON en.team_id = t.team_id
    NATURAL JOIN (
        SELECT
            team_name,
            COUNT(team_name) AS teamcount
        FROM
            team
        GROUP BY
            team_name
        HAVING
            COUNT(team_name) = (
                SELECT
                    MAX(teamcount)
                FROM
                    (
                        SELECT
                            team_name,
                            COUNT(team_name) AS teamcount
                        FROM
                            team
                        GROUP BY
                            team_name
                    )
            )
        ORDER BY
            team_name
    )
WHERE
    t.entry_id = en.entry_id
GROUP BY
    team_name,
    en.carn_date,
    en.comp_no,
    c.comp_fname,
    c.comp_lname,
    t.team_no_members
ORDER BY
    teamname,
    carnivaldate;