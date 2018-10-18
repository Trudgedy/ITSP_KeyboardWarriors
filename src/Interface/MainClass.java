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
        UserAuthentication userAuth = new UserAuthentication();
        HomeGUI home = new HomeGUI(userAuth);
        
        

        

    }

}
