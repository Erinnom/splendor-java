/*
 * @author    Corentin Dufourg
 * @version     1.1
 * @since       1.0
 */

import java.util.ArrayList;
import java.util.List;

public class Game {

    /* L'affichage et la lecture d'entrée avec l'interface de jeu se fera entièrement via l'attribut display de la classe Game.
     * Celui-ci est rendu visible à toutes les autres classes par souci de simplicité.
     * L'intéraction avec la classe Display est très similaire à celle que vous auriez avec la classe System :
     *    - affichage de l'état du jeu (méthodes fournies): Game.display.outBoard.println("Nombre de joueurs: 2");
     *    - affichage de messages à l'utilisateur: Game.display.out.println("Bienvenue sur Splendor ! Quel est ton nom?");
     *    - demande d'entrée utilisateur: new Scanner(Game.display.in);
     */
    private static final int ROWS_BOARD = 36, ROWS_CONSOLE = 8, COLS = 82;
    public static final Display display = new Display(
        ROWS_BOARD,
        ROWS_CONSOLE,
        COLS
    );

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
        if (nbOfPlayers >= 2 && nbOfPlayers <= 4) {
            board = new Board(nbOfPlayers);
            players = new ArrayList<Player>();
            int id;
            String name;
            Terminal term = new Terminal();

            for (int i = 0; i < nbOfPlayers; i++) {
                if (i == 0) {
                    id = i;
                    name = term.readString();
                    HumanPlayer player = new HumanPlayer(id, name);
                    players.add(player);
                } else {
                    id = i;
                    name = "DumbRobot" + i;
                    DumbRobotPlayer robot = new DumbRobotPlayer(id, name);
                    players.add(robot);
                }
            }
        } else {
            throw new IllegalArgumentException("nombre de joueurs incorrect");
        }
    }

    public int getNbPlayers() {
        return players.size();
    }

    private void display(int currentPlayer) {
        String[] boardDisplay = board.toStringArray();
        String[] playerDisplay = Display.emptyStringArray(0, 0);
        for (int i = 0; i < players.size(); i++) {
            String[] pArr = players.get(i).toStringArray();
            if (i == currentPlayer) {
                pArr[0] = "\u27A4 " + pArr[0];
            }
            playerDisplay = Display.concatStringArray(
                playerDisplay,
                pArr,
                true
            );
            playerDisplay = Display.concatStringArray(
                playerDisplay,
                Display.emptyStringArray(1, COLS - 54, "\u2509"),
                true
            );
        }
        String[] mainDisplay = Display.concatStringArray(
            boardDisplay,
            playerDisplay,
            false
        );

        display.outBoard.clean();
        display.outBoard.println(String.join("\n", mainDisplay));
    }

    public void play() {
        int turn = 0;
        while (!isGameOver()) {
            this.move(players.get(turn));

            if (players.get(turn).getNbTokens() > 10) {
                this.discardToken(players.get(turn));
            }

            turn++;
        }
        this.gameOver();
    }

    private void move(Player player) {
        // c'est normal que ça ne marche pas 
        Action action = player.chooseAction(player,board);
        action.process(player, board);
    }

    private void discardToken(Player player) {
        Action discard =player.chooseDiscardingTokens();
        discard.process(player, board);
    }

    public boolean isGameOver() {
        for (Player player : players) {
            if (player.getPoints() > 15) {
                return true;
            }
        }
        return false;
    }

    private void gameOver() {
        boolean draw = false;
        int winner = 0;
        int winner2 = 0;
        for (int i = 0; i < this.getNbPlayers(); i++) {
            if (players.get(i).getPoints() > players.get(winner).getPoints()) {
                winner = i;
            } else if (
                players.get(i).getPoints() == players.get(winner).getPoints()
            ) {
                draw = true;
                winner2 = i;
            }
        }
        if (draw) {
            if (
                players.get(winner).getNbPurchasedCards() <
                players.get(winner2).getNbPurchasedCards()
            ) {
                winner = winner2;
            }
        }
        System.out.println(
            "félicitation à " +
            players.get(winner).getName() +
            " pour sa victoire écrasante sur ces adversaires"
        );
    }
}
