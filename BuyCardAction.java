
/**
 * Décrivez votre classe BuyCardAction ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

import java.util.ArrayList;

public class BuyCardAction implements Action
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Player player;
    private Terminal term;
    private Board board;
    private DevCard card;        

    /**
     * Constructeur d'objets de classe BuyCardActionù
     */
    public BuyCardAction(Board board, Player player)
    {
        this.board = board;
        this.player = player;
        term = new Terminal();
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public void process()
    {   
        String message;
        String y;
        String x;
        ArrayList<String> possible = new ArrayList<String>();
        possible.add("1");
        possible.add("2");
        possible.add("3");
        int cout;
        
        while (true){
            
            message = "quel niveau de carte voulez-vous acheter ? 1, 2 ou 3?";
            y = term.playerChoice(message,possible);
            message = "Quel carte pour ce niveau voulez vous achetez ? 1, 2 ou 3?";
            x = term.playerChoice(message, possible);
            card = board.getCard(Integer.parseInt(y),Integer.parseInt(x));
            
            if (player.canBuyCard(card)){
                
                Resource[] resourceAvailable = card.coutResources.getAvaibleResources();
                for (int i=0; i<resourceAvailable.length;i++){
                    cout = card.coutResources.getNbResource(resourceAvailable[i]);
                    player.updateNbResource(resourceAvailable[i], cout);
                }
                
                player.addPurchaseCard();
                player.updatePoints(card.points);
                board.updateCard(Integer.parseInt(y),Integer.parseInt(x));
                break;
                
            } else {
                System.out.println("Vous ne pouvez pas acheter cette carte, veuillez en choisir une autre");
            }
        }
        this.toString();
    }
    
    public String toString(){
        return "Le joueur a acheté la carte suivante :" + card;
    }
}
