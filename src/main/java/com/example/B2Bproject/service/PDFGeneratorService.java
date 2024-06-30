package com.example.B2Bproject.service;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;


import java.awt.*;
import java.io.IOException;

@Service

public class PDFGeneratorService {
    public void export(HttpServletResponse response) throws IOException, DocumentException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph paragraph = new Paragraph("Accept our Terms and policy ✔✔.", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Chunk chunk1 = new Chunk("Mouad Makboul", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.UNDERLINE, new Color(0, 0, 255)));
        chunk1.setAction(new PdfAction("https://github.com/mouadmakboul?tab=repositories"));

        Chunk chunk2 = new Chunk(" && ");

        Chunk chunk3 = new Chunk("Youssef Amezzane", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.UNDERLINE, new Color(0, 0, 255)));
        chunk3.setAction(new PdfAction("https://github.com/mouadmakboul?tab=repositories"));

        // Ajouter les chunks au paragraphe
        paragraph.add(chunk1);
        paragraph.add(chunk2);
        paragraph.add(chunk3);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph2 = new Paragraph();
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        paragraph2.add(new Paragraph("Terms of Use:", fontParagraph));
        paragraph2.add(new Paragraph("1. By using our application, you agree to comply with our terms and conditions."));
        paragraph2.add(new Paragraph("2. You must be at least 18 years old to use our services."));
        paragraph2.add(new Paragraph("3. You are responsible for maintaining the confidentiality of your account and password."));
        paragraph2.add(new Paragraph("4. You agree not to use our application for any illegal or unauthorized purpose."));
        paragraph2.add(new Paragraph("5. We reserve the right to terminate or suspend your account at any time for violation of these terms."));

        paragraph2.add(new Paragraph("\nPrivacy Policy:", fontParagraph));
        paragraph2.add(new Paragraph("1. We respect your privacy and are committed to protecting your personal information."));
        paragraph2.add(new Paragraph("2. We collect and use your personal information only for providing and improving our services."));
        paragraph2.add(new Paragraph("3. Your data will not be shared with third parties without your consent, except as required by law."));
        paragraph2.add(new Paragraph("4. We use cookies and similar technologies to analyze usage and improve user experience."));
        paragraph2.add(new Paragraph("5. By using our application, you consent to the collection and use of your information as outlined in this policy."));

        paragraph2.add(new Paragraph("\nPlease review our full Terms of Use and Privacy Policy for more information."));


        document.add(paragraph);
        document.add(paragraph2);
        document.close();
    }

}
