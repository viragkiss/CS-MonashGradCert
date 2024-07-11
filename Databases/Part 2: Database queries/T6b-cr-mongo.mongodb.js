//*****PLEASE ENTER YOUR DETAILS BELOW*****
//T6b-cr-nosql.txt

// ITO Assignment 2 Task 6b

//Student ID: 33724733
//Student Name: Virag Kiss

// Comments for your marker:

// ===================================================================================
// Do not modify or remove any of the comments in this document (items marked with //)
// ===================================================================================

//Use (connect to) your database - you MUST update xyz001
//with your authcate username

use("vkis0001");

//(b)
// PLEASE PLACE REQUIRED MONGODB COMMAND/S FOR THIS PART HERE
// ENSURE that your query is formatted and has a semicolon
// (;) at the end of this answer

//Drop collection 
db.events.drop();

//Create collection and insert documents all documents from 6a
db.events.insertMany(
    [
        {"_id":"19092021_10K","carnival_date":"19-09-2021","carnival_location":"The Tan, Birdwood Ave, Melbourne, 3004","event":{"type":"10K","description":"10 Km Run"},"no_competitors":2,"competitors":[{"comp_no":1,"name":"Cathy Freeman","gender":"Female","phone":"0422666777"},{"comp_no":3,"name":"Brigid Radcliffe","gender":"Female","phone":"1234567890"}]},
        {"_id":"19092021_5K","carnival_date":"19-09-2021","carnival_location":"The Tan, Birdwood Ave, Melbourne, 3004","event":{"type":"5K","description":"5 Km Run"},"no_competitors":2,"competitors":[{"comp_no":2,"name":"Rob De Costella","gender":"Male","phone":"0422888999"},{"comp_no":4,"name":"Bob Ryan","gender":"Male","phone":"0411222345"}]},
        {"_id":"04092022_10K","carnival_date":"04-09-2022","carnival_location":"The Tan, Birdwood Ave, Melbourne, 3004","event":{"type":"10K","description":"10 Km Run"},"no_competitors":1,"competitors":[{"comp_no":4,"name":"Bob Ryan","gender":"Male","phone":"0411222345"}]},
        {"_id":"04092022_5K","carnival_date":"04-09-2022","carnival_location":"The Tan, Birdwood Ave, Melbourne, 3004","event":{"type":"5K","description":"5 Km Run"},"no_competitors":3,"competitors":[{"comp_no":3,"name":"Brigid Radcliffe","gender":"Female","phone":"1234567890"},{"comp_no":6,"name":"Jane Ryan","gender":"Female","phone":"0411222345"},{"comp_no":5,"name":"Sam Ryan","gender":"Undisclosed","phone":"0411222345"}]},
        {"_id":"01022023_10K","carnival_date":"01-02-2023","carnival_location":"Bare Creek, Garigal National Park, Sydney, 2075","event":{"type":"10K","description":"10 Km Run"},"no_competitors":1,"competitors":[{"comp_no":7,"name":"Dan Chu","gender":"Male","phone":"0403999808"}]},
        {"_id":"01022023_21K","carnival_date":"01-02-2023","carnival_location":"Bare Creek, Garigal National Park, Sydney, 2075","event":{"type":"21K","description":"21.1 Km Half Marathon"},"no_competitors":1,"competitors":[{"comp_no":8,"name":"Srini Vash","gender":"Male","phone":"0411234567"}]},
        {"_id":"01022023_3K","carnival_date":"01-02-2023","carnival_location":"Bare Creek, Garigal National Park, Sydney, 2075","event":{"type":"3K","description":"3 Km Community Run/Walk"},"no_competitors":1,"competitors":[{"comp_no":10,"name":"Ling Shu","gender":"Undisclosed","phone":"0421909808"}]},
        {"_id":"01022023_5K","carnival_date":"01-02-2023","carnival_location":"Bare Creek, Garigal National Park, Sydney, 2075","event":{"type":"5K","description":"5 Km Run"},"no_competitors":1,"competitors":[{"comp_no":9,"name":"Nithin Pal","gender":"Male","phone":"0450789690"}]},
        {"_id":"06042023_21K","carnival_date":"06-04-2023","carnival_location":"Open Park, Massey Place, Indooroopilly, QLD, 4068","event":{"type":"21K","description":"21.1 Km Half Marathon"},"no_competitors":4,"competitors":[{"comp_no":1,"name":"Cathy Freeman","gender":"Female","phone":"0422666777"},{"comp_no":13,"name":"William Wang","gender":"Male","phone":"0421909808"},{"comp_no":12,"name":"Fan Shu","gender":"Male","phone":"0421909808"},{"comp_no":11,"name":"Nan Shu","gender":"Female","phone":"0421909808"}]},
        {"_id":"06042023_42K","carnival_date":"06-04-2023","carnival_location":"Open Park, Massey Place, Indooroopilly, QLD, 4068","event":{"type":"42K","description":"42.2 Km Marathon"},"no_competitors":9,"competitors":[{"comp_no":6,"name":"Jane Ryan","gender":"Female","phone":"0411222345"},{"comp_no":19,"name":"Juan Rose","gender":"Male","phone":"6112345678"},{"comp_no":18,"name":"Annamaria Rose","gender":"Female","phone":"6112345678"},{"comp_no":17,"name":"Adrianna Rose","gender":"Female","phone":"6187654321"},{"comp_no":16,"name":"Fernando Rose","gender":"Male","phone":"6112345678"},{"comp_no":10,"name":"Ling Shu","gender":"Undisclosed","phone":"0421909808"},{"comp_no":9,"name":"Nithin Pal","gender":"Male","phone":"0450789690"},{"comp_no":8,"name":"Srini Vash","gender":"Male","phone":"0411234567"},{"comp_no":7,"name":"Dan Chu","gender":"Male","phone":"0403999808"}]},
        {"_id":"06042023_5K","carnival_date":"06-04-2023","carnival_location":"Open Park, Massey Place, Indooroopilly, QLD, 4068","event":{"type":"5K","description":"5 Km Run"},"no_competitors":2,"competitors":[{"comp_no":2,"name":"Rob De Costella","gender":"Male","phone":"0422888999"},{"comp_no":3,"name":"Brigid Radcliffe","gender":"Female","phone":"1234567890"}]},
        {"_id":"08092023_42K","carnival_date":"08-09-2023","carnival_location":"William Park, Devon Park, SA, 5008","event":{"type":"42K","description":"42.2 Km Marathon"},"no_competitors":6,"competitors":[{"comp_no":4,"name":"Bob Ryan","gender":"Male","phone":"0411222345"},{"comp_no":20,"name":"Lynn Nguyen","gender":"Female","phone":"0433123456"},{"comp_no":15,"name":"Sebastian Coe","gender":"Male","phone":"0421990880"},{"comp_no":14,"name":"Pamela Sim","gender":"Female","phone":"0430450678"},{"comp_no":6,"name":"Jane Ryan","gender":"Female","phone":"0411222345"},{"comp_no":5,"name":"Sam Ryan","gender":"Undisclosed","phone":"0411222345"}]},
        {"_id":"08092023_5K","carnival_date":"08-09-2023","carnival_location":"William Park, Devon Park, SA, 5008","event":{"type":"5K","description":"5 Km Run"},"no_competitors":2,"competitors":[{"comp_no":6,"name":"Jane Ryan","gender":"Female","phone":"0411222345"},{"comp_no":7,"name":"Dan Chu","gender":"Male","phone":"0403999808"}]},
        {"_id":"20022024_10K","carnival_date":"20-02-2024","carnival_location":"Yarra Bend Park, Yarra Bend Rd, Fairfield, 3078","event":{"type":"10K","description":"10 Km Run"},"no_competitors":3,"competitors":[{"comp_no":14,"name":"Pamela Sim","gender":"Female","phone":"0430450678"},{"comp_no":20,"name":"Lynn Nguyen","gender":"Female","phone":"0433123456"},{"comp_no":15,"name":"Sebastian Coe","gender":"Male","phone":"0421990880"}]},
        {"_id":"20022024_21K","carnival_date":"20-02-2024","carnival_location":"Yarra Bend Park, Yarra Bend Rd, Fairfield, 3078","event":{"type":"21K","description":"21.1 Km Half Marathon"},"no_competitors":5,"competitors":[{"comp_no":6,"name":"Jane Ryan","gender":"Female","phone":"0411222345"},{"comp_no":10,"name":"Ling Shu","gender":"Undisclosed","phone":"0421909808"},{"comp_no":9,"name":"Nithin Pal","gender":"Male","phone":"0450789690"},{"comp_no":8,"name":"Srini Vash","gender":"Male","phone":"0411234567"},{"comp_no":7,"name":"Dan Chu","gender":"Male","phone":"0403999808"}]}
    ]
);



//(c)
// PLEASE PLACE REQUIRED MONGODB COMMAND/S FOR THIS PART HERE
// ENSURE that your query is formatted and has a semicolon
// (;) at the end of this answer

// List all documents you added
db.events.find();



//(d)
// PLEASE PLACE REQUIRED MONGODB COMMAND/S FOR THIS PART HERE
// ENSURE that your query is formatted and has a semicolon
// (;) at the end of this answer
db.events.find(
    {"no_competitors":{"$gt":2}},
    {"event.type":"10K"},
    {"_id":1,"carnival_date":1, "carnival_location":1, "no_competitors":1, "competitors.comp_no":1, "competitors.name":1}
);



//(e)
// PLEASE PLACE REQUIRED MONGODB COMMAND/S FOR THIS PART HERE
// ENSURE that your query is formatted and has a semicolon
// (;) at the end of this answer

db.events.updateMany(
    {
        "carnival_date":"01-02-2023"
    },
    {
        "$set":
        {
            "carnival_location":"Lake Gillawarna, Georges Hill, 2198"
        }
    }
);


// Illustrate/confirm changes made
db.events.find({"carnival_date":"01-02-2023"});


