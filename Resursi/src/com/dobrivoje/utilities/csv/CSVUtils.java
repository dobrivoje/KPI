/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dobrivoje.utilities.csv;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 *
 * @author root
 */
public class CSVUtils {

    private static CSVUtils instance;
    //
    private static String CSV_LokacijaFajla;
    //
    private static char CSV_Separator = ';';
    private static final char CSV_Param = '\'';
    private static int CSV_PreskakanjeLinija = 1;
    //
    private static CSVReader CVSReader;
    private static final CsvToBean CVSToBean = new CsvToBean();
    private static final ColumnPositionMappingStrategy cpms = new ColumnPositionMappingStrategy();
    //
    private static List<IColumnMapping> list;

    protected CSVUtils(String CSV_LokacijaFajla, char CSV_Separator, int CSV_PreskakanjeLinija) throws FileNotFoundException {

        init(CSV_LokacijaFajla, CSV_Separator, CSV_PreskakanjeLinija);
    }

    private static void init(String CSV_LokacijaFajla,
            char CSV_Separator,
            int CSV_PreskakanjeLinija) throws FileNotFoundException {

        CSVUtils.CSV_LokacijaFajla = CSV_LokacijaFajla;
        CSVUtils.CSV_Separator = CSV_Separator;
        CSVUtils.CSV_PreskakanjeLinija = CSV_PreskakanjeLinija;

        CVSReader = new CSVReader(
                new FileReader(CSV_LokacijaFajla),
                CSV_Separator,
                CSV_Param,
                CSV_PreskakanjeLinija);
    }

    public static CSVUtils getDafault(String CSV_LokacijaFajla) throws FileNotFoundException {
        init(CSV_LokacijaFajla, CSVUtils.CSV_Separator, CSVUtils.CSV_PreskakanjeLinija);

        return instance = (instance == null
                ? new CSVUtils(
                        CSVUtils.CSV_LokacijaFajla,
                        CSVUtils.CSV_Separator,
                        CSVUtils.CSV_PreskakanjeLinija
                )
                : instance);
    }

    //<editor-fold defaultstate="collapsed" desc="Setters">
    public static void setCSV_LokacijaFajla(String CSV_LokacijaFajla) {
        CSVUtils.CSV_LokacijaFajla = CSV_LokacijaFajla;
    }

    public static void setCSV_Separator(char CSV_Separator) {
        CSVUtils.CSV_Separator = CSV_Separator;
    }

    public static void setCSV_PreskakanjeLinija(int CSV_PreskakanjeLinija) {
        CSVUtils.CSV_PreskakanjeLinija = CSV_PreskakanjeLinija;
    }
//</editor-fold>

    public void setUpBean(IColumnMapping bean) {
        cpms.setType(bean.getClass());
        cpms.setColumnMapping(bean.getColumnNames());

        list = CVSToBean.parse(cpms, CVSReader);
    }

    public List<IColumnMapping> getList() {
        return list;
    }
}
