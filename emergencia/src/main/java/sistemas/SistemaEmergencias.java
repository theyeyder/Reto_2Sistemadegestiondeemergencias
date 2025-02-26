package sistemas;

import java.util.ArrayList;
import java.util.List;

public class SistemaEmergencias {
    private final List<Emergencia> emergencias;
    private final Bomberos bomberos;
    private final Ambulancia ambulancia;
    private final Policia policia;

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
            case "Incendio" -> servicio = bomberos;
            case "Accidente Vehicular" -> servicio = ambulancia;
            case "Robo" -> servicio = policia;
            default -> {
                System.out.println("Tipo de emergencia no reconocido.");
                return;
            }
        }

        extracted(emergencia, servicio);
        emergencia.setEstado("Atendida"); // Cambiar el estado a "Atendida"
        System.out.println("Emergencia atendida: " + emergencia);
    }

    private void extracted(Emergencia emergencia, ServicioEmergencia servicio) {
        servicio.atenderEmergencia(emergencia);
    }

    public void mostrarEstadisticas() {
        System.out.println("Estadísticas del día:");
        System.out.println("Emergencias registradas: " + emergencias.size());
        System.out.println("Camiones de bomberos disponibles: " + bomberos.getCamionesDisponibles());
        System.out.println("Ambulancias disponibles: " + ambulancia.getAmbulanciasDisponibles());
        System.out.println("Unidades policiales disponibles: " + policia.getUnidadesDisponibles());
    }

    public List<Emergencia> getEmergencias() {
        return emergencias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SistemaEmergencias{");
        sb.append("emergencias=").append(emergencias);
        sb.append(", bomberos=").append(bomberos);
        sb.append(", ambulancia=").append(ambulancia);
        sb.append(", policia=").append(policia);
        sb.append('}');
        return sb.toString();
    }
}