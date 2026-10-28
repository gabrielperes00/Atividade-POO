public interface Desconto {
    double aplicar(double valor);
}

class SemDesconto implements Desconto {

    @Override
    public double aplicar(double valor) {
        return valor;
    }
}

class DescontoEstudante implements Desconto {

    @Override
    public double aplicar(double valor) {
        return valor * 0.90;
    }
}
