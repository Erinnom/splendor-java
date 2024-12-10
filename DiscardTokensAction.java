
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
    private Board board;
    private Player player;
    private ArrayList<Resource> resource;
    /**
     * Constructeur d'objets de classe DiscardTokensAction
     */
    public DiscardTokensAction(Board board, Player player)
    {
        // initialisation des variables d'instance
        this.board = board;
        this.player = player;
        resource = new ArrayList<Resource>();
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public void process(Player player, Board board)
    {
        resource = player.chooseDiscardingTokens();
        for (Resource elem : resource){
            player.updateNbResource(elem,-1);
        }
        this.toString();
    }
    
    public String toString(){
        String msg = " Le joueur suivant s'est défaussé de jetons :" + player;
        return msg;
    }
}
