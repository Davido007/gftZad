/**
 * Created by dplichta on 2015-08-04.
 */

import java.util.Date;

public class Transaction {
    Date date;
    float amount;

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Transaction(Date date, float amount) {
        this.date = date;
        this.amount = amount;
    }

    public float getAmount() {
        return this.amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
