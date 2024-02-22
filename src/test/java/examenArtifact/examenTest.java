package examenArtifact;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class examenTest {
	@BeforeAll
	//@Disabled	
	 void testIniciarLista() {
		// prueba que se ejecute una vez al inicio
		Examen.iniciarLista();
		assertNotNull(Examen.getPassword());
	}

	@AfterAll
	//@Disabled
	void testListaVaciaAlFinal() {
		// prueba que se ejecute una vez al final
		assertTrue(Examen.getPassword().isEmpty());
	}
	
	@BeforeEach
	//@Disabled
	void antesPrueba() {
		// prueba que se ejecute antes de cada prueba
		Examen.iniciarLista();
		Examen.rellenarLista();		
	}

	@AfterEach
	//@Disabled
	void despuesPrueba() {
		// prueba que se ejecute después de cada prueba
		Examen.getPassword().clear();
	}

	@Test
	void testImpar16() {
		// Impar 16
		assertFalse(Examen.esImpar(16));
	}
	
	@Test
    void testImpar25() {
        // Impar 25
        assertTrue(Examen.esImpar(25));
    }
	
	@Test
    void pruebaParametrizada() {
        //ComprobarCadenas
        assertAll(
                () -> assertFalse(Examen.getPassword().contains("1234")),
                () -> assertFalse(Examen.getPassword().contains("98765")),
                () -> assertFalse(Examen.getPassword().contains("5ABC"))
        );
    }
	

    @RepeatedTest(5)
    void palabraLarga() {
        // palabra mas larga
        assertNotNull(Examen.palabraMasLarga());
    }
    
    @ParameterizedTest
    @CsvSource({
            "20, 50, 10",
            "10, 100, 10",
            "20, 220, 44",
            "5, 10, 0.5"
    })
    void CalcularValorPorcentajeCSV(int porcentaje, int total, double resultadoEsperado) {
        // Prueba parametrizada 
        assertEquals(resultadoEsperado, Examen.calcularValorPorcentaje(porcentaje, total));
    }
    @Test
    void CalcularValorPorcentaje() {
    	//Prueba con valores 110,200
        assertThrows(IllegalArgumentException.class, () -> Examen.calcularValorPorcentaje(110, 200));
    }
    
}
