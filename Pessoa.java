import java.time.LocalDate;

public class Pessoa {


//Atributos    
private String nome;
private  LocalDate dataNascimento;
    

    //Metodo construtor
    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        LocalDate dataNsc = dataNascimento;
        this.dataNascimento = dataNsc;

     }

     //Metodos Getter e Setter

     public String getNome(){
        return nome;
    

     }


     public void setNome(String nome){
        this.nome = nome;
     }

     public LocalDate getDatanascimento(){
        return dataNascimento;

     }

     public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;


     }

}