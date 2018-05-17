package navarro_modulo_2101_tf;
import java.util.Scanner;
import java.util.ArrayList;
import ClasesNavarro.Clientes;
import ClasesNavarro.ValidarRut;
import ClasesNavarro.validarCuenta;

public class Navarro_Modulo_2101_TF {
static ArrayList<Clientes> ClientesNuevos = new ArrayList<>();
static Scanner dato = new Scanner(System.in);
static int seleccion;
static int sel; 
static String yaescliente;
 
static int saldoinicial;

    public static void main(String[] args) {
        
boolean aux;
boolean exit=false;
boolean salir=false;
do{    
    do{
    aux= false;
    System.out.println("¡¡Bienvenido!!");
    System.out.println("Por Favor Seleccione su opcion"); 
    System.out.println("1.- Crear Cuenta Nueva"); 
    System.out.println("2.- Ya Poseo una Cuenta"); 
    System.out.println("3.- Salir"); 
    System.out.printf("Seleccion: "); 
    String A = dato.next();
    try {sel = Integer.parseInt(A);
    }catch(Exception ex){}
    if ((sel >0)&&(sel<4)){
    switch (sel){
        case 1:
            CrearCuenta(); aux= true;  break;
        case 2:  
            int contador=0; 
            do{
            seleccion=0;            
            if (contador<3){    
                System.out.printf("Por Favor Ingrese su Numero de Cuenta: ");             
                String cuenta = dato.next();            
                if (cuenta.equals(yaescliente)){  
                do{
                System.out.println("En este programa podra: ");
                System.out.println("1.- Transferir desde su Cuenta");    
                System.out.println("2.- Girar Dinero desde su Cuenta");    
                System.out.println("3.- Abonar Dinero a su Cuenta");   
                 
                System.out.printf("Por Favor Seleccione su opcion: "); 
                String letra = dato.next();
                try {
                  seleccion = Integer.parseInt(letra);
                }catch(Exception ex){}
                    if ((seleccion >0)&&(seleccion <4)){
                    switch(seleccion){
                        case 1: 
                            Transferir(); aux= true; break;
                        case 2: 
                            Girar(); aux= true; break;
                        case 3: 
                           Abonar(); aux= true; break;                                                    }                        
                    }else {
                         System.out.println("INGRESE UNA OPCION VALIDA");                         
                          }           
              }while (!aux);
              }else {
                 System.out.println("INGRESE UNA CUENTA VALIDA");
                 contador=contador+1;
                  }
            }else{
                System.out.println("AGOTADOS SUS INTENTOS"); aux=true;
            }           
            }while(!aux); aux=true; salir=false; break;
        case 3: 
            System.out.println("¡¡¡¡¡Que tenga un buen dia!!!!!");
            aux=true; exit=true; salir=true; break;                        
        
    }
    }else{
    System.out.println("INGRESE UNA OPCION VALIDA");
    }
        }while(!aux);    
    do{
        if(salir==false){
        System.out.printf("Desea realizar alguna otra operacion? S/N:  "); 
        String opcion = dato.next();
        opcion = opcion.toUpperCase();        
        switch (opcion){
            case "N":
                    System.out.println("¡¡¡¡¡¡¡¡Gracias por operar con nosotros!!!!!!!!!!"); 
                    exit = true; salir=true; break;
            case "S":        
                    System.out.println("Continue con su operacion"); 
                    System.out.println("");
                    salir = true; break;                 
            default:
                    System.out.println("INGRESE UNA OPCION VALIDA (S/N)"); 
                        }
    }else{}
    }while (!salir);
}while(!exit);
}
    private static void CrearCuenta() {        
        
        boolean aux= false;        
        System.out.println("Bienvenido a Creacion de Cuenta Nueva");      
        do{
        String rut;
        System.out.println("Ingrese su RUT con guion y  digito verificador");        
        ValidarRut Validacion;         
        System.out.print("Ingrese el RUT a Validar: ");
        rut = dato.next();
         Validacion = new ValidarRut(rut);
         if (Validacion.Validacion_rut() == true){
            System.out.printf("Ingrese su Nombre: ");
            String Nombre= dato.next();
            System.out.printf("Ingrese su Primer Apellido: ");
            String Apellido1= dato.next();
            System.out.printf("Ingrese su Segundo Apellido: ");
            String Apellido2= dato.next();  
            boolean aux1=false;
            do{                           
            System.out.printf("Ingrese su Saldo Inicial: ");
            String saldo= dato.next(); 
            try {
            saldoinicial = Integer.parseInt(saldo);
            aux1=true;
            }catch(Exception ex){
                System.out.println("INGRESE UN VALOR NUMERICO");
            }            
            }while(!aux1);            
            int lineaCredito= (saldoinicial*15)/100;
            validarCuenta cliente1 = new validarCuenta(rut, Nombre, Apellido1, Apellido2, saldoinicial, lineaCredito);
            cliente1.setNCuenta(rut+"A");
            ClientesNuevos.add(cliente1);   
            cliente1.mostrarDatosCliente();
            aux=true;
           yaescliente = (rut+"A");
         }else{
             System.out.println("INGRESE UN RUT VALIDO");
         }
        }while(!aux);
    }

