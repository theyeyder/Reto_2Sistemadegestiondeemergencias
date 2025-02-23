package sistemas;

import java.util.ArrayList;
import java.util.List;

public class SistemaEmergencias {
    private List<Emergencia> emergencias;
    private Bomberos bomberos;
    private Ambulancia ambulancia;
    private Policia policia;

    public SistemaEmergencias(Bomberos bomberos, Ambulancia ambulancia, Policia policia) {
        this.bomberos = bomberos;
        this.ambulancia = ambulancia;
        this.policia = policia;
        this.emergencias = new ArrayList<>();
    }

    public void registrarEmergencia(Emergencia emergencia) {
        emergencias.add(emergencia);
        System.out.println("Emergencia registrada: " + emergencia);
    }

    public void atenderEmergencia(Emergencia emergencia) {
        ServicioEmergencia servicio = null;

        switch (emergencia.getTipo()) {
            case "Incendio":
                servicio = bomberos;
                break;
            case "Accidente Vehicular":
                servicio = ambulancia;
                break;
            case "Robo":
                servicio = policia;
                break;
            default:
                System.out.println("Tipo de emergencia no reconocido.");
                return;
        }

        servicio.atenderEmergencia(emergencia);
    }

    public void mostrarEstadisticas() {
        System.out.println("Estadísticas del día:");
        System.out.println("Emergencias atendidas: " + emergencias.size());
        System.out.println("Camiones de bomberos disponibles: " + bomberos.getCamionesDisponibles());
        System.out.println("Ambulancias disponibles: " + ambulancia.getAmbulanciasDisponibles());
        System.out.println("Unidades policiales disponibles: " + policia.getUnidadesDisponibles());
    }
}
