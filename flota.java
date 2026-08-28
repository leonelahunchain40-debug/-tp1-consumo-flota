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
        System.out.println("=======================================================");
        System.out.printf(" %35s %n%n", "FLOTA DE CAMIONES");
        System.out.print("=======================================================");
        
        for(int i = 0;i < CANTIDAD_DATOS;i++){
            System.out.printf("%n|%34s  %d                 |%n","Datos del camion", (i+1) );
            System.out.println("-------------------------------------------------------");
            System.out.printf("|Patente              : %30s|%n", patente[i]);
            System.out.println("-------------------------------------------------------");
            System.out.printf("|Kilometros Recorridos: %30d|%n", KilometrosRecorridos[i]);
            System.out.println("-------------------------------------------------------");
            System.out.printf("|Litros Consumidos    : %30.2f|%n", LitrosConsumidos[i]);
            System.out.print("=======================================================");
        }
            System.out.printf("%n Kilometros Recorridos por la flota: %30d|%n", KilometrosFlota(camiones, KilometrosRecorridos));
            System.out.println("=======================================================");
            System.out.printf("Litros Consumidos Por La Flota: %30.2f|%n", LitrosFlota(camiones, LitrosConsumidos));
            System.out.println("=======================================================");
            System.out.printf("Promedio De Kilometros Por Camion: %30.2f|%n", PromedioKilometros(camiones, KilometrosRecorridos));
            System.out.println("=======================================================");
            System.out.printf("Promedio De Litros Consumidos Cada 100km: %30.2f|%n", ConsumoPromedioLitro(LitrosConsumidos, KilometrosRecorridos));
            System.out.println("=======================================================");
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

    public static void MayoryMenorKilometros(int[] camiones,int[] KilometrosRecorridos,String[] patente){
        int mayor = KilometrosRecorridos[0];
        int menor = KilometrosRecorridos[0];
        int contador_mayor = 0;
        int contador_menor = 0;

        for(int i = 1;i < CANTIDAD_DATOS;i++){
            if(mayor < KilometrosRecorridos[i]){
                mayor = KilometrosRecorridos[i];
                contador_mayor = i;
            }
            if(menor > KilometrosRecorridos[i]){
                menor = KilometrosRecorridos[i];
                contador_menor = i;
            }
        }
        System.out.printf("|Patente Del Camion Que Mas Recorrió:         %s|%n", patente[contador_mayor]);
        System.out.println("=======================================================");
        System.out.printf("|Patente Del Camion Que Menos Recorrio:      %s|%n", patente[contador_menor]);
        System.out.println("=======================================================");
        }

    public static double[] ConsumoCada100km(double[] LitrosCargados,int[] KilometrosRecorridos){
        double[] resultado = new double[CANTIDAD_DATOS];
        for(int i = 0;i < CANTIDAD_DATOS;i++){
            resultado[i] = (LitrosCargados[i] / KilometrosRecorridos[i]) * 100;
        }
        return resultado;
    }

    public static double ConsumoPromedioLitro(double[] LitrosCargados,int[] KilometrosRecorridos){
            double suma = 0;

            for(int i = 0;i < CANTIDAD_DATOS;i++){
                suma+= ConsumoCada100km(LitrosCargados, KilometrosRecorridos)[i];
            }

            return suma / CANTIDAD_DATOS;
        }

    public static void ClasificacionConsumo(int[] KilometrosRecorridos, double[] LitrosConsumidos){
        int contador_eficiente = 0;
        int contador_normal = 0;
        int contador_excesivo = 0;
        System.out.println("=======================================================");
        System.out.printf("%35s %n%n", "TIPO DE CONSUMO");
        System.out.println("=======================================================");
        for(int i = 0;i < CANTIDAD_DATOS;i++){
            if(ConsumoCada100km(LitrosConsumidos, KilometrosRecorridos)[i] < 8){
                System.out.printf("|%35s                    |%n","EFICIENTE");
                System.out.println("=======================================================");
                contador_eficiente++;
            }else if(ConsumoCada100km(LitrosConsumidos, KilometrosRecorridos)[i] < 12 && ConsumoCada100km(LitrosConsumidos, KilometrosRecorridos)[i] > 8){
                System.out.printf("|%35s                    |%n","NORMAL");
                System.out.println("=======================================================");
                contador_normal++;
            }else if(ConsumoCada100km(LitrosConsumidos, KilometrosRecorridos)[i] > 12){
                System.out.printf("|%35s                    |%n","EXCESIVO");
                System.out.println("=======================================================");
                contador_excesivo++;
            }
        }
    }

    public static void main(String[] args){
        int[] camiones = new int[CANTIDAD_DATOS];
        String[] patente = new String[CANTIDAD_DATOS];
        int[] KilometrosRecorridos = new int[CANTIDAD_DATOS];
        double[] LitrosConsumidos = new double[CANTIDAD_DATOS];

        Scanner teclado = new Scanner(System.in);

        CargarInformacionFlota(camiones, patente, KilometrosRecorridos, LitrosConsumidos, teclado);

        MostrarInformacion(camiones, patente, KilometrosRecorridos, LitrosConsumidos);

        MayoryMenorKilometros(camiones, KilometrosRecorridos, patente);

        ClasificacionConsumo(KilometrosRecorridos, LitrosConsumidos);
    }
}
