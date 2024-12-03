import java.util.ArrayList;
//public abstract class Player implements Displayable
public abstract class Player implements Displayable {

    /* --- Stringers --- */
   
     
    public String[] toStringArray(){
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
         /*
            * A decommenter une fois la classe implémentée
        if(points>0){
            pointStr = new String(new int[] {getPoints()+9311}, 0, 1);
        }else{
            pointStr = "\u24EA";
        }

        
        strPlayer[0] = "Player "+(id+1)+": "+name;
        strPlayer[1] = pointStr + "pts";
        strPlayer[2] = "";
        for(ACOMPLETER){ //-- parcourir l'ensemble des resources (res) en utilisant l'énumération Resource
            strPlayer[3+(Resource.values().length-1-res.ordinal())] = res.toSymbol() + " ("+resources.getNbResource(res)+") ["+getResFromCards(res)+"]";
        }
        */
        return strPlayer;
    }
    private int id;
    private String name;
    private int points;
    private ArrayList purchasedCards;
    private ArrayList<Resource> resource;
    private Resource resources;

    public Player(String name){
        id = 0;
        this.name = name;
        points = 0;
        purchasedCards = new ArrayList<>();
        resource = new ArrayList<>();
        
    }
    
    //accesseurs
    public String getName(){
        return name;
    }
    public int getPoints(){
        return points;
    }
    public int getNbTokens(){
        return resource.size();
    }
    public int getNbPurchasedCards(){
        return purchasedCards.size();
    }
    
    public void updatePoints(int point){
        points += point;
    }
    
    public abstract void chooseAction();
    public abstract void chooseDiscardingTokens();
    }
