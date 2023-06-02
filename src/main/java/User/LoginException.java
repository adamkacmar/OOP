package User;

/**
 * Trieda slúži na spracovanie výnimky v prihlasocavom okne, ak ide o chybu v prihlásení.
 */
public class LoginException extends Exception {
    public LoginException(String message) {
        super(message);
    }
}
