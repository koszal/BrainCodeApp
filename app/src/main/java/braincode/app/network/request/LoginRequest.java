package braincode.app.network.request;

/**
 * Created by koszal on 18/03/16.
 */
public class LoginRequest {

    private String login;
    private String password;

    public LoginRequest(String username, String password) {
        this.login = username;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String username) {
        this.login = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
