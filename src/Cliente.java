public class Cliente {

    private String rut;

    private String nombreCompleto;

    private String correoElectronico;

    public Cliente(String rut, String nombreCompleto, String correoElectronico) {
        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
    }


    public String getRut() {
        return rut;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }
}
