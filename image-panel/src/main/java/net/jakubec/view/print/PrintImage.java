/*
 * Copyright 2018 Michael Jakubec
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.jakubec.view.print;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSize;

public class PrintImage implements Printable {
	Image image;

	public PrintImage(final Image img) {
		image = img;

		PrinterJob pj = PrinterJob.getPrinterJob();
		PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
		aset.add(MediaSize.ISO.A4);

		PageFormat pf = pj.pageDialog(aset);
		pj.setPrintable(this, pf);
		boolean ok = pj.printDialog(aset);
	}

	@Override
	public int print(final Graphics g, final PageFormat pf, final int page) throws PrinterException {
		Graphics2D g2d = (Graphics2D) g;
		if (page > 0) return NO_SUCH_PAGE;

		g2d.translate(pf.getImageableX(), pf.getImageableY());
		return PAGE_EXISTS;
	}
}
