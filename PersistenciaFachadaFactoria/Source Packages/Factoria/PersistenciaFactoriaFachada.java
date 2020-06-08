package Factoria;

import Fachada.PersistenciaFachada;


public class PersistenciaFactoriaFachada {
    public static PersistenciaFachada getPersistenciaFachada(String tipo){
        return new PersistenciaFachada();
    }
}
