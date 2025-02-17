export interface ProjetResponse {
    id: number;
    nom: string;
    budget: number;
    client: string;
    description: string;
    statut: string;
    dateDeCreation: string;
    dateDebut: string;
    dateFin: string;
    chefProjetId: number | null;
    equipeDuProjetId: number | null;
    listMesCompetencesId: number | null;
    lesTachesDeProjetIds: number[] | null;
}
