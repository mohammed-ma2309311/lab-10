package model;

/**
 * The uploaded document. Lab 10 refinement: the cost depends on the number of pages.
 */
public final class Document {
    private final String fileName;
    private final int pages;

    public Document(String fileName, int pages) {
        if (pages < 1) {
            throw new IllegalArgumentException("A document has at least one page");
        }
        this.fileName = fileName;
        this.pages = pages;
    }

    public String getFileName() {
        return fileName;
    }

    public int getPages() {
        return pages;
    }
}
