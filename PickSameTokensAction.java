
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
    private Ressource ressource;
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
        System.out.println("Choisissez une ressource parmi les suivantes :" + board.getAvailableResources());
        String message = "Choisissez une ressource parmi les suivantes :";
        Ressource availableR[] = board.getAvailableResources();
        
        for (Ressource elem : availableR){
            
            System.out.println(elem);
        }
        
        String choice = term.playerChoice(message,availableR);
        Ressource ressource;
        
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
        
        board.updateNbResource(ressource, 2);
        board.setNbResource(ressource, -2);
        player.updateNbResource(ressource, 2);
        
    }
    
    public String toString(Ressource resource) {
        String msg = "";
        return msg = "Le joueur à choisi de prendre 2 ressources de types" + ressource;
    }
}
