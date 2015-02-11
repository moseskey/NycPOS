package com.openbravo.pos.printer;

public abstract class BaseAnimator implements DisplayAnimator {

    protected String baseLine1;

    protected String baseLine2;

    protected String currentLine1;

    protected String currentLine2;

    public BaseAnimator() {
        baseLine1 = null;
        baseLine2 = null;
    }

    public BaseAnimator(String line1, String line2) {
        baseLine1 = line1;
        baseLine2 = line2;
    }

    @Override
    public String getLine1() {
        return currentLine1;
    }

    @Override
    public String getLine2() {
        return currentLine2;
    }
}
