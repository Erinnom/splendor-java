import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.Collections;

public class Board implements Displayable {
    
    // Attributs
    
    private ArrayList<Stack<DevCard>> stackCards;
    private DevCard[][] visibleCards;
    private Resources resources;
    
    // Constructeur
    
    public Board () {
        resources = new Resources(5,4,3,2,1);
        visibleCards = new DevCard[3][4];
    }
    
    // Méthodes
    
    public int getNbResource(Resource resource){
        return resources.getNbResource(resource);
    }
    
    public void setNbResource(Resource resource, int r){
        resources.setNbResource(resource,r);
    }
    
    public Resource[] getAvaibleResources(Resource resource, int r){
        return resources.getAvaibleResources();
    }
    
    public DevCard getCard(int tier,int colone){
        return visibleCards[tier][colone];
    }
    
    public void updateCard(int tier,int colone){
        if (stackCards.get(tier).isEmpty()){
            visibleCards[tier][colone] = null;
        }else{
            visibleCards[tier][colone] = stackCards.get(tier).pop();
        }
    }
    
    public DevCard drawCard(int tier){
        return  stackCards.get(tier).pop();
    }
    
    public boolean canGiveSameTokens(Resource resource){
        if (resources.getNbResource(resource) < 4){
            return false;
        } 
        return true;
    }
    
    public boolean canGiveDiffTokens(Resource[] resources){
        for (int i = 0; i < resources.length; i++){
            if (this.resources.getNbResource(resources[i]) >= 4){
                return true;
            }
        }
        return false;
    }
    
    /* --- Stringers --- */

    private String[] deckToStringArray(int tier){
        /** EXAMPLE
         * ┌────────┐
         * │        │╲ 
         * │ reste: │ │
         * │   16   │ │
         * │ cartes │ │
         * │ tier 3 │ │
         * │        │ │
         * └────────┘ │
         *  ╲________╲│
         */
        int nbCards = stackCards.get(tier).size(); //- AREMPLEACER par le nombre de cartes présentes
        String[] deckStr = {"\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510  ",
                            "\u2502        \u2502\u2572 ",
                            "\u2502 reste: \u2502 \u2502",
                            "\u2502   "+String.format("%02d", nbCards)+"   \u2502 \u2502",
                            "\u2502 carte"+(nbCards>1 ? "s" : " ")+" \u2502 \u2502",
                            "\u2502 tier "+tier+" \u2502 \u2502",
                            "\u2502        \u2502 \u2502",
                            "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518 \u2502",
                            " \u2572________\u2572\u2502"};
        return deckStr;
    }

    private String[] resourcesToStringArray(){
        /** EXAMPLE
         * Resources disponibles : 4♥R 4♣E 4♠S 4♦D 4●O
         */
        String[] resStr = {"Resources disponibles : "};
        
        for(Resource res:resources.getAvaibleResources()){ //-- parcourir l'ensemble des resources (res) en utilisant l'énumération Resource
            resStr[0] += resources.getNbResource(res)+res.toSymbol()+" ";
        }
        resStr[0] += "        ";
        return resStr;
    }

    private String[] boardToStringArray(){
        String[] res = Display.emptyStringArray(0, 0);
        //Deck display
        String[] deckDisplay = Display.emptyStringArray(0, 0);
        for(int i=stackCards.size();i>0;i--){
            deckDisplay = Display.concatStringArray(deckDisplay, deckToStringArray(i), true);
        }

        //Card display
        String[] cardDisplay = Display.emptyStringArray(0, 0);
        for(int i = 0;i<3;i++){ //-- parcourir les différents niveaux de carte (i)
            String[] tierCardsDisplay = Display.emptyStringArray(8, 0);
            for(int j = 0; j < 4;j++){ //-- parcourir les 4 cartes faces visibles pour un niveau donné (j)
                tierCardsDisplay = Display.concatStringArray(tierCardsDisplay, visibleCards[i][j]!=null ? visibleCards[i][j].toStringArray() : DevCard.noCardStringArray(), false);
            }
            cardDisplay = Display.concatStringArray(cardDisplay, Display.emptyStringArray(1, 40), true);
            cardDisplay = Display.concatStringArray(cardDisplay, tierCardsDisplay, true);
        }
        
        res = Display.concatStringArray(deckDisplay, cardDisplay, false);
        res = Display.concatStringArray(res, Display.emptyStringArray(1, 52), true);
        res = Display.concatStringArray(res, resourcesToStringArray(), true);
        res = Display.concatStringArray(res, Display.emptyStringArray(35, 1, " \u250A"), false);
        res = Display.concatStringArray(res, Display.emptyStringArray(1, 54, "\u2509"), true);
        return res;
    }
    
    
    @Override
    public String[] toStringArray() {
        return boardToStringArray();
    }
}
