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
    
    public Board(int nbJoueurs) throws FileNotFoundException {
        resources = new Resources(5,4,3,2,1);
        visibleCards = new DevCard[3][4];
        String nom_fichier = "stats.csv";
        stackCards = new ArrayList<Stack<DevCard>>();
        Stack<DevCard> tier1 = new Stack<DevCard>();
        Stack<DevCard> tier2 = new Stack<DevCard>();
        Stack<DevCard> tier3 = new Stack<DevCard>();
        visibleCards = new DevCard[3][4];
        boolean notFirstLine = false;
        try (Scanner scanner = new Scanner(new File(nom_fichier))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (notFirstLine){
                    int tier = Integer.parseInt(line.substring(0,1));
                    int coutDIAMOND = Integer.parseInt(line.substring(2,3));
                    int coutSAPPHIRE = Integer.parseInt(line.substring(4,5));
                    int coutEMERALD = Integer.parseInt(line.substring(6,7));
                    int coutRUBY = Integer.parseInt(line.substring(8,9));
                    int coutONYX = Integer.parseInt(line.substring(10,11));
                    int points = Integer.parseInt(line.substring(12,13));
                    String t = line.substring(14);
                    if (!t.equals("NOBLE")){
                        Resource type = Resource.valueOf(t);
                        //Créer la carte
                        DevCard newCard = new DevCard(tier, coutDIAMOND, coutSAPPHIRE, coutEMERALD, coutRUBY, coutONYX, points, type);
                        //Ensuite, ajouter au tas de carte associé.
                        if (tier == 1){
                            tier1.push(newCard);
                        }
                        else if(tier == 2){
                            tier2.push(newCard);
                        }
                        else if(tier == 3){
                            tier3.push(newCard);
                        }
                    }
                }
                else{
                    notFirstLine = true;
                }
            }
        }
        
        //Mettre les tas de cartes dans stacksCards
        Collections.shuffle(tier1);
        Collections.shuffle(tier2);
        Collections.shuffle(tier3);
        stackCards.add(tier1);
        stackCards.add(tier2);
        stackCards.add(tier3);
        //Rendre visible les 4 premières carte de chaque tas
        for(int i=0; i<stackCards.size();i++){
            for(int j=0; j<4;j++){
                visibleCards[i][j] = (stackCards.get(i).pop());
            }
        }
        //Initialisation des ressources
        int nbRes;
        if(nbJoueurs == 2){
            nbRes = 4;
        }else if(nbJoueurs == 3){
            nbRes = 5;
        }else{
            nbRes = 7;
        }
        resources = new Resources(nbRes,nbRes,nbRes,nbRes,nbRes);
    }
    
    // Méthodes
    /**
     * Get the amount of a resource
     * @param Resource resource
     * @return int number of resource
     */
    public int getNbResource(Resource resource){
        return resources.getNbResource(resource);
    }
    
    /**
     * set a  specific the amount of a resource
     * @param Resource resource
     * @return void
     */
    public void setNbResource(Resource resource, int r){
        resources.setNbResource(resource,r);
    }
    
    /**
     * Add or remove a specific amount of resource
     * @param Resource resource
     * @return void
     */
    public void updateNbResource(Resource resource, int r){
        resources.updateNbResource(resource,r);
    }
    
    
    /**
     * Get the list of avaible resources types 
     * @return list of resources
     */
    public Resource[] getAvaibleResources(){
        return resources.getAvaibleResources();
    }
    
    /**
     * Get a visible card
     * @param int tier & int colone
     * @return DevCard
     */
    public DevCard getCard(int tier,int colone){
        //return visibleCards[3-(tier)][colone-1];
        return visibleCards[tier-1][colone-1];
    }
    
    /**
     * Replace a DevCard by another
     * @param DevCard card
     * @return void
     */
    public void updateCard(DevCard card){
        int tier_card = card.getTier();
        int i = 0;
        while (i < 4 && visibleCards[tier_card-1][i] != card){
            i++;
        }
        if (visibleCards[tier_card-1][i] == card) {
            if(stackCards.get(tier_card-1).size() !=0){
                visibleCards[tier_card-1][i] = stackCards.get(tier_card-1).pop();
            }
            else{
                visibleCards[tier_card-1][i] = null;                
            }
        }
    }
    
    /**
     * Get a card from a stack following the tier categorie
     * @param int tier
     * @return DevCard
     */
    public DevCard drawCard(int tier){
        return  stackCards.get(tier).pop();
    }
    
    /**
     * Check if a player can take two identical resources
     * @param Resource resource
     * @return boolean
     */
    public boolean canGiveSameTokens(Resource resource){
        if (resources.getNbResource(resource) <= 4){
            return false;
        } 
        return true;
    }
    
    /**
     * Check if a player can take three differents resources
     * @param list of resources
     * @return boolean
     */
    public boolean canGiveDiffTokens(Resource[] resources){
        for (int i = 0; i < resources.length; i++){
            if (this.resources.getNbResource(resources[i]) >= 1){
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

        int nbCards = stackCards.get(tier-1).size(); //- AREMPLEACER par le nombre de cartes présentes
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

        for(Resource res : Resource.values()){
            resStr[0] += resources.getNbResource(res)+res.toSymbol()+" ";
        }
        resStr[0] += "        ";
        return resStr;
    }

    private String[] boardToStringArray(){
        String[] res = Display.emptyStringArray(0, 0);
        //Deck display
        String[] deckDisplay = Display.emptyStringArray(0, 0);
        for(int i=1;i<stackCards.size()+1;i++){
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

