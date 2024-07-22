/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hw.pkg1;

public class Multa {
    
    private int codigo;
    private String nombre;
    private String tipo;
    private double monto;
    private boolean pagado;
    
    public double TIPO_GRAVE;
    public double TIPO_MEDIO;
    public double TIPO_LEVE;
    
    public Multa(int codigo, String nombre, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        pagado = false;
        
        TIPO_GRAVE = 250;
        TIPO_MEDIO = 125;
        TIPO_LEVE = 50;
        
        switch (tipo) {
            case "LEVE" -> monto = TIPO_LEVE;
            case "MEDIO" -> monto = TIPO_MEDIO;
            case "GRAVE" -> monto = TIPO_GRAVE;
            default -> monto = TIPO_LEVE;
        }
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public double getMonto() {
        return monto;
    }
    
    public boolean getPagado() {
        return pagado;
    }
    
    public String pay() {
        pagado = true;
        return "Multa con Código #" + codigo + " fue pagada "
                + "\npor un monto de Lps." + monto;
    }
    
    public String print(boolean paga) {
        String text = (paga) ? "Pagada por un monto de Lps." 
                + monto : "Multa pendiente";
        return text;
    }
}
