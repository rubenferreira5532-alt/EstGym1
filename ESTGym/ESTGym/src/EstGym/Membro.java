package EstGym;

import java.util.Objects;

public class Membro {

    
    private final int id;
    private final String nome;
    private boolean estaNoGinasio;

  
    private int limiteAulasSemana;
    private int aulasFrequentadasSemana;

    private int limiteDuchesDia;
    private int duchasTomadasHoje;

    private int limiteBebidasDia;
    private int bebidasConsumidasHoje;
    private int minutoUltimaBebida;

    private int duracaoDucheMinutos;
    private int duracaoDucheExtraMinutos;
    private int duracaoPiscinaMinutos;

   public Membro(int id, String nome, int limiteAulas, int limiteDuches, int limiteBebidas, 
                  int duracaoDuche, int duracaoDucheExtra, int duracaoPiscina) {
        
        if (id <= 0) {
            throw new IllegalArgumentException("O id deve ser maior que zero.");
        }
        Objects.requireNonNull(nome, "O nome não pode ser nulo.");
        if (nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser branco.");
        }

        if (limiteAulas < 0 || limiteDuches < 0 || limiteBebidas < 0) {
            throw new IllegalArgumentException("Os limites não podem ser negativos.");
        }
        if (duracaoDuche < 0 || duracaoDucheExtra < 0 || duracaoPiscina < 0) {
            throw new IllegalArgumentException("As durações não podem ser negativas.");
        }

        this.id = id;
        this.nome = nome;
        this.estaNoGinasio = false;

       
        this.limiteAulasSemana = limiteAulas;
        this.limiteDuchesDia = limiteDuches;
        this.limiteBebidasDia = limiteBebidas;
        this.duracaoDucheMinutos = duracaoDuche;
        this.duracaoDucheExtraMinutos = duracaoDucheExtra;
        this.duracaoPiscinaMinutos = duracaoPiscina;


        this.aulasFrequentadasSemana = 0;
        this.duchasTomadasHoje = 0;
        this.bebidasConsumidasHoje = 0;
        this.minutoUltimaBebida = -1; 
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

    public int getLimiteDuchesDia() {
        return limiteDuchesDia;
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


    public void entrarGinasio() {
        this.estaNoGinasio = true;
    }

    public void sairGinasio() {
        this.estaNoGinasio = false;
    }

    public boolean realizarAula() {
        if (this.aulasFrequentadasSemana < this.limiteAulasSemana) {
            this.aulasFrequentadasSemana++;
            return true;
        }
        return false; 
    }

    public boolean tomarDuche() {
        if (this.duchasTomadasHoje < this.limiteDuchesDia) {
            this.duchasTomadasHoje++;
            return true;
        }
        return false;
    }

    public boolean consumirBebida(int minutoAtual) {
        if (this.bebidasConsumidasHoje < this.limiteBebidasDia) {
            this.bebidasConsumidasHoje++;
            this.minutoUltimaBebida = minutoAtual;
            return true;
        }
        return false;
    }

}
