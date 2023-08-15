package com.netcracker.edu.miloserdov.extendedclass;

public class ExtendedClass {

    private byte b;
    private int i;
    private double d;
    private String s;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        ExtendedClass toCompare = (ExtendedClass) o;
        return (toCompare.getB() == this.b &&
                toCompare.getI() == this.i &&
                toCompare.getD() == this.d &&
                toCompare.getS().equals(this.s));
    }

    @Override
    public int hashCode() {
        int res = s == null ? 0 : s.hashCode();
        res += 29 * res + Double.hashCode(d);
        res += 31 * res + i;
        return res;
    }

    @Override
    public String toString() {
        return "ExtendedClass{"
                + "b=" + b
                + ", i=" + i
                + ", d=" + d
                + ", s='" + s + '\''
                + '}';
    }


    public byte getB() {
        return b;
    }

    public void setB(byte b) {
        this.b = b;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
