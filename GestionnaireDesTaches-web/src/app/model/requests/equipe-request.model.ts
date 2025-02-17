export interface EquipeRequest {
    nom: string;
    dateDeCreation: string;
    chefEquipeId: number;
    lesProjetsDEquipeIds: number[];
    lesMembresDEquipeIds: number[];
}