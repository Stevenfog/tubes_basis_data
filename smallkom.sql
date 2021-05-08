-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 08 Bulan Mei 2021 pada 11.48
-- Versi server: 10.4.13-MariaDB
-- Versi PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smallkom`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `alat`
--

CREATE TABLE `alat` (
  `id_alat` char(4) NOT NULL,
  `id_ruangan` char(8) NOT NULL,
  `id_spesifikasi` char(8) NOT NULL,
  `kondisi` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `alat`
--

INSERT INTO `alat` (`id_alat`, `id_ruangan`, `id_spesifikasi`, `kondisi`) VALUES
('C101', 'labgdc_1', 'proinfo1', 'baik'),
('C102', 'labgdc_1', 'komacer1', 'baik'),
('C103', 'labgdc_1', 'komacer1', 'baik'),
('C104', 'labgdc_1', 'komasus1', 'baik'),
('C105', 'labgdc_1', 'komasus1', 'baik'),
('C106', 'labgdc_1', 'komhepa1', 'baik'),
('C107', 'labgdc_1', 'komhepa1', 'baik'),
('C108', 'labgdc_1', 'komleno1', 'baik'),
('C109', 'labgdc_1', 'komleno1', 'baik'),
('C201', 'labgdc_2', 'proinfo1', 'baik'),
('C202', 'labgdc_2', 'komacer1', 'baik'),
('C203', 'labgdc_2', 'komacer1', 'baik'),
('C204', 'labgdc_2', 'komasus1', 'baik'),
('C205', 'labgdc_2', 'komasus1', 'baik'),
('C206', 'labgdc_2', 'komhepa1', 'baik'),
('C207', 'labgdc_2', 'komhepa1', 'baik'),
('C208', 'labgdc_2', 'komleno1', 'baik'),
('C209', 'labgdc_2', 'komleno1', 'baik'),
('L301', 'labtek_1', 'prosony1', 'baik'),
('L302', 'labtek_1', 'komacer1', 'baik'),
('L303', 'labtek_1', 'komacer1', 'baik'),
('L304', 'labtek_1', 'komasus1', 'baik'),
('L305', 'labtek_1', 'komasus1', 'baik'),
('L306', 'labtek_1', 'komhepa1', 'baik'),
('L307', 'labtek_1', 'komhepa1', 'baik'),
('L308', 'labtek_1', 'komleno1', 'baik'),
('L309', 'labtek_1', 'komleno1', 'baik'),
('L401', 'labtek_2', 'prosony1', 'baik'),
('L402', 'labtek_2', 'komacer1', 'baik'),
('L403', 'labtek_2', 'komacer1', 'baik'),
('L404', 'labtek_2', 'komasus1', 'baik'),
('L405', 'labtek_2', 'komasus1', 'baik'),
('L406', 'labtek_2', 'komhepa1', 'baik'),
('L407', 'labtek_2', 'komhepa1', 'baik'),
('L408', 'labtek_2', 'komleno1', 'baik'),
('L409', 'labtek_2', 'komleno1', 'baik');

-- --------------------------------------------------------

--
-- Struktur dari tabel `laboran`
--

CREATE TABLE `laboran` (
  `id_laboran` char(8) NOT NULL,
  `password` varchar(25) DEFAULT NULL,
  `id_ruangan` char(8) NOT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `kontak` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `laboran`
--

INSERT INTO `laboran` (`id_laboran`, `password`, `id_ruangan`, `nama`, `kontak`) VALUES
('11814014', 'elkan', 'labgdc_1', 'Steven Elkan Hutauruk', '0818140149'),
('11914006', 'putri', 'labtek_2', 'Putri Dwisastika Lumbantoruan', '0819140068'),
('11914019', 'figo', 'labgdc_2', 'Orville Figo El Islami ', '0819140194'),
('14117109', 'steven', 'labtek_1', 'Steven Hermadoni', '0814117109');

-- --------------------------------------------------------

--
-- Struktur dari tabel `lapor`
--

CREATE TABLE `lapor` (
  `no_laporan` int(11) NOT NULL,
  `id_alat` char(8) DEFAULT NULL,
  `id_ruangan` char(8) DEFAULT NULL,
  `jenis_kerusakan` varchar(50) DEFAULT NULL,
  `deskripsi` varchar(255) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `ruangan`
--

CREATE TABLE `ruangan` (
  `id_ruangan` char(8) NOT NULL,
  `id_laboran` char(8) DEFAULT NULL,
  `nama_ruangan` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `ruangan`
--

INSERT INTO `ruangan` (`id_ruangan`, `id_laboran`, `nama_ruangan`) VALUES
('labgdc_1', '11814014', 'Lab TPB Gedung C'),
('labgdc_2', '11914019', 'Lab Prodi Gedung C'),
('labtek_1', '14117109', 'Lab TPB LABTEK'),
('labtek_2', '11914006', 'Lab Prodi LABTEK');

-- --------------------------------------------------------

--
-- Struktur dari tabel `spesifikasi`
--

CREATE TABLE `spesifikasi` (
  `id_spesifikasi` char(8) NOT NULL,
  `jenis` varchar(25) DEFAULT NULL,
  `merek` varchar(25) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `spesifikasi`
--

INSERT INTO `spesifikasi` (`id_spesifikasi`, `jenis`, `merek`, `harga`) VALUES
('komacer1', 'komputer', 'Acer', 7500000),
('komasus1', 'komputer', 'Asus', 7000000),
('komhepa1', 'komputer', 'Hewlett Packard', 8000000),
('komleno1', 'komputer', 'Lenovo', 7000000),
('proinfo1', 'proyektor', 'Infocus', 5000000),
('prosony1', 'proyektor', 'Sony', 5500000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `alat`
--
ALTER TABLE `alat`
  ADD PRIMARY KEY (`id_alat`),
  ADD KEY `id_ruangan` (`id_ruangan`),
  ADD KEY `id_spesifikasi` (`id_spesifikasi`);

--
-- Indeks untuk tabel `laboran`
--
ALTER TABLE `laboran`
  ADD PRIMARY KEY (`id_laboran`),
  ADD KEY `id_ruangan` (`id_ruangan`);

--
-- Indeks untuk tabel `lapor`
--
ALTER TABLE `lapor`
  ADD PRIMARY KEY (`no_laporan`),
  ADD KEY `id_alat` (`id_alat`),
  ADD KEY `id_ruangan` (`id_ruangan`);

--
-- Indeks untuk tabel `ruangan`
--
ALTER TABLE `ruangan`
  ADD PRIMARY KEY (`id_ruangan`),
  ADD KEY `id_laboran` (`id_laboran`);

--
-- Indeks untuk tabel `spesifikasi`
--
ALTER TABLE `spesifikasi`
  ADD PRIMARY KEY (`id_spesifikasi`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `alat`
--
ALTER TABLE `alat`
  ADD CONSTRAINT `alat_ibfk_1` FOREIGN KEY (`id_spesifikasi`) REFERENCES `spesifikasi` (`id_spesifikasi`),
  ADD CONSTRAINT `alat_ibfk_2` FOREIGN KEY (`id_ruangan`) REFERENCES `ruangan` (`id_ruangan`);

--
-- Ketidakleluasaan untuk tabel `laboran`
--
ALTER TABLE `laboran`
  ADD CONSTRAINT `laboran_ibfk_1` FOREIGN KEY (`id_ruangan`) REFERENCES `ruangan` (`id_ruangan`);

--
-- Ketidakleluasaan untuk tabel `lapor`
--
ALTER TABLE `lapor`
  ADD CONSTRAINT `lapor_ibfk_1` FOREIGN KEY (`id_ruangan`) REFERENCES `ruangan` (`id_ruangan`),
  ADD CONSTRAINT `lapor_ibfk_2` FOREIGN KEY (`id_alat`) REFERENCES `alat` (`id_alat`);

--
-- Ketidakleluasaan untuk tabel `ruangan`
--
ALTER TABLE `ruangan`
  ADD CONSTRAINT `ruangan_ibfk_1` FOREIGN KEY (`id_laboran`) REFERENCES `laboran` (`id_laboran`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
