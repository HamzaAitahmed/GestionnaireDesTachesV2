export interface CompetencetilisateurResponse {
    id: number;
    nom: string;
    niveau: string;
    competenceId: number | null;
    listCompetencesUtilisateurId: number | null;
}
