package sistemas;

public class Main {
    public static void main(String[] args) {
        Bomberos bomberos = new Bomberos(5, 15);
        Ambulancia ambulancia = new Ambulancia(3, 6);
        Policia policia = new Policia(4, 8);

        SistemaEmergencias sistema = new SistemaEmergencias(bomberos, ambulancia, policia);

        Emergencia incendio = new Emergencia("Incendio", "Calle Falsa 123", 3, 10);
        Emergencia accidente = new Emergencia("Accidente Vehicular", "Avenida Siempre Viva 456", 2, 5);
        Emergencia robo = new Emergencia("Robo", "Calle Luna 789", 1, 2);

        sistema.registrarEmergencia(incendio);
        sistema.registrarEmergencia(accidente);
        sistema.registrarEmergencia(robo);

        sistema.atenderEmergencia(incendio);
        sistema.atenderEmergencia(accidente);
        sistema.atenderEmergencia(robo);

        sistema.mostrarEstadisticas();
    }
}