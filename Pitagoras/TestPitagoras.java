import java.lang.Math;
import java.util.Scanner;
public class TestPitagoras{
    public static void main(String [] args){
        Pitagoras iD = new Pitagoras();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese valor del primer cateto:");
        int catetoA = sc.nextInt();
        System.out.println("Ingrese valor del segundo cateto:");
        int catetoB = sc.nextInt();
        double hipotenusa = iD.calcularHipotenusa(catetoA, catetoB); //!!!recordar id antes de llamar a una funcion del archivo original
        System.out.println("El valor de la hipotenusa es " + hipotenusa);
    } 
}