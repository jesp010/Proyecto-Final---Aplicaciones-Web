package Factoria;

import Fachada.PersistenciaFachada;


public class PersistenciaFactoriaFachada {
    public static PersistenciaFachada getPersistenciaFachada(){
        return new PersistenciaFachada();
    }
}