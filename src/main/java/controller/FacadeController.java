package controller;

import java.util.LinkedList;

import javafx.stage.Stage;
import model.ArquivosModel;
import model.TemaModel;
import model.modalList.ArquivoModelList;
import model.modalList.FavoritosModelList;
import model.modalList.TemaModelList;

/**
 * A classe FacadeController atua como uma fachada para os controladores do
 * sistema.
 * Ela fornece métodos de alto nível para acessar e controlar os diferentes
 * aspectos do sistema.
 */
public class FacadeController {

    private static FacadeController instance;

    /**
     * Obtém uma instância singleton da classe FacadeController.
     *
     * @return A instância única de FacadeController.
     */
    public synchronized static FacadeController getInstance() {
        if (instance == null) {
            instance = new FacadeController();
        }
        return instance;
    }

    private FacadeController() {
    }

    /**
     * Obtém o estágio principal do aplicativo.
     *
     * @return O estágio principal do aplicativo.
     */
    public Stage getStage() {
        return GerenteDeStage.getStage();
    }

    /**
     * Define o estágio principal do aplicativo.
     *
     * @param primaryStage O estágio principal do aplicativo.
     */
    public void setStage(Stage primaryStage) {
        GerenteDeStage.setStage(primaryStage);
    }

    /**
     * Recarrega os dados do sistema.
     * Isso inclui carregar listas de temas, favoritos e arquivos em threads
     * separadas.
     */
    public synchronized void recarregarDados() {
        LinkedList<Thread> threads = new LinkedList<>();

        Thread temas = new Thread(TemaModelList.getInstance());
        temas.start();
        threads.add(temas);

        Thread favoritos = new Thread(FavoritosModelList.getInstance());
        favoritos.start();
        threads.add(favoritos);

        Thread arquivos = new Thread(ArquivoModelList.getInstance());
        arquivos.start();
        threads.add(arquivos);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException error) {
                error.printStackTrace();
            }
        }
    }

    /**
     * Reinicializa o gerente de temas.
     * Isso redefine o estado do gerente de temas, descartando quaisquer alterações
     * não salvas.
     */
    public void reinicializarGerenteTemas() {
        GerenteDeTema.inicializar();
    }

    /**
     * Realiza o login de um usuário no sistema.
     *
     * @param email O email do usuário.
     * @param senha A senha do usuário.
     * @return true se o login for bem-sucedido, false caso contrário.
     */
    public boolean login(String email, String senha) {
        return UsuarioController.getInstance().login(email, senha);
    }

    /**
     * Realiza o logout do usuário atual.
     * Isso limpa todos os dados do usuário e redefine o estado do sistema.
     */
    public void logout() {
        GerenteDeTema.inicializar();
        TemaController.reinicializar();
        FavoritosController.reinicializar();
        UsuarioController.getInstance().logout();
    }

    /**
     * Cadastra um novo usuário no sistema.
     *
     * @param nome  O nome do usuário.
     * @param email O email do usuário.
     * @param senha A senha do usuário.
     * @return true se o cadastro for bem-sucedido, false caso contrário.
     */
    public boolean cadastrarUsuario(String nome, String email, String senha) {
        return UsuarioController.getInstance().cadastrarUsuario(email, nome, senha);
    }

    /**
     * Obtém a lista de temas principais do sistema.
     *
     * @return Uma lista encadeada de objetos TemaModel representando os temas
     *         principais.
     */
    public LinkedList<TemaModel> listaDeTemasPrincipais() {
        return GerenteDeTema.getNaoFavoritos(
                TemaController
                        .getTemasPrincipais());
    }

    /**
     * Obtém a lista de temas favoritos principais do usuário atual.
     *
     * @return Uma lista encadeada de objetos TemaModel representando os temas
     *         favoritos principais.
     */
    public LinkedList<TemaModel> listaDeTemasFavoritosPrincipais() {
        return GerenteDeTema.getFavoritos(
                TemaController
                        .getTemasPrincipais());
    }

    /**
     * Obtém a lista de subtemas de um tema principal.
     *
     * @param temaPrincipal O tema principal para o qual se deseja obter os
     *                      subtemas.
     * @return Uma lista encadeada de objetos TemaModel representando os subtemas.
     */
    public LinkedList<TemaModel> listaDeSubTemas(TemaModel temaPrincipal) {
        return GerenteDeTema.getNaoFavoritos(
                TemaController
                        .getSubTemas(temaPrincipal));
    }

    /**
     * Obtém a lista de subtemas favoritos de um tema principal.
     *
     * @param temaPrincipal O tema principal para o qual se deseja obter os subtemas
     *                      favoritos.
     * @return Uma lista encadeada de objetos TemaModel representando os subtemas
     *         favoritos.
     */
    public LinkedList<TemaModel> listaDeSubTemasFavoritos(TemaModel temaPrincipal) {
        return GerenteDeTema.getFavoritos(
                TemaController
                        .getSubTemas(temaPrincipal));
    }

    /**
     * Adiciona um tema aos favoritos do usuário atual.
     *
     * @param tema O tema a ser adicionado aos favoritos.
     * @return true se o tema foi adicionado com sucesso aos favoritos, false caso
     *         contrário.
     */
    public boolean adicionarFavorito(TemaModel tema) {
        return FavoritosController.adicionarFavorito(tema);
    }

    /**
     * Remove um tema dos favoritos do usuário atual.
     *
     * @param tema O tema a ser removido dos favoritos.
     * @return true se o tema foi removido com sucesso dos favoritos, false caso
     *         contrário.
     */
    public boolean removerFavorito(TemaModel tema) {
        return FavoritosController.removerFavorito(tema);
    }

    /**
     * Verifica se um tema está nos favoritos do usuário atual.
     *
     * @param tema O tema a ser verificado.
     * @return true se o tema estiver nos favoritos, false caso contrário.
     */
    public boolean isFavorito(TemaModel tema) {
        return FavoritosController.isFavorito(tema);
    }

    /**
     * Obtém o tema atualmente selecionado.
     *
     * @return O objeto TemaModel representando o tema selecionado.
     */
    public TemaModel getTemaSelecionado() {
        return GerenteDeTema.getTemaSelecionado();
    }

    /**
     * Define o tema selecionado.
     *
     * @param tema O tema a ser selecionado.
     */
    public void setTemaSelecionado(TemaModel tema) {
        GerenteDeTema.selecionarTema(tema);
    }

    /**
     * Volta para o tema pai do tema atualmente selecionado.
     *
     * @return true se foi possível voltar para o tema pai, false caso contrário.
     */
    public boolean voltarTema() {
        return GerenteDeTema.voltarTema();
    }

    /**
     * Adiciona um novo tema como subtema de um tema existente.
     *
     * @param idTemaPai O ID do tema pai.
     * @param nome      O nome do novo tema.
     * @return true se o tema foi adicionado com sucesso, false caso contrário.
     */
    public boolean adicionarNovoTema(Integer idTemaPai, String nome) {
        return TemaController.adicionarNovoTema(nome, idTemaPai);
    }

    /**
     * Atualiza as informações de um tema existente.
     *
     * @param tema      O tema a ser atualizado.
     * @param nome      O novo nome do tema.
     * @param descricao A nova descrição do tema.
     * @return true se o tema foi atualizado com sucesso, false caso contrário.
     */
    public boolean atualizarTema(TemaModel tema, String nome, String descricao) {
        return TemaController.atualizarTema(tema, nome, descricao);
    }

    /**
     * Remove um tema do sistema.
     *
     * @param tema O tema a ser removido.
     * @return true se o tema foi removido com sucesso, false caso contrário.
     */
    public boolean removerTema(TemaModel tema) {
        return TemaController.removerTema(tema);
    }

    /**
     * Obtém a lista de arquivos associados a um tema.
     *
     * @param tema O tema para o qual se deseja obter os arquivos.
     * @return Uma lista encadeada de objetos ArquivosModel representando os
     *         arquivos associados ao tema.
     */
    public LinkedList<ArquivosModel> getListaArquivos(TemaModel tema) {
        return ArquivosController.getListArquivos(tema);
    }

    /**
     * Adiciona um novo arquivo associado a um tema.
     *
     * @param tema O tema ao qual o arquivo será associado.
     * @param nome O nome do arquivo.
     * @param link O link do arquivo.
     * @return true se o arquivo foi adicionado com sucesso, false caso contrário.
     */
    public boolean adicionarArquivos(TemaModel tema, String nome, String link) {
        return ArquivosController.adicionarArquivo(tema, nome, link);
    }

    /**
     * Remove um arquivo associado a um tema.
     *
     * @param arquivosModel O objeto ArquivosModel representando o arquivo a ser
     *                      removido.
     * @return true se o arquivo foi removido com sucesso, false caso contrário.
     */
    public boolean removerArquivo(ArquivosModel arquivosModel) {
        return ArquivosController.removerArquivo(arquivosModel);
    }

    /**
     * Atualiza as informações de um arquivo associado a um tema.
     *
     * @param arquivosModel O objeto ArquivosModel representando o arquivo a ser
     *                      atualizado.
     * @param nome          O novo nome do arquivo.
     * @param link          O novo link do arquivo.
     * @return true se o arquivo foi atualizado com sucesso, false caso contrário.
     */
    public boolean atualizarArquivo(ArquivosModel arquivosModel, String nome, String link) {
        return ArquivosController.atualizarArquivo(arquivosModel, nome, link);
    }

    /**
     * Exporta um tema para um arquivo PDF.
     * 
     * @param tema O tema a ser exportado.
     */
    public void exportPDF(TemaModel tema) {
        ExportController.criarPDF(tema);
    }

}
