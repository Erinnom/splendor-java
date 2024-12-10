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
     */
    public PickDiffTokensAction(Resource res1, Resource res2, Resource res3) {
        // initialisation des variables d'instance
        resource1 = res1;
        resource2 = res2;
        resource3 = res3;
    }

    public void process(Player player, Board board) {
        board.updateNbResource(resource1, 1);
        player.updateNbResource(resource1, 1);
        board.updateNbResource(resource2, 1);
        player.updateNbResource(resource2, 1);
        board.updateNbResource(resource3, 1);
        player.updateNbResource(resource3, 1);
        this.toString();
    }

    public String toString() {
        String msg = "";
        return (
            msg =
                "Le joueur à choisi de prendre 3 ressources différentes de types" +
                resource1 +
                ", " +
                resource2 +
                " et " +
                resource3
        );
    }
}
