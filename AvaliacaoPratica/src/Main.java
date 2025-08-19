import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Criação do scanner para entrada de dados
        Scanner sc = new Scanner(System.in);

        // Criação de perfis
        Perfil p0 = Perfil.ADMINISTRADOR;
        Perfil p1 = Perfil.EDITOR;
        Perfil p2 = Perfil.VISUALIZADOR;
        
        // Criação de usuários administradores
        Usuario usuario0 = new Usuario("Rafael Kuhnen", "rafael.kuhnen@adm.com",    "adm123",    p0);
        //criação de usuários editores
        Usuario usuario1 = new Usuario("João Silva",    "joao.silve@editor.com",    "editor123", p1);
        Usuario usuario2 = new Usuario("Maria Oliveira","maria.oliveira@editor.com","editor456", p1);
        //criação de usuários visualizadores
        Usuario usuario3 = new Usuario("Ana Souza",     "ana.souza@visu.com",       "visu123",   p2);
        Usuario usuario4 = new Usuario("Carlos Eduardo","carlos.edu@visu.com",      "visu456",   p2);
        Usuario usuario5 = new Usuario("Magno Pinto",   "magno.pinto@visu.com",     "visu789",   p2);
        
        // Criação da lista de usuários
        ListaUsuarios listaUsers = new ListaUsuarios();
        listaUsers.adicionarUsuario(usuario0);
        listaUsers.adicionarUsuario(usuario1);
        listaUsers.adicionarUsuario(usuario2);
        listaUsers.adicionarUsuario(usuario3);
        listaUsers.adicionarUsuario(usuario4);
        listaUsers.adicionarUsuario(usuario5);

        int condition = 0;

        System.out.println("Bem vindo ao sistema de gerenciamento de usuários!\n" +
        "Informe seu email e senha para acessar o sistema.\n");

        do {
            String var = "";

            System.out.println("Email: ");
            String email = sc.nextLine().toLowerCase().trim();

            System.out.println("Senha: ");
            String senha = sc.nextLine();

            for (Usuario u : listaUsers.listaUsuarios) {
                if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                    var = "Usuário: " + u.getNome() + "\nPerfil: " + u.getPerfil();
                    condition = 1;
                    break;
                }   
            }
            if (condition == 1) {
                System.out.println("Usuário autenticado com sucesso!\n");
                System.out.println(var);
            }else{
                if (condition == 0) {
                    System.out.println("Usuário não encontrado ou senha incorreta. Tente novamente.\n");
                }
            }
            
        } while (condition == 0);
        

       

    }

    

}

