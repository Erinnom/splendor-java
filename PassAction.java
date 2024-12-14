/**
 * Décrivez votre classe PassAction ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.ArrayList;
import java.util.List;

public class PassAction implements Action {

    // variables d'instance - remplacez l'exemple qui suit par le vôtre

    /**
     * Constructeur d'objets de classe PassAction
     */
    public PassAction() {}

    /**
     * Méthode permettant de traiter l'action de passer son tour
     * @param player le joueur qui passe son tour
     * @param board le plateau de jeu
     * @return void
     */
    public void process(Player player, Board board) {
        Game.display.out.println(this.toString(player));
    }

    public String toString(Player player) {
        return (
            "le joueur suivant a passé son tour : " + player.getName() + "\n"
        );
    }
}
