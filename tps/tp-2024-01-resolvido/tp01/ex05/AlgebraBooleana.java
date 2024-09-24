package tp01.ex05;

import java.util.Scanner;

/** Algebra Booleana
 * 
 * GitHub: https://github.com/Gaok1
 * 
 * @author Luis Phillip Lemos Martins
 * @since 31/08/2024
*/
public class AlgebraBooleana {

    // Método para converter uma string em um array de booleanos
    static boolean[] GetBoolMap(String frase) {
        int tamanho = Integer.parseInt(String.valueOf(frase.charAt(0))); // O primeiro caractere é o número de variáveis
        
        boolean[] arraybool = new boolean[tamanho];
        int count = 0;
        for (int i = 0; i < tamanho * 2 + 1; i++) {
            if (frase.charAt(i) == '1') {
                arraybool[count] = true;
                count++;
            } else if (frase.charAt(i) == '0') {
                arraybool[count] = false;
                count++;
            }
        }
        return arraybool;
    }

    public static void main(String[] args) {
        boolean arraybool[];
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            String frase = sc.nextLine();

            if (igual_0(frase)){
                sc.close();
                break;
            }
            
            arraybool = GetBoolMap(frase); // Retorna um array bool com quantos elementos lógicos terão e o valor
                                           // deles em bool (ex: (a,b,c) se é true ou false)
            frase = GetOperators(frase, arraybool); // Retorna nova String com os operadores substituídos por símbolos
            // para facilitar a leitura: and = ^, or = V, not = !

            frase = CalculateBooleanExpresion(frase); // Retorna a frase com as operações lógicas resolvidas
            System.out.println(frase);

        }

    }

    // Função intermediária para calcular a expressão booleana
    public static String CalculateBooleanExpresion(String frase) {
        // Preparando para chamar a função And
        int operadores = 0;

        for (int i = 0; i < frase.length(); i++) { // Loop para contar quantos operadores tem na frase
            if (frase.charAt(i) == '^' || frase.charAt(i) == 'V' || frase.charAt(i) == '!') {
                operadores++;
            }
        }

        int[] OperatorsIndex = new int[operadores]; // Criando array para guardar as posições dos operadores
        int index = 0; // Criando Index para guardar a posição dos operadores

        for (int i = frase.length() - 1; i >= 0; i--) { // Loop para guardar a posição dos operadores em index de trás
                                                        // para frente para a ordem de resolução de operações
            if (frase.charAt(i) == '^' || frase.charAt(i) == 'V' || frase.charAt(i) == '!') {
                OperatorsIndex[index] = i;
                index++;
            }
        }

        for (int i : OperatorsIndex) { // Loop para chamar as funções lógicas de acordo com a ordem de resolução de
                                       // operações (trás para frente)
            if (frase.charAt(i) == '^') {
                frase = andElement(frase, i);
            } else if (frase.charAt(i) == 'V') {
                frase = OrElement(frase, i);
            } else if (frase.charAt(i) == '!') {

                frase = notElementSingle(frase, i);
            }
        }

        return frase;
    }

    // Função para a operação lógica AND
    public static String andElement(String frase, int index) {
        StringBuilder newFrase = new StringBuilder();
        int i = 0;
        int length = frase.length();
    
        while (i < length) {
            if (i == index) {
                int count = 0;
                int positivo = 0;
                int currentIndex = index; // Criando uma variável para controlar a posição atual
    
                // Conta o número de dígitos dentro dos parênteses até o fim dos parênteses
                while (frase.charAt(currentIndex) != ')') {
                    char c = frase.charAt(currentIndex);
                    if (Character.isDigit(c)) {
                        count++;
                        if (c == '1') {
                            positivo++;
                        }
                    }
                    currentIndex++;
                }
    
                // Verifica se todos os dígitos dentro dos parênteses são '1'
                newFrase.append((positivo == count) ? '1' : '0');
    
                i = currentIndex + 1; // Atualiza a posição externa para pular os dígitos e os parênteses
            } else {
                newFrase.append(frase.charAt(i));
                i++;
            }
        }
    
        return newFrase.toString();
    }
    

    // Função para a operação lógica NOT
    public static String notElementSingle(String frase, int index) {
        StringBuilder newFrase = new StringBuilder();
        int i = 0;
        int length = frase.length();
    
        while (i < length) {
            if (i == index) {
                int count = 0;
    
                // Conta o número de dígitos dentro dos parênteses
                while (frase.charAt(index) != ')') {
                    char c = frase.charAt(index);
                    if (Character.isDigit(c)) {
                        count++;
                        newFrase.append(c == '1' ? '0' : '1'); // Troca as entradas invertendo-as
                    }
                    index++; // Atualiza o índice
                }
    
                i += count + 3; // Pula os dígitos e os parênteses
            } else {
                newFrase.append(frase.charAt(i));
                i++;
            }
        }
    
        return newFrase.toString();
    }
    

    // Função para a operação lógica OR
    public static String OrElement(String frase, int index) {
        StringBuilder newFrase = new StringBuilder();
        int i = 0;
        int length = frase.length();
    
        while (i < length) {
            if (i == index) {
                int count = 0;
                int positivo = 0;
                int currentIndex = index; // Criando uma variável para controlar a posição atual
    
                // Conta o número de dígitos dentro dos parênteses
                while (frase.charAt(currentIndex) != ')') {
                    char c = frase.charAt(currentIndex);
                    if (Character.isDigit(c)) {
                        count++;
                        if (c == '1') {
                            positivo++;
                        }
                    }
                    currentIndex++;
                }
    
                // Verifica se há dígitos nos parênteses que são positivos
                newFrase.append((positivo > 0) ? '1' : '0');
    
                i += count + 3; // Pula os dígitos e os parênteses
            } else {
                newFrase.append(frase.charAt(i));
                i++;
            }
        }
    
        return newFrase.toString();
    }
    

    // Função para limpar a string e deixá-la pronta para a leitura lógica
    public static String CleanString(String frase) {
        String newfrase = "";// String resultante
        int newindex = 0; // Index da primeira Operação (início da String utilizável para a lógica)

        // frase antes de limpar: 2 1 0 ^(!(1) , !(0))
        for (int i = 0; i < frase.length(); i++) { // Caminhando e apagando números até chegar na operação
            if (frase.charAt(i) == 'V' || frase.charAt(i) == '!' || frase.charAt(i) == '^') {
                newindex = i;
                break; // Saí do loop
            }
            if (!clear(frase.charAt(i))) { // Identifica se é um número ou um espaço ou uma vírgula
                newfrase += frase.charAt(i); // Adicionando caracteres à nova frase úteis
            }
        }

        for (int i = newindex; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ' || frase.charAt(i) == ',')
                continue; // Ignora espaços e vírgulas
            else
                newfrase += frase.charAt(i);
        }
        // frase depois de limpar: ^(!(1)!(0))
        return newfrase;
    }

    // Função para obter o valor booleano de uma expressão
    public static String getBoolValue(String frase, boolean[] arraybool) {
        String newfrase = "";
        int qtd = arraybool.length;

        for (char element : frase.toCharArray()) {
            if (element == 'A') {
                if (arraybool[0]) {
                    newfrase += '1';
                } else {
                    newfrase += '0';
                }
            } else if (element == 'B' && qtd > 1) {
                if (arraybool[1]) {
                    newfrase += '1';
                } else {
                    newfrase += '0';
                }
            } else if (element == 'C' && qtd > 2) {
                if (arraybool[2]) {
                    newfrase += '1';
                } else {
                    newfrase += '0';
                }
            } else {
                newfrase += element;
            }
        }
        return newfrase;
    }

    // Função intermediária para substituir os operadores lógicos por símbolos
    public static String GetOperators(String frase, boolean[] arraybool) {

        frase = equalsAnd(frase); // Substitui and por ^
        frase = equalsNot(frase); // Substitui not por !
        frase = equalsOr(frase);// Substitui or por V
        frase = (getBoolValue(frase, arraybool)); // Retorna String com os termos A,B,C substituídos pelos seus
                                                  // valores lógicos.
        frase = CleanString(frase); // Remove os números da entrada inicial e

        return frase;
    }

    // Método para substituir o operador NOT
    public static String equalsNot(String frase) {
        return frase.replace("not", "!");
    }
    
    // Método para substituir o operador OR
    public static String equalsOr(String frase) {
        return frase.replace("or", "V");
    }
    
    // Método para substituir o operador AND
    public static String equalsAnd(String frase) {
        return frase.replace("and", "^");
    }
    
    // Método para verificar se a frase é igual a 0
    static boolean igual_0(String frase) {
        return frase.equals("0");
    }
    
    // Método para limpar um caractere
    static boolean clear(char c) {
        return Character.isDigit(c) || c == ' ' || c == ',' || c == '.';
    }
    
    // Método para verificar se é um número
    static boolean isNumber(char c) {
        return Character.isDigit(c);
    }
}
