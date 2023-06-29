package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import controller.ArquivosController;
import controller.FacadeController;
import controller.TemaController;
import javafx.stage.DirectoryChooser;
import model.ArquivosModel;
import model.TemaModel;
import view.mensagens.DialogView;

/**
 * A classe PDFExport é responsável por exportar os dados de um tema para um
 * arquivo PDF.
 */
public class PDFExport {

    private TemaModel tema;

    /**
     * Cria uma nova instância de PDFExport com o tema fornecido.
     *
     * @param tema o tema a ser exportado para PDF
     */
    public PDFExport(TemaModel tema) {
        this.tema = tema;
    }

    /**
     * Executa a exportação do tema para um arquivo PDF.
     */
    public void run() {
        Document pdf = createDocument(selectDiretory());
        if (pdf != null) {
            addSumario(pdf);
            addConteudo(pdf);
            pdf.close();
        }
        DialogView.exibirMensagem("Learn Flow", "PDF Criado.");
    }

    /**
     * Abre um seletor de diretório para permitir que o usuário escolha o local de
     * destino do arquivo PDF.
     *
     * @return o diretório selecionado pelo usuário
     */
    public synchronized String selectDiretory() {
        // Criação do seletor de diretório
        DirectoryChooser directoryChooser = new DirectoryChooser();
        String userHomeDirectory = System.getProperty("user.home");
        String documentsPath = userHomeDirectory + "/Documents";
        directoryChooser.setInitialDirectory(new File(documentsPath));

        // Configuração do título da janela de seleção
        directoryChooser.setTitle("Selecionar diretório");

        // Mostrar a janela de seleção de diretório
        File selectedDirectory = directoryChooser.showDialog(FacadeController.getInstance().getStage());

        if (selectedDirectory != null) {
            // Obter o diretório selecionado pelo usuário
            return selectedDirectory.getAbsolutePath();
        } else {
            return null;
        }
    }

    /**
     * Cria um novo documento PDF com o diretório fornecido.
     *
     * @param diretorio o diretório de destino do arquivo PDF
     * @return o documento PDF criado
     */
    public Document createDocument(String diretorio) {
        try {
            // Criação do documento
            Document document = new Document();
            int i = 0;
            document.setPageCount(i);
            PdfWriter.getInstance(document,
                    new FileOutputStream(diretorio + "/learn_Flow_" + tema.getNome().replace(" ", "_") + ".pdf"));
            // Abertura do documento
            document.open();

            // Cabeçalho do documento
            Paragraph nomeApp = new Paragraph("Learn Flow", new Font(Font.FontFamily.COURIER, 30, Font.BOLD));
            nomeApp.setAlignment(Element.ALIGN_CENTER);
            document.add(nomeApp);

            Image imagem = Image.getInstance("src/main/resources/img/icon.png");
            imagem.setAbsolutePosition(150, 300);
            imagem.scaleToFit(300, 300);
            document.add(imagem);

            Paragraph topfrase = new Paragraph("O conhecimento transforma vidas e vidas tranforma o mundo!");
            topfrase.setAlignment(Element.ALIGN_CENTER);
            document.add(topfrase);

            return document;
        } catch (DocumentException | IOException e) {
            return null;
        }
    }

    /**
     * Adiciona o sumário ao documento PDF.
     *
     * @param pdf o documento PDF
     */
    public void addSumario(Document pdf) {
        try {
            pdf.newPage();
            Paragraph sumario = new Paragraph("Sumário", new Font(Font.FontFamily.COURIER));
            sumario.setAlignment(Element.ALIGN_CENTER);
            pdf.add(sumario);
            pdf.add(new Paragraph(" "));

            Paragraph titulo = new Paragraph("Tópicos", new Font(Font.FontFamily.COURIER));
            titulo.setAlignment(Element.ALIGN_CENTER);
            pdf.add(titulo);
            pdf.add(new Paragraph(" "));

            Paragraph principal = new Paragraph(tema.getNome(), new Font(Font.FontFamily.COURIER));
            principal.setAlignment(Element.ALIGN_CENTER);
            pdf.add(principal);
            pdf.add(new Paragraph(" "));

            recursiveSumario(pdf, tema);
        } catch (DocumentException error) {
            error.printStackTrace();
        }
    }

    /**
     * Adiciona os tópicos recursivamente ao sumário.
     *
     * @param pdf  o documento PDF
     * @param tema o tema atual
     */
    public void recursiveSumario(Document pdf, TemaModel tema) {
        for (TemaModel tModel : TemaController.getSubTemas(tema)) {
            try {
                Paragraph pg = new Paragraph(tModel.getNome(), new Font(Font.FontFamily.COURIER));
                pg.setAlignment(Element.ALIGN_CENTER);
                pdf.add(pg);
                recursiveSumario(pdf, tModel);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Adiciona o conteúdo ao documento PDF.
     *
     * @param pdf o documento PDF
     */
    public void addConteudo(Document pdf) {
        try {
            pdf.newPage();
            Paragraph titulo = new Paragraph(tema.getNome(), new Font(Font.FontFamily.COURIER));
            titulo.setAlignment(Element.ALIGN_CENTER);
            pdf.add(titulo);
            pdf.add(new Paragraph(" "));

            Paragraph descricao = new Paragraph("\t" + tema.getDescricao(), new Font(Font.FontFamily.COURIER));
            pdf.add(descricao);
            pdf.add(new Paragraph(" "));
            pdf.add(new Paragraph(" "));

            addArquivos(pdf, tema);
            recursiveConteudo(pdf, tema);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adiciona o conteúdo recursivamente ao documento PDF.
     *
     * @param pdf  o documento PDF
     * @param tema o tema atual
     */
    public void recursiveConteudo(Document pdf, TemaModel tema) {
        for (TemaModel tModel : TemaController.getSubTemas(tema)) {
            try {
                pdf.newPage();
                Paragraph pg = new Paragraph(tModel.getNome(), new Font(Font.FontFamily.COURIER,24,Font.BOLD));
                pg.setAlignment(Element.ALIGN_CENTER);
                pdf.add(pg);
                pdf.add(new Paragraph(" "));

                Paragraph descricao = new Paragraph("\t" + tModel.getDescricao(), new Font(Font.FontFamily.COURIER));
                pdf.add(descricao);
                pdf.add(new Paragraph(" "));
                pdf.add(new Paragraph(" "));

                addArquivos(pdf, tModel);
                recursiveConteudo(pdf, tModel);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Adiciona os arquivos ao documento PDF.
     *
     * @param pdf  o documento PDF
     * @param tema o tema atual
     */
    public void addArquivos(Document pdf, TemaModel tema) {
        for (ArquivosModel arquivos : ArquivosController.getListArquivos(tema)) {
            try {
                Anchor link = new Anchor(arquivos.getNome());
                link.setReference(arquivos.getLink());
                Font fonteLink = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.UNDERLINE);
                link.setFont(fonteLink);

                // Adiciona o link ao parágrafo
                Paragraph paragrafo = new Paragraph();
                paragrafo.setAlignment(Element.ALIGN_CENTER);
                paragrafo.add(link);
                pdf.add(paragrafo);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
    }
}
