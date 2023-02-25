package org.example;

import java.util.Date;

public class NBP_Response {
    String table;
    String currency;
    String code;
    RatesData[] rates;

    public float getRate (int index) {
        return this.rates[index].mid;
    }

    private class RatesData {
        // Po co Intellij mi porponuje zeby ta klasa była statyczna? poczytałem w necie i dalej nie rozumiem za bardzo
        String no;
        String effectiveDate;
        float mid;

        public void setNo(String no) {
            this.no = no;
        }

        public void setEffectiveDate(String effectiveDate) {
            this.effectiveDate = effectiveDate;
        }

        public void setMid(float mid) {
            this.mid = mid;
        }
    }
}
