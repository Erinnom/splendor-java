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
        possible.add("1");
        possible.add("2");
        possible.add("3");
        possible.add("4");
        
        String msg;   
        String choice;
        Terminal term = new Terminal();
        
        msg ="Que voulez-vous faire pour ce tour : \n 1 : prendre 2 jetons de la même ressource \n 2 : prendre 3 jetons de ressources différentes \n 3 : acheter une carte de développement \n 4 : ne rien faire";
        choice = term.playerChoice(msg , possible);
        
        if(choice.equals("1")){
            PickSameTokensAction pick = new PickSameTokensAction(choixResource());
            return pick;
        }
        if(choice.equals("2")){
            PickDiffTokensAction pick = new PickDiffTokensAction(choixResource(),choixResource(),choixResource());
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
                        super.updateNbResource(Resource.DIAMOND, -1);
                    }
                }
                if(choice.equals("2")){
                    if(super.getNbResource(Resource.SAPPHIRE) > 0){
                        super.updateNbResource(Resource.SAPPHIRE, -1);
                    }
                }
                if(choice.equals("3")){
                    if(super.getNbResource(Resource.EMERALD) > 0){
                        super.updateNbResource(Resource.EMERALD, -1);
                    }
                }
                if(choice.equals("4")){
                    if(super.getNbResource(Resource.RUBY) > 0){
                        super.updateNbResource(Resource.RUBY, -1);
                    }
                }else{
                    if(super.getNbResource(Resource.ONYX) > 0){
                        super.updateNbResource(Resource.ONYX, -1);
                    }
                }
            }
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
