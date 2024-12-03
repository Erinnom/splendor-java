public class Ressources
{
    // Attributs
    
    private int[] ressources;
    
    
    // Constructeur
    public Ressources(int countDIAMOND,int countSAPPHIRE, int countEMERALD, int countRUBY,int countONYX){
        ressources = new int[5];
        ressources[0] = countDIAMOND;
        ressources[1] = countSAPPHIRE;
        ressources[2] = countEMERALD;
        ressources[3] = countRUBY;
        ressources[4] = countONYX;
    }
    
    // Méthodes
    
    public int NbRessource(Ressource ressource){
        switch (ressource){
            case DIAMOND:
                return ressources[0];
            case SAPPHIRE:
                return ressources[1];
            case EMERALD:
                return ressources[2];
            case ONYX:
                return ressources[3];
            case RUBY:
                return ressources[4];
        }
        return 0;
    }
    
    // Méthodes
    
    public void setRessource(Ressource ressource,int r){
        if (r >= 0){
            switch (ressource){
                case DIAMOND:
                    ressources[0] = r;
                    break;
                case SAPPHIRE:
                    ressources[1] = r;
                    break;
                case EMERALD:
                    ressources[2] = r;
                    break;
                case ONYX:
                    ressources[3] = r;
                    break;
                case RUBY:
                    ressources[4] = r;
                    break;
            }
        }
    }
    
    public void updateRessource(Ressource ressource,int r){
        switch (ressource){
            case DIAMOND:
                if (ressources[0] + r >= 0) {
                    ressources[0] += r;
                }
                break;
            case SAPPHIRE:
                if (ressources[1] + r >= 0) {
                    ressources[1] += r;
                }
                break;
            case EMERALD:
                if (ressources[2] + r >= 0) {
                    ressources[2] += r;
                }
                break;
            case ONYX:
                if (ressources[3] + r >= 0) {
                    ressources[3] += r;
                }
                break;
            case RUBY:
                if (ressources[4] + r >= 0) {
                    ressources[4] += r;
                }
                break;
        }
    }
    
    public Ressource[] getAvaibleRessources(){
        int count_avaible_ressources = 0;
        for (int i = 0;i<5;i++){
            if (ressources[i] > 0){
                count_avaible_ressources += 1;
            }
        }
        
        Ressource[] avaible_ressources = new Ressource[count_avaible_ressources];
        int indice = 0;
        for (int i = 0;i<5;i++){
            if (ressources[i] > 0){
                switch(i){
                    case 0:
                        avaible_ressources[indice] = Ressource.DIAMOND;
                        break;
                    case 1:
                        avaible_ressources[indice] = Ressource.SAPPHIRE;
                        break;
                    case 2:
                        avaible_ressources[indice] = Ressource.EMERALD;
                        break;
                    case 3:
                        avaible_ressources[indice] = Ressource.ONYX;
                        break;
                    case 4:
                        avaible_ressources[indice] = Ressource.RUBY;
                        break;
                }
                indice+=1;
            }
        }
        return avaible_ressources;
    }
    
}
