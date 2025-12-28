package ex2.exceptions;

public class FondsInsuffisantsException extends Exception {
    public FondsInsuffisantsException(double montantDemande, double soldeActuel) {
        super("Fonds insuffisants ! Vous demandez " + montantDemande +
                " mais votre limite permet seulement " + soldeActuel);
    }
}