package ex2.exceptions;

public class CompteInexistantException extends Exception {
    public CompteInexistantException() {
        super("Erreur : Le compte destinataire n'existe pas ou est invalide.");
    }
}