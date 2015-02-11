package com.openbravo.format;

import java.text.ParseException;

public abstract class FormatsConstrain {

//    public final static FormatsConstrain NOTNULL = new FormatsConstrainNOTNULL();

    /**
     *
     * @throws ParseException
     */

    public abstract Object check(Object value) throws ParseException;

    public FormatsConstrain() {
    }

//    private static class FormatsConstrainNOTNULL extends FormatsConstrain {
//        public Object check(Object value) throws ParseException{
//            if (value == null) {
//                throw new ParseException(LocalRes.getIntString("exception.notnull"), 0);
//            } else {
//                return value;
//            }
//        }
//    }
}
