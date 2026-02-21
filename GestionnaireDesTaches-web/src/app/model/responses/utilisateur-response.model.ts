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

    profilePicture: string;

    mesProjetsIds: number[] | null;
    mesTachesIds: number[] | null;
    mesEquipesIds: number[] | null;
    membreDansLEquipeIds: number[] | null;
}
