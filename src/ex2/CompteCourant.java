package ex2;

import ex2.exceptions.FondsInsuffisantsException;

public class CompteCourant extends CompteBancaire {
    private double decouvertAutorise;

    public CompteCourant(String numeroCompte, String nomTitulaire, double soldeInitial, double decouvertAutorise) {
        super(numeroCompte, nomTitulaire, soldeInitial);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retirer(double montant) throws FondsInsuffisantsException {
        // Le solde peut être négatif tant qu'il ne dépasse pas -decouvertAutorise
        if (solde - montant < -decouvertAutorise) {
            throw new FondsInsuffisantsException(montant, solde + decouvertAutorise);
        }
        solde -= montant;
        System.out.println("Retrait de " + montant + " effectué sur le compte courant.");
    }
}
