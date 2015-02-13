package com.openbravo.pos.inventory;

import com.openbravo.pos.panels.ComboItemLocal;

public class MovementReason extends ComboItemLocal {

    // public static final MovementReason NULL = new MovementReason(null, "");

    public static final MovementReason IN_PURCHASE = new MovementReason(+1, "stock.in.purchase");

    public static final MovementReason IN_REFUND = new MovementReason(+2, "stock.in.refund");

    public static final MovementReason IN_MOVEMENT = new MovementReason(+4, "stock.in.movement");

    public static final MovementReason OUT_SALE = new MovementReason(-1, "stock.out.sale");

    public static final MovementReason OUT_REFUND = new MovementReason(-2, "stock.out.refund");

    public static final MovementReason OUT_BREAK = new MovementReason(-3, "stock.out.break");

    public static final MovementReason OUT_MOVEMENT = new MovementReason(-4, "stock.out.movement");

    public static final MovementReason OUT_CROSSING = new MovementReason(1000, "stock.out.crossing");

    private MovementReason(Integer iKey, String sKeyValue) {
        super(iKey, sKeyValue);
    }

    public boolean isInput() {
        return m_iKey > 0;
    }

    public Double samesignum(Double d) {

        if (d == null || m_iKey == null) {
            return d;
        } else if ((m_iKey > 0 && d < 0.0) ||
                   (m_iKey < 0 && d > 0.0)) {
            return -d;
        } else {
            return d;
        }
    }

    public Double getPrice(Double dBuyPrice, Double dSellPrice) {

        if (this == IN_PURCHASE || this == OUT_REFUND || this == OUT_BREAK) {
            return dBuyPrice;
        } else if (this == OUT_SALE || this == IN_REFUND) {
            return dSellPrice;
        } else {
            return null;
        }
    }
}
