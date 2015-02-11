package com.openbravo.pos.scale;

public class ScaleFake implements Scale {

    /**
     * Creates a new instance of ScaleFake
     */
    public ScaleFake() {
    }

    /**
     *
     * @throws ScaleException
     */
    @Override
    public Double readWeight() throws ScaleException {
        return new Double(Math.random() * 2.0);
    }

}
