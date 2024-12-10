import java.util.ArrayList;

//public abstract class Player implements Displayable
public abstract class Player implements Displayable, Action {

    private int id;
    private String name;
    private int points;
    private ArrayList<DevCard> purchasedCards;
    //private ArrayList<Resource> resource;
    private Resources resources;

    //private DevCard devcard;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        points = 0;
        purchasedCards = new ArrayList<DevCard>();
        //resource = new ArrayList<>();
        //for(Resource res: Resource.values()){
        //    resource.add(res);
        //}
        Resources resources;
        //devcard = new DevCard(2,3,2,0,0,0,2,Resource.DIAMOND);
    }

    /* --- Stringers --- */

    public String[] toStringArray() {
        /** EXAMPLE. The number of resource tokens is shown in brackets (), and the number of cards purchased from that resource in square brackets [].
         * Player 1: Camille
         * ⓪pts
         *
         * ♥R (0) [0]
         * ●O (0) [0]
         * ♣E (0) [0]
         * ♠S (0) [0]
         * ♦D (0) [0]
         */
        String pointStr = " ";
        String[] strPlayer = new String[8];

        if (points > 0) {
            pointStr = new String(new int[] { getPoints() + 9311 }, 0, 1);
        } else {
            pointStr = "\u24EA";
        }

        strPlayer[0] = "Player " + (id + 1) + ": " + name;
        strPlayer[1] = pointStr + "pts";
        strPlayer[2] = "";

        for (Resource res : Resource.values()) { //-- parcourir l'ensemble des resources (res) en utilisant l'énumération Resource
            System.out.println(res);
            System.out.println(
                3 + (Resource.values().length - 1 - res.ordinal())
            );
            strPlayer[3 + (Resource.values().length - 1 - res.ordinal())] =
                res.toSymbol() +
                " (" +
                resources.getNbResource(res) +
                ") [" +
                getResFromCards(res) +
                "]";
        }

        return strPlayer;
    }

    //accesseurs
    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getNbTokens() {
        Resource[] resource = {
            Resource.DIAMOND,
            Resource.SAPPHIRE,
            Resource.EMERALD,
            Resource.RUBY,
            Resource.ONYX,
        };
        int nbTockens = 0;
        for (int i = 0; i < 5; i++) {
            nbTockens += resources.getNbResource(resource[i]);
        }
        return nbTockens;
    }

    public int getNbPurchasedCards() {
        return purchasedCards.size();
    }

    public int getNbResource(Resource res) {
        return resources.getNbResource(res);
    }

    public int[] getAvailableResources() {
        int[] res;
        res = new int[5];

        res[0] = getNbResource(Resource.DIAMOND);
        res[1] = getNbResource(Resource.SAPPHIRE);
        res[2] = getNbResource(Resource.EMERALD);
        res[3] = getNbResource(Resource.ONYX);
        res[4] = getNbResource(Resource.RUBY);

        return res;
    }

    public int getResFromCards(Resource res) {
        int total = 0;
        for (int i = 0; i < getNbPurchasedCards(); i++) {
            total += purchasedCards.get(i).getCost().getNbResource(res);
        }
        return total;
    }

    public void updateNbResource(Resource res, int v) {
        resources.updateNbResource(res, v);
    }

    public void updatePoints(int point) {
        points += point;
    }

    public void addPurchasedCard(DevCard dev) {
        purchasedCards.add(dev);
    }

    public boolean canBuyCard(DevCard dev) {
        if (
            getNbResource(Resource.DIAMOND) <
            dev.getCost().getNbResource(Resource.DIAMOND)
        ) {
            return false;
        }
        if (
            getNbResource(Resource.SAPPHIRE) <
            dev.getCost().getNbResource(Resource.SAPPHIRE)
        ) {
            return false;
        }
        if (
            getNbResource(Resource.EMERALD) <
            dev.getCost().getNbResource(Resource.EMERALD)
        ) {
            return false;
        }
        if (
            getNbResource(Resource.ONYX) <
            dev.getCost().getNbResource(Resource.ONYX)
        ) {
            return false;
        }
        if (
            getNbResource(Resource.RUBY) <
            dev.getCost().getNbResource(Resource.RUBY)
        ) {
            return false;
        }
        return true;
    }

    public abstract Action chooseAction(Player player, Board board);

    public abstract Action chooseDiscardingTokens();
}
