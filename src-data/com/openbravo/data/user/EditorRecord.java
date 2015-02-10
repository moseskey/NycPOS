//    uniCenta oPOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2014 uniCenta & previous Openbravo POS works
//    http://www.unicenta.com
//
//    This file is part of uniCenta oPOS
//
//    uniCenta oPOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   uniCenta oPOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.data.user;

import java.awt.Component;

/**
 *
 * @author JG uniCenta
 */
public interface EditorRecord extends EditorCreator {

    /**
     *
     */
    public void writeValueEOF();

    /**
     *
     */
    public void writeValueInsert();

    /**
     *
     * @param value
     */
    public void writeValueEdit(Object value); // not null por definicion.

    /**
     *
     * @param value
     */
    public void writeValueDelete(Object value); // not null por definicion.

    /**
     *
     */
    public void refresh();

    /**
     *
     * @return
     */
    public Component getComponent();
}
