import java.util.ArrayList;
import java.util.List;

public class ListaDocumentos {

    List<Documento> listaDocumentos;

    public ListaDocumentos() {
        listaDocumentos = new ArrayList<>();
    }

    public void adicionarDocumento(Documento documento) {
        if (documento == null) {
            throw new IllegalArgumentException("\nDocumento não pode ser nulo");
        }
        listaDocumentos.add(documento);
    }

    public void removerDocumento(Documento documento) {
        if (documento == null) {
            throw new IllegalArgumentException("\nDocumento não pode ser nulo");
        }
        listaDocumentos.remove(documento);
    }

    public void exibirDocumentos() {
        if (listaDocumentos.isEmpty()) {
            System.out.println("\nNenhum documento cadastrado.");
            return;
        }
        for (Documento documento : listaDocumentos) {
            System.out.println("\nTítulo: " + documento.getTitulo());
        }
    }
    public void exibirDocumento(String titulo) {
        for (Documento documento : listaDocumentos) {
            if (documento.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("\nTítulo: " + documento.getTitulo());
                System.out.println("\nDescrição: " + documento.getDescricao());
                return;
            }
        }
        System.out.println("\nDocumento com o título '" + titulo + "' não encontrado.");
    }

    public void editarDocumento(String titulo, String novaDescricao) {
        for (Documento documento : listaDocumentos) {
            if (documento.getTitulo().equalsIgnoreCase(titulo)) {
                documento.setDescricao(novaDescricao);
                System.out.println("\nDocumento atualizado com sucesso.");
                return;
            }
        }
        System.out.println("\nDocumento com o título '" + titulo + "' não encontrado.");
    }

}