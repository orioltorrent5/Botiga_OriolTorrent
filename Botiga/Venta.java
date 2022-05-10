package Botiga;

import Amarratges.Client;

public class Venta {

    //Atributs
    private MetodeDePagamaent tipusPagament;
    private Client c1;
    private Producte producte;
    private double quantitat;

    //Constructos
    public Venta(MetodeDePagamaent tipusPagament, Client client, Producte producte, double quantitat){
        this.c1 = client;
        this.producte = producte;
        this.quantitat = quantitat;
        this.tipusPagament = tipusPagament;
    }

    //Metodes
    public String toString(){
        return "Client: " + this.c1.getNom() +" Quanitat: " + this.quantitat +" Producte: " + this.producte.getNom() + " Tipus de pagament: " + this.tipusPagament ;
    }

    public Client getClient(){
        return this.c1;
    }

    public Producte getProducte(){
        return this.producte;
    }

    public double getQuantitat(){
        return this.quantitat;
    }

    public MetodeDePagamaent getTipusPagament(){
        return this.tipusPagament;
    }

}
