package in.expo.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;


@Service
public class PdfService {

	private Logger logger = LoggerFactory.getLogger(PdfService.class);

	public ByteArrayInputStream createPdf() {

		logger.info("Create Pdf started");

		String tittle = "Welcome to my world";
		String content = "I have special content for you.please connect with us.";

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		Document document = new Document();

		PdfWriter.getInstance(document, byteArrayOutputStream);
		
		document.open();
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);
		Paragraph tittleParagraph = new Paragraph();
		tittleParagraph.setAlignment(Element.ALIGN_CENTER);
		
		document.add(tittleParagraph);
		
		Font paraFont = FontFactory.getFont(FontFactory.HELVETICA,18);
		Paragraph paragraph = new Paragraph();
		paragraph.add(new Chunk("Wow this text is added after creating"));
		document.add(paragraph);
		
		document.close();
		
		return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

	}

}
