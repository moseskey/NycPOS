package com.openbravo.pos.scale;

public class ScaleFake implements Scale {

    public ScaleFake() {
    }

    @Override
    public Double readWeight() throws ScaleException {
        return new Double(Math.random() * 2.0);
    }

}
