import java.util.Scanner;

public class flota {
    public static final int CANTIDAD_DATOS= 6;
    public static final double CANTIDAD_MINIMA = 0;
    public static final double CAPACIDAD_TANQUE = 400;

    public static int[] CargarInformacionFlota(int[] camiones,String[] patente,int[] KilometrosRecorridos,double[] LitrosConsumidos,Scanner teclado){
        double aux = 0;

        for(int i = 0; i < CANTIDAD_DATOS;i++){
            System.out.println("Ingrese la patente del camion " + (i+1) + " : ");
            patente[i] = teclado.nextLine();
            do{
            System.out.println("Ingrese los kilometros recorridos: ");
            aux = teclado.nextDouble();
            }while(aux < CANTIDAD_MINIMA);{
                KilometrosRecorridos[i] = (int) aux;
            }
            do{
            System.out.println("Ingrese los litros consumidos por el camion " + (i+1) + " : ");
            aux = teclado.nextDouble();
            teclado.nextLine();
            }while(aux < CANTIDAD_MINIMA && aux < CAPACIDAD_TANQUE);{
                LitrosConsumidos[i] = aux;
            }
        }
        return camiones;
    }

    public static void MostrarInformacion(int[] camiones,String[] patente,int[] KilometrosRecorridos,double[] LitrosConsumidos){
        for(int i = 0;i < CANTIDAD_DATOS;i++){
            System.out.println("Datos del camion " + (i+1) + " : ");
            System.out.println("Patente: " + patente[i]);
            System.out.println("Kilometros Recorridos: " + KilometrosRecorridos[i]);
            System.out.println("Litros Consumidos: " + LitrosConsumidos[i]);
        }
    }

    public static int KilometrosFlota(int[] camiones,int[] KilometrosRecorridos){
        int suma = 0;
        for(int i = 0;i < CANTIDAD_DATOS;i++){
            suma += KilometrosRecorridos[i];
        }

        return suma;
    }

    public static double LitrosFlota(int[] camiones,double[] LitrosConsumidos){
        double suma = 0;
        for(int i = 0;i < CANTIDAD_DATOS;i++){
            suma += LitrosConsumidos[i];
        }

        return suma;
    }

    public static double PromedioKilometros(int[] camiones,int[] KilometrosRecorridos){
        double promedio = 0;
        for(int i = 0;i < CANTIDAD_DATOS;i++){
            promedio += KilometrosRecorridos[i];
        }

        return (double) promedio / CANTIDAD_DATOS;
    }

    public static void main(String[] args){
        int[] camiones = new int[CANTIDAD_DATOS];
        String[] patente = new String[CANTIDAD_DATOS];
        int[] KilometrosRecorridos = new int[CANTIDAD_DATOS];
        double[] LitrosConsumidos = new double[CANTIDAD_DATOS];

        Scanner teclado = new Scanner(System.in);

        CargarInformacionFlota(camiones, patente, KilometrosRecorridos, LitrosConsumidos, teclado);

        MostrarInformacion(camiones, patente, KilometrosRecorridos, LitrosConsumidos);

        System.out.println("Kilometros Recorridos por la flota: " + KilometrosFlota(camiones, KilometrosRecorridos));
    }
}
