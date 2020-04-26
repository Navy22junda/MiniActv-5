package com.coreservlets.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class GridViewActivity extends Activity {

    private String mPlantillaMensajeItemSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);

        mPlantillaMensajeItemSelected = getString(R.string.plantilla_mensaje_gridview);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        //Sense afegir adaptador no es mostraria -> gridView.setOnItemClickListener(new GridViewInfo());

        //Array amb la data ha ser mostrada
        List<String> entries = Arrays.asList("Acer", "Dell", "HTC", "Huawei", "Kyocera",
                "LG", "Motorola", "Nexus", "Samsung", "Sony Ericsson", "T-Mobile", "Neptune");

        //Creacio instancia per el adaptador
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, entries);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        gridView.setAdapter(arrayAdapter);
        gridView.setOnItemClickListener(new GridViewInfo());


    }

    private void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    private class GridViewInfo implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String selection = parent.getItemAtPosition(position).toString();
            String missatge = String.format(mPlantillaMensajeItemSelected, selection);
            showToast(missatge);
        }
    }
}
