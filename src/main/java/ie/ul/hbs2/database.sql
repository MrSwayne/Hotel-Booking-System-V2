-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

-- Table: hotels
CREATE TABLE IF NOT EXISTS hotels (
    Hid int  NOT NULL AUTO_INCREMENT,
    Name varchar(40)  NOT NULL,
    Country varchar(40)  NOT NULL,
    City varchar(40)  NOT NULL,
    Rooms int  DEFAULT 0,
    PRIMARY KEY (Hid)
);

-- Table: rooms
CREATE TABLE IF NOT EXISTS rooms (
    Rid int  NOT NULL AUTO_INCREMENT,
    Rnumber int  NOT NULL,
    Type varchar(40)  NOT NULL,
    available boolean  default TRUE,
    Price int  DEFAULT 0,
    Hid int  NOT NULL,
    PRIMARY KEY (Rid),
    FOREIGN KEY (Hid) REFERENCES hotels(Hid)
);

-- Table: guests
CREATE TABLE IF NOT EXISTS guests (
    Gid int  NOT NULL AUTO_INCREMENT,
    firstName varchar(40)  NOT NULL,
    lastName varchar(40)  NOT NULL,
    memberSince timestamp  DEFAULT current_timestamp,
    totalSpent int  DEFAULT 0,
    membershipLevel int DEFAULT 0,
    PRIMARY KEY (Gid)
);

-- Table: bookings
CREATE TABLE IF NOT EXISTS bookings (
    Bid int  NOT NULL AUTO_INCREMENT,
    dateIn timestamp  DEFAULT current_timestamp,
    dateOut timestamp  DEFAULT current_timestamp,
    Gid int  NOT NULL,
    Rid int  NOT NULL,
    PRIMARY KEY (Bid),
    FOREIGN KEY (Gid) REFERENCES guests(Gid),
    FOREIGN KEY (Rid) REFERENCES rooms(Rid)
);

-- Table: payments
CREATE TABLE IF NOT EXISTS payments (
    Pid int  NOT NULL AUTO_INCREMENT,
    IsPaid boolean  NOT NULL,
    TotalPrice int  NOT NULL,
    Bid int  NOT NULL,
    PRIMARY KEY (Pid),
    FOREIGN KEY (Bid) REFERENCES bookings(Bid)
);



-- Table: users
CREATE TABLE IF NOT EXISTS users (
    Uid int  NOT NULL AUTO_INCREMENT,
    FirstName varchar(40)  NOT NULL,
    LastName varchar(40)  NOT NULL,
    IsManager boolean  NOT NULL,
    Password varchar(40)  NOT NULL,
	Wages int NOT NULL,
    PRIMARY KEY (Uid)


);

UPDATE table SET datefield = NULL WHERE datefield = '0000-00-00 00:00:00';

INSERT INTO hotels VALUES (default, 'The Swayne','Netherlands','Amsterdam',70);
INSERT INTO hotels VALUES (default, 'The Duggans','Ireland','Galway',50);
INSERT INTO hotels VALUES (default, 'The McDonaghs','Iceland','Reykjavik',25);
INSERT INTO hotels VALUES (default, 'The Taddeis','Italy','Rome',150);
INSERT INTO hotels VALUES (default, 'The Marczaks','Japan','Kyoto',200);
INSERT INTO hotels VALUES (default, 'Azure Hotel','Germany','Berlin',120);
INSERT INTO hotels VALUES (default, 'Sapphire Hotel','England','London',300);
INSERT INTO hotels VALUES (default, 'Bronze Motel','France','Lyon',80);
INSERT INTO hotels VALUES (default, 'Stellar Hotel','Spain','Barcelona',110);
INSERT INTO hotels VALUES (default, 'Atlantic Hotel','Portugal','Lisbon',60);
INSERT INTO hotels VALUES (default, 'Drizzle Hotel','USA','New York',500);


INSERT INTO users VALUES (default, 'Caolan','McDonagh',TRUE,'nana',100000);
INSERT INTO users VALUES (default, 'Ian','Duggan',FALSE,'devops',20000);
INSERT INTO users VALUES (default, 'Adam','Swayne',TRUE,'Apple1',50000);
INSERT INTO users VALUES (default, 'Sabina','Taddei',FALSE,'MIA',35000);
INSERT INTO users VALUES (default, 'Patryk','Marczak',FALSE,'easy',40000);

