-- MySQL dump 10.13  Distrib 8.0.30, for macos12.4 (arm64)
--
-- Host: localhost    Database: venued_db
-- ------------------------------------------------------
-- Server version	8.0.30
use venued_db;

USE venued_db;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answer`
--



DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) NOT NULL,
  `down_votes` bigint DEFAULT NULL,
  `up_votes` bigint DEFAULT NULL,
  `question_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7mluqeoggakn10mca9veouh1p` (`question_id`),
  KEY `FK68tbcw6bunvfjaoscaj851xpb` (`user_id`),
  CONSTRAINT `FK68tbcw6bunvfjaoscaj851xpb` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK7mluqeoggakn10mca9veouh1p` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,'They do card and they put an X mark on your hand with a sharpie if you\'re under 18.',5,15,NULL,4),(2,'I\'ve gotten there 5 hours early and there was still a long line! Some people camped out overnight to see\n    SZA',8,8,NULL,1),(3,'They don\'t patdown men or women at this venue',10,80,NULL,2),(4,'They do. They also make you go through a metal detector',0,45,NULL,3),(5,'No, they dont. I don\'t even know why this is listed on this website because it\'s a restaurant.',NULL,NULL,14,7);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `answered` int NOT NULL DEFAULT '0',
  `question` varchar(255) NOT NULL,
  `answer_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `venue_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrpls5f3p44jjllhddaceixe8n` (`answer_id`),
  KEY `FK5gvv7d57o43884mp8rvaj7w37` (`user_id`),
  KEY `FKgvey28kj0ry88x7yvmccnhe40` (`venue_id`),
  CONSTRAINT `FK5gvv7d57o43884mp8rvaj7w37` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKgvey28kj0ry88x7yvmccnhe40` FOREIGN KEY (`venue_id`) REFERENCES `venue` (`id`),
  CONSTRAINT `FKrpls5f3p44jjllhddaceixe8n` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,0,'Does anyone know if this place has a ChickFilA?',NULL,1,24),(2,0,'How much is the parking right in front of the stadium??',NULL,4,26),(3,1,'Do they card/id ppl under 18 after 10PM?',1,3,30),(4,1,'Do they check the inside of your bag when you enter the place?',4,2,39),(5,1,'How early should I get to this venue??',2,4,24),(6,1,'Does anyone know if they do patdowns on girls??',3,1,26),(10,0,'Does anyone know what the capacity for the bigger stage is??',NULL,7,24),(11,0,'Does anyone know if I can order a hotdog from the Dogfather from inside Bang Bang?',NULL,7,26),(13,0,'Do they have an outdoor patio?',NULL,7,30),(14,1,'Does this place even have any events?',5,7,39);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tips`
--

DROP TABLE IF EXISTS `tips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tips` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `down_votes` bigint DEFAULT NULL,
  `tip_content` varchar(255) NOT NULL,
  `tip_name` varchar(255) NOT NULL,
  `up_votes` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `venue_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5txxi7o5jkael1t752otft3k3` (`user_id`),
  KEY `FKqh9bf0972nk6vblscetel70jf` (`venue_id`),
  CONSTRAINT `FK5txxi7o5jkael1t752otft3k3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKqh9bf0972nk6vblscetel70jf` FOREIGN KEY (`venue_id`) REFERENCES `venue` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tips`
--

