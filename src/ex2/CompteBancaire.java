package ex2;

import ex2.exceptions.CompteInexistantException;
import ex2.exceptions.FondsInsuffisantsException;

public abstract class CompteBancaire {
    protected String numeroCompte;
    protected double solde;
    protected String nomTitulaire;

    public CompteBancaire(String numeroCompte, String nomTitulaire, double soldeInitial) {
        this.numeroCompte = numeroCompte;
        this.nomTitulaire = nomTitulaire;
        this.solde = soldeInitial;
    }

    // 1. Dépôt
    public void deposer(double montant) {
        if (montant > 0) {
            this.solde += montant;
            System.out.println("Dépôt de " + montant + " sur le compte " + numeroCompte);
        }
    }

    // 2. Retrait (Abstraite ou implémentation par défaut, ici on laisse les enfants gérer la logique exacte du solde)
    // Nous déclarons que cette méthode PEUT lever une exception
    public abstract void retirer(double montant) throws FondsInsuffisantsException;

    // 3. Affichage du solde
    public void afficherSolde() {
        System.out.println("Compte " + numeroCompte + " (" + nomTitulaire + ") - Solde : " + solde);
    }

    // 4. Transfert
    public void transferer(CompteBancaire destinataire, double montant)
            throws FondsInsuffisantsException, CompteInexistantException {

        if (destinataire == null) {
            throw new CompteInexistantException();
        }

        // On tente d'abord de retirer de ce compte.
        // Si ça échoue (fonds insuffisants), l'exception arrête tout ici, donc pas de dépôt chez l'autre.
        this.retirer(montant);

        // Si le retrait a marché, on dépose chez l'autre
        destinataire.deposer(montant);
        System.out.println("Transfert de " + montant + " effectué vers " + destinataire.getNumeroCompte());
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    // Pour faciliter l'affichage dans la liste
    @Override
    public String toString() {
        return "Compte N°" + numeroCompte + " | Titulaire: " + nomTitulaire + " | Solde: " + solde;
    }
}