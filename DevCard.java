public class DevCard implements Displayable {
    // Attributs
    
    int tier;
    Resources coutResources;
    int points;
    Resource resourceType;
    
    // Constructeur
    
    public DevCard(int tier,int countDIAMOND,int countSAPPHIRE, int countEMERALD, int countRUBY,int countONYX, int points, Resource type)
    {
        this.tier = tier;
        this.points = points;
        this.resourceType = type;
        
        coutResources = new Resources(countDIAMOND,countSAPPHIRE, countEMERALD, countRUBY,countONYX);
        
        
    }
    
    // Méthodes
    
    public int getPoints() {
        return points;
    }
    
    public String[] toStringArray(){
        /** EXAMPLE
         * ┌────────┐
         * │①    ♠S│
         * │        │
         * │        │
         * │2 ♠S    │
         * │2 ♣E    │
         * │3 ♥R    │
         * └────────┘
         */
        String pointStr = "  ";
        //String[] cardStr = {}; //-- ASUPPRIMER
        /*
         * Ce code est à décommenter une fois que la classe DevCard a été implémentée*/
        if(getPoints()>0){
            pointStr = new String(new int[] {getPoints()+9311}, 0, 1);
        }
        String[] cardStr = {"\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510",
                            "\u2502"+pointStr+"    "+resourceType.toSymbol()+"\u2502",
                            "\u2502        \u2502",
                            "\u2502        \u2502",
                            "\u2502        \u2502",
                            "\u2502        \u2502",
                            "\u2502        \u2502",
                            "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518"};
        //update cost of the repr
        int i=6;
        Resource[] resources = {Resource.DIAMOND,Resource.SAPPHIRE,Resource.EMERALD,Resource.ONYX,Resource.RUBY};
        for(Resource res:resources){ //-- parcourir l'ensemble des resources (res)en utilisant l'énumération Resource
            if(getCost().getNbResource(res)>0){
                cardStr[i] = "\u2502"+getCost().getNbResource(res)+" "+res.toSymbol()+"    \u2502";
                i--;
            }
        }
        return cardStr;
    }
    
    public Resources getCost() {
        return coutResources;
    }

    public static String[] noCardStringArray(){
        /** EXAMPLE
         * ┌────────┐
         * │ \    / │
         * │  \  /  │
         * │   \/   │
         * │   /\   │
         * │  /  \  │
         * │ /    \ │
         * └────────┘
         */
        String[] cardStr = {"\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510",
                            "\u2502 \\    / \u2502",
                            "\u2502  \\  /  \u2502",
                            "\u2502   \\/   \u2502",
                            "\u2502   /\\   \u2502",
                            "\u2502  /  \\  \u2502",
                            "\u2502 /    \\ \u2502",
                            "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518"};
        
        return cardStr;
    }

    public String toString(){
        String cardStr = "";
        /*
         * Ce code est à décommenter une fois que la classe DevCard a été implémentée
              
        cardStr = getPoints()+"pts, type "+resourceType.toSymbol()+" | coût: ";
        for(ACOMPLETER){ //-- parcourir l'ensemble des resources (res) en utilisant l'énumération Resource
            if(getCost().getNbResource(res)>0){
                cardStr += getCost().getNbResource(res)+res.toSymbol()+" ";
            }
        }
        */
        return cardStr;
    }
}