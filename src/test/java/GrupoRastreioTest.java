import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrupoRastreioTest {
    private GrupoRastreio grupoRastreio;

    @BeforeEach
    void setUp() {
        grupoRastreio = new GrupoRastreio();
    }

    @Test
    void DeveConvidar() {
        var email = "test@test.com";
        var result = grupoRastreio.convidar(email);
        assertEquals("e-mail enviado para" + email, result);
    }

    @Test
    void DeveGerarLink() {
        var result = grupoRastreio.gerarLink();
        assertTrue(result.startsWith("https://gruporastreio.com/rastrear/"));
    }

    @Test
    void DeveFalharAoAdicionarDispositivoComNomeNulo() {
        var dispositivo = new Dispositivo();
        dispositivo.setDescricao("Descrição");
        dispositivo.setLatitude(0);
        dispositivo.setLongitude(0);
        dispositivo.setTags(List.of(new Tag("Entrega", "Entrega dos correios", "#FF0000")));
        var result = grupoRastreio.adicionarDispositivo(dispositivo);
        assertEquals("Nome do dispositivo não pode ser vazio", result);
    }

    @Test
    void DeveFalharAoAdicionarDispositivoComNomeVazio() {
        var dispositivo = new Dispositivo();
        dispositivo.setNome("");
        dispositivo.setDescricao("Descrição");
        dispositivo.setLatitude(0);
        dispositivo.setLongitude(0);
        dispositivo.setTags(List.of(new Tag("Entrega", "Entrega dos correios", "#FF0000")));
        var result = grupoRastreio.adicionarDispositivo(dispositivo);
        assertEquals("Nome do dispositivo não pode ser vazio", result);
    }

    @Test
    void DeveFalharAoAdicionarDispositivoComDescricaoNula() {
        var dispositivo = new Dispositivo();
        dispositivo.setNome("Nome");
        dispositivo.setLatitude(0);
        dispositivo.setLongitude(0);
        dispositivo.setTags(List.of(new Tag("Entrega", "Entrega dos correios", "#FF0000")));
        var result = grupoRastreio.adicionarDispositivo(dispositivo);
        assertEquals("Descrição do dispositivo não pode ser vazia", result);
    }

    @Test
    void DeveFalharAoAdicionarDispositivoComDescricaoVazia() {
        var dispositivo = new Dispositivo();
        dispositivo.setNome("Nome");
        dispositivo.setDescricao("");
        dispositivo.setLatitude(0);
        dispositivo.setLongitude(0);
        dispositivo.setTags(List.of(new Tag("Entrega", "Entrega dos correios", "#FF0000")));
        var result = grupoRastreio.adicionarDispositivo(dispositivo);
        assertEquals("Descrição do dispositivo não pode ser vazia", result);
    }

    @Test
    void DeveFalharAoAdicionarDispositivoComLatitudeMaiorQue90() {
        var dispositivo = new Dispositivo();
        dispositivo.setNome("Nome");
        dispositivo.setDescricao("Descrição");
        dispositivo.setLatitude(91);
        dispositivo.setLongitude(0);
        dispositivo.setTags(List.of(new Tag("Entrega", "Entrega dos correios", "#FF0000")));
        var result = grupoRastreio.adicionarDispositivo(dispositivo);
        assertEquals("Latitude inválida", result);
    }

    @Test
    void DeveFalharAoAdicionarDispositivoComLatitudeMenorQueMenos90() {
        var dispositivo = new Dispositivo();
        dispositivo.setNome("Nome");
        dispositivo.setDescricao("Descrição");
        dispositivo.setLatitude(-91);
        dispositivo.setLongitude(0);
        dispositivo.setTags(List.of(new Tag("Entrega", "Entrega dos correios", "#FF0000")));
        var result = grupoRastreio.adicionarDispositivo(dispositivo);
        assertEquals("Latitude inválida", result);
    }

    @Test
    void DeveFalharAoAdicionarDispositivoComLongitudeMaiorQue180() {
        var dispositivo = new Dispositivo();
        dispositivo.setNome("Nome");
        dispositivo.setDescricao("Descrição");
        dispositivo.setLatitude(0);
        dispositivo.setLongitude(181);
        dispositivo.setTags(List.of(new Tag("Entrega", "Entrega dos correios", "#FF0000")));
        var result = grupoRastreio.adicionarDispositivo(dispositivo);
        assertEquals("Longitude inválida", result);
    }

    @Test
    void DeveFalharAoAdicionarDispositivoComLongitudeMenorQueMenos180() {
        var dispositivo = new Dispositivo();
        dispositivo.setNome("Nome");
        dispositivo.setDescricao("Descrição");
        dispositivo.setLatitude(0);
        dispositivo.setLongitude(-181);
        dispositivo.setTags(List.of(new Tag("Entrega", "Entrega dos correios", "#FF0000")));
        var result = grupoRastreio.adicionarDispositivo(dispositivo);
        assertEquals("Longitude inválida", result);
    }

    @Test
    void DeveFalharAoAdicionarDispositivoSemTags() {
        var dispositivo = new Dispositivo();
        dispositivo.setNome("Nome");
        dispositivo.setDescricao("Descrição");
        dispositivo.setLatitude(0);
        dispositivo.setLongitude(0);
        var result = grupoRastreio.adicionarDispositivo(dispositivo);
        assertEquals("Dispositivo deve ter pelo menos uma tag", result);
    }

    @Test
    void DeveFalharAoAdicionarDispositivoComTagsVazia() {
        var dispositivo = new Dispositivo();
        dispositivo.setNome("Nome");
        dispositivo.setDescricao("Descrição");
        dispositivo.setLatitude(0);
        dispositivo.setLongitude(0);
        dispositivo.setTags(List.of());
        var result = grupoRastreio.adicionarDispositivo(dispositivo);
        assertEquals("Dispositivo deve ter pelo menos uma tag", result);
    }

    @Test
    void DeveAdicionarDispositivo() {
        var dispositivo = new Dispositivo();
        dispositivo.setNome("Nome");
        dispositivo.setDescricao("Descrição");
        dispositivo.setLatitude(0);
        dispositivo.setLongitude(0);
        dispositivo.setTags(List.of(new Tag("Entrega", "Entrega dos correios", "#FF0000")));
        var result = grupoRastreio.adicionarDispositivo(dispositivo);
        assertEquals("Dispositivo adicionado com sucesso", result);
        assertEquals(dispositivo, grupoRastreio.getDispositivos().get(0));
    }
}