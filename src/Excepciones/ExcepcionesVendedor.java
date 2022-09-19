package Excepciones;

import java.io.IOException;

public class ExcepcionesVendedor extends IOException {
    public ExcepcionesVendedor() {}

    public ExcepcionesVendedor(String msg) {
        super(msg);
    }

}
