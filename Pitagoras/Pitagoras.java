import java.lang.Math;
public class Pitagoras{
    public double calcularHipotenusa(int catetoA, int catetoB){
        double sumaDeCatetosAlCuadrado = Math.pow(catetoA, 2) + Math.pow(catetoB, 2);
        double hipotenusa = Math.sqrt(sumaDeCatetosAlCuadrado);
        return hipotenusa;
    }
}