package Factoria;

import Fachada.PersistenciaFachada;

/**
 *
 * @author Juan Enrique Solis Perla, ID: 165920
 */
public class PersistenciaFachadaFactoria {
    
    public static PersistenciaFachada getPersistenciaFachada(){
        return new PersistenciaFachada();
    }
}
