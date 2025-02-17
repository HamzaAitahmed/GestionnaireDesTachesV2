export interface TacheRequest {
    nom: string;
    description: string;
    statutTache: string;
    priorite: string;
    dateDeCreation: string;
    dateDebut: string;
    dateFin: string;
    historiqueDeLaTacheId: number;
    projetDeTacheId: number;
    assigneurDeTacheId: number;
}