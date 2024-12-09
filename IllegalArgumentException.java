
/**
 * Décrivez votre classe IllegalArgumentException ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class IllegalArgumentException extends Exception
{


    /**
     * Constructeur d'objets de classe IllegalArgumentException
     */
    public IllegalArgumentException()
    {
        super("Nombre entrez en paramètre invalide");
    }
    
    public IllegalArgumentException(String msg)
    {
        super(msg);
    }


}
