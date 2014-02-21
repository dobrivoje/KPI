/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dobrivoje.utilities.excel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dobri
 */
public class FakturisaneUslugeBean implements IExcelable {

    private String Radnik;
    private double Sati;
    private String RadniNalog;
    private Date DatumRacuna;
    private String ProfitniCentar;

    // Nazivi kolona moraju biti identični kao navedenja polja iznad !!!
    private static final String[] kolone = new String[]{"Radnik", "Sati", "RadniNalog", "DatumRacuna", "ProfitniCentar"};

    @Override
    public List<String> getColumns() {
        return new ArrayList<>(Arrays.asList(kolone));
    }

    //<editor-fold defaultstate="collapsed" desc="Konstruktori">
    public FakturisaneUslugeBean() {
    }

    public FakturisaneUslugeBean(String Radnik, double Sati, String RadniNalog, Date DatumRacuna, String ProfitniCentar) {
        this.Radnik = Radnik;
        this.Sati = Sati;
        this.RadniNalog = RadniNalog;
        this.DatumRacuna = DatumRacuna;
        this.ProfitniCentar = ProfitniCentar;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/setters">
    public String getRadnik() {
        return Radnik;
    }

    public void setRadnik(String Radnik) {
        this.Radnik = Radnik;
    }

    public double getSati() {
        return Sati;
    }

    public void setSati(double Sati) {
        this.Sati = Sati;
    }

    public String getRadniNalog() {
        return RadniNalog;
    }

    public void setRadniNalog(String RadniNalog) {
        this.RadniNalog = RadniNalog;
    }

    public Date getDatumRacuna() {
        return DatumRacuna;
    }

    public void setDatumRacuna(Date DatumRacuna) {
        this.DatumRacuna = DatumRacuna;
    }

    public String getProfitniCentar() {
        return ProfitniCentar;
    }

    public void setProfitniCentar(String ProfitniCentar) {
        this.ProfitniCentar = ProfitniCentar;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "[" + Radnik + "]"
                + "[" + Sati + "]"
                + "[" + RadniNalog + "]"
                + "[" + DatumRacuna + "]"
                + "[" + ProfitniCentar + "]";
    }

}
