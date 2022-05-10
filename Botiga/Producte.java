package Botiga;

public abstract class Producte {
    //Atributs
    private float preu;
    private String nom;

    //Constructor
    public Producte(float preu, String nom){
        this.nom = nom;
        this.preu = preu;
    }

    //Metodes
    abstract float calcularPreu(float quantitat);

    public float getPreu(){
        return this.preu;
    }

    public String getNom(){
        return this.nom;
    }
}
