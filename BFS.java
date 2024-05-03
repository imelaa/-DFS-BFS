// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.Scanner;

// public class BFS {
//     public int nn;
//     public int origen[] = new int[100];
//     public int destino[] = new int[100];  
//     public int M[][] = new int[50][50];
//     public int x=0;

//     public void printMatrixBFS(){
//         System.out.println("Matrix of adyacence");
//         System.out.println("Nodes "+nn);
//         System.out.println();  

//         for (int k=0;k<=nn;k++){ //Print columns at the top
//             System.out.print(k +" ");
//         }
//         for (int i =1;i<=nn;i++){//Print the structure and the rows
//             System.out.println();
//             System.out.print(i + " ");

//             for (int j=1;j<=nn;j++){ //Print the matrix itself
//                 System.out.print(M[i][j]+ " ");
//             }
//         }

//     }

//     public void readFile(String grafo) {
//         String rutaArchivo = grafo;

//         try {
//             File archivo = new File(rutaArchivo);
//             Scanner read = new Scanner(archivo);
//             boolean firstLine = false;

//             while (read.hasNextLine()) {

//                 if (!firstLine) {
//                     String moco = read.nextLine();
//                     this.nn = Integer.parseInt(moco);
//                     firstLine = true;
//                 } else {
//                     String line = read.nextLine();
//                     String[] parts = line.split(" ");
//                     origen[x] = Integer.parseInt(parts[0]);
//                     destino[x] = Integer.parseInt(parts[1]);
//                     x++;
//                     M[Integer.parseInt(parts[0])][Integer.parseInt(parts[1])] = 1;
//                     M[Integer.parseInt(parts[1])][Integer.parseInt(parts[0])] = 1;
//                 }
//             }
//             read.close();
//             System.out.println("Grafo leido");
//             System.out.println(nn);
//             for (int i = 0; i < x; i++) {
//                 System.out.println(origen[i] + " " + destino[i]);
//             }
//         } catch (FileNotFoundException e) {
//             System.out.println("Error reading the file");
//         }
//     }

//     public static void main (String []args){
//         BFS bfs = new BFS();
//         bfs.readFile("grafo.txt");
//         bfs.printMatrixBFS();
//     }
    
// }
