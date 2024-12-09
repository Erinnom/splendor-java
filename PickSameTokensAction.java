
/**
 * Décrivez votre classe PickSameTokensAction ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */


public class PickSameTokensAction implements Action
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Player player;
    private Terminal term;
    private Board board;
    private Resource resource;
    /**
     * Constructeur d'objets de classe PickSameTokensAction
     */
    public PickSameTokensAction(Player player, Board board)
    {
        // initialisation des variables d'instance
        this.player = player;
        term = new Terminal();
        this.board = board;
    }

    public void process(){
        Resource availableR[] = board.getAvaibleResources();
        
        while (true){
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
            
            if (canGiveSameTokens(resource)){
                break;
            } else {
                System.out.println("Vous ne pouvez pas choisir cette ressource car il n'y en a pas assez");
            }
        }
        board.updateNbResource(resource, 2);
        board.setNbResource(resource, -2);
        player.updateNbResource(resource, 2);
        this.toString();
        
    }
    
    public String toString() {
        String msg = "";
        return msg = "Le joueur à choisi de prendre 2 ressources de types" + ressource;
    }
}
