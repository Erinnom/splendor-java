
/**
 * Décrivez votre classe PassAction ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.List;
import java.util.ArrayList;

public class PassAction implements Action
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private List<Player> players;

    /**
     * Constructeur d'objets de classe PassAction
     */
    public PassAction(List<Player> players)
    {
        // initialisation des variables d'instance
        this.players = players;
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public void process(Player player, Board board)
    {
        players.remove(player);
        players.add(player);
        System.out.println(this.toString(player));
    }
    
    public String toString(Player player){
        return ("le joueur suivant a passé son tour : " + player.getName() ) ;
    }
}
