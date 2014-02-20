/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dobrivoje.utilities.excel;

import java.util.Date;

/**
 *
 * @author dobri
 */
public class FakturisaneUslugeBean implements IColumnMapping {

    private String Radnik;
    private double Sati;
    private String RadniNalog;
    private Date DatumRacuna;
    private String ProfitniCentar;

    @Override
    public String[] getColumnNames() {
        return new String[]{"Radnik", "Sati", "RadniNalog", "DatumRacuna", "ProfitniCentar"};
    }

    public FakturisaneUslugeBean() {
    }

    public FakturisaneUslugeBean(String Radnik, double Sati, String RadniNalog, Date DatumRacuna, String ProfitniCentar) {
        this.Radnik = Radnik;
        this.Sati = Sati;
        this.RadniNalog = RadniNalog;
        this.DatumRacuna = DatumRacuna;
        this.ProfitniCentar = ProfitniCentar;
    }

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

    @Override
    public String toString() {
        return "[" + Radnik + "]"
                + "[" + Sati + "]"
                + "[" + RadniNalog + "]"
                + "[" + DatumRacuna + "]"
                + "[" + ProfitniCentar + "]";
    }

}
