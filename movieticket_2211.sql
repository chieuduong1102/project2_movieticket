-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.13-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for movieticket
DROP DATABASE IF EXISTS `movieticket`;
CREATE DATABASE IF NOT EXISTS `movieticket` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `movieticket`;

-- Dumping structure for table movieticket.admin
DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `adminid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table movieticket.admin: ~0 rows (approximately)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`adminid`, `username`, `password`) VALUES
	(1, 'admin1', '123123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- Dumping structure for table movieticket.category
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `categoryid` int(11) NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(255) NOT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table movieticket.category: ~11 rows (approximately)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`categoryid`, `categoryname`) VALUES
	(1, 'Học đường'),
	(2, 'Kinh dị'),
	(3, 'Hành động'),
	(4, 'Tình cảm'),
	(5, 'Phiêu lưu'),
	(6, 'Lãng mạn'),
	(7, 'Hài hước'),
	(8, 'Khoa học'),
	(26, 'Phim Ma'),
	(28, 'Viễn Tưởng'),
	(29, 'Hoạt hình');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Dumping structure for table movieticket.countticket
DROP TABLE IF EXISTS `countticket`;
CREATE TABLE IF NOT EXISTS `countticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table movieticket.countticket: ~1 rows (approximately)
/*!40000 ALTER TABLE `countticket` DISABLE KEYS */;
INSERT INTO `countticket` (`id`, `count`) VALUES
	(1, 0);
/*!40000 ALTER TABLE `countticket` ENABLE KEYS */;

