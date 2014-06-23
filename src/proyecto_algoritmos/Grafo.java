
package proyecto_algoritmos;

import java.util.ArrayList;

public class Grafo {
    ArrayList<Lista> grafo;
    ArrayList<Nodo> listaP = new ArrayList();
    ArrayList<String>listaSC1 = new ArrayList();
    ArrayList<Nodo> listaSC2 = new ArrayList();
    ArrayList<Nodo> lista1 = new ArrayList();
    ArrayList<Nodo> amigos=new ArrayList();
    ArrayList<Nodo> amigosAmigos=new ArrayList();
    ArrayList<Nodo> clique=new ArrayList();
    
    public Grafo(){
        grafo = new ArrayList();
    }
    
    public Grafo(ArrayList<Lista> grafo1){
        grafo = grafo1;
    }
    
    public void AgregarNodo(int id, String nombre){
        grafo.add(new Lista(id, nombre));
    }//fin
    
    public void AgregarArista(int id, int id2){
        for(int i=0; i<grafo.size();i++){
            if(grafo.get(i).getId()==id)
                grafo.get(i).AddArista(id2);
        }
    }//fin
        
    public void imprimirGrafo(){
        for(int i=0; i<grafo.size(); i++){
            System.out.println("");
            grafo.get(i).imprimir();
        }
    }//fin
    
//-------------------- RECORRIDO EN PROFUNDIDAD --------------------//
    public void recorrido(){
        for(int i=0;i<grafo.size();i++){
            Nodo temp = grafo.get(i).getHead();
            if(!estaVisitado(temp.getId())){
                profundidad(temp);
            }
        }
    }//fin
    
    public void profundidad(Nodo nod){
        listaP.add(nod);
        visitar(nod.getId());
        do{
            nod=nod.getSig();
            if(!estaVisitado(nod.getId())){
                profundidad(getNodoHead(nod));
            }
        }while(nod.getSig() != null);
    }//fin
    
    public Nodo getNodoHead(Nodo nodo){
        Nodo t = new Nodo();
        for(int i=0;i<grafo.size();i++){
            int temp1 = grafo.get(i).getId();
            if(temp1 == nodo.getId()){
                t = grafo.get(i).getHead();
            }
        }
        return t;
    }//fin
    
    private boolean estaVisitado(int id){
        for(int i=0; i<grafo.size(); i++){
            if(grafo.get(i).getId()==id)
               return grafo.get(i).VisitadoL();
        }
        return true;
    }//fin
    
    private void visitar(int id){
        for(int i=0; i<grafo.size();i++){
            if(grafo.get(i).getId()==id){
                grafo.get(i).visitar();
            }
        }
    }//fin
  
    public void imprimirRecorrido(){
        for(int i=0; i<listaP.size(); i++){
            System.out.println(listaP.get(i).toString());
        }
    }//fin
 //------------------------- SET COVER -------------------------//       
    public void SetCover(){
        int cont=0;
        int[] cantNod;
        for(int i=0;i<grafo.size();i++){
            Nodo temp = grafo.get(i).getHead();
            cantNod = new int[grafo.get(i).getCant()];
            do{
                if(!ingresado(temp.getId())){
                   cantNod[cont]=temp.getId();
                   cont ++;
                }
                temp=temp.getSig();
            }while(temp.getSig() != null);
            if((((cont/grafo.get(i).getCant())*100)>=50) || cont>1){
                for (int j = 0; j < cont; j++) {
                    if(!ingresado(cantNod[j])){
                       listaSC1.add(""+cantNod[j]);
                    }
                }
                listaSC2.add( grafo.get(i).getHead() );
            }
            cont=0;
        }
    }//fin

    public boolean ingresado(int id) {
        for(int i=0; i<listaSC1.size(); i++){
            if(Integer.parseInt(listaSC1.get(i)) == id)
                return true;
        }
        return false;
    }//fin
    
    public void imprimirSetCover(){
        for(int i=0; i<listaSC2.size(); i++){
            System.out.println(listaSC2.get(i).toString());
        }
    }//fin
    
//-------------------- CLIQUE --------------------//
    public void Clique(){
        int cantAmigos=0;
        for(int i=0;i<grafo.size();i++){
            cantAmigos = grafo.get(i).getCant() -1;
            if(cantAmigos > 1){
                Nodo temp = grafo.get(i).getHead();
                Nodo temp1=temp;
                temp=temp.getSig();
                amigos=amigosMasCerca(temp);
                Clique1(temp1);
            }else{
                System.out.println("El id: "+grafo.get(i).getId()+" solo tiene 1 amigo, No es candidato para Clique");
            }
        }
    }//fin
    
    public void Clique1(Nodo head){
        int cantAmigos=0;
        boolean resp=false, si=false;
        for(int i=0;i<grafo.size();i++){
            for (int j = 0; j < amigos.size(); j++){
                if(grafo.get(i).getId() == amigos.get(j).getId()){
                    cantAmigos = grafo.get(i).getCant() -1;
                    if(cantAmigos > 1){
                        Nodo temp = grafo.get(i).getHead();
                        Nodo temp1=temp;
                        temp=temp.getSig();
                        amigosAmigos=amigosMasCerca(temp);
                        for(int n=0; n<amigos.size();n++){
                            if(amigos.get(n).getId() != temp1.getId()){
                                resp=compare(temp1, amigos.get(n));
                                if(resp==true){
                                    clique.add(amigos.get(n));
                                    si=true;
                                }
                            }
                        }
                        if (si==true){
                            clique.add(head);
                            clique.add(temp1);
                        }
                    }
                }
            }
        }
    }//fin
    
    public ArrayList<Nodo> amigosMasCerca(Nodo nod){
        ArrayList<Nodo> t = new ArrayList();
        while(nod.getSig() != null){
            t.add(nod);
            nod=nod.getSig();
        }
        t.add(nod);
        return t;
    }
    
    public boolean compare(Nodo head2, Nodo amig){
        boolean resp=false;
        int cont=0;
        for (int i = 0; i < amigosAmigos.size(); i++) {
            if(amig.getId() == amigosAmigos.get(i).getId()){
                resp=true;
                break;
            } 
        }
        return resp;
    }
    
    public void imprimirClique(){
        for(int i=0; i<clique.size(); i++){
            System.out.print(clique.get(i).toString1());
        }
        System.out.println("");
    }//fin
}