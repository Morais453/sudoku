package tabuleiro;

public enum Mensagem {

    /**
     * Retorno usado no método {@link Validator#isValid(String[][], int, String, int)}.
     *
     * Indica que a validação falhou por violação na coluna (validação vertical).
     *
     * Tipo: Enum constante
     * Parâmetros:
     *   - valor: {@code false}
     *   - descricao: "Verifique a vertical do número escolhido e o local a ser inserido"
     * Retorno no método: Quando {@code verticalValidator} retorna {@code false}
     */
    VerticalFalse(false, "Verifique a vertical do número escolhido e o local a ser inserido"),
    /**
     * Retorno usado no método {@link Validator#isValid(String[][], int, String, int)}.
     *
     * Indica que a validação falhou por violação na linha (validação horizontal).
     *
     * Tipo: Enum constante
     * Parâmetros:
     *   - valor: {@code false}
     *   - descricao: "Verifique a horizontal do número escolhido e o local a ser inserido"
     * Retorno no método: Quando {@code horizontalValidator} retorna {@code false}
     */
    HorizontalFalse(false,"Verifique a horizontal do número escolhido e o local a ser inserido"),
    /**
     * Retorno usado no método {@link Validator#isValid(String[][], int, String, int)}.
     *
     * Indica que a validação falhou por violação no bloco 3x3 correspondente.
     *
     * Tipo: Enum constante
     * Parâmetros:
     *   - valor: {@code false}
     *   - descricao: "Verifique o bloco do número escolhido e o local a ser inserido"
     * Retorno no método: Quando {@code blockValidator} retorna {@code false}
     */
    BlocoFalse(false,"Verifique o bloco do número escolhido e o local a ser inserido"),
    /**
     * Retorno usado no método {@link Validator#isValid(String[][], int, String, int)}.
     *
     * Indica que a validação foi bem-sucedida e o valor pode ser inserido.
     *
     * Tipo: Enum constante
     * Parâmetros:
     *   - valor: {@code true}
     *   - descricao: "Inserção de valor validada com sucesso"
     * Retorno no método: Quando todas as validações retornam {@code true}
     */
    ValidationTrue(true, "Inserção de valor validada com sucesso"),;

    private final boolean valor;
    private final String descricao;

    public boolean isValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    Mensagem(boolean valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }
}
