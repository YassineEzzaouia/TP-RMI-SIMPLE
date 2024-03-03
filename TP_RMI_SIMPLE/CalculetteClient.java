import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculetteClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            Calculette calculette = (Calculette) registry.lookup("calculette");
            Scanner scanner = new Scanner(System.in);
            boolean continuer = true;
            while (continuer) {
                System.out.println("Choisissez une opération :");
                System.out.println("1. Addition");
                System.out.println("2. Soustraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Quitter");
                System.out.print("Votre choix : ");
                int choix = scanner.nextInt();
                if (choix >= 1 && choix <= 4) {
                    System.out.print("Entrez le premier nombre : ");
                    double a = scanner.nextDouble();
                    System.out.print("Entrez le deuxième nombre : ");
                    double b = scanner.nextDouble();
                    double resultat = 0;
                    switch (choix) {
                        case 1:
                            resultat = calculette.addition(a, b);
                            break;
                        case 2:
                            resultat = calculette.soustraction(a, b);
                            break;
                        case 3:
                            resultat = calculette.multiplication(a, b);
                            break;
                        case 4:
                            resultat = calculette.division(a, b);
                            break;
                    }
                    System.out.println("Résultat : " + resultat);
                } else if (choix == 5) {
                    continuer = false;
                } else {
                    System.out.println("Choix invalide");
                }
            }
            System.out.println("Fin du programme.");
        } catch (Exception e) {
            System.err.println("Erreur: " + e.getMessage());
        }
    }
}
