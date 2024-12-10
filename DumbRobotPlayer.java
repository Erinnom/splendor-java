/**
 * Décrivez votre classe DumbRobotPlayer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DumbRobotPlayer extends Player {

    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int action;

    /**
     * Constructeur d'objets de classe DumbRobotPlayer
     */
    public DumbRobotPlayer(int id, String name) {
        // initialisation des variables d'instance
        super(id, name);
        action = 0;
    }

    public Action chooseAction(Player player, Board board) {
        switch (action) {
            case 0:
                action += 1;
                break;
            case 1:
                action += 1;
                break;
            case 2:
                action += 1;
                break;
            case 3:
                action = 0;
                break;
            default:
                action = 0;
                break;
        }
        return null;
    }

    public Action chooseDiscardingTokens() {
        return null;
    }

    public void process(Player player, Board board) {
        int n;
    }

    public String toString() {
        return "";
    }
}
