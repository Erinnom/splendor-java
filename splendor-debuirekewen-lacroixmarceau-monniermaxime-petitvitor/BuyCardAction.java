/**
 * Décrivez votre classe BuyCardAction ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

import java.util.ArrayList;

public class BuyCardAction implements Action {

    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private DevCard card;

    /**
     * Constructeur d'objets de classe BuyCardActionù
     * @param card la carte à acheter
     * @return void
     */
    public BuyCardAction(DevCard card) {
        this.card = card;
    }

    /**
     * Méthode permettant de traiter l'action d'achat d'une carte
     * @param player le joueur qui achète la carte
     * @param board le plateau de jeu
     * @return void
     */
    public void process(Player player, Board board) {
        int cout;
        if (player.canBuyCard(card)) {
            Resource[] resourceAvailable =
                card.coutResources.getAvaibleResources();
            for (int i = 0; i < resourceAvailable.length; i++) {
                cout = card.coutResources.getNbResource(resourceAvailable[i]);
                player.updateNbResource(
                    resourceAvailable[i],
                    -Math.max(
                        0,
                        (cout - player.getResFromCards(resourceAvailable[i]))
                    )
                );
                board.updateNbResource(
                    resourceAvailable[i],
                    Math.max(
                        0,
                        (cout - player.getResFromCards(resourceAvailable[i]))
                    )
                );
            }
            player.addPurchasedCard(card);
            player.updatePoints(card.points);
            board.updateCard(card);
            Game.display.out.println(this.toString(card, player));
        } else {
            Game.display.out.println(
                "Vous ne pouvez pas acheter cette carte, veuillez en choisir une autre\n"
            );
        }
    }

    public String toString(DevCard card, Player player) {
        String msg;
        return (
            msg =
                "Le joueur " +
                player.getName() +
                " a acheté la carte suivante : " +
                card +
                "\n"
        );
    }
}
