-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 24 déc. 2024 à 22:36
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
  `competence_de_projet_id` int(11) DEFAULT NULL,
  `competences_id` int(11) DEFAULT NULL,
  `projet_id` int(11) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `competence_utilisateur`
--

CREATE TABLE `competence_utilisateur` (
  `id` int(11) NOT NULL,
  `niveau` enum('Avance','Debutant','Intermediaire') DEFAULT NULL,
  `competence_de_utilisateur_id` int(11) DEFAULT NULL,
  `competences_id` int(11) DEFAULT NULL,
  `utilisateur_id` int(11) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE `equipe` (
  `id` int(11) NOT NULL,
  `date_de_creation` datetime(6) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `chef_equipe_id` int(11) DEFAULT NULL,
  `id_chef_equipe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `equipe`
--

INSERT INTO `equipe` (`id`, `date_de_creation`, `nom`, `chef_equipe_id`, `id_chef_equipe`) VALUES
(1, NULL, 'Equipe Hamza', 1, NULL),
(2, NULL, 'mohamed Equipe', 10, NULL);

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
  `les_statut_de_la_tache_id` int(11) DEFAULT NULL,
  `modifie_par_id` int(11) DEFAULT NULL,
  `id_tache` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `date_de_creation` datetime(6) DEFAULT NULL,
  `date_envoyer` datetime(6) DEFAULT NULL,
  `date_lu` datetime(6) DEFAULT NULL,
  `date_recever` datetime(6) DEFAULT NULL,
  `lu` bit(1) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `emmetteur_id` int(11) DEFAULT NULL,
  `recepteur_id` int(11) DEFAULT NULL,
  `id_emmetteur` int(11) DEFAULT NULL,
  `id_recepteur` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

CREATE TABLE `notification` (
  `id` int(11) NOT NULL,
  `date_de_creation` datetime(6) DEFAULT NULL,
  `date_lu` datetime(6) DEFAULT NULL,
  `lu` bit(1) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `recepteur_id` int(11) DEFAULT NULL,
  `id_recepteur` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE `projet` (
  `id` int(11) NOT NULL,
  `budget` double NOT NULL,
  `client` varchar(255) DEFAULT NULL,
  `date_de_creation` datetime(6) DEFAULT NULL,
  `date_debut` datetime(6) DEFAULT NULL,
  `date_fin` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `statut` enum('EN_ATTENTE','EN_COURS','SUSPENDU','TERMINEE') DEFAULT NULL,
  `chef_projet_id` int(11) DEFAULT NULL,
  `equipe_de_projet_id` int(11) DEFAULT NULL,
  `id_chef_projet` int(11) DEFAULT NULL,
  `id_equipe_de_projet` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `projet`
--

INSERT INTO `projet` (`id`, `budget`, `client`, `date_de_creation`, `date_debut`, `date_fin`, `description`, `nom`, `statut`, `chef_projet_id`, `equipe_de_projet_id`, `id_chef_projet`, `id_equipe_de_projet`) VALUES
(1, 10000, 'Emsi', NULL, NULL, NULL, 'Description Du Projet', 'Projet PFA', NULL, 12, 1, NULL, NULL),
(2, 900000, 'J2EE', NULL, NULL, NULL, '2nd Project ', 'Application MicroService', NULL, 13, 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `statut_avec_date`
--

CREATE TABLE `statut_avec_date` (
  `id` int(11) NOT NULL,
  `date_de_modification` datetime(6) DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `historique_statut_id_id` int(11) DEFAULT NULL,
  `id_historique_statut` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

CREATE TABLE `tache` (
  `id` int(11) NOT NULL,
  `date_de_creation` datetime(6) DEFAULT NULL,
  `date_debut` datetime(6) DEFAULT NULL,
  `date_fin` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `priorite` enum('BASSE','CRITIQUE','HAUTE','MOYENNE') DEFAULT NULL,
  `statut_tache` enum('BLOQUEE','EN_ATTENTE','EN_COURS','EN_REVUE','TERMINEE') DEFAULT NULL,
  `assigneur_de_tache_id` int(11) DEFAULT NULL,
  `historique_statut_id` int(11) DEFAULT NULL,
  `projet_de_tache_id` int(11) DEFAULT NULL,
  `id_assigneur_de_tache` int(11) DEFAULT NULL,
  `id_historique_statut` int(11) DEFAULT NULL,
  `id_projet_de_tache` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `tache`
--

INSERT INTO `tache` (`id`, `date_de_creation`, `date_debut`, `date_fin`, `description`, `nom`, `priorite`, `statut_tache`, `assigneur_de_tache_id`, `historique_statut_id`, `projet_de_tache_id`, `id_assigneur_de_tache`, `id_historique_statut`, `id_projet_de_tache`) VALUES
(1, NULL, NULL, NULL, 'Description Tache 1', 'Tache 1 PFA', NULL, NULL, 8, NULL, 1, NULL, NULL, 1),
(2, NULL, NULL, NULL, 'Description Tache 2', 'Tache 2 PFA', NULL, NULL, 9, NULL, 1, NULL, NULL, NULL),
(3, NULL, NULL, NULL, 'Description Tache 3', 'Tache 3 PFA', NULL, NULL, 2, NULL, 1, NULL, NULL, NULL),
(4, NULL, NULL, NULL, 'Description Tache 4', 'Tache 4 PFA', NULL, NULL, 5, NULL, 1, NULL, NULL, NULL),
(5, NULL, NULL, NULL, 'Description Tache 1', 'Tache 1 MicroService', NULL, NULL, 3, NULL, 2, 3, NULL, NULL),
(6, NULL, NULL, NULL, 'Description Tache 2', 'Tache 2 MicroService', NULL, NULL, 4, NULL, 2, NULL, NULL, NULL),
(7, NULL, NULL, NULL, 'Description Tache 3', 'Tache 3 MicroService', NULL, NULL, 6, NULL, 2, NULL, NULL, NULL),
(8, NULL, NULL, NULL, 'Description Tache 4', 'Tache 4 MicroService', NULL, NULL, 7, NULL, 2, NULL, NULL, NULL),
(9, NULL, NULL, NULL, 'Description Tache 5', 'Tache 5 PFA', 'BASSE', 'EN_ATTENTE', 5, NULL, 1, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `annee_expeience` datetime(6) DEFAULT NULL,
  `date_inscription` datetime(6) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','CHEF_EQUIPE','CHEF_PROJET','MEMBRE','USER') DEFAULT NULL,
  `salaire` double NOT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `annee_expeience`, `date_inscription`, `date_of_birth`, `email`, `gender`, `nom`, `password`, `prenom`, `photo`, `role`, `salaire`, `username`) VALUES
(1, '0000-00-00 00:00:00.000000', '2024-12-10 17:20:01.000000', '2024-12-01', 'hamza@gmail.com', 'homme', 'hamza', '123', 'aitahmed', NULL, 'USER', 1000, 'hamza.aitahmed'),
(2, NULL, NULL, NULL, 'fahd@gmail.com', 'homme', 'fahd', '123', 'test', NULL, 'USER', 8000, 'fahd297'),
(3, NULL, NULL, NULL, 'aitahmed@gmail.com', 'homme', 'aitahmed', '123', 'test', NULL, 'USER', 32333, 'aitahmed21312'),
(4, NULL, NULL, NULL, 'said@gmail.com', 'homme', 'said', '123', 'test', NULL, 'USER', 32333, 'said3723'),
(5, NULL, NULL, NULL, 'karim@gmail.com', 'homme', 'karim', '123', 'test', NULL, 'USER', 32333, 'karim0896b'),
(6, NULL, NULL, NULL, 'fouad@gmail.com', 'homme', 'fouad', '123', 'test', NULL, 'USER', 32333, 'fouad832l'),
(7, NULL, NULL, NULL, 'amine@gmail.com', 'homme', 'amine', '123', 'test', NULL, 'USER', 100, 'amine0932'),
(8, NULL, NULL, NULL, 'omar@gmail.com', 'homme', 'omar', '123', 'test', NULL, 'USER', 5000, 'omar3248'),
(9, NULL, NULL, NULL, 'oussama@gmail.com', 'homme', 'oussama', '123', 'test', NULL, 'USER', 8000, 'oussama58'),
(10, NULL, NULL, NULL, 'mohamed@gmail.com', 'homme', 'mohamed', '123', 'test', NULL, 'USER', 8000, 'mohamed0121'),
(11, NULL, NULL, NULL, 'jamal@gmail.com', 'homme', 'jamal', '123', 'test', NULL, 'USER', 9000, 'jamal09878'),
(12, NULL, NULL, NULL, 'Ali@gmail.com', 'homme', 'Ali', '123', 'test', NULL, 'USER', 9000, 'Ali7821'),
(13, NULL, NULL, NULL, 'Chouaib@gmail.com', 'homme', 'Chouaib', '123', 'test', NULL, 'USER', 12000, 'Chouaib213');

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
  ADD UNIQUE KEY `UKrliryftwp6k0qo7ghro3k8mpm` (`competences_id`),
  ADD KEY `FKhyu8l4yatfu64a4wqnqhg6t6n` (`competence_de_projet_id`);

--
-- Index pour la table `competence_utilisateur`
--
ALTER TABLE `competence_utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK36vgdyxamcd4r9guqgfqycqv1` (`competences_id`),
  ADD KEY `FKkfwx7il9f47y6cm85p1nb36pd` (`competence_de_utilisateur_id`);

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
  ADD UNIQUE KEY `UKpd1u7gxcirl2gcdm0qnom62m1` (`les_statut_de_la_tache_id`),
  ADD UNIQUE KEY `UKle5m5alkpo0ca7fmk4hc753ob` (`modifie_par_id`);

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
  ADD UNIQUE KEY `UKrma38wvnqfaf66vvmi57c71lo` (`email`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `historique_statut`
--
ALTER TABLE `historique_statut`
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
  ADD CONSTRAINT `FK9k8yxk2lk0frtro53eyqtjvl7` FOREIGN KEY (`competences_id`) REFERENCES `competence` (`id`),
  ADD CONSTRAINT `FKhyu8l4yatfu64a4wqnqhg6t6n` FOREIGN KEY (`competence_de_projet_id`) REFERENCES `projet` (`id`);

--
-- Contraintes pour la table `competence_utilisateur`
--
ALTER TABLE `competence_utilisateur`
  ADD CONSTRAINT `FKihqech73dgtcomnfnx5aa6q39` FOREIGN KEY (`competences_id`) REFERENCES `competence` (`id`),
  ADD CONSTRAINT `FKkfwx7il9f47y6cm85p1nb36pd` FOREIGN KEY (`competence_de_utilisateur_id`) REFERENCES `utilisateur` (`id`);

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
  ADD CONSTRAINT `FKg4ro811xavc7dh4kbvbic9ske` FOREIGN KEY (`modifie_par_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FKtke6etchgvqdgx4mcahjsxvam` FOREIGN KEY (`les_statut_de_la_tache_id`) REFERENCES `tache` (`id`);

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
