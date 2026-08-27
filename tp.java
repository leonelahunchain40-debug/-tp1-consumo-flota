import java.util.Scanner;

public class tp {
    public static final double PRECIO_LITRO = 1250.0;
    public static final double CAPACIDAD_TANQUE = 400.0;

    public static int Kilometros_recorridos(int KilometrajeInicial,int KilometrajeFinal){
        return KilometrajeFinal - KilometrajeInicial;
    }

    public static double Consumo_100_Km(int KilometrosRecorridos,double LitrosCargados){
         return (LitrosCargados / KilometrosRecorridos) * 100;
    }
    public static void main(String[] args){
        String patente;
        int KilometrajeInicial, KilometrajeFinal;
        double LitrosCargados;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese la patente del camion: ");
        patente = teclado.nextLine();

        System.out.println("Ingrese el kilometraje inicial del odómetro: ");
        KilometrajeInicial = teclado.nextInt();

        System.out.println("Ingrese el kilometraje final: ");
        KilometrajeFinal = teclado.nextInt();

        System.out.println("Ingrese los litros de gasoil que fueron cargados: ");
        LitrosCargados = teclado.nextDouble();

        System.out.println("");

        int KilometrosRecorridos = Kilometros_recorridos(KilometrajeInicial, KilometrajeFinal);

        System.out.println("El camion con patente " + patente + " ha recorrido un total de " + KilometrosRecorridos + " kilometros");

        System.out.println("");

        System.out.printf("Litros consumidos cada 100km: %.2f%n", Consumo_100_Km(KilometrosRecorridos, LitrosCargados));

        teclado.close();
    }
}