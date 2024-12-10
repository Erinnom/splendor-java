<<<<<<< HEAD

=======
>>>>>>> kewen
/**
 * Décrivez votre classe DiscardTokensAction ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

import java.util.ArrayList;

public class DiscardTokensAction implements Action
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre

    private ArrayList<Resource> resource;
    /**
     * Constructeur d'objets de classe DiscardTokensAction
     */
    public DiscardTokensAction(ArrayList<Resource> resource)
    {
        // initialisation des variables d'instance
        this.resource = resource;
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public void process(Player player, Board board)
    {
        for (Resource elem : resource){
            player.updateNbResource(elem,-1);
            board.updateNbResource(elem, 2);
        }
        this.toString(player);
    }
    
    public String toString(Player player){
        String msg = " Le joueur suivant s'est défaussé de jetons :" + player;
        return msg;
    }
}
<<<<<<< HEAD
=======

>>>>>>> kewen
