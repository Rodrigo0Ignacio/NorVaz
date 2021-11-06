/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author felip
 */
public class Venta {
    private int id_venta;
    private int  total;
    private String cod_seguimiento;
    private String fecha;
    private String estado;
    private String rut;

    public Venta(int id_venta, int total, String cod_seguimiento, String fecha, String estado, String rut) {
        this.id_venta = id_venta;
        this.total = total;
        this.cod_seguimiento = cod_seguimiento;
        this.fecha = fecha;
        this.estado = estado;
        this.rut = rut;
    }

    public int getId_venta() {
        return id_venta;
    }

    public int getTotal() {
        return total;
    }

    public String getCod_seguimiento() {
        return cod_seguimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public String getRut() {
        return rut;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCod_seguimiento(String cod_seguimiento) {
        this.cod_seguimiento = cod_seguimiento;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    
    
}
