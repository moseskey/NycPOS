package com.openbravo.pos.printer.escpos;

// import javax.comm.*; // Java comm library
import com.openbravo.pos.printer.TicketPrinterException;
import gnu.io.*;
import java.io.IOException;
import java.io.OutputStream;

public class PrinterWritterRXTX extends PrinterWritter /* implements SerialPortEventListener */ {

    private CommPortIdentifier m_PortIdPrinter;
    private CommPort m_CommPortPrinter;

    private String m_sPortPrinter;
    private OutputStream m_out;

    /**
     * Creates a new instance of PrinterWritterComm
     * @throws com.openbravo.pos.printer.TicketPrinterException
     */
    public PrinterWritterRXTX(String sPortPrinter) throws TicketPrinterException {
        m_sPortPrinter = sPortPrinter;
        m_out = null;
    }

    @Override
    protected void internalWrite(byte[] data) {
        try {
            if (m_out == null) {
                m_PortIdPrinter = CommPortIdentifier.getPortIdentifier(m_sPortPrinter); // Tomamos el puerto
                m_CommPortPrinter = m_PortIdPrinter.open("PORTID", 2000); // Abrimos el puerto

                m_out = m_CommPortPrinter.getOutputStream(); // Tomamos el chorro de escritura

                if (m_PortIdPrinter.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                    ((SerialPort)m_CommPortPrinter).setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE); // Configuramos el puerto
                    ((SerialPort)m_CommPortPrinter).setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN);  // this line prevents the printer tmu220 to stop printing after +-18 lines printed
                    // this line prevents the printer tmu220 to stop printing after +-18 lines printed. Bug 8324
                    // But if added a regression error appears. Bug 9417, Better to keep it commented.
                    // ((SerialPort)m_CommPortPrinter).setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN);
    // Not needed to set parallel properties
    //                } else if (m_PortIdPrinter.getPortType() == CommPortIdentifier.PORT_PARALLEL) {
    //                    ((ParallelPort)m_CommPortPrinter).setMode(1);

                }
            }
            m_out.write(data);
// JG 16 May 12 use multicatch
        } catch (NoSuchPortException | PortInUseException | UnsupportedCommOperationException | IOException e) {
            System.err.println(e);
        }
    }

    @Override
    protected void internalFlush() {
        try {
            if (m_out != null) {
                m_out.flush();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Override
    protected void internalClose() {
        try {
            if (m_out != null) {
                m_out.flush();
                m_out.close();
                m_out = null;
                m_CommPortPrinter = null;
                m_PortIdPrinter = null;
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
