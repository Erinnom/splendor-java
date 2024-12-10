
/**
 * Décrivez votre classe DumbRobotPlayer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DumbRobotPlayer extends Player
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    

    /**
     * Constructeur d'objets de classe DumbRobotPlayer
     */
    public DumbRobotPlayer(int id,String name)
    {
        // initialisation des variables d'instance
        super(id,name);
        
    }

    
    public Action chooseAction(Player player,Board board){
        return null;
    }
    public Action chooseDiscardingTokens(){
        return null;
    }
    public void process(Player player, Board board){
        int n;
    }
    public String toString(){
        return "";
    }
}
