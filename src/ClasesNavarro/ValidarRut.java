
package ClasesNavarro;


public class ValidarRut {
    String rut;
    

    public ValidarRut(String rut) {
        this.rut = rut;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String Rut) {
        this.rut = rut;
    }
    
    public boolean Validacion_rut(){
    
         Boolean lDevuelve = false;
         int Ult= this.rut.length(); 
         int Largo = this.rut.length() -3;
         int Constante = 2;
         int Suma = 0;
         int Digito = 0;
        
             for (int i= Largo; i >=0; i--){
             Suma= Suma + Integer.parseInt(this.rut.substring(i,i+1)) * Constante;
             Constante = Constante + 1 ;
             if (Constante == 8){
                 Constante =2; }
         }
         String Ultimo = this.rut.substring(Ult-1).toUpperCase();
         Digito =11 - (Suma % 11);
         if (Digito==10 && Ultimo.equals("K")){
             lDevuelve=true;
   } else 
        { 
            if(Digito == 11 && Ultimo.equals("0")){
               lDevuelve=true;    
            } 
            else
            {        
                if (Digito == Integer.parseInt(Ultimo)){
            
                 lDevuelve=true;          
        }              
        }          
}
         return lDevuelve;
    }
    
    
}
