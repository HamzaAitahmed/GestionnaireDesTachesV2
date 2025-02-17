export interface TacheResponse {
    id: number;
    nom: string;
    description: string;
    statutTache: string;
    priorite: string;
    dateDeCreation: string;
    dateDebut: string;
    dateFin: string;
    historiqueDeLaTacheId: number | null;
    projetDeTacheId: number | null;
    assigneurDeTacheId: number | null;
}
