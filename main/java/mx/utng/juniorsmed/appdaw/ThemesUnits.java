package mx.utng.juniorsmed.appdaw;

import java.io.Serializable;

/**
 * Created by Alexa on 05/07/2018.
 */

public class ThemesUnits implements Serializable {
    private String nameTheme;
    private String infoTheme;
    private String tileTheme;
    private String descriptionTheme;
    private String descriptionThemeTwo;
    private String descripionThemeThree;
    private int imageThema;
    private int imageDetail;
    private int imageFirst;
    private int imageSecond;
    private int imageThird;

    public ThemesUnits() {
    }

    public ThemesUnits(String nameTheme, String infoTheme, String tileTheme, String descriptionTheme, String descriptionThemeTwo, String descripionThemeThree, int imageThema, int imageDetail, int imageFirst, int imageSecond, int imageThird) {
        this.nameTheme = nameTheme;
        this.infoTheme = infoTheme;
        this.tileTheme = tileTheme;
        this.descriptionTheme = descriptionTheme;
        this.descriptionThemeTwo = descriptionThemeTwo;
        this.descripionThemeThree = descripionThemeThree;
        this.imageThema = imageThema;
        this.imageDetail = imageDetail;
        this.imageFirst = imageFirst;
        this.imageSecond = imageSecond;
        this.imageThird = imageThird;
    }

    public String getNameTheme() {
        return nameTheme;
    }

    public void setNameTheme(String nameTheme) {
        this.nameTheme = nameTheme;
    }

    public String getInfoTheme() {
        return infoTheme;
    }

    public void setInfoTheme(String infoTheme) {
        this.infoTheme = infoTheme;
    }

    public String getDescriptionTheme() {
        return descriptionTheme;
    }

    public void setDescriptionTheme(String descriptionTheme) {
        this.descriptionTheme = descriptionTheme;
    }

    public int getImageThema() {
        return imageThema;
    }

    public void setImageThema(int imageThema) {
        this.imageThema = imageThema;
    }

    public int getImageDetail() {
        return imageDetail;
    }

    public void setImageDetail(int imageDetail) {
        this.imageDetail = imageDetail;
    }

    public String getTileTheme() {
        return tileTheme;
    }

    public void setTileTheme(String tileTheme) {
        this.tileTheme = tileTheme;
    }

    public String getDescriptionThemeTwo() {
        return descriptionThemeTwo;
    }

    public void setDescriptionThemeTwo(String descriptionThemeTwo) {
        this.descriptionThemeTwo = descriptionThemeTwo;
    }

    public String getDescripionThemeThree() {
        return descripionThemeThree;
    }

    public void setDescripionThemeThree(String descripionThemeThree) {
        this.descripionThemeThree = descripionThemeThree;
    }

    public int getImageFirst() {
        return imageFirst;
    }

    public void setImageFirst(int imageFirst) {
        this.imageFirst = imageFirst;
    }

    public int getImageSecond() {
        return imageSecond;
    }

    public void setImageSecond(int imageSecond) {
        this.imageSecond = imageSecond;
    }

    public int getImageThird() {
        return imageThird;
    }

    public void setImageThird(int imageThird) {
        this.imageThird = imageThird;
    }
}
