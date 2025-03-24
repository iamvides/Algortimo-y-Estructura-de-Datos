public class OperacionesMatB<T extends Number> implements Operable<T> {
    @Override
    public T suma(T operando1, T operando2) {
        return (T) Double.valueOf(operando1.doubleValue() + operando2.doubleValue());
    }

    @Override
    public T resta(T operando1, T operando2) {
        return (T) Double.valueOf(operando1.doubleValue() - operando2.doubleValue());
    }

    @Override
    public T producto(T operando1, T operando2) {
        return (T) Double.valueOf(operando1.doubleValue() * operando2.doubleValue());
    }

    @Override
    public T division(T operando1, T operando2) {
        if (operando2.doubleValue() == 0) throw new ArithmeticException("No se puede dividir por cero");
        return (T) Double.valueOf(operando1.doubleValue() / operando2.doubleValue());
    }

    public Double potencia(T base, T exponente) {
        return Math.pow(base.doubleValue(), exponente.doubleValue());
    }

    public Double raizCuadrada(T numero) {
        return Math.sqrt(numero.doubleValue());
    }

    public Double raizCubica(T numero) {
        return Math.cbrt(numero.doubleValue());
    }
}
