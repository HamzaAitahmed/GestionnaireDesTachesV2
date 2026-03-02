import {TokenResponse} from './token.response';
import {UtilisateurResponse} from './utilisateur-response.model';

export interface ConnecterResponse {
    tokenResponse: TokenResponse;
    utulisateurResponse: UtilisateurResponse;
}
