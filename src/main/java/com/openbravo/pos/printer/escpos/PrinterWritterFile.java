package com.openbravo.pos.printer.escpos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrinterWritterFile extends PrinterWritter {
    private static final Logger logger = LoggerFactory.getLogger(PrinterWritterFile.class);

    private String m_sFilePrinter;
    private OutputStream m_out;

    public PrinterWritterFile(String sFilePrinter) {
        m_sFilePrinter = sFilePrinter;
        m_out = null;
    }

    @Override
    protected void internalWrite(byte[] data) {
        try {
            if (m_out == null) {
                m_out = new FileOutputStream(m_sFilePrinter);  // No poner append = true.
            }
            m_out.write(data);
        } catch (IOException e) {
            logger.error("Encountered IOException: {}", e);
        }
    }

    @Override
    protected void internalFlush() {
        try {
            if (m_out != null) {
                m_out.flush();
                m_out.close();
                m_out = null;
            }
        } catch (IOException e) {
            logger.error("Encountered IOException: {}", e);
        }
    }

    @Override
    protected void internalClose() {
        try {
            if (m_out != null) {
                m_out.flush();
                m_out.close();
                m_out = null;
            }
        } catch (IOException e) {
            logger.error("Encountered IOException: {}", e);
        }
    }
}
