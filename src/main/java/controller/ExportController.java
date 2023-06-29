package controller;

import model.TemaModel;
import util.PDFExport;

/**
 * 
 * A classe ExportController é responsável pela exportação de um tema para um
 * arquivo PDF.
 */
public class ExportController {

    /**
     * 
     * Cria um arquivo PDF com base no tema fornecido.
     * 
     * @param tema O tema a ser exportado para o PDF.
     */
    public static void criarPDF(TemaModel tema) {
        PDFExport export = new PDFExport(tema);
        export.run();
    }
}
