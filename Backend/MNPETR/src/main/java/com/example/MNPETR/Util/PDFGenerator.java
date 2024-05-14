package com.example.MNPETR.Util;

import com.example.MNPETR.Model.OrdreDeTravail;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class PDFGenerator {

    public void generatePDF(List<OrdreDeTravail> ordresDeTravail) {
        if (ordresDeTravail == null || ordresDeTravail.isEmpty()) {
            System.out.println("No data to generate PDF.");
            return;
        }

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 12);
                contentStream.newLineAtOffset(100, 700);

                // Loop through each OrdreDeTravail and add its information to the PDF
                for (OrdreDeTravail ordreDeTravail : ordresDeTravail) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String dateOT = dateFormat.format(ordreDeTravail.getDate_OT());

                    String content = "ID_OT: " + ordreDeTravail.getID_OT() +
                            ", Tot_Horaire: " + ordreDeTravail.getTot_Horaire() +
                            ", Duree: " + ordreDeTravail.getDuree() +
                            ", Date_OT: " + dateOT +
                            ", Description_Panne: " + ordreDeTravail.getDescription_Panne() +
                            ", Type_Otz: " + ordreDeTravail.getType_Otz() +
                            ", status: " + ordreDeTravail.getStatusOT();

                    contentStream.showText(content);
                    contentStream.newLine();
                }

                contentStream.endText();
            }

            document.save("output.pdf");
            System.out.println("PDF generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error generating PDF: " + e.getMessage());
        }
    }
}
