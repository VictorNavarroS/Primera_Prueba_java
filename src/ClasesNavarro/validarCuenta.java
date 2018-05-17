
package ClasesNavarro;

public class validarCuenta extends Clientes {

   
   
    private String NumeroCuenta;
   
    public validarCuenta (String rut, String nombre, String apellido1,String apellido2,int saldoinicial, int lineaCredito) {
        super(rut, nombre, apellido1 ,apellido2, saldoinicial, lineaCredito );
        NumeroCuenta = "Desconocido";   
    } 
    public validarCuenta (String rut, String nombre, String apellido1,String apellido2, String NroCuenta, int saldoinicial, int lineaCredito) {
        super(rut, nombre, apellido1 ,apellido2, saldoinicial,lineaCredito );
        NumeroCuenta= NroCuenta;   
    }    
     public void setNCuenta (String NCuenta) { 
        this.NumeroCuenta = NCuenta;   
    }
      public String getNroCuenta () { 
        return NumeroCuenta;   
    }

    public void mostrarDatosCliente() {
        System.out.println("Cliente: "+getNombre()+""+getApellido1()+""+getApellido2()+ "\tRUT: "+getRut()+
        "\nSu Numero de Cuenta es: "+getNroCuenta()+"\tSu Saldo inicial es: "+"$"+getSaldo()+"\tSu Linea de Credito es: "+"$"+getlinea());
    }

   
}
