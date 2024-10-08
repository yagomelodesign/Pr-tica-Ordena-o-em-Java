
package javassortaula;

import java.time.LocalDate;

public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private LocalDate dataNascimento;
    private Double nota;
    
    public Pessoa(String nome, LocalDate dataNasc, Double nota){
        super();
        this.nome = nome;
        this.dataNascimento = dataNasc;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
    
    
    
    @Override
    public String toString(){
        return this.nome + " :" 
                + this.dataNascimento;
    }
    
    @Override
    public int compareTo(Pessoa outraPessoa){
        int comparaNome = this.nome.compareTo(outraPessoa.getNome());
        if(comparaNome==0)// nomes iguais
            return this.dataNascimento.compareTo(outraPessoa.getDataNascimento());
        
        return comparaNome;
    }
    
}
