package ex1;

public class NombreNegatifException extends Exception {
    private int valeurErronee;

    public NombreNegatifException(int valeurErronee) {
        super("Erreur : La valeur " + valeurErronee + " est négative. Un Entier Naturel doit être >= 0.");
        this.valeurErronee = valeurErronee;
    }

    public int getValeurErronee() {
        return valeurErronee;
    }
}