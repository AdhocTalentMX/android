package androids.adhoctalent.com.aplicacion31;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edNum1)
    EditText num1;
    @BindView(R.id.edNum2)
    EditText num2;
    @BindView(R.id.txtResultado)
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSuma)
    public void hacerSuma()
    {
        int suma = Integer.parseInt(num1.getText().toString()) +
                Integer.parseInt(num2.getText().toString());
        resultado.setText("El resultado es " + suma);
    }
}
