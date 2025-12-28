package ex1;

public class Main {
    public static void main(String[] args) {

        try {
            EntierNaturel e1 = new EntierNaturel(1);
            System.out.println("Valeur initiale : " + e1.getVal());

            e1.decrementer();
            System.out.println("Après décrémentation : " + e1.getVal());

            System.out.println("Tentative de décrémenter encore...");
            e1.decrementer();

        } catch (NombreNegatifException e) {
            System.out.println("Exception attrapée !");
            System.out.println("Message : " + e.getMessage());
            System.out.println("Valeur erronée stockée : " + e.getValeurErronee());
        }

        System.out.println();

        try {
            EntierNaturel e2 = new EntierNaturel(10);
            System.out.println("Valeur actuelle : " + e2.getVal());

            System.out.println("Tentative de mettre la valeur à -5...");
            e2.setVal(-5);

        } catch (NombreNegatifException e) {
            System.out.println("Exception attrapée !");
            System.out.println("Valeur erronée récupérée via l'exception : " + e.getValeurErronee());
        }

        System.out.println();

        try {
            System.out.println("Tentative de créer un ex1.EntierNaturel avec -100...");
            EntierNaturel e3 = new EntierNaturel(-100);

        } catch (NombreNegatifException e) {
            System.out.println("Impossible de créer l'objet.");
            System.out.println("Valeur refusée : " + e.getValeurErronee());
        }
    }
}