    private static void Transferir() {
      System.out.println("Bienvenido en esta opcion podra transferir fondos de una cuenta a otra");
        System.out.println("NO SUPE COMO HACERLO PROFE u.u");
    }

    private static void Girar(){
      System.out.println("Bienvenido!! En esta opcion podra girar fondos de su cuenta;");
      boolean sal=false;
      do{
      for (int i = 0; i < ClientesNuevos.size(); i++) {
     int cuenta = ClientesNuevos.get(i).getSaldo();
     int linea = ClientesNuevos.get(i).getlinea();
     String rut = ClientesNuevos.get(i).getRut();
     String nombre = ClientesNuevos.get(i).getNombre();
     String apellido1 = ClientesNuevos.get(i).getApellido1();
     String apellido2 = ClientesNuevos.get(i).getApellido2();
     System.out.println("Su Saldo Actual es: "+"$"+cuenta);
     if(cuenta>0){
     System.out.printf("Desea Girar Dinero de su cuenta?(S/N): ");
     String A=dato.next();
     A=A.toUpperCase();
     switch(A){
        case "S":             
                System.out.println("Monto Maximo de Giro: "+"$"+cuenta);
                do{
                System.out.printf("Cuanto desea girar?: ");
                String giro=dato.next();
                try {
                  int monto = Integer.parseInt(giro);
                  int SaldoActual=cuenta-monto;
                    System.out.println("Usted Giro "+"$"+monto+" Exitosamente");
                    System.out.println("Su Nuevo Saldo es: "+"$"+SaldoActual);
                    validarCuenta cliente1 = new validarCuenta(rut, nombre, apellido1, apellido2, SaldoActual, linea); 
                    cliente1.setSaldo(SaldoActual);
                  sal=true; break;
                }catch(Exception ex){
                    System.out.println("INGRESE UN MONTO VALIDO");
                }  
                }while(!sal);
                break;
        case "N": 
                System.out.println("Gracias por preferirnos!!!"); sal=true; break;
        default:
                    System.out.println("INGRESE UNA OPCION VALIDA (S/N)"); 
     }      
     }else{
         System.out.println("No tiene suficientes fondos para Girar"); sal=true;         
     }      
      }
      
    }while(!sal);
    }
    private static void Abonar() {
      System.out.println("Bienvenido!! En esta opcion podra Abonar fondos a su cuenta;");
      boolean sal=false;
      do{
      for (int i = 0; i < ClientesNuevos.size(); i++) {
     int cuenta = ClientesNuevos.get(i).getSaldo();
     int linea = ClientesNuevos.get(i).getlinea();
     String rut = ClientesNuevos.get(i).getRut();
     String nombre = ClientesNuevos.get(i).getNombre();
     String apellido1 = ClientesNuevos.get(i).getApellido1();
     String apellido2 = ClientesNuevos.get(i).getApellido2();
     System.out.println("Su Saldo Actual es: "+"$"+cuenta);
     if(cuenta>0){
     System.out.printf("Desea Abonar Dinero a su cuenta?(S/N): ");
     String A=dato.next();
     A=A.toUpperCase();
     switch(A){
        case "S":             
                System.out.println("Monto Minimo de Abono: $500");                
                do{
                System.out.printf("Cuanto desea Abonar: ?");
                String abono=dato.next();                
                try {
                  int monto = Integer.parseInt(abono);
                  if (monto>=500){
                  int SaldoActual=cuenta+monto;
                    System.out.println("Usted Abono "+"$"+monto+" Exitosamente");
                    System.out.println("Su Nuevo Saldo es: "+"$"+SaldoActual);
                    validarCuenta cliente1 = new validarCuenta(rut, nombre, apellido1, apellido2, SaldoActual, linea); 
                    cliente1.setSaldo(SaldoActual);
                  sal=true; break;
                  }else{
                      System.out.println("Ingrese un valor mayor a $500");
                  }
                }catch(Exception ex){
                    System.out.println("INGRESE UN MONTO VALIDO");
                }  
                }while(!sal);
                break;
        case "N": 
                System.out.println("Gracias por preferirnos!!!"); sal=true; break;
        default:
                    System.out.println("INGRESE UNA OPCION VALIDA (S/N)"); 
     }      
     }else{
         System.out.println("No tiene suficientes fondos para Girar"); sal=true;         
     }      
      }
      
    }while(!sal);
    }
    

    



   
    
}
