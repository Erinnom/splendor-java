
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
        //System.out.println("Choisissez une ressource parmi les suivantes :" + board.getAvailableResources());
        int choix = term.readInt();
        Ressource ressource;
        switch(choix){
            case 0:
                ressource = Ressource.DIAMOND; 
            case 1:
                ressource = Ressource.SAPPHIRE; 
            case 2:
                ressource = Ressource.EMERALD; 
            case 3:
                ressource = Ressource.DIAMOND; 
            case 4:
                ressource = Ressource.DIAMOND; 
            default:
                break;
        }
        //board.updateNbResource(ressource, 2);
        //board.setNbResource(ressource, -2);
        //player.updateNbResource(ressource, 2);
        
    }
    
    public String toString(Ressource resource) {
        String msg = "";
        return msg = "Le joueur à choisi de prendre 2 ressources de types" + ressource;
    }
}
