public interface Operable<E> {
    E suma(E operando1, E operando2);
    E resta(E operando1, E operando2);
    E producto(E operando1, E operando2);
    E division(E operando1, E operando2);
    E potencia(E base, int exponente);
    E raizCuadrada(E operando);
    E raizCubica(E operando);
}