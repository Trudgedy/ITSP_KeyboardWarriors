package Classes;

/**
 *
 * @author Trudgedy
 */
public class UserAuthentication {

    private String LoggedInUser = "";

    public boolean Login(String username, String password) {

        Database db = new Database();

        db.connect_db();

        String[] passwordDetails = db.getPassword(username);

        //Encrypt password here
        if (passwordDetails[0].equals(password)) {
            LoggedInUser = username;
            System.out.println("Logged in");
            return true;
        }

        return false;
    }

    public boolean isLoggedIn() {

        if (!"".equals(LoggedInUser)) {
            return true;
        }

        return false;
    }

    public void logout() {
        LoggedInUser = "";
    }

}
