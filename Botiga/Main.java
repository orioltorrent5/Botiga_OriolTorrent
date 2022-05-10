package Botiga;
import Amarratges.Client;
import java.util.Scanner;

public class Main {

    public static Botiga botiga = new Botiga();

    public static void main(String[] args) {
        boolean repetir = true;
        int opcio;

        while (repetir){
            mostraMenu();
            opcio = solicitarOpcio(4);

            switch (opcio) {
                case 1 -> {
                    boolean repetirProducts = true;
                    while (repetirProducts){
                        mostraMenuProductes();
                        opcio = solicitarOpcio(6);
                        switch (opcio) {
                            case 1 -> crearAfegirProducte();
                            case 2 -> imprimirProductes();
                            case 3 -> calcularPreuFinal();
                            case 4 -> costTotalDeVentesDeUnProducte();
                            case 5 -> mostraProducteMesVengut();
                            case 6 -> repetirProducts = false;
                        }
                    }
                }

                case 2 -> {
                    boolean repetirVentes = true;
                    while (repetirVentes){
                        mostraMenuVentes();
                        opcio = solicitarOpcio(4);
                        switch (opcio){
                            case 1 -> agregarVenta();
                            case 2 -> botiga.imprimirVentes();
                            case 3 -> costTotalDeMetodesDePagament();
                            case 4 -> repetirVentes = false;
                        }
                    }
                }

                case 3 ->{
                    boolean repetirClients = true;
                    while (repetirClients){
                        mostraMenuClients();
                        opcio = solicitarOpcio(5);
                        switch (opcio){
                            case 1 -> agregarClient();
                            case 2 -> botiga.imprimirClients();
                            case 3 -> costTotalCompresClient();
                            case 4 -> clientQueHaGastatMes();
                            case 5 -> repetirClients = false;
                        }
                    }
                }

                case 4 -> repetir = false;
            }
        }
    }

    /**
     * Sol·licita una opcio a l'usuari i mira que estigui entre 1 i el numero introduit per l'usuari.
     * @param numOpcions el numero maxim de opcio que et poden donar
     * @return et retorna un numero que serà l'opcio
     */
    private static int solicitarOpcio(int numOpcions) {
        Scanner lector = new Scanner(System.in);
        int opcio;

        do {
            System.out.print("opcio: ");
            opcio = lector.nextInt();
            if(opcio < 1 || opcio > numOpcions){
                System.out.println("Numero Incorrecta!! tornal a introduir!!");
            }
        }while (opcio < 1 || opcio > 12);

        return opcio;
    }

    /**
     * Mostra el menu de ventes
     */
    private static void mostraMenuVentes(){
        System.out.println();
        System.out.println("---MENU VENTES---");
        System.out.println("1- Afegir venta");
        System.out.println("2- Imprimir ventes");
        System.out.println("3- Cost total de un metode de pagament");
        System.out.println("4- Sortir");
    }

    /**
     * Mostra el menu de clients
     */
    private static void mostraMenuClients(){
        System.out.println();
        System.out.println("---MENU CLIENTS---");
        System.out.println("1- Afegir client");
        System.out.println("2- Imprimir clients");
        System.out.println("3- Cost total de compres de un client");
        System.out.println("4- Client que ha gastat més i el total gastat");
        System.out.println("5- Sortir");
    }

    /**
     * Mostre el menu dels productes
     */
    private static void mostraMenuProductes(){
        System.out.println();
        System.out.println("---MENU PRODUCTES---");
        System.out.println("1- Afegir producte");
        System.out.println("2- Imprimir productes");
        System.out.println("3- Calcular preu final producte");
        System.out.println("4- Cost total de ventes de un producte");
        System.out.println("5- Mostra producte més vengut i el seu cost total");
        System.out.println("6- Sortir");
    }

    /**
     * Mostra el menu
     */
    private static void mostraMenu() {
        System.out.println();
        System.out.println("---MENU---");
        System.out.println("1- Productes");
        System.out.println("2- Ventes");
        System.out.println("3- Clients");
        System.out.println("4- Sortir");
    }

    /**
     * Crea un producte el qual després serà afegit
     */
    private static void crearAfegirProducte() {
        Scanner lector = new Scanner(System.in);
        int opcio;
        Producte p = new ProductePes(1, "hola");
        boolean repetir = true;

        while (repetir){
            System.out.println();
            System.out.println("--Crecio producte--");
            System.out.println("Tipus:");
            System.out.println("1- Pes");
            System.out.println("2- Unitat");
            System.out.println("3- Sortir al menu");
            do {
                System.out.print("opcio: ");
                opcio = lector.nextInt();
                if (opcio < 1  || opcio > 3){
                    System.out.println("Numero incorrecta!! Introdueix un número correcta!");
                }
            }while (opcio < 1  || opcio > 3);

            switch (opcio){
                case 1 ->  p = creacioProductePes();
                case 2 ->  p = creacioProducteUnitat();
                case 3 ->  repetir = false;
            }

            if (opcio == 1 || opcio == 2){
                afegirProducte(p);
            }
        }
    }

