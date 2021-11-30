
package bsu.rfe.java.group10.lab3.Pekarskaya.varB8;

import javax.swing.table.AbstractTableModel;
@SuppressWarnings("serial")

public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;
    private double result;

    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public int getColumnCount() {
// В данной модели два столбца
        return 3;
    }

    public int getRowCount() {
// Вычислить количество точек между началом и концом отрезка
        return new Double(Math.ceil((to-from)/step)).intValue()+1;
    }

    public Object getValueAt(int row, int column) {
// Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
        double x = from + step * row;

        switch(column) {
            case 0: {
                return x;
            }
            case 1: {
                 result = 0.0;
                for (int i = 0; i < coefficients.length; i++){
                    result += Math.pow(x, coefficients.length - 1 - i) * coefficients[i];
            }
                return result;
            }
            case 2: {
                int res = (int) Math.floor(result);
                    return res==0;
            }

            default: {
                return 0;
            }
        }
    }

        public String getColumnName ( int col){
            switch (col) {
                case 0: {
// Название 1-го столбца
                    return "Значение X";
                }
                case 1:{
// Название 2-го столбца
                    return "Значение многочлена";
            }
                case 2:{
// Название 3-го столбца
                    return "Малое число?";
                }
                default: {
                    return " ";
                }
        }
    }

        public Class<?> getColumnClass(int column) {
// И в 1-ом и во 2-ом столбце находятся значения типа Double
            if(column==0 || column==1) {
                return Double.class;
            }
            else {
                return Boolean.class;
            }
            }

            public Double getFrom () {
                return from;
            }
            public Double getTo () {
                return to;
            }
            public Double getStep () {
                return step;
            }
}

