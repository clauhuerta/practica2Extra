package es.ufv.dis.back.practica2.Back;


public class TurismoComunidad {
    private String _id;
    private String periodo;
    private int total;
    private String provinciaOrigen;
    private String comunidadOrigen;
    private String comunidadDestino;
    private String provinciaDestino;

    // Getters y Setters
    public String get_id() { return _id; }
    public void set_id(String _id) { this._id = _id; }
    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }
    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }
    public String getProvinciaOrigen() { return provinciaOrigen; }
    public void setProvinciaOrigen(String provinciaOrigen) { this.provinciaOrigen = provinciaOrigen; }
    public String getComunidadOrigen() { return comunidadOrigen; }
    public void setComunidadOrigen(String comunidadOrigen) { this.comunidadOrigen = comunidadOrigen; }
    public String getComunidadDestino() { return comunidadDestino; }
    public void setComunidadDestino(String comunidadDestino) { this.comunidadDestino = comunidadDestino; }
    public String getProvinciaDestino() { return provinciaDestino; }
    public void setProvinciaDestino(String provinciaDestino) { this.provinciaDestino = provinciaDestino; }
}
