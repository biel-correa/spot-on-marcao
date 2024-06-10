import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoPrivadoTest {
    private GrupoPrivado grupoPrivado;

    @BeforeEach
    void setUp() {
        grupoPrivado = new GrupoPrivado();
    }

    @Test
    void DeveTornarPublico() {
        var result = grupoPrivado.tornarPublico();
        assertEquals("Grupo tornou-se público", result);
        assertEquals("publico", grupoPrivado.getStatus());
    }
}