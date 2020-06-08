package Factoria;

import Fachada.PersistenciaFachada;
//La factoria obtiene los datos de la persistencia fachada
public class PersistenciaFactoriaFachada {
    public static PersistenciaFachada getPersistenciaFachada(){
        return new PersistenciaFachada();
    }
}
