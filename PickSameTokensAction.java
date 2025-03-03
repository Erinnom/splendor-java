/**
 * Décrivez votre classe PickSameTokensAction ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

import java.util.ArrayList;

public class PickSameTokensAction implements Action {

    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Resource resource;

    public PickSameTokensAction(Resource res) {
        // initialisation des variables d'instance
        resource = res;
    }

    /**
     * Méthode permettant de traiter l'action de prendre 2 ressources identiques
     * @param player le joueur qui prend les ressources
     * @param board le plateau de jeu
     * @return void
     */
    public void process(Player player, Board board) {
        board.updateNbResource(resource, -2);
        player.updateNbResource(resource, 2);
        Game.display.out.println(this.toString(player));
    }

    public String toString(Player player) {
        String msg = "";
        return (
            msg =
                "Le joueur " +
                player.getName() +
                " à choisi de prendre 2 ressources de types " +
                resource +
                "\n"
        );
    }
}
