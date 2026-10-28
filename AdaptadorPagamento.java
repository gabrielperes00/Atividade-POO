interface RegistradorPagamento {
    void registrar(double reais);
}

public class AdaptadorPagamento implements RegistradorPagamento {

    private final SistemaLegado legado;

    public AdaptadorPagamento(SistemaLegado legado) {
        this.legado = legado;
    }

    @Override
    public void registrar(double reais) {
        int centavos = (int) Math.round(reais * 100);
        legado.registrarEmCentavos(centavos);
    }
}