    /**
     * Afegeix un producte a la llista de productes de la botiga
     */
    private static void afegirProducte(Producte p) {
        if (botiga.afegirProducte(p)){
            System.out.println("Producte repetit!!");
        }else{
            System.out.println("Producte afegit correctament!");
        }
    }

    /**
     * Crea un producte de tipus Unitat
     * @return retorna un producte de tipus unitat
     */
    private static ProducteUnitat creacioProducteUnitat() {
        Scanner lector = new Scanner(System.in);
        float descompte;

        System.out.print("Introdueix el nom: ");
        String nom = lector.nextLine();
        System.out.print("Introduexi el preu: ");
        float preu = lector.nextFloat();
        System.out.print("Introdueix el descompte(entre 0.0-1.1): ");
        do {
            System.out.print("opcio: ");
             descompte = lector.nextFloat();
             if (descompte > 1.1f || descompte < 0.0f){
                 System.out.println("Número incorrecta!! Introdueix un numero correcta!!");
             }
        }while (descompte > 1.1f || descompte < 0.0f);
        System.out.print("Introdueix el preu per aplicar descompte: ");
        float preuMinim = lector.nextFloat();

        return new ProducteUnitat(preu, nom, descompte, preuMinim);
    }

    /**
     * Crea un producte de tipus pes
     * @return retorna el producte de tipus pes creat
     */
    private static ProductePes creacioProductePes() {
        Scanner lector = new Scanner(System.in);
        System.out.print("Introdueix el nom: ");
        String nom = lector.nextLine();
        System.out.print("Introduexi el preu: ");
        float preu = lector.nextFloat();

        return new ProductePes(preu, nom);
    }

    /**
     * Imprimeix la llista de productes que te la botiga
     */
    private static void imprimirProductes() {
        botiga.imprimirProductes();
    }

    /**
     * Calcula el preu final del producte i tel mostra per pantalla
     */
    private static void calcularPreuFinal() {
        Scanner lector = new Scanner(System.in);
        boolean repetir = true;

        while (repetir) {
            System.out.println();
            System.out.println("---Calcular preu final---");
            System.out.println("Introdueix el nom del producte(S - Per sortir): ");
            String nom = lector.nextLine();
            if (nom.equals("S") || nom.equals("s")){
                repetir = false;
            }else {
                System.out.println("Introdueix la quanitat: ");
                float quanitat = lector.nextFloat();

                Producte p = botiga.obtenirProducte(nom);

                float preuFinal = p.calcularPreu(quanitat);

                System.out.println();
                System.out.println("Preu final: " + preuFinal + "€");
                lector.nextLine();
            }
        }
    }

    /**
     * Aquest metode et permet afegir clients, comproba que el client no ja hi sigui.
     */
    private static void agregarClient() {
        Scanner lector = new Scanner(System.in);
        boolean repetir = true;
        String nom;
        String cognom;
        String dni;

        while (repetir){
            System.out.println("Introdueix el nom(S-Per sortir): ");
            nom = lector.nextLine();
            if (nom.equals("S") || nom.equals("s")){
                repetir = false;
            }else {
                System.out.println("Introdueix el cognom: ");
                cognom = lector.nextLine();

                System.out.println("Introdueix el DNI: ");
                dni = lector.nextLine();

                if (botiga.saberSiElClientExisteix(dni)){
                    System.out.println("Client existent!!");
                }else{
                    Client client = new Client(nom, cognom, dni);
                    botiga.afegirClient(client);
                    System.out.println("Client afegit correctament!!");
                    System.out.println();
                }
            }
        }
    }

