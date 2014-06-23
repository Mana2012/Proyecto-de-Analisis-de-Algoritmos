
package proyecto_algoritmos;

import java.io.*;

public class Proyecto_Algoritmos {
    
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        llenarGrafo();
        
    }
     
    public static void llenarGrafo(){
        Grafo grafo = new Grafo();
        String lista="";
        String[] prueba;
        int c=0,band1=0, id=0, arista=0;
                
        javax.swing.JFileChooser j= new javax.swing.JFileChooser();
        j.showOpenDialog(j);
        String path= j.getSelectedFile().getAbsolutePath();
        lista=leer(path);
        
        prueba = lista.split("[\n\\/\\;\\,]");
        for (int i = 0; i < prueba.length; i++) {
            if(isNumeric(prueba[i])){
                arista=Integer.parseInt(prueba[i]);
                if((i+1)<prueba.length){
                    if(isNumeric(prueba[i+1])){
                        if(c>0)
                            grafo.AgregarArista(id,arista);
                    }
                }else
                    grafo.AgregarArista(id,arista);
            }else{
                id=Integer.parseInt(prueba[i-1]);
                grafo.AgregarNodo(id, prueba[i]);
                c=1;
            }
        }
        
        System.out.println("---------------- IMPRIMIENDO GRAFO ----------------\n");
        grafo.imprimirGrafo();
        System.out.println("\n\n------------- IMPRIMIENDO RECORRIDO -------------\n");
        grafo.recorrido();
        grafo.imprimirRecorrido();
        System.out.println("\n------------- IMPRIMIENDO SET COVER -------------\n");
        grafo.SetCover();
        grafo.imprimirSetCover();
        System.out.println("\n--------------- IMPRIMIENDO CLIQUE ---------------\n");
        grafo.Clique();
        grafo.imprimirClique();
        
    }//fin
    
    public static String leer(String nombre){
        try{
            FileReader lectorArchivo;
            File f = new File(nombre);
            lectorArchivo = new FileReader(f);
            BufferedReader br = new BufferedReader(lectorArchivo);
            String lista="";
            String aux="";
            while(true){
                aux=br.readLine();
                if(aux!=null)
                    lista=lista+aux+"/";
                else
                    break;
            }//fin while
            br.close();
            lectorArchivo.close();
            return lista;
        }
        catch(IOException e){
            System.out.println("Error:"+e.getMessage());
        }
        return null;
    }//fin
    
    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }//fin
    
}
