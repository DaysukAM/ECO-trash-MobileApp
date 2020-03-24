package fr.AnthonyM.ECOTrash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SellActivity extends AppCompatActivity {

    ImageView imageMain;
    TextView textName, textDesc;

    String data1, data2;
    int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        imageMain = findViewById(R.id.imageMain);
        textName = findViewById(R.id.textName);
        textDesc = findViewById(R.id.textDesc);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("images") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")){

            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            images = getIntent().getIntExtra("images", 1);

        }else{
            Toast.makeText(this, "no data", Toast.LENGTH_LONG).show();
        }
    }

    private void setData(){
        textName.setText(data1);
        textDesc.setText(data2);
        imageMain.setImageResource(images);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(otherActivity);
        finish();
    }
}