    /**
     * Ens permet crear i afegir una venta, no podem crear la venta si abans no s'ha creat un client.
     */
    private static void agregarVenta() {
        Scanner lector = new Scanner(System.in);

        if (!botiga.saberSiLaLlistaClientsEstaBuida()){
        boolean repetir = true;
        MetodeDePagamaent metodeDePagamaent = null;
        Client clientVenta;
        Producte producteVenut;
        double quanitat;
        int opcio;

           while (repetir) {
               System.out.println();
               System.out.println("--Creacio Venta--");
               System.out.println("Selecciona el tipus de pagament");
               System.out.println(" 1- Targeta \n 2- Efectiu \n 3- Online \n 4- Sortir");
               do {
                   opcio = lector.nextInt();
               } while (opcio < 1 || opcio > 4);

               switch (opcio) {
                   case 1 -> metodeDePagamaent = MetodeDePagamaent.TARGETA;
                   case 2 -> metodeDePagamaent = MetodeDePagamaent.EFECTIU;
                   case 3 -> metodeDePagamaent = MetodeDePagamaent.ONLINE;
                   case 4 -> repetir = false;
                   default -> throw new IllegalStateException("Vlaor no espesificat: " + opcio);
               }
               if (repetir) {
                   System.out.println("Introdueix el DNI del client: ");
                   String dni = lector.next();
                   clientVenta = botiga.obtenirClientAmbElDni(dni);

                   System.out.println("Introdueix el nom del producte venut: ");
                   String nomProducte = lector.next();
                   producteVenut = botiga.obtenirProducte(nomProducte);
                   if (producteVenut == null){
                       System.out.println("El producte no existeix!!");
                   }else {
                       System.out.println("Introdueix la quanitat venuda: ");
                       quanitat = lector.nextDouble();

                       Venta v1 = new Venta(metodeDePagamaent, clientVenta, producteVenut, quanitat);
                       botiga.afegirVenta(v1);
                       System.out.println("Venta afegida correctament!!");
                   }
               }
           }
       }
        if (botiga.saberSiLaLlistaClientsEstaBuida()){
            System.out.println("Primer has de afegir un client!!");
        }
    }

    /**
     * Aquest metode et diu el total que ha gastat un client a la botiga.
     */
    private static void costTotalCompresClient() {
        Scanner lector = new Scanner(System.in);
        boolean repetir = true;
        String nom;
        double totalGastat;

        while (repetir){
            System.out.println();
            System.out.println("Introduiex el nom del client per veure el cost total de les seves ventes(S-Per sortir):");
            nom = lector.next();
            if (nom.equals("S") || nom.equals("s")){
                repetir = false;
            }else {
                Client client = botiga.obtenirClientAmbElNom(nom);
                totalGastat = botiga.calcularTotalVentaClient(client);
                System.out.println("El client ha gastat amb total: " + totalGastat + "€");
            }
        }
    }

    /**
     * Mostra la quantiat total amb euros que ha vengut un producte
     */
    private static void costTotalDeVentesDeUnProducte() {
        Scanner lector = new Scanner(System.in);
        boolean repetir = true;
        String nomProducte;
        double totalVengut;

        while (repetir){
            System.out.println();
            System.out.println("Introdueix el nom del prodcute(S-Per soritr): ");
            nomProducte = lector.next();
            if (nomProducte.equals("s") || nomProducte.equals("S")){
                repetir = false;
            }else {
                Producte producte = botiga.obtenirProducte(nomProducte);
                totalVengut = botiga.calcularTotalVentaProducte(producte);
                System.out.println("Cost total de ventes del producte: " + totalVengut + "€");
            }
        }
    }

    /**
     * Mostra el total vengut amb un metode de pagament
     */
    private static void costTotalDeMetodesDePagament() {
       Scanner lector = new Scanner(System.in);
       boolean repetir = true;
       int opcio;
       MetodeDePagamaent metodeDePagamaent = null;
       double total;

       while (repetir){
           System.out.println();
           System.out.println("Selecciona el metode de pagament que vols veure el cost total: ");
           System.out.println("1- Online");
           System.out.println("2- Efecitu");
           System.out.println("3- Targeta");
           System.out.println("4- Sortir");
           do {
               opcio = lector.nextInt();
           }while (opcio < 0 || opcio > 4);
           switch (opcio){
               case 1 -> metodeDePagamaent = MetodeDePagamaent.ONLINE;
               case 2 -> metodeDePagamaent = MetodeDePagamaent.EFECTIU;
               case 3 -> metodeDePagamaent = MetodeDePagamaent.TARGETA;
               case 4 -> repetir = false;
           }

           if (repetir){
               total = botiga.calcularTotalVentaSegonsMetodePagament(metodeDePagamaent);
               System.out.println("El cost total és: " + total + "€");
           }

       }
    }

    /**
     * Mostra el producte més vengut i el cost total
     */
    private static void mostraProducteMesVengut() {
        Producte producteMesVengut = botiga.obtenirProducteMesVengut();
        double costTotal = botiga.calcularTotalVentaProducte(producteMesVengut);

        System.out.println();
        System.out.println("---PRODUCTE MÉS VENGUT---");
        System.out.println("NOM:" + producteMesVengut.getNom() + " | COST TOTAL: " + costTotal + "€");
    }

    /**
     * Mostra el client que ha gastat més i el total gastat
     */
    private static void clientQueHaGastatMes() {
        Client clientMesGastat = botiga.obtenirClientQueHaGastatMes();
        double totalGastat = botiga.calcularTotalVentaClient(clientMesGastat);

        System.out.println();
        System.out.println("---CLIENT QUE MÉS A GASTAT---");
        System.out.println("NOM:" + clientMesGastat.getNom() + " | TOTAL GASTAT: " + totalGastat + "€");
    }
}
