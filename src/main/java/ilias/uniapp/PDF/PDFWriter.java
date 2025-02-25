package ilias.uniapp.PDF;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ilias.uniapp.db.University;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PDFWriter {


    //Δημιουργεί τον πίνακα με τα στατιστικά των πανεπιστημίων
    private static void addTableHeader(PdfPTable table, Font font) {

        PdfPCell header = new PdfPCell();
        Chunk chunk = new Chunk("Πανεπιστήμιο", font);
        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
        header.setBorderWidth(2);
        header.setPhrase(new Phrase(chunk));
        table.addCell(header);

        header = new PdfPCell();
        chunk = new Chunk("Προβολές", font);
        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
        header.setBorderWidth(2);
        header.setPhrase(new Phrase(chunk));
        table.addCell(header);
    }

    //Δημιουργεί το PDF αρχείο με τα στατιστικά των πανεπιστημίων
    public static boolean createPDFFile(List<University> universitiesViews, String path) {
        Document document = new Document();
        try {
            if (!path.toLowerCase().endsWith(".pdf")) {
                path += ".pdf";
            }
            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            BaseFont bf = BaseFont.createFont("Aver-opKo.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(bf, 16);

            PdfPTable table = new PdfPTable(2);
            addTableHeader(table, font);

            for (University university : universitiesViews) {
                table.addCell(university.getName());
                table.addCell(String.valueOf(university.getUniversityviews()));
            }

            document.add(new Paragraph(new Chunk("Στατιστικά πανεπιστημίων", font)));
            document.add(new Paragraph(" "));
            document.add(table);
            document.close();
            return true;
        } catch (DocumentException | IOException e) {
            e.printStackTrace();  // Εκτυπώνει το error για debugging
            return false;
        }
    }
}
