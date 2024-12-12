import java.util.ArrayList;
/**
 * Décrivez votre classe HumanPlayer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class HumanPlayer extends Player
{
    /**
     * Constructeur d'objets de classe HumanPlayer
     */
    public HumanPlayer(int id,String name)
    {
        // initialisation des variables d'instance
        super(id,name);
    }
    public Resource choixResource(){
        ArrayList<String> possible = new ArrayList<String>();
        possible.add("1");
        possible.add("2");
        possible.add("3");
        possible.add("4");
        possible.add("5");
        
        String msg;   
        String choice;
        Terminal term = new Terminal();
        
        System.out.println("Resources disponibles : \n 1 : DIAMOND \n 2 : SAPPHYRE \n 3 : EMERALD \n 4 : RUBY \n 5 : ONYX");
        
        msg ="Choix de la resource :";
        
        choice = term.playerChoice(msg , possible);
        
        if(choice.equals("1")){
            return Resource.DIAMOND;
        }
        if(choice.equals("2")){
            return Resource.SAPPHIRE;
        }
        if(choice.equals("3")){
            return Resource.EMERALD;
        }
        if(choice.equals("4")){
            return Resource.RUBY;
        }else{
            return Resource.ONYX;
        }
        
        
    }

    public Action chooseAction(Player player,Board board){
        ArrayList<String> possible = new ArrayList<String>();
        Resource[] res = board.getAvaibleResources();
        int cpt = 0;
        boolean notEnough = false;
        possible.add("1");
        possible.add("2");
        possible.add("3");
        possible.add("4");
        
        String msg;   
        String choice;
        Terminal term = new Terminal();
        
        msg ="Que voulez-vous faire pour ce tour : \n 1 : prendre 2 jetons de la même ressource \n 2 : prendre 3 jetons de ressources différentes \n 3 : acheter une carte de développement \n 4 : ne rien faire \n";
        while (true){
        choice = term.playerChoice(msg , possible);
        if (choice.equals("1")){
            for (Resource elem : res){
                if (board.getNbResource(elem) < 4){
                    cpt++;
                    }
                }
            if ( cpt == 4){
                System.out.println(" Il ne reste plus assez de jetons, veuillez choisir une autre option entre la 2, la 3 ou la 4\n");
                }
            possible.remove("1");
            }
        break;
        }
        
        if(choice.equals("1")){
            Resource res0;
            while (true) {
            res0 = choixResource();
            switch(res0){
                case DIAMOND :
                    if (board.getNbResource(Resource.DIAMOND)<4){
                        notEnough = true;
                    }
                    break;
                case SAPPHIRE :
                    if (board.getNbResource(Resource.SAPPHIRE)<4){
                        notEnough = true;
                    }
                    break;
                case EMERALD :
                    if (board.getNbResource(Resource.EMERALD)<4){
                        notEnough = true;
                    }
                    break;
                case RUBY :
                    if (board.getNbResource(Resource.RUBY)<4){
                        notEnough = true;
                    }
                    break;
                case ONYX :
                    if (board.getNbResource(Resource.ONYX)<4){
                        notEnough = true;
                    }
                    break;
            }
            if (!notEnough){
                break;
            }else{
                System.out.println("Il n'y a plus assez de cette ressource, veuillez en choisir une autre");
                notEnough = false;
                }
            }
            PickSameTokensAction pick = new PickSameTokensAction(res0);
            return pick;
        }
        if(choice.equals("2")){
            Resource res1;
            Resource res2;
            Resource res3;
            res1 = choixResource();
            while (true) {
                res2 = choixResource();
                if (res1.equals(res2)){
                    System.out.println("Vous avez déjà sélectionné cette ressource, veuillez en choisir une autre");
                }else {
                    break;
                }
            }
            while (true){
                res3 = choixResource();
                if (res1.equals(res3) || res2.equals(res3)){
                    System.out.println("Vous avez déjà sélectionné cette ressource, veuillez en choisir une autre");
                }else {
                    break;
                }
            }
            PickDiffTokensAction pick = new PickDiffTokensAction(res1, res2, res3);
            return pick;
        }
        if(choice.equals("3")){
            ArrayList<String> possible2 = new ArrayList<String>();
            possible2.add("1");
            possible2.add("2");
            possible2.add("3");
            possible2.add("4");
            
            String msg2;  
            String msg3; 
            String choice2;
            String choice3;
            Terminal term2 = new Terminal();
            
            msg2 ="Choisir une carte : \n tier :";
            choice2 = term.playerChoice(msg2 , possible2);
            
            msg3 ="colone :";
            choice3 = term.playerChoice(msg3 , possible2);
            
            BuyCardAction buy = new BuyCardAction(board.getCard(Integer.parseInt(choice2),Integer.parseInt(choice3)));
            
            return buy;
            
        }
        return null;
    }
    public Action chooseDiscardingTokens(){
        
        if(super.getNbTokens() > 10){
            ArrayList<Resource> discard = new ArrayList<Resource>();
            ArrayList<String> possible = new ArrayList<String>();
            possible.add("1");
            possible.add("2");
            possible.add("3");
            possible.add("4");
            possible.add("5");
            
            String msg;   
            String choice;
            Terminal term = new Terminal();
            int nbTokentrop;
            
            
            while(super.getNbTokens() > 10){
                nbTokentrop = super.getNbTokens() - 10;
                msg = "Vous avez "+ nbTokentrop + " resource en trop. \nResources disponibles : \n 1 : DIAMOND \n 2 : SAPPHYRE \n 3 : EMERALD \n 4 : ONYX \n 5 : RUBY";
                choice = term.playerChoice(msg , possible);
                if(choice.equals("1")){
                    if(super.getNbResource(Resource.DIAMOND) > 0){
                        discard.add(Resource.DIAMOND);
                    }
                }
                if(choice.equals("2")){
                    if(super.getNbResource(Resource.SAPPHIRE) > 0){
                        discard.add(Resource.SAPPHIRE);
                    }
                }
                if(choice.equals("3")){
                    if(super.getNbResource(Resource.EMERALD) > 0){
                        discard.add(Resource.EMERALD);
                    }
                }
                if(choice.equals("4")){
                    if(super.getNbResource(Resource.RUBY) > 0){
                        discard.add(Resource.RUBY);
                    }
                }else{
                    if(super.getNbResource(Resource.ONYX) > 0){
                        discard.add(Resource.ONYX);
                    }
                }
            }
            return new DiscardTokensAction(discard); 
        }
        return null;
    }
    public void process(Player player, Board board){
        int n;
    }
    public String toString(){
        return super.toString();
    }
}
