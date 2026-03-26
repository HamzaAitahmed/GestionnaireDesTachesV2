package aitahmed.hamza.gestionnairedestachesservice.constants;

public class Constants {

    // ========================= Authentification ============================
    public static final String REFRESH_COOKIE_PATH = "${cookie.refresh.path}";
    public static final String PERMIT_ALL_PATH = "/api/auth/**";
    public static final String ALL_PATH = "/**";

    public static final String REFRESH_TOKEN = "refreshToken";
    public static final String REFRESH_TOKEN_TIME = "${refreshtoken.time}";
    public static final String ACCESS_TOKEN = "accessToken";
    public static final String ACCESS_TOKEN_TIME = "${accesstoken.time}";
    public static final String JWT_SECRET = "${jwt.secret}";

    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_BEARER = "Bearer ";

    public static final String URL_LOCAL_HOST = "${url.localhost}";
    public static final String URL_AUTHENTIFICATION_REST = "/api/auth";
    public static final String URL_INSCRIPTION_REST = "inscription";
    public static final String URL_CONNECTER_REST = "connecter";
    public static final String URL_DECONNECTER_REST = "deconnecter";
    public static final String URL_REFRESH_REST = "refresh";
    public static final String URL_REDIRECT_REFRESH_REST = "redirectToRefresh";

    // ========================= Projet =================================

    public static final String MY_PROJECT = "Mes_Projets";
    public static final String OTHER_PROJECTS = "Les_Autres_Projets";
    public static final String ALL_PROJECTS = "Toutes_Les_Projets";
    public static final String SEARCH = "search";

    public static final String URL_PROJET_REST = "?????????????";

    // ========================= Equipe =================================

    public static final String URL_EQUIPE_REST = "?????????????";

    // ========================= Tache ==================================

    public static final String URL_TACHE_REST = "?????????????";

    // ========================= Utilisateur ============================
    public static final String URL_UTILISATEUR_REST = "?????????????";


}
