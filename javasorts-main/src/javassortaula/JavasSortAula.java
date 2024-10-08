
package javassortaula;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class JavasSortAula {

    // Gera array aleatório
    public static Integer[] geraArrayAleatorio(int size, int min, int max) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min; // Gera um número aleatório entre min e max
        }
        return array;
    }

    public static void main(String[] args) {

        String path = "C:\\Users\\yagoa\\OneDrive\\Documentos\\OneDrive\\Área de Trabalho\\Faculdade\\Estrutura de Dados II\\CSV//dadosConcurso.csv";

        List<Pessoa> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            line = br.readLine();  // Pula o cabeçalho
            while (line != null) {

                String[] vect = line.split(",");
                String nome = vect[0];
                LocalDate dataNascimento = LocalDate.parse(vect[1]);
                Double nota = Double.parseDouble(vect[2]);

                Pessoa pes = new Pessoa(nome, dataNascimento, nota);
                list.add(pes);

                line = br.readLine();

            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Converte a lista para um array de pessoas
        Pessoa[] vetorPessoas = list.toArray(new Pessoa[0]);

        // Criação do comparador que ordena pela maior nota e, em caso de empate, pela data de nascimento
        Comparator<Pessoa> comparaNotaDataNascimento = (p1, p2) -> {
            // Primeiro compara pela nota (ordem decrescente)
            int comparacaoNota = p2.getNota().compareTo(p1.getNota());
            if (comparacaoNota != 0) {
                return comparacaoNota;  // Se as notas forem diferentes, retorna a comparação
            }
            // Se as notas forem iguais, compara pela data de nascimento (ordem crescente - mais velho primeiro)
            return p1.getDataNascimento().compareTo(p2.getDataNascimento());
        };

        // Aqui você pode escolher o algoritmo de ordenação que deseja usar
        InsertionSort<Pessoa> isort = new InsertionSort<>();
        isort.sort(vetorPessoas, comparaNotaDataNascimento);  // Ordena com base no comparador definido

        // Exibe o resultado
        System.out.println("Pessoas ordenadas por nota e data de nascimento:");
        for (Pessoa p : vetorPessoas) {
            System.out.println(p);
        }
    }
}
        
       


