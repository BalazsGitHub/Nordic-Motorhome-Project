package teletearbies.Invoice;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;
/*import com.dev.springboot.model.Booking;*/
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import teletearbies.entity.Booking;

public class InvoicePdfExport /*extends AbstractPdfView*/ {
/*
    @Override
    protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request)
    {
        Font headerFont = new Font(Font.TIMES_ROMAN, 20, Font.BOLD, Color.magenta);
        HeaderFooter header = new HeaderFooter(new Phrase("All Invoices PDF View", headerFont), false);
        header.setAlignment(Element.ALIGN_CENTER);
        document.setHeader(header);

        Font dateFont = new Font(Font.HELVETICA, 12, Font.NORMAL, Color.BLUE);

        HeaderFooter footer = new HeaderFooter(new Phrase("PDF Export Executed On : "+new Date(), dateFont), true);
        footer.setAlignment(Element.ALIGN_CENTER);
        document.setFooter(footer);
    }

    @Override
    protected void buildPdfDocument(
            Map<String, Object> model,
            Document document,
            PdfWriter writer,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception
    {

        //download PDF with a given filename
        response.addHeader("Content-Disposition", "attachment;filename=Invoices.pdf");

        //read data from controller
        List<Booking> list = (List<Booking>) model.get("list");

        //create element
        Font titleFont = new Font(Font.TIMES_ROMAN, 24, Font.BOLD, Color.blue);
        Paragraph title = new Paragraph("ALL INVOICES DATA", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingBefore(20.0f);
        title.setSpacingAfter(25.0f);
        //add to document
        document.add(title);

        Font tableHead = new Font(Font.TIMES_ROMAN, 12, Font.BOLD, Color.blue);
        PdfPTable table = new PdfPTable(4);// no.of columns
        table.addCell(new Phrase("START DATE",tableHead));
        table.addCell(new Phrase("END DATE",tableHead));
        table.addCell(new Phrase("PICK UP POINT",tableHead));
        table.addCell(new Phrase("DROP OFF POINT",tableHead));
        table.addCell(new Phrase("CUSTOMER FULLNAME",tableHead));
        table.addCell(new Phrase("PHONE NUMBER",tableHead));
        table.addCell(new Phrase("ADDRESS",tableHead));
        table.addCell(new Phrase("DRIVERS NUMBER",tableHead));


        for(Booking invoice : list ) {
            table.addCell(invoice.getStartDate());
            table.addCell(invoice.getEndDate());
            table.addCell(invoice.getPickUpPoint());
            table.addCell(invoice.getDropOffPoint());
            table.addCell(invoice.getFullName());
            table.addCell(invoice.getPhoneNumber());
            table.addCell(invoice.getAddress());
            table.addCell(invoice.getDriversNumber());
            table.addCell(invoice.getCardNumber());
        }
        //add table data to document
        document.add(table);
    */



}
