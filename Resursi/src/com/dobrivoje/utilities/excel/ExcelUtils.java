/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dobrivoje.utilities.excel;

import Exceptions.ExcelSheetException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jxl.DateCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author root
 */
public class ExcelUtils {
    
    private static ExcelUtils instance;
    private static final List<IExcelable> ExelableBeanList = new ArrayList<>();
    //
    private static int PreskociBrLinija = 1;
    //
    private static Workbook Workbook;
    private static Sheet Sheet;

    //<editor-fold defaultstate="collapsed" desc="Konstruktori i inits">
    protected ExcelUtils(File file, int PreskakanjeLinija, int RBr_Sheet_a) throws FileNotFoundException, IOException, Exception {
        ExcelUtils.Workbook = Workbook.getWorkbook(file);
        init(PreskakanjeLinija, RBr_Sheet_a);
    }
    
    private static void init(int PreskakanjeLinija, int RBr_Sheet_a) throws FileNotFoundException, IOException, Exception {
        ExcelUtils.PreskociBrLinija = PreskakanjeLinija;
        ExcelUtils.Sheet = Workbook.getSheet(RBr_Sheet_a - 1);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setters">
    public static void setExcel_PreskakanjeLinija(int PreskakanjeLinija) {
        ExcelUtils.PreskociBrLinija = PreskakanjeLinija;
    }
    
    public static void setPreskakanjeLinija(int PreskakanjeLinija) {
        ExcelUtils.PreskociBrLinija = PreskakanjeLinija;
    }
    
    public static void setSheet(int sheet) throws ExcelSheetException {
        if (sheet < 1) {
            throw new ExcelSheetException("Sheet počinje od 1 pa na dalje.");
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getDafault">
    public static ExcelUtils getDafault(File File, int PreskociLinije, int Sheet_RBr)
            throws FileNotFoundException, IOException, ExcelSheetException, Exception {
        
        if (Sheet_RBr < 1) {
            throw new ExcelSheetException("Sheet počinje od 1 pa na dajje.");
        } else {
            return (instance == null ? instance = new ExcelUtils(File, PreskociLinije, Sheet_RBr) : instance);
        }
    }
    
    public static ExcelUtils getDafault(File File)
            throws FileNotFoundException, IOException, ExcelSheetException, Exception {
        
        return (instance == null ? instance = new ExcelUtils(File, 1, 1) : instance);
    }
//</editor-fold>

    public List<IExcelable> getBeanList() {
        FakturisaneUslugeBean fuTmp;
        
        for (int vrsta = ExcelUtils.PreskociBrLinija; vrsta < ExcelUtils.Sheet.getRows(); vrsta++) {
            fuTmp = new FakturisaneUslugeBean();

            fuTmp.setRadnik(ExcelUtils.Sheet.getCell(0, vrsta).getContents());
            fuTmp.setSati(((NumberCell) ExcelUtils.Sheet.getCell(1, vrsta)).getValue());
            fuTmp.setRadniNalog(ExcelUtils.Sheet.getCell(2, vrsta).getContents());
            fuTmp.setDatumRacuna(((DateCell) ExcelUtils.Sheet.getCell(3, vrsta)).getDate());
            fuTmp.setProfitniCentar(ExcelUtils.Sheet.getCell(4, vrsta).getContents());
            
            ExelableBeanList.add(fuTmp);
        }
        // }

        return ExelableBeanList;
    }
    
    @Override
    public String toString() {
        int rb = 0;
        String tmp = null;
        
        for (IExcelable fb : getBeanList()) {
            tmp += (++rb) + ".  " + ((FakturisaneUslugeBean) fb).toString() + '\n';
        }
        
        return tmp;
    }
}
