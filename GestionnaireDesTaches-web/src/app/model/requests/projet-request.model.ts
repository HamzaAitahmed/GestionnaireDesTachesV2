export interface ProjetRequest {
    nom: string;

    budget: number;
    client: string;
    description: string;

    dateDeCreation: string;
    dateDebut: string;
    dateFin: string;

    chefProjetId: number | null;
    equipeDuProjetId: number | null;
    lesTachesDeProjetIds: number[] | null;
}
