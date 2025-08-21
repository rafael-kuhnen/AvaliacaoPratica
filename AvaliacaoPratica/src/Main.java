import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criação do scanner para entrada de dados
        Scanner sc = new Scanner(System.in);

        // Criação de perfis
        Perfil p0 = Perfil.ADMINISTRADOR;
        Perfil p1 = Perfil.EDITOR;
        Perfil p2 = Perfil.VISUALIZADOR;

        // Criação de usuários administradores
        Usuario usuario0 = new Usuario("Rafael Kuhnen", "rafael.kuhnen@adm.com", "adm123", p0);
        // criação de usuários editores
        Usuario usuario1 = new Usuario("João Silva", "joao.silve@editor.com", "editor123", p1);
        Usuario usuario2 = new Usuario("Maria Oliveira", "maria.oliveira@editor.com", "editor456", p1);
        // criação de usuários visualizadores
        Usuario usuario3 = new Usuario("Ana Souza", "ana.souza@visu.com", "visu123", p2);
        Usuario usuario4 = new Usuario("Carlos Eduardo", "carlos.edu@visu.com", "visu456", p2);
        Usuario usuario5 = new Usuario("Magno Pinto", "magno.pinto@visu.com", "visu789", p2);

        // Criação da lista de usuários
        ListaUsuarios listaUsers = new ListaUsuarios();
        listaUsers.adicionarUsuario(usuario0);
        listaUsers.adicionarUsuario(usuario1);
        listaUsers.adicionarUsuario(usuario2);
        listaUsers.adicionarUsuario(usuario3);
        listaUsers.adicionarUsuario(usuario4);
        listaUsers.adicionarUsuario(usuario5);

        ListaDocumentos listaDocs = new ListaDocumentos();

        int funcionamento = 1;

        while (funcionamento == 1) {

            int login = 0;

            System.out.println("Bem vindo ao sistema de gerenciamento de usuários!\n" +
                    "Informe seu email e senha para acessar o sistema.\n");

            try {
                Thread.sleep(3000); // Atraso de 2 segundos (2000 milissegundos)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            limparConsole();

            Usuario temporario = new Usuario("a", "a@.com", "as", p2);

            do {
                try {
                    Thread.sleep(2000); // Atraso de 2 segundos (2000 milissegundos)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Email: ");
                String email = sc.nextLine().toLowerCase().trim();

                System.out.println("Senha: ");
                String senha = sc.nextLine();

                for (Usuario u : listaUsers.listaUsuarios) {
                    if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                        temporario.setEmail(u.getEmail());
                        temporario.setNome(u.getNome());
                        temporario.setSenha(u.getSenha());
                        temporario.setPerfil(u.getPerfil());

                        login = 1;
                        break;
                    }
                }
                if (login == 1) {
                    limparConsole();
                    System.out.println("Usuário autenticado com sucesso!\n");
                    try {
                        Thread.sleep(2000); // Atraso de 2 segundos (2000 milissegundos)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (login == 0) {
                        System.out.println("Usuário não encontrado ou senha incorreta. Tente novamente.\n");
                        try {
                            Thread.sleep(2000); // Atraso de 2 segundos (2000 milissegundos)
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            } while (login == 0);

            limparConsole();

            int acoes = 1;

            try {
                Thread.sleep(2000); // Atraso de 2 segundos (2000 milissegundos)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            do {

                if (temporario.getPerfil() == Perfil.ADMINISTRADOR) {
                    System.out.println("Bem vindo, " + temporario.getNome() + "!\n" +
                            "Seu nível de acesso é de: " + temporario.getPerfil() + "\n");
                    System.out.println("Informe a acao que deseja realizar:\n" +
                            "1 - Visualizar Documentos\n" +
                            "2 - Editar Documento\n" +
                            "3 - Criar Documento\n" +
                            "4 - Excluir Documento\n" +
                            "0 - Sair\n");
                } else if (temporario.getPerfil() == Perfil.EDITOR) {
                    System.out.println("Bem vindo, " + temporario.getNome() + "!\n" +
                            "Seu nível de acesso é de: " + temporario.getPerfil() + "\n");
                    System.out.println("Informe a acao que deseja realizar:\n" +
                            "1 - Visualizar Documentos\n" +
                            "2 - Editar Documento\n" +
                            "0 - Sair\n");
                } else if (temporario.getPerfil() == Perfil.VISUALIZADOR) {
                    System.out.println("Bem vindo, " + temporario.getNome() + "!\n" +
                            "Seu nível de acesso é de: " + temporario.getPerfil() + "\n");
                    System.out.println("Informe a acao que deseja realizar:\n" +
                            "1 - Visualizar Documentos\n" +
                            "0 - Sair\n");

                }
                int opcao = sc.nextInt();
                sc.nextLine(); // Consumir a quebra de linha pendente

                try {
                    Thread.sleep(1500); // Atraso de 2 segundos (2000 milissegundos)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                limparConsole();

                switch (opcao) {
                    case 1:
                        listaDocs.exibirDocumentos();
                        try {
                            Thread.sleep(3000); // Atraso de 2 segundos (2000 milissegundos)
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        limparConsole();
                        break;

                    case 2:
                        if (temporario.getPerfil() == Perfil.VISUALIZADOR) {
                            System.out.println("Ação não permitida para seu perfil.");
                            try {
                                Thread.sleep(3000); // Atraso de 2 segundos (2000 milissegundos)
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            limparConsole();
                            break;
                        } else {
                            System.out.println("Informe o título do documento que deseja editar: ");
                            String titulo = sc.nextLine();
                            System.out.println("\nInforme a nova descrição do documento: ");
                            String descricao = sc.nextLine();
                            listaDocs.editarDocumento(titulo, descricao);
                        }
                        try {
                            Thread.sleep(3000); // Atraso de 2 segundos (2000 milissegundos)
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        limparConsole();
                        break;

                    case 3:
                        if (temporario.getPerfil() != Perfil.ADMINISTRADOR) {
                            System.out.println("Ação não permitida para seu perfil.");
                            break;
                        } else {
                            System.out.println("Informe o título do novo documento: ");
                            String titulo = sc.nextLine();
                            System.out.println("\nInforme a descrição do novo documento: ");
                            String descricao = sc.nextLine();
                            Documento novoDoc = new Documento(titulo, descricao);
                            listaDocs.adicionarDocumento(novoDoc);
                            System.out.println("\nDocumento adicionado com sucesso.");
                        }
                        try {
                            Thread.sleep(3000); // Atraso de 2 segundos (2000 milissegundos)
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        limparConsole();
                        break;
                    case 4:
                        if (temporario.getPerfil() != Perfil.ADMINISTRADOR) {
                            System.out.println("Ação não permitida para seu perfil.");
                            break;
                        } else {
                            System.out.println("\nInforme o título do documento que deseja excluir: ");
                            String titulo = sc.nextLine();
                            Documento docParaRemover = null;
                            for (Documento doc : listaDocs.listaDocumentos) {
                                if (doc.getTitulo().equals(titulo)) {
                                    docParaRemover = doc;
                                    break;
                                }
                            }
                            if (docParaRemover != null) {
                                listaDocs.removerDocumento(docParaRemover);
                                System.out.println("\nDocumento removido com sucesso.");
                            } else {
                                System.out.println("\nDocumento com o título '" + titulo + "' não encontrado.");
                            }
                        }
                        try {
                            Thread.sleep(3000); // Atraso de 2 segundos (2000 milissegundos)
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        limparConsole();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema. Até logo!");
                        try {
                            Thread.sleep(3000); // Atraso de 2 segundos (2000 milissegundos)
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        limparConsole();
                        acoes = 0;
                        break;
                    default:
                        break;
                }

            } while (acoes == 1);

        }

        sc.close();

    }

    public static void limparConsole() {
        try {
            String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
