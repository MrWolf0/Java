package com.bill;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.IOException;

public class Helper {

    // Constants for table and page layout
    private static final int START_X = 50; // Starting X position for the table
    private static final int START_Y = 700; // Starting Y position for the table (near top of the page)
    private static final int CELL_WIDTH = 50; // Width of each cell
    private static final int CELL_HEIGHT = 30; // Height of each cell
    private static final int NUMBER_OF_ROWS = 5; // Number of rows in the table
    private static final int NUMBER_OF_COLUMNS = 10; // Number of columns in the table

    public Helper() {
        // Call the method to create and save the document
        createDocument();
    }

    /**
     * This method creates the PDF document, adds a page, draws the table, and saves the document.
     */
    private void createDocument() {
        // Create a new PDF document
        try (PDDocument document = new PDDocument()) {
            // Add a page to the document
            PDPage page = new PDPage();
            document.addPage(page);

            // Create a content stream to draw on the page
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                drawTable(contentStream);
            }

            // Save the document to a file
            document.save("E:/App/subscriber_bill.pdf");
            System.out.println("PDF created successfully!");
        } catch (IOException e) {
            System.err.println("Error while creating PDF: " + e.getMessage());
        }
    }

    /**
     * This method draws a table on the given content stream.
     * @param contentStream The PDPageContentStream used for drawing on the page.
     * @throws IOException If there is an error while drawing the table.
     */
    private void drawTable(PDPageContentStream contentStream) throws IOException {
        // Set initial positions for the table
        int currentX = START_X;
        int currentY = START_Y;

        // Loop through rows
        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            // Loop through columns in each row
            for (int col = 0; col < NUMBER_OF_COLUMNS; col++) {
                /*
                 * Draw the cell rectangle for each row. We move the X-coordinate by CELL_WIDTH (50px) for each cell in the row.
                 * After completing a row (i.e., after drawing all columns in that row), we reset the X-coordinate to the starting position.
                 *
                 * We then move the Y-coordinate downward by subtracting CELL_HEIGHT (30px) from it.
                 * This shifts the position of the next row downward by 30px, while maintaining the height of each row at 30px.
                 *
                 * In other words, the height of each row remains constant (30px), but the new row will be positioned lower on the page by 30px.
                 */

                contentStream.addRect(currentX, currentY, CELL_WIDTH, -CELL_HEIGHT);
                /*
                 * Move to the next column.
                 * This line ensures that the next rectangle (cell) is drawn to the right of the previous one,
                 * forming the columns of the table. We achieve this by increasing the X-coordinate (currentX) by CELL_WIDTH.
                 */
                currentX += CELL_WIDTH;
            }

            /*
             * Move to the next row by resetting the X-coordinate (currentX) to START_X and adjusting the Y-coordinate (currentY).
             * This ensures that the new row starts on the left side of the table (at START_X),
             * and the Y-coordinate is decreased by CELL_HEIGHT, moving the row down by 30px.
             */
            currentX = START_X;
            currentY -= CELL_HEIGHT;

        }

        /* Apply the stroke to make the rectangles visible*/
        contentStream.stroke();
    }
}
