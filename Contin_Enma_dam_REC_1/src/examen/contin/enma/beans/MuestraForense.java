package examen.contin.enma.beans;

import java.time.LocalDate;

public class MuestraForense {
    private int id;
    private int codigoCaso;
    private String tipoMuestra;
    private LocalDate fechaRecogida;
    private String estadoCustodia;
    private CentroForense centro;
    private InformeForense informe;

    public MuestraForense() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoCaso() {
        return codigoCaso;
    }

    public void setCodigoCaso(int codigoCaso) {
        this.codigoCaso = codigoCaso;
    }

    public String getTipoMuestra() {
        return tipoMuestra;
    }

    public void setTipoMuestra(String tipoMuestra) {
        this.tipoMuestra = tipoMuestra;
    }

    public LocalDate getFechaRecogida() {
        return fechaRecogida;
    }

    public void setFechaRecogida(LocalDate fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }

    public String getEstadoCustodia() {
        return estadoCustodia;
    }

    public void setEstadoCustodia(String estadoCustodia) {
        this.estadoCustodia = estadoCustodia;
    }

    public CentroForense getCentro() {
        return centro;
    }

    public void setCentro(CentroForense centro) {
        this.centro = centro;
    }

    public InformeForense getInforme() {
        return informe;
    }

    public void setInforme(InformeForense informe) {
        this.informe = informe;
    }
}
