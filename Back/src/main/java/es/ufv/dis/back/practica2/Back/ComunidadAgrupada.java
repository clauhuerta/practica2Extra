package es.ufv.dis.back.practica2.Back;


import java.util.List;

public class ComunidadAgrupada {
    private String codigoComunidad;
    private List<TurismoComunidad> entradas;

    public String getCodigoComunidad() { return codigoComunidad; }
    public void setCodigoComunidad(String codigoComunidad) { this.codigoComunidad = codigoComunidad; }

    public List<TurismoComunidad> getEntradas() { return entradas; }
    public void setEntradas(List<TurismoComunidad> entradas) { this.entradas = entradas; }
}
