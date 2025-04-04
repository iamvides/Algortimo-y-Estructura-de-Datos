FUNCIÓN ConteoI (v : VECTOR(ENTERO), n : ENTERO) : ENTERO 
    conteo := 0;  						// O(1)
    PARA i DESDE 0 HASTA n-2 HACER  			// O(n)
        PARA j DESDE i+1 HASTA n-1 HACER  			// O(n)
            SI v[i] = v[j] ENTONCES  				// O(1)
                conteo := conteo + 1;  				// O(1)
            FINSI
        FINPARA
    FINPARA
    DEVOLVER conteo;  					// O(1)
FINFUNCIÓN
