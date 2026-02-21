export interface TacheRequest {
    nom: string;
    description: string;

    dateDeCreation: string;
    dateDebut: string;
    dateFin: string;

    projetDeTacheId: number;
    assigneurDeTacheId: number;
}
