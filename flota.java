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
        System.out.println("Patente Del Camion Que Mas Recorrió: " + patente[contador_mayor]);
        System.out.println("Patente Del Camion Que Menos Recorrio: " + patente[contador_menor]);
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
            for(int i = 0;i < CANTIDAD_DATOS;i++){
                if(ConsumoCada100km(LitrosConsumidos, KilometrosRecorridos)[i] < 8){
                    System.out.println("EFICIENTE");
                    contador_eficiente++;
                }else if(ConsumoCada100km(LitrosConsumidos, KilometrosRecorridos)[i] < 12 && ConsumoCada100km(LitrosConsumidos, KilometrosRecorridos)[i] > 8){
                    System.out.println("NORMAL");
                    contador_normal++;
                }else if(ConsumoCada100km(LitrosConsumidos, KilometrosRecorridos)[i] > 12){
                    System.out.println("EXCESIVO");
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

        System.out.println("Kilometros Recorridos por la flota: " + KilometrosFlota(camiones, KilometrosRecorridos));
    }
}
