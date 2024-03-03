import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculetteServeur extends UnicastRemoteObject implements Calculette {

    protected CalculetteServeur() throws RemoteException {
        super();
    }

    @Override
    public double addition(double a, double b) throws RemoteException {
        return a + b;
    }

    @Override
    public double soustraction(double a, double b) throws RemoteException {
        return a - b;
    }

    @Override
    public double multiplication(double a, double b) throws RemoteException {
        return a * b;
    }

    @Override
    public double division(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Division par zéro impossible");
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {
            CalculetteServeur calculetteServeur = new CalculetteServeur();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("calculette", calculetteServeur);
            System.out.println("Serveur prêt");
        } catch (Exception e) {
            System.err.println("Erreur: " + e.getMessage());
        }
    }
}
