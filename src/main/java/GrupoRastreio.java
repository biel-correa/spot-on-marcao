import java.util.List;
import java.util.UUID;

public class GrupoRastreio implements IGrupo {
    private String status = "publico";
    private List<Dispositivo> dispositivos;

    @Override
    public String convidar(String email) {
        return "e-mail enviado para" + email;
    }

    @Override
    public String gerarLink() {
        var guid = UUID.randomUUID().toString();
        return "https://gruporastreio.com/rastrear/" + guid;
    }

    @Override
    public String adicionarDispositivo(Dispositivo dispositivo) {
        if (dispositivo.getNome() == null || dispositivo.getNome().isEmpty())
            return "Nome do dispositivo não pode ser vazio";

        if (dispositivo.getDescricao() == null || dispositivo.getDescricao().isEmpty())
            return "Descrição do dispositivo não pode ser vazia";

        if (dispositivo.getLatitude() > 90 || dispositivo.getLatitude() < -90)
            return "Latitude inválida";

        if (dispositivo.getLongitude() > 180 || dispositivo.getLongitude() < -180)
            return "Longitude inválida";

        if (dispositivo.getTags() == null || dispositivo.getTags().isEmpty())
            return "Dispositivo deve ter pelo menos uma tag";

        dispositivos.add(dispositivo);
        return "Dispositivo adicionado com sucesso";
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }
}
