package com.mygdx.game;

public class LocalAccount {
    // Используем шаблон "одиночка" - Singleton
    // 1) Приватный конструктор
    // 2) Приватное статичное поле данного класса
    // 3) Публичные методы для инициализации и получения доступа к переменной.
    private static LocalAccount account;
    private int xcoin = 0; //gone unused

    public enum XSkins{
        DEFAULT("sprites/skins/x/x.png"),
        TOXIC_X("sprites/skins/x/toxic.png");

        private final String path;

        XSkins(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }

    public enum OSkins {
        DEFAULT("sprites/skins/o/o.png"),
        EYES_O("sprites/skins/o/eyes.png");

        private final String path;

        OSkins(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }

    private OSkins currentOSkin = OSkins.DEFAULT;
    private XSkins currentXSkin = XSkins.DEFAULT;

    public OSkins getCurrentOSkin() {
        return currentOSkin;
    }

    public void setCurrentOSkin(OSkins currentOSkin) {
        this.currentOSkin = currentOSkin;
    }

    public XSkins getCurrentXSkin() {
        return currentXSkin;
    }

    public void setCurrentXSkin(XSkins currentXSkin) {
        this.currentXSkin = currentXSkin;
    }

    private boolean tx = false;
    private boolean eo = false;

    private int victoriesX = 0;
    private int victoriesO = 0;

    
    public int getVictoriesX() {
        return victoriesX;
    }

    public boolean getEo(){
        return eo;
    }

    public boolean getTx(){
        return tx;
    }

    public void setVictoriesX(int victoriesX) {
        this.victoriesX = victoriesX;
    }

    public int getVictoriesO() {
        return victoriesO;
    }

    public void setVictoriesO(int victoriesO) {
        this.victoriesO = victoriesO;
    }

    public static LocalAccount getAccount() {
        return account;
    }

    public static void init() {
        account = new LocalAccount();
    }

    private LocalAccount(){

    }

    public int getXcoin() {
        return xcoin;
    }

    public void getReward(){
        xcoin+=1;
        System.out.println(xcoin);
    }

    public void setXcoin(int xcoin) {
        this.xcoin = xcoin;
    }

    public String getOSkinPath(){
        return currentOSkin.getPath();
    }
    public String getXSkinPath(){
        return currentXSkin.getPath();
    }
}
