Trabajo Práctico 1 — Entorno, Git y fundamentos de Java

Materia: Programación II

Estudiante: Leonel Ignacio Ahunchaín



Programas que incluye "tp.java":



- Programa que mide los kilometros que ha recorrido un camion

- Programa que calcula cuantos litros de gasoil gastó el camion cada 100km

- Programa que calcula el rendimiento de los litros de gasoil en base a los kilometros recorridos

- Programa que calcula el costo total en base al combustible que cargó el camion

- Programa que calcula el costo de cada kilometro recorrido

- Programa que calcula cuanto porcentaje del tanque se ha llenado con el combustible que se ha cargado



Programas que incluye "flota.java":



- Programa en el cual el usuario brinda los datos de la flota de los camiones (1 por 1)

- Programa que muestra la informacion de la flota

- Programa que calcula el total de kilometros que ha recorrido la flota

- Programa que calcula el total de litros que ha consumido la flota

- Programa que calcula el promedio de kilometros recorridos por la flota

- Programa que dice la patente del camion que mas kilometros hizo y tambien dice la patente del camion que menos kilometros hizo

- Programa que calcula el consumo de los litros de combustible cada 100km

- Programa que calcula y devuelve el promedio de la flota en base al consumo del combustible cada 100km

- Programa que separa la consumicion del combustible cada 100km de cada camion en diferentes clasificaciones, tales como: 
                            - EFICIENTE
                            - NORMAL
                            - EXCESIVO


Instrucciones para compilarlos y ejecutarlos:

1 - Abrir la carpeta en la cual quieras tener los programas

2 - Escribir en la terminal:

                git clone https://github.com/leonelahunchain40-debug/-tp1-consumo-flota

                             
3 - Entras en la sub-carpeta que se creó:
                                        
                cd "-tp1-consumo-flota"


4 - Compilas con el programa tp:

                Javac tp.java



5 - Ejecutas con:
                
                Java tp



6 - Compilas el programa flota:

                Javac flota



7 - Ejecutas con:

                Java flota



1- Puede dar un resultado equivocado porque si los 2 que vas a dividir son enteros el resultado pierde automaticamente la parte decimal, por eso para solucionarlo decidi colocar un "(double)" antes de la ecuacion.

2- Haber trabajado la parte c en una rama diferente (parte-c) me sirvió para poder comparar el codigo de la rama con el del main y elegir que codigo preferiria, ademas de que si llegaba a terminar teniendo un error en la parte-c podia volver al codigo del main y utilizar ese otra vez.

3-
