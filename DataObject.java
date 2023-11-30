public class DataObject {
    private String A, B, C,D,E, F, G,H,I;
    // Constructor
    public DataObject(String A, String B, String C, String D, String E, String F, String G, String H,String I) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.E = E;
        this.F = F;
        this.G = G;
        this.H = H;
        this.I = I;

    }

    // Default Constructor
    public DataObject() {

    }

    // Getters and Setters
    public String getA() {
        return A;
    }

    public void setA(String A) {
        this.A = A;
    }

    public String getB() {
        return B;
    }

    public void setB(String B) {
        this.B = B;
    }

    public String getC() {
        return C;
    }

    public void setC(String C) {
        this.C = C;
    }

    public String getD() {
        return D;
    }

    public void setD(String D) {
        this.D = D;
    }

    public String getE() {
        return E;
    }

    public void setE(String E) {
        this.E = E;
    }

    public String getF() {
        return F;
    }

    public void setF(String F) {
        this.F = F;
    }

    public String getG() {
        return G;
    }

    public void setG(String G) {
        this.G = G;
    }

    public String getH() {
        return H;
    }

    public void setH(String H) {
        this.H = H;
    }
    public String getI() {
        return I;
    }

    public void setI(String I) {
        this.I = I;
    }
    // Other methods, to convert data
    public Object[] getDataAsArray() {
        return new Object[]{ A, B, C, D, E, F, G, H, I};
    }

    public Object[] getColumnNames() {
        return new Object[]{"A", "B", "C", "D", "E", "F", "G", "H","I"};
    }
}
