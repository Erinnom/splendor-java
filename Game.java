/*
 * @author    Corentin Dufourg
 * @version     1.1
 * @since       1.0
 */

import java.util.List;
import java.util.ArrayList;

public class Game {
    /* L'affichage et la lecture d'entrée avec l'interface de jeu se fera entièrement via l'attribut display de la classe Game.
     * Celui-ci est rendu visible à toutes les autres classes par souci de simplicité.
     * L'intéraction avec la classe Display est très similaire à celle que vous auriez avec la classe System :
     *    - affichage de l'état du jeu (méthodes fournies): Game.display.outBoard.println("Nombre de joueurs: 2");
     *    - affichage de messages à l'utilisateur: Game.display.out.println("Bienvenue sur Splendor ! Quel est ton nom?");
     *    - demande d'entrée utilisateur: new Scanner(Game.display.in);
     */
    private static final int ROWS_BOARD=36, ROWS_CONSOLE=8, COLS=82;
    public static final  Display display = new Display(ROWS_BOARD, ROWS_CONSOLE, COLS);

    private Board board;
    private List<Player> players;

    public static void main(String[] args) {
        //-- à modifier pour permettre plusieurs scénarios de jeu
        display.outBoard.println("Bienvenue sur Splendor !");
        Game game = new Game(2);
        game.play();
        display.close();
    }

    public Game(int nbOfPlayers) throws IllegalArgumentException {
        if (nbOfPlayers >= 2 && nbOfPlayers <= 4 ) {
            
            board = new Board();
            players = new ArrayList<Player>();
            int id;
            String name;
            Terminal term = new Terminal();
            
            for (int i=0; i<nbOfPlayers; i++){
                
                if (i==0) {
                    
                    id = i;
                    name = term.readString();
                    HumanPlayer player = new HumanPlayer(id, name);
                    players.add(player);
                    
                }else{
                    
                    id = i;
                    name = "DumbRobot"+i;
                    DumbRobotPlayer robot = new DumbRobotPlayer(id, name);
                    players.add(robot);
                }
            
            }
        }
        else {
            throw new IllegalArgumentException("nombre de joueurs incorrect");
        }
    }

    public int getNbPlayers(){
        return players.size();
    }

    private void display(int currentPlayer){
        String[] boardDisplay = board.toStringArray();
        String[] playerDisplay = Display.emptyStringArray(0, 0);
        for(int i=0;i<players.size();i++){
            String[] pArr = players.get(i).toStringArray();
            if(i==currentPlayer){
                pArr[0] = "\u27A4 " + pArr[0];
            }
            playerDisplay = Display.concatStringArray(playerDisplay, pArr, true);
            playerDisplay = Display.concatStringArray(playerDisplay, Display.emptyStringArray(1, COLS-54, "\u2509"), true);
        }
        String[] mainDisplay = Display.concatStringArray(boardDisplay, playerDisplay, false);

        display.outBoard.clean();
        display.outBoard.println(String.join("\n", mainDisplay));
    }

    public void play(){
        int turn = 0;
        while ( !isGameOver()){
            
            this.move(players.get(turn));
            
            if (players.get(turn).getNbTokens() > 10){
                this.discardToken(players.get(turn));
                }
    
            turn ++;
            }
        this.gameOver();
        }


    private void move(Player player){
        ArrayList<String> possible = new ArrayList<String>();
        possible.add("1");
        possible.add("2");
        possible.add("3");
        
        String msg;   
        String choice;
        Terminal term = new Terminal();
        
        msg ="Que voulez-vous faire pour ce tour : \n 1 : prendre 2 jetons de la même ressource \n 2 : prendre 3 jetons de ressources différentes \n 3 : acheter une carte de développement";
        choice = term.playerChoice(msg , possible);
            
        switch(choice){
            
            case "1" :
                PickDiffTokensAction pickDiff = new PickDiffTokensAction(player, board);
                pickDiff.process();
                break;
                
            case "2" :
                PickSameTokensAction pickSame = new PickSameTokensAction(player,board);
                pickSame.process();
                break;
                
            case "3" :
                BuyCardAction buyCard = new BuyCardAction(board, player);
                buyCard.process();
                break;
        }
    }

    private void discardToken(Player player){
        DiscardTokensAction discard = new DiscardTokensAction(board, player);
        discard.process();
    }

    public boolean isGameOver(){
        for (Player player : players){
            
            if( player.getPoint() > 15){
                
                return true;
            }
        return false;
        }
    }

    private void gameOver(){
        boolean draw = false;
        int winner = 0;
        int winner2 = 0;
        for (int i = 0; i<this.getNbPlayers();i++){
            if (players.get(i).getPoint() > players.get(winner).getPoint()){
                winner = i;
            } else if (players.get(i).getPoint() == players.get(winner).getPoint()){
                draw = true;
                winner2 = i;
            }
        }
        if (draw){
            
            if (players.get(winner).getNbPurchasedCards() < players.get(winner2).getNbPurchasedCards()){
                winner = winner2;
            }
        }
        System.out.println("félicitation à " + players.get(winner.getName()) + " pour sa victoire écrasante sur ces adversaires");
    }


}
