package EstGym;

public class Membro {

    // Identificador
    private final int id;
    private final String nome;
    private boolean estaNoGinasio;

    // Limites e Constantes
    private int limiteAulasSemana;
    private int aulasFrequentadasSemana;

    private int limiteDuchasDia;
    private int duchasTomadasHoje;

    private int limiteBebidasDia;
    private int bebidasConsumidasHoje;
    private int minutoUltimaBebida;

    private int duracaoDucheMinutos;
    private int duracaoDucheExtraMinutos;
    private int duracaoPiscinaMinutos;

    public Membro(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.estaNoGinasio = false;

        this.limiteAulasSemana = limiteAulasSemana;
        this.limiteDuchasDia = limiteDuchasDia;
        this.limiteBebidasDia = limiteBebidasDia;
        this.duracaoDucheMinutos = duracaoDucheMinutos;
        this.duracaoDucheExtraMinutos = duracaoDucheExtraMinutos;
        this.duracaoPiscinaMinutos = duracaoPiscinaMinutos;

        // Contadores começam a zero
        this.aulasFrequentadasSemana = 0;
        this.duchasTomadasHoje = 0;
        this.bebidasConsumidasHoje = 0;
        this.minutoUltimaBebida = -1; // ainda não consumiu nenhuma bebida

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isEstaNoGinasio() {
        return estaNoGinasio;
    }

    public int getLimiteAulasSemana() {
        return limiteAulasSemana;
    }

    public int getAulasFrequentadasSemana() {
        return aulasFrequentadasSemana;
    }

    public int getLimiteDuchasDia() {
        return limiteDuchasDia;
    }

    public int getDuchasTomadasHoje() {
        return duchasTomadasHoje;
    }

    public int getLimiteBebidasDia() {
        return limiteBebidasDia;
    }

    public int getBebidasConsumidasHoje() {
        return bebidasConsumidasHoje;
    }

    public int getMinutoUltimaBebida() {
        return minutoUltimaBebida;
    }

    public int getDuracaoDucheMinutos() {
        return duracaoDucheMinutos;
    }

    public int getDuracaoDucheExtraMinutos() {
        return duracaoDucheExtraMinutos;
    }

    public int getDuracaoPiscinaMinutos() {
        return duracaoPiscinaMinutos;
    }

    // ================= Métodos de Gestão de Estado =================

    // Indicar que o membro entrou no ginásio.

    public void entrarGinasio() {
        this.estaNoGinasio = true;
    }

    // Indicar que o membro saiu do ginásio.
    public void sairGinasio() {
        this.estaNoGinasio = false;
    }

    // Tenta realizar uma aula. Retorna verdadeiro se o limite ainda não foi
    // atingido.
    public boolean realizarAula() {
        if (this.aulasFrequentadasSemana < this.limiteAulasSemana) {
            this.aulasFrequentadasSemana++;
            return true;
        }
        return false; // Atingiu o limite semanal
    }

    // Tenta tomar um duche. Retorna verdadeiro se o limite diário ainda não foi
    // atingido.
    public boolean tomarDuche() {
        if (this.duchasTomadasHoje < this.limiteDuchasDia) {
            this.duchasTomadasHoje++;
            return true;
        }
        return false;
    }

    // Regista o consumo de uma bebida, guardando também o minuto em que foi tomada.
    public boolean consumirBebida(int minutoAtual) {
        if (this.bebidasConsumidasHoje < this.limiteBebidasDia) {
            this.bebidasConsumidasHoje++;
            this.minutoUltimaBebida = minutoAtual;
            return true;
        }
        return false;
    }

}
