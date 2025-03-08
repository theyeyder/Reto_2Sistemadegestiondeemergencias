package sistemas;


    public class Policia implements ServicioEmergencia {
        private int unidadesDisponibles;
        private int oficialesDisponibles;
    
        public Policia(int unidadesDisponibles, int oficialesDisponibles) {
            this.unidadesDisponibles = unidadesDisponibles;
            this.oficialesDisponibles = oficialesDisponibles;
        }
    
        @Override
        public void atenderEmergencia(Emergencia emergencia) {
            if (emergencia.getTipo().equals("Robo")) {
                System.out.println("Atendiendo robo en " + emergencia.getUbicacion());
                unidadesDisponibles--;
                oficialesDisponibles -= 50;
            }
        }
    
        // Getters y Setters
        public int getUnidadesDisponibles() {
            return unidadesDisponibles;
        }
    
        public void setUnidadesDisponibles(int unidadesDisponibles) {
            this.unidadesDisponibles = unidadesDisponibles;
        }
    
        public int getOficialesDisponibles() {
            return oficialesDisponibles;
        }
    
        public void setOficialesDisponibles(int oficialesDisponibles) {
            this.oficialesDisponibles = oficialesDisponibles;
        }
    }

