FUNCIÓN potenciaRapida(x : ENTERO, y : ENTERO) : ENTERO 
    SI y = 0 ENTONCES  						// O(1)
        DEVOLVER 1;  							// O(1)
    SINO SI y % 2 = 0 ENTONCES  					// O(1)
        mitad := potenciaRapida(x, y / 2);  				// O(log y)
        DEVOLVER mitad * mitad;  					// O(1)
    SINO 
        DEVOLVER x * potenciaRapida(x, y - 1);  				// O(log y)
    FINSI 
FINFUNCIÓN
