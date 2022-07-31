-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: busan
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `origin_chapter2_choice`
--

DROP TABLE IF EXISTS `origin_chapter2_choice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `origin_chapter2_choice` (
  `choiceId` int NOT NULL,
  `choiceNum` varchar(20) NOT NULL,
  `choiceMain` varchar(1000) DEFAULT NULL,
  `check` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`choiceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `origin_chapter2_choice`
--

LOCK TABLES `origin_chapter2_choice` WRITE;
/*!40000 ALTER TABLE `origin_chapter2_choice` DISABLE KEYS */;
INSERT INTO `origin_chapter2_choice` VALUES (1,'1-1','가까이 다가가서 차를 뒤져본다.',NULL),(2,'1-2','차에 뭐 중요한 게 있겠어? 다른 곳을 살펴보자.',NULL),(3,'2-1','이렇게 큰 카페면 쓸만한 게 많을 것 같은데? 들어가보자.',NULL),(4,'2-2','(전판례 할머니) 전판례 할머니께서 커피를 좋아하신다고 하던데.... ',NULL),(5,'2-3','너무 깜깜한데... 들어가서 아무것도 안 보일 것 같아.',NULL),(6,'3-1','(도독놈 아저씨) \"이런 허접한 자물쇠는 눈 감고도 풀 수 있지!\"',NULL),(7,'3-1-1','이런 라커엔 항상 중요한 게 있던데. 여기도 그렇지 않을까?',NULL),(8,'3-1-2','비도 오고 너무 추운데 오늘은 거처에 있는게 어떨까?',NULL),(9,'4-1','저 군인이 어디에 물린것인지 알 수 없다. 그냥 지나치자.',NULL),(10,'4-2','이런 곳에서 사람을 만나긴 힘든데. 가서 살펴보자.',NULL),(11,'4-2-1',' (의약품 -1) 상처를 지혈해준다.',NULL),(12,'4-2-2','근처에 안전해 보이는 곳으로 이동시켜준다.',NULL),(13,'4-2-2-1','총만 있다면 우리도...! 그가 가진 총을 뺐는다.',NULL),(14,'4-2-2-2','옆에 식량을 조금 두고 간다.',NULL),(15,'5-1','(삽) 여길 파보자! 좋은 게 나올지도 몰라!',NULL),(16,'5-2','손으로 파보자! 종은 게 나올지도 몰라!',NULL),(17,'5-3','안에 뭐가 있을 지 확실하지 않은데 파보는건...',NULL),(18,'5-4','(강아지 쿠키) 쿠키야! 잘 파줄 수 있지?',NULL),(19,'6-1','(도독놈 아저씨) 최대한 많은 집을 둘러본다.',NULL),(20,'6-2','어쩔수 없네... 할 수 있는 만큼만 돌아보자.',NULL),(21,'9-1','(총) 총을 겨누고 소리가 난 쪽으로 간다.',''),(22,'9-2','조심스럽게 소리가 나는 쪽으로 가서 우선 살펴본다.',NULL),(23,'12-1-1','(강아지 쿠키) 쿠키야 짖으면 안돼. 쿠키를 잡는다. ',NULL),(24,'12-1-2','(한은둔 할아버지) 숨바꼭질 스킬 발동! 그림자 덮기!',NULL),(25,'12-1-3','조용히, 숨을 참자. 들키면 안돼!',NULL),(27,'8-1','덫을 그대로 놔둔다.',NULL),(28,'8-2','덫의 자리를 옮긴다.',NULL),(29,'9-3','(장주먹 할아버지) 장주먹 할아버지를 앞세워서 들어가보자!',NULL),(30,'9-4','(고모리) 고모리를 앞세워서 들어가보자!',NULL),(31,'13-1','좀비 개는 위험한데... 우리도 조심하자...',NULL),(32,'13-2','\"야! 이리와!\" 큰 소리로 나한테 유인한다.',NULL),(33,'13-3','\"저리가!\" 위협해서 좀비 개를 쫓아낸다.',NULL),(34,'15-1','용기를 내서 질문을 해보자!',NULL),(35,'15-2','서로 다른 무리의 군인들이 왜 같은 곳에 있을까?',NULL),(36,'15-3','강가에만 오면 군인들이 있네?',NULL),(37,'14-1',' 할머니를 안아드리자.',NULL),(38,'14-2','(침낭) 이럴때 쓰려고 사뒀지!',NULL),(39,'10-1','손을 들고 항복하고, 문을 열어준다.',NULL),(40,'10-2','(권총) 나도 총구를 같이 들이민다.',NULL),(41,'10-3','(권총) 정당방위다. 내가 먼저 군인을 쏜다!','칭호 살인자');
/*!40000 ALTER TABLE `origin_chapter2_choice` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-31 14:08:03
