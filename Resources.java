
/**
 * The Resources class is used to manage a collection of resources, 
 * including DIAMOND, SAPPHIRE, EMERALD, RUBY, and ONYX. 
 * Each resource is represented as an integer count.
 * 
 * @author Erinnom
 */
public class Resources {

    // Attributes
    private int[] resources;

    /**
     * Constructs a Resources object with the specified counts for each resource.
     *
     * @param countDIAMOND the number of DIAMOND resources
     * @param countSAPPHIRE the number of SAPPHIRE resources
     * @param countEMERALD the number of EMERALD resources
     * @param countRUBY the number of RUBY resources
     * @param countONYX the number of ONYX resources
     */
    public Resources(int countDIAMOND, int countSAPPHIRE, int countEMERALD, int countRUBY, int countONYX) {
        resources = new int[5];
        resources[0] = countDIAMOND;
        resources[1] = countSAPPHIRE;
        resources[2] = countEMERALD;
        resources[3] = countRUBY;
        resources[4] = countONYX;
    }

    /**
     * Gets the count of the specified resource.
     *
     * @param resource the type of resource (DIAMOND, SAPPHIRE, EMERALD, RUBY, ONYX)
     * @return the count of the specified resource
     */
    public int getNbResource(Resource resource) {
        switch (resource) {
            case DIAMOND:
                return resources[0];
            case SAPPHIRE:
                return resources[1];
            case EMERALD:
                return resources[2];
            case RUBY:
                return resources[3];
            case ONYX:
                return resources[4];
        }
        return 0;
    }

    /**
     * Sets the count of the specified resource.
     *
     * @param resource the type of resource (DIAMOND, SAPPHIRE, EMERALD, RUBY, ONYX)
     * @param r the new count for the resource (must be non-negative)
     */
    public void setNbResource(Resource resource, int r) {
        if (r >= 0) {
            switch (resource) {
                case DIAMOND:
                    resources[0] = r;
                    break;
                case SAPPHIRE:
                    resources[1] = r;
                    break;
                case EMERALD:
                    resources[2] = r;
                    break;
                case RUBY:
                    resources[3] = r;
                    break;
                case ONYX:
                    resources[4] = r;
                    break;
            }
        }
    }

    /**
     * Updates the count of the specified resource by a given value.
     * The count cannot go below zero.
     *
     * @param resource the type of resource (DIAMOND, SAPPHIRE, EMERALD, RUBY, ONYX)
     * @param r the value to add (positive or negative) to the resource count
     */
    public void updateResource(Resource resource, int r) {
        switch (resource) {
            case DIAMOND:
                if (resources[0] + r >= 0) {
                    resources[0] += r;
                }
                break;
            case SAPPHIRE:
                if (resources[1] + r >= 0) {
                    resources[1] += r;
                }
                break;
            case EMERALD:
                if (resources[2] + r >= 0) {
                    resources[2] += r;
                }
                break;
            case RUBY:
                if (resources[3] + r >= 0) {
                    resources[3] += r;
                }
                break;
            case ONYX:
                if (resources[4] + r >= 0) {
                    resources[4] += r;
                }
                break;
        }
    }

    /**
     * Retrieves an array of available resources (those with a count greater than zero).
     *
     * @return an array of Resource types that are available
     */
    public Resource[] getAvaibleResources() {
        int count_avaible_resources = 0;
        for (int i = 0; i < 5; i++) {
            if (resources[i] > 0) {
                count_avaible_resources++;
            }
        }

        Resource[] avaible_resources = new Resource[count_avaible_resources];
        int indice = 0;
        for (int i = 0; i < 5; i++) {
            if (resources[i] > 0) {
                switch (i) {
                    case 0:
                        avaible_resources[indice] = Resource.DIAMOND;
                        break;
                    case 1:
                        avaible_resources[indice] = Resource.SAPPHIRE;
                        break;
                    case 2:
                        avaible_resources[indice] = Resource.EMERALD;
                        break;
                    case 3:
                        avaible_resources[indice] = Resource.ONYX;
                        break;
                    case 4:
                        avaible_resources[indice] = Resource.RUBY;
                        break;
                }
                indice+=1;
            }
        }
        return avaible_resources;
    }
}