-- Dumping structure for table movieticket.movie
DROP TABLE IF EXISTS `movie`;
CREATE TABLE IF NOT EXISTS `movie` (
  `movieid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `director` varchar(50) NOT NULL,
  `nation` varchar(50) NOT NULL,
  `year` varchar(50) NOT NULL DEFAULT '',
  `views` int(11) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `cover` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`movieid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table movieticket.movie: ~12 rows (approximately)
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` (`movieid`, `title`, `director`, `nation`, `year`, `views`, `status`, `cover`) VALUES
	(6, 'Mắt Biếc', 'Victo Vu', 'Viet Nam', '2020', 1990, 'Đang chiếu', 'DreamyEyes.jpg'),
	(7, 'Ròm', 'Tran Thanh Huy', 'Viet Nam', '2020', 1523, 'Đang chiếu', 'Rom.jpg'),
	(8, 'End Game', 'Anthony Russo Joe Russo', 'Mỹ', '2019', 1890, 'Đang chiếu', 'EndGame.jpg'),
	(9, 'Cua Lại Vợ Bầu', 'Nhat Trung', 'Viet Nam', '2019', 1670, 'Đã ngừng chiếu', 'WinMyBabyBack.jpg'),
	(14, 'Sài Gòn Trong Cơn Mưa', 'Le Minh Hoang', 'Viet Nam', '2020', 0, 'Sắp chiếu', 'SaiGontrongconmua.jpg'),
	(18, 'DORAEMON', 'Kazukai Imai', 'Nhật Bản', '2020', 0, 'Sắp chiếu', 'doraemon.jpg'),
	(19, 'Hai Phượng', 'Lê Văn Kiệt', 'Việt Nam', '2019', 1200, 'Đã ngừng chiếu', 'haiphuong.jpg'),
	(20, 'Đại Dịch Xác Sống', 'Johnny Martin', 'USA', '2020', 907, 'Đang chiếu', 'daidichxacsong.jpg'),
	(21, 'Tiệc Trang Máu', 'Nguyễn Quang Dũng', 'Việt Nam', '2020', 990, 'Đang chiếu', 'tiectrangmau.jpg'),
	(23, 'Tí Hon Hậu Đậu', 'Munchow Pohl', 'Australia', '2020', 689, 'Đang chiếu', 'tihonhaudau.jpg'),
	(24, 'Quái Vật Săn Đêm', 'Egor Abramenko', 'Nga', '2020', 572, 'Đang chiếu', 'quaivatsandem.jpg'),
	(25, 'Cục Nợ Hóa Cục Cưng', 'Dae Gyu Kang', 'Hàn Quốc', '2020', 762, 'Đang chiếu', '10597_103_100003.jpg'),
	(26, 'Đừng Gọi Anh Là Bố', 'Mai Pawat', 'Viet Nam', '2020', 0, 'Sắp chiếu', 'dungoianhlabo.jpg');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;

-- Dumping structure for table movieticket.moviecategory
DROP TABLE IF EXISTS `moviecategory`;
CREATE TABLE IF NOT EXISTS `moviecategory` (
  `mcid` int(11) NOT NULL AUTO_INCREMENT,
  `movieid` int(11) NOT NULL,
  `categoryid` int(11) NOT NULL,
  PRIMARY KEY (`mcid`),
  KEY `movieid` (`movieid`),
  KEY `categoryid` (`categoryid`),
  CONSTRAINT `moviecategory_ibfk_1` FOREIGN KEY (`movieid`) REFERENCES `movie` (`movieid`),
  CONSTRAINT `moviecategory_ibfk_2` FOREIGN KEY (`categoryid`) REFERENCES `category` (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table movieticket.moviecategory: ~21 rows (approximately)
/*!40000 ALTER TABLE `moviecategory` DISABLE KEYS */;
INSERT INTO `moviecategory` (`mcid`, `movieid`, `categoryid`) VALUES
	(6, 6, 4),
	(7, 6, 6),
	(8, 9, 4),
	(9, 9, 6),
	(10, 8, 28),
	(11, 8, 3),
	(12, 14, 4),
	(13, 18, 29),
	(14, 19, 3),
	(15, 20, 2),
	(16, 20, 3),
	(17, 21, 2),
	(18, 21, 7),
	(19, 23, 29),
	(20, 23, 7),
	(21, 24, 3),
	(22, 24, 2),
	(23, 25, 4),
	(24, 25, 6),
	(25, 26, 7),
	(26, 26, 4);
/*!40000 ALTER TABLE `moviecategory` ENABLE KEYS */;

-- Dumping structure for table movieticket.room
DROP TABLE IF EXISTS `room`;
CREATE TABLE IF NOT EXISTS `room` (
  `roomid` int(11) NOT NULL AUTO_INCREMENT,
  `roomname` varchar(255) NOT NULL,
  PRIMARY KEY (`roomid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table movieticket.room: ~6 rows (approximately)
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` (`roomid`, `roomname`) VALUES
	(1, 'Room 1'),
	(2, 'Room 2'),
	(3, 'Room 3'),
	(4, 'Room 4'),
	(5, 'Room 5'),
	(6, 'Room 6');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;

-- Dumping structure for table movieticket.seat
DROP TABLE IF EXISTS `seat`;
CREATE TABLE IF NOT EXISTS `seat` (
  `seatid` int(11) NOT NULL AUTO_INCREMENT,
  `seatcode` varchar(10) NOT NULL,
  PRIMARY KEY (`seatid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table movieticket.seat: ~20 rows (approximately)
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` (`seatid`, `seatcode`) VALUES
	(1, 'A1'),
	(2, 'A2'),
	(4, 'A3'),
	(5, 'A4'),
	(6, 'A5'),
	(7, 'B1'),
	(8, 'B2'),
	(9, 'B3'),
	(10, 'B4'),
	(11, 'B5'),
	(12, 'C1'),
	(13, 'C2'),
	(14, 'C3'),
	(15, 'C4'),
	(16, 'C5'),
	(17, 'D1'),
	(18, 'D2'),
	(19, 'D3'),
	(20, 'D4'),
	(21, 'D5');
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;

-- Dumping structure for table movieticket.showtime
DROP TABLE IF EXISTS `showtime`;
CREATE TABLE IF NOT EXISTS `showtime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movieid` int(11) NOT NULL,
  `roomid` int(11) NOT NULL,
  `timeid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `movieid` (`movieid`),
  KEY `roomid` (`roomid`),
  KEY `timeid` (`timeid`),
  CONSTRAINT `showtime_ibfk_1` FOREIGN KEY (`movieid`) REFERENCES `movie` (`movieid`),
  CONSTRAINT `showtime_ibfk_2` FOREIGN KEY (`roomid`) REFERENCES `room` (`roomid`),
  CONSTRAINT `showtime_ibfk_3` FOREIGN KEY (`timeid`) REFERENCES `timeslot` (`timeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table movieticket.showtime: ~0 rows (approximately)
/*!40000 ALTER TABLE `showtime` DISABLE KEYS */;
/*!40000 ALTER TABLE `showtime` ENABLE KEYS */;

-- Dumping structure for table movieticket.staff
DROP TABLE IF EXISTS `staff`;
CREATE TABLE IF NOT EXISTS `staff` (
  `staffid` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) NOT NULL,
  `dob` datetime NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(16) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phonenumber` int(10) NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`staffid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table movieticket.staff: ~0 rows (approximately)
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` (`staffid`, `fullname`, `dob`, `username`, `password`, `email`, `phonenumber`, `address`) VALUES
	(1, 'Pham Huu Duong', '1996-10-26 00:00:00', 'duongchieu', '123123', 'chieuduong1102@gmail.com', 867672610, 'Ha Noi');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;

-- Dumping structure for table movieticket.ticketdetail
DROP TABLE IF EXISTS `ticketdetail`;
CREATE TABLE IF NOT EXISTS `ticketdetail` (
  `ticketid` int(11) NOT NULL AUTO_INCREMENT,
  `customer` varchar(255) NOT NULL,
  `phonenumber` varchar(13) NOT NULL,
  `moviename` varchar(255) NOT NULL,
  `room` varchar(50) NOT NULL,
  `timeslot` varchar(50) NOT NULL,
  `seat` varchar(50) NOT NULL,
  `price` int(11) DEFAULT 75000,
  `numberticket` int(11) DEFAULT NULL,
  `totalprice` int(11) DEFAULT NULL,
  PRIMARY KEY (`ticketid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table movieticket.ticketdetail: ~1 rows (approximately)
/*!40000 ALTER TABLE `ticketdetail` DISABLE KEYS */;
INSERT INTO `ticketdetail` (`ticketid`, `customer`, `phonenumber`, `moviename`, `room`, `timeslot`, `seat`, `price`, `numberticket`, `totalprice`) VALUES
	(1, 'Duong', '0867672610', 'Mắt Biếc', 'Room 1', '02:00PM - 04:00PM', 'B1, B2, B3', 75000, 3, 225000),
	(24, 'Nguyen Huy Hao', '0865765102', 'Mắt Biếc', 'Room 2', '04:00PM - 06:00PM', 'A3, A4, ', 75000, 2, 150000),
	(25, 'Nguyen Huy Hao', '0865765102', 'Ròm', 'Room 2', '04:00PM - 06:00PM', 'A3, ', 75000, 1, 75000),
	(26, 'Nguyen Huy Hao', '0865765102', 'Ròm', 'Room 2', '04:00PM - 06:00PM', 'A3, A4, ', 75000, 2, 150000),
	(27, 'Nguyen Huy Hao', '0865765102', 'End Game', 'Room 2', '06:00PM - 08:00PM', 'A2, A3, A4, ', 75000, 3, 225000);
/*!40000 ALTER TABLE `ticketdetail` ENABLE KEYS */;

-- Dumping structure for table movieticket.timeslot
DROP TABLE IF EXISTS `timeslot`;
CREATE TABLE IF NOT EXISTS `timeslot` (
  `timeid` int(11) NOT NULL AUTO_INCREMENT,
  `time` varchar(50) NOT NULL,
  PRIMARY KEY (`timeid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table movieticket.timeslot: ~5 rows (approximately)
/*!40000 ALTER TABLE `timeslot` DISABLE KEYS */;
INSERT INTO `timeslot` (`timeid`, `time`) VALUES
	(1, '02:00PM - 04:00PM'),
	(2, '04:00PM - 06:00PM'),
	(3, '06:00PM - 08:00PM'),
	(4, '08:00PM - 10:00PM'),
	(5, '10:00PM - 00:00AM');
/*!40000 ALTER TABLE `timeslot` ENABLE KEYS */;

-- Dumping structure for table movieticket.viewer
DROP TABLE IF EXISTS `viewer`;
CREATE TABLE IF NOT EXISTS `viewer` (
  `viewerid` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) NOT NULL,
  `dob` varchar(50) NOT NULL DEFAULT '',
  `username` varchar(255) NOT NULL,
  `password` varchar(16) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phoneNumber` varchar(50) NOT NULL DEFAULT '',
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`viewerid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table movieticket.viewer: ~2 rows (approximately)
/*!40000 ALTER TABLE `viewer` DISABLE KEYS */;
INSERT INTO `viewer` (`viewerid`, `fullname`, `dob`, `username`, `password`, `email`, `phoneNumber`, `address`) VALUES
	(1, 'Mai Trong Dat', '18/10/2001', 'datmai', '123123', 'dat09@gmail.com', '0865765102', 'HN'),
	(2, 'Nguyen Huy Hao', '14/08/2000', 'huyhao', '123123', 'huyhao@gmail.com', '0865765102', 'Ha Noi');
/*!40000 ALTER TABLE `viewer` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
