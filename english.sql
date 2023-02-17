CREATE DATABASE  IF NOT EXISTS `english` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `english`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: english
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `meaning`
--

DROP TABLE IF EXISTS `meaning`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meaning` (
  `meaning_id` int NOT NULL AUTO_INCREMENT,
  `meaning` varchar(75) NOT NULL,
  `phrasal_fk_id` int NOT NULL,
  PRIMARY KEY (`meaning_id`,`phrasal_fk_id`),
  UNIQUE KEY `meaning_UNIQUE` (`meaning`),
  KEY `phrasal_fk_id_idx` (`phrasal_fk_id`),
  CONSTRAINT `phrasal_fk_id` FOREIGN KEY (`phrasal_fk_id`) REFERENCES `phrasal` (`phrasal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meaning`
--

LOCK TABLES `meaning` WRITE;
/*!40000 ALTER TABLE `meaning` DISABLE KEYS */;
INSERT INTO `meaning` VALUES (50,'Arrive at a station (for trains)',18),(37,'Ask for help ',19),(40,'Ask smn to do smth (especially to speak in public)',19),(56,'Attack',16),(33,'Be eliminated in a competition',21),(51,'Be functioning (of machines)',17),(35,'Be sent',21),(34,'Be transmitted',21),(25,'Become consious, wake up from anesthetic',2),(31,'Become unfashionable',21),(39,'Challange',19),(66,'Choose',10),(3,'Close or fasten clothes, etc.',5),(61,'Deal with, handle',13),(69,'Deceive, lie',9),(55,'Disappear, become obscured by a cloud',16),(71,'Do it again',8),(62,'Do smth tha shoul have been done earlier',24),(59,'Eat at home',15),(58,'Eat in a restaurant',14),(9,'Escape from people chasing you',7),(54,'Fit',16),(49,'Get dark earlier',18),(68,'Get fat',9),(24,'Get worlk, etc. up to date',12),(30,'Go on strike',21),(53,'Go to hospital for treatment, surgery, etc.',16),(60,'Have a good relationship with smn',13),(67,'Identify from a picture',10),(29,'Leave a place',21),(64,'Make notes or write down in full',11),(63,'Meet smn after a perion of time and find out what they have been doing',24),(32,'Move backwards, of a tide',21),(5,'Not include',3),(8,'Not punish',6),(1,'Pay a brief visit',1),(27,'Reach smn who was ahead of you',12),(65,'Remove',11),(4,'Repair and renovate',5),(2,'Replace someone / something with someone / something ',4),(28,'Result in',2),(70,'Start wearing',9),(26,'Stop burning, be exxtinguished ',21),(57,'Take medication or drugs, especially when they affect the person badly',17),(52,'Take place',17),(22,'Test, test smth to see if ou like it or want to by it',23),(23,'To join someone',22),(36,'To provoke a negative reaction',20),(38,'Visit',19);
/*!40000 ALTER TABLE `meaning` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phrasal`
--

