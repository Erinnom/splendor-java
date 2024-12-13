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
     */
    public BuyCardAction(DevCard card) {
        this.card = card;
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public void process(Player player, Board board) {
        int cout;
        if (player.canBuyCard(card)) {
            Resource[] resourceAvailable = card.coutResources.getAvaibleResources();
            for (int i = 0; i < resourceAvailable.length; i++) {
                cout = card.coutResources.getNbResource(resourceAvailable[i]);
                player.updateNbResource(resourceAvailable[i], - (cout - player.getResFromCards(resourceAvailable[i])));
                board.updateNbResource(resourceAvailable[i], cout);
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
        return (msg = "Le joueur " + player.getName() +" a acheté la carte suivante : " + card + "\n");
    }
}

