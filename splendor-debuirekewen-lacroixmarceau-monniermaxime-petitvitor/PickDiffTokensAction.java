/**
 * Décrivez votre classe PickSameTokensAction ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class PickDiffTokensAction implements Action {

    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Resource resource1;
    private Resource resource2;
    private Resource resource3;

    /**
     * Constructeur d'objets de classe PickSameTokensAction
     * @param res1 la première ressource à prendre
     * @param res2 la deuxième ressource à prendre
     * @param res3 la troisième ressource à prendre
     * @return void
     */
    public PickDiffTokensAction(Resource res1, Resource res2, Resource res3) {
        // initialisation des variables d'instance
        resource1 = res1;
        resource2 = res2;
        resource3 = res3;
    }

    /**
     * Méthode permettant de traiter l'action de prendre 3 ressources différentes
     * @param player le joueur qui prend les ressources
     * @param board le plateau de jeu
     * @return void
     */
    public void process(Player player, Board board) {
        board.updateNbResource(resource1, -1);
        player.updateNbResource(resource1, 1);
        board.updateNbResource(resource2, -1);
        player.updateNbResource(resource2, 1);
        board.updateNbResource(resource3, -1);
        player.updateNbResource(resource3, 1);

        Game.display.out.println(this.toString(player));
    }

    public String toString(Player player) {
        String msg = "";
        return (
            msg =
                "Le joueur " +
                player.getName() +
                " à choisi de prendre 3 ressources différentes de types " +
                resource1 +
                ", " +
                resource2 +
                " et " +
                resource3 +
                "\n"
        );
    }
}
