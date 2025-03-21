import java.util.ArrayList;
import java.util.List;

public class Case {
    private boolean contientUneBombe;
    private boolean estDecouverte;
    private boolean estMarquee;
    private List<Case> lesVoisines;


    public Case() {
        this.contientUneBombe = false;
        this.estDecouverte = false;
        this.estMarquee = false;
        lesVoisines = new ArrayList<>();
    }

    public void reset() {
        this.contientUneBombe = false;
        this.estDecouverte = false;
        this.estMarquee = false;
    }

    public void poseBombe() {
        this.contientUneBombe = true;
    }

    public boolean contientUneBombe() {
     return  this.contientUneBombe;
      
    }

    public boolean estDecouverte() {
        return this.estDecouverte;
    }

    public boolean estMarquee() {
        return this.estMarquee;
    }

    public boolean reveler() {
        if (! this.estDecouverte && ! this.estMarquee){
           this.estDecouverte = true;
        }
        if (nombreBombeVoisine()== 0){
            for(Case voisine : lesVoisines){
                if (!voisine.estDecouverte()){
                    voisine.reveler();
                }
            }return true;
        } return false;
    }  

    public void marquer() {
        this.estMarquee = !this.estMarquee;
    }

    public void ajouterVoisine(Case voisine) {
            lesVoisines.add(voisine) ;    
        
    }
    public List<Case> getLesVoisines() {
        return lesVoisines;
    }

    public int nombreBombeVoisine(){

        int cpt = 0;
        for (Case voisine : lesVoisines) {
            if (voisine.contientUneBombe()) {
                cpt++;
            }
            
        } return cpt;
    
}


}