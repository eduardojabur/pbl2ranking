import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static BinarySearchTree bstCompartilhada = new BinarySearchTree();

  public static void main(String[] args) {
    carregarJogadores("src/players.csv");

    BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
    int opcao = -1;

    while (opcao != 0) {
      System.out.println("\n--- MENU ---");
      System.out.println("1 - Inserir jogador");
      System.out.println("2 - Buscar jogador");
      System.out.println("3 - Remover jogador");
      System.out.println("4 - Visualizar Arvore (Interface Grafica)");
      System.out.println("0 - Sair");
      System.out.print("Opcao: ");

      try {
        String entrada = leitor.readLine();
        if (entrada == null || entrada.trim().isEmpty()) {
          continue;
        }
        opcao = Integer.parseInt(entrada.trim());

        if (opcao == 1) {
          System.out.print("Nickname: ");
          String nick = leitor.readLine();
          System.out.print("Ranking: ");
          int rank = Integer.parseInt(leitor.readLine().trim());
          bstCompartilhada.insert(new Player(nick, rank));
          System.out.println("Jogador inserido na arvore.");
        } else if (opcao == 2) {
          System.out.print("Nickname para buscar: ");
          String nick = leitor.readLine();
          if (bstCompartilhada.search(nick)) {
            System.out.println("Jogador encontrado na arvore.");
          } else {
            System.out.println("Jogador nao encontrado.");
          }
        } else if (opcao == 3) {
          System.out.print("Nickname para remover: ");
          String nick = leitor.readLine();
          if (bstCompartilhada.remove(nick) != null) {
            System.out.println("Jogador removido com sucesso.");
          } else {
            System.out.println("Jogador nao encontrado para remocao.");
          }
        } else if (opcao == 4) {
          TreeVisualizer.exibir();
        }
      } catch (IOException | NumberFormatException e) {
        System.out.println("Entrada invalida.");
      }
    }
  }

  private static void carregarJogadores(String arquivo) {
    Lista listaAux = new Lista();
    try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
      String linha = br.readLine();
      while ((linha = br.readLine()) != null) {
        listaAux.adicionar(linha);
      }
    } catch (IOException e) {
      System.out.println("Nao foi possivel carregar o ficheiro CSV.");
      return;
    }

    NoLista atual = listaAux.getFim();
    while (atual != null) {
      String[] partes = atual.getLinha().split(",");
      if (partes.length == 2) {
        String nickname = partes[0].trim();
        try {
          int ranking = Integer.parseInt(partes[1].trim());
          bstCompartilhada.insert(new Player(nickname, ranking));
        } catch (NumberFormatException ignored) {
        }
      }
      atual = atual.getAnterior();
    }
  }
}