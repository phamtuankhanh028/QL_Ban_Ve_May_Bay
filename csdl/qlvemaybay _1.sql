-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2021 at 01:20 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlvemaybay`
--

-- --------------------------------------------------------

--
-- Table structure for table `chuyen_bay`
--

CREATE TABLE `chuyen_bay` (
  `ma_chuyen_bay` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ngay_di` date NOT NULL,
  `ngay_den` date NOT NULL,
  `gio_di` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `gio_den` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `so_gio_bay` int(11) NOT NULL,
  `ma_tuyen_bay` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ma_mb` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `sgh1cl` int(11) NOT NULL,
  `sgh2cl` int(11) NOT NULL,
  `bay_tu` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `bay_den` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chuyen_bay`
--

INSERT INTO `chuyen_bay` (`ma_chuyen_bay`, `ngay_di`, `ngay_den`, `gio_di`, `gio_den`, `so_gio_bay`, `ma_tuyen_bay`, `ma_mb`, `sgh1cl`, `sgh2cl`, `bay_tu`, `bay_den`) VALUES
('CB013', '2021-05-15', '2021-05-22', '2:30am', '2:30am', 1, 'CM-CT', 'MB1', 1, 2, 'TP. Hồ Chí Minh', 'Cần Thơ'),
('CB014', '2021-05-15', '2021-05-22', '1:00am', '2:00am', 1, 'DB-TH', 'MB1', 1, 3, 'Cà Mau', 'Cần Thơ'),
('CB015', '2021-05-22', '2021-05-15', '2:00am', '3:00am', 3, 'CM-CT', 'MB1', 1, 2, 'TP. Hồ Chí Minh', 'LonDon'),
('CB017', '2021-05-15', '2021-05-22', '2:30am', '2:30am', 1, 'CM-CT', 'MB1', 1, 2, 'TP. Hồ Chí Minh', 'Cần Thơ'),
('QTCM-CT2', '2021-05-01', '2021-05-12', '1:00am', '2:00am', 2, 'CM-CT', 'MB5', 123, 58, 'Cà Mau', 'Cần Thơ'),
('QTHCM-LD', '2021-05-26', '2021-05-26', '1:00am', '19:pm', 19, 'QTHCM-LD', 'MB2', 100, 200, 'TP. Hồ Chí Minh', 'LonDon'),
('QTHCM-LD1', '1970-01-01', '1970-01-01', '1:00am', '2:00am', 19, 'CM-CT', 'MB1', 1, 1, 'TP. Hồ Chí Minh', 'LonDon');

-- --------------------------------------------------------

--
-- Table structure for table `ct_hoa_don`
--

