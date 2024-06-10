public interface IGrupo {
    String getStatus();
    void setStatus(String status);
    String convidar(String email);
    String gerarLink();
    String adicionarDispositivo(Dispositivo dispositivo);
}
