
package proyecto_algoritmos;


public class Nodo {
    private int Id;
    private String name;
    private Nodo sig;
    private boolean visit;
    
    Nodo(){        
    }
    
    Nodo(int id){
        Id=id;
    }
    
    Nodo(int id, String nombre){
        Id=id;
        name=nombre;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    //@param Id the Id to set
    public void setId(int Id) {
        this.Id = Id;
    }

    //@return the name
    public String getName() {
        return name;
    }

    //@param name the name to set
    public void setName(String name) {
        this.name = name;
    }
    
    //@return the sig
    public Nodo getSig() {
        return sig;
    }


    //@param sig the sig to set
    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public boolean isVisit() {
        return visit;
    }

    public void setVisit(boolean visit) {
        this.visit = visit;
    }
    
    @Override
    public String toString(){
        return "Id: " + Id + " " +  "Nombre: " + name;
    }
    
    public String toString1(){
        return " " + Id + " ";
    }
}
