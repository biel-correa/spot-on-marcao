import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoPublicoTest {
    private GrupoPublico grupoPublico;

    @BeforeEach
    void setUp() {
        grupoPublico = new GrupoPublico();
    }

    @Test
    void DeveTornarPrivado() {
        var result = grupoPublico.tornarPrivado();
        assertEquals("Grupo tornou-se privado", result);
        assertEquals("privado", grupoPublico.getStatus());
    }
}