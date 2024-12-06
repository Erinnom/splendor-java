
/**
 * Décrivez votre classe PickSameTokensAction ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.ArrayList;

public class PickDifferentTokensAction implements Action
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Player player;
    private Terminal term;
    private Board board;
    private Ressource ressource;
    /**
     * Constructeur d'objets de classe PickSameTokensAction
     */
    public PickDifferentTokensAction(Player player, Board board)
    {
        // initialisation des variables d'instance
        this.player = player;
        term = new Terminal();
        this.board = board;
    }

    public void process(){
        Ressource ressource;
        Ressource temp[] = board.getAvailableResources();
        ArrayList<Ressource> availableR = new ArrayList<Ressource>();
        
        for (Ressource elem : temp){
            
            availableR.add(elem);
        }
        
        for (int i=0; i<3; i++){
            
            String message = "Choisissez une ressource parmi les suivantes :";
            for (Ressource elem : availableR){
                System.out.println(elem);
            }
            
            String choice = term.playerChoice(message,availableR);
            switch(choice){
                case "DIAMOND":
                    ressource = Ressource.DIAMOND;
                    break;
                case "SAPHIRRE":
                    ressource = Ressource.SAPPHIRE; 
                    break;
                case "EMERALD":
                    ressource = Ressource.EMERALD;
                    break;
                case "ONYX":
                    ressource = Ressource.ONYX; 
                    break;
                case "RUBY":
                    ressource = Ressource.RUBY; 
                    break;
                default:
                    break;
            }
            
            board.updateNbResource(ressource, 1);
            board.setNbResource(ressource, -1);
            player.updateNbResource(ressource, 1);
            availableR.remove(ressource);
        }
        
    }
    
    public String toString(Ressource resource) {
        String msg = "";
        return msg = "Le joueur à choisi de prendre 2 ressources de types" + ressource;
    }
}
