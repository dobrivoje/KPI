/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dobrivoje.utilities.excel;

import Exceptions.ExcelSheetException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import jxl.DateCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author root
 */
public class ExcelUtils {

    private static ExcelUtils instance;
    //
    private static String Fajl_Lokacija;
    private static int PreskakanjeLinija = 1;
    private static int RBr_Sheet_a = 0; // Prvi sheet počinje od nule.
    //
    private static Workbook Workbook;
    private static Sheet Sheet;
    //
    private static List<FakturisaneUslugeBean> BeanList;

    protected ExcelUtils(String Fajl_Lokacija, int PreskakanjeLinija, int RBr_Sheet_a) throws FileNotFoundException, IOException, Exception {
        init(Fajl_Lokacija, PreskakanjeLinija, RBr_Sheet_a);
    }

    protected ExcelUtils(File file, int PreskakanjeLinija, int RBr_Sheet_a) throws FileNotFoundException, IOException, Exception {
        init(file.getAbsolutePath(), PreskakanjeLinija, RBr_Sheet_a);
    }

    private static void init(String Fajl_Lokacija, int PreskakanjeLinija, int RBr_Sheet_a) throws FileNotFoundException, IOException, Exception {
        ExcelUtils.Fajl_Lokacija = Fajl_Lokacija;
        ExcelUtils.PreskakanjeLinija = PreskakanjeLinija;
        //
        ExcelUtils.Workbook = Workbook.getWorkbook(new File(ExcelUtils.Fajl_Lokacija));
        ExcelUtils.Sheet = Workbook.getSheet(RBr_Sheet_a - 1);
        //
        instance = new ExcelUtils(Fajl_Lokacija, PreskakanjeLinija, RBr_Sheet_a);
    }

    public static ExcelUtils getDafault(String LokacijaFajla, int PreskakanjeLinija, int RBr_Sheet_a) throws FileNotFoundException, IOException, ExcelSheetException, Exception {
        if (RBr_Sheet_a < 1) {
            throw new ExcelSheetException("Sheet počinje od 1 pa na dajje.");
        } else {
            init(LokacijaFajla, PreskakanjeLinija, RBr_Sheet_a);

            return instance = (instance == null
                    ? new ExcelUtils(
                            ExcelUtils.Fajl_Lokacija,
                            ExcelUtils.PreskakanjeLinija,
                            ExcelUtils.RBr_Sheet_a)
                    : instance);
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Setters">
    public static void setExcel_LokacijaFajla(String LokacijaFajla) {
        ExcelUtils.Fajl_Lokacija = LokacijaFajla;
    }

    public static void setExcel_PreskakanjeLinija(int PreskakanjeLinija) {
        ExcelUtils.PreskakanjeLinija = PreskakanjeLinija;
    }

    public static void setPreskakanjeLinija(int PreskakanjeLinija) {
        ExcelUtils.PreskakanjeLinija = PreskakanjeLinija;
    }

    public static void setSheet(int sheet) throws ExcelSheetException {
        if (sheet < 1) {
            throw new ExcelSheetException("Sheet počinje od 1 pa na dalje.");
        } else {
            ExcelUtils.RBr_Sheet_a = sheet - 1;
        }
    }

    //</editor-fold>
    public List<FakturisaneUslugeBean> getBeanList() {
        FakturisaneUslugeBean fuTmp;

        for (int vrsta = ExcelUtils.PreskakanjeLinija; vrsta < ExcelUtils.Sheet.getRows(); vrsta++) {
            fuTmp = new FakturisaneUslugeBean();

            fuTmp.setRadnik(ExcelUtils.Sheet.getCell(0, vrsta).getContents());
            fuTmp.setSati(((NumberCell) ExcelUtils.Sheet.getCell(1, vrsta)).getValue());
            fuTmp.setRadniNalog(ExcelUtils.Sheet.getCell(2, vrsta).getContents());
            fuTmp.setDatumRacuna(((DateCell) ExcelUtils.Sheet.getCell(3, vrsta)).getDate());
            fuTmp.setProfitniCentar(ExcelUtils.Sheet.getCell(4, vrsta).getContents());

            BeanList.add(fuTmp);
        }

        return BeanList;
    }

    @Override
    public String toString() {
        int rb = 0;
        String tmp = null;

        for (FakturisaneUslugeBean fb : BeanList) {
            tmp = (++rb) + ".  " + fb.toString();
        }

        return tmp;
    }

}
