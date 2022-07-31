-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
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
-- Table structure for table `chapter2_storyonly`
--

DROP TABLE IF EXISTS `chapter2_storyonly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chapter2_storyonly` (
  `StoryId` int NOT NULL,
  `StoryNum` varchar(30) NOT NULL,
  `StoryMain` varchar(1500) DEFAULT NULL,
  `StoryTime` varchar(10) DEFAULT NULL,
  `check` varchar(30) DEFAULT NULL,
  `check2` varchar(30) DEFAULT NULL,
  `check3` varchar(45) DEFAULT NULL,
  `check4` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`StoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chapter2_storyonly`
--

LOCK TABLES `chapter2_storyonly` WRITE;
/*!40000 ALTER TABLE `chapter2_storyonly` DISABLE KEYS */;
INSERT INTO `chapter2_storyonly` VALUES (1,'1','쓸만한 것이 없나 찾아보던 중,\n꽤 오래 방치된 것 같은 차를 발견했다.\n\n안에 쓸만한 것이 있을지도 모른다.\n한 번 만져볼까?','12','선택지, 확률, 스탯증감, 조건, 아이템증감','전투, (사람이름), (아이템이름),수치',NULL,NULL),(5,'2','방치된 커다란 폐건물을 발견했다.\n흉물스럽게 떨어진 커다란 간판을 보니\n예전에 카페를 하던 곳이었던 것 같다.\n\n찾아보면 쓸만한 게 많지 않을까?\n하지만 위험한 게 많을수도...\n내부는 깜깜해서 아무것도 보이지 않는다.','12','선택지',NULL,NULL,NULL),(11,'3','점점 가을로 접어들어가서 그런지\n날이 차고 쌀쌀하다.\n\n그 와중에 비가 내린다.\n\n비를 피할 곳을 찾다가 \n작은 폐건물을 하나 발견했다.\n급한대로 안에 들어간다.\n\n관리실이었던 듯 조작할 수 있는 기계가 있고,\n카메라와 연결된 많은 모니터 화면이 보인다.\n\n전기가 들어오지 않아\n전원을 켤 수 없다.\n\n그리고 굳게 잠긴 라커가 하나 있다.\n열어보면 쓸만한 게 있지 않을까?\n\n어떻게 하지?','12','선택지',NULL,NULL,NULL),(16,'4','\"살려줘! 사람 살려!\"\n\n좀비가 아닌 사람이 있다!\n군인이다.\n\n어디에 물린 것 같은 상처가 심하다.\n\n\"나, 나는, 좀비에게 물린 게 아니야!\n그냥 좀 도와줘!\"\n\n이 군인의 말을 믿을 수 있을까?','12','선택지',NULL,NULL,NULL),(24,'5','다른 곳과 달리\n땅이 눈에 띄게 불룩 솟아오른 곳이 있다.\n\n안에 뭐가있는걸까?\n한 번 파볼까?','12','선택지',NULL,NULL,NULL),(29,'6','이리저리 돌아다니다가\n주택 몇 채가 모여있는 곳을 발견했다.\n\n이 집들을 하나하나 살펴보면\n시간은 많이 걸리지만,\n생존에 필요한 물건들을 많이 모을 수 있을 것 같다.\n\n어떻게 할까?','12','선택지',NULL,NULL,NULL),(35,'9','빈 집이나 빈 건물을 뒤져보고 있는데,\n어디서 부스럭 거리는 소리가 들린다.\n좀비인가?','12','선택지',NULL,NULL,NULL),(59,'13','갈대가 우거진 곳에서\n작은 비명소리가 들린다.\n\n몸집이 작은 할머니  분이\n좀비 개에게 쫓기고 계신다.','12','선택지',NULL,NULL,NULL),(101,'GM','(GM스푸키)\n새출발을 시작하는 아침이다.\n을숙도 탈출하기\n오늘부터 1일차!\n\n씩씩하게 거처의 문을 열고 나섰다.\n갑자기 하늘에서 빛줄기가 내려온다.\n어라? 이거 있었던 일 같은데?\n\n\"안녕하세요~\nGM 스푸키에요!\n당신의 새출발을 응원해!\n\n아이템과 인벤토리 기능에\n공을 많이 들였으니까!\n자주 자주 이용해주세요!\n\n아 그리고, 상점 아저씨랑 꼭!\n잘 되시길 바랄게요!\n거긴 게임 속의 미니게임으로\n미연시를 만들어뒀다구!\"\n\n번쩍! 빛이 나타났다가 사라진다.\n으악 너무 눈부셔!\n\n... 방금 무슨 일이 있었지?\n이런 일이 자주 있는 것 같은\n그런 느낌적인 느낌이다.\n\n가방이 묵직해졌다!\n나는 당장 상점에 가고싶어졌다.\n\n// + 교환 아이템\n// + 손전등','낮','GM/손전등+ 아이템+',NULL,NULL,NULL),(102,'GM','(GM 숨탁)\n낮이지만 가을바람이 쌀쌀하다.\n불어오는 바람에 갈대 스치는 소리만 고요하다.\n\n\"여어-. 플레이어,\n게임은 어때?\n\n아아- 내 소개가 늦었군.\n나는 GM 「숨탁-」.\n눈을 마주치는 것 만으로도...\n숨이- 탁-, 멎어버린달까?\n\n그래서-, 랄까, 일부러\n모습을 드러내진 않았어.\n너를 \"죽이고 싶진\" 않으니까.\"\n\n그는 이상한 소리를 한다.\n아무래도 숨탁은 숨은 오타쿠의\n약자인 것 같다.\n\n\"아아-, 숨은 오타쿠-, 라-.\n야레야레-. 내 정체를 단번에 파악하다니...\n이건, 좀, 곤란하겠는데?\"\n\n내 마음은 어떻게 읽은거야!\nGM숨탁의 정신공격에\n항마력이 떨어진다.\n\n// 정신력 -2\n','낮','GM/정신력 -2',NULL,NULL,NULL),(103,'GM','(GM 모구)\n귀여운 검정 강아지 한 마리가\n나에게 무척 자연스럽게 말을 건다.\n... 강아지가 말을 한다고?\n\n\"저기... 혹시 게임 후기는 남겼어?\n게임 후기 게시판이 좀... 비어있는 것 같아서...\"\n\n강아지는 시무룩한 눈빛으로 귀엽게 날 바라본다.\n이러면! 내가 미안해지잖아!\n\n\"게임을 다 하고 엔딩을 보면...\n후기 꼭 남겨줘야해!\n별점도 만들어뒀단 말이야.\n난 너의 별점이 궁금해!\"\n\nGM 모구의 귀여움이 치명적이다!\n나는 당장 게임 후기를 적으러 가고싶어졌다!\n\n\"헤헤 고마워! 플레이어!\n네 덕분에 내가 힘... 자, 잠깐!\n지, 지금은 안돼!\"\n\n갑자기 귀여운 강아지가\n펑 소리를 내며\n그린컴퓨터아카데미의\n누군가로 변한다.\n\n\"하하...\n후기 기다릴게요!\"\n\n그는 머쓱하게 웃으며 후다닥 사라진다.\n아무래도 GM 모구는\n자기 강아지를 빌려 귀여운척을 하려다가\n실패한 것 같다.\n\n그래도 나는 후기를 남기고 싶다는\n의지로 충만해졌다!\n\n//체력 +1','낮','GM/체력 +1',NULL,NULL,NULL),(104,'GM','(GM 소짱)\n길을 걸어가는데,\n뜬금없이 부숴진 피규어 하나가\n발에 채인다.\n\n어! 나 이거 뭔지 알아!\n페이트에 토오사카 린!\n\n\"그게 뭔데 씹덕아.\"\n\n예?\n\n\"그게 뭐냐고 씹덕아.\"\n\n아... 그게......\n\nGM 소짱은 오덕 중에 오덕들만 모인\n팀에서 그뭔씹을 외치는 역할을\n담당했다고 한다.\n\n오덕 토크에 과몰입한 팀원들을\n다시 현실로 돌아오게 만드는데\n중요한 역할을 했다고...\n\n아니 내가 이걸 어떻게 알지 ?\n나는 뒤통수를 긁적였다.\n\n\"그래서 그게 뭔데 씹덕아.\n나같은 갓반인은 그게 뭔지 모른다고.\"\n\n아 아니... 그게...\n나는 황급히 그자리를 벗어났다.\n\n내 덕력을 들킨 것 같아\n조금 수치스러워졌다.\n\n// 정신력 -1','낮','GM/정신력 -1',NULL,NULL,NULL),(105,'GM','(GM 우파루파)\n끝도없이 비슷한 곳을 골라다니다 보니\n사색의 시간을 가지게 된다.\n\n우리... 이런 무기랑, 이런 스킬들로\n여기서 계속 살아남을 수 있을까?\n\n막막함이 몰려오는 그때,\n목소리가 들려온다.\n데자뷰!\n\n\"전투 시스템의 가호가 함께하기를!\n걱정 마세요!\n별 볼일 없는 아이템이지만!\n이세계에서는 용사들만 쓸 수 있는 템이라고!\"\n\n그건 그렇지.\n나는 고개를 끄덕였다.\n이제 어떤 전투가 와도\n이길 수 있을 것 같은 의지력이 생긴다!\n\n\"당신의 전투를 응원해!\n꼭 끝판왕도 만나길!\"\n\n끝판왕을 만나는건 좋은 일인지\n나쁜일인지 잘 모르겠다...\n불길한 기분이 드는 건 왜일까?\n\n목소리가 사라졌다.\n전투 의지가 충만해졌다!\n\n내 손에는 어느새\n그녀가 남기고 간 효자손이 들려있다.\n아니! 효자손을 왜 주는건데!\n\n아니 그리고 난 어떻게 그녀의 이름을 알지?\n고개를 갸웃거리게 된다.\n\n// 효자손 +1\n\n','낮','GM/효자손 +1',NULL,NULL,NULL),(106,'GM','(GM 킹박민) \n어디선가 아주 신성한 음악소리가 들려온다.\n경건해진다. 무릎을 꿇어야만 할 것 같다.\n\n\"나는... GM 킹박민...\n그린 컴퓨터 아카데미... 424호의 의지를 잇는 자...\"\n\n아니! 그런 엄청난 분께서 이런 누추한 곳에!\n\n\"GM 킹박민과 1조의 가호가 당신과 함께하길...\"\n\n그는 조용히 축복을 내려주고 사라진다.\n나, 취업 준비 할때, 그린 컴퓨터 다녔었지...\n그때가 그립다...\n\n당신은 훌륭한 개발자가 될 것 같은\n의지로 가득찼다!\n\n그러면서 게임을 하고싶다는 의지도\n충만해졌다!\n역시 GM 킹박민의 가호!\n\n// 체력 +1 정신력 +1','낮','GM/체력+1 정신력+1',NULL,NULL,NULL);
/*!40000 ALTER TABLE `chapter2_storyonly` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-31 13:34:52
