package persona;

public class Persona {
    private int id;
    private int dni;
    private String nombre;
    
    public Persona() {
        
    }
    
    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setID(int id) {
        this.id = id;
    }
    
    public void setDni(int dni) {
        this.dni = dni;
    }
        
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getID() {
        return id;
    }
    
    public int getDNI() {
        return dni;
    }
    
    public String getNombre() {
        return nombre;
    }
}
