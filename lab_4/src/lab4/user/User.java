package lab4.user;

import lab4.user.userMenu.Command;
import java.util.HashMap;
import java.util.Map;

public class User {

    Map<String, Command> userCommands = new HashMap();

    public void addCommand(String name,Command command) {
        this.userCommands.put(name,command);
    }

    public void runCommand(String name) {
        this.userCommands.get(name).execute();
    }
}
