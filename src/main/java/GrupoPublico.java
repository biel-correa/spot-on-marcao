public class GrupoPublico extends GrupoRastreio {
    public String tornarPrivado() {
        this.setStatus("privado");
        return "Grupo tornou-se privado";
    }
}
