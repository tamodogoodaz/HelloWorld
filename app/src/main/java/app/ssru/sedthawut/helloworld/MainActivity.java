package app.ssru.sedthawut.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnReset;
    private Button btnCalculator;

    private EditText etX;
    private EditText etY;

    private RadioGroup rg;

    private RadioButton rbPlus;
    private RadioButton rbMinus;
    private RadioButton rbMultiply;
    private RadioButton rbDivide;

    private TextView tvDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
        initView();
    }

    private void initView() {
        rg.check(rbPlus.getId());

        tvDisplay.setText("0");

        btnReset.setOnClickListener(this);
        btnCalculator.setOnClickListener(this);

        etX.setText("");
        etY.setText("");
    }

    private void bindView(){
        etX = findViewById(R.id.etX);
        etY = findViewById(R.id.etY);

        rg = findViewById(R.id.rg);
        rbPlus = findViewById(R.id.rbPlus);
        rbMinus = findViewById(R.id.rbMinus);
        rbMultiply = findViewById(R.id.rbMultiply);
        rbDivide = findViewById(R.id.rbDivide);

        tvDisplay = findViewById(R.id.tvDisplay);

        btnReset = findViewById(R.id.btnReset);
        btnCalculator = findViewById(R.id.btnCalculator);

    }

    @Override
    public void onClick(View view) {
        if (view == btnReset)
            initView();
        else if (view == btnCalculator)
            calculator();

    }

    private void calculator() {
        int id = rg.getCheckedRadioButtonId();

        if (id == rbPlus.getId()) {
            plus();
        } else if (id == rbMinus.getId()) {
            minus();
        } else if (id == rbMultiply.getId()) {
            multiply();
        } else if (id == rbDivide.getId()) {
            divide();
        }
    }

    private void plus() {
        int x = getValueX();
        int y = getValueY();

        String display = String.valueOf(x + y);
        tvDisplay.setText(display);
    }
    private int getValueX() {
        if (etX.getText() != null
                && !etX.getText().toString().isEmpty())
            return Integer.parseInt(etX.getText().toString());
        return 0;
    }
    private int getValueY() {
        if (etY.getText() != null
                && !etY.getText().toString().isEmpty())
            return Integer.parseInt(etY.getText().toString());
        return 0;
    }



    private void minus() {
        int x = getValueX();
        int y = getValueY();

        String display = String.valueOf(x - y);
        tvDisplay.setText(display);

    }

    private void multiply() {
        int x = getValueX();
        int y = getValueY();

        String display = String.valueOf(x * y);
        tvDisplay.setText(display);

    }

    private void divide() {
        int x = getValueX();
        int y = getValueY();

        if(y != 0) {

            String display = String.valueOf(x / y);
            tvDisplay.setText(display);

        }else {
            tvDisplay.setText("Infinity");
        }
    }
}
