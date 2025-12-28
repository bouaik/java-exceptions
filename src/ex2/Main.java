package ex2;

import ex2.exceptions.CompteInexistantException;
import ex2.exceptions.FondsInsuffisantsException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Déclaration de la liste
        ArrayList<CompteBancaire> banque = new ArrayList<>();

        // 2. Ajout des comptes
        System.out.println("--- CRÉATION DES COMPTES ---");
        CompteCourant c1 = new CompteCourant("CC001", "Alice", 1000, 500); // 500 de découvert
        CompteEpargne c2 = new CompteEpargne("CE002", "Bob", 2000, 0.05); // 5% d'intérêts

        banque.add(c1);
        banque.add(c2);

        // Affichage initial
        for (CompteBancaire c : banque) {
            System.out.println(c);
        }
        System.out.println();

        // 3. Opérations et Gestion des Exceptions
        System.out.println("--- TESTS D'OPÉRATIONS ---");

        // Test A : Retrait valide sur Compte Courant
        try {
            c1.retirer(1200); // Solde: 1000, Retrait: 1200. OK car découvert 500. Solde devient -200.
        } catch (FondsInsuffisantsException e) {
            System.out.println("Erreur Retrait : " + e.getMessage());
        }

        // Test B : Retrait invalide sur Compte Epargne
        try {
            c2.retirer(5000); // Solde: 2000. Impossible.
        } catch (FondsInsuffisantsException e) {
            System.err.println(">> Erreur Retrait (" + c2.getNumeroCompte() + ") : " + e.getMessage());
        }

        System.out.println();

        // Test C : Transfert réussi
        System.out.println("--- TEST TRANSFERT ---");
        try {
            // Alice (-200) transfère vers Bob (2000).
            // Alice peut aller jusqu'à -500. Elle peut donc encore envoyer 200.
            c1.transferer(c2, 200);
        } catch (Exception e) {
            System.err.println("Erreur Transfert : " + e.getMessage());
        }

        c1.afficherSolde();
        c2.afficherSolde();

        System.out.println();

        // Test D : Transfert vers un compte inexistant (null)
        System.out.println("--- TEST TRANSFERT INVALIDE (Compte Inexistant) ---");
        try {
            CompteBancaire compteFantome = null;
            c2.transferer(compteFantome, 100);
        } catch (CompteInexistantException | FondsInsuffisantsException e) {
            System.err.println(">> Erreur Transfert : " + e.getMessage());
        }

        System.out.println();

        // 4. Suppression d'un compte
        System.out.println("--- SUPPRESSION ---");
        banque.remove(c1);
        System.out.println("Compte CC001 supprimé.");

        System.out.println("Comptes restants :");
        for (CompteBancaire c : banque) {
            System.out.println(c);
        }

        // Bonus : Application des intérêts
        if(banque.get(0) instanceof CompteEpargne) {
            ((CompteEpargne) banque.get(0)).appliquerInterets();
        }
    }
}