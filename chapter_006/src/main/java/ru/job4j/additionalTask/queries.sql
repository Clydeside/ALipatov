-- names of all persons that are NOT in the company with id = 5
select p.name from company as c inner join person as p
    on p.company_id = c.id where c.id != 5;



-- company name for each person
select p.name, c.name from company as c inner join person as p
    on p.company_id = c.id;



-- Select the name of the company with the maximum number of persons + number of persons in this company
select max(c.name) into companyname from company as c inner join person as p
    on p.company_id = c.id;
select count(c.name) from company as c inner join person as p
    on p.company_id = c.id where (select * from companyname) = c.name;