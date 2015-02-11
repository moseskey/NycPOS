package com.openbravo.pos.printer;

public class ScrollAnimator extends BaseAnimator {

    private int msglength;

    public ScrollAnimator(String line1, String line2) {
        msglength = Math.max(line1.length(), line2.length());
        baseLine1 = DeviceTicket.alignLeft(line1, msglength);
        baseLine2 = DeviceTicket.alignLeft(line2, msglength);
    }

    @Override
    public void setTiming(int i) {
        int j = (i / 2) % (msglength + 20);
        if (j < 20) {
            currentLine1 = DeviceTicket.alignLeft(DeviceTicket.getWhiteString(20 - j) + baseLine1, 20);
            currentLine2 = DeviceTicket.alignLeft(DeviceTicket.getWhiteString(20 - j) + baseLine2, 20);
        } else {
            currentLine1 = DeviceTicket.alignLeft(baseLine1.substring(j - 20), 20);
            currentLine2 = DeviceTicket.alignLeft(baseLine2.substring(j - 20), 20);
        }
    }
}
