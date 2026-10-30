package EstGym;

import java.util.Objects;

public abstract class Equipamento {

    protected String nome;
    protected boolean estaocupada;
    protected int minutosparafinalizacaodaocupacao; // é protected para as subclasses porta e assim acederem.



    public Equipamento(String nome, boolean estaocupada , int minutosparafinalizacaodaocupacao) {
        
        Objects.requireNonNull(nome);
         if (nome.isBlank()) {
            throw new IllegalArgumentException("O nome do equipamento não pode ser branco.");
        }

        this.estaocupada = false;
        this.minutosparafinalizacaodaocupacao = 0;
           
    }

    public String getNome() {
        return nome;
    }
    public boolean isEstaocupada() {
        return estaocupada;
    }

    public int getMinutosparafinalizacaodaocupacao() {
        return minutosparafinalizacaodaocupacao;
    }

    public void ocupada(){
        this.estaocupada = true;
    }

    public void desocupada(){
        this.estaocupada = false;
    }

    public void atualizarOcupacao(int RelogioMinutoAtual) {
        if(this.estaocupada==true && RelogioMinutoAtual >= this.minutosparafinalizacaodaocupacao) {
            this.desocupada();
        }

    public abstract void validarAcesso(Membro membro, int RelogioMinutoAtual);

    public abstract void iniciarUso(Membro membro, int RelogioMinutoAtual);
    
       }
            
  }
           