DROP TABLE IF EXISTS `phrasal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phrasal` (
  `phrasal_id` int NOT NULL AUTO_INCREMENT,
  `phrasal` varchar(20) NOT NULL,
  PRIMARY KEY (`phrasal_id`),
  UNIQUE KEY `phresal_UNIQUE` (`phrasal`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phrasal`
--

LOCK TABLES `phrasal` WRITE;
/*!40000 ALTER TABLE `phrasal` DISABLE KEYS */;
INSERT INTO `phrasal` VALUES (20,'Ask for'),(17,'Be on'),(19,'Call on'),(12,'Catch up'),(24,'Catch up with'),(22,'Come along'),(2,'Come to'),(8,'Do over'),(5,'Do up'),(18,'Draw in'),(1,'Dropp by'),(15,'Eat in'),(14,'Eat out'),(13,'Get along with'),(16,'Go in'),(21,'Go out'),(3,'Leave out'),(6,'Let off'),(10,'Pick out'),(9,'Put on'),(7,'Run away'),(4,'Substitute for'),(11,'Take down'),(23,'Try out');
/*!40000 ALTER TABLE `phrasal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phrase`
--

DROP TABLE IF EXISTS `phrase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phrase` (
  `phrase_id` bigint NOT NULL AUTO_INCREMENT,
  `phrase` varchar(95) NOT NULL,
  `preposition_fk_id` int NOT NULL,
  PRIMARY KEY (`phrase_id`),
  KEY `preposition_fk_idx` (`preposition_fk_id`),
  CONSTRAINT `preposition_fk` FOREIGN KEY (`preposition_fk_id`) REFERENCES `preposition` (`preposition_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phrase`
--

LOCK TABLES `phrase` WRITE;
/*!40000 ALTER TABLE `phrase` DISABLE KEYS */;
INSERT INTO `phrase` VALUES (1,'He dropped _ today',18),(2,'The two men started arguin by soon the come _ conclusin',39),(3,'He was left _ of the side because he hasn\'t been playing too well lately',49),(4,'Will you substitute _ Tom while he is away?',21),(5,'You must do _ your safaty belt in the back of cars now',50),(6,'The judge let him _ with a fine rather than a prison sentence since it was his first offence',28);
/*!40000 ALTER TABLE `phrase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preposition`
--

DROP TABLE IF EXISTS `preposition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preposition` (
  `preposition_id` int NOT NULL AUTO_INCREMENT,
  `preposition` varchar(10) NOT NULL,
  PRIMARY KEY (`preposition_id`),
  UNIQUE KEY `preposition_UNIQUE` (`preposition`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preposition`
--

LOCK TABLES `preposition` WRITE;
/*!40000 ALTER TABLE `preposition` DISABLE KEYS */;
INSERT INTO `preposition` VALUES (1,'about'),(2,'above'),(3,'across'),(4,'after'),(5,'against'),(6,'along'),(7,'amid'),(8,'among'),(9,'around'),(10,'as'),(11,'at'),(12,'before'),(13,'behind'),(14,'below'),(15,'beneath'),(16,'beside'),(17,'beyond'),(18,'by'),(19,'despite'),(20,'down'),(21,'for'),(22,'from'),(23,'in'),(24,'into'),(25,'like'),(26,'near'),(27,'of'),(28,'off'),(29,'on'),(30,'onto'),(49,'out'),(31,'over'),(32,'past'),(33,'per'),(34,'regarding'),(35,'round'),(36,'since'),(37,'than'),(38,'through'),(39,'to'),(40,'toward'),(41,'towards'),(42,'under'),(43,'underneath'),(44,'unlike'),(50,'up'),(45,'upon'),(46,'with'),(47,'within'),(48,'without');
/*!40000 ALTER TABLE `preposition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `word`
--

DROP TABLE IF EXISTS `word`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `word` (
  `word_id` bigint NOT NULL AUTO_INCREMENT,
  `word_english` varchar(65) NOT NULL,
  `word_ukrainian` varchar(65) NOT NULL,
  PRIMARY KEY (`word_id`)
) ENGINE=InnoDB AUTO_INCREMENT=264 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `word`
--

LOCK TABLES `word` WRITE;
/*!40000 ALTER TABLE `word` DISABLE KEYS */;
INSERT INTO `word` VALUES (1,'Slums','Нетрі'),(2,'Neglact / derelict','Занедбаний'),(3,'Upmarket','Елітний'),(4,'Inner city','Зона біля центру міста'),(5,'Clock on','Зазначити початок роботи'),(6,'Clock off','Зазначити кінець роботи'),(7,'Knock off','Закінчувати роботу'),(8,'Flexitime','Мати різні робочі години'),(9,'Full-time job','Повна зайнятійсть'),(10,'Part-time job','Часткова зайнятість'),(11,'Day work','Денна робота'),(12,'Night work','Нічна робота'),(13,'Shifts-night / day / morning / afternoon','Працювати зімни (відпрацювання)'),(14,'Overtime','Працювати понаднормово'),(15,'Lunchbreak','Обідня перерва'),(16,'Day off','Вихідний день'),(17,'Sick leave','Вихідний по стану здоров\'я'),(18,'Maternity leave','Декрет'),(19,'Take time off work','Брати вихідний'),(20,'Meet deadlines','Вкластися в термін'),(21,'Objectives','Цілі'),(22,'Heavy workload','Велике завантаження на роботі'),(23,'Light workload','Легке завантажання на роботі'),(24,'Long working hours','Багато робочих годин'),(25,'Take early retirement','Піти рано на пенсію'),(26,'Get the sack / get fired','Бути звільненим'),(27,'Be made redunbdant','Бути скороченим'),(28,'Densly populated','Густо населене'),(29,'Built-up area','Густо забудована зона/район'),(30,'Residentioal area','Спальний район'),(31,'Commercial area/district','Комерційний район'),(32,'Centre','Центр'),(33,'Outskirts','Околиці'),(34,'Suburbs','Передмістя'),(35,'Urban','Міський'),(36,'Neighbourhood','Район'),(37,'Local amenities/facilities','Інфраструктура'),(38,'Poor housing area','Зона з занедбаними будинками'),(39,'Up-and-coming','Зона яка розвивається'),(40,'Run-down','Ставати занедбаним'),(41,'Deprived','Позбавлений зруностей, з малою к-стю населення'),(42,'Lively neighbourhood','Жвавий район'),(43,'Regenerated area','Зона яка була відновлена '),(44,'Sprawling city','Місто яке збільшується'),(45,'Be / get addicted to drugs / be / get hooked on drugs','Бути залежним від наркотиків'),(46,'Contraversual','Суперечливий'),(47,'Addicts','Залежний від наркотиків'),(48,'Junkie','Наркоман'),(49,'User (drug user)','Наркоман'),(50,'Get clean/to fix a drug habit','Перестати вживати наркотики'),(51,'Rehab (rehabilitation)','Реабілітація від наркотиків'),(52,'Be on drugs','Вживати наркотики'),(53,'Soft / hard drugs','Легкі/важкі наркотики'),(54,'Drug habit','Мати звчичку вживати наркотики'),(55,'Supply the drug habbit','Підтримувати звичку вживати наркотики'),(56,'Drug dealer/pusher','Продавець наркотиків'),(57,'Over-the-counter drug','Наркотик, який продається без виписки'),(58,'Prescription','Виписка на ліки/наркотики'),(59,'Get high on','Отримувати задоволення від чогось'),(60,'Get wasted on','Бути пригніченим через щось'),(61,'Recreational drug use','Вживати наркотики на дозвіллі'),(62,'O.D. (be O.D. on smth)','Передозування чимось'),(63,'Upper drug','Наркотик, що робить тебе веселим'),(64,'Downer drug','Наркотик, що робить тебе пригрічеим'),(65,'Drug traficking','Наркотичний трафік'),(66,'Drug raid','Наркооблава (рейд по наркотрафіку)'),(67,'Bear fruit','Бути вдалим, доягти цілей'),(68,'Get off the ground','Стати успішним'),(69,'Get off on the right foot','Почати стосунки на хорошій ноті'),(70,'Work like a dream','Повністю успішна ідея'),(71,'Hit the mark','Досягти поставлених цілей/результатів'),(72,'Make it big/make the grade','Стати успішним'),(73,'Work wonders','Спрацювало так, як мало спрацювати'),(74,'To go/run like clockwork','Рухаєтися \"як по маслу\"'),(75,'Go according to plan','Йти відповідно до плану'),(76,'To fall into place','Ставати на свої місця'),(77,'Go from strength to strength','Ставати краще і краще'),(78,'Come to nothing','Нівелюватись, не спрацювати'),(79,'Fall flat (idea falls flet)','Не сприйнята іншими'),(80,'Draw a blank','Не досягнти очікуваних результатів'),(81,'Get off on the wrong foot','Почати стосунки на поганій ноті'),(82,'Go pear-shaped','Не увінчатись успіхом'),(83,'Miss the mark','Не досягти поставлених цілей'),(84,'Fight a losing battle','Боротись за програшне'),(85,'Not last five minutes','Не прожити довго'),(86,'Cut your losses','Сприйняти програш та зупинити втрати'),(87,'Dead in the water','Бути неуспішним на стадії планування'),(88,'Bite the dust','Зазнати невдачі/померти'),(89,'Illness / ailment / medical disorder','Хвороба'),(90,'Allergic to smth','Алергія на щось'),(91,'Antibiotics','Антибіотики'),(92,'Medication','Лікувальний засіб'),(93,'Minor / major surgery','Легка/важка хірургія'),(94,'Operaion','Хірургічна операція'),(95,'Fistaid','Перша допомога'),(96,'Cream','Крем/лікувальий крем(мазь)'),(97,'Pills','Таблетки'),(98,'Plastet / band-aid','Пластир'),(99,'Pain killer','Знеболювальне'),(100,'Aches and pains','Біль'),(101,'Scratch','Царапка'),(102,'Cut / deep cut','Поріз'),(103,'Bruise','Забій'),(104,'To feell dizzy / feel lingt-headed','Запаморочення'),(105,'Fever','Гарячка'),(106,'High / low blood','Високий/низький тиск крові'),(107,'To dislocate a joint','Витягти суглоб'),(108,'Fracture/break a bone','Перелом'),(109,'Picturesque','Візуально привалбливий'),(110,'Quaint','Незвичайно привабливий (невідомо чим притягує)'),(111,'Remote','Відделний'),(112,'Srcluded','Віддалений (важко добратись), де дуже мало людей'),(113,'Unspoilt / unspoiled (USA) / virgin','Не спорчений людьми'),(114,'Sleepy plact','Спокійне місце, без великої активності'),(115,'Dodgy / seedy area','Потенційно небезпечне місце'),(116,'Shabby','Запущене місце без реновацій'),(117,'Boring (with no life) / dull places','Нудне, сумне місце'),(118,'Bustling','Жваве, з великою к-стю активності'),(119,'Polluted','Забруднене'),(120,'Lively','Живе, жваве'),(121,'Noisy','Шемне'),(122,'Touristy','Туристично привабливе'),(123,'Cosmopolitan','Багатонаціональне'),(124,'Multicultural','Багатокультурне'),(125,'Politician','Політик'),(126,'Members of parlaiment','Парламентарії'),(127,'Upper house (senate)','Сенат'),(128,'Lower house (house of reprresentatives)','Будинок продставників'),(129,'Monarchy','Монархія'),(130,'Rebublics','Республіка'),(131,'Dictatorships','Диктаторство'),(132,'Cotton','Бавовняний'),(133,'Denim','Бавовняна тканина'),(134,'Cashmere','Кашеміровий'),(135,'Linen','Льон'),(136,'Lycra','Лайкра'),(137,'Suede','Замша'),(138,'Silk','Шовка'),(139,'Wool','Вовна'),(140,'Leather','Шкіра'),(141,'Corduroy','Рубчастий вельвет'),(142,'Velvet','Вельвет'),(143,'Checked','В клітинку'),(144,'Flowery','В квітку'),(145,'Striped','В полоску'),(146,'Spotted','В точку'),(147,'Plain','Без малюнку'),(148,'Baggy','Мішкуватий'),(149,'Loose','Вільний'),(150,'Tight / close-fitting','Обтягуючий населене'),(151,'Long sleeved','З довгим рукавом'),(152,'Short sleeved','З короткиим рукавом'),(153,'V-neck','V-виріз біля шиї'),(154,'Round-neck','Круглий виріз біля шиї'),(155,'Polo-neck','З великим коміром'),(156,'Collar','Комір'),(157,'Cash','Готівка'),(158,'Cheque / check','Розрахунковий чек / чек'),(159,'Credit / debit card','Кредитка'),(160,'Cash point / ATM (automatic teller machine)','Банкомат'),(161,'Pin number','Пін-код'),(162,'Withdrawl','Видача готівки'),(163,'Deposit','Внесення коштів на рахунок / відкладені кошти'),(164,'Transfer','Переказ'),(165,'Bank accaunt','Банківський рахунок'),(166,'Bank statement','Сиписка з банку (список всіз операцій)'),(167,'Overdrawn/go in the red','Мінус по карті'),(168,'Direct debit','Періодичне автоматичне зняття коштів з карти'),(169,'Standing order','Періочиний переказ коштів з карти'),(170,'Loan','Кредик (позика)'),(171,'Mortgage','Іпотека'),(172,'Celebrity / personality','Знаменитість'),(173,'Be a houshold name','Бути відомим'),(174,'World famous','Всесвітньо відомий'),(175,'Local celebrity','Місцева знаменитість'),(176,'International celebrity','Всесвітня знаменитість'),(177,'Rise to fame / statdom','Стати знаменитим'),(178,'Big / lucky break','Справа, що тебе прославить'),(179,'Lavish lifestyle','Витрачання коштів лише на найкраще'),(180,'Mansion','Маєток'),(181,'Be in the lime light / public eye','Бути на виду у публіки'),(182,'Private jet','Приватний літак'),(183,'Entourage','група людей, які зажди переслідують знаменитість'),(184,'First name','Ім\'я'),(185,'Middle name','Друге ім\'я'),(186,'Surname / last name / family name','Прізвище'),(187,'Full name','Повне ім\'я'),(188,'Initials','Ініціали'),(189,'Nickname','Кличка'),(190,'Maiden name','Дівоче ім\'я'),(191,'Title (mr, ms, etc) ','Приставка до імені'),(192,'Autograph','Автограф'),(193,'Signature','Підпис'),(194,'Sign your name','Розписатись, підписатись'),(195,'False name','Неспарвжнє ім\'я'),(196,'Pseudonym','Псевдонім'),(197,'Pen name','Письменне ім\'я'),(198,'Stage name','Сценічне ім\'я'),(199,'Screen name','Акторське ім\'я'),(200,'Collocation','фразеологізм, словосполучення, взаємопов\'язані слова'),(201,'Earn / make money','Заробляти гроші'),(202,'Lend','Позичати (давати в борг)'),(203,'Borrow','Позичати (брати в борг)'),(204,'Waste','Марнотратити'),(205,'Invest','Інверстувати'),(206,'Inherit','Унаслідувати'),(207,'Owe','Заборгувати'),(208,'Pay back','Віддавати заборговане'),(209,'House','Дім'),(210,'Flat','Квартира'),(211,'Apartment','Апартаменти'),(212,'Rent','Оренда'),(213,'Sublet','Суборенда'),(214,'First-time buyer','Покупець свого першого дому'),(215,'Tenants','Орендар'),(216,'Landlord / landlady','Орендодавець'),(217,'References','Відкгуки (рецензія)'),(218,'Counsil / public housing','Житло надане державою'),(219,'Houses crisis / shortage','Житлова криза'),(220,'Evicting','Виселення'),(221,'Squatting','Нелегальне проживання в будинку'),(222,'Sleep rough','Ночівля в поганих умовах'),(223,'Homeless','Бездомний'),(224,'Congestion','нагромадження'),(225,'Traffic jam','Затор, корок'),(226,'Be backed up / gridlock','Бути заблокованим'),(227,'Rush / peak hour','Година пік'),(228,'Bottleneck','Звуження дороги'),(229,'Hold ups','Затримки в трафіку'),(230,'Arson','Підпал'),(231,'Bigamy','Многожонство'),(232,'Burglary','Пограбування дому'),(233,'Drug dealing','Торгівля наркотиками'),(234,'Counterfeiting / forgery','Підробка, лагіат'),(235,'Hijacking','Незаконне управління чимось (транспортом)'),(236,'Kidnapping','Викрадення дітей (домашніх тварин)'),(237,'Mugging','Вуличне пограбування'),(238,'Murder','Вбивство'),(239,'Pickpocketting','Кишенькова крадіжка'),(240,'Robbery','Крупне пограбування'),(241,'Shoplifting','Крадіжка в магазині'),(242,'Smuggling','Котнрабанда'),(243,'Theft','Крадіжка'),(244,'Vandalism','Вандалізм'),(245,'Forecast','Прогнощ погоди'),(246,'Freezing','Дуже холодно'),(247,'Cold','Холодно'),(248,'Chilly','Прохолодно (ближче до золодного)'),(249,'Mild ','Помірно'),(250,'Cool','Прохолодно (ближче до теплого)'),(251,'Warm','Тепло'),(252,'Hot','Спекотно'),(253,'Scorcher','Гаряче, жарко'),(254,'Boiling hot','Дуже жарко'),(255,'Humid','Волого'),(256,'Muggy','Душно'),(257,'Stifling','Задушливо'),(258,'Sweltering','Неприємно жарко'),(259,'Cold spell','Холодний період'),(260,'Hot spell / heat wawe','Теплий період'),(261,'Bias','Упередженість'),(262,'Dictum','Вислів'),(263,'Vitriolic','Гіркиа, різка (критика, фраза і т.п.)');
/*!40000 ALTER TABLE `word` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-02 22:01:02
