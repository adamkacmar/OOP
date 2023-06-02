package User;

import java.util.HashMap;
import java.util.Map;

/**
 * Trieda uchovava informacie o prihlasovacich menach a validacnu funkciu.
 */
public class UserLogin {
    private String username;
    private String password;
    private Map<String, String> users = new HashMap<>();

    /**
     * Konštruktor triedy UserLogin, ktorý slúži na uloženie 3 rôznych prihlasovacích variánt.
     */
    public UserLogin() {
        users.put("Admin", "adminovoheslo");
        users.put("TestUser", "testuserheslo");
        users.put("OOPTest", "OOPTestheslo");
    }

    /**
     * Validačná funkcia pre prihlasovanie.
     * @param username
     * @param password
     * @return vracia pravdivostnú hodnotu toho, či sa dané uživateľské meno/heslo nachádza v zozname.
     */
    public boolean isValidLogin(String username, String password) {
        if (users.containsKey(username)) {
            String savedPassword = users.get(username);
            return savedPassword.equals(password);
        }
        return false;
    }

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