INSERT INTO guests VALUES (default, 'Vera','Irwin','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Erica','Valenzuela','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Oscar','Valencia','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Quin','Barrera','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Len','Moss','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Ina','Deleon','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Fredericka','Olsen','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Upton','Graves','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Hyatt','Petersen','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Charissa','Dale','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Elvis','Farrell','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Hiram','Edwards','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Miriam','Short','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Harding','Sosa','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Illiana','Cross','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Hasad','Carey','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Victor','Santos','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Magee','Tanner','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Ali','Vazquez','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Rahim','Kelley','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Latifah','Estrada','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Prescott','Fields','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Duncan','Finch','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Brandon','Wilkins','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Melyssa','Hull','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Knox','Hester','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Otto','Meadows','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Nina','Dickerson','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Tiger','Clarke','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Ginger','Michael','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Finn','Prince','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Owen','Rios','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Hyacinth','Hudson','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Justina','Petersen','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Brianna','Mcconnell','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Shana','Garrison','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Odessa','Allison','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Rana','Whitley','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Zeph','Faulkner','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Hedy','Sloan','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Ocean','Allen','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Jonah','Conway','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Jaime','Cobb','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Dante','Landry','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Grady','Lynch','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Christian','Wiggins','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Oscar','Green','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Cedric','Chavez','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Amity','Jensen','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Lavinia','Hale','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Kevin','Mcintosh','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Caesar','Buck','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Megan','Boyer','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Imelda','Forbes','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Anastasia','Goodman','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Demetria','Giles','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Alika','Dorsey','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Marvin','Rojas','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Quinlan','Parker','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Tashya','Marks','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Inez','Leblanc','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Veda','Oneal','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Mason','Nelson','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Keegan','Brock','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Beau','Adkins','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Kamal','Hodges','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Britanni','Hall','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Hedy','Page','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Omar','Pace','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Mufutau','Blair','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Neil','Pierce','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Mary','Williams','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Sylvia','Klein','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'August','Fry','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Jackson','Kidd','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Keely','Chen','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Dai','Thornton','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Carl','Burt','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Hollee','Day','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Alexander','Bishop','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Hyatt','Goodwin','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Kennedy','French','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Nathaniel','Wells','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Travis','Barnes','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Wesley','Hickman','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Risa','Hutchinson','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Alden','Barrett','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Declan','Gallagher','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Megan','Kent','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Venus','Anderson','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Marsden','Puckett','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Rajah','Cruz','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Zane','Rodgers','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Joseph','Long','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Whilemina','Burnett','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Jael','Cantrell','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Gary','Weiss','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Buffy','Reid','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Hoyt','Acevedo','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Felix','Thomas','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Aristotle','Emerson','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Fredericka','Mcmahon','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Barry','Garza','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Virginia','Mullen','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'William','Bean','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Shana','Fox','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Cleo','Elliott','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Mannix','Stanley','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Wesley','Heath','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Malcolm','Daugherty','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Yardley','Clemons','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Nora','Gallagher','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Justin','Mccarty','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Kai','George','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Daniel','Buck','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Mira','Cain','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Robert','Fuller','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Abraham','Keith','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Ezekiel','Bailey','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Florence','Baldwin','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Hammett','Marquez','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Kareem','Reed','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Martina','Mercer','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Camille','Cleveland','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Flavia','Williamson','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Jolie','Cook','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Bertha','Parsons','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Raphael','Holcomb','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Nero','Salazar','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Darrel','Ballard','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Xenos','Berger','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Keefe','Buck','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Cally','Brady','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Brooke','Burris','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Clio','Boyer','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Christen','Greene','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Owen','Massey','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Wang','Leon','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Marsden','Evans','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Joel','Ray','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Oren','Alford','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Bree','Gentry','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Cynthia','Martin','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Aristotle','Price','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Jackson','Stephens','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Ori','Wynn','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Eagan','Guerrero','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Gillian','Holland','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Emerson','Vazquez','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Fredericka','Velez','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Lewis','Wright','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Wing','Fields','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Hanna','Beach','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Myles','Gordon','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Irma','Lee','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Abdul','Rogers','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Kyle','Holden','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Selma','Peters','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Dominic','Golden','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Neville','Hill','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Barbara','Sparks','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Rebekah','Hanson','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Anjolie','Rush','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Curran','Haynes','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Emi','Lamb','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Judith','Oneil','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Kiara','Maldonado','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Phoebe','Sloan','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Ruby','Collier','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Camille','Hanson','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Otto','Campbell','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'William','Byrd','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Mechelle','Todd','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Emery','Reyes','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Amity','Conway','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Xanthus','Gilmore','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Harriet','Craft','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Angela','Sherman','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Jaime','Murray','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Urielle','Frazier','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Francesca','Reynolds','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Murphy','Conner','27/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Chanda','Shepard','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Wylie','Knapp','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Josephine','Buckley','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Mollie','Shepard','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Astra','Olson','30/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Asher','Albert','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Chandler','Harris','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Ryan','Humphrey','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Adara','Richardson','29/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Quynn','Madden','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Brett','Ryan','01/11/2018', default, default);
INSERT INTO guests VALUES (default, 'Jessica','Ratliff','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Nichole','England','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Octavius','Whitaker','31/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Lucius','Mcguire','26/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Elizabeth','Joseph','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Stacy','Gray','28/10/2018', default, default);
INSERT INTO guests VALUES (default, 'Germane','Gilmore','26/10/2018', default, default);

INSERT INTO rooms VALUES (default, 1, 'Single', default, 50, 1);
INSERT INTO rooms VALUES (default, 2, 'Double', default, 100, 1);
INSERT INTO rooms VALUES (default, 3, 'King', default, 150, 1);
INSERT INTO rooms VALUES (default, 1, 'Single', default, 50, 2);
INSERT INTO rooms VALUES (default, 2, 'Double', default, 100, 2);
INSERT INTO rooms VALUES (default, 3, 'King', default, 150, 2);