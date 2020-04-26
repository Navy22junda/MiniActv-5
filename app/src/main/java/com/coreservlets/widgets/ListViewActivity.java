package com.coreservlets.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListViewActivity extends Activity {

    private String mPlantillaMensajeItemSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        mPlantillaMensajeItemSelected = getString(R.string.plantilla_mensaje_listview);


        ListView listView = (ListView) findViewById(R.id.listview);
        //Sense afegir adaptador fer direactament ->listView.setOnItemClickListener(new ListViewInfo());

        List<String> currentAndroidVendors = getCurrentAndroidVendors();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, currentAndroidVendors);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new ListViewInfo());


    }

    private List<String> getCurrentAndroidVendors() {

        String[] vendorArray = { "Acer", "Dell", "HTC", "Huawei", "Kyocera",
                "LG", "Motorola", "Nexus", "Samsung", "Sony Ericsson", "T-Mobile", "Neptune"};
        List<String> vendorList = Arrays.asList(vendorArray);
        // Per a que la ordenació vagi variant
        Collections.shuffle(vendorList);
        return(vendorList);
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    private class ListViewInfo implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Agafo el text del item que ha estat clica't del ListView
            String selection = parent.getItemAtPosition(position).toString();
            String missatge = String.format(mPlantillaMensajeItemSelected, selection);
            showToast(missatge);
        }
    }

}
