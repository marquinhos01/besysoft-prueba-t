package Excepciones;

import java.io.IOException;

public class ExcepcionesAlmacen extends IOException {
    public ExcepcionesAlmacen(){}
    public ExcepcionesAlmacen(String msj_error){super(msj_error);}

}
