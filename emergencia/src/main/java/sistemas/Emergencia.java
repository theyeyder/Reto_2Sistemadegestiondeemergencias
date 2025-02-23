package sistemas;


    public class Emergencia {
        private String tipo;
        private String ubicacion;
        private int nivelGravedad;
        private int tiempoRespuesta;
    
        public Emergencia(String tipo, String ubicacion, int nivelGravedad, int tiempoRespuesta) {
            this.tipo = tipo;
            this.ubicacion = ubicacion;
            this.nivelGravedad = nivelGravedad;
            this.tiempoRespuesta = tiempoRespuesta;
        }
    
        // Getters y Setters
        public String getTipo() {
            return tipo;
        }
    
        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
    
        public String getUbicacion() {
            return ubicacion;
        }
    
        public void setUbicacion(String ubicacion) {
            this.ubicacion = ubicacion;
        }
    
        public int getNivelGravedad() {
            return nivelGravedad;
        }
    
        public void setNivelGravedad(int nivelGravedad) {
            this.nivelGravedad = nivelGravedad;
        }
    
        public int getTiempoRespuesta() {
            return tiempoRespuesta;
        }
    
        public void setTiempoRespuesta(int tiempoRespuesta) {
            this.tiempoRespuesta = tiempoRespuesta;
        }
    
        @Override
        public String toString() {
            return "Emergencia{" +
                    "tipo='" + tipo + '\'' +
                    ", ubicacion='" + ubicacion + '\'' +
                    ", nivelGravedad=" + nivelGravedad +
                    ", tiempoRespuesta=" + tiempoRespuesta +
                    '}';
        }
    }

