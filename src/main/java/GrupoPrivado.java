public class GrupoPrivado extends GrupoRastreio {
    public String tornarPublico() {
        this.setStatus("publico");
        return "Grupo tornou-se público";
    }
}
