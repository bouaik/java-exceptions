package ex2;

import ex2.exceptions.FondsInsuffisantsException;

public class CompteEpargne extends CompteBancaire {
    private double tauxInteret; // Exemple 0.05 pour 5%

    public CompteEpargne(String numeroCompte, String nomTitulaire, double soldeInitial, double tauxInteret) {
        super(numeroCompte, nomTitulaire, soldeInitial);
        this.tauxInteret = tauxInteret;
    }

    @Override
    public void retirer(double montant) throws FondsInsuffisantsException {
        // Pas de découvert autorisé ici
        if (solde < montant) {
            throw new FondsInsuffisantsException(montant, solde);
        }
        solde -= montant;
        System.out.println("Retrait de " + montant + " effectué sur le compte épargne.");
    }

    public void appliquerInterets() {
        double interets = solde * tauxInteret;
        solde += interets;
        System.out.println("Intérêts appliqués (" + (tauxInteret * 100) + "%). Nouveaux solde : " + solde);
    }
}