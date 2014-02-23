/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dobrivoje.utilities.csv;

import ERS.Beans.FakturisaneUsluge.FUCSVBean;
import Exceptions.ExcelSheetException;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author root
 */
public class CSVUtils extends CSVSingletonUtils<FUCSVBean> {

    private static CSVUtils instance;

    private CSVUtils(File file, char Separator, int PreskociBrLinija) throws FileNotFoundException, InstantiationException, IllegalAccessException {
        super(file, Separator, PreskociBrLinija);
        super.forClass(FUCSVBean.class);
    }

    public static CSVUtils getDafault(File File, char Separator, int PreskociLinije) throws ExcelSheetException, Exception {
        return (instance == null ? instance = new CSVUtils(File, Separator, PreskociLinije) : instance);
    }

    public static CSVUtils getDafault(File File) throws ExcelSheetException, Exception {
        return (instance == null ? instance = new CSVUtils(File, ';', 1) : instance);
    }
}
