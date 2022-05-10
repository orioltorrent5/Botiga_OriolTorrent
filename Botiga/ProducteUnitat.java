package Botiga;

public class ProducteUnitat extends Producte{
    //Atributs
    private float descompte;
    private float preuMinimPerAplicarDescompte;

    //Constructor
    public ProducteUnitat(float preu, String nom, float descompte, float preuMinimPerAplicarDescompte){
        super(preu, nom);
        this.descompte = descompte;
        this.preuMinimPerAplicarDescompte = preuMinimPerAplicarDescompte;
    }

    //Metodes
    public double getDescompte(){
        return this.descompte;
    }

    public double getPreuMinimPerAplicarDescompte(){
        return this.preuMinimPerAplicarDescompte;
    }

    public void setDescompte(float descompte){
        this.descompte = descompte;
    }

    public void setPreuMinimPerAplicarDescompte(float preuMinimPerAplicarDescompte){
        this.preuMinimPerAplicarDescompte = preuMinimPerAplicarDescompte;
    }

    public float calcularPreu(float quanitat){
        float preuFinal;
        if ((super.getPreu() * quanitat) >= this.preuMinimPerAplicarDescompte){
            preuFinal = super.getPreu() * quanitat - (super.getPreu() * quanitat) * descompte;
        }else {
            preuFinal = super.getPreu() * quanitat;
        }
        return preuFinal;
    }
}

