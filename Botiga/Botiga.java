package Botiga;
import Amarratges.Client;

import javax.swing.plaf.SplitPaneUI;
import java.util.ArrayList;

public class Botiga {
    //Atributs
    private ArrayList<Producte> llistaProductes;
    private ArrayList<Venta> llistaVendes = new ArrayList<Venta>();
    private ArrayList<Client> llistaClients = new ArrayList<Client>();

    //Constructor
    public Botiga(){
        this.llistaProductes = new ArrayList<Producte>();
    }

    //Metodes
    public boolean afegirProducte(Producte p){
        boolean hiEs = false;
        for (Producte p1 : llistaProductes){
            if (p1.getNom().equals(p.getNom())){
                hiEs = true;
                break;
            }
        }
        if (!hiEs) {
            llistaProductes.add(p);
        }

        return hiEs;
    }

    public void imprimirProductes(){
        System.out.println();
        int i = 1;
        for (Producte p : llistaProductes){
            System.out.println("Producte "+ i + " = Nom: " + p.getNom() + " Preu: " + p.getPreu() + "€");
            i++;
        }
    }

    public Producte obtenirProducte(String nom){
        Producte p1 = null;
        for (Producte p : llistaProductes){
            if (p.getNom().equals(nom)){
                p1 = p;
            }
        }
        return p1;
    }

    public void afegirClient(Client c){
        llistaClients.add(c);
    }
    
    public Client obtenirClientAmbElDni(String dni){
        Client client = null;
        for (Client c : llistaClients){
            if (c.getDNI().equals(dni)){
                client = c;
            }
        }
        return client;
    }

    public Client obtenirClientAmbElNom(String nom){
        Client client = null;
        for (Client c : llistaClients){
            if (c.getNom().equals(nom)){
                client = c;
            }
        }
        return client;
    }

    public boolean saberSiLaLlistaClientsEstaBuida(){
        boolean buida = llistaClients.isEmpty();
        return buida;
    }

    public boolean saberSiElClientExisteix(String dni){
        boolean existeix = false;
        if (llistaClients != null){
            for (Client c : llistaClients) {
                if (c.getDNI().equals(dni)) {
                    existeix = true;
                    break;
                }
            }
        }
        return existeix;
    }
    
    public void afegirVenta(Venta v){
        llistaVendes.add(v);
    }

    public void imprimirVentes(){
        for (Venta a : llistaVendes){
            System.out.println();
            System.out.println(a);
            System.out.println();
        }
    }

    public  double calcularTotalVentaClient(Client c){
        double total = 0;
        for (Venta a : llistaVendes){
            if (a.getClient().equals(c)){
                total =  a.getQuantitat() * a.getProducte().getPreu() + total;
            }
        }
        return total;
    }

    public double calcularTotalVentaProducte(Producte p){
        double total = 0;
        for (Venta venta : llistaVendes){
            if (venta.getProducte().equals(p)){
                total = venta.getQuantitat() * p.getPreu() + total;
            }
        }
        return total;
    }

    public double calcularTotalVentaSegonsMetodePagament(MetodeDePagamaent metodeDePagamaent){
        double total = 0;
        for (Venta venta : llistaVendes){
            if (venta.getTipusPagament().equals(metodeDePagamaent)){
                total = venta.getQuantitat() * venta.getProducte().getPreu() + total;
            }
        }
        return total;
    }


    public Producte obtenirProducteMesVengut(){
        Producte producteMesVengut = null;
        double ingresosObtinguts = 0;
        for (Producte producte : llistaProductes){
            if (ingresosObtinguts < calcularTotalVentaProducte(producte)){
                ingresosObtinguts = calcularTotalVentaProducte(producte);
                producteMesVengut = producte;
            }
        }
        return producteMesVengut;
    }

    public Client obtenirClientQueHaGastatMes(){
       Client client = null;
       double totalGastat = 0;
       for (Client cli : llistaClients){
           if (totalGastat < calcularTotalVentaClient(cli)){
               totalGastat = calcularTotalVentaClient(cli);
               client = cli;
           }
       }
       return client;
    }

    public void imprimirClients(){
        System.out.println();
        int i = 1;
        for (Client a : llistaClients){
            System.out.println(i + ": " + a);
            i++;
        }
    }
}

