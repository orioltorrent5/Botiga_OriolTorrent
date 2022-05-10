package Botiga;

public class ProductePes extends Producte{

    //Constructor
    public ProductePes(float preu, String nom){
        super(preu, nom);
    }

    //Metodes

    /**
     * Calcula el preu del producte
     * @param quanitat la quantiat de aquest producte
     * @return retorna el preu
     */
    public float calcularPreu(float quanitat){
        return super.getPreu() * quanitat;
    }
}
