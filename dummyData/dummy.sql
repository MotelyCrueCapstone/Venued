USE venued_db;

INSERT INTO user(email, password, user_name, img_path) VALUES
                                                           ('frances@frances.com','123','frances',"https://media.licdn.com/dms/image/D4E03AQEA6WIBGmC-3w/profile-displayphoto-shrink_800_800/0/1668713783300?e=1678320000&v=beta&t=ym5lSa38RuVGDe7yigBKgJKgLg8w_ylcM5YFXpxHznk"),
                                                           ('rodrigo@rodrigo.com','123','rodrigo',"https://media.licdn.com/dms/image/D4D35AQHLZINnUP1DBg/profile-framedphoto-shrink_800_800/0/1667488999849?e=1673470800&v=beta&t=6WONigkbLMy2kdrNQMpVycoPtz_0q4xheoCv1CmX5LA"),
                                                           ('tesfalem@tesfalem.com','123','tesfalem',"https://media.licdn.com/dms/image/D5635AQHPfalhyKe0_w/profile-framedphoto-shrink_800_800/0/1672687768415?e=1673470800&v=beta&t=znGSQnDSEp79ES3Zy-z3w3PYxDMjLzvy2st22eOz4mE"),
                                                           ('deshawn@tesfalem.com','123','deshawn',"https://media.licdn.com/dms/image/D5635AQHIdlFrqXRr_Q/profile-framedphoto-shrink_800_800/0/1664338511404?e=1673470800&v=beta&t=XX14GqNeCvkOo-LKMPVDtQh8y74_jRVLIX49WqbOFkE");
INSERT INTO venue(id, venue_name, address, venue_alias) VALUES
                                                            (1, "Paper Tiger", "600 St. Mary's St.", "papertiger_TX"),
                                                            (2, "Alamodome", "100 Commerce St.", "alamodome_TX"),
                                                            (3, "Circut of the Americas", "123 Fast Ave.", "cota_TX");

INSERT INTO questions(id, question, user_id, venue_id) VALUES
                                                           (1, "Does anyone know if this place has a ChickFilA?", 1, 2),
                                                           (2, "How much is the parking right in front of the stadium??", 4, 2),
                                                           (3, "Do they card/id ppl under 18 after 10PM?", 3, 1),
                                                           (4, "Do they check the inside of your bag when you enter the place?", 2, 3)

INSERT INTO tips(down_votes, up_votes, tip_content, tip_name, user_id, venue_id) VALUES
    (2, 20, "You can park on St. Mary's street near Faust's Taven for free. It's a less than ten minute walk to get
    here.", "Free Parking", 1, 1),
    (90, 3, "You can park across the street for $25 but you have to pay through an app.", "Not Free Parking", 2, 1),
    (0, 100, "Get there three hours early if the artist you want to see is super popular so you can get a good spot in
    the front!!!!", "Get there EARLY!!", 3, 2),
    (13, 89,"DO NOT BUY the tip insurance!!! It's a scam. I tried to get a refund and the comapny asked for a DOCTOR'S
    SLIP with PROOF that I was sick during the dates of the concert. Complete bull****!", "Ticket Insurance Scam", 1, 3)



