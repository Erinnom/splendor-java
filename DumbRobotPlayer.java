/**
 * Décrivez votre classe DumbRobotPlayer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.Random;
public class DumbRobotPlayer extends Player {

    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int action;
    private int tour;

    /**
     * Constructeur d'objets de classe DumbRobotPlayer
     */
    public DumbRobotPlayer(int id, String name) {
        // initialisation des variables d'instance
        super(id, name);
        action = 0;
        tour = 0;
    }

    public Action chooseAction(Player player, Board board) {
        Random r = new Random();
        int n = r.nextInt(4);
        Resource[] res = new Resource[5];
        res[0] = Resource.DIAMOND;
        res[1] = Resource.SAPPHIRE;
        res[2] = Resource.EMERALD;
        res[3] = Resource.RUBY;
        res[4] = Resource.ONYX;
        
        
        if(tour == 0){
            BuyCardAction buy = new BuyCardAction(board.getCard(1,1));
            tour += 1;
            return buy;
        }
        if(tour == 1){
            
            PickSameTokensAction pick = new PickSameTokensAction(res[r.nextInt(4)]);
            tour += 1;
            return pick;           
        }
        if(tour == 2){
            PickDiffTokensAction pick = new PickDiffTokensAction(res[r.nextInt(4)],res[r.nextInt(4)],res[r.nextInt(4)]);
            tour += 1;
            return pick;
        }
        else{
            tour = 0;
            return null;
        }       
    }

    public Action chooseDiscardingTokens() {
        if(super.getNbTokens() > 10){
            Random r = new Random();
            int n;
            while(super.getNbTokens() > 10){           
                n = r.nextInt(4);                               
                if(n == 0){
                    if(super.getNbResource(Resource.DIAMOND) > 0){
                        super.updateNbResource(Resource.DIAMOND, -1);
                    }
                }
                if(n == 1){
                    if(super.getNbResource(Resource.SAPPHIRE) > 0){
                        super.updateNbResource(Resource.SAPPHIRE, -1);
                    }
                }
                if(n == 2){
                    if(super.getNbResource(Resource.EMERALD) > 0){
                        super.updateNbResource(Resource.EMERALD, -1);
                    }
                }
                if(n == 3){
                    if(super.getNbResource(Resource.RUBY) > 0){
                        super.updateNbResource(Resource.RUBY, -1);
                    }
                }
                if(n == 4){
                    if(super.getNbResource(Resource.ONYX) > 0){
                        super.updateNbResource(Resource.ONYX, -1);
                    }
                }
            }
        }
        return null;
    }

    public void process(Player player, Board board) {
        int n;
    }

    public String toString() {
        return super.toString();
    }

}