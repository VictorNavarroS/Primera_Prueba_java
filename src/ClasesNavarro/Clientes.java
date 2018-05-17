package ClasesNavarro;

public class Clientes {

    private String rut;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int SaldoInicial;
    private int LineaCredito;
  
 public Clientes (String rut, String nombre, String apellido1, String apellido2, int saldoinicial, int lineaCredito) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;       
        this.SaldoInicial= saldoinicial;
        this.LineaCredito= lineaCredito;
    }
 
    public String getRut () { 
        return rut;   
    }    
    public String getNombre () { 
        return nombre;  
    }
    public String getApellido1 () { 
        return apellido1;  
    }
    public String getApellido2 () { 
        return apellido2;  
    }   
    public int getSaldo () { 
        return SaldoInicial;  
    }
    public int getlinea () { 
        return LineaCredito;  
    }
    public void setSaldo (int SaldoActual) { 
        this.SaldoInicial = SaldoActual;
    }



   
 }