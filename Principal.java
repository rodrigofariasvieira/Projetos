import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


        


public class Principal {

        //formatar salário
        private static String formatarSalario(BigDecimal salario){
            NumberFormat formatadorsal = NumberFormat.getInstance(new Locale("pt", "BR"));
            return formatadorsal.format(salario);
        }

        //Funcao para impressão para facilitar as edições
        private static void imprimirFuncionarios(List<Funcionario> funcionarios, DateTimeFormatter formatador, String titulo) {
        System.out.println("\n=== " + titulo + " ===");
        System.out.printf("%-10s %-12s %-15s %-15s%n", "NOME", "DATA NASC.", "SALÁRIO", "FUNÇÃO");
        System.out.println("-------------------------------------------------------------");
        
        for (Funcionario f : funcionarios) {
            String dataFormatada = f.getDatanascimento().format(formatador);    
            String salarioFormatado = formatarSalario(f.getSalario());
            System.out.printf("%-10s %-12s %-15s %-15s%n", 
                f.getNome(), dataFormatada, salarioFormatado, f.getFuncao());
        }
    }    

    public static void main(String[] args) {
        //Adicionar as informações na ordem solicitada
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 03, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.44"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
        //formatar data
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        imprimirFuncionarios(funcionarios, formatador, "Lista padrão");
        
    

       //Laço para imprimir a lista com 10% de
       
        for (Funcionario f: funcionarios){
        BigDecimal novoSalario = f.getSalario().multiply(new BigDecimal("1.10"));
        f.setSalario(novoSalario);
        
        
       
        }

        imprimirFuncionarios(funcionarios, formatador, "Funcionarios com 10%");
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();
for (Funcionario f : funcionarios) {
    funcionariosPorFuncao.computeIfAbsent(f.getFuncao(), k -> new ArrayList<>()).add(f);
}

System.out.println("Funcionarios agrupador por função");
    //agrupar em map 
    for (String funcao : funcionariosPorFuncao.keySet()) {
    System.out.println("\n--- " + funcao + " ---");
    //impressão dos funcionarios agrupados
    for (Funcionario f : funcionariosPorFuncao.get(funcao)) {
    System.out.println(f.getNome());
    }
}
    //Aniversariantes dos meses 10 e 12
    System.out.println("\n====Aniversariantes mes 10 e 12====");
    for (Funcionario f : funcionarios) {
    int mes = f.getDatanascimento().getMonthValue();
    if (mes == 10 || mes == 12) {
        String dataFormatada = f.getDatanascimento().format(formatador);
        System.out.println(f.getNome() + " - " + dataFormatada);
    }
}


    // Funcionário mais velho
    System.out.println("\n===Funcionario mais velho===");
    Funcionario maisVelho = Collections.min(funcionarios, Comparator.comparing(Funcionario::getDatanascimento));
    int idade = LocalDate.now().getYear() - maisVelho.getDatanascimento().getYear();
    System.out.println("Nome: " + maisVelho.getNome() + ", Idade: " + idade + " anos");

    //Impressão em ordem alfabetica
    funcionarios.sort(Comparator.comparing(Funcionario::getNome));
    imprimirFuncionarios(funcionarios, formatador, "Funcionarios ordenados em ordem alfabetica");

    System.out.println("\n===Total de salário===");
    BigDecimal total = BigDecimal.ZERO;
    for (Funcionario f : funcionarios) {
    total = total.add(f.getSalario());
}
    System.out.println("Total: " + formatarSalario(total));

    //Salarios mínimos
    System.out.println("\n===Salarios mínimos===");
    BigDecimal salarioMinimo = new BigDecimal("1212.00");
    for (Funcionario f : funcionarios) {
    BigDecimal qtdSalariosMinimos = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
    System.out.println(f.getNome() + ": " + qtdSalariosMinimos + " salários mínimos");
}

    }

    
    
}
