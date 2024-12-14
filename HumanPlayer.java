import java.util.ArrayList;
import java.util.Scanner;
/**
 * Décrivez votre classe HumanPlayer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class HumanPlayer extends Player
{
    private Scanner scan = new Scanner(Game.display.in);
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

        Game.display.out.println("Resources disponibles : \n 1 : DIAMOND \n 2 : SAPPHYRE \n 3 : EMERALD \n 4 : RUBY \n 5 : ONYX");

        msg ="Choix de la resource :";

        choice = playerChoice(msg , possible);

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

        msg ="Que voulez-vous faire pour ce tour : \n 1 : prendre 2 jetons de la même ressource \n 2 : prendre 3 jetons de ressources différentes \n 3 : acheter une carte de développement \n 4 : ne rien faire \n";
        while (true){
            choice = playerChoice(msg , possible);
            if (choice.equals("1")){
                for (Resource elem : res){
                    if (board.getNbResource(elem) < 4){
                        cpt++;
                    }
                }
                if ( cpt == 4){
                    Game.display.out.println(" Il ne reste plus assez de jetons, veuillez choisir une autre option entre la 2, la 3 ou la 4\n");
                    possible.remove("1");
                    choice = "";
                }               
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
                        Game.display.out.println("Il n'y a plus assez de cette ressource, veuillez en choisir une autre");
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
                        Game.display.out.println("Vous avez déjà sélectionné cette ressource, veuillez en choisir une autre");
                    }else {
                        break;
                    }
                }
                while (true){
                    res3 = choixResource();
                    if (res1.equals(res3) || res2.equals(res3)){
                        Game.display.out.println("Vous avez déjà sélectionné cette ressource, veuillez en choisir une autre");
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
                DevCard card;
                while(true){
                    msg2 ="Choisir une carte : \n tier :";
                    choice2 = playerChoice(msg2 , possible2);

                    msg3 ="colone :";
                    choice3 = playerChoice(msg3 , possible2);
                    Game.display.out.println(choice2 + "  " + choice3);

                    card = board.getCard(Integer.parseInt(choice2),Integer.parseInt(choice3));
                    if (player.canBuyCard(card)) {
                        BuyCardAction buy = new BuyCardAction(card);
                        return buy;
                    } else {
                        Game.display.out.println("Vous n'avez pas les ressources suffisantes pour acheter la carte suivante : " + card + "\nVeuillez effectuer une autre action");
                        break;
                    }

                }
                

            }
            if(choice.equals("4")){
                Action pass = new PassAction();
                return pass;
            }
        }       
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

            int nbDiamond = super.getNbResource(Resource.DIAMOND);
            int nbSapphire = super.getNbResource(Resource.SAPPHIRE);
            int nbEmerald = super.getNbResource(Resource.EMERALD);
            int nbRuby = super.getNbResource(Resource.RUBY);
            int nbOnyx = super.getNbResource(Resource.ONYX);

            String msg;   
            String choice;
            int nbTokentrop;
            nbTokentrop = super.getNbTokens() - 10;

            while(nbTokentrop > 0){

                msg = "Vous avez "+ nbTokentrop + " resource en trop. \nResources disponibles : \n 1 : DIAMOND \n 2 : SAPPHYRE \n 3 : EMERALD \n 4 : RUBY \n 5 : ONYX";
                choice = playerChoice(msg , possible);
                if(choice.equals("1")){
                    Game.display.out.println("diamond "+super.getNbResource(Resource.DIAMOND));
                    if(nbDiamond > 0){
                        discard.add(Resource.DIAMOND);
                        nbTokentrop--;
                    }
                }
                if(choice.equals("2")){
                    Game.display.out.println("sapphire "+super.getNbResource(Resource.SAPPHIRE));
                    if(nbSapphire > 0){
                        discard.add(Resource.SAPPHIRE);
                        nbTokentrop--;
                    }
                }
                if(choice.equals("3")){
                    Game.display.out.println("emerald "+super.getNbResource(Resource.EMERALD));
                    if(nbEmerald > 0){
                        discard.add(Resource.EMERALD);
                        nbTokentrop--;
                    }
                }
                if(choice.equals("4")){
                    Game.display.out.println("ruby "+super.getNbResource(Resource.RUBY));
                    if(nbRuby > 0){
                        discard.add(Resource.RUBY);
                        nbTokentrop--;
                    }
                }else{
                    Game.display.out.println("onyx "+super.getNbResource(Resource.ONYX));
                    if(nbOnyx > 0){
                        discard.add(Resource.ONYX);
                        nbTokentrop--;
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

    public String playerChoice(String message, ArrayList expectedResult){
        Game.display.out.println(message);
        String choice = scan.next();
        while (true){
            if ( expectedResult.contains(choice) == false ){
                Game.display.out.println("Erreur de saisie, veuillez réessayer");
                choice = scan.next();
            } else {
                break;
            }
        }
        return choice;
    }
}
