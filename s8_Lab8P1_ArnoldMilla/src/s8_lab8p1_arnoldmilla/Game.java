package s8_lab8p1_arnoldmilla;

import java.util.ArrayList;


public class Game {
    int tablero [][];
    int actual [][];
    int despues [][] = new int [10][10];
    int rondas;
    ArrayList<String> coords= new ArrayList();
    
    public Game (){
    }
    
    public int getRondas() {
        return rondas;
    }
    
    public int[][] getTablero() {
        return tablero;
    }
    
    public int [][] getactual(){
        return actual;
    }
    
    public int [][] getdespues(){
        return despues;
    }
    
    public ArrayList<String> getcoords(){
        return coords;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public void setActual(int[][] actual) {
        this.actual = actual;
    }

    public void setDespues(int[][] despues) {
        this.despues = despues;
    }

    public void setCoords(ArrayList<String> coords) {
        this.coords = coords;
    }
    
    public void setRondas(int rondas) {
        this.rondas = rondas;
    }
    
    //////////////////////NextGEN
    
    public void nextGen (int rondas, int [][] tablero, int [][] actual, int [][] despues){      
        int c = 1;
        int nums = 0;
        int replace [][] = new int [10][10];
        String posicion = "";
        
        coords.clear();
        
        while (c <= rondas){
        for (int contador = 0; contador < 10; contador++) {
            for (int cont = 0; cont < 10; cont++) {
                if (cont != 0  && cont != 9 && contador != 0 && contador != 9){
                    if (actual [contador + 1][cont + 1] == 1){
                        nums += 1;
                    }
                    if (actual [contador + 1][cont - 1] == 1){
                        nums += 1;
                    }
                    if (actual [contador + 1][cont] == 1){
                        nums += 1;
                    }
                    if (actual [contador - 1][cont] == 1){
                        nums += 1;
                    }
                    if (actual [contador - 1][cont - 1] == 1){
                        nums += 1;
                    }
                    if (actual [contador][cont + 1] == 1){
                        nums += 1;
                    }
                    if (actual [contador][cont - 1] == 1){
                        nums += 1;
                    }
                    if (actual [contador - 1][cont + 1] == 1){
                        nums += 1;
                    }
                    if (actual [contador][cont] == 1 && nums < 2){
                        despues[contador][cont] = 0;
                    }
                        else if (actual [contador][cont] == 1 && nums > 3){
                            despues[contador][cont] = 0;
                        }
                        else if (actual [contador][cont] == 0 && nums == 3){
                            despues[contador][cont] = 1;
                        }
                        else if (actual [contador][cont] == 1 && nums == 2){
                            despues[contador][cont] = 1;
                        }
                        if (despues[cont][contador] == 1){
                            System.out.println(nums);
                            posicion += contador;
                            posicion += ":";
                            posicion += cont;
                            coords.add(posicion);
                            posicion = "";
                        }
                }
                nums = 0;
                
            }
        }   
            System.out.println("Ronda numero:" + c);
            System.out.println("Coordenadas de celdas vivas: ");
            System.out.println(coords);
        for (int cont = 0; cont < 10; cont++) {
                for (int contador = 0; contador < 10; contador++) {
                    System.out.print("[" + despues[cont][contador] + "]");
                }
                System.out.println("");
            }
        c++;
        coords.clear();
        }
    }////Fin nextGen
    
    public int [][] Print(ArrayList<String> coords){
        char provX = ' ';
        char provY = ' ';
        int x;
        int y;
        int temp [][] = new int [10][10];
        
        for (int contador = 0; contador < coords.size(); contador++) {
            String coordenadas = coords.get(contador);
            provX = coordenadas.charAt(0);
            provY = coordenadas.charAt(2);
            x = provX - '0';
            y = provY - '0';
            temp [x][y] = 1; 
            provX = ' ';
            provY = ' ';
        }
        return temp;
    }///fin print coordenadas
    
}//fin clase

