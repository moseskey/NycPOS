package com.openbravo.pos.scanpal2;

public interface DeviceScanner {

    public void connectDevice() throws DeviceScannerException;

    public void disconnectDevice();

    public void startDownloadProduct() throws DeviceScannerException;

    public ProductDownloaded recieveProduct() throws DeviceScannerException;

    public void startUploadProduct() throws DeviceScannerException;

    public void sendProduct(String sName, String sCode, Double dPrice) throws DeviceScannerException;

    public void stopUploadProduct() throws DeviceScannerException;
}
