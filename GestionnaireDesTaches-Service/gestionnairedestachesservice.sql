-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 27 déc. 2024 à 15:14
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

--
-- Déchargement des données de la table `competence`
--

INSERT INTO `competence` (`id`, `nom`) VALUES
(12, 'ANGULAR'),
(6, 'C#'),
(2, 'C++'),
(8, 'CSS'),
(11, 'FLUTTER'),
(7, 'HTML'),
(1, 'Java'),
(9, 'JS'),
(5, 'Langage C'),
(3, 'PHP'),
(4, 'PYTHON'),
(10, 'RUBY');

-- --------------------------------------------------------

--
-- Structure de la table `competence_requise`
--

CREATE TABLE `competence_requise` (
  `id` int(11) NOT NULL,
  `id_list_competences_requise` int(11) DEFAULT NULL,
  `niveau` enum('Avance','Debutant','Intermediaire') DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `list_des_competences_requise_id` int(11) DEFAULT NULL,
  `competence_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `competence_requise`
--

INSERT INTO `competence_requise` (`id`, `id_list_competences_requise`, `niveau`, `nom`, `list_des_competences_requise_id`, `competence_id`) VALUES
(1, 1, 'Debutant', 'Java', 1, 1),
(2, 1, 'Debutant', 'CSS', 1, 5),
(3, 1, 'Debutant', 'RUBY', 1, 10),
(4, 1, 'Debutant', 'ANGULAR', 1, 12),
(5, 2, 'Debutant', 'Java', 2, 1),
(6, 2, 'Debutant', 'CSS', 2, 5),
(7, 2, 'Debutant', 'RUBY', 2, 10),
(8, 2, 'Debutant', 'ANGULAR', 2, 12);

-- --------------------------------------------------------

--
-- Structure de la table `competence_utilisateur`
--

CREATE TABLE `competence_utilisateur` (
  `id` int(11) NOT NULL,
  `id_list_des_competences` int(11) DEFAULT NULL,
  `niveau` enum('Avance','Debutant','Intermediaire') DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `list_des_competences_id` int(11) DEFAULT NULL,
  `competence_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `competence_utilisateur`
--

INSERT INTO `competence_utilisateur` (`id`, `id_list_des_competences`, `niveau`, `nom`, `list_des_competences_id`, `competence_id`) VALUES
(1, 3, 'Debutant', 'Java', 3, 1),
(2, 3, 'Debutant', 'CSS', 3, 5),
(3, 3, 'Debutant', 'RUBY', 3, 10),
(4, 3, 'Debutant', 'ANGULAR', 3, 12),
(5, 11, 'Debutant', 'Java', 11, 1),
(6, 11, 'Debutant', 'CSS', 11, 5),
(7, 11, 'Debutant', 'RUBY', 11, 10),
(8, 11, 'Debutant', 'ANGULAR', 11, 12),
(9, 9, 'Debutant', 'Java', 9, 1),
(10, 9, 'Debutant', 'CSS', 9, 5),
(11, 9, 'Debutant', 'RUBY', 9, 10),
(12, 9, 'Debutant', 'ANGULAR', 9, 12),
(13, 8, 'Debutant', 'Java', 8, 1),
(14, 8, 'Debutant', 'CSS', 8, 5),
(15, 8, 'Debutant', 'RUBY', 8, 10),
(16, 8, 'Debutant', 'ANGULAR', 8, 12),
(17, 7, 'Debutant', 'Java', 7, 1),
(18, 7, 'Debutant', 'CSS', 7, 5),
(19, 7, 'Debutant', 'RUBY', 7, 10),
(20, 7, 'Debutant', 'ANGULAR', 7, 12),
(21, 6, 'Debutant', 'Java', 6, 1),
(22, 6, 'Debutant', 'CSS', 6, 5),
(23, 6, 'Debutant', 'RUBY', 6, 10),
(24, 6, 'Debutant', 'ANGULAR', 6, 12),
(25, 5, 'Debutant', 'Java', 5, 1),
(26, 5, 'Debutant', 'CSS', 5, 5),
(27, 5, 'Debutant', 'RUBY', 5, 10),
(28, 5, 'Debutant', 'ANGULAR', 5, 12),
(29, 4, 'Debutant', 'Java', 4, 1),
(30, 4, 'Debutant', 'CSS', 4, 5),
(31, 4, 'Debutant', 'RUBY', 4, 10),
(32, 4, 'Debutant', 'ANGULAR', 4, 12),
(33, 2, 'Debutant', 'Java', 2, 1),
(34, 2, 'Debutant', 'CSS', 2, 5),
(35, 2, 'Debutant', 'RUBY', 2, 10),
(36, 2, 'Debutant', 'ANGULAR', 2, 12);

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE `equipe` (
  `id` int(11) NOT NULL,
  `date_de_creation` date DEFAULT NULL,
  `id_chef_equipe` int(11) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `chef_equipe_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `equipe`
--

INSERT INTO `equipe` (`id`, `date_de_creation`, `id_chef_equipe`, `nom`, `chef_equipe_id`) VALUES
(1, NULL, 1, 'Equipe Hamza', 1),
(2, NULL, 10, 'mohamed Equipe', 10);

-- --------------------------------------------------------

--
-- Structure de la table `equipe_mes_members`
--

CREATE TABLE `equipe_mes_members` (
  `membre_equipe_id` int(11) NOT NULL,
  `mes_members_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `equipe_mes_members`
--

INSERT INTO `equipe_mes_members` (`membre_equipe_id`, `mes_members_id`) VALUES
(2, 3),
(2, 4),
(2, 6),
(2, 7),
(1, 2),
(1, 5),
(1, 8),
(1, 9);

-- --------------------------------------------------------

--
-- Structure de la table `historique_statut`
--

CREATE TABLE `historique_statut` (
  `id` int(11) NOT NULL,
  `id_tache` int(11) DEFAULT NULL,
  `les_statut_de_la_tache_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `historique_statut`
--

INSERT INTO `historique_statut` (`id`, `id_tache`, `les_statut_de_la_tache_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 9, 9);

-- --------------------------------------------------------

--
-- Structure de la table `list_competences_requise`
--

CREATE TABLE `list_competences_requise` (
  `id` int(11) NOT NULL,
  `id_projet` int(11) DEFAULT NULL,
  `projet_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `list_competences_requise`
--

INSERT INTO `list_competences_requise` (`id`, `id_projet`, `projet_id`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `list_competences_utilisateur`
--

CREATE TABLE `list_competences_utilisateur` (
  `id` int(11) NOT NULL,
  `id_utilisateur` int(11) DEFAULT NULL,
  `utilisateur_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `list_competences_utilisateur`
--

INSERT INTO `list_competences_utilisateur` (`id`, `id_utilisateur`, `utilisateur_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10),
(11, 11, 11),
(12, 12, 12),
(13, 13, 13);

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
  `id_chef_projet` int(11) DEFAULT NULL,
  `id_equipe_de_projet` int(11) DEFAULT NULL,
  `id_list_competences_requise` int(11) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `statut` enum('EN_ATTENTE','EN_COURS','SUSPENDU','TERMINEE') DEFAULT NULL,
  `chef_projet_id` int(11) DEFAULT NULL,
  `equipe_de_projet_id` int(11) DEFAULT NULL,
  `list_mes_competences_requise_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `projet`
--

INSERT INTO `projet` (`id`, `budget`, `client`, `date_de_creation`, `date_debut`, `date_fin`, `description`, `id_chef_projet`, `id_equipe_de_projet`, `id_list_competences_requise`, `nom`, `statut`, `chef_projet_id`, `equipe_de_projet_id`, `list_mes_competences_requise_id`) VALUES
(1, 10000, 'Emsi', NULL, NULL, NULL, 'Description Du Projet', NULL, NULL, NULL, 'Projet PFA', NULL, 12, 1, 1),
(2, 900000, 'J2EE', NULL, NULL, NULL, '2nd Project ', NULL, NULL, NULL, 'Application MicroService', NULL, 13, 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `statut_avec_date`
--

CREATE TABLE `statut_avec_date` (
  `id` int(11) NOT NULL,
  `date_de_modification` date DEFAULT NULL,
  `id_historique_statut` int(11) DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `historique_statut_id_id` int(11) DEFAULT NULL
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
  `id_assigneur_de_tache` int(11) DEFAULT NULL,
  `id_historique_statut` int(11) DEFAULT NULL,
  `id_projet_de_tache` int(11) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `priorite` enum('BASSE','CRITIQUE','HAUTE','MOYENNE') DEFAULT NULL,
  `statut_tache` enum('BLOQUEE','EN_ATTENTE','EN_COURS','EN_REVUE','TERMINEE') DEFAULT NULL,
  `assigneur_de_tache_id` int(11) DEFAULT NULL,
  `historique_statut_id` int(11) DEFAULT NULL,
  `projet_de_tache_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `tache`
--

INSERT INTO `tache` (`id`, `date_de_creation`, `date_debut`, `date_fin`, `description`, `id_assigneur_de_tache`, `id_historique_statut`, `id_projet_de_tache`, `nom`, `priorite`, `statut_tache`, `assigneur_de_tache_id`, `historique_statut_id`, `projet_de_tache_id`) VALUES
(1, NULL, NULL, NULL, 'Description Tache 1', NULL, NULL, 1, 'Tache 1 PFA', 'BASSE', NULL, 8, 1, 1),
(2, NULL, NULL, NULL, 'Description Tache 2', NULL, NULL, NULL, 'Tache 2 PFA', 'BASSE', NULL, 9, 2, 1),
(3, NULL, NULL, NULL, 'Description Tache 3', NULL, NULL, NULL, 'Tache 3 PFA', 'BASSE', NULL, 2, 3, 1),
(4, NULL, NULL, NULL, 'Description Tache 4', NULL, NULL, NULL, 'Tache 4 PFA', 'BASSE', NULL, 5, 4, 1),
(5, NULL, NULL, NULL, 'Description Tache 1', 3, NULL, NULL, 'Tache 1 MicroService', 'BASSE', NULL, 3, 5, 2),
(6, NULL, NULL, NULL, 'Description Tache 2', NULL, NULL, NULL, 'Tache 2 MicroService', 'BASSE', NULL, 4, 6, 2),
(7, NULL, NULL, NULL, 'Description Tache 3', NULL, NULL, NULL, 'Tache 3 MicroService', 'BASSE', NULL, 6, 7, 2),
(8, NULL, NULL, NULL, 'Description Tache 4', NULL, NULL, NULL, 'Tache 4 MicroService', 'BASSE', NULL, 7, 8, 2),
(9, NULL, NULL, NULL, 'Description Tache 5', NULL, NULL, NULL, 'Tache 5 PFA', 'BASSE', 'EN_ATTENTE', 5, 9, 1);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `annee_expeience` int(11) NOT NULL,
  `date_inscription` date DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `id_list_mes_competences` int(11) DEFAULT NULL,
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

INSERT INTO `utilisateur` (`id`, `annee_expeience`, `date_inscription`, `date_of_birth`, `email`, `gender`, `id_list_mes_competences`, `nom`, `password`, `prenom`, `photo`, `role`, `salaire`, `username`, `list_mes_competences_id`) VALUES
(1, 0, '2024-12-10', '2024-12-01', 'hamza@gmail.com', 'homme', NULL, 'hamza', '123', 'aitahmed', NULL, 'USER', 1000, 'hamza.aitahmed', 1),
(2, 0, NULL, NULL, 'fahd@gmail.com', 'homme', NULL, 'fahd', '123', 'test', NULL, 'USER', 8000, 'fahd297', 2),
(3, 0, NULL, NULL, 'aitahmed@gmail.com', 'homme', NULL, 'aitahmed', '123', 'test', NULL, 'USER', 32333, 'aitahmed21312', 3),
(4, 0, NULL, NULL, 'said@gmail.com', 'homme', NULL, 'said', '123', 'test', NULL, 'USER', 32333, 'said3723', 4),
(5, 0, NULL, NULL, 'karim@gmail.com', 'homme', NULL, 'karim', '123', 'test', NULL, 'USER', 32333, 'karim0896b', 5),
(6, 0, NULL, NULL, 'fouad@gmail.com', 'homme', NULL, 'fouad', '123', 'test', NULL, 'USER', 32333, 'fouad832l', 6),
(7, 0, NULL, NULL, 'amine@gmail.com', 'homme', NULL, 'amine', '123', 'test', NULL, 'USER', 100, 'amine0932', 7),
(8, 0, NULL, NULL, 'omar@gmail.com', 'homme', NULL, 'omar', '123', 'test', NULL, 'USER', 5000, 'omar3248', 8),
(9, 0, NULL, NULL, 'oussama@gmail.com', 'homme', NULL, 'oussama', '123', 'test', NULL, 'USER', 8000, 'oussama58', 9),
(10, 0, NULL, NULL, 'mohamed@gmail.com', 'homme', NULL, 'mohamed', '123', 'test', NULL, 'USER', 8000, 'mohamed0121', 10),
(11, 0, NULL, NULL, 'jamal@gmail.com', 'homme', NULL, 'jamal', '123', 'test', NULL, 'USER', 9000, 'jamal09878', 11),
(12, 0, NULL, NULL, 'Ali@gmail.com', 'homme', NULL, 'Ali', '123', 'test', NULL, 'USER', 9000, 'Ali7821', 12),
(13, 0, NULL, NULL, 'Chouaib@gmail.com', 'homme', NULL, 'Chouaib', '123', 'test', NULL, 'USER', 12000, 'Chouaib213', 13);

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
  ADD KEY `FKeulo0nhtg7h9exsegwlh6t6ut` (`list_des_competences_requise_id`),
  ADD KEY `FKlawsd9hh4n234sh0j141lw18d` (`competence_id`);

--
-- Index pour la table `competence_utilisateur`
--
ALTER TABLE `competence_utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2c2jb61b3h0f6ar2fpmvimpp2` (`list_des_competences_id`),
  ADD KEY `FK95bq8dh97njj4skpidl9wx1jn` (`competence_id`);

--
-- Index pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKtmpaatkvnqxaa1xpqfah1xhg9` (`nom`),
  ADD KEY `FKqlnvn7x2ulva8k081d716bxr` (`chef_equipe_id`);

--
-- Index pour la table `equipe_mes_members`
--
ALTER TABLE `equipe_mes_members`
  ADD KEY `FKskyc15068surxmrnu8uwumukc` (`mes_members_id`),
  ADD KEY `FKfwv45fyrtbvqsnb1st91ye4ge` (`membre_equipe_id`);

--
-- Index pour la table `historique_statut`
--
ALTER TABLE `historique_statut`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKpd1u7gxcirl2gcdm0qnom62m1` (`les_statut_de_la_tache_id`);

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
  ADD UNIQUE KEY `UKqs8ovfcxpftu4npwcxg8fg3ry` (`list_mes_competences_requise_id`),
  ADD KEY `FKryggnvufkm34xwoqvuegjusq7` (`chef_projet_id`),
  ADD KEY `FKrtd76wah3s1sxi944tvjfkspx` (`equipe_de_projet_id`);

--
-- Index pour la table `statut_avec_date`
--
ALTER TABLE `statut_avec_date`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2venihy22b8m3ytyoh27yi2nq` (`historique_statut_id_id`);

--
-- Index pour la table `tache`
--
ALTER TABLE `tache`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKfk47y4u17vj7i2msi6wjr88ob` (`nom`),
  ADD KEY `FK4dqnn3s6y4t3gkhxhq1bgjc0h` (`assigneur_de_tache_id`),
  ADD KEY `FK27vvwfnx0ax5bur879b8474i7` (`historique_statut_id`),
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `competence_requise`
--
ALTER TABLE `competence_requise`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `competence_utilisateur`
--
ALTER TABLE `competence_utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT pour la table `equipe`
--
ALTER TABLE `equipe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `historique_statut`
--
ALTER TABLE `historique_statut`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `list_competences_requise`
--
ALTER TABLE `list_competences_requise`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `list_competences_utilisateur`
--
ALTER TABLE `list_competences_utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `statut_avec_date`
--
ALTER TABLE `statut_avec_date`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `tache`
--
ALTER TABLE `tache`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `competence_requise`
--
ALTER TABLE `competence_requise`
  ADD CONSTRAINT `FKeulo0nhtg7h9exsegwlh6t6ut` FOREIGN KEY (`list_des_competences_requise_id`) REFERENCES `list_competences_requise` (`id`),
  ADD CONSTRAINT `FKlawsd9hh4n234sh0j141lw18d` FOREIGN KEY (`competence_id`) REFERENCES `competence` (`id`);

--
-- Contraintes pour la table `competence_utilisateur`
--
ALTER TABLE `competence_utilisateur`
  ADD CONSTRAINT `FK2c2jb61b3h0f6ar2fpmvimpp2` FOREIGN KEY (`list_des_competences_id`) REFERENCES `list_competences_utilisateur` (`id`),
  ADD CONSTRAINT `FK95bq8dh97njj4skpidl9wx1jn` FOREIGN KEY (`competence_id`) REFERENCES `competence` (`id`);

--
-- Contraintes pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD CONSTRAINT `FKqlnvn7x2ulva8k081d716bxr` FOREIGN KEY (`chef_equipe_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `equipe_mes_members`
--
ALTER TABLE `equipe_mes_members`
  ADD CONSTRAINT `FKfwv45fyrtbvqsnb1st91ye4ge` FOREIGN KEY (`membre_equipe_id`) REFERENCES `equipe` (`id`),
  ADD CONSTRAINT `FKskyc15068surxmrnu8uwumukc` FOREIGN KEY (`mes_members_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `historique_statut`
--
ALTER TABLE `historique_statut`
  ADD CONSTRAINT `FKtke6etchgvqdgx4mcahjsxvam` FOREIGN KEY (`les_statut_de_la_tache_id`) REFERENCES `tache` (`id`);

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
  ADD CONSTRAINT `FKnpx40t4gjp28jgp1qh1bxwxlk` FOREIGN KEY (`list_mes_competences_requise_id`) REFERENCES `list_competences_requise` (`id`),
  ADD CONSTRAINT `FKrtd76wah3s1sxi944tvjfkspx` FOREIGN KEY (`equipe_de_projet_id`) REFERENCES `equipe` (`id`),
  ADD CONSTRAINT `FKryggnvufkm34xwoqvuegjusq7` FOREIGN KEY (`chef_projet_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `statut_avec_date`
--
ALTER TABLE `statut_avec_date`
  ADD CONSTRAINT `FK2venihy22b8m3ytyoh27yi2nq` FOREIGN KEY (`historique_statut_id_id`) REFERENCES `historique_statut` (`id`);

--
-- Contraintes pour la table `tache`
--
ALTER TABLE `tache`
  ADD CONSTRAINT `FK27vvwfnx0ax5bur879b8474i7` FOREIGN KEY (`historique_statut_id`) REFERENCES `historique_statut` (`id`),
  ADD CONSTRAINT `FK4dqnn3s6y4t3gkhxhq1bgjc0h` FOREIGN KEY (`assigneur_de_tache_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FKcx5pf0jhcsknfds1xuip1mowa` FOREIGN KEY (`projet_de_tache_id`) REFERENCES `projet` (`id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FKabyxtejjki2nvamcjy43ta7td` FOREIGN KEY (`list_mes_competences_id`) REFERENCES `list_competences_utilisateur` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
