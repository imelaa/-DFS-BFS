
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class DFS {
    public int nn; // number of nodes
    public int origen[] = new int[100];
    public int destino[] = new int[100];
    public int M[][] = new int[50][50];
    public int x = 0;
    public int y;

    public void printMatrixDFS() {

        System.out.println("Matrix of adyacence");
        System.out.println("Nodes " + nn);
        System.out.println();
        for (int k = 0; k <= nn; k++) {
            System.out.print(k + " ");
        }

        for (int i = 1; i <= nn; i++) {
            System.out.println();

            System.out.print(i + " ");

            for (int j = 1; j <= nn; j++) {

                System.out.print(M[i][j] + " ");
            }
        }
        System.out.println();
        System.out.println();

    }

    public void readFileDFS(String grafo) {
        String rutaArchivo = grafo;

        try {
            File archivo = new File(rutaArchivo);
            Scanner read = new Scanner(archivo);
            boolean firstLine = false;

            while (read.hasNextLine()) {

                if (!firstLine) {
                    String moco = read.nextLine();
                    this.nn = Integer.parseInt(moco);
                    firstLine = true;
                } else {
                    String line = read.nextLine();
                    String[] parts = line.split(" ");
                    origen[x] = Integer.parseInt(parts[0]);
                    destino[x] = Integer.parseInt(parts[1]);
                    x++;
                    M[Integer.parseInt(parts[0])][Integer.parseInt(parts[1])] = 1;
                    M[Integer.parseInt(parts[1])][Integer.parseInt(parts[0])] = 1;
                }
            }
            read.close();
            System.out.println("Grafo leido");
            System.out.println(nn);
            for (int i = 0; i < x; i++) {
                System.out.println(origen[i] + " " + destino[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading the file");
        }
    }

    public void recorridoProfundo(int inicio) {
        Stack S = new Stack(nn + 1);
        int visitados[] = new int[nn + 1];

        for (int i = 0; i <= nn; i++) {
            visitados[i] = 0;
        }
        S.push(inicio);
        visitados[inicio] = 1;

        System.out.print(inicio + "->");

        while (S.isEmpty() != 1) {
            int nodo = S.pop();
            
            if (visitados[nodo] == 0) {
                System.out.print(nodo + "->");
            }
            visitados[nodo] = 1;

            for (int i = nn; i >= 1; i--) {
                if (M[nodo][i] != 0 && visitados[i] == 0) {
                    S.push(i);
                }
            }
        }
        System.out.println();
    }

    public boolean euleriano(){
        int grado[] = new int[nn+1];
        int impar = 0;
        for (int i = 1; i <= nn; i++){
            for (int j = 1; j <= nn; j++){
                if (M[i][j] != 0){
                    grado[i]++;
                }
            }
        }
        for (int i = 1; i <= nn; i++){
            if (grado[i] % 2 != 0){
                impar++;
            }
        }
        if (impar == 0){
            return true;
        }
        return false;
    
    }

    public static void main(String args[]) {
        DFS G = new DFS();
        G.readFileDFS("grafo.txt");
        G.printMatrixDFS();
        G.recorridoProfundo(2);
        System.out.println(G.euleriano());

        
    }
}
