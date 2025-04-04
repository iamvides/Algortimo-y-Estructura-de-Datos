FUNCIÓN BM (v : VECTOR(ENTERO), n : ENTERO) : ENTERO 
    m := v[0];  						// O(1)
    PARA i DESDE 1 HASTA n-1 HACER  			// O(n)
        SI v[i] > m ENTONCES  					// O(1)
            m := v[i];  						// O(1)
        FINSI
    FINPARA
    DEVOLVER m; 						// O(1)
FINFUNCIÓN