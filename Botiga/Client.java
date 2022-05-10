package Botiga;

public class Client {
    //Atributs
    private String nom;
    private String cognom;
    private String DNI;

    //Constructor
    public Client(String nom, String cognom, String DNI){
        this.nom = nom;
        this.cognom = cognom;
        this.DNI = DNI;
    }

    public Client(){
        this.nom = "no definit";
        this.cognom = "no definit";
        this.DNI = "1234567";
    }

    //Metodes
    public String getNom(){
        return this.nom;
    }
    public String getCognom(){
        return this.cognom;
    }
    public String getDNI(){
        return this.DNI;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setCognom(String cognom){
        this.cognom = cognom;
    }
    public void setDNI(String DNI){
        this.DNI = DNI;
    }

    public String toString(){
        return "Nom: " + getNom() + " DNI: " + getDNI();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        if (this.DNI.equals(client.DNI)) return true;
        else return false;
    }
}