CREATE TABLE `ct_hoa_don` (
  `ma_hoa_don` int(11) NOT NULL,
  `ma_ve` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `don_gia` int(10) NOT NULL,
  `sl` int(10) NOT NULL,
  `thanh_tien` int(10) NOT NULL,
  `macthd` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ct_hoa_don`
--

INSERT INTO `ct_hoa_don` (`ma_hoa_don`, `ma_ve`, `don_gia`, `sl`, `thanh_tien`, `macthd`) VALUES
(1, '1', 100000, 10000, 100000000, 1),
(2, '1', 5000, 9, 45000, 6),
(2, '1', 5000, 9, 45000, 7),
(2, '1', 5000, 9, 45000, 8);

-- --------------------------------------------------------

--
-- Table structure for table `don_gia`
--

CREATE TABLE `don_gia` (
  `ma_don_gia` int(11) NOT NULL,
  `ma_hang_ve` int(11) NOT NULL,
  `dg_usd` int(10) DEFAULT NULL,
  `dg_vnd` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `don_gia`
--

INSERT INTO `don_gia` (`ma_don_gia`, `ma_hang_ve`, `dg_usd`, `dg_vnd`) VALUES
(1, 1, 10000, 10001);

-- --------------------------------------------------------

--
-- Table structure for table `hang_ve`
--

CREATE TABLE `hang_ve` (
  `ma_hang_ve` int(11) NOT NULL,
  `ten_hang_ve` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hang_ve`
--

INSERT INTO `hang_ve` (`ma_hang_ve`, `ten_hang_ve`) VALUES
(1, 'Hạng vé 1');

-- --------------------------------------------------------

--
-- Table structure for table `hoa_don`
--

CREATE TABLE `hoa_don` (
  `ma_hoa_don` int(11) NOT NULL,
  `ma_kh` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ma_nv` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `tong_tien` int(11) NOT NULL,
  `ngay_lap` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hoa_don`
--

INSERT INTO `hoa_don` (`ma_hoa_don`, `ma_kh`, `ma_nv`, `tong_tien`, `ngay_lap`) VALUES
(1, '2', 'nv01', 100000, '2021-05-16'),
(2, '2', 'nv01', 1000, '2021-05-16'),
(3, '2', 'nv01', 1001, '2021-05-16');

-- --------------------------------------------------------

--
-- Table structure for table `khach_hang`
--

CREATE TABLE `khach_hang` (
  `ma_kh` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ho_kh` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ten_kh` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `gioi_tinh` tinyint(1) NOT NULL,
  `cmnd` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `ngay_sinh` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khach_hang`
--

INSERT INTO `khach_hang` (`ma_kh`, `ho_kh`, `ten_kh`, `sdt`, `gioi_tinh`, `cmnd`, `ngay_sinh`) VALUES
('1', 'Võ ', 'Hoàng Kiệt', '0218392183', 1, '123671236', '2021-05-16'),
('2', 'Võ', 'Hoàng Kiệt', '12345678', 1, '1223344', '2021-05-16');

-- --------------------------------------------------------

--
-- Table structure for table `may_bay`
--

CREATE TABLE `may_bay` (
  `ma_mb` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `loai_mb` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ten_mb` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `so_ghe_1` int(6) NOT NULL,
  `so_ghe_2` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `may_bay`
--

INSERT INTO `may_bay` (`ma_mb`, `loai_mb`, `ten_mb`, `so_ghe_1`, `so_ghe_2`) VALUES
('MB1', 'Boeing', 'Boeing 787', 100, 550),
('MB2', 'Airbus', 'Airbus A350', 150, 200),
('MB3', 'Airbus', 'Airbus A330', 100, 169),
('MB4', 'Airbus', 'Airbus A321', 86, 100),
('MB5', 'ATR', 'ATR 72-500', 15, 50);

-- --------------------------------------------------------

--
-- Table structure for table `nhan_vien`
--

CREATE TABLE `nhan_vien` (
  `ma_nv` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ho_nv` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ten_nv` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ngay_sinh` date NOT NULL,
  `gioi_tinh` tinyint(1) NOT NULL,
  `que_quan` text COLLATE utf8_unicode_ci NOT NULL,
  `hinh` varchar(25) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhan_vien`
--

INSERT INTO `nhan_vien` (`ma_nv`, `email`, `password`, `ho_nv`, `ten_nv`, `ngay_sinh`, `gioi_tinh`, `que_quan`, `hinh`) VALUES
('nv01', 'phamtuankhanh@gmail.com', 'khanhdct1195', 'Phạm', 'Tuấn Khanh', '2001-08-02', 1, '164/NT, Mỹ Nhơn, Ba Tri, Bến Tre', 'nobita.jpg'),
('NV2', 'nguyendinhtri@gmail.com', 'tri', 'Nguyễn Đình', 'Trí', '2001-01-01', 1, 'Đồng Nai', 'xuka.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `san_bay`
--

CREATE TABLE `san_bay` (
  `ma_sb` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ten_sb` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `san_bay`
--

INSERT INTO `san_bay` (`ma_sb`, `ten_sb`) VALUES
('CB', 'Sân bay Cát Bi-HP'),
('CM', 'Sân bay Cà Mau'),
('CT', 'Sân bay quốc tế Cần Thơ'),
('DB', 'Sân bay Điện Biên Phủ-ĐB'),
('DH', 'Sân bay Đồng Hới-QB'),
('DN', 'Sân bay quốc tế Đà Nẵng'),
('NB', 'Sân bay Nội Bài'),
('PK', 'Sân bay Pleiku-GL'),
('QTCLB', 'Sân bay Colombo'),
('QTDB', 'Sân bay Dubai'),
('QTDH', 'Sân bay DoHa'),
('QTLD', 'Sân bay LonDon'),
('QTMB', 'Sân bay MumBai'),
('QTNY', 'Sân bay New York'),
('QTSGP', 'Sân bay Singapore'),
('QTTKO', 'Sân bay ToKyo'),
('QTWST', 'Sân bay Washington'),
('TH', 'Sân bay Tuy Hòa-PY'),
('TN', 'Sân bay Thống Nhất'),
('TX', 'Sân bay Thọ Xuân-TH'),
('V', 'Sân bay quốc tế Vinh');

-- --------------------------------------------------------

--
-- Table structure for table `tuyen_bay`
--

CREATE TABLE `tuyen_bay` (
  `ma_tuyen_bay` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ma_san_di` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ma_san_den` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `san_bay_tg1` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `san_bay_tg2` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `thoi_gian_dung` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tuyen_bay`
--

INSERT INTO `tuyen_bay` (`ma_tuyen_bay`, `ma_san_di`, `ma_san_den`, `san_bay_tg1`, `san_bay_tg2`, `thoi_gian_dung`) VALUES
('CM-CT', 'CM', 'CT', NULL, NULL, NULL),
('DB-TH', 'DB', 'TH', NULL, NULL, 1),
('HCM-HN', 'TN', 'NB', NULL, NULL, 1),
('HN-HCM', 'NB', 'TN', NULL, NULL, 1),
('QTHCM-LD', 'TN', 'QTLD', 'Sân bay DoHa', 'Sân bay Frankfurt', 3),
('QTHN-WST', 'NB', 'QTWST', 'Sân bay Tokyo', 'Sân bay Dallas', 4);

-- --------------------------------------------------------

--
-- Table structure for table `ve_bay`
--

CREATE TABLE `ve_bay` (
  `ma_ve` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ma_chuyen_bay` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ma_kh` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ma_hang_ve` int(11) NOT NULL,
  `ma_don_gia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ve_bay`
--

INSERT INTO `ve_bay` (`ma_ve`, `ma_chuyen_bay`, `ma_kh`, `ma_hang_ve`, `ma_don_gia`) VALUES
('1', 'CB013', '1', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chuyen_bay`
--
ALTER TABLE `chuyen_bay`
  ADD PRIMARY KEY (`ma_chuyen_bay`),
  ADD KEY `ma_tuyen_bay` (`ma_tuyen_bay`),
  ADD KEY `ma_may_bay` (`ma_mb`);

--
-- Indexes for table `ct_hoa_don`
--
ALTER TABLE `ct_hoa_don`
  ADD PRIMARY KEY (`macthd`),
  ADD KEY `ma_ve` (`ma_ve`),
  ADD KEY `ma_hoa_don` (`ma_hoa_don`);

--
-- Indexes for table `don_gia`
--
ALTER TABLE `don_gia`
  ADD PRIMARY KEY (`ma_don_gia`),
  ADD KEY `ma_hang_ve` (`ma_hang_ve`);

--
-- Indexes for table `hang_ve`
--
ALTER TABLE `hang_ve`
  ADD PRIMARY KEY (`ma_hang_ve`);

--
-- Indexes for table `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD PRIMARY KEY (`ma_hoa_don`),
  ADD KEY `ma_kh` (`ma_kh`),
  ADD KEY `ma_nv` (`ma_nv`);

--
-- Indexes for table `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`ma_kh`);

--
-- Indexes for table `may_bay`
--
ALTER TABLE `may_bay`
  ADD PRIMARY KEY (`ma_mb`);

--
-- Indexes for table `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD PRIMARY KEY (`ma_nv`);

--
-- Indexes for table `san_bay`
--
ALTER TABLE `san_bay`
  ADD PRIMARY KEY (`ma_sb`);

--
-- Indexes for table `tuyen_bay`
--
ALTER TABLE `tuyen_bay`
  ADD PRIMARY KEY (`ma_tuyen_bay`),
  ADD KEY `ma_san_di` (`ma_san_di`),
  ADD KEY `ma_san_den` (`ma_san_den`);

--
-- Indexes for table `ve_bay`
--
ALTER TABLE `ve_bay`
  ADD PRIMARY KEY (`ma_ve`),
  ADD KEY `ma_chuyen_bay` (`ma_chuyen_bay`),
  ADD KEY `ma_kh` (`ma_kh`),
  ADD KEY `ma_hang_ve` (`ma_hang_ve`),
  ADD KEY `ma_don_gia` (`ma_don_gia`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ct_hoa_don`
--
ALTER TABLE `ct_hoa_don`
  MODIFY `macthd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `don_gia`
--
ALTER TABLE `don_gia`
  MODIFY `ma_don_gia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `hang_ve`
--
ALTER TABLE `hang_ve`
  MODIFY `ma_hang_ve` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `hoa_don`
--
ALTER TABLE `hoa_don`
  MODIFY `ma_hoa_don` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chuyen_bay`
--
ALTER TABLE `chuyen_bay`
  ADD CONSTRAINT `chuyen_bay_ibfk_1` FOREIGN KEY (`ma_tuyen_bay`) REFERENCES `tuyen_bay` (`ma_tuyen_bay`),
  ADD CONSTRAINT `chuyen_bay_ibfk_2` FOREIGN KEY (`ma_mb`) REFERENCES `may_bay` (`ma_mb`);

--
-- Constraints for table `ct_hoa_don`
--
ALTER TABLE `ct_hoa_don`
  ADD CONSTRAINT `ct_hoa_don_ibfk_1` FOREIGN KEY (`ma_ve`) REFERENCES `ve_bay` (`ma_ve`),
  ADD CONSTRAINT `ct_hoa_don_ibfk_2` FOREIGN KEY (`ma_hoa_don`) REFERENCES `hoa_don` (`ma_hoa_don`);

--
-- Constraints for table `don_gia`
--
ALTER TABLE `don_gia`
  ADD CONSTRAINT `don_gia_ibfk_1` FOREIGN KEY (`ma_hang_ve`) REFERENCES `hang_ve` (`ma_hang_ve`);

--
-- Constraints for table `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD CONSTRAINT `hoa_don_ibfk_1` FOREIGN KEY (`ma_nv`) REFERENCES `nhan_vien` (`ma_nv`),
  ADD CONSTRAINT `hoa_don_ibfk_2` FOREIGN KEY (`ma_kh`) REFERENCES `khach_hang` (`ma_kh`);

--
-- Constraints for table `tuyen_bay`
--
ALTER TABLE `tuyen_bay`
  ADD CONSTRAINT `tuyen_bay_ibfk_1` FOREIGN KEY (`ma_san_di`) REFERENCES `san_bay` (`ma_sb`),
  ADD CONSTRAINT `tuyen_bay_ibfk_2` FOREIGN KEY (`ma_san_den`) REFERENCES `san_bay` (`ma_sb`);

--
-- Constraints for table `ve_bay`
--
ALTER TABLE `ve_bay`
  ADD CONSTRAINT `ve_bay_ibfk_1` FOREIGN KEY (`ma_kh`) REFERENCES `khach_hang` (`ma_kh`),
  ADD CONSTRAINT `ve_bay_ibfk_2` FOREIGN KEY (`ma_don_gia`) REFERENCES `don_gia` (`ma_don_gia`),
  ADD CONSTRAINT `ve_bay_ibfk_3` FOREIGN KEY (`ma_hang_ve`) REFERENCES `hang_ve` (`ma_hang_ve`),
  ADD CONSTRAINT `ve_bay_ibfk_4` FOREIGN KEY (`ma_chuyen_bay`) REFERENCES `chuyen_bay` (`ma_chuyen_bay`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
