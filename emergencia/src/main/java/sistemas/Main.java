package sistemas;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Inicialización de servicios para el sistema de gestion  de emergencias
        Bomberos bomberos = new Bomberos(50, 50);
        // Camiones y bomberos disponibles 50 de cada de uno 
        Ambulancia ambulancia = new Ambulancia(50, 50);
        // Para ambulancia y Paramedicos 50 disponibles para cada uno
        Policia policia = new Policia(50, 50);
        // Los oficiales dispobles y undidades disponibles son 50 para cada quien 

        // Creación del sistema de emergencias
        SistemaEmergencias sistema = new SistemaEmergencias(bomberos, ambulancia, policia);

        try ( // Scanner para la entrada del usuarios 
                Scanner scanner = new Scanner(System.in)) {
            int opcion;

            do {
                // Menú de opciones Sistemas de Gestion De Emergencias 
                System.out.println("==========================================");
                System.out.println("\n Sistema de Gestión de Emergencias Urbanas");
                System.out.println("==========================================");
                System.out.println("1. Registrar Nueva Emergencia");
                System.out.println("2. Ver Estado de Recursos");
                System.out.println("3. Atender Emergencia");
                System.out.println("4. Mostrar Estadísticas");
                System.out.println("5. Monitorear Emergencias");
                System.out.println("6. Evaluar Desempeño del Sistema");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opción: ");
                System.out.println("-->");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Para limpiar buffer

                switch (opcion) {
                    case 1 -> {
                        // Registro de  Nuevas Emergencias
                        System.out.println("==============================================");
                        System.out.println("\n Tipos de Emergencias a Prestar Servicio ");
                        System.out.println("==============================================");
                        System.out.println("1. Incendio");
                        System.out.println("2. Accidente Vehicular");
                        System.out.println("3. Robo");
                        System.out.print("Seleccione el tipo de emergencia (1-3): ");
                        int tipoEmergencia = scanner.nextInt();
                        scanner.nextLine(); // Para limpiar buffer


                        String tipo = "";
                        switch (tipoEmergencia) {
                            case 1 ->
                                tipo = "Incendio";
                            case 2 ->
                                tipo = "Accidente Vehicular";
                            case 3 ->
                                tipo = "Robo";
                            default -> {
                                System.out.println("Opción no válida. Volviendo al menú principal.");
                                continue; // Volver al menú principal
                            }
                        }

                        System.out.print("Ingrese La Ubicación En la Que Se Encuetra: ");

                        String ubicacion = scanner.nextLine();
                        System.out.print("Ingrese el nivel de gravedad (1 a 10): ");
                        int nivelGravedad = scanner.nextInt();
                        System.out.print("Ingrese su tiempo de respuestas esperado (en minutos): ");
                        int tiempoRespuesta = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer

                        Emergencia emergencia = new Emergencia(tipo, ubicacion, nivelGravedad, tiempoRespuesta);
                        sistema.registrarEmergencia(emergencia);
                        System.out.println("Emergencia registrada correctamente.");
                    }

                    case 2 -> {
                        // Ver Estado de Recursos sistema de emergencias ....
                        System.out.println("\n--- Estado de Recursos ---");
                        System.out.println("Camiones de bomberos disponibles: " + bomberos.getCamionesDisponibles());
                        System.out.println("Ambulancias disponibles: " + ambulancia.getAmbulanciasDisponibles());
                        System.out.println("Unidades policiales disponibles: " + policia.getUnidadesDisponibles());
                    }

                    case 3 -> {
                        // Atender Emergencia.....
                        System.out.println("\nEmergencias Registradas:-->");
                        List<Emergencia> emergencias = sistema.getEmergencias();
                        if (emergencias.isEmpty()) {
                            System.out.println("No hay emergencias registradas.");
                        } else {
                            for (int i = 0; i < emergencias.size(); i++) {
                                System.out.println((i + 1) + ". " + emergencias.get(i));
                            }

                            System.out.print("Seleccione el número de la emergencia a atender: ");
                            int idEmergencia = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer codigo ...

                            if (idEmergencia > 0 && idEmergencia <= emergencias.size()) {
                                sistema.atenderEmergencia(emergencias.get(idEmergencia - 1));
                                System.out.println("Emergencia atendida correctamente.");
                            } else {
                                System.out.println("Número de emergencia no válido.");
                            }
                        }
                    }

                    case 4 -> // Mostrar Estadísticas Del sistema de emergencias 
                        sistema.mostrarEstadisticas();

                    case 5 -> {
                        // Monitorear Emergencias
                        System.out.println("\n--- Emergencias Registradas ---");
                        List<Emergencia> emergenciasMonitoreo = sistema.getEmergencias();
                        if (emergenciasMonitoreo.isEmpty()) {
                            System.out.println("No hay emergencias registradas.");
                        } else {
                            for (Emergencia e : emergenciasMonitoreo) {
                                String estado = e.getEstado();
                                if (estado.equals("Atendida")) {
                                    System.out.println(e + " [ATENDIDA]");
                                } else {
                                    System.out.println(e + " [PENDIENTE]");
                                }
                            }
                        }
                    }

                    case 6 -> {
                        // Evaluar Desempeño del Sistema de emergencias
                        System.out.println("\n--- Evaluación del Desempeño ---");
                        System.out.println("Emergencias atendidas: " + sistema.getEmergencias().size());
                        System.out.println("Camiones de bomberos restantes: " + bomberos.getCamionesDisponibles());
                        System.out.println("Ambulancias restantes: " + ambulancia.getAmbulanciasDisponibles());
                        System.out.println("Unidades policiales restantes: " + policia.getUnidadesDisponibles());
                    }

                    case 7 -> // Salir  del Programa o sistema
                        System.out.println("Saliendo del sistema...");

                    default ->
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 7);
        }
    }
    
}
