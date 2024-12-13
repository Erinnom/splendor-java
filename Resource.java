/**
 * Enumeration of resources representing different types of gemstones:
 * DIAMOND, SAPPHIRE, EMERALD, ONYX, and RUBY.
 * Each resource has a textual representation and a symbolic representation.
 * 
 * @author Erinnom
 */
public enum Resource {
    DIAMOND,
    SAPPHIRE,
    EMERALD,
    ONYX,
    RUBY;

    /**
     * Provides a human-readable string representation of the resource, 
     * including its name and a corresponding Unicode symbol.
     *
     * @return a string representation of the resource
     */
    public String toString() {
        switch (this) {
            case EMERALD:
                return "EMERAUDE \u2663"; // EMERAUDE ♣
            case DIAMOND:
                return "DIAMANT \u2666"; // DIAMANT ♦
            case SAPPHIRE:
                return "SAPHIR \u2660"; // SAPHIR ♠
            case ONYX:
                return "ONYX \u25CF"; // ONYX ●
            case RUBY:
                return "RUBIS \u2665"; // RUBIS ♥
            default:
                return "";
        }
    }

    /**
     * Provides a symbolic representation of the resource,
     * combining a Unicode character and a single-letter abbreviation.
     *
     * @return a string representing the symbol of the resource
     */
    public String toSymbol() {
        switch (this) {
            case EMERALD:
                return "\u2663E"; // ♣E
            case DIAMOND:
                return "\u2666D"; // ♦D
            case SAPPHIRE:
                return "\u2660S"; // ♠S
            case ONYX:
                return "\u25CFO"; // ●O
            case RUBY:
                return "\u2665R"; // ♥R
            default:
                return "";
        }
    }
}
