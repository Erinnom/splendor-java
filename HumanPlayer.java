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
        
        System.out.println("Resources disponibles : \n 1 : DIAMOND \n 2 : SAPPHYRE \n 3 : EMERALD \n 4 : ONYX \n 5 : RUBY");
        
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
            return Resource.ONYX;
        }else{
            return Resource.RUBY;
        }
        
        
    }

    public Action chooseAction(Player player,Board board){
        ArrayList<String> possible = new ArrayList<String>();
        possible.add("1");
        possible.add("2");
        possible.add("3");
        
        String msg;   
        String choice;
        Terminal term = new Terminal();
        
        msg ="Que voulez-vous faire pour ce tour : \n 1 : prendre 2 jetons de la même ressource \n 2 : prendre 3 jetons de ressources différentes \n 3 : acheter une carte de développement";
        choice = term.playerChoice(msg , possible);
        System.out.println(choice);
        if(choice.equals("1")){
            PickSameTokensAction pick = new PickSameTokensAction(choixResource());
            return pick;
        }
        if(choice.equals("2")){
            PickDiffTokensAction pick = new PickDiffTokensAction(choixResource(),choixResource(),choixResource());
            return pick;
        }
        if(choice.equals("3")){
            
        }
        return null;
    }
    public Action chooseDiscardingTokens(){
       return null; 
    }
    public void process(Player player, Board board){
        int n;
    }
    public String toString(){
        return "";
    }
}
