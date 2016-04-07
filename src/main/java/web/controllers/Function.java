package web.controllers;

public enum Function {
    SIN, COS, TG, CTG, POLYNOMIAL, EXP, LOG;

    public Function getFunc(String s) {
        switch (s) {
            case "SIN":
                return SIN;
            case "COS":
                return COS;
            case "TG":
                return TG;
            case "CTG":
                return CTG;
            case "POLYNOMIAL":
                return POLYNOMIAL;
            case "EXP":
                return EXP;
            case "LOG":
                return LOG;
            default:
                return SIN;
        }
    }
}
