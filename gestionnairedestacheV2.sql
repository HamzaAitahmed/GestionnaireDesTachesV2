-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 21 fév. 2026 à 16:50
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE DATABASE IF NOT EXISTS gestionnairedestacheV2;
USE gestionnairedestacheV2;


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestionnairedestacheV2`
--

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE `equipe` (
  `id` int(11) NOT NULL,
  `date_de_creation` date DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `chef_equipe_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `team`
--

INSERT INTO `equipe` (`id`, `nom`, `chef_equipe_id`, `date_de_creation`) VALUES
(16, 'T1 Hamza', 16,null),
(17, 'T2 Hamza', 16,null),
(18, 'T1 Aitahmed', 17,null),
(19, 'T2 Aitahmed', 17,null),
(20, 'T1 ibtissam', 18,null),
(21, 'T2 ibtissam', 18,null),
(22, 'T1 Amina', 19,null),
(23, 'T1 Karim', 21,null),
(24, 'T2 Karim', 21,null),
(25, 'test team', 16,null);

-- --------------------------------------------------------

--
-- Structure de la table `equipe_les_membresdequipe`
--

CREATE TABLE `equipe_les_membresdequipe` (
  `membre_danslequipe_id` int(11) NOT NULL,
  `les_membresdequipe_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `team_members`
--

INSERT INTO `equipe_les_membresdequipe` (`membre_danslequipe_id`, `les_membresdequipe_id`) VALUES
(20, 16),
(20, 17),
(20, 19),
(20, 20),
(20, 21),
(20, 22),
(19, 16),
(19, 17),
(19, 18),
(19, 20),
(20, 21),
(19, 22),
(19, 23),
(22, 16),
(22, 17),
(22, 18),
(22, 21),
(22, 23),
(21, 16),
(21, 17),
(21, 18),
(21, 19),
(21, 20),
(21, 22),
(21, 23),
(17, 16),
(17, 18),
(17, 19),
(17, 20),
(17, 21),
(17, 22),
(17, 23),
(17, 17),
(17, 24),
(16, 18),
(16, 19),
(16, 20),
(16, 22),
(16, 21),
(16, 23),
(16, 16),
(16, 25),
(16, 27),
(16, 24),
(16, 26),
(16, 17),
(16, 29);


-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE `projet` (
  `id` int(11) NOT NULL,
  `budget` double NOT NULL,
  `client` varchar(255) DEFAULT NULL,
  `date_de_creation` date DEFAULT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `chef_projet_id` int(11) DEFAULT NULL,
  `equipe_du_projet_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `project`
--

INSERT INTO `projet` (`id`, `nom`, `chef_projet_id`, `equipe_du_projet_id`, `description`,`budget`, `client`, `date_de_creation`, `date_debut`, `date_fin`) VALUES
(67, 'P1 Hamza', 16, 20, 'P1Description',null,null,null,null,null),
(68, 'P2 Hamza', 16, 19, 'P2 Description',null,null,null,null,null),
(69, 'P1 Aitahmed', 17, 22, 'P1 Description',null,null,null,null,null),
(70, 'P1 Amina', 19, 16, 'P1 Description',null,null,null,null,null),
(71, 'P1 ibtissam', 18, 19, 'P1 Description',null,null,null,null,null),
(72, 'P1 Said', 20, 21, 'P1 Description',null,null,null,null,null),
(73, 'P2 Said', 20, 16, 'P2 Description',null,null,null,null,null),
(74, 'P1 Karim', 21, 16, 'P1 Description',null,null,null,null,null),
(75, 'P2 Karim', 21, NULL, 'P2 Description',null,null,null,null,null),
(78, 'P3 Hamza', 16, NULL, 'P3 No Description No Need  Team',null,null,null,null,null);

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

CREATE TABLE `tache` (
  `id` int(11) NOT NULL,
  `date_de_creation` date DEFAULT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `assigneur_de_tache_id` int(11) DEFAULT NULL,
  `projet_de_tache_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
--
-- Déchargement des données de la table `task`
--

INSERT INTO `tache` (`id`, `description`, `nom`, `projet_de_tache_id`, `assigneur_de_tache_id`, `date_de_creation`,`date_debut`,`date_fin`) VALUES
(53, 'T1 Description', 'T1 P1', 67, 17, Null, Null, Null),
(54, 'T2 Description', 'T2 P1', 67, 19, Null, Null, Null),
(55, 'T3 Description', 'T3 P3', 67, 22, Null, Null, Null),
(56, 'T4 Description', 'T4 P4', 67, 21, Null, Null, Null),
(57, 'T1 Descrition', 'T1 P2', 68, 16, Null, Null, Null),
(59, 'T2 Descrition', 'T2 P2', 68, 18, Null, Null, Null),
(60, 'T3 Descrition', 'T3 P2', 68, 17, Null, Null, Null),
(61, 'T4 Descrition', 'T4 P2', 68, 22, Null, Null, Null),
(66, 'T1 Description', 'T 1 P1', 69, NULL, Null, Null, Null),
(67, 'T2 Description', 'T 2 P1', 69, NULL, Null, Null, Null),
(68, 'T3 Description', 'T 3 P1', 69, NULL, Null, Null, Null),
(69, 'T4 Description', 'T 4 P1', 69, NULL, Null, Null, Null),
(70, 'T1 Description', 'T1  P1', 71, NULL, Null, Null, Null),
(71, 'T2 Description', 'T2  P1', 71, NULL, Null, Null, Null),
(72, 'T3 Description', 'T3  P1', 71, NULL, Null, Null, Null),
(73, 'T4 Description', 'T4  P1', 71, NULL, Null, Null, Null),
(74, 'T1 Description', 'T1   P1', 70, NULL, Null, Null, Null),
(75, 'T2 Description', 'T2   P1', 70, NULL, Null, Null, Null),
(76, 'T3 Description', 'T3   P1', 70, NULL, Null, Null, Null),
(77, 'T4 Description', 'T4   P1', 70, NULL, Null, Null, Null),
(78, 'T1 Description', 'T1-P1', 72, NULL, Null, Null, Null),
(79, 'T2 Description', 'T2-P1', 72, NULL, Null, Null, Null),
(80, 'T3 Description', 'T3-P1', 72, NULL, Null, Null, Null),
(81, 'T4 Description', 'T4-P1', 72, NULL, Null, Null, Null),
(86, 'T1 Description', 'T1&P1', 73, NULL, Null, Null, Null),
(87, 'T2 Description', 'T2&P1', 73, NULL, Null, Null, Null),
(88, 'T3 Description', 'T3&P1', 73, NULL, Null, Null, Null),
(89, 'T4 Description', 'T4&P1', 73, NULL, Null, Null, Null);


-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `annee_experience` int(11) NOT NULL,
  `date_inscription` date DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `salaire` double NOT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `utilisateur` (`id`, `email`, `password`, `username`, `photo`, `nom`, `gender`, `prenom`, `date_of_birth`, `annee_experience`, `date_inscription`, `salaire`) VALUES
 (16, 'hamza@gmail.com', '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', 'Hamza.Aitahmed', 'images/user/user-1.jpg', 'hamza', 'Male', 'Aitahmed', '2003-01-09',null,null,null),
 (17, 'aitahmed@gmail.com', NULL,  'Ait Ahmed', 'images/user/user-2.jpg', NULL, NULL, NULL, '2024-07-10',null,null,null),
 (18, 'user@gmail.com', NULL,  'old user', 'images/user/user-3.jpg', NULL, NULL, NULL, '2024-07-05',null,null,null),
 (19, 'Amina@gmail.com', NULL, 'Amina', 'images/user/user-4.jpg', NULL, NULL, NULL, NULL,null,null,null),
 (20, 'Said@gmail.com', NULL,  'Said', 'images/user/11.jpg', NULL, NULL, NULL, NULL,null,null,null),
 (21, 'Karim@gmail.com', NULL,  'Karim', 'images/user/07.jpg', NULL, NULL, NULL, NULL,null,null,null),
 (22, 'Reda@gmail.com', NULL,  'Reda', 'images/user/08.jpg', NULL, NULL, NULL, NULL,null,null,null),
 (23, 'Khadija@gmail.com', NULL,  'Khadija', 'images/user/user-6.jpg', NULL, NULL, NULL, NULL,null,null,null),
 (24, 'user9@gmail.com', '123',  'old user', 'images/user/inconnu.jpg', NULL, NULL, NULL, '2024-07-06',null,null,null),
 (25, 'hamzaaitahmed003@gmail.com', '123',  'hamza#03', 'images/user/inconnu.jpg', NULL, NULL, NULL, NULL,null,null,null),
 (26, 'hamzaaitahmed030@gmail.com', '123', 'hamzaTest', 'images/user/inconnu.jpg', NULL, NULL, NULL, NULL,null,null,null),
 (27, 'hamzaaitahmed023@gmail.com', '123',  'hamza003', 'images/user/inconnu.jpg', NULL, NULL, NULL, NULL,null,null,null),
 (28, 'hamzaaitahmed03@gmail.com', '123', 'Hamza.aitahmed', 'images/user/inconnu.jpg', NULL, NULL, NULL, NULL,null,null,null),
 (29, 'messouk@gmail.com', '123',  'youness messouk', 'images/user/inconnu.jpg', NULL, NULL, NULL, NULL,null,null,null),
 (30, 'user123@gmail.com', '123',  'user123', 'images/user/inconnu.jpg', NULL, NULL, NULL, NULL,null,null,null),
 (31, 'admin@gmail.com', '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', 'admin', 'images/user/11.jpg', NULL, NULL, NULL, NULL,null,null,null);

-- --------------------------------------------------------

--
-- Structure de la table `refresh_token`
--

CREATE TABLE `refresh_token` (
 `id` int(11) NOT NULL,
 `created_at` datetime(6) DEFAULT NULL,
 `expires_at` datetime(6) DEFAULT NULL,
 `revoked` bit(1) NOT NULL,
 `token` varchar(255) DEFAULT NULL,
 `proprietaire_du_token_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `refresh_token`
--

INSERT INTO `refresh_token` (`id`, `created_at`, `expires_at`, `revoked`, `token`, `proprietaire_du_token_id`) VALUES
(4, '2026-02-23 01:05:59.000000', '2026-03-02 01:05:59.000000', b'1', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJoYW16YUBnbWFpbC5jb20iLCJpYXQiOjE3NzE4MDg3NTksImV4cCI6MTc3NDQwMDc1OX0.y93rkudYQ1ZpuYPy1xIgmXK_c55hnphAmOMxgGH_q9EmCa5sQtC0hDg5CrX3sFin-tmKGmIvCuDDT1nzp5FxQw', 16),
(5, '2026-02-23 01:06:17.000000', '2026-03-02 01:06:17.000000', b'1', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJoYW16YUBnbWFpbC5jb20iLCJpYXQiOjE3NzE4MDg3NzcsImV4cCI6MTc3NDQwMDc3N30.pmIfyJOujbnjHxoJH-AjlmFfSMRqfKtctcIN0vK-tNbi5GsPEvcttfVzel-z822ScqCtq76PLKbzovArpCRL1Q', 16);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKtmpaatkvnqxaa1xpqfah1xhg9` (`nom`),
  ADD KEY `FKqlnvn7x2ulva8k081d716bxr` (`chef_equipe_id`);

--
-- Index pour la table `equipe_les_membresdequipe`
--
ALTER TABLE `equipe_les_membresdequipe`
  ADD KEY `FK56ga8v057dqy5b42xgvvdeyoq` (`les_membresdequipe_id`),
  ADD KEY `FK7igt11eyhythgotnootpyqd1w` (`membre_danslequipe_id`);

--
-- Index pour la table `projet`
--
ALTER TABLE `projet`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKhc62ibguw2x2cf7f1b2sr2j23` (`nom`),
  ADD KEY `FKryggnvufkm34xwoqvuegjusq7` (`chef_projet_id`),
  ADD KEY `FK4dvjk7ccuo7mofnn72ybnt3md` (`equipe_du_projet_id`);

--
-- Index pour la table `refresh_token`
--
ALTER TABLE `refresh_token`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKoah43xchqcesap1exueatv4pd` (`proprietaire_du_token_id`);

--
-- Index pour la table `tache`
--
ALTER TABLE `tache`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKfk47y4u17vj7i2msi6wjr88ob` (`nom`),
  ADD KEY `FK4dqnn3s6y4t3gkhxhq1bgjc0h` (`assigneur_de_tache_id`),
  ADD KEY `FKcx5pf0jhcsknfds1xuip1mowa` (`projet_de_tache_id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKrma38wvnqfaf66vvmi57c71lo` (`email`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `equipe`
--
ALTER TABLE `equipe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `projet`
--
ALTER TABLE `projet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `refresh_token`
--
ALTER TABLE `refresh_token`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `tache`
--
ALTER TABLE `tache`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD CONSTRAINT `FKqlnvn7x2ulva8k081d716bxr` FOREIGN KEY (`chef_equipe_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `equipe_les_membresdequipe`
--
ALTER TABLE `equipe_les_membresdequipe`
  ADD CONSTRAINT `FK56ga8v057dqy5b42xgvvdeyoq` FOREIGN KEY (`les_membresdequipe_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FK7igt11eyhythgotnootpyqd1w` FOREIGN KEY (`membre_danslequipe_id`) REFERENCES `equipe` (`id`);

--
-- Contraintes pour la table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `FK4dvjk7ccuo7mofnn72ybnt3md` FOREIGN KEY (`equipe_du_projet_id`) REFERENCES `equipe` (`id`),
  ADD CONSTRAINT `FKryggnvufkm34xwoqvuegjusq7` FOREIGN KEY (`chef_projet_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `projet`
--
ALTER TABLE `refresh_token`
  ADD CONSTRAINT `FKoah43xchqcesap1exueatv4pd` FOREIGN KEY (`proprietaire_du_token_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `tache`
--
ALTER TABLE `tache`
  ADD CONSTRAINT `FK4dqnn3s6y4t3gkhxhq1bgjc0h` FOREIGN KEY (`assigneur_de_tache_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FKcx5pf0jhcsknfds1xuip1mowa` FOREIGN KEY (`projet_de_tache_id`) REFERENCES `projet` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
