package com.openbravo.pos.util;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.print.*;
import javax.print.PrintService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.export.JRGraphics2DExporterParameter;
import net.sf.jasperreports.engine.util.JRGraphEnvInitializer;
/**
 * @version $Id: JRPrinterAWT.java 2123 2008-03-12 11:00:41Z teodord $
 */
public class JRPrinterAWT300 implements Printable
{


	/**
	 *
	 */
	private JasperPrint jasperPrint = null;
	private int pageOffset = 0;


	/**
	 *
	 */
	protected JRPrinterAWT300(JasperPrint jrPrint) throws JRException
	{
		JRGraphEnvInitializer.initializeGraphEnv();

		jasperPrint = jrPrint;
	}


	/**
	 *
	 */
	public static boolean printPages(
		JasperPrint jrPrint,
		int firstPageIndex,
		int lastPageIndex,
		PrintService service
		) throws JRException
	{
		JRPrinterAWT300 printer = new JRPrinterAWT300(jrPrint);
		return printer.printPages(
			firstPageIndex,
			lastPageIndex,
			service
			);
	}


	/**
	 *
	 */
	public static Image printPageToImage(
		JasperPrint jrPrint,
		int pageIndex,
		float zoom
		) throws JRException
	{
		JRPrinterAWT300 printer = new JRPrinterAWT300(jrPrint);
		return printer.printPageToImage(pageIndex, zoom);
	}


	/**
	 *
	 */
	private boolean printPages(
		int firstPageIndex,
		int lastPageIndex,
                PrintService service
		) throws JRException
	{
		boolean isOK = true;

		if (
			firstPageIndex < 0 ||
			firstPageIndex > lastPageIndex ||
			lastPageIndex >= jasperPrint.getPages().size()
			)
		{
			throw new JRException(
				"Invalid page index range : " +
				firstPageIndex + " - " +
				lastPageIndex + " of " +
				jasperPrint.getPages().size()
				);
		}

		pageOffset = firstPageIndex;

		PrinterJob printJob = PrinterJob.getPrinterJob();

		// fix for bug ID 6255588 from Sun bug database
		initPrinterJobFields(printJob);

		PageFormat pageFormat = printJob.defaultPage();
		Paper paper = pageFormat.getPaper();

		printJob.setJobName("JasperReports - " + jasperPrint.getName());

		switch (jasperPrint.getOrientationValue())
		{
			case LANDSCAPE :
			{
				pageFormat.setOrientation(PageFormat.LANDSCAPE);
				paper.setSize(jasperPrint.getPageHeight(), jasperPrint.getPageWidth());
				paper.setImageableArea(
					0,
					0,
					jasperPrint.getPageHeight(),
					jasperPrint.getPageWidth()
					);
				break;
			}
			case PORTRAIT :
			default :
			{
				pageFormat.setOrientation(PageFormat.PORTRAIT);
				paper.setSize(jasperPrint.getPageWidth(), jasperPrint.getPageHeight());
				paper.setImageableArea(
					0,
					0,
					jasperPrint.getPageWidth(),
					jasperPrint.getPageHeight()
					);
			}
		}

		pageFormat.setPaper(paper);

		Book book = new Book();
		book.append(this, pageFormat, lastPageIndex - firstPageIndex + 1);
		printJob.setPageable(book);
		try
		{
                    if (service == null) {
                        if (printJob.printDialog()) {
                            printJob.print();
                        }
                    } else {
                        printJob.setPrintService(service);
                        printJob.print();
                    }
		}
		catch (HeadlessException | PrinterException ex)
		{
			throw new JRException("Error printing report.", ex);
		}

		return isOK;
	}


	/**
	 *
	 */
    @Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException
	{
		if (Thread.currentThread().isInterrupted())
		{
			throw new PrinterException("Current thread interrupted.");
		}

		pageIndex += pageOffset;

		if ( pageIndex < 0 || pageIndex >= jasperPrint.getPages().size() )
		{
			return Printable.NO_SUCH_PAGE;
		}

		try
		{
			JRGraphics2DExporter exporter = new JRGraphics2DExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, this.jasperPrint);
			exporter.setParameter(JRGraphics2DExporterParameter.GRAPHICS_2D, graphics);
			exporter.setParameter(JRExporterParameter.PAGE_INDEX, new Integer(pageIndex));
			exporter.exportReport();
		}
		catch (JRException e)
		{
			throw new PrinterException(e.getMessage());
		}

		return Printable.PAGE_EXISTS;
	}


	/**
	 *
	 */
	private Image printPageToImage(int pageIndex, float zoom) throws JRException
	{
		Image pageImage = new BufferedImage(
			(int)(jasperPrint.getPageWidth() * zoom) + 1,
			(int)(jasperPrint.getPageHeight() * zoom) + 1,
			BufferedImage.TYPE_INT_RGB
			);

		JRGraphics2DExporter exporter = new JRGraphics2DExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, this.jasperPrint);
		exporter.setParameter(JRGraphics2DExporterParameter.GRAPHICS_2D, pageImage.getGraphics());
		exporter.setParameter(JRExporterParameter.PAGE_INDEX, new Integer(pageIndex));
		exporter.setParameter(JRGraphics2DExporterParameter.ZOOM_RATIO, new Float(zoom));
		exporter.exportReport();

		return pageImage;
	}


	/**
	 * Fix for bug ID 6255588 from Sun bug database
	 * @param job print job that the fix applies to
	 */
	public static void initPrinterJobFields(PrinterJob job)
	{
		try
		{
			job.setPrintService(job.getPrintService());
		}
		catch (PrinterException e)
		{
		}
	}

    public static long getImageSize(JasperPrint jasperPrint, float zoom)
	{
		int width = (int) (jasperPrint.getPageWidth() * zoom) + 1;
		int height = (int) (jasperPrint.getPageHeight() * zoom) + 1;
		return width * height;
	}
}
