USE venued_db;

INSERT INTO user(email, password, username, img_path) VALUES
   ('frances@frances.com','123','frances',"https://media.licdn.com/dms/image/D4E03AQEA6WIBGmC-3w/profile-displayphoto-shrink_800_800/0/1668713783300?e=1678320000&v=beta&t=ym5lSa38RuVGDe7yigBKgJKgLg8w_ylcM5YFXpxHznk"),
   ('rodrigo@rodrigo.com','123','rodrigo',"https://media.licdn.com/dms/image/D4D35AQHLZINnUP1DBg/profile-framedphoto-shrink_800_800/0/1667488999849?e=1673470800&v=beta&t=6WONigkbLMy2kdrNQMpVycoPtz_0q4xheoCv1CmX5LA"),
   ('tesfalem@tesfalem.com','123','tesfalem',"https://media.licdn.com/dms/image/D5635AQHPfalhyKe0_w/profile-framedphoto-shrink_800_800/0/1672687768415?e=1673470800&v=beta&t=znGSQnDSEp79ES3Zy-z3w3PYxDMjLzvy2st22eOz4mE"),
   ('deshawn@tesfalem.com','123','deshawn',"https://media.licdn.com/dms/image/D5635AQHIdlFrqXRr_Q/profile-framedphoto-shrink_800_800/0/1664338511404?e=1673470800&v=beta&t=XX14GqNeCvkOo-LKMPVDtQh8y74_jRVLIX49WqbOFkE");

INSERT INTO venue(id, venue_name, address, venue_alias) VALUES
    (1, "Paper Tiger", "600 St. Mary's St.", "papertiger_TX"),
    (2, "Alamodome", "100 Commerce St.", "alamodome_TX"),
    (3, "Circut of the Americas", "123 Fast Ave.", "cota_TX");

INSERT INTO answer(id, answer, user_id, up_votes, down_votes) VALUES
    (1, "They do card and they put an X mark on your hand with a sharpie if you're under 18.", 4, 15, 5),
    (2, "I've gotten there 5 hours early and there was still a long line! Some people camped out overnight to see
    SZA", 1, 8, 8),
    (3, "They don't patdown men or women at this venue", 2, 80, 10),
    (4, "They do. They also make you go through a metal detector", 3, 45, 0 );

INSERT INTO questions(id, question, user_id, venue_id, answered) VALUES
   (1, "Does anyone know if this place has a ChickFilA?", 1, 1,0, NULL),
   (2, "How much is the parking right in front of the stadium??", 4, 1, 0, NULL),
   (3, "Do they card/id ppl under 18 after 10PM?", 3, 1, 1, 1),
   (4, "Do they check the inside of your bag when you enter the place?", 2, 1, 1, 4),
   (5, "How early should I get to this venue??", 4, 1, 1, 2),
   (6, "Does anyone know if they do patdowns on girls??", 1, 1, 1, 3);



INSERT INTO tips(down_votes, up_votes, tip_content, tip_name, user_id, venue_id) VALUES
    (2, 20, "You can park on St. Mary's street near Faust's Taven for free. It's a less than ten minute walk to get
    here.", "Free Parking", 1, 1),
    (90, 3, "You can park across the street for $25 but you have to pay through an app.", "Not Free Parking", 2, 1),
    (0, 100, "Get there three hours early if the artist you want to see is super popular so you can get a good spot in
    the front!!!!", "Get there EARLY!!", 3, 2),
    (13, 89,"DO NOT BUY the tip insurance!!! It's a scam. I tried to get a refund and the comapny asked for a DOCTOR'S
    SLIP with PROOF that I was sick during the dates of the concert. Complete bull****!", "Ticket Insurance Scam", 1,
     3);



