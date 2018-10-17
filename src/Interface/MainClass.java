package Interface;

import Classes.UserAuthentication;

/**
 * @author Heli
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HomeGUI home = new HomeGUI();
        LoginGUI login = new LoginGUI();
        UserAuthentication userAuth = new UserAuthentication();

        if (userAuth.Login("Andrew", "password")) {

            home.setVisible(true);
        } else {

            login.setVisible(true);
        }

    }

}
