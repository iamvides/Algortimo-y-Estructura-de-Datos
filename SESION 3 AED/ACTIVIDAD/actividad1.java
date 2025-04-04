//a.
PROCEDIMIENTO intercambia(REF x : ENTERO, REF y : ENTERO)
	aux : ENTERO;
	aux := x;
	x := y;
	y := aux;
FINPROCEDIMIENTO

//Propuesta de solución
PROCEDIMIENTO intercambia(REF x : ENTERO, REF y : ENTERO)
	aux : ENTERO;				//O(1)
	aux := x;				    //O(1)
	x := y;					    //O(1)
	y := aux;				    //O(1)
FINPROCEDIMIENTO

//b.
FUNCION max(x : ENTERO, y : ENTERO) : ENTERO 
    result : ENTERO; 
    SI (x >= y) ENTONCES 
        result := x; 
    SINO 
        result := y; 
    FINSI 
        DEVOLVER result; 
FINFUNCION

//Propuesta de solución
FUNCION max(x : ENTERO, y : ENTERO) : ENTERO 
    result : ENTERO; 
    SI (x >= y) ENTONCES 				//O(1)
            result := x; 				//O(1)
    SINO 
            result := y; 				//O(1)
    FINSI 
        DEVOLVER result; 				//O(1)
FINFUNCION

//c. 
FUNCION suma (v : VECTOR(ENTERO), tamaño : ENTERO) : ENTERO 
    i, result : ENTERO; 
    result := 0; 
    PARA i DESDE 0 HASTA tamaño-1 HACER 
        result := result + v[i]; 
    FINPARA 
    DEVOLVER result; 
FINFUNCION

//Propuesta de solución
FUNCION suma (v : VECTOR(ENTERO), tamaño : ENTERO) : ENTERO 
    i, result : ENTERO; 
    result := 0; 						        //O(1)
    PARA i DESDE 0 HASTA tamaño-1 HACER 		//O(n)
        result := result + v[i]; 				//O(1)
    FINPARA 
    DEVOLVER result; 					        //O(1)
FINFUNCION

//d. 
PROCEDIMIENTO ordenar(REF v : VECTOR(ENTERO), tamaño : ENTERO) 
    i, j, aux : ENTERO; 
    PARA i DESDE 0 HASTA tamaño-1 HACER 
        PARA j DESDE 0 HASTA tamaño-1 HACER 
            SI (v[j] > v[j+1] ENTONCES 
                aux := v[j]; 
                v[j] := v[j+1]; 
                v[j+1] := aux; 
            FINSI 
        INPARA 
    FINPARA 
FINPROCEDIMIENTO

//Propuesta de solución
PROCEDIMIENTO ordenar(REF v : VECTOR(ENTERO), tamaño : ENTERO) 
    i, j, aux : ENTERO; 
    PARA i DESDE 0 HASTA tamaño-1 HACER 		//O(n)
        PARA j DESDE 0 HASTA tamaño-1 HACER 	//O(n)
                SI (v[j] > v[j+1] ENTONCES 		//O(1)
                    aux := v[j]; 			    //O(1)
                    v[j] := v[j+1]; 			//O(1)
                    v[j+1] := aux; 			    //O(1)
                FINSI 
        FINPARA 
    FINPARA 
FINPROCEDIMIENTO