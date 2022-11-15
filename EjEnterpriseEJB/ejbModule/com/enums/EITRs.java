package com.enums;



public enum EITRs {
SUROESTE("Region Suroeste",Departamento.RIO_NEGRO),CENTROSUR("Region Centrosur",Departamento.DURAZNO),NORTE("Region Norte",Departamento.RIVERA);

private String Nombre;
private Departamento departamento;
private EITRs (String Nombre,Departamento departamento) {
}
public String getNombreITR() {
    return this.Nombre;
}
public Departamento getDepITR() {
    return this.departamento;
}
}