LOCK TABLES `tips` WRITE;
/*!40000 ALTER TABLE `tips` DISABLE KEYS */;
INSERT INTO `tips` VALUES (1,2,'You can park on St. Mary\'s street near Faust\'s Taven for free. It\'s a less than ten minute walk to get\n    here.','Free Parking',20,1,1),(2,90,'You can park across the street for $25 but you have to pay through an app.','Not Free Parking',3,2,1),(3,0,'Get there three hours early if the artist you want to see is super popular so you can get a good spot in\n    the front!!!!','Get there EARLY!!',100,3,2),(4,13,'DO NOT BUY the tip insurance!!! It\'s a scam. I tried to get a refund and the comapny asked for a DOCTOR\'S\n    SLIP with PROOF that I was sick during the dates of the concert. Complete bull****!','Ticket Insurance Scam',89,1,3),(5,1,'You can order hotdogs from the hotdog stand across the street (Dogfather) from the QR code at each table inside this bar! ','Hotdogs??',31,7,26);
/*!40000 ALTER TABLE `tips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `img_path` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `bio` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'frances@frances.com','https://media.licdn.com/dms/image/D4E03AQEA6WIBGmC-3w/profile-displayphoto-shrink_800_800/0/1668713783300?e=1678320000&v=beta&t=ym5lSa38RuVGDe7yigBKgJKgLg8w_ylcM5YFXpxHznk','123','frances','',NULL),(2,'rodrigo@rodrigo.com','https://media.licdn.com/dms/image/D4D35AQHLZINnUP1DBg/profile-framedphoto-shrink_800_800/0/1667488999849?e=1673470800&v=beta&t=6WONigkbLMy2kdrNQMpVycoPtz_0q4xheoCv1CmX5LA','123','rodrigo','',NULL),(3,'tesfalem@tesfalem.com','https://media.licdn.com/dms/image/D5635AQHPfalhyKe0_w/profile-framedphoto-shrink_800_800/0/1672687768415?e=1673470800&v=beta&t=znGSQnDSEp79ES3Zy-z3w3PYxDMjLzvy2st22eOz4mE','123','tesfalem','',NULL),(4,'deshawn@tesfalem.com','https://media.licdn.com/dms/image/D5635AQHIdlFrqXRr_Q/profile-framedphoto-shrink_800_800/0/1664338511404?e=1673470800&v=beta&t=XX14GqNeCvkOo-LKMPVDtQh8y74_jRVLIX49WqbOFkE','123','deshawn','',NULL),(7,'123@gmail.com','https://media.licdn.com/dms/image/D4E03AQEA6WIBGmC-3w/profile-displayphoto-shrink_800_800/0/1668713783300?e=1678320000&v=beta&t=ym5lSa38RuVGDe7yigBKgJKgLg8w_ylcM5YFXpxHznk','$2a$10$WprbxkU92sTMSqBKghq4Ueyis/LCIRHs5yQAT6NPWFYGewvgiQt0K','frankie144','',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venue`
--

DROP TABLE IF EXISTS `venue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venue` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `img_path` varchar(255) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `rating` varchar(255) DEFAULT NULL,
  `venue_alias` varchar(255) NOT NULL,
  `venue_id` varchar(255) DEFAULT NULL,
  `venue_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venue`
--

LOCK TABLES `venue` WRITE;
/*!40000 ALTER TABLE `venue` DISABLE KEYS */;
INSERT INTO `venue` VALUES (1,'600 St. Mary\'s St.',NULL,NULL,NULL,NULL,'papertiger_TX',NULL,'Paper Tiger'),(2,'100 Commerce St.',NULL,NULL,NULL,NULL,'alamodome_TX',NULL,'Alamodome'),(3,'123 Fast Ave.',NULL,NULL,NULL,NULL,'cota_TX',NULL,'Circut of the Americas'),(4,'1236 W Hildebrand Ave','','29.4662647','-98.5147095','5','alamo-city-golf-cars-san-antonio-2','JwgKVqjtaBrU5fKYnG3APg','Alamo City Golf Cars'),(5,'1149 W Hildebrand Ave','https://s3-media3.fl.yelpcdn.com/bphoto/9CIldDWjy0BJlys9Fx0xLQ/o.jpg','29.4667313','-98.5133632','4.5','alamo-candy-san-antonio','L0UXkRX9TMEhGL9vuyEtMA','Alamo Candy'),(6,'931 W Hildebrand Ave','https://s3-media1.fl.yelpcdn.com/bphoto/knP-js2VepZgNOhSI4542Q/o.jpg','29.4667587280273','-98.5090408325195','3.5','alamo-city-party-rents-san-antonio','k8kzoMjtYvnqZrxzdLCgSQ','Alamo City Party Rents'),(7,'4515B San Pedro Ave','https://s3-media2.fl.yelpcdn.com/bphoto/Hdw64c7IOVpNwo7cKhTOag/o.jpg','29.476027','-98.4995035','5','alamo-city-crossfit-san-antonio','xajoI4fPDcXiruzpE4i0TQ','Alamo City Crossfit'),(8,'1539 Santa Monica','','29.47221','-98.52067','1','alamo-city-courier-san-antonio','hC-147EWVAN6QK3XWWCgXA','Alamo City Courier'),(9,'3009 Blanco Rd','','29.47424','-98.50801','3.5','alamo-upholstery-san-antonio','b2egzNRdBwyIc4SS1P4PcA','Alamo Upholstery'),(10,'','https://s3-media3.fl.yelpcdn.com/bphoto/OTaReJEQnvB-oIgxu5_9GA/o.jpg','29.46663','-98.53541','5','alamo-city-shuttle-san-antonio','ptT9AWTq7KZ94j6VNzUsSw','Alamo City Shuttle'),(11,'5616 Ih-10 W','https://s3-media1.fl.yelpcdn.com/bphoto/QhVR7GFN5Rb1iUCKZ917rw/o.jpg','29.481372','-98.527084','1','alamo-paint-of-san-antonio-san-antonio','9yXRTwWaFw36YfTYv6nJgQ','Alamo Paint of San Antonio'),(12,'202 Quentin Dr','','29.468019','-98.531445','5','alamo-bathtub-refinishing-san-antonio','8rzR0I_F1KRSGc6Vng__1g','Alamo Bathtub Refinishing'),(13,'1110 Basse Rd','','29.48791','-98.50142','3','alamo-blinds-shade-and-shutter-san-antonio','rHQZoEMlfLaCj4Rs5iQMig','Alamo Blinds Shade & Shutter'),(14,'','','29.46964','-98.52915','1','alamo-city-granite-and-tile-san-antonio','a9u--hdJo5tAiKTel6ETIA','Alamo City Granite & Tile'),(15,'126 El Mio Dr','https://s3-media3.fl.yelpcdn.com/bphoto/E46tEZbKy679ytKXKX_RCw/o.jpg','29.493567','-98.500428','3.5','alamo-plumbing-solutions-san-antonio','l1SlAOT6ff_HMt4UwMmbJA','Alamo Plumbing Solutions'),(16,'5609 San Pedro Ave','https://s3-media3.fl.yelpcdn.com/bphoto/NZgqgPSgSPa-OeWVzDwcOQ/o.jpg','29.48556','-98.49953','4','alamo-gold-buyers-san-antonio-2','BSK36fwLjGb_c98RYX8LhQ','Alamo Gold Buyers'),(17,'5150 Broadway St','https://s3-media3.fl.yelpcdn.com/bphoto/_BcjXxd1OwFK1lwyF82nfA/o.jpg','29.4739620787896','-98.4626165174679','5','alamo-wedding-photography-and-videography-san-antonio','BoJBi8wonjWoOzNcrEJegQ','Alamo Wedding Photography & Videography'),(18,'3201 Cherry Ridge','https://s3-media1.fl.yelpcdn.com/bphoto/Oi7xZmsttoa2CzJLg79h-Q/o.jpg','29.5083405872715','-98.547574537207','3','alamo-xtreme-ac-and-heating-san-antonio','LQbBY1i9iT_fgTmSBH2VbA','Alamo Xtreme AC & Heating'),(19,'4923 Spyglass View','https://s3-media3.fl.yelpcdn.com/bphoto/-uh0a4iKYv26u5_3oblPRw/o.jpg','29.590336','-98.399603','5','craft-cruiser-san-antonio-4','yG6EwAp7GwHc5SXTrVp57Q','Craft Cruiser'),(20,'2230 Blanco Rd','https://s3-media2.fl.yelpcdn.com/bphoto/WyOspS8rBqiFCTsUceRz_Q/o.jpg','29.4674434661865','-98.5075759887695','4.5','alamo-feed-and-pet-supply-san-antonio','FsYSPzVOMcZMRqyS9Os0ng','Alamo Feed & Pet Supply'),(21,'203 S Crockett St','https://s3-media3.fl.yelpcdn.com/bphoto/2JGYFrNCF6poTHyWEb47pA/o.jpg','29.56792','-97.96264','5','the-haunted-magnolia-hotel-seguin','NXz8MX5Pc0YRyf5JgBCCGw','The Haunted Magnolia Hotel'),(22,'8535 Mission Rd','https://s3-media2.fl.yelpcdn.com/bphoto/awGZoHdJB1HZrUPWwxhRPw/o.jpg','29.3389379','-98.468016','5','alamo-helicopter-tours-san-antonio','YRbs1n0lVgwZxEjXAdVGvw','Alamo Helicopter Tours'),(23,'711 Navaro St','https://s3-media1.fl.yelpcdn.com/bphoto/CXZzxPC3qNNKNRPviU52Gw/o.jpg','29.4280907','-98.4900183','5','sa-food-tours-san-antonio','FV89bC7owxPgI1tL_TzMkA','SA Food Tours'),(24,'2410 N St Mary\'s St','https://s3-media4.fl.yelpcdn.com/bphoto/fIbJ04R8xQcZJqrvE-j39g/o.jpg','29.4487800598145','-98.4875869750977','3.5','paper-tiger-san-antonio','MyfcNWnm1raA9xrP-McquA','Paper Tiger'),(25,'1303 W Hildebrand Ave','https://s3-media3.fl.yelpcdn.com/bphoto/pctGxt0XVatqVmDHFnPu6Q/o.jpg','29.4668102719698','-98.517028838396','2.5','7-eleven-san-antonio-25','PyJdooqRCB_3xD9EWQXDTg','7-Eleven'),(26,'119 El Mio St','https://s3-media2.fl.yelpcdn.com/bphoto/bzmJ3Z0wnm12_dHtCcIVhA/o.jpg','29.493741067403','-98.4998858347535','4.5','the-bang-bang-bar-san-antonio','cZZlVk4bC1PTpgMMjybsFA','The Bang Bang Bar'),(27,'6211 San Pedro Ave','https://s3-media1.fl.yelpcdn.com/bphoto/4SbhXKymuV0pvw4XWZ3fNQ/o.jpg','29.49348041634231','-98.4996181','4.5','the-dogfather-san-antonio','fjQyLm3ktC8hqRm97cuYMA','The Dogfather'),(28,'3307 Fredericksburg Rd','https://s3-media3.fl.yelpcdn.com/bphoto/kbZYbJmxKk3aaqHFVcjdFg/o.jpg','29.47254','-98.5345','4','the-original-donut-shop-san-antonio','G-vSdp0nXdm9IX8aZkSeCg','The Original Donut Shop'),(29,'4102 Blanco Rd','https://s3-media3.fl.yelpcdn.com/bphoto/N4DLNx2J0u1vmbdeoqHivg/o.jpg','29.484394','-98.507507','4','texas-ice-service-san-antonio','6r9mcQ09myE2dWFW2SqzLA','Texas Ice Service'),(30,'447 W Hildebrand Ave','https://s3-media1.fl.yelpcdn.com/bphoto/eM3WifZJYsKhkOQi9-xCjQ/o.jpg','29.4668','-98.501297','3.5','ladybird-beer-garden-san-antonio','aFgfvN5S9lX_-HdXYNNsjA','LadyBird Beer Garden'),(31,'3711 West Ave','https://s3-media3.fl.yelpcdn.com/bphoto/VpFnTTB4OfH_6NmLyL17UQ/o.jpg','29.497207','-98.526458','4','joes-ice-house-san-antonio','wL3g1aWwqtaHVWSF6nxDOQ','Joe\'s Ice House'),(32,'1134 W Hildebrand Ave','https://s3-media2.fl.yelpcdn.com/bphoto/qHF15C8Sc92fmBB6bfmxmQ/o.jpg','29.466326479340584','-98.5133711736199','3.5','sa-country-saloon-san-antonio','eRY8JX0wc_HIgsgbLKv5JA','SA Country Saloon'),(33,'527 W Hildebrand Ave','https://s3-media4.fl.yelpcdn.com/bphoto/ZQUdsNBA6-84JVrCO4a4qA/o.jpg','29.46668','-98.50258','4.5','cream-kitchen-and-bar-san-antonio','ZJ3bdTNPF5TUaNnGzdamhg','Cream Kitchen And Bar'),(34,'1900 Fredericksburg Rd','https://s3-media3.fl.yelpcdn.com/bphoto/fDiuidjA0S315452pxNCXg/o.jpg','29.46275736996694','-98.5238696','4.5','black-potion-san-antonio','-s3uJtEAbzNvlfg8N7cxqQ','Black Potion'),(35,'3333 West Ave','https://s3-media3.fl.yelpcdn.com/bphoto/pLvr6zamjOzh8OK0LUwgQA/o.jpg','29.49242','-98.52645','4','coquetas-bar-and-grill-san-antonio','FKRaCIKSVq-31B4Hs7ShNA','Coquetas bar & grill'),(36,'3805 Blanco Rd','https://s3-media3.fl.yelpcdn.com/bphoto/6WIKYfdjkE9Eyf4Deckq0w/o.jpg','29.4816604','-98.5079749','1','stacys-sports-bar-san-antonio','ZN-HRGHl9magI9DPUoWtBQ','Stacy\'s Sports Bar'),(37,'1902 West Ave','https://s3-media3.fl.yelpcdn.com/bphoto/P36_EfDJIFOe0F84OSKf3Q/o.jpg','29.47871','-98.52576','3.5','happy-hut-san-antonio','8bJP-c4zhcOB-MrBsjG4FQ','Happy Hut'),(38,'','https://s3-media4.fl.yelpcdn.com/bphoto/J0OgZ7rgzMmKSF9HcxmFjA/o.jpg','29.468765258451675','-98.52826157256297','4.5','ooyoo-pan-san-antonio','pWTUyNKvNrP9yfl58bypeA','Ooyoo Pan'),(39,'1719 Blanco Rd','https://s3-media1.fl.yelpcdn.com/bphoto/r8qu503GQ7z17UwslrTIyQ/o.jpg','29.46222','-98.50805','4.5','sohill-cafe-san-antonio-2','BOkC5cpT3lkVljfDkFDilQ','SoHill Cafe'),(40,'3733 S Congress Ave','https://s3-media4.fl.yelpcdn.com/bphoto/7liZhQX2xVdk7A8T9kdMPw/o.jpg','30.226357','-97.762012','5','elizabeth-birdsong-photography-austin-2','n0JTIwvNxBpICBHO1k66gw','Elizabeth Birdsong Photography'),(41,'4522 Fredericksburg Rd','https://s3-media4.fl.yelpcdn.com/bphoto/F1pXhwucqwxLsMiQRKeFJg/o.jpg','29.4928534','-98.549665','4','pacoy-quality-jewelry-and-manufacturer-san-antonio-2','6JTcB6Hw8slLqVnRvI8e4A','Pacoy Quality Jewelry & Manufacturer'),(42,'8324 Steamline Cir','https://s3-media2.fl.yelpcdn.com/bphoto/UUcPb-H7KkTaiRN4KNWLVA/o.jpg','30.1878796','-97.8134918','5','live-oak-photo-booth-austin','nLgjM4keKzGvIsvo2nkCAg','Live Oak Photo Booth'),(43,'637 W Hildebrand Ave','https://s3-media2.fl.yelpcdn.com/bphoto/CKcD358-AfANaqRihHdrTA/o.jpg','29.4666976928711','-98.5040893554688','5','big-grass-living-san-antonio-2','stj5nrDXcX5eVVP60ZecMA','Big Grass'),(44,'','https://s3-media1.fl.yelpcdn.com/bphoto/zcqrSnXra2qNtNUJnelRNA/o.jpg','30.29017','-97.74484','3.5','how-about-henna-body-art-austin-9','ri--oFBLUxytWy9Zao8g7A','How About Henna?|Body Art'),(45,'5051 Ih 10','https://s3-media2.fl.yelpcdn.com/bphoto/lbQTrQBlY10Bjt7FgXz7PQ/o.jpg','29.4769611','-98.519104','3','art-of-nails-san-antonio','xb9PQHveyJIU2LpPLymCaQ','Art of Nails');
/*!40000 ALTER TABLE `venue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vote` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `direction` int NOT NULL,
  `tips_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo7r0aaii1027gxhmab7aarudp` (`tips_id`),
  KEY `FKcsaksoe2iepaj8birrmithwve` (`user_id`),
  CONSTRAINT `FKcsaksoe2iepaj8birrmithwve` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKo7r0aaii1027gxhmab7aarudp` FOREIGN KEY (`tips_id`) REFERENCES `tips` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote`
--

LOCK TABLES `vote` WRITE;
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-11  9:54:08
