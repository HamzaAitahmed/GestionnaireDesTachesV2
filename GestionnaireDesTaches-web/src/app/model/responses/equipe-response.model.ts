export interface EquipeResponse {
    id: number;
    nom: string;
    dateDeCreation: string;
    chefEquipeId: number | null;
    lesProjetsDEquipeIds: number[] | null;
    lesMembresDEquipeIds: number[] | null;
}
