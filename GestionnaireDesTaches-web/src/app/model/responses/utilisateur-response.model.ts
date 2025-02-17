export interface UtilisateurResponse {
    id: number;
    email: string;
    salaire: number;
    nom: string;
    prenom: string;
    username: string;
    gender: string;
    dateOfBirth: string;
    dateInscription: string;
    anneeExperience: number;
    role: string;
    profilePicture: string;
    listMesCompetencesId: number | null;
    mesProjetsIds: number[] | null;
    mesTachesIds: number[] | null;
    mesEquipesIds: number[] | null;
    membreDansLEquipeIds: number[] | null;
}
