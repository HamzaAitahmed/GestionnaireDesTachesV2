-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 16 fév. 2025 à 19:54
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestionnairedestachesservice`
--

-- --------------------------------------------------------

--
-- Structure de la table `competence`
--

CREATE TABLE `competence` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `competence_requise`
--

CREATE TABLE `competence_requise` (
  `id` int(11) NOT NULL,
  `niveau` enum('Avance','Debutant','Intermediaire') DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `competence_id` int(11) DEFAULT NULL,
  `list_competences_requise_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `competence_utilisateur`
--

CREATE TABLE `competence_utilisateur` (
  `id` int(11) NOT NULL,
  `niveau` enum('Avance','Debutant','Intermediaire') DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `competence_id` int(11) DEFAULT NULL,
  `list_competences_utilisateur_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
-- Déchargement des données de la table `equipe`
--

INSERT INTO `equipe` (`id`, `date_de_creation`, `nom`, `chef_equipe_id`) VALUES
(16, NULL, 'T1 Hamza', 16),
(17, NULL, 'T2 Hamza', 16),
(18, NULL, 'T1 Aitahmed', 17),
(19, NULL, 'T2 Aitahmed', 17),
(20, NULL, 'T1 ibtissam', 18),
(21, NULL, 'T2 ibtissam', 18),
(22, NULL, 'T1 Amina', 19),
(23, NULL, 'T1 Karim', 21),
(24, NULL, 'T2 Karim', 21),
(25, NULL, 'test team', 16);

-- --------------------------------------------------------

--
-- Structure de la table `equipe_les_membresdequipe`
--

CREATE TABLE `equipe_les_membresdequipe` (
  `membre_danslequipe_id` int(11) NOT NULL,
  `les_membresdequipe_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `equipe_les_membresdequipe`
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
-- Structure de la table `historique_statut`
--

CREATE TABLE `historique_statut` (
  `id` int(11) NOT NULL,
  `tache_de_historique_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `historique_statut`
--

INSERT INTO `historique_statut` (`id`, `tache_de_historique_id`) VALUES
(1, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `list_competences_requise`
--

CREATE TABLE `list_competences_requise` (
  `id` int(11) NOT NULL,
  `projet_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `list_competences_utilisateur`
--

CREATE TABLE `list_competences_utilisateur` (
  `id` int(11) NOT NULL,
  `utilisateur_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `date_de_creation` date DEFAULT NULL,
  `date_envoyer` date DEFAULT NULL,
  `date_lu` date DEFAULT NULL,
  `date_recever` date DEFAULT NULL,
  `id_emmetteur` int(11) DEFAULT NULL,
  `id_recepteur` int(11) DEFAULT NULL,
  `lu` bit(1) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `emmetteur_id` int(11) DEFAULT NULL,
  `recepteur_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

CREATE TABLE `notification` (
  `id` int(11) NOT NULL,
  `date_de_creation` date DEFAULT NULL,
  `date_lu` date DEFAULT NULL,
  `id_recepteur` int(11) DEFAULT NULL,
  `lu` bit(1) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `recepteur_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `statut` enum('EN_ATTENTE','EN_COURS','SUSPENDU','TERMINEE') DEFAULT NULL,
  `chef_projet_id` int(11) DEFAULT NULL,
  `equipe_du_projet_id` int(11) DEFAULT NULL,
  `list_mes_competences_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `projet`
--

INSERT INTO `projet` (`id`, `budget`, `client`, `date_de_creation`, `date_debut`, `date_fin`, `description`, `nom`, `statut`, `chef_projet_id`, `equipe_du_projet_id`, `list_mes_competences_id`) VALUES
(67, 0, NULL, NULL, NULL, NULL, 'P1 Description', 'P1 Hamza', 'EN_ATTENTE', 16, 20, NULL),
(68, 0, NULL, NULL, NULL, NULL, 'P2 Description', 'P2 Hamza', 'EN_ATTENTE', 16, 19, NULL),
(69, 0, NULL, NULL, NULL, NULL, 'P1 Description', 'P1 Aitahmed', 'EN_ATTENTE', 17, 22, NULL),
(70, 0, NULL, NULL, NULL, NULL, 'P1 Description', 'P1 Amina', 'EN_ATTENTE', 19, 16, NULL),
(71, 0, NULL, NULL, NULL, NULL, 'P1 Description', 'P1 ibtissam', 'EN_ATTENTE', 18, 19, NULL),
(72, 0, NULL, NULL, NULL, NULL, 'P1 Description', 'P1 Said', 'EN_ATTENTE', 20, 21, NULL),
(73, 0, NULL, NULL, NULL, NULL, 'P2 Description', 'P2 Said', 'EN_ATTENTE', 20, 16, NULL),
(74, 0, NULL, NULL, NULL, NULL, 'P1 Description', 'P1 Karim', 'EN_ATTENTE', 21, 16, NULL),
(75, 0, NULL, NULL, NULL, NULL, 'P2 Description', 'P2 Karim', 'EN_ATTENTE', 21, NULL, NULL),
(78, 0, NULL, NULL, NULL, NULL, 'P3 No Description No Need  Team', 'P3 Hamza', 'EN_ATTENTE', 16, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `statut_avec_date`
--

CREATE TABLE `statut_avec_date` (
  `id` int(11) NOT NULL,
  `date_de_modification` date DEFAULT NULL,
  `statut` enum('BLOQUEE','EN_ATTENTE','EN_COURS','EN_REVUE','TERMINEE') DEFAULT NULL,
  `historique_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `priorite` enum('BASSE','CRITIQUE','HAUTE','MOYENNE') DEFAULT NULL,
  `statut_tache` enum('BLOQUEE','EN_ATTENTE','EN_COURS','EN_REVUE','TERMINEE') DEFAULT NULL,
  `assigneur_de_tache_id` int(11) DEFAULT NULL,
  `historique_de_la_tache_id` int(11) DEFAULT NULL,
  `projet_de_tache_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `tache`
--

INSERT INTO `tache` (`id`, `date_de_creation`, `date_debut`, `date_fin`, `description`, `nom`, `priorite`, `statut_tache`, `assigneur_de_tache_id`, `historique_de_la_tache_id`, `projet_de_tache_id`) VALUES
(53, NULL, NULL, NULL, 'T1 Description', 'T1 P1', NULL, 'EN_ATTENTE', NULL, NULL, 67),
(54, NULL, NULL, NULL, 'T2 Description', 'T2 P1', NULL, 'EN_ATTENTE', NULL, NULL, 67),
(55, NULL, NULL, NULL, 'T3 Description', 'T3 P3', NULL, 'EN_ATTENTE', NULL, NULL, 67),
(56, NULL, NULL, NULL, 'T4 Description', 'T4 P4', NULL, 'EN_ATTENTE', NULL, NULL, 67),
(57, NULL, NULL, NULL, 'T1 Descrition', 'T1 P2', NULL, 'EN_ATTENTE', 16, NULL, 68),
(59, NULL, NULL, NULL, 'T2 Descrition', 'T2 P2', NULL, 'EN_ATTENTE', 18, NULL, 68),
(60, NULL, NULL, NULL, 'T3 Descrition', 'T3 P2', NULL, 'EN_ATTENTE', 17, NULL, 68),
(61, NULL, NULL, NULL, 'T4 Descrition', 'T4 P2', NULL, 'EN_ATTENTE', 22, NULL, 68),
(66, NULL, NULL, NULL, 'T1 Description', 'T 1 P1', NULL, 'EN_ATTENTE', NULL, NULL, 69),
(67, NULL, NULL, NULL, 'T2 Description', 'T 2 P1', NULL, 'EN_ATTENTE', NULL, NULL, 69),
(68, NULL, NULL, NULL, 'T3 Description', 'T 3 P1', NULL, 'EN_ATTENTE', NULL, NULL, 69),
(69, NULL, NULL, NULL, 'T4 Description', 'T 4 P1', NULL, 'EN_ATTENTE', NULL, NULL, 69),
(70, NULL, NULL, NULL, 'T1 Description', 'T1  P1', NULL, 'EN_ATTENTE', NULL, NULL, 71),
(71, NULL, NULL, NULL, 'T2 Description', 'T2  P1', NULL, 'EN_ATTENTE', NULL, NULL, 71),
(72, NULL, NULL, NULL, 'T3 Description', 'T3  P1', NULL, 'EN_ATTENTE', NULL, NULL, 71),
(73, NULL, NULL, NULL, 'T4 Description', 'T4  P1', NULL, 'EN_ATTENTE', NULL, NULL, 71),
(74, NULL, NULL, NULL, 'T1 Description', 'T1   P1', NULL, 'EN_ATTENTE', NULL, NULL, 70),
(75, NULL, NULL, NULL, 'T2 Description', 'T2   P1', NULL, 'EN_ATTENTE', NULL, NULL, 70),
(76, NULL, NULL, NULL, 'T3 Description', 'T3   P1', NULL, 'EN_ATTENTE', NULL, NULL, 70),
(77, NULL, NULL, NULL, 'T4 Description', 'T4   P1', NULL, 'EN_ATTENTE', NULL, NULL, 70),
(78, NULL, NULL, NULL, 'T1 Description', 'T1-P1', NULL, 'EN_ATTENTE', NULL, NULL, 72),
(79, NULL, NULL, NULL, 'T2 Description', 'T2-P1', NULL, 'EN_ATTENTE', NULL, NULL, 72),
(80, NULL, NULL, NULL, 'T3 Description', 'T3-P1', NULL, 'EN_ATTENTE', NULL, NULL, 72),
(81, NULL, NULL, NULL, 'T4 Description', 'T4-P1', NULL, 'EN_ATTENTE', NULL, NULL, 72),
(86, NULL, NULL, NULL, 'T1 Description', 'T1&P1', NULL, 'EN_ATTENTE', NULL, NULL, 73),
(87, NULL, NULL, NULL, 'T2 Description', 'T2&P1', NULL, 'EN_ATTENTE', NULL, NULL, 73),
(88, NULL, NULL, NULL, 'T3 Description', 'T3&P1', NULL, 'EN_ATTENTE', NULL, NULL, 73),
(89, NULL, NULL, NULL, 'T4 Description', 'T4&P1', NULL, 'EN_ATTENTE', NULL, NULL, 73);

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
  `role` enum('ADMIN','CHEF_EQUIPE','CHEF_PROJET','MEMBRE','USER') DEFAULT NULL,
  `salaire` double NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `list_mes_competences_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `annee_experience`, `date_inscription`, `date_of_birth`, `email`, `gender`, `nom`, `password`, `prenom`, `photo`, `role`, `salaire`, `username`, `list_mes_competences_id`) VALUES
(16, 0, NULL, '2003-01-09', 'hamza@gmail.com', 'Male', 'Aitahmed', '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', 'hamza', 'assets/images/user/user-1.jpg', NULL, 0, 'Hamza.Aitahmed', NULL),
(17, 0, NULL, '2024-07-10', 'aitahmed@gmail.com', NULL, NULL, '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', NULL, 'assets/images/user/user-2.jpg', NULL, 0, 'Ait Ahmed', NULL),
(18, 0, NULL, '2024-07-05', 'user@gmail.com', NULL, NULL, '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', NULL, 'assets/images/user/user-3.jpg', NULL, 0, 'old user', NULL),
(19, 0, NULL, NULL, 'Amina@gmail.com', NULL, NULL, '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', NULL, 'assets/images/user/user-4.jpg', NULL, 0, 'Amina', NULL),
(20, 0, NULL, NULL, 'Said@gmail.com', NULL, NULL, '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', NULL, 'assets/images/user/11.jpg', NULL, 0, 'Said', NULL),
(21, 0, NULL, NULL, 'Karim@gmail.com', NULL, NULL, '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', NULL, 'assets/images/user/07.jpg', NULL, 0, 'Karim', NULL),
(22, 0, NULL, NULL, 'Reda@gmail.com', NULL, NULL, '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', NULL, 'assets/images/user/08.jpg', NULL, 0, 'Reda', NULL),
(23, 0, NULL, NULL, 'Khadija@gmail.com', NULL, NULL, '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', NULL, 'assets/images/user/user-6.jpg', NULL, 0, 'Khadija', NULL),
(24, 0, NULL, '2024-07-06', 'user9@gmail.com', NULL, NULL, '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', NULL, 'assets/images/user/inconnu.jpg', 'USER', 0, 'old user', NULL),
(25, 0, NULL, NULL, 'hamzaaitahmed003@gmail.com', NULL, NULL, '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', NULL, 'assets/images/user/inconnu.jpg', 'USER', 0, 'hamza#03', NULL),
(26, 0, NULL, NULL, 'hamzaaitahmed030@gmail.com', NULL, NULL, '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', NULL, 'assets/images/user/inconnu.jpg', 'USER', 0, 'hamzaTest', NULL),
(27, 0, NULL, NULL, 'hamzaaitahmed023@gmail.com', NULL, NULL, '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', NULL, 'assets/images/user/inconnu.jpg', 'USER', 0, 'hamza003', NULL),
(28, 0, NULL, NULL, 'hamzaaitahmed03@gmail.com', NULL, NULL, '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', NULL, 'assets/images/user/inconnu.jpg', 'USER', 0, 'Hamza.aitahmed', NULL),
(29, 0, NULL, NULL, 'messouk@gmail.com', NULL, NULL, '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', NULL, 'assets/images/user/inconnu.jpg', 'USER', 0, 'youness messouk', NULL),
(30, 0, NULL, NULL, 'user123@gmail.com', NULL, NULL, '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', NULL, 'assets/images/user/inconnu.jpg', 'USER', 0, 'user123', NULL),
(31, 0, NULL, NULL, 'admin@gmail.com', NULL, NULL, '$2a$10$vvIsfW6rkwxknDYOJ6b.fuwINLYplRuJvfCozCJqIwbI/3UJlRXPS', NULL, 'assets/images/user/11.jpg', 'USER', 0, 'admin', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `competence`
--
ALTER TABLE `competence`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKrrc0ai8b7oycwupef8h16m790` (`nom`);

--
-- Index pour la table `competence_requise`
--
ALTER TABLE `competence_requise`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlawsd9hh4n234sh0j141lw18d` (`competence_id`),
  ADD KEY `FKck9f5cqrbbuo6wra5tcdu5fic` (`list_competences_requise_id`);

--
-- Index pour la table `competence_utilisateur`
--
ALTER TABLE `competence_utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK95bq8dh97njj4skpidl9wx1jn` (`competence_id`),
  ADD KEY `FKg6j2lx3bvesr81kdqicdv9c0g` (`list_competences_utilisateur_id`);

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
-- Index pour la table `historique_statut`
--
ALTER TABLE `historique_statut`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKkg6fgu4n8f2ofdp08e8areavh` (`tache_de_historique_id`);

--
-- Index pour la table `list_competences_requise`
--
ALTER TABLE `list_competences_requise`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKs3guwjya4mtftyfvc031eleao` (`projet_id`);

--
-- Index pour la table `list_competences_utilisateur`
--
ALTER TABLE `list_competences_utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKl0v9d6exmt6ruc5mtlwklbgpl` (`utilisateur_id`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKcv2wxc2dwkatuofaxly6ltkvk` (`emmetteur_id`),
  ADD UNIQUE KEY `UK7vs0jlllfn8ugj28vjx7x6kwl` (`recepteur_id`);

--
-- Index pour la table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqas420ouoy8sh3kesactppnkd` (`recepteur_id`);

--
-- Index pour la table `projet`
--
ALTER TABLE `projet`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKhc62ibguw2x2cf7f1b2sr2j23` (`nom`),
  ADD UNIQUE KEY `UKs5x5kac9oxy1v3beq7wmwjuym` (`list_mes_competences_id`),
  ADD KEY `FKryggnvufkm34xwoqvuegjusq7` (`chef_projet_id`),
  ADD KEY `FK4dvjk7ccuo7mofnn72ybnt3md` (`equipe_du_projet_id`);

--
-- Index pour la table `statut_avec_date`
--
ALTER TABLE `statut_avec_date`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4gja7rcdmldxfmnasn6y740sb` (`historique_id`);

--
-- Index pour la table `tache`
--
ALTER TABLE `tache`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKfk47y4u17vj7i2msi6wjr88ob` (`nom`),
  ADD KEY `FK4dqnn3s6y4t3gkhxhq1bgjc0h` (`assigneur_de_tache_id`),
  ADD KEY `FKslhu2yfd63djgwu9hktvxcm6x` (`historique_de_la_tache_id`),
  ADD KEY `FKcx5pf0jhcsknfds1xuip1mowa` (`projet_de_tache_id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKrma38wvnqfaf66vvmi57c71lo` (`email`),
  ADD UNIQUE KEY `UK5xc8bs1gd5wxsof5o9sr2rl2g` (`list_mes_competences_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `competence`
--
ALTER TABLE `competence`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `competence_requise`
--
ALTER TABLE `competence_requise`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `competence_utilisateur`
--
ALTER TABLE `competence_utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `equipe`
--
ALTER TABLE `equipe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT pour la table `historique_statut`
--
ALTER TABLE `historique_statut`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `list_competences_requise`
--
ALTER TABLE `list_competences_requise`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `list_competences_utilisateur`
--
ALTER TABLE `list_competences_utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `notification`
--
ALTER TABLE `notification`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `projet`
--
ALTER TABLE `projet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- AUTO_INCREMENT pour la table `statut_avec_date`
--
ALTER TABLE `statut_avec_date`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `tache`
--
ALTER TABLE `tache`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `competence_requise`
--
ALTER TABLE `competence_requise`
  ADD CONSTRAINT `FKck9f5cqrbbuo6wra5tcdu5fic` FOREIGN KEY (`list_competences_requise_id`) REFERENCES `list_competences_requise` (`id`),
  ADD CONSTRAINT `FKlawsd9hh4n234sh0j141lw18d` FOREIGN KEY (`competence_id`) REFERENCES `competence` (`id`);

--
-- Contraintes pour la table `competence_utilisateur`
--
ALTER TABLE `competence_utilisateur`
  ADD CONSTRAINT `FK95bq8dh97njj4skpidl9wx1jn` FOREIGN KEY (`competence_id`) REFERENCES `competence` (`id`),
  ADD CONSTRAINT `FKg6j2lx3bvesr81kdqicdv9c0g` FOREIGN KEY (`list_competences_utilisateur_id`) REFERENCES `list_competences_utilisateur` (`id`);

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
-- Contraintes pour la table `historique_statut`
--
ALTER TABLE `historique_statut`
  ADD CONSTRAINT `FKm9g66xo31do66cusxhmrpn0k6` FOREIGN KEY (`tache_de_historique_id`) REFERENCES `tache` (`id`);

--
-- Contraintes pour la table `list_competences_requise`
--
ALTER TABLE `list_competences_requise`
  ADD CONSTRAINT `FK4r0wkmejbgoo896g57jtr7pn0` FOREIGN KEY (`projet_id`) REFERENCES `projet` (`id`);

--
-- Contraintes pour la table `list_competences_utilisateur`
--
ALTER TABLE `list_competences_utilisateur`
  ADD CONSTRAINT `FKhdomatv64gd9dg4yj5idlde8d` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `FK6gkspn4aqf6438y3c3rt5w3ua` FOREIGN KEY (`emmetteur_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FKcqqlqffg9h03eagpbtku5k6u0` FOREIGN KEY (`recepteur_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `FKqas420ouoy8sh3kesactppnkd` FOREIGN KEY (`recepteur_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `FK4dvjk7ccuo7mofnn72ybnt3md` FOREIGN KEY (`equipe_du_projet_id`) REFERENCES `equipe` (`id`),
  ADD CONSTRAINT `FK65fa5hvg27wkaqvp8euk0efbe` FOREIGN KEY (`list_mes_competences_id`) REFERENCES `list_competences_requise` (`id`),
  ADD CONSTRAINT `FKryggnvufkm34xwoqvuegjusq7` FOREIGN KEY (`chef_projet_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `statut_avec_date`
--
ALTER TABLE `statut_avec_date`
  ADD CONSTRAINT `FK4gja7rcdmldxfmnasn6y740sb` FOREIGN KEY (`historique_id`) REFERENCES `historique_statut` (`id`);

--
-- Contraintes pour la table `tache`
--
ALTER TABLE `tache`
  ADD CONSTRAINT `FK4dqnn3s6y4t3gkhxhq1bgjc0h` FOREIGN KEY (`assigneur_de_tache_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FKcx5pf0jhcsknfds1xuip1mowa` FOREIGN KEY (`projet_de_tache_id`) REFERENCES `projet` (`id`),
  ADD CONSTRAINT `FKslhu2yfd63djgwu9hktvxcm6x` FOREIGN KEY (`historique_de_la_tache_id`) REFERENCES `historique_statut` (`id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FKabyxtejjki2nvamcjy43ta7td` FOREIGN KEY (`list_mes_competences_id`) REFERENCES `list_competences_utilisateur` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
