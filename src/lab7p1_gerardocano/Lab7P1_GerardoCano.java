/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_gerardocano;
import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author gcano
 */
public class Lab7P1_GerardoCano {
static Scanner read = new Scanner (System.in);
static Random ram = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op=0;
        op = menu(op);
        do{
            switch(op){
                case 1:{
                    System.out.println("Ingrese una matriz impar");
                    System.out.println("Ingrese numero de filas");
                    int fil = read.nextInt();
                    System.out.println("Ingrese numero de columnas");
                    int col = read.nextInt();
                    if(fil ==col){
                         JOptionPane.showMessageDialog(null,"El numero de columnas tiene que ser diferente al numero de "
                                 + "filas");
                    }else{
                        int[][] matrix = matram(fil,col);
                        JOptionPane.showMessageDialog(null,"Matriz Generada\n"+imprimir(matrix)+"\n"
                                +"Matriz rotada\n"+imprimir(rotary(matrix)));
                        //minimiza pa ver
                    }
                    
                    
                }break;
                case 2:
                    System.out.println("Ingrese una matriz impar");
                    System.out.println("Ingrese numero de filas");
                    int fil = read.nextInt();
                    System.out.println("Ingrese numero de columnas");
                    int col = read.nextInt();
                    if(fil ==col){
                         JOptionPane.showMessageDialog(null,"El numero de columnas tiene que ser diferente al numero de "
                                 + "filas");
                    }else{
                        int[][] matrix = matram(fil,col);
                        JOptionPane.showMessageDialog(null,imprimir(matrix)+"\n"+"el numero generado es\n"+magico(matrix));
                    }
                break;
                case 3:
                    System.out.println("Ingrese la primera cadena");
                    String S1 = read.next();
                    System.out.println("Ingrese la segunda cadena");
                    String S2 = read.next();
                    JOptionPane.showMessageDialog(null, "El tamano es "+LCS(S1,S2));
                break;
                case 4:
                    JOptionPane.showMessageDialog(null,"Saliendo");
                break;
            }
            op = menu(op);
        }while(op!=4);
    }
    public static  int menu(int op ){
        
        System.out.println("Menu");
        System.out.println("1.Portrait");
        System.out.println("2.Numero magico");
        System.out.println("3.Subsequencia");
        System.out.println("4.Salir");
        System.out.println("Ingrese una opcion");
        op = read.nextInt();
        int opcion = op;
        return opcion;
    }
    public static int[][] matram(int fil, int col){
        int temp [][] =  new int [fil][col];
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j <col; j++) {
                temp[i][j] =1+ram.nextInt(9);
            }}
        
    return temp;    
    }
    public static String imprimir(int[][] matrix){
        String str="";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                str+="["+matrix[i][j]+"]"+" ";
            }
            str+="\n";
        }
        
        return str;
    }
    public static int [][] rotary(int [][]matrix){
        int [][] temp = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                temp[j][i]+=matrix[i][j];
                
            }
            
        }
        temp=inverse(temp);
        return temp;
    }
    //metodo para invertir la matriz pq me daba transpuesta
    public static int [][] inverse(int[][]m){
        int [] [] nm = new int [m.length][m[0].length];
        int cols = m[0].length-1;
        for (int i = 0; i <= m.length-1; i++) {
            for (int j =  m[0].length-1; j>=0; j--) {
                nm[i][cols-j]=m[i][j];
                //System.out.println(i+" "+j);
            }
        }
        return nm;
    }
    public static int  magico(int [][]matrix){
        int op1=1, op2=0, res;//op =1 pq si es 0 multiplica todo por 0 q es 0 lol
          for (int i = 0; i < matrix.length; i++) {
                  for (int j = 0; j < matrix[0].length; j++) {
                      if(j==0||i==0||i==matrix.length-1||j==matrix[0].length-1){
                         op2 += matrix[i][j];
                      }else{
                         op1 *= matrix[i][j];
                         
                      
                  }}}
          System.out.println(imprimir(matrix));
          System.out.println("OP1= "+op1);
          System.out.println("OP2= "+op2);
          res=op1+op2;
          System.out.println("respuesta = "+res);
          return res;
     }
    public static int LCS(String S1,String S2){
        int res=0;
        char s='-';
        S1=s+S1;
        S2=s+S2;
        int [][] sub=new int[S1.length()][S2.length()];
        for (int i = 0; i < S1.length(); i++) {
            for (int j = 0; j <S2.length(); j++) {
               if(S1.charAt(i)=='-'||S2.charAt(j)=='-'){
                   sub[i][j]=0;
               }else if(S1.charAt(i)==S2.charAt(j)){
                  sub[i][j]=1+sub[i-1][j-1];
               }else{
                   sub[i][j]=Math.max(sub[i][j-1], sub[i-1][j]);
               }
            }
            //System.out.println(imprimir(sub));
        }
        System.out.println(imprimir(sub));
        //sub[sub.length-1][sub[0].length-1]=6
        JOptionPane.showMessageDialog(null,imprimir(sub));
        res = sub[sub.length-1][sub[0].length-1];
        return res;
    }
    
    
}
