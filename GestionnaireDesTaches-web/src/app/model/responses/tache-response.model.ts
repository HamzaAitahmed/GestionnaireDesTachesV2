export interface TacheResponse {
    id: number;

    nom: string;
    description: string;
    statut: boolean;

    dateDeCreation: string;
    dateDebut: string;
    dateFin: string;

    projetDeTacheId: number | null;
    assigneurDeTacheId: number | null;
}
