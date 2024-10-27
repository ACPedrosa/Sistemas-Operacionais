# Sistemas-Operacionais: 
  ## Soma e Multiplicação de Vetores em Java com Multithreading

## Descrição
Este projeto é uma implementação em Java que realiza a soma de dois vetores de números do tipo `double` utilizando múltiplas threads. A soma é calculada de forma paralela, permitindo uma execução mais rápida, especialmente com vetores grandes. Este projeto é baseado em conceitos de programação concorrente e foi desenvolvido como parte de uma atividade acadêmica.

## Objetivos
- Realizar a soma e multiplicação entre dois vetores `C = A + B` e `C = A * B`.
- Implementar a soma para qualquer tamanho de vetor e qualquer quantidade de threads.
- Medir o tempo de execução do código.

## Estrutura do Projeto
O projeto é dividido em três classes principais:

1. **Main**: Classe principal que inicializa e preenche os vetores, instancia a classe master e executa a soma.
2. **AddVetorMaster**: Classe responsável por gerenciar as threads que realizam a soma dos vetores. Divide o trabalho entre as threads e aguarda a conclusão delas.
3. **AddVetorThread**: Classe que implementa a interface `Runnable`. Contém o código que realiza a soma de uma fatia dos vetores `A` e `B`, a partir do método `run()`.


