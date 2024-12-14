/**
 * Décrivez votre classe DiscardTokensAction ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

import java.util.ArrayList;

public class DiscardTokensAction implements Action {

    // Attributs

    private ArrayList<Resource> resource;

    /**
     * Constructeur d'objets de classe DiscardTokensAction
     * @param resource la liste des ressources à défausser
     */
    public DiscardTokensAction(ArrayList<Resource> resource) {
        // initialisation des variables d'instance
        this.resource = resource;
    }

    /**
     * Méthode permettant de traiter l'action de défausser des jetons
     * @param player le joueur qui défausse des jetons
     * @param board le plateau de jeu
     * @return void
     */
    public void process(Player player, Board board) {
        for (Resource elem : resource) {
            player.updateNbResource(elem, -1);
            board.updateNbResource(elem, 1);
        }
        Game.display.out.println(this.toString(player));
    }

    public String toString(Player player) {
        String msg =
            " Le joueur " +
            player.getName() +
            " suivant s'est défaussé de jetons de ressources :";
        for (Resource elem : resource) {
            msg += elem + "\n";
        }

        return msg + "\n";
    }
}
