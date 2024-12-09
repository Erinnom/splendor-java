
/**
 * Décrivez votre classe PassAction ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

import java.util.ArrayList;

public class PassAction implements Action
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private ArrayList<Player> players;
    private Player player;

    /**
     * Constructeur d'objets de classe PassAction
     */
    public PassAction(ArrayList<Player> players, Player player)
    {
        // initialisation des variables d'instance
        this.players = players;
        this.player = player;
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public void process()
    {
        players.remove(player);
        players.add(player);
        this.toString();
    }
    
    public String toString(){
        return "le joueur suivant a passé son tour :" + player;
    }
}
