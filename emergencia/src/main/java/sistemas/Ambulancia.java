package sistemas;


    public class Ambulancia implements ServicioEmergencia {
        private int ambulanciasDisponibles;
        private int paramedicosDisponibles;
    
        public Ambulancia(int ambulanciasDisponibles, int paramedicosDisponibles) {
            this.ambulanciasDisponibles = ambulanciasDisponibles;
            this.paramedicosDisponibles = paramedicosDisponibles;
        }
    
        @Override
        public void atenderEmergencia(Emergencia emergencia) {
            if (emergencia.getTipo().equals("Accidente Vehicular")) {
                System.out.println("Atendiendo accidente en " + emergencia.getUbicacion());
                ambulanciasDisponibles--;
                paramedicosDisponibles -= 2;
            }
        }
    
        // Getters y Setters
        public int getAmbulanciasDisponibles() {
            return ambulanciasDisponibles;
        }
    
        public void setAmbulanciasDisponibles(int ambulanciasDisponibles) {
            this.ambulanciasDisponibles = ambulanciasDisponibles;
        }
    
        public int getParamedicosDisponibles() {
            return paramedicosDisponibles;
        }
    
        public void setParamedicosDisponibles(int paramedicosDisponibles) {
            this.paramedicosDisponibles = paramedicosDisponibles;
        }
    }
    



