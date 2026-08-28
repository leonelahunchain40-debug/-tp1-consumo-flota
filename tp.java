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

    public static double Rendimiento(double LitrosCargados,int KilometrosRecorridos){
        return KilometrosRecorridos / LitrosCargados;
    }

    public static double CostoTotalCombustible(double LitrosCargados){
        return LitrosCargados * PRECIO_LITRO;
    }

    public static double CostoKilometro(int KilometrosRecorridos,double CostoTotal){

        return CostoTotal / KilometrosRecorridos;
    }

    public static double PorcentajeCarga(double LitrosCargados){
        return (LitrosCargados / CAPACIDAD_TANQUE) * 100;
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

        double CostoTotal = CostoTotalCombustible(LitrosCargados);

        System.out.println("======================================================================");
        
        System.out.printf("|Patente              |  %12s                                 |%n", patente);
        System.out.println("----------------------------------------");
        System.out.printf("|Kilometraje Inicial  |  %12d                                 |%n", KilometrajeInicial);
        System.out.println("----------------------------------------");
        System.out.printf("|Kilometraje Final    |  %12d                                 |%n", KilometrajeFinal);
        System.out.println("----------------------------------------");
        System.out.printf("|Litros Cargados      |  %12.2f                                 |%n", LitrosCargados);

        System.out.println("======================================================================");

        System.out.printf("|Kilometros Recorridos|  %12d                                 |%n", KilometrosRecorridos);
        
        System.out.println("======================================================================");

        System.out.printf("Litros consumidos cada 100km| %.2f                                   |%n", Consumo_100_Km(KilometrosRecorridos, LitrosCargados));

        System.out.println("======================================================================");

        System.out.printf("Rendimiento en kilometros por litro: %.2f                           |%n", Rendimiento(LitrosCargados, KilometrosRecorridos));

        System.out.println("======================================================================");

        System.out.printf("Costo Total del combustible cargado: %.2f                           |%n", CostoTotalCombustible(LitrosCargados));

        System.out.println("======================================================================");

        System.out.printf("Costo por kilometro: %.2f                                           |%n", CostoKilometro(KilometrosRecorridos,CostoTotal));

        System.out.println("======================================================================");

        System.out.printf("Porcentaje de la capacidad del tanque que representa la carga: %.2f%%|%n", PorcentajeCarga(LitrosCargados));

        System.out.println("======================================================================");

        System.out.println("El camion con patente " + patente + " ha recorrido un total de " + KilometrosRecorridos + " kilometros|");

        System.out.println("======================================================================");

        teclado.close();
    }
}