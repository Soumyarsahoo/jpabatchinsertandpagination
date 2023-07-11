package com.abc.entity;

import com.opencsv.bean.CsvBindByPosition;

import javax.persistence.*;

@Entity
public class CsvEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
    @SequenceGenerator(name = "seqGen", sequenceName = "seq", initialValue = 1,allocationSize = 1)
    private int id;

    @CsvBindByPosition(position = 0)
    private String field1;

    @CsvBindByPosition(position = 1)
    private String field2;

    @CsvBindByPosition(position = 2)
    private String field3;

    @CsvBindByPosition(position = 3)
    private String field4;

    @CsvBindByPosition(position = 4)
    private String field5;

    @CsvBindByPosition(position = 5)
    private String field6;

    @CsvBindByPosition(position = 6)
    private String field7;

    @CsvBindByPosition(position = 7)
    private String field8;

    @CsvBindByPosition(position = 8)
    private String field9;

    @CsvBindByPosition(position = 9)
    private String field10;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    public String getField7() {
        return field7;
    }

    public void setField7(String field7) {
        this.field7 = field7;
    }

    public String getField8() {
        return field8;
    }

    public void setField8(String field8) {
        this.field8 = field8;
    }

    public String getField9() {
        return field9;
    }

    public void setField9(String field9) {
        this.field9 = field9;
    }

    public String getField10() {
        return field10;
    }

    public void setField10(String field10) {
        this.field10 = field10;
    }

    @Override
    public String toString() {
        return "CsvEntity{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                ", field6='" + field6 + '\'' +
                ", field7='" + field7 + '\'' +
                ", field8='" + field8 + '\'' +
                ", field9='" + field9 + '\'' +
                ", field10='" + field10 + '\'' +
                '}';
    }
}