package sistemas;


    public class Bomberos implements ServicioEmergencia {
        private int camionesDisponibles;
        private int personalDisponible;
    
        public Bomberos(int camionesDisponibles, int personalDisponible) {
            this.camionesDisponibles = camionesDisponibles;
            this.personalDisponible = personalDisponible;
        }
    
        @Override
        public void atenderEmergencia(Emergencia emergencia) {
            if (emergencia.getTipo().equals("Incendio")) {
                System.out.println("Atendiendo incendio en " + emergencia.getUbicacion());
                camionesDisponibles--;
                personalDisponible -= 3;
            }
        }
    
        // Getters y Setters
        public int getCamionesDisponibles() {
            return camionesDisponibles;
        }
    
        public void setCamionesDisponibles(int camionesDisponibles) {
            this.camionesDisponibles = camionesDisponibles;
        }
    
        public int getPersonalDisponible() {
            return personalDisponible;
        }
    
        public void setPersonalDisponible(int personalDisponible) {
            this.personalDisponible = personalDisponible;
        }
    }

