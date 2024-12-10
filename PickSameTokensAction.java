
/**
 * Décrivez votre classe PickSameTokensAction ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

public class PickSameTokensAction implements Action
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Resource resource;
    
    public PickSameTokensAction(Resource res)
    {
        // initialisation des variables d'instance
        resource = res;
    }

    public void process(Player player, Board board){
        
        board.updateNbResource(resource, -2);
        player.updateNbResource(resource, 2);
        this.toString();
        
    }
    
    public String toString() {
        String msg = "";
        return msg = "Le joueur à choisi de prendre 2 ressources de types" + resource;
    }
}
