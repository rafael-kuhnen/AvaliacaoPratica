import java.util.ArrayList;
import java.util.List;

public class ListaUsuarios {
    
    List<Usuario> listaUsuarios;

    public ListaUsuarios() {
       listaUsuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        listaUsuarios.add(usuario);
    }

    public void exibirUsuarios() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        for (Usuario usuario : listaUsuarios) {
            System.out.println(usuario);
        }
    }

    
}
