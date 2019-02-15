package com.example.android.practice1;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    int quantity = 2;
    TextView tvquantity;
    TextView txttotal;
    CheckBox cbcream;
    CheckBox cbchoco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void decrement (View view) {
        if (quantity == 0){
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }

    public void increment (View view) {
        if (quantity == 10){
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    public void display (int quantity){
        tvquantity = findViewById(R.id.txtQuantity);
        tvquantity.setText(String.valueOf(quantity));
    }

    public void submit (View view){
        EditText etname = findViewById(R.id.etName);
        String name = etname.getText().toString();

        cbcream = findViewById(R.id.cbCream);
        cbchoco = findViewById(R.id.cbChoccolate);

        boolean cream = cbcream.isChecked();
        boolean choco = cbchoco.isChecked();

        int total = hitung(name, cream, choco);
        String pesan = nota(name, total, cream, choco);
        alert(pesan);
    }

    private int hitung (String name, boolean cream, boolean choco){
        int price = 10;
        int total = 0;
        String message = "";

        if(cream){
            price = price + 1;
            message = message + "Whipped Cream ";
        }

        if(choco){
            price = price + 2;
            message = message + "& Chocolate";
        }

        return quantity * price;

//        txttotal = findViewById(R.id.txtTotal);
//        txttotal.setText(String.valueOf("Your total price is: $"+total));
//        alert("Your name: " + name + "\nTotal cost: $" + total + "\nToppings: " + message);
//        return total;
    }

    private String nota(String name, int price, boolean cream, boolean choco){
        String pesan = "Name : " + name;
        pesan += "\n" + "Whipped Cream : " + cream;
        pesan += "\n" + "Chocolate : " + choco;
        pesan += "\n" + "Quantity : " + quantity;
//        pesan += "\n" + "Total Cost : " + NumberFormat.getCurrencyInstance().format(price);
        pesan += "\n" + "Total Cost : " + "$" + price;
        return pesan;
    }

    private void alert (String pesan){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Information");
        alertDialog.setMessage(pesan);
        alertDialog.show();
    }
}
