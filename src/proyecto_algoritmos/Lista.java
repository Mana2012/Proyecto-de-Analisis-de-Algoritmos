
package proyecto_algoritmos;

public class Lista {
    private Nodo head;
    private Nodo fin;
    int cant;
    
    Lista(){
    }
    
    Lista(int cabeza, String ultimo){
        head=new Nodo(cabeza,ultimo);
        fin=head;
        cant=1;
    }

    //@return the head
    public Nodo getHead() {
        return head;
    }

    //@param head the head to set
    public void setHead(Nodo head) {
        this.head = head;
    }

    //@return the fin
    public Nodo getFin() {
        return fin;
    }

    //* @param fin the fin to set
    public void setFin(Nodo fin) {
        this.fin = fin;
    }
    
    void AddArista(int id){
        fin.setSig(new Nodo(id));
        fin=fin.getSig();
        cant++;
    }
    
    public int getCant(){
        return cant;
    }
    
    public int getId(){
        return head.getId();
    }
    
    public String getName(){
        return head.getName();
    }
    
    public boolean VisitadoL(){
        boolean prueba=head.isVisit();
        return prueba;
    }
    
    public void imprimir(){
        Nodo temp = head;
        System.out.println(temp.toString());
        if(temp.getSig() != null){
            temp = temp.getSig();
            while(temp.getSig() != null){
                System.out.print(temp.toString1());
                temp = temp.getSig();
            }
            System.out.print(temp.toString1());
        }
    }

    public void visitar() {
        head.setVisit(true);
    }
}
