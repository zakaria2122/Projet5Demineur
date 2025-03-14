import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Plateau{

    private int nbLignes;
    private int nbColonnes;
    private int pourcentageDeBombes;
    private int nbBombes;
    private List<Case> lePlateau;

    public Plateau(int nbLignes, int nbColonnes, int pourcentageDeBombes, int nbBombes){
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.pourcentageDeBombes = pourcentageDeBombes;
        this.nbBombes = nbBombes;
        this.lePlateau = new ArrayList<Case>();
    }

    private void creerLesCasesVides(){
        for (int i = 0; i < this.nbLignes*this.nbColonnes; i++){
            this.lePlateau.add(new Case());
        }
    }

    private void rendLesCasesIntelligentes(){
        for (int i = 0; i < nbLignes; i++){
            for (int j = 0; j < nbColonnes; j++){
                if(j == 0){
                    if(i == 0){
                        this.getCase(i, j).ajouterVoisine(this.getCase(i+1, j));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i, j+1));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i+1, j+1));
                    }
                    else if(i == nbLignes-1){
                        this.getCase(i, j).ajouterVoisine(this.getCase(i-1, j));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i, j+1));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i-1, j+1));
                    }
                    else{
                        this.getCase(i, j).ajouterVoisine(this.getCase(i-1, j));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i+1, j));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i, j+1));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i-1, j+1));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i+1, j+1));
                    }
                }
                else if(j == nbColonnes-1){
                    if(i == 0){
                        this.getCase(i, j).ajouterVoisine(this.getCase(i+1, j));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i, j-1));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i+1, j-1));
                    }
                    else if(i == nbLignes-1){
                        this.getCase(i, j).ajouterVoisine(this.getCase(i-1, j));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i, j-1));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i-1, j-1));
                    }
                    else{
                        this.getCase(i, j).ajouterVoisine(this.getCase(i-1, j));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i+1, j));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i, j-1));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i-1, j-1));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i+1, j-1));
                    }
                }
                else{
                    if(i == 0){
                        this.getCase(i, j).ajouterVoisine(this.getCase(i+1, j));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i, j-1));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i, j+1));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i+1, j-1));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i+1, j+1));
                    }
                    else if(i == nbLignes-1){
                        this.getCase(i, j).ajouterVoisine(this.getCase(i-1, j));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i, j-1));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i, j+1));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i-1, j-1));
                        this.getCase(i, j).ajouterVoisine(this.getCase(i-1, j+1));
                    }
                    else{

                    }
                }
            }
        }
    }

    protected void poseDesBombesAleatoirement(){
        Random generateur = new Random();
        for (int x = 0; x < this.getNbLignes(); x++){
            for (int y = 0; y < this.getNbColonnes(); y++){
                if (generateur.nextInt(100)+1 < this.pourcentageDeBombes){
                    this.poseBombe(x, y);
                    this.nbBombes = this.nbBombes + 1;
                }
            }
        }
    }

    public int getNbLignes() {
        return this.nbLignes;
    }

    public int getNbColonnes() {
        return this.nbColonnes;
    }

    public int getNbTotalBombes() {
        return this.nbBombes;
    }

    public Case getCase(int numLigne, int numColonne){
        return this.lePlateau.get(numLigne*this.nbColonnes+numColonne);
    }

    public int getNbCasesMarquees(){
        int nbCasesMarquees = 0;
        for (Case c : this.lePlateau){
            if (c.estMarquee()){
                nbCasesMarquees = nbCasesMarquees + 1;
            }
        }
        return nbCasesMarquees;
    }

    public void poseBombe(int x, int y){
        this.getCase(x, y).poseBombe();
    }

    public void reset(){
        this.lePlateau = new ArrayList<Case>();
    }

    public String toString(){
        return "Plateau a "+this.nbLignes+" lignes et "+this.nbColonnes+" colonnes";
    }
}

