
/**
 * Décrivez votre classe PickSameTokensAction ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.ArrayList;

public class PickDiffTokensAction implements Action
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Player player;
    private Terminal term;
    private Board board;
    private Resource resource;
    /**
     * Constructeur d'objets de classe PickSameTokensAction
     */
    public PickDiffTokensAction(Player player, Board board)
    {
        // initialisation des variables d'instance
        this.player = player;
        term = new Terminal();
        this.board = board;
    }

    public void process(){
        Resource resource = null;
        Resource temp[] = board.getAvaibleResources();
        ArrayList<Resource> availableR = new ArrayList<Resource>();
        
        for (Resource elem : temp){
            
            availableR.add(elem);
        }
        
        for (int i=0; i<3; i++){
            
            String message = "Choisissez une ressource parmi les suivantes :";
            for (Resource elem : availableR){
                System.out.println(elem);
            }
            
            String choice = term.playerChoice(message,availableR);
            switch(choice){
                case "DIAMOND":
                    resource = Resource.DIAMOND;
                    break;
                case "SAPHIRRE":
                    resource = Resource.SAPPHIRE; 
                    break;
                case "EMERALD":
                    resource = Resource.EMERALD;
                    break;
                case "ONYX":
                    resource = Resource.ONYX; 
                    break;
                case "RUBY":
                    resource = Resource.RUBY; 
                    break;
                default:
                    break;
            }
            
            board.updateNbResource(resource, 1);
            board.setNbResource(resource, -1);
            player.updateNbResource(resource, 1);
            availableR.remove(resource);
            this.toString();
        }
        
    }
    
    public String toString() {
        String msg = "";
        return msg = "Le joueur à choisi de prendre 1 ressources de types" + resource;
    }
}
