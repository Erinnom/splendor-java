/**
 * Décrivez votre classe DumbRobotPlayer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.Random;
import java.util.ArrayList;
public class DumbRobotPlayer extends Player {


    /**
     * Constructeur d'objets de classe DumbRobotPlayer
     */
    public DumbRobotPlayer(int id, String name) {
        // initialisation des variables d'instance
        super(id, name);
    }

    public Action chooseAction(Player player, Board board) {
        Random r = new Random();
        int n = r.nextInt(4);
        ArrayList<Resource> res = new ArrayList<Resource>();
        res.add(Resource.DIAMOND);
        res.add(Resource.SAPPHIRE);
        res.add(Resource.EMERALD);
        res.add(Resource.RUBY);
        res.add(Resource.ONYX);
        
        int maxCard = board.getCard(1,1).getPoints();
        int maxI = 1;
        int maxJ = 1;
        for(int i = 1 ; i < 4 ; i++){
            for(int j = 1 ; j < 5 ; j++){ 
                if((board.getCard(i,j).getPoints() > maxCard)&&(super.canBuyCard(board.getCard(i,j)))){
                   maxI = i;
                   maxJ = j;           
                }                   
            }
        }
        if(super.canBuyCard(board.getCard(maxI,maxJ))){
                BuyCardAction buy = new BuyCardAction(board.getCard(maxI,maxJ));
                return buy;
        }else{
            int cpt = 0;
            int cpt1 = 0;
            for (Resource elem : board.getAvaibleResources()){
                if (board.getNbResource(elem) < 4){
                    cpt++;
                }
                if (board.getNbResource(elem) <= 0){
                    cpt1++;
                    res.remove(elem);
                }
            }
            if (cpt != 5){
            Resource res0 = res.get(r.nextInt(4));
            if (board.getNbResource(res0) < 4){
                while (board.getNbResource(res0) <4){
                res0 = res.get(r.nextInt(4));
                }
            }
            PickSameTokensAction pick = new PickSameTokensAction(res0);
            return pick;            
            
            }else if(cpt1<=2) {
                Resource res1 = res.get(r.nextInt(4));
                res.remove(res1);
                Resource res2 = res.get(r.nextInt(3));
                res.remove(res2);
                Resource res3 = res.get(r.nextInt(2));
                res.remove(res3);
                PickDiffTokensAction pick = new PickDiffTokensAction(res1, res2, res3);
                return pick; 
            } else {
            Action pass = new PassAction();
            return pass;
            }
        }
    }
    public Action chooseDiscardingTokens() {
        if(super.getNbTokens() > 10){
            ArrayList<Resource> discard = new ArrayList<Resource>();
            Random r = new Random();
            int n;
            while(super.getNbTokens() > 10){           
                n = r.nextInt(4);                               
                if(n == 0){
                    if(super.getNbResource(Resource.DIAMOND) > 0){
                        discard.add(Resource.DIAMOND);
                    }
                }
                if(n == 1){
                    if(super.getNbResource(Resource.SAPPHIRE) > 0){
                        discard.add(Resource.SAPPHIRE);
                    }
                }
                if(n == 2){
                    if(super.getNbResource(Resource.EMERALD) > 0){
                        discard.add(Resource.EMERALD);
                    }
                }
                if(n == 3){
                    if(super.getNbResource(Resource.RUBY) > 0){
                        discard.add(Resource.RUBY);
                    }
                }
                if(n == 4){
                    if(super.getNbResource(Resource.ONYX) > 0){
                        discard.add(Resource.ONYX);
                    }
                }
            }
            return new DiscardTokensAction(discard);
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