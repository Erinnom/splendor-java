/**
 * Represents a Development Card (DevCard) in a game.
 * Each DevCard has a tier, resource cost, point value, and a resource type it generates.
 * It can be displayed in both text and symbolic formats.
 * 
 * Implements the `Displayable` interface for display purposes.
 * 
 * @author Erinnom
 */
public class DevCard implements Displayable {

    // Attributes
    int tier;
    Resources coutResources;
    int points;
    Resource resourceType;

    /**
     * Constructs a Development Card with the specified properties.
     *
     * @param tier the tier of the card
     * @param countDIAMOND the cost in DIAMOND resources
     * @param countSAPPHIRE the cost in SAPPHIRE resources
     * @param countEMERALD the cost in EMERALD resources
     * @param countRUBY the cost in RUBY resources
     * @param countONYX the cost in ONYX resources
     * @param points the number of points the card provides
     * @param type the type of resource this card generates
     */
    public DevCard(int tier, int countDIAMOND, int countSAPPHIRE, int countEMERALD, int countRUBY, int countONYX, int points, Resource type) {
        this.tier = tier;
        this.points = points;
        this.resourceType = type;
        this.coutResources = new Resources(countDIAMOND, countSAPPHIRE, countEMERALD, countRUBY, countONYX);
    }
    // Methodes
    
    public int getTier(){
        return tier;
    }
    
    public Resource getResourceType(){
        return resourceType;
    }
    /**
     * Gets the point value of the card.
     *
     * @return the number of points this card provides
     */
    public int getPoints() {
        return points;
    }

    /**
     * Converts the card to a symbolic array of strings for display purposes.
     * @return an array of strings representing the card
     */
    public String[] toStringArray() {
        String pointStr = "  ";
        if (getPoints() > 0) {
            pointStr = new String(new int[] {getPoints() + 9311}, 0, 1); // Unicode for circled numbers
        }
        String[] cardStr = {
            "\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510",
            "\u2502" + pointStr + "    " + resourceType.toSymbol() + "\u2502",
            "\u2502        \u2502",
            "\u2502        \u2502",
            "\u2502        \u2502",
            "\u2502        \u2502",
            "\u2502        \u2502",
            "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518"
        };

        // Update the cost representation
        int i = 6;
        Resource[] resources = {Resource.DIAMOND, Resource.SAPPHIRE, Resource.EMERALD, Resource.ONYX, Resource.RUBY};
        for (Resource res : resources) {
            if (getCost().getNbResource(res) > 0) {
                cardStr[i] = "\u2502" + getCost().getNbResource(res) + " " + res.toSymbol() + "    \u2502";
                i--;
            }
        }
        return cardStr;
    }

    /**
     * Gets the resource cost of the card.
     *
     * @return a Resources object representing the cost of the card
     */
    public Resources getCost() {
        return coutResources;
    }

    /**
     * Returns a symbolic representation of an empty card.
     * @return an array of strings representing an empty card
     */
    public static String[] noCardStringArray() {
        return new String[] {
            "\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510",
            "\u2502 \\    / \u2502",
            "\u2502  \\  /  \u2502",
            "\u2502   \\/   \u2502",
            "\u2502   /\\   \u2502",
            "\u2502  /  \\  \u2502",
            "\u2502 /    \\ \u2502",
            "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518"
        };
    }

    /**
     * Converts the card to a descriptive string format.
     * @return a string representation of the card
     */
    public String toString() {
        String cardStr = getPoints() + "pts, type " + resourceType.toSymbol() + " | coût: ";
        Resource[] resources = {Resource.DIAMOND, Resource.SAPPHIRE, Resource.EMERALD, Resource.ONYX, Resource.RUBY};
        for (Resource res : resources) {
            if (getCost().getNbResource(res) > 0) {
                cardStr += getCost().getNbResource(res) + res.toSymbol() + " ";
            }
        }
        return cardStr.trim();
    }
}
