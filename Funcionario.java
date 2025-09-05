import java.math.BigDecimal;
import java.time.LocalDate;


 public class Funcionario extends Pessoa {
    //Atributos
    private BigDecimal salario;
    private String funcao;
    //Metodo construtor com super para herdar da classe mãe
    public Funcionario (String nome, LocalDate dataNascimento, BigDecimal salario, String funcao){
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;


    }
 

    //Metodos Getter e Setter
    public BigDecimal getSalario(){
        return salario;

    }
 
    public void setSalario(BigDecimal salario){
        this.salario = salario;
    }

    public String getFuncao(){
        return funcao;

    }

    public void setFuncao(String funcao){
        this.funcao = funcao;
    }



}