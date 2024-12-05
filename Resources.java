public class Resources
{
    // Attributs
    
    private int[] resources;
    
    
    // Constructeur
    public Resources(int countDIAMOND,int countSAPPHIRE, int countEMERALD, int countRUBY,int countONYX){
        resources = new int[5];
        resources[0] = countDIAMOND;
        resources[1] = countSAPPHIRE;
        resources[2] = countEMERALD;
        resources[3] = countRUBY;
        resources[4] = countONYX;
    }
    
    // Méthodes
    
    public int getNbResource(Resource resource){
        switch (resource){
            case DIAMOND:
                return resources[0];
            case SAPPHIRE:
                return resources[1];
            case EMERALD:
                return resources[2];
            case ONYX:
                return resources[3];
            case RUBY:
                return resources[4];
        }
        return 0;
    }
    
    // Méthodes
    
    public void setResource(Resource resource,int r){
        if (r >= 0){
            switch (resource){
                case DIAMOND:
                    resources[0] = r;
                    break;
                case SAPPHIRE:
                    resources[1] = r;
                    break;
                case EMERALD:
                    resources[2] = r;
                    break;
                case ONYX:
                    resources[3] = r;
                    break;
                case RUBY:
                    resources[4] = r;
                    break;
            }
        }
    }
    
    public void updateResource(Resource resource,int r){
        switch (resource){
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
            case ONYX:
                if (resources[3] + r >= 0) {
                    resources[3] += r;
                }
                break;
            case RUBY:
                if (resources[4] + r >= 0) {
                    resources[4] += r;
                }
                break;
        }
    }
    
    public Resource[] getAvaibleResources(){
        int count_avaible_resources = 0;
        for (int i = 0;i<5;i++){
            if (resources[i] > 0){
                count_avaible_resources += 1;
            }
        }
        
        Resource[] avaible_resources = new Resource[count_avaible_resources];
        int indice = 0;
        for (int i = 0;i<5;i++){
            if (resources[i] > 0){
                switch(i){
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
