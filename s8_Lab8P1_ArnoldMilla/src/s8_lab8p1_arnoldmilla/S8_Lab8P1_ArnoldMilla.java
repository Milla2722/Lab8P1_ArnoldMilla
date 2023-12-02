package s8_lab8p1_arnoldmilla;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class S8_Lab8P1_ArnoldMilla {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static Game g = new Game();

    
    public static void main(String[] args) {
        System.out.println("1. Game of Life");
        System.out.println("2. Salir");
        System.out.println("Ingrese una opcion [1,2]");
        int op = sc.nextInt();
            while (op > 0 && op < 2){
                switch(op){
                    case 1: {  
                        int tablero [][] = new int [10][10];
                        int actual [][] = new int [10][10];
                        int despues [][] = new int [10][10];
                        ArrayList<String> coords = new ArrayList();
                        tablero = creacion(tablero, actual, coords);
                        actual = tablero;
                        imprimir(tablero);
                        System.out.println("Ingrese la cantidad de rondas ");
                        int rondas = sc.nextInt();
                        g.setRondas(rondas);
                        g.setActual(actual);
                        g.setTablero(tablero);
                        g.setDespues(despues);
                        //g.nextGen(tablero,actual,despues);
                        g.nextGen(rondas, tablero,actual,despues);
                    }
                }
                
            System.out.println("1. Game of Life");
            System.out.println("2. Salir");
            System.out.println("Ingrese una opcion [1,2]");
            op = sc.nextInt();    
            }
        
    }
     
    public static int [][] creacion(int tablero[][], int actual[][],ArrayList<String>coords){
    int temp [][] = new int [10][10];
    String pos = "";
    
        for (int cont = 0; cont < 10; cont++) {           
            for (int contador = 0; contador < 10; contador++) {
               if (cont == 0  || cont == 9 || contador == 0 || contador == 9){
                   temp[cont][contador] = 0;
               }                  
                else {
                   temp [cont][contador] = rand.nextInt(0,2);
                }
               if (temp[cont][contador] == 1){
                   pos += contador;
                   pos += ":";
                   pos += cont;
                   coords.add(pos);
                   pos = "";
               }
            }
        }
        System.out.println(coords);
        g.setCoords(coords);
    return temp;  
    }
    
    public static void imprimir (int matriz [][]){
        System.out.println("");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
        System.out.println("");
        }
    }
    
}
