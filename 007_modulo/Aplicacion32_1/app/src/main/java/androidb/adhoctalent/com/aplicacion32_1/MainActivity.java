package androidb.adhoctalent.com.aplicacion32_1;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editText)
    EditText txtUrl;
    @BindView(R.id.imageView)
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);



    }

    @OnClick(R.id.button)
    public void algo() {
        Glide.with(getApplicationContext())
                .load("https://goo.gl/hx35gP")
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .thumbnail(1.0f)
                .sizeMultiplier(0.8f)
                .dontAnimate()
                .into(imgView);
    }
}
