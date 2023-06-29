**LearnFlow**

LearnFlow é um projeto de aplicação Java que permite armazenar e gerenciar conteúdos relacionados a diferentes temas. O projeto utiliza padrões de projeto e segue a estrutura do MVC (Model-View-Controller).

---

__Padrões de Projeto Utilizados__

**Template Method**
    
    src\main\java\app\InicializadorInterface - Classe responsável pela inicialização da interface do aplicativo.
    src\main\java\view\paginas\Pagina - Classe base para as páginas do aplicativo.

**Chain of Responsibility**

    src\main\java\view\changeAppearence\ - Pacote contendo classes relacionadas à alteração de aparência da interface.

**Simple Factory**

    src\main\java\view\paginas\factory - Pacote contendo classes de fábrica relacionadas às páginas.

    src\main\java\view\telaLayout\factorys - Pacote contendo classes de fábrica relacionadas ao layout da tela.

**Facade**

    src\main\java\controller\FacadeController - Classe que atua como uma fachada para o controle das funcionalidades do aplicativo.

---

__Outros Detalhes__

- O projeto faz uso do padrão Singleton em várias classes.
- Utiliza conexão com banco de dados através do JDBC.
- O banco de dados também é implementado com o padrão Singleton.

---

__Funcionalidades__

- Armazenamento de conteúdo relacionado a diferentes temas.
- Cada conteúdo possui um tema, uma descrição e pode ter nenhum ou vários arquivos associados.
- Os arquivos são salvos como links, podendo ser do Google Drive, vídeos do YouTube ou sites de conteúdo de referência.
- Cada tema pode ter vários subtemas, com as mesmas características, sem limites.
- Exportação rápida e fácil do conteúdo para PDF.