package classes;

import enums.UseState;

public class WebUser {
    String login_id;
    String password;
    UseState state;

    public WebUser(String login_id, String password, UseState state) {
        this.login_id = login_id;
        this.password = password;
        this.state = state;
    }


}
