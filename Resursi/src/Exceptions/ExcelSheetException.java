/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author dobri
 */
public class ExcelSheetException extends Exception {

    public ExcelSheetException() {
        super();
    }

    public ExcelSheetException(String Poruka) {
        super(Poruka);
    }
}